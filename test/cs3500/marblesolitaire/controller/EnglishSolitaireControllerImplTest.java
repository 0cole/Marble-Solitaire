package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.model.SimpleModel.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.SimpleModel.MockModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Tests for {@link MarbleSolitaireControllerImpl} for an english board.
 */
public class EnglishSolitaireControllerImplTest {

  EnglishSolitaireModel modelState = new EnglishSolitaireModel();
  EnglishSolitaireModel modelStateArmFive = new EnglishSolitaireModel(5);
  Appendable appendable = new StringBuilder();
  MarbleSolitaireView view = new MarbleSolitaireTextView(modelState, appendable);
  MarbleSolitaireView viewArmFive = new MarbleSolitaireTextView(modelStateArmFive, appendable);




  // QUIT AT START LOWER CASE
  Readable readableQuitAtStartLowercase = new StringReader("q");
  MarbleSolitaireController controllerQuitAtStartLowercase =
          new MarbleSolitaireControllerImpl(modelState, view, readableQuitAtStartLowercase);

  // QUIT AT START UPPER CASE
  Readable readableQuitAtStartUppercase = new StringReader("Q");
  MarbleSolitaireController controllerQuitAtStartUppercase =
          new MarbleSolitaireControllerImpl(modelState, view, readableQuitAtStartUppercase);

  // QUIT NO WHITESPACE
  Readable readableQuitNoWhiteSpaceMove = new StringReader("lalalalaQ 6 4 4 4 Q");
  MarbleSolitaireController controllerQuitNoWhiteSpaceMove =
          new MarbleSolitaireControllerImpl(modelState, view, readableQuitNoWhiteSpaceMove);


