package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.MarbleSolitaireModelState;

/**
 * This is the abstract class that each game TextView type inherits and uses when creating the view.
 */
public abstract class AbstractSolitaireView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState modelState;

  protected Appendable appendable;

  /**
   * Constructor for the MarbleSolitaireTextView class. The output for this constructor is
   * the console.
   * @param modelState The current state of the board
   * @throws IllegalArgumentException if the model is null
   */
  public AbstractSolitaireView(MarbleSolitaireModelState modelState) {

    if (modelState == null) {
      throw new IllegalArgumentException("Model is null");
    }
    this.modelState = modelState;

    this.appendable = System.out;

  }

  /**
   * Constructor for the MarbleSolitaireTextView class. The output for this constructor is
   * unspecified.
   * @param modelState the current state of the marble solitaire board
   * @param appendable the destination of the textView class
   * @throws IllegalArgumentException if modelState are null
   * @throws IllegalArgumentException if appendable are null
   */
  public AbstractSolitaireView(MarbleSolitaireModelState modelState, Appendable appendable) {

    if (modelState == null) {
      throw new IllegalArgumentException("ModelState is null");
    }
    if (appendable == null) {
      throw new IllegalArgumentException("Appendable is null");
    }

    this.modelState = modelState;

    this.appendable = appendable;
  }


  /**
   * Assigns each SlotState its own corresponding String.
   *
   * @param slot the specific SlotState
   * @return the SlotState's string
   */
  protected String getSlotValue(MarbleSolitaireModelState.SlotState slot) {
    String value;
    value = "";
    // empty Slot = "_"
    if (slot.equals(MarbleSolitaireModelState.SlotState.Empty)) {
      value = "_";
      // marble Slot = "O"
    } else if (slot.equals(MarbleSolitaireModelState.SlotState.Marble)) {
      value = "O";
      // empty Slot = " "
    } else if (slot.equals(MarbleSolitaireModelState.SlotState.Invalid)) {
      value = "";
    }
    return value;
  }

  @Override
  public void renderBoard() throws IOException {
    this.appendable.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }
}
