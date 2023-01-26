package cs3500.marblesolitaire.model.SimpleModel;

import cs3500.marblesolitaire.model.BetterModel.AbstractSolitaireModel;

/**
 * This class initializes the board and contains functions from the MarbleSolitaireModel interface
 * as well as functions from the MarbleSolitaireModelState interface.
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {


  /**
   * Constructor that takes no parameters and outputs a board with armThickness 3 and
   * an empty space at (3,3).
   */
  public EnglishSolitaireModel() {

    this(3,3,3);

  }

  /**
   * Constructor that takes two parameters (sRow, sCol) and outputs a board with armThickness 3
   * and an empty space at (sRow,sCol).
   *
   * @param sRow the empty space's row value
   * @param sCol the empty space's column value
   * @throws IllegalArgumentException if sRow or sCol is negative
   * @throws IllegalArgumentException if sRow or sCol is greater than the board size
   * @throws IllegalArgumentException if the proposed empty space already is a SlotState.Invalid
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {

    this(3,sRow,sCol);

  }

  /**
   * Constructor that takes in one parameter (armThickness), and outputs a board with an
   * armThickness determined by the input, and an empty space in the middle of the board
   * using the formula ((armThickness * 3 - 2 )/ 2).
   *
   * @param armThickness the armThickness of the board
   * @throws IllegalArgumentException if the armThickness is not positive OR not odd
   * @throws IllegalArgumentException if the proposed empty space already is a SlotState.Invalid
   **/
  // CONSTRUCTOR THREE
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {

    this(armThickness,(armThickness * 3 - 2) / 2,(armThickness * 3 - 2) / 2);

  }

  /**
   * Constructor that takes in three parameters (armThickness, row, col), and outputs a board
   * based on those parameters. Calls to the abstract constructor which creates and populates the
   * SlotSpaces on the board.
   *
   * @param armThickness the armThickness of the board
   * @param sRow         the empty space's row value
   * @param sCol         the empty space's column value
   * @throws IllegalArgumentException if the armThickness is not positive
   * @throws IllegalArgumentException if sRow or sCol is negative
   * @throws IllegalArgumentException if sRow or sCol is greater than the board size
   * @throws IllegalArgumentException if the proposed empty space already is a SlotState.Invalid
   */
  // CONSTRUCTOR FOUR
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    super(armThickness, sRow, sCol);

    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("armThickness is not odd");
    }

  }

  /**
   * Determines the validity of a position at (row, col).
   * @param row the vertical coordinate of the position
   * @param col the horizontal coordinate of the position
   * @return true if the position is invalid and false if the position is either marble or empty
   */
  protected boolean isPositionInvalid(int row, int col) {
    return (row < armThickness - 1
            && ((col < armThickness - 1)
            || (col >= armThickness * 2 - 1)))
            || (row >= armThickness * 2 - 1
            && ((col < armThickness - 1)
            || (col >= armThickness * 2 - 1)));
  }

  @Override
  public int getBoardSize() {
    return armThickness * 3 - 2;
  }

}