package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.SimpleModel.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.MarbleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link MarbleSolitaireTextView}.
 */
public class EnglishSolitaireTextViewTest {

  EnglishSolitaireModel englishDefault = new EnglishSolitaireModel();
  EnglishSolitaireModel englishModelArmFive = new EnglishSolitaireModel(5);
  EnglishSolitaireModel englishModelArmOne = new EnglishSolitaireModel(1);
  EnglishSolitaireModel englishEmptyPosition = new EnglishSolitaireModel(3, 0);



  // prints the board with base cases after it is constructed
  @Test
  public void testToStringEnglishDefault() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(englishDefault);

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", board.toString());
  }

  // prints the board with an armThickness of five
  @Test
  public void testToStringEnglishArmFive() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(englishModelArmFive);

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", board.toString());
  }

  // prints the board with an armThickness of one
  @Test
  public void testToStringEnglishArmOne() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(englishModelArmOne);

    assertEquals("_", board.toString());
  }

  // prints the board with a custom empty space
  @Test
  public void testToStringEnglishEmptyPositon() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(englishEmptyPosition);

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "_ O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", board.toString());
  }


  // tests the exception when the model is equal to null
  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {

    MarbleSolitaireView invalid = new MarbleSolitaireTextView(null);
  }

  // prints the board after one move
  @Test
  public void testMoveEnglish() {

    MarbleSolitaireTextView board = new MarbleSolitaireTextView(englishDefault);

    englishDefault.move(1, 3, 3, 3);

    assertEquals("    O O O\n"
            + "    O _ O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", board.toString());
  }



  // prints the board after two moves
  @Test
  public void testTwoMovesEnglish() {

    MarbleSolitaireTextView board = new MarbleSolitaireTextView(englishDefault);

    englishDefault.move(1, 3, 3, 3);
    englishDefault.move(2, 1, 2, 3);

    assertEquals("    O O O\n"
            + "    O _ O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", board.toString());
  }

  // prints the board after the game is won
  @Test
  public void testWinToStringEnglish() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(englishDefault);

    englishDefault.move(3, 5, 3, 3);
    englishDefault.move(1, 4, 3, 4);
    englishDefault.move(2, 6, 2, 4);
    englishDefault.move(4, 6, 2, 6);
    englishDefault.move(2, 3, 2, 5);
    englishDefault.move(2, 6, 2, 4);
    englishDefault.move(2, 1, 2, 3);
    englishDefault.move(0, 2, 2, 2);
    englishDefault.move(0, 4, 0, 2);
    englishDefault.move(3, 2, 1, 2);
    englishDefault.move(0, 2, 2, 2);
    englishDefault.move(5, 2, 3, 2);
    englishDefault.move(4, 0, 4, 2);
    englishDefault.move(2, 0, 4, 0);
    englishDefault.move(4, 3, 4, 1);
    englishDefault.move(4, 5, 4, 3);
    englishDefault.move(6, 4, 4, 4);
    englishDefault.move(6, 2, 6, 4);
    englishDefault.move(3, 4, 5, 4);
    englishDefault.move(6, 4, 4, 4);
    englishDefault.move(4, 0, 4, 2);
    englishDefault.move(3, 2, 1, 2);
    englishDefault.move(1, 2, 1, 4);
    englishDefault.move(1, 4, 3, 4);
    englishDefault.move(3, 4, 5, 4);
    englishDefault.move(5, 4, 5, 2);
    englishDefault.move(5, 2, 3, 2);
    englishDefault.move(3, 3, 1, 3);
    englishDefault.move(3, 1, 3, 3);
    englishDefault.move(4, 3, 2, 3);
    englishDefault.move(1, 3, 3, 3);

    assertEquals("    _ _ _\n"
            + "    _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "_ _ _ O _ _ _\n"
            + "_ _ _ _ _ _ _\n"
            + "    _ _ _\n"
            + "    _ _ _", board.toString());

  }

  // tests the printed board when the game is lost
  @Test
  public void testLoseEnglish() {

    MarbleSolitaireTextView board = new MarbleSolitaireTextView(englishDefault);

    englishDefault.move(3, 5, 3, 3);
    englishDefault.move(3, 2, 3, 4);
    englishDefault.move(3, 0, 3, 2);
    englishDefault.move(5, 3, 3, 3);
    englishDefault.move(4, 1, 4, 3);
    englishDefault.move(4, 4, 4, 2);
    englishDefault.move(6, 4, 4, 4);
    englishDefault.move(4, 5, 4, 3);
    englishDefault.move(4, 2, 4, 4);
    englishDefault.move(6, 2, 4, 2);
    englishDefault.move(3, 2, 5, 2);
    englishDefault.move(3, 4, 5, 4);
    englishDefault.move(1, 2, 3, 2);
    englishDefault.move(1, 4, 3, 4);
    englishDefault.move(2, 0, 2, 2);
    englishDefault.move(2, 6, 2, 4);
    englishDefault.move(4, 6, 2, 6);
    englishDefault.move(3, 2, 1, 2);
    englishDefault.move(3, 4, 1, 4);
    englishDefault.move(0, 2, 2, 2);
    englishDefault.move(0, 4, 2, 4);
    englishDefault.move(2, 3, 4, 3);
    englishDefault.move(0, 3, 2, 3);
    englishDefault.move(2, 3, 2, 1);

    assertEquals("    _ _ _\n"
            + "    _ _ _\n"
            + "_ O _ _ O _ O\n"
            + "_ _ _ _ _ _ _\n"
            + "O _ _ O _ _ _\n"
            + "    O _ O\n"
            + "    _ O _", board.toString());
  }

  // tests when appendable is null in the constructor
  @Test (expected = IllegalArgumentException.class)
  public void constructorAppendableNull() {

    Appendable appendable = null;

    MarbleSolitaireView view = new MarbleSolitaireTextView(englishDefault, appendable);

    view.toString();
  }

  // tests when model and appendable are null in the constructor
  @Test (expected = IllegalArgumentException.class)
  public void constructorModelAndAppendableNull() {

    Appendable appendable = null;
    MarbleSolitaireModel model = null;

    MarbleSolitaireView view = new MarbleSolitaireTextView(model, appendable);

    view.toString();
  }

  // tests when model is null with valid appendable in the constructor
  @Test (expected = IllegalArgumentException.class)
  public void constructorModelNullValidAppendable() {

    Appendable appendable = new StringBuilder();
    MarbleSolitaireModel model = null;

    MarbleSolitaireView view = new MarbleSolitaireTextView(model, appendable);

    view.toString();
  }

  // tests renderBoard appends to appendable correctly
  @Test
  public void testRenderBoard() throws IOException {

    Appendable appendable = new StringBuilder();
    MarbleSolitaireTextView boardView = new MarbleSolitaireTextView(englishDefault, appendable);


    boardView.renderBoard();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", appendable.toString());
  }

  // tests renderMessage appends a message to appendable correctly
  @Test
  public void testRenderMessage() throws IOException {

    Appendable appendable = new StringBuilder();
    MarbleSolitaireTextView boardView = new MarbleSolitaireTextView(englishDefault, appendable);
    String message = "test message";

    boardView.renderMessage(message);
    assertEquals("test message", appendable.toString());
  }

}