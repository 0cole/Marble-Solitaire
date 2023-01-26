package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.BetterModel.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link MarbleSolitaireTextView}.
 */
public class EuropeanSolitaireTextViewTest {


  EuropeanSolitaireModel europeanDefault = new EuropeanSolitaireModel();
  EuropeanSolitaireModel europeanModelArmFive = new EuropeanSolitaireModel(5);
  EuropeanSolitaireModel europeanModelArmOne = new EuropeanSolitaireModel(1);
  EuropeanSolitaireModel europeanEmptyPosition = new EuropeanSolitaireModel(1,5);
  EuropeanSolitaireModel europeanModelArmFiveEmptyPosition = new EuropeanSolitaireModel(5,4,4);


  @Test
  public void testToStringDefault() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(europeanDefault);

    assertEquals("    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O", board.toString());
  }

  @Test
  public void testToStringArmFive() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(europeanModelArmFive);

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", board.toString());
  }

  @Test
  public void testToStringArmOne() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(europeanModelArmOne);

    assertEquals("_", board.toString());
  }

  @Test
  public void testToStringEmptyPosition() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(europeanEmptyPosition);

    assertEquals("    O O O\n" +
            "  O O O O _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", board.toString());
  }

  @Test
  public void testToStringArmFiveEmptyPosition() {
    MarbleSolitaireTextView board = new MarbleSolitaireTextView(europeanModelArmFiveEmptyPosition);

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", board.toString());
  }

  @Test
  public void testMovesDefault() {

    MarbleSolitaireTextView board = new MarbleSolitaireTextView(europeanDefault);

    europeanDefault.move(1, 3, 3, 3);

    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", board.toString());
  }

  @Test
  public void testMovesEmptyPosition() {

    MarbleSolitaireTextView board = new MarbleSolitaireTextView(europeanEmptyPosition);

    europeanEmptyPosition.move(1, 3, 1, 5);

    assertEquals("    O O O\n" +
            "  O O _ _ O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", board.toString());
  }

  @Test
  public void testTwoMoves() {

    MarbleSolitaireTextView board = new MarbleSolitaireTextView(europeanDefault);

    europeanDefault.move(1, 3, 3, 3);
    europeanDefault.move(2, 1, 2, 3);

    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", board.toString());
  }

  // tests when appendable is null in the constructor
  @Test (expected = IllegalArgumentException.class)
  public void constructorAppendableNull() {

    MarbleSolitaireView view = new MarbleSolitaireTextView(europeanDefault, null);

    view.toString();
  }

  // tests when model and appendable are null in the constructor
  @Test (expected = IllegalArgumentException.class)
  public void constructorModelAndAppendableNull() {

    MarbleSolitaireView view = new MarbleSolitaireTextView(null, null);

    view.toString();
  }

  // tests when model is null with valid appendable in the constructor
  @Test (expected = IllegalArgumentException.class)
  public void constructorModelNullValidAppendable() {

    Appendable appendable = new StringBuilder();

    MarbleSolitaireView view = new MarbleSolitaireTextView(null, appendable);

    view.toString();
  }

  // tests renderBoard appends to appendable correctly
  @Test
  public void testRenderBoard() throws IOException {

    Appendable appendable = new StringBuilder();
    MarbleSolitaireTextView boardView = new MarbleSolitaireTextView(europeanDefault, appendable);


    boardView.renderBoard();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", appendable.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {

    Appendable appendable = new StringBuilder();
    MarbleSolitaireTextView boardView = new MarbleSolitaireTextView(europeanDefault, appendable);
    String message = "test message";

    boardView.renderMessage(message);
    assertEquals("test message", appendable.toString());
  }

}