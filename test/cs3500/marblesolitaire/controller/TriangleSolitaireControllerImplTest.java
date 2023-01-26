package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.model.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.SimpleModel.MockModel;
import cs3500.marblesolitaire.model.BetterModel.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Tests for {@link MarbleSolitaireControllerImpl} for a triangle board.
 */
public class TriangleSolitaireControllerImplTest {
  
  TriangleSolitaireModel modelState = new TriangleSolitaireModel();
  TriangleSolitaireModel modelStateSizeNine = new TriangleSolitaireModel(9);
  Appendable appendable = new StringBuilder();
  MarbleSolitaireView view = new TriangleSolitaireTextView(modelState, appendable);
  MarbleSolitaireView viewSizeNine = new TriangleSolitaireTextView(modelStateSizeNine, appendable);


  // QUIT AT START LOWER CASE
  Readable readableQuitAtStartLowercase = new StringReader("q");
  MarbleSolitaireController controllerQuitAtStartLowercase =
          new MarbleSolitaireControllerImpl(modelState, view, readableQuitAtStartLowercase);

  // QUIT AT START UPPER CASE
  Readable readableQuitAtStartUppercase = new StringReader("Q");
  MarbleSolitaireController controllerQuitAtStartUppercase =
          new MarbleSolitaireControllerImpl(modelState, view, readableQuitAtStartUppercase);

  // QUIT NO WHITESPACE
  Readable readableQuitNoWhiteSpaceMove = new StringReader("lalalalaQ 3 3 1 1 Q");
  MarbleSolitaireController controllerQuitNoWhiteSpaceMove =
          new MarbleSolitaireControllerImpl(modelState, view, readableQuitNoWhiteSpaceMove);


  // QUIT AT POS ONE VALID MOVE LOWERCASE
  Readable readableQuitAtPosOneValidMoveLowercase = new StringReader("q 3 3 1 1");
  MarbleSolitaireController controllerQuitAtPosOneValidMoveLowercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosOneValidMoveLowercase);

  // QUIT AT POS TWO VALID MOVE LOWERCASE
  Readable readableQuitAtPosTwoValidMoveLowercase = new StringReader("3 q 3 1 1");
  MarbleSolitaireController controllerQuitAtPosTwoValidMoveLowercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosTwoValidMoveLowercase);

  // QUIT AT POS THREE VALID MOVE LOWERCASE
  Readable readableQuitAtPosThreeValidMoveLowercase = new StringReader("3 3 q 1 1");
  MarbleSolitaireController controllerQuitAtPosThreeValidMoveLowercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosThreeValidMoveLowercase);

  // QUIT AT POS FOUR VALID MOVE LOWERCASE
  Readable readableQuitAtPosFourValidMoveLowercase = new StringReader("3 3 1 q 1");
  MarbleSolitaireController controllerQuitAtPosFourValidMoveLowercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosFourValidMoveLowercase);

  // QUIT AT POS ONE VALID MOVE UPPERCASE
  Readable readableQuitAtPosOneValidMoveUppercase = new StringReader("Q 3 3 1 1");
  MarbleSolitaireController controllerQuitAtPosOneValidMoveUppercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosOneValidMoveUppercase);

  // QUIT AT POS TWO VALID MOVE LOWERCASE
  Readable readableQuitAtPosTwoValidMoveUppercase = new StringReader("3 Q 3 1 1");
  MarbleSolitaireController controllerQuitAtPosTwoValidMoveUppercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosTwoValidMoveUppercase);

  // QUIT AT POS THREE VALID MOVE UPPERCASE
  Readable readableQuitAtPosThreeValidMoveUppercase = new StringReader("3 3 Q 1 1");
  MarbleSolitaireController controllerQuitAtPosThreeValidMoveUppercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosThreeValidMoveUppercase);

  // QUIT AT POS FOUR VALID MOVE UPPERCASE
  Readable readableQuitAtPosFourValidMoveUppercase = new StringReader("3 3 1 Q 1");
  MarbleSolitaireController controllerQuitAtPosFourValidMoveUppercase =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableQuitAtPosFourValidMoveUppercase);

  // LETTER IN THE READABLE
  Readable readableLetterInReadable = new StringReader("a q");
  MarbleSolitaireController controllerLetterInReadable =
          new MarbleSolitaireControllerImpl(modelState, view, readableLetterInReadable);

  // LETTER IN THE READABLE VALID MOVE
  Readable readableLetterInReadableValidMove = new StringReader("3 3 1 a 1 q");
  MarbleSolitaireController controllerLetterInReadableValidMove =
          new MarbleSolitaireControllerImpl(modelState, view, readableLetterInReadableValidMove);

  // TWO LETTERS IN THE READABLE VALID MOVE
  Readable readableTwoLettersInReadableValidMove = new StringReader("3 3 p 1 q 1 q");
  MarbleSolitaireController controllerTwoLettersInReadableValidMove =
          new MarbleSolitaireControllerImpl(modelState,view, readableTwoLettersInReadableValidMove);

  // SYMBOL IN THE READABLE
  Readable readableSymbolInReadable = new StringReader("; q");
  MarbleSolitaireController controllerSymbolInReadable =
          new MarbleSolitaireControllerImpl(modelState, view, readableSymbolInReadable);

  // SYMBOL IN THE READABLE VALID MOVE
  Readable readableSymbolInReadableValidMove = new StringReader("3 3 1 ; 1 q");
  MarbleSolitaireController controllerSymbolInReadableValidMove =
          new MarbleSolitaireControllerImpl(modelState, view, readableSymbolInReadableValidMove);

  // NEGATIVE NUMBER IN THE READABLE
  Readable readableNegativeNumberInReadable = new StringReader("-1 q");
  MarbleSolitaireController controllerNegativeNumberInReadable =
          new MarbleSolitaireControllerImpl(modelState, view, readableNegativeNumberInReadable);

  // FOUR NEGATIVE NUMBERS IN THE READABLE
  Readable readableFourNegativeNumbersInReadable = new StringReader("-3 -3 -1 -1 q");
  MarbleSolitaireController controllerFourNegativeNumbersInReadable = new
          MarbleSolitaireControllerImpl(modelState, view, readableFourNegativeNumbersInReadable);

  // NEGATIVE NUMBER IN THE READABLE VALID MOVE
  Readable readableNegativeNumberInReadableValidMove = new StringReader("3 3 -1 1 1 q");
  MarbleSolitaireController controllerNegativeNumberInReadableValidMove =
          new MarbleSolitaireControllerImpl(modelState,
                  view, readableNegativeNumberInReadableValidMove);

  // INVALID MOVE ON BOARD QUIT
  Readable readableInvalidMoveOnBoard = new StringReader("4 4 4 4 q");
  MarbleSolitaireController controllerInvalidMoveOnBoard =
          new MarbleSolitaireControllerImpl(modelState, view, readableInvalidMoveOnBoard);

  // INVALID MOVE OFF BOARD QUIT
  Readable readableInvalidMoveOffBoard = new StringReader("10 10 8 8 q");
  MarbleSolitaireController controllerInvalidMoveOffBoard =
          new MarbleSolitaireControllerImpl(modelState, view, readableInvalidMoveOffBoard);


  // ONE MOVE QUIT
  Readable readableValidOneMove = new StringReader("3 3 1 1 q");
  MarbleSolitaireController controllerValidOneMove =
          new MarbleSolitaireControllerImpl(modelState, view, readableValidOneMove);

  // ONE MOVE SEPARATED BY NEW LINE QUIT
  Readable readableValidOneMoveSeparatedByNewLine = new StringReader("3 3 \n" + "1 1 q");
  MarbleSolitaireController controllerValidOneMoveSeparatedByNewLine = new
          MarbleSolitaireControllerImpl(modelState, view, readableValidOneMoveSeparatedByNewLine);

  // TWO MOVES QUIT
  Readable readableValidTwoMoves = new StringReader("3 3 1 1 3 1 3 3 q");
  MarbleSolitaireController controllerValidTwoMoves =
          new MarbleSolitaireControllerImpl(modelState, view, readableValidTwoMoves);

  // TWO MOVES QUIT SIZE NINE
  Readable readableValidTwoMovesSizeNine = new StringReader("3 3 1 1 3 1 3 3 q");
  MarbleSolitaireController controllerValidTwoMovesSizeNine =
          new MarbleSolitaireControllerImpl(modelStateSizeNine,
                  viewSizeNine, readableValidTwoMovesSizeNine);

  // TWO MOVES QUIT WITH NEW LINE
  Readable readableValidTwoMovesNewLine = new StringReader("3 3 1 1 \n 3 1 3 3 q");
  MarbleSolitaireController controllerValidTwoMovesNewLine =
          new MarbleSolitaireControllerImpl(modelState, view, readableValidTwoMovesNewLine);

  // WIN CONDITION
  Readable readableWin = new StringReader("3 1 1 1   3 3 3 1  1 1 3 3  4 1 2 1  5 3 3 1  4 4 4 2"
          + "  2 1 4 1  4 1 4 3  5 5 5 3  5 2 5 4  3 3 5 3  5 4 5 2  5 1 5 3");
  MarbleSolitaireController controllerWin =
          new MarbleSolitaireControllerImpl(modelState, view, readableWin);

  // LOSE CONDITION
  Readable readableLose = new StringReader("3 1 1 1   3 3 3 1  1 1 3 3  4 1 2 1  5 3 3 1  4 4 4 2"
          + "  2 1 4 1  4 1 4 3  5 5 5 3  5 2 5 4  5 4 3 2  3 3 3 1");
  MarbleSolitaireController controllerLose =
          new MarbleSolitaireControllerImpl(modelState, view, readableLose);




  @Test
  public void testQuitAtStartLowercase() {

    this.controllerQuitAtStartLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitAtStartUppercase() {

    this.controllerQuitAtStartUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitNoWhiteSpaceMove() {

    this.controllerQuitNoWhiteSpaceMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n" +
            "You made the move: (2, 2) to (0, 0)\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13", appendable.toString());
  }

  @Test
  public void testQuitAtPosOneValidMoveLowercase() {

    this.controllerQuitAtPosOneValidMoveLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitAtPosTwoValidMoveLowercase() {

    this.controllerQuitAtPosTwoValidMoveLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitAtPosThreeValidMoveLowercase() {

    this.controllerQuitAtPosThreeValidMoveLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitAtPosFourValidMoveLowercase() {

    this.controllerQuitAtPosFourValidMoveLowercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitAtPosOneValidMoveUppercase() {

    this.controllerQuitAtPosOneValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitAtPosTwoValidMoveUppercase() {

    this.controllerQuitAtPosTwoValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitAtPosThreeValidMoveUppercase() {

    this.controllerQuitAtPosThreeValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitAtPosFourValidMoveUppercase() {

    this.controllerQuitAtPosFourValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testQuitInTheMiddleOfValidMoveUppercase() {

    this.controllerQuitAtPosOneValidMoveUppercase.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testLetterInReadable() {

    this.controllerLetterInReadable.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testLetterInReadableValidMove() {

    this.controllerLetterInReadableValidMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n" +
            "You made the move: (2, 2) to (0, 0)\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13", appendable.toString());
  }

  @Test
  public void testTwoLettersInReadableValidMove() {

    this.controllerTwoLettersInReadableValidMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testSymbolInReadable() {

    this.controllerSymbolInReadable.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testSymbolInReadableValidMove() {

    this.controllerSymbolInReadableValidMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "One of your inputs is not a \"Q\" or \"q\" or a valid integer\n" +
            "You made the move: (2, 2) to (0, 0)\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13", appendable.toString());
  }

  @Test
  public void testNegativeNumberInReadable() {

    this.controllerNegativeNumberInReadable.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "One of your inputs is less than zero\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testFourNegativeNumbersInReadable() {

    this.controllerFourNegativeNumbersInReadable.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "One of your inputs is less than zero\n" +
            "One of your inputs is less than zero\n" +
            "One of your inputs is less than zero\n" +
            "One of your inputs is less than zero\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testNegativeNumberInReadableValidMove() {

    this.controllerNegativeNumberInReadableValidMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "One of your inputs is less than zero\n" +
            "You made the move: (2, 2) to (0, 0)\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13", appendable.toString());
  }

  @Test
  public void testInvalidMoveOnBoard() {

    this.controllerInvalidMoveOnBoard.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Invalid move. Play again!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testInvalidMoveOffBoard() {

    this.controllerInvalidMoveOffBoard.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "Invalid move. Play again!\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14", appendable.toString());
  }

  @Test
  public void testValidOneMoveQuit() {

    this.controllerValidOneMove.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "You made the move: (2, 2) to (0, 0)\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13", appendable.toString());
  }

  @Test
  public void testValidOneMoveSeparatedByNewLineQuit() {

    this.controllerValidOneMoveSeparatedByNewLine.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "You made the move: (2, 2) to (0, 0)\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13", appendable.toString());
  }

  @Test
  public void testValidTwoMovesQuit() {

    this.controllerValidTwoMoves.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "You made the move: (2, 2) to (0, 0)\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "You made the move: (2, 0) to (2, 2)\n" +
            "    O\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 12\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 12", appendable.toString());
  }

  @Test
  public void testValidTwoMovesQuitSizeNine() {

    this.controllerValidTwoMovesSizeNine.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "        _\n" +
            "       O O\n" +
            "      O O O\n" +
            "     O O O O\n" +
            "    O O O O O\n" +
            "   O O O O O O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O\n" +
            "Score: 44\n" +
            "Make your first move below!\n" +
            "You made the move: (2, 2) to (0, 0)\n" +
            "        O\n" +
            "       O _\n" +
            "      O O _\n" +
            "     O O O O\n" +
            "    O O O O O\n" +
            "   O O O O O O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O\n" +
            "Score: 43\n" +
            "You made the move: (2, 0) to (2, 2)\n" +
            "        O\n" +
            "       O _\n" +
            "      _ _ O\n" +
            "     O O O O\n" +
            "    O O O O O\n" +
            "   O O O O O O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O\n" +
            "Score: 42\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "        O\n" +
            "       O _\n" +
            "      _ _ O\n" +
            "     O O O O\n" +
            "    O O O O O\n" +
            "   O O O O O O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O\n" +
            "Score: 42", appendable.toString());
  }

  @Test
  public void testValidTwoMovesNewLineQuit() {

    this.controllerValidTwoMovesNewLine.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "You made the move: (2, 2) to (0, 0)\n" +
            "    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "You made the move: (2, 0) to (2, 2)\n" +
            "    O\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 12\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 12", appendable.toString());
  }

  @Test
  public void testWin() {

    this.controllerWin.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "You made the move: (2, 0) to (0, 0)\n" +
            "    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "You made the move: (2, 2) to (2, 0)\n" +
            "    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 12\n" +
            "You made the move: (0, 0) to (2, 2)\n" +
            "    _\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 11\n" +
            "You made the move: (3, 0) to (1, 0)\n" +
            "    _\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " _ O O O\n" +
            "O O O O O\n" +
            "Score: 10\n" +
            "You made the move: (4, 2) to (2, 0)\n" +
            "    _\n" +
            "   O _\n" +
            "  O _ O\n" +
            " _ _ O O\n" +
            "O O _ O O\n" +
            "Score: 9\n" +
            "You made the move: (3, 3) to (3, 1)\n" +
            "    _\n" +
            "   O _\n" +
            "  O _ O\n" +
            " _ O _ _\n" +
            "O O _ O O\n" +
            "Score: 8\n" +
            "You made the move: (1, 0) to (3, 0)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " O O _ _\n" +
            "O O _ O O\n" +
            "Score: 7\n" +
            "You made the move: (3, 0) to (3, 2)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " _ _ O _\n" +
            "O O _ O O\n" +
            "Score: 6\n" +
            "You made the move: (4, 4) to (4, 2)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " _ _ O _\n" +
            "O O O _ _\n" +
            "Score: 5\n" +
            "You made the move: (4, 1) to (4, 3)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " _ _ O _\n" +
            "O _ _ O _\n" +
            "Score: 4\n" +
            "You made the move: (2, 2) to (4, 2)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ _\n" +
            " _ _ _ _\n" +
            "O _ O O _\n" +
            "Score: 3\n" +
            "You made the move: (4, 3) to (4, 1)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ _\n" +
            " _ _ _ _\n" +
            "O O _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ _\n" +
            " _ _ _ _\n" +
            "_ _ O _ _\n" +
            "Score: 1", appendable.toString());
  }

  @Test
  public void testLose() {

    this.controllerLose.playGame();

    assertEquals("Welcome to Cole's Marble Solitaire!\n" +
            "    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 14\n" +
            "Make your first move below!\n" +
            "You made the move: (2, 0) to (0, 0)\n" +
            "    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 13\n" +
            "You made the move: (2, 2) to (2, 0)\n" +
            "    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 12\n" +
            "You made the move: (0, 0) to (2, 2)\n" +
            "    _\n" +
            "   _ _\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O\n" +
            "Score: 11\n" +
            "You made the move: (3, 0) to (1, 0)\n" +
            "    _\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " _ O O O\n" +
            "O O O O O\n" +
            "Score: 10\n" +
            "You made the move: (4, 2) to (2, 0)\n" +
            "    _\n" +
            "   O _\n" +
            "  O _ O\n" +
            " _ _ O O\n" +
            "O O _ O O\n" +
            "Score: 9\n" +
            "You made the move: (3, 3) to (3, 1)\n" +
            "    _\n" +
            "   O _\n" +
            "  O _ O\n" +
            " _ O _ _\n" +
            "O O _ O O\n" +
            "Score: 8\n" +
            "You made the move: (1, 0) to (3, 0)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " O O _ _\n" +
            "O O _ O O\n" +
            "Score: 7\n" +
            "You made the move: (3, 0) to (3, 2)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " _ _ O _\n" +
            "O O _ O O\n" +
            "Score: 6\n" +
            "You made the move: (4, 4) to (4, 2)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " _ _ O _\n" +
            "O O O _ _\n" +
            "Score: 5\n" +
            "You made the move: (4, 1) to (4, 3)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " _ _ O _\n" +
            "O _ _ O _\n" +
            "Score: 4\n" +
            "You made the move: (4, 3) to (2, 1)\n" +
            "    _\n" +
            "   _ _\n" +
            "  _ O O\n" +
            " _ _ _ _\n" +
            "O _ _ _ _\n" +
            "Score: 3\n" +
            "Game over!\n" +
            "    _\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " _ _ _ _\n" +
            "O _ _ _ _\n" +
            "Score: 2", appendable.toString());

  }

  @Test
  public void testMockModelValid() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("3 3 1 1 q");
    MarbleSolitaireView view = new TriangleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("2 2 0 0 ", appendable.toString());

  }

  @Test
  public void testMockModelLetters() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("a b c d hi i hope this counts 3 3 1 1 q");
    MarbleSolitaireView view = new TriangleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("2 2 0 0 ", appendable.toString());

  }

  @Test
  public void testMockModelSymbols() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("#instagram (4) **** *** @ 3 3 1 1 q");
    MarbleSolitaireView view = new TriangleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("2 2 0 0 ", appendable.toString());

  }

  @Test
  public void testMockModelNegativeNumbers() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("-1 -2 -3 -4 3 3 1 1 q");
    MarbleSolitaireView view = new TriangleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("2 2 0 0 ", appendable.toString());

  }

  @Test
  public void testMockModelOffTheBoardNumbersPositive() {
    MarbleSolitaireModel mockModel = new MockModel(appendable);
    Readable readableMockModel = new StringReader("520 10 99 20 q");
    MarbleSolitaireView view = new TriangleSolitaireTextView(modelState);

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel,
            view, readableMockModel);

    controller.playGame();

    assertEquals("519 9 98 19 ", appendable.toString());

  }

  @Test
  public void testRenderBoardIOException() {
    MarbleSolitaireView view = new TriangleSolitaireTextView(modelState, new FakeTestAppendable());
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
