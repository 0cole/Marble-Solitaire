package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * The class that implements the Controller interface.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable myInput;
  private boolean shouldGameContinue;

  /**
   * The constructor for MarbleSolitaireControllerImpl.
   *
   * @param model the game being played
   * @param view  the visualization of the game
   * @param input the game player's input
   * @throws IllegalArgumentException if model, object, or input is null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable input) throws IllegalArgumentException {

    // exception if any param is null
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("One or more of the "
              + "parameters for the constructor is null");
    }

    this.model = model;
    this.view = view;
    this.myInput = input;
    // always true unless input is "Q" or "q"
    this.shouldGameContinue = true;
  }

  @Override
  public void playGame() throws IllegalStateException {
    Scanner scanner = new Scanner(myInput);

    // prints the welcome message
    this.gameStart();

    try {
      // while the game is not over
      while (!(model.isGameOver())) {

        // play the actual game
        this.scannerHelper(scanner);

        // when input is "Q" or "q", end the process
        if (!this.shouldGameContinue) {
          return;
        }
      }
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("the controller is unable to successfully read"
              + "input or transmit output");
    }
  }

  /**
   * Interacts with each element in the scanner. Creates a list of valid integers and then creates
   * a move based on it if all four integers are valid and the game is not over.
   * If one of the inputs is a "q" or "Q", the game ends and the gameQuit method is called.
   * @param scanner the inputs from playGame
   */
  private void scannerHelper(Scanner scanner) {
    List<Integer> inputTotal = new ArrayList<>();

    // if input is not 4 integers yet
    while (inputTotal.size() < 4) {
      String input = scanner.next();
      // make sure values in input are valid
      try {
        int value = Integer.parseInt(input);
        // checks if the int is greater than zero
        if (value < 0) {
          this.writeMessage("One of your inputs is less than zero\n");
        } else {
          // adds to total if it works
          inputTotal.add(value - 1);
        }
        // catches exception if not an integer
      } catch (NumberFormatException e) {
        // checks if exception is caused because quit
        if (input.equalsIgnoreCase("q")) {
          this.gameQuit();
          // leave the method if input is a q or Q
          return;
        } else {
          // if not quit write the message invalid integer
          this.writeMessage("One of your inputs is not a \"Q\" or \"q\" or a valid integer\n");
        }
      }
    }
    // if the input size is equal to four and no Q
    if (inputTotal.size() == 4
            && this.shouldGameContinue) {
      try {
        // make move
        model.move(inputTotal.get(0), inputTotal.get(1),
                inputTotal.get(2), inputTotal.get(3));
        // as long as the game isn't over in any cases make the move otherwise
        // call the gameEnd method
        if (this.model.getScore() > 1 && (!this.model.isGameOver())) {
          this.gameMove(writeMoveMessage(inputTotal));
        } else {
          this.gameEnd();
        }
        // throw exception if move is invalid
      } catch (IllegalArgumentException e) {
        writeMessage("Invalid move. Play again!\n");
      }
    }
  }

  /**
   * Catches the IO exception in renderBoard, so it never occurs anywhere else in my code.
   * @throws IllegalStateException instead of IO exception if the transmission fails
   */
  private void writeBoard() throws IllegalStateException {
    try {
      this.view.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException("Transmission of the board to the "
              + "provided data destination fails");
    }
  }

  /**
   * Catches the IO exception in renderMessage, so it never occurs anywhere else in my code.
   * @param message the message that is to be concatenated
   * @throws IllegalStateException instead of IO exception if the transmission fails
   */
  private void writeMessage(String message) throws IllegalStateException {
    try {
      this.view.renderMessage(message);
    } catch (IOException e) {
      throw new IllegalStateException("transmission of the message to the "
              + "provided data destination fails");
    }
  }

  /**
   * Prints a welcome statement, the board, and then a prompt to make a move. Starts the game.
   */
  private void gameStart() {
    this.writeMessage("Welcome to Cole's Marble Solitaire!\n");
    this.writeBoard();
    this.writeMessage("\nScore: " + model.getScore());
    this.writeMessage("\nMake your first move below!\n");
  }

  /**
   * Creates the move message that is output to the user.
   * @param inputTotal the list of 4 valid integers added by the user
   * @return the concatenated move string
   */
  private String writeMoveMessage(List<Integer> inputTotal) {
    return ("(" + (inputTotal.get(0))
            + ", " + (inputTotal.get(1))
            + ") to (" + (inputTotal.get(2))
            + ", " + (inputTotal.get(3)))
            + ")";
  }

  /**
   * Prints the move made by the user, the board state, and then the current score.
   * @param message writeMoveMessage
   */
  private void gameMove(String message) {
    this.writeMessage("You made the move: " + message + "\n");
    this.writeBoard();
    this.writeMessage("\nScore: " + model.getScore() + "\n");
  }

  /**
   * Quits the game when "q" or "Q" is input by the user. Prints a game quit message, the state of
   * the board, your score, and the game's outcome.
   */
  private void gameQuit() {
    this.shouldGameContinue = false;
    this.writeMessage("Game quit!\n");
    this.writeMessage("State of game when quit:\n");
    this.writeBoard();
    this.writeMessage("\nScore: " + model.getScore());
  }

  /**
   * Ends the game when you win or lose. Prints a game quit message, the state of
   * the board, your score, and the game's outcome.
   */
  private void gameEnd() {
    this.writeMessage("Game over!\n");
    this.writeBoard();
    this.writeMessage("\nScore: " + model.getScore());
  }

}