  // QUIT AT POS ONE VALID MOVE LOWERCASE
  Readable readableQuitAtPosOneValidMoveLowercase = new StringReader("q 4 6 4 4");
  MarbleSolitaireController controllerQuitAtPosOneValidMoveLowercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosOneValidMoveLowercase);

  // QUIT AT POS TWO VALID MOVE LOWERCASE
  Readable readableQuitAtPosTwoValidMoveLowercase = new StringReader("4 q 6 4 4");
  MarbleSolitaireController controllerQuitAtPosTwoValidMoveLowercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosTwoValidMoveLowercase);

  // QUIT AT POS THREE VALID MOVE LOWERCASE
  Readable readableQuitAtPosThreeValidMoveLowercase = new StringReader("4 6 q 4 4");
  MarbleSolitaireController controllerQuitAtPosThreeValidMoveLowercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosThreeValidMoveLowercase);

  // QUIT AT POS FOUR VALID MOVE LOWERCASE
  Readable readableQuitAtPosFourValidMoveLowercase = new StringReader("4 6 4 q 4");
  MarbleSolitaireController controllerQuitAtPosFourValidMoveLowercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosFourValidMoveLowercase);

  // QUIT AT POS ONE VALID MOVE UPPERCASE
  Readable readableQuitAtPosOneValidMoveUppercase = new StringReader("Q 4 6 4 4");
  MarbleSolitaireController controllerQuitAtPosOneValidMoveUppercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosOneValidMoveUppercase);

  // QUIT AT POS TWO VALID MOVE LOWERCASE
  Readable readableQuitAtPosTwoValidMoveUppercase = new StringReader("4 Q 6 4 4");
  MarbleSolitaireController controllerQuitAtPosTwoValidMoveUppercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosTwoValidMoveUppercase);

  // QUIT AT POS THREE VALID MOVE UPPERCASE
  Readable readableQuitAtPosThreeValidMoveUppercase = new StringReader("4 6 Q 4 4");
  MarbleSolitaireController controllerQuitAtPosThreeValidMoveUppercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosThreeValidMoveUppercase);

  // QUIT AT POS FOUR VALID MOVE UPPERCASE
  Readable readableQuitAtPosFourValidMoveUppercase = new StringReader("4 6 4 Q 4");
  MarbleSolitaireController controllerQuitAtPosFourValidMoveUppercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosFourValidMoveUppercase);

  // LETTER IN THE READABLE
  Readable readableLetterInReadable = new StringReader("a q");
  MarbleSolitaireController controllerLetterInReadable =
          new MarbleSolitaireControllerImpl(modelState, view, readableLetterInReadable);

  // LETTER IN THE READABLE VALID MOVE
  Readable readableLetterInReadableValidMove = new StringReader("4 6 4 a 4 q");
  MarbleSolitaireController controllerLetterInReadableValidMove =
          new MarbleSolitaireControllerImpl(modelState, view, readableLetterInReadableValidMove);

  // TWO LETTERS IN THE READABLE VALID MOVE
  Readable readableTwoLettersInReadableValidMove = new StringReader("4 6 p 4 a 4 q");
  MarbleSolitaireController controllerTwoLettersInReadableValidMove =
          new MarbleSolitaireControllerImpl(modelState,view, readableTwoLettersInReadableValidMove);

  // SYMBOL IN THE READABLE
  Readable readableSymbolInReadable = new StringReader("; q");
  MarbleSolitaireController controllerSymbolInReadable =
          new MarbleSolitaireControllerImpl(modelState, view, readableSymbolInReadable);

  // SYMBOL IN THE READABLE VALID MOVE
  Readable readableSymbolInReadableValidMove = new StringReader("4 6 4 ; 4 q");
  MarbleSolitaireController controllerSymbolInReadableValidMove =
          new MarbleSolitaireControllerImpl(modelState, view, readableSymbolInReadableValidMove);

  // NEGATIVE NUMBER IN THE READABLE
  Readable readableNegativeNumberInReadable = new StringReader("-1 q");
  MarbleSolitaireController controllerNegativeNumberInReadable =
          new MarbleSolitaireControllerImpl(modelState, view, readableNegativeNumberInReadable);

  // FOUR NEGATIVE NUMBERS IN THE READABLE
  Readable readableFourNegativeNumbersInReadable = new StringReader("-4 -6 -4 -4 q");
  MarbleSolitaireController controllerFourNegativeNumbersInReadable = new
          MarbleSolitaireControllerImpl(modelState, view, readableFourNegativeNumbersInReadable);

  // NEGATIVE NUMBER IN THE READABLE VALID MOVE
  Readable readableNegativeNumberInReadableValidMove = new StringReader("4 6 -1 4 4 q");
  MarbleSolitaireController controllerNegativeNumberInReadableValidMove =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableNegativeNumberInReadableValidMove);

  // INVALID MOVE ON BOARD QUIT
  Readable readableInvalidMoveOnBoard = new StringReader("4 4 4 4 q");
  MarbleSolitaireController controllerInvalidMoveOnBoard =
          new MarbleSolitaireControllerImpl(modelState, view, readableInvalidMoveOnBoard);

  // INVALID MOVE OFF BOARD QUIT
  Readable readableInvalidMoveOffBoard = new StringReader("10 8 10 10 q");
  MarbleSolitaireController controllerInvalidMoveOffBoard =
          new MarbleSolitaireControllerImpl(modelState, view, readableInvalidMoveOffBoard);


  // ONE MOVE QUIT
  Readable readableValidOneMove = new StringReader("4 6 4 4 q");
  MarbleSolitaireController controllerValidOneMove =
          new MarbleSolitaireControllerImpl(modelState, view, readableValidOneMove);

  // ONE MOVE SEPARATED BY NEW LINE QUIT
  Readable readableValidOneMoveSeparatedByNewLine = new StringReader("4 6 \n" + "4 4 q");
  MarbleSolitaireController controllerValidOneMoveSeparatedByNewLine = new
          MarbleSolitaireControllerImpl(modelState, view, readableValidOneMoveSeparatedByNewLine);

  // TWO MOVES QUIT
  Readable readableValidTwoMoves = new StringReader("4 6 4 4 2 5 4 5 q");
  MarbleSolitaireController controllerValidTwoMoves =
          new MarbleSolitaireControllerImpl(modelState, view, readableValidTwoMoves);

  // TWO MOVES QUIT ARM 5
  Readable readableValidTwoMovesArmFive = new StringReader("4 6 4 4 2 5 4 5 q");
  MarbleSolitaireController controllerValidTwoMovesArmFive =
          new MarbleSolitaireControllerImpl(modelStateArmFive, 
                  viewArmFive, readableValidTwoMovesArmFive);

  // TWO MOVES QUIT WITH NEW LINE
  Readable readableValidTwoMovesNewLine = new StringReader("4 6 4 4 \n 2 5 4 5 q");
  MarbleSolitaireController controllerValidTwoMovesNewLine =
          new MarbleSolitaireControllerImpl(modelState, view, readableValidTwoMovesNewLine);

  // WIN CONDITION
  Readable readableWin = new StringReader("4 6 4 4   2 5 4 5   3 7 3 5   5 7 3 7   "
          + "3 4 3 6   3 7 3 5   3 2 3 4   1 3 3 3   1 5 1 3   4 3 2 3   1 3 3 3   6 3 4 3   "
          + "5 1 5 3   3 1 5 1   5 4 5 2   5 6 5 4   7 5 5 5   7 3 7 5   4 5 6 5   7 5 5 5   "
          + "5 1 5 3   4 3 2 3   2 3 2 5   2 5 4 5   4 5 6 5   6 5 6 3   6 3 4 3   4 4 2 4   "
          + "4 2 4 4   5 4 3 4   2 4 4 4");
  MarbleSolitaireController controllerWin =
          new MarbleSolitaireControllerImpl(modelState, view, readableWin);

  // LOSE CONDITION
  Readable readableLose = new StringReader("4 6 4 4   2 5 4 5   3 7 3 5   5 7 3 7   "
          + "3 4 3 6   3 7 3 5   3 2 3 4   1 3 3 3   1 5 1 3   4 3 2 3   1 3 3 3   6 3 4 3   "
          + "5 1 5 3   3 1 5 1   5 4 5 2   5 6 5 4   7 5 5 5   7 3 7 5   4 5 6 5   7 5 5 5   "
          + "5 1 5 3   4 3 2 3   2 3 2 5   2 5 4 5   4 5 6 5   6 5 6 3   6 3 4 3   4 4 2 4   "
          + "4 2 4 4   4 4 6 4");
  MarbleSolitaireController controllerLose =
          new MarbleSolitaireControllerImpl(modelState, view, readableLose);




  @Test
  public void testQuitAtStartLowercase() {

    this.controllerQuitAtStartLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitAtStartUppercase() {

    this.controllerQuitAtStartUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitNoWhiteSpaceMove() {

    this.controllerQuitNoWhiteSpaceMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n"
          + "You made the move: (5, 3) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "    O _ O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "    O _ O\n"
          + "    O O O\n"
          + "Score: 31", appendable.toString());
  }

  @Test
  public void testQuitAtPosOneValidMoveLowercase() {

    this.controllerQuitAtPosOneValidMoveLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitAtPosTwoValidMoveLowercase() {

    this.controllerQuitAtPosTwoValidMoveLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Make your first move below!\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitAtPosThreeValidMoveLowercase() {

    this.controllerQuitAtPosThreeValidMoveLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Make your first move below!\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitAtPosFourValidMoveLowercase() {

    this.controllerQuitAtPosFourValidMoveLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Make your first move below!\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitAtPosOneValidMoveUppercase() {

    this.controllerQuitAtPosOneValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Make your first move below!\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitAtPosTwoValidMoveUppercase() {

    this.controllerQuitAtPosTwoValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Make your first move below!\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitAtPosThreeValidMoveUppercase() {

    this.controllerQuitAtPosThreeValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Make your first move below!\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitAtPosFourValidMoveUppercase() {

    this.controllerQuitAtPosFourValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Make your first move below!\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32", appendable.toString());
  }

  @Test
  public void testQuitInTheMiddleOfValidMoveUppercase() {

    this.controllerQuitAtPosOneValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testLetterInReadable() {

    this.controllerLetterInReadable.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testLetterInReadableValidMove() {

    this.controllerLetterInReadableValidMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n"
          + "You made the move: (3, 5) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31", appendable.toString());
  }

  @Test
  public void testTwoLettersInReadableValidMove() {

    this.controllerTwoLettersInReadableValidMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n"
          + "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n"
          + "You made the move: (3, 5) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31", appendable.toString());
  }

  @Test
  public void testSymbolInReadable() {

    this.controllerSymbolInReadable.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testSymbolInReadableValidMove() {

    this.controllerSymbolInReadableValidMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n"
          + "You made the move: (3, 5) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31", appendable.toString());
  }

  @Test
  public void testNegativeNumberInReadable() {

    this.controllerNegativeNumberInReadable.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "One of your inputs is less than zero\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testFourNegativeNumbersInReadable() {

    this.controllerFourNegativeNumbersInReadable.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "One of your inputs is less than zero\n"
          + "One of your inputs is less than zero\n"
          + "One of your inputs is less than zero\n"
          + "One of your inputs is less than zero\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testNegativeNumberInReadableValidMove() {

    this.controllerNegativeNumberInReadableValidMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "One of your inputs is less than zero\n"
          + "You made the move: (3, 5) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31", appendable.toString());
  }

  @Test
  public void testInvalidMoveOnBoard() {

    this.controllerInvalidMoveOnBoard.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "Invalid move. Play again!\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testInvalidMoveOffBoard() {

    this.controllerInvalidMoveOffBoard.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "Invalid move. Play again!\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32", appendable.toString());
  }

  @Test
  public void testValidOneMoveQuit() {

    this.controllerValidOneMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "You made the move: (3, 5) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31", appendable.toString());
  }

  @Test
  public void testValidOneMoveSeparatedByNewLineQuit() {

    this.controllerValidOneMoveSeparatedByNewLine.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "You made the move: (3, 5) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31", appendable.toString());
  }

  @Test
  public void testValidTwoMovesQuit() {

    this.controllerValidTwoMoves.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "You made the move: (3, 5) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "You made the move: (1, 4) to (3, 4)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O _ O O\n"
          + "O O O O O _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 30\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O _ O O\n"
          + "O O O O O _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 30", appendable.toString());
  }

  @Test
  public void testValidTwoMovesQuitArmFive() {

    this.controllerValidTwoMovesArmFive.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "O O O O O O O O O O O O O\n"
          + "O O O O O O O O O O O O O\n"
          + "O O O O O O _ O O O O O O\n"
          + "O O O O O O O O O O O O O\n"
          + "O O O O O O O O O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "Score: 104\n"
          + "Make your first move below!\n"
          + "Invalid move. Play again!\n"
          + "Invalid move. Play again!\n"
          + "Game quit!\n"
          + "State of game when quit:\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "O O O O O O O O O O O O O\n"
          + "O O O O O O O O O O O O O\n"
          + "O O O O O O _ O O O O O O\n"
          + "O O O O O O O O O O O O O\n"
          + "O O O O O O O O O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "        O O O O O\n"
          + "Score: 104", appendable.toString());
  }

  @Test
  public void testValidTwoMovesNewLineQuit() {

    this.controllerValidTwoMovesNewLine.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "Make your first move below!\n"
            + "You made the move: (3, 5) to (3, 3)\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O _ _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "You made the move: (1, 4) to (3, 4)\n"
            + "    O O O\n"
            + "    O O _\n"
            + "O O O O _ O O\n"
            + "O O O O O _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 30\n"
            + "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O _\n"
            + "O O O O _ O O\n"
            + "O O O O O _ O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 30", appendable.toString());
  }

  @Test
  public void testWin() {

    this.controllerWin.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "You made the move: (3, 5) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "You made the move: (1, 4) to (3, 4)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O _ O O\n"
          + "O O O O O _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 30\n"
          + "You made the move: (2, 6) to (2, 4)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O O _ _\n"
          + "O O O O O _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 29\n"
          + "You made the move: (4, 6) to (2, 6)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O O _ O\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 28\n"
          + "You made the move: (2, 3) to (2, 5)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O _ _ O O\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 27\n"
          + "You made the move: (2, 6) to (2, 4)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O _ O _ _\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 26\n"
          + "You made the move: (2, 1) to (2, 3)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O _ _ O O _ _\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 25\n"
          + "You made the move: (0, 2) to (2, 2)\n"
          + "    _ O O\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 24\n"
          + "You made the move: (0, 4) to (0, 2)\n"
          + "    O _ _\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 23\n"
          + "You made the move: (3, 2) to (1, 2)\n"
          + "    O _ _\n"
          + "    O O _\n"
          + "O _ _ O O _ _\n"
          + "O O _ O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 22\n"
          + "You made the move: (0, 2) to (2, 2)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O _ O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 21\n"
          + "You made the move: (5, 2) to (3, 2)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O O O O _ _\n"
          + "O O _ O O O _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 20\n"
          + "You made the move: (4, 0) to (4, 2)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O O O O _ _\n"
          + "_ _ O O O O _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 19\n"
          + "You made the move: (2, 0) to (4, 0)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O _ O O O O _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 18\n"
          + "You made the move: (4, 3) to (4, 1)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O O _ _ O O _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 17\n"
          + "You made the move: (4, 5) to (4, 3)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O O _ O _ _ _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 16\n"
          + "You made the move: (6, 4) to (4, 4)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O O _ O O _ _\n"
          + "    _ O _\n"
          + "    O O _\n"
          + "Score: 15\n"
          + "You made the move: (6, 2) to (6, 4)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O O _ O O _ _\n"
          + "    _ O _\n"
          + "    _ _ O\n"
          + "Score: 14\n"
          + "You made the move: (3, 4) to (5, 4)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O _ _ _\n"
          + "O O _ O _ _ _\n"
          + "    _ O O\n"
          + "    _ _ O\n"
          + "Score: 13\n"
          + "You made the move: (6, 4) to (4, 4)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O _ _ _\n"
          + "O O _ O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 12\n"
          + "You made the move: (4, 0) to (4, 2)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O _ _ _\n"
          + "_ _ O O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 11\n"
          + "You made the move: (3, 2) to (1, 2)\n"
          + "    _ _ _\n"
          + "    O O _\n"
          + "_ _ _ O O _ _\n"
          + "_ O _ O _ _ _\n"
          + "_ _ O O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 10\n"
          + "You made the move: (1, 2) to (1, 4)\n"
          + "    _ _ _\n"
          + "    _ _ O\n"
          + "_ _ _ O O _ _\n"
          + "_ O _ O _ _ _\n"
          + "_ _ O O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 9\n"
          + "You made the move: (1, 4) to (3, 4)\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ O _ O O _ _\n"
          + "_ _ O O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 8\n"
          + "You made the move: (3, 4) to (5, 4)\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ O _ O _ _ _\n"
          + "_ _ O O _ _ _\n"
          + "    _ O O\n"
          + "    _ _ _\n"
          + "Score: 7\n"
          + "You made the move: (5, 4) to (5, 2)\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ O _ O _ _ _\n"
          + "_ _ O O _ _ _\n"
          + "    O _ _\n"
          + "    _ _ _\n"
          + "Score: 6\n"
          + "You made the move: (5, 2) to (3, 2)\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ O O O _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "Score: 5\n"
          + "You made the move: (3, 3) to (1, 3)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ _ _ _ _ _\n"
          + "_ O O _ _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "Score: 4\n"
          + "You made the move: (3, 1) to (3, 3)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ _ _ _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "Score: 3\n"
          + "You made the move: (4, 3) to (2, 3)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ _ O _ _ _\n"
          + "_ _ _ _ _ _ _\n"
          + "_ _ _ _ _ _ _\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "Score: 2\n"
          + "Game over!\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "_ _ _ _ _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ _ _ _ _ _ _\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "Score: 1", appendable.toString());
  }

  @Test
  public void testLose() {

    this.controllerLose.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O _ O O O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 32\n"
          + "Make your first move below!\n"
          + "You made the move: (3, 5) to (3, 3)\n"
          + "    O O O\n"
          + "    O O O\n"
          + "O O O O O O O\n"
          + "O O O O _ _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 31\n"
          + "You made the move: (1, 4) to (3, 4)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O _ O O\n"
          + "O O O O O _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 30\n"
          + "You made the move: (2, 6) to (2, 4)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O O _ _\n"
          + "O O O O O _ O\n"
          + "O O O O O O O\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 29\n"
          + "You made the move: (4, 6) to (2, 6)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O O O _ O\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 28\n"
          + "You made the move: (2, 3) to (2, 5)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O _ _ O O\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 27\n"
          + "You made the move: (2, 6) to (2, 4)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O O O _ O _ _\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 26\n"
          + "You made the move: (2, 1) to (2, 3)\n"
          + "    O O O\n"
          + "    O O _\n"
          + "O _ _ O O _ _\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 25\n"
          + "You made the move: (0, 2) to (2, 2)\n"
          + "    _ O O\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 24\n"
          + "You made the move: (0, 4) to (0, 2)\n"
          + "    O _ _\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O O O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 23\n"
          + "You made the move: (3, 2) to (1, 2)\n"
          + "    O _ _\n"
          + "    O O _\n"
          + "O _ _ O O _ _\n"
          + "O O _ O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 22\n"
          + "You made the move: (0, 2) to (2, 2)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O _ O O _ _\n"
          + "O O O O O O _\n"
          + "    O O O\n"
          + "    O O O\n"
          + "Score: 21\n"
          + "You made the move: (5, 2) to (3, 2)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O O O O _ _\n"
          + "O O _ O O O _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 20\n"
          + "You made the move: (4, 0) to (4, 2)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "O _ O O O _ _\n"
          + "O O O O O _ _\n"
          + "_ _ O O O O _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 19\n"
          + "You made the move: (2, 0) to (4, 0)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O _ O O O O _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 18\n"
          + "You made the move: (4, 3) to (4, 1)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O O _ _ O O _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 17\n"
          + "You made the move: (4, 5) to (4, 3)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O O _ O _ _ _\n"
          + "    _ O O\n"
          + "    O O O\n"
          + "Score: 16\n"
          + "You made the move: (6, 4) to (4, 4)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O O _ O O _ _\n"
          + "    _ O _\n"
          + "    O O _\n"
          + "Score: 15\n"
          + "You made the move: (6, 2) to (6, 4)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O O _ _\n"
          + "O O _ O O _ _\n"
          + "    _ O _\n"
          + "    _ _ O\n"
          + "Score: 14\n"
          + "You made the move: (3, 4) to (5, 4)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O _ _ _\n"
          + "O O _ O _ _ _\n"
          + "    _ O O\n"
          + "    _ _ O\n"
          + "Score: 13\n"
          + "You made the move: (6, 4) to (4, 4)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O _ _ _\n"
          + "O O _ O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 12\n"
          + "You made the move: (4, 0) to (4, 2)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ O O O _ _\n"
          + "_ O O O _ _ _\n"
          + "_ _ O O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 11\n"
          + "You made the move: (3, 2) to (1, 2)\n"
          + "    _ _ _\n"
          + "    O O _\n"
          + "_ _ _ O O _ _\n"
          + "_ O _ O _ _ _\n"
          + "_ _ O O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 10\n"
          + "You made the move: (1, 2) to (1, 4)\n"
          + "    _ _ _\n"
          + "    _ _ O\n"
          + "_ _ _ O O _ _\n"
          + "_ O _ O _ _ _\n"
          + "_ _ O O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 9\n"
          + "You made the move: (1, 4) to (3, 4)\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ O _ O O _ _\n"
          + "_ _ O O O _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 8\n"
          + "You made the move: (3, 4) to (5, 4)\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ O _ O _ _ _\n"
          + "_ _ O O _ _ _\n"
          + "    _ O O\n"
          + "    _ _ _\n"
          + "Score: 7\n"
          + "You made the move: (5, 4) to (5, 2)\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ O _ O _ _ _\n"
          + "_ _ O O _ _ _\n"
          + "    O _ _\n"
          + "    _ _ _\n"
          + "Score: 6\n"
          + "You made the move: (5, 2) to (3, 2)\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ O O O _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "Score: 5\n"
          + "You made the move: (3, 3) to (1, 3)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ _ _ _ _ _\n"
          + "_ O O _ _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "Score: 4\n"
          + "You made the move: (3, 1) to (3, 3)\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ _ _ _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "_ _ _ O _ _ _\n"
          + "    _ _ _\n"
          + "    _ _ _\n"
          + "Score: 3\n"
          + "Game over!\n"
          + "    _ _ _\n"
          + "    _ O _\n"
          + "_ _ _ _ _ _ _\n"
          + "_ _ _ _ _ _ _\n"
          + "_ _ _ _ _ _ _\n"
          + "    _ O _\n"
          + "    _ _ _\n"
          + "Score: 2", appendable.toString());

  }

  @Test
  public void testMockModelValid() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("6 4 4 4 q");
    MarbleSolitaireView view = new MarbleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("5 3 3 3 ", appendable.toString());

  }

  @Test
  public void testMockModelLetters() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("a b c d hi i hope this counts 4 6 4 4 q");
    MarbleSolitaireView view = new MarbleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("3 5 3 3 ", appendable.toString());

  }

  @Test
  public void testMockModelSymbols() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("#instagram (4) **** *** @ 4 6 4 4 q");
    MarbleSolitaireView view = new MarbleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("3 5 3 3 ", appendable.toString());

  }

  @Test
  public void testMockModelNegativeNumbers() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("-1 -2 -3 -4 4 6 4 4 q");
    MarbleSolitaireView view = new MarbleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("3 5 3 3 ", appendable.toString());

  }

  @Test
  public void testMockModelOffTheBoardNumbersPositive() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("520 10 99 20 q");
    MarbleSolitaireView view = new MarbleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("519 9 98 19 ", appendable.toString());

  }

  @Test
  public void testRenderBoardIOException() {
    MarbleSolitaireView view = new MarbleSolitaireTextView(modelState, new FakeTestAppendable());
    assertThrows(IOException.class, view::renderBoard);
  }

  @Test
  public void testRenderMessageIOException() {
    MarbleSolitaireView view = new MarbleSolitaireTextView(modelState, new FakeTestAppendable());
    assertThrows(IOException.class, () -> view.renderMessage("i hope this is correct"));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorNullAll() {

    MarbleSolitaireController controllerNull = new MarbleSolitaireControllerImpl(null,
            null, null);

    controllerNull.playGame();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorNullViewReadable() {

    MarbleSolitaireController controllerNull = new MarbleSolitaireControllerImpl(modelState,
            null, null);

    controllerNull.playGame();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorNullModelReadable() {

    MarbleSolitaireController controllerNull = new MarbleSolitaireControllerImpl(null,
            view, null);

    controllerNull.playGame();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorNullModelView() {

    MarbleSolitaireController controllerNull = new MarbleSolitaireControllerImpl(null,
            null, readableValidOneMove);

    controllerNull.playGame();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorNullReadable() {

    MarbleSolitaireController controllerNull = new MarbleSolitaireControllerImpl(modelState,
            view, null);

    controllerNull.playGame();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorNullModel() {

    MarbleSolitaireController controllerNull = new MarbleSolitaireControllerImpl(null,
            view, readableValidOneMove);

    controllerNull.playGame();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructorNullView() {

    MarbleSolitaireController controllerNull = new MarbleSolitaireControllerImpl(modelState,
            null, readableValidOneMove);

    controllerNull.playGame();
  }

  @Test
  public void testNoSuchElementPlayGameValidMove() {

    Readable readableNoSuchElementException = new StringReader("4 6 4 4");
    MarbleSolitaireController controllerNoSuchElementException =
            new MarbleSolitaireControllerImpl(modelState,
                    view, readableNoSuchElementException);

    assertThrows(IllegalStateException.class, controllerNoSuchElementException::playGame);
  }

  @Test
  public void testNoSuchElementPlayGameNothing() {

    Readable readableNoSuchElementException = new StringReader("");
    MarbleSolitaireController controllerNoSuchElementException =
            new MarbleSolitaireControllerImpl(modelState,
                    view, readableNoSuchElementException);

    assertThrows(IllegalStateException.class, controllerNoSuchElementException::playGame);
  }

}