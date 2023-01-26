package cs3500.marblesolitaire.model.BetterModel;

/**
 * This class initializes a triangle game board and contains functions from the MarbleSolitaireModel
 * interface as well as functions from the MarbleSolitaireModelState interface.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  /**
   * Constructor that takes no parameters and outputs a board with armThickness 5 and
   * an empty space at (0,0).
   */
  public TriangleSolitaireModel() {

    this(5,0,0);

  }

  /**
   * Constructor that takes in one parameter (armThickness), and outputs a board with an
   * armThickness determined by the input, and an empty space in the middle of the board
   * using the formula (boardLength / 2).
   *
   * @param armThickness the armThickness of the board
   * @throws IllegalArgumentException if the armThickness is not positive
   * @throws IllegalArgumentException if the proposed empty space already is a SlotState.Invalid
   **/
  public TriangleSolitaireModel(int armThickness) throws IllegalArgumentException {

    this(armThickness,0,0);

  }

  /**
   * Constructor that takes two parameters (row, col) and outputs a board with armThickness 3
   * and an empty space at (sRow,sCol).
   *
   * @param row the empty space's row value
   * @param col the empty space's column value
   * @throws IllegalArgumentException if sRow or sCol is negative
   * @throws IllegalArgumentException if sRow or sCol is greater than the board size
   * @throws IllegalArgumentException if the proposed empty space already is a SlotState.Invalid
   */
  public TriangleSolitaireModel(int row, int col) throws IllegalArgumentException {

    this(5,row,col);

  }

  /**
   * Constructor that takes in three parameters (armThickness, row, col), and outputs a board
   * based on those parameters. Calls to the abstract constructor which creates and populates the
   * SlotSpaces on the board.
   *
   * @param armThickness the armThickness of the board
   * @param row         the empty space's row value
   * @param col         the empty space's column value
   * @throws IllegalArgumentException if the armThickness is not positive
   * @throws IllegalArgumentException if sRow or sCol is negative
   * @throws IllegalArgumentException if sRow or sCol is greater than the board size
   * @throws IllegalArgumentException if the proposed empty space already is a SlotState.Invalid
   */
  public TriangleSolitaireModel(int armThickness, int row, int col)
          throws IllegalArgumentException {

    super(armThickness,row,col);

    if (armThickness < 1) {
      throw new IllegalArgumentException("specified dimension is non-positive");
    }
  }

  /**
   * Determines the validity of a position at (row, col).
   * @param row the vertical coordinate of the position
   * @param col the horizontal coordinate of the position
   * @return true if the position is invalid and false if the position is either marble or empty
   */
  protected boolean isPositionInvalid(int row, int col) {
    return row < col;
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

    if (fromRow < 0
            || fromCol < 0
            || toRow < 0
            || toCol < 0
            || (fromRow >= getBoardSize())
            || (fromCol >= getBoardSize())
            || (toCol >= getBoardSize())
            || (toRow >= getBoardSize())) {
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

    // CHANGED

    // spot being skipped is not a marble
    if (((fromRow - toRow == 0
            && fromCol - toCol == 2) && this.getSlotAt(fromRow, fromCol - 1) != SlotState.Marble)
            || ((fromRow - toRow == 0
            && fromCol - toCol == -2) && this.getSlotAt(fromRow, fromCol + 1) != SlotState.Marble)
            || ((fromCol - toCol == 0
            && fromRow - toRow == 2) && this.getSlotAt(fromRow - 1, fromCol) != SlotState.Marble)
            || ((fromCol - toCol == 0
            && fromRow - toRow == -2) && this.getSlotAt(fromRow + 1, fromCol) != SlotState.Marble)
            || ((fromCol - toCol == 2
            && fromRow - toRow == 2) && this.getSlotAt(fromRow - 1, fromCol - 1)
            != SlotState.Marble)
            || ((fromCol - toCol == 2
            && fromRow - toRow == -2) && this.getSlotAt(fromRow + 1, fromCol - 1)
            != SlotState.Marble)
            || ((fromCol - toCol == -2
            && fromRow - toRow == 2) && this.getSlotAt(fromRow - 1, fromCol + 1)
            != SlotState.Marble)
            || ((fromCol - toCol == -2
            && fromRow - toRow == -2) && this.getSlotAt(fromRow + 1, fromCol + 1)
            != SlotState.Marble)) {
      return "Skipped over slot is not a marble";
    }

    if (Math.abs(fromRow - toRow) != 2
            && Math.abs(fromRow - toRow) != 0
            || (Math.abs(fromCol - toCol) != 2
            && (Math.abs(fromCol - toCol) != 0))) {
      return "Either row or col changes values by an int that is not 0 which is illegal";
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
      if (fromCol + 2 == toCol && fromRow == toRow) {
        this.board[toRow][toCol - 1] = SlotState.Empty;
      } else if (fromCol - 2 == toCol && fromRow == toRow) {
        this.board[toRow][toCol + 1] = SlotState.Empty;
      } else if (fromRow + 2 == toRow && fromCol == toCol) {
        this.board[toRow - 1][toCol] = SlotState.Empty;
      } else if (fromRow - 2 == toRow && fromCol == toCol) {
        this.board[toRow + 1][toCol] = SlotState.Empty;
      } else if (fromRow + 2 == toRow && fromCol + 2 == toCol) {
        this.board[toRow - 1][toCol - 1] = SlotState.Empty;
      } else if (fromRow + 2 == toRow && fromCol - 2 == toCol) {
        this.board[toRow - 1][toCol + 1] = SlotState.Empty;
      } else if (fromRow - 2 == toRow && fromCol + 2 == toCol) {
        this.board[toRow + 1][toCol - 1] = SlotState.Empty;
      } else if (fromRow - 2 == toRow && fromCol - 2 == toCol) {
        this.board[toRow + 1][toCol + 1] = SlotState.Empty;
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
      for (int i = 0; i < getBoardSize(); i++) {
        for (int j = 0; j < getBoardSize(); j++) {
          if (this.isMovePossible(i, j, i + 2, j).equals("true")
                  || (this.isMovePossible(i, j, i - 2, j).equals("true"))
                  || (this.isMovePossible(i, j, i, j + 2).equals("true"))
                  || (this.isMovePossible(i, j, i, j - 2).equals("true"))
                  || (this.isMovePossible(i, j, i + 2, j + 2).equals("true"))
                  || (this.isMovePossible(i, j, i + 2, j - 2).equals("true"))
                  || (this.isMovePossible(i, j, i - 2, j + 2).equals("true"))
                  || (this.isMovePossible(i, j, i - 2, j - 2).equals("true"))) {
            return false;
          }
        }
      }
    }
    // returns true if there are not any moves left AND more than one marble left
    return true;
  }

  @Override
  public int getBoardSize() {
    return armThickness;
  }
}
