package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.MarbleSolitaireModelState;

/**
 * This class represents the 2D array board in a String. Three characters represent
 * the different SlotStates: "o" for a marble, "_" for an empty space, and " " for an invalid space.
 */
public class MarbleSolitaireTextView extends AbstractSolitaireView {


  /**
   * Constructor for the MarbleSolitaireTextView class. The output for this constructor is
   * the console.
   *
   * @param modelState The current state of the board
   * @throws IllegalArgumentException if the model is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState modelState) {

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
  public MarbleSolitaireTextView(MarbleSolitaireModelState modelState, Appendable appendable) {

    super(modelState, appendable);

  }

  @Override
  public String toString() {

    //local variable so the StringBuilder does not just append the new state onto the previous one
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < modelState.getBoardSize(); i++) {

      for (int j = 0; j < modelState.getBoardSize(); j++) {

        // append every enum first to stringBuilder
        sb.append(getSlotValue(modelState.getSlotAt(i, j)));

        // conditional for a linebreak
        if (1 < modelState.getBoardSize()) {
          if ((i < modelState.getBoardSize() - 1
                  && j == modelState.getBoardSize() - 1)
                  || (MarbleSolitaireModelState.SlotState.Invalid
                  == modelState.getSlotAt(i, j + 1)
                  && MarbleSolitaireModelState.SlotState.Invalid != modelState.getSlotAt(i, j))) {
            sb.append("\n");
            break;
          }
          if (modelState.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Invalid)) {
            sb.append("  ");
          } else {
            // add a space between everything else
            sb.append(" ");
          }
        }
      }
    }
    // delete last line break
    if (modelState.getBoardSize() > 1) {
      sb.delete((sb.length() - 1), sb.length());
    }
    return sb.toString();
  }
}