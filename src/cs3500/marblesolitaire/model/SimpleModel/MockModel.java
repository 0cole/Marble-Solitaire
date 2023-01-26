package cs3500.marblesolitaire.model.SimpleModel;

import java.io.IOException;
import java.util.Objects;

import cs3500.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This class is for the mockModel test.
 */
public class MockModel implements MarbleSolitaireModel {

  private final Appendable appendable;

  public MockModel(Appendable appendable) {
    this.appendable = Objects.requireNonNull(appendable);
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    try {
      this.appendable.append(fromRow + " " + fromCol + " " + toRow + " " + toCol + " " );
    } catch (IOException e) {
      throw new IllegalArgumentException("Appendable failed");
    }
  }

  @Override
  public boolean isGameOver() {
    try {
      this.appendable.append("");
    } catch (IOException e) {
      throw new IllegalArgumentException("Appendable failed");
    }
    return false;
  }

  @Override
  public int getBoardSize() {
    try {
      this.appendable.append("");
    } catch (IOException e) {
      throw new IllegalArgumentException("Appendable failed");
    }
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    try {
      this.appendable.append("");
    } catch (IOException e) {
      throw new IllegalArgumentException("Appendable failed");
    }
    return null;
  }

  @Override
  public int getScore() {
    try {
      this.appendable.append("");
    } catch (IOException e) {
      throw new IllegalArgumentException("Appendable failed");
    }
    return 0;
  }
}
