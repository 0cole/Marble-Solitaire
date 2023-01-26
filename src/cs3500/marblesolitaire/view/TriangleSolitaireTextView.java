package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.MarbleSolitaireModelState;

/**
 * This class represents the 2D array board in a String. Three characters represent
 * the different SlotStates: "o" for a marble, "_" for an empty space, and " " for an invalid space.
 */
public class TriangleSolitaireTextView extends AbstractSolitaireView {

  /**
   * Constructor for the MarbleSolitaireTextView class. The output for this constructor is
   * the console.
   *
   * @param modelState The current state of the board
   * @throws IllegalArgumentException if the model is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState modelState) {

    super(modelState);

  }

  /**
   * Constructor for the MarbleSolitaireTextView class. The output for this constructor is
   * unspecified.
   *
   * @param modelState the current state of the marble solitaire board
   * @param appendable the destination of the textView class
   * @throws IllegalArgumentException if modelState are null
   * @throws IllegalArgumentException if appendable are null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState modelState, Appendable appendable) {

    super(modelState, appendable);

  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < modelState.getBoardSize(); i++) {
      int marbles = i + 1;

      // spaces before marbles
      for (int j = 0; j < modelState.getBoardSize() - marbles; j++) {
        sb.append(" ");
      }

      //add the marbles and empty and spaces
      for (int j = 0; j < marbles; j++) {
        if (j != (marbles - 1)
                && !(modelState.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Invalid)
                && !(modelState.getSlotAt(i, j + 1).equals(
                        MarbleSolitaireModelState.SlotState.Invalid)))) {
          sb.append(getSlotValue(modelState.getSlotAt(i, j)));
          sb.append(" ");
        } else {
          sb.append(getSlotValue(modelState.getSlotAt(i, j)));
        }
      }
      if (i != modelState.getBoardSize() - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }
}
