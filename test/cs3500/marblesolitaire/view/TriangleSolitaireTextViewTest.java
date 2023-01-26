package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.BetterModel.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link TriangleSolitaireTextView}.
 */
public class TriangleSolitaireTextViewTest {


  TriangleSolitaireModel triangleDefault = new TriangleSolitaireModel();
  TriangleSolitaireModel triangleSizeNine = new TriangleSolitaireModel(9);
  TriangleSolitaireModel triangleSizeOne = new TriangleSolitaireModel(1);
  TriangleSolitaireModel triangleHoleFourFour = new TriangleSolitaireModel(4,4);

  @Test
  public void testToStringDefault() {
    TriangleSolitaireTextView board = new TriangleSolitaireTextView(triangleDefault);

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", board.toString());
  }

  @Test
  public void testToStringSizeNine() {
    TriangleSolitaireTextView board = new TriangleSolitaireTextView(triangleSizeNine);

    assertEquals("        _\n" +
            "       O O\n" +
            "      O O O\n" +
            "     O O O O\n" +
            "    O O O O O\n" +
            "   O O O O O O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O", board.toString());
  }

  @Test
  public void testToStringSizeOne() {
    TriangleSolitaireTextView board = new TriangleSolitaireTextView(triangleSizeOne);

    assertEquals("_", board.toString());
  }

  @Test
  public void testToStringHoleFourFour() {
    TriangleSolitaireTextView board = new TriangleSolitaireTextView(triangleHoleFourFour);

    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O _", board.toString());
  }


  @Test
  public void testMovesDefault() {

    TriangleSolitaireTextView board = new TriangleSolitaireTextView(triangleDefault);

    triangleDefault.move(2, 2, 0, 0);

    assertEquals("    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", board.toString());
  }

  @Test
  public void testMoveHole() {

    TriangleSolitaireTextView board = new TriangleSolitaireTextView(triangleHoleFourFour);

    triangleHoleFourFour.move(2, 2, 4, 4);

    assertEquals("    O\n" +
            "   O O\n" +
            "  O O _\n" +
            " O O O _\n" +
            "O O O O O", board.toString());
  }

  @Test
  public void testTwoMoves() {

    TriangleSolitaireTextView board = new TriangleSolitaireTextView(triangleDefault);

    triangleDefault.move(2, 2, 0, 0);
    triangleDefault.move(2, 0, 2, 2);

    assertEquals("    O\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " O O O O\n" +
            "O O O O O", board.toString());
  }

  // tests when appendable is null in the constructor
  @Test (expected = IllegalArgumentException.class)
  public void constructorAppendableNull() {

    MarbleSolitaireView view = new TriangleSolitaireTextView(triangleDefault, null);

    view.toString();
  }

  // tests when model and appendable are null in the constructor
  @Test (expected = IllegalArgumentException.class)
  public void constructorModelAndAppendableNull() {

    MarbleSolitaireView view = new TriangleSolitaireTextView(null, null);

    view.toString();
  }

  // tests when model is null with valid appendable in the constructor
  @Test (expected = IllegalArgumentException.class)
  public void constructorModelNullValidAppendable() {

    Appendable appendable = new StringBuilder();

    MarbleSolitaireView view = new TriangleSolitaireTextView(null, appendable);

    view.toString();
  }

  // tests renderBoard appends to appendable correctly
  @Test
  public void testRenderBoard() throws IOException {

    Appendable appendable = new StringBuilder();
    TriangleSolitaireTextView boardView =
            new TriangleSolitaireTextView(triangleDefault, appendable);


    boardView.renderBoard();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", appendable.toString());
  }

  @Test
  public void testRenderMessage() throws IOException {

    Appendable appendable = new StringBuilder();
    TriangleSolitaireTextView boardView =
            new TriangleSolitaireTextView(triangleDefault, appendable);
    String message = "test message";

    boardView.renderMessage(message);
    assertEquals("test message", appendable.toString());
  }


}