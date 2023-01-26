package cs3500.marblesolitaire.model.BetterModel;

import cs3500.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This is the abstract class that each Model type inherits and uses when creating the model.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {

  protected int armThickness;
  protected SlotState[][] board;

  /**
   * Constructor that takes in three parameters (armThickness, sRow, sCol), and outputs a board
   * based on those parameters. Creates a current score using the formula
   * ((armThickness * (armThickness - 1) * 4) + (armThickness * armThickness) - 1). Populates the
   * SlotSpaces on the board.
   *
   * @param armThickness the armThickness of the board
   * @param sRow         the empty space's row value
   * @param sCol         the empty space's column value
   * @throws IllegalArgumentException if the armThickness is not positive OR not odd
   * @throws IllegalArgumentException if sRow or sCol is negative
   * @throws IllegalArgumentException if sRow or sCol is greater than the board size
   * @throws IllegalArgumentException if the proposed empty space already is a SlotState.Invalid
   */
  public AbstractSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    this.armThickness = armThickness;

    try {
      this.board = new SlotState[getBoardSize()][getBoardSize()];
    } catch (NegativeArraySizeException e) {
      throw new IllegalArgumentException("armThickness is not positive");
    }

    this.populate();

    if (sRow > getBoardSize() - 1 || sCol > getBoardSize() - 1 || sRow < 0 || sCol < 0) {
      throw new IllegalArgumentException("Row or Column for empty space not within the armThickness"
              + " of the board");
    }

    // exception if empty space input is already a SlotState.Invalid
    if (this.board[sRow][sCol].equals(SlotState.Invalid)) {
      throw new IllegalArgumentException("Proposed empty space is invalid");
    }

    this.board[sRow][sCol] = SlotState.Empty;

  }

  /**
   * Determines the validity of a position at (row, col).
   *
   * @param row the vertical coordinate of the position
   * @param col the horizontal coordinate of the position
   * @return true if the position is invalid and false if the position is either marble or empty
   */
  protected abstract boolean isPositionInvalid(int row, int col);

  /**
   * Populates each slot on the board with its corresponding SlotState enum.
   */
  private void populate() {
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (isPositionInvalid(i, j)) {
          this.board[i][j] = SlotState.Invalid;
        } else {
          this.board[i][j] = SlotState.Marble;
        }
      }
    }
  }


  /**
   * Runs exception cases from move to return a string based on whether the move is possible or not.
   *
   * @param fromRow the original row of the marble SlotState
   * @param fromCol the original column of the marble SlotState
   * @param toRow   the proposed new row of the marble SlotState
   * @param toCol   the proposed new row of the marble SlotState
   * @return the string "true" if the move is possible and a custom message if the move is not
   *         possible explaining the reason why the move isn't possible.
   */
  private String isMovePossible(int fromRow, int fromCol, int toRow, int toCol) {

    //EXCEPTIONS FOR MOVE
    // if any input is off board
    if (fromRow < 0
            || fromCol < 0
            || toRow < 0
            || toCol < 0
            || (fromRow > getBoardSize() - 1)
            || (fromCol > getBoardSize() - 1)
            || (toCol > getBoardSize() - 1)
            || (toRow > getBoardSize() - 1)) {
      return "Proposed move has invalid positions";
    }
    // to space isn't empty
    if (this.getSlotAt(toRow, toCol) != SlotState.Empty) {
      return "toSlotState isn't empty";
    }
    // from space isn't marble
    if (this.getSlotAt(fromRow, fromCol) != SlotState.Marble) {
      return "fromSlotState isn't marble";
    }
    // to space isn't two away or is diagonal
    if (!(fromRow == toRow
            && (Math.abs(fromCol - toCol)) == 2)
            && !(fromCol == toCol
            && (Math.abs(fromRow - toRow)) == 2)) {
      return "the to and from positions need to be exactly two "
              + "positions away, and can't be diagonal";
    }
    // spot being skipped is not a marble
    if (((fromRow == toRow
            && fromCol - toCol == 2) && this.getSlotAt(fromRow, fromCol - 1) != SlotState.Marble)
            || ((fromRow == toRow
            && fromCol - toCol == -2) && this.getSlotAt(fromRow, fromCol + 1) != SlotState.Marble)
            || ((fromCol == toCol
            && fromRow - toRow == 2) && this.getSlotAt(fromRow - 1, fromCol) != SlotState.Marble)
            || ((fromCol == toCol
            && fromRow - toRow == -2) && this.getSlotAt(fromRow + 1, fromCol)
            != SlotState.Marble)) {
      return "Skipped over slot is not a marble";
    }

    // when true
    // from row is two below the toRow
    // from row is two above the toRow
    // from col is two below the toCol
    // from col is two below the toCol
    if (fromRow == toRow + 2
            && getSlotAt(fromRow, fromCol) == SlotState.Marble
            && getSlotAt(fromRow - 1, fromCol) == SlotState.Marble
            && getSlotAt(toRow, toCol) == SlotState.Empty
            || fromRow == toRow - 2
            && getSlotAt(fromRow, fromCol) == SlotState.Marble
            && getSlotAt(fromRow + 1, fromCol) == SlotState.Marble
            && getSlotAt(toRow, toCol) == SlotState.Empty
            || fromCol == toCol + 2
            && getSlotAt(fromRow, fromCol) == SlotState.Marble
            && getSlotAt(fromRow, fromCol - 1) == SlotState.Marble
            && getSlotAt(toRow, toCol) == SlotState.Empty
            || fromCol == toCol - 2
            && getSlotAt(fromRow, fromCol) == SlotState.Marble
            && getSlotAt(fromRow, fromCol + 1) == SlotState.Marble
            && getSlotAt(toRow, toCol) == SlotState.Empty) {
      return "true";
    }
    return "true";
  }


  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

    // exceptions in isMovePossible
    if (!(this.isMovePossible(fromRow, fromCol, toRow, toCol).equals("true"))) {
      throw new IllegalArgumentException(this.isMovePossible(fromRow, fromCol, toRow, toCol));
    }

    // if move is possible
    if (this.isMovePossible(fromRow, fromCol, toRow, toCol).equals("true")) {
      // to space becomes marble
      this.board[toRow][toCol] = (SlotState.Marble);
      // from space becomes empty
      this.board[fromRow][fromCol] = (SlotState.Empty);
      // in between space becomes empty
      if (fromCol + 2 == toCol) {
        this.board[toRow][toCol - 1] = SlotState.Empty;
      } else if (fromCol - 2 == toCol) {
        this.board[toRow][toCol + 1] = SlotState.Empty;
      } else if (fromRow + 2 == toRow) {
        this.board[toRow - 1][toCol] = SlotState.Empty;
      } else if (fromRow - 2 == toRow) {
        this.board[toRow + 1][toCol] = SlotState.Empty;
      }
    }
  }

  @Override
  public boolean isGameOver() {
    // one marble left
    if (getScore() <= 1) {
      return true;
      //there are still moves
    } else {
      for (int i = 0; i <= getBoardSize() - 1; i++) {
        for (int j = 0; j <= getBoardSize() - 1; j++) {
          if (this.isMovePossible(i, j, i + 2, j).equals("true")
                  || (this.isMovePossible(i, j, i - 2, j).equals("true"))
                  || (this.isMovePossible(i, j, i, j + 2).equals("true"))
                  || (this.isMovePossible(i, j, i, j - 2).equals("true"))) {
            return false;
          }
        }
      }
    }
    // returns true if there are not any moves left AND more than one marble left
    return true;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    // input is off the board
    if (row >= getBoardSize()
            || col >= getBoardSize()
            || row < 0
            || col < 0) {
      throw new IllegalArgumentException("Row or column value exceeds board length or "
              + "is less than zero");
    } else {
      return this.board[row][col];
    }
  }

  @Override
  public int getScore() {
    int currentScore;
    currentScore = 0;

    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (this.board[i][j].equals(SlotState.Marble)) {
          currentScore++;
        }
      }
    }
    return currentScore;
  }

}
