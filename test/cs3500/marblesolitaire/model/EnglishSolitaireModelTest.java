package cs3500.marblesolitaire.model;

import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.SimpleModel.EnglishSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link EnglishSolitaireModel}.
 */
public class EnglishSolitaireModelTest {

  EnglishSolitaireModel invalid;
  EnglishSolitaireModel constructorOne;
  EnglishSolitaireModel constructorTwo;
  EnglishSolitaireModel constructorThree;
  EnglishSolitaireModel constructorFour;
  EnglishSolitaireModel armThicknessOne;

  // init conditions for ModelTest
  @Before
  public void init() {
    constructorOne = new EnglishSolitaireModel();
    constructorTwo = new EnglishSolitaireModel(0, 4);
    constructorThree = new EnglishSolitaireModel(7);
    constructorFour = new EnglishSolitaireModel(5, 4, 7);
    armThicknessOne = new EnglishSolitaireModel(1);
  }


  // tests getSlotAt after the board is constructed
  @Test
  public void testGetSlotAtInitConditions() {

    // init tests
    // constructorOne
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorOne.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorOne.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructorOne.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructorTwo.getSlotAt(0, 0));

    // constructorTwo
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorTwo.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorTwo.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorTwo.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructorTwo.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructorTwo.getSlotAt(1, 1));

    // constructorThree
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorThree.getSlotAt(9, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorThree.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorThree.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructorThree.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructorThree.getSlotAt(3, 3));

    // constructorFour
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorFour.getSlotAt(4, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorFour.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorFour.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructorFour.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, constructorFour.getSlotAt(3, 3));

    // armThicknessOne
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, armThicknessOne.getSlotAt(0, 0));
  }

  // exception when row > getBoardSize
  @Test(expected = IllegalArgumentException.class)
  public void testsRowGreaterThanBoardLength() {

    invalid = new EnglishSolitaireModel(10, 3);
  }

  // exception when col > getBoardSize
  @Test(expected = IllegalArgumentException.class)
  public void testsColGreaterThanBoardLength() {

    invalid = new EnglishSolitaireModel(3, 10);
  }

  // exception when row && col > getBoardSize
  @Test(expected = IllegalArgumentException.class)
  public void testsRowAndsColGreaterThanBoardLength() {

    invalid = new EnglishSolitaireModel(10, 10);
  }

  // exception when row < 0
  @Test(expected = IllegalArgumentException.class)
  public void testsRowLessThanZero() {

    invalid = new EnglishSolitaireModel(-3, 3);
  }

  // exception when col < 0
  @Test(expected = IllegalArgumentException.class)
  public void testsColLessThanZero() {

    invalid = new EnglishSolitaireModel(3, -3);
  }

  // exception when row && col < 0
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidsRowAndsColLessThanZero() {

    invalid = new EnglishSolitaireModel(-3, -3);
  }

  // exception when negative odd armThickness
  @Test(expected = IllegalArgumentException.class)
  public void testsNegativeOddArmThickness() {

    invalid = new EnglishSolitaireModel(-3);
  }

  // exception when row && col < 0 armThickness is five
  @Test(expected = IllegalArgumentException.class)
  public void testRowAndsColLessThanZeroArmThicknessFive() {

    invalid = new EnglishSolitaireModel(5, -3, -3);
  }

  // exception when (sRow, sCol) is already SlotState.invalid
  @Test(expected = IllegalArgumentException.class)
  public void testEmptySpaceIsInvalid() {

    invalid = new EnglishSolitaireModel(0, 0);
  }

  // exception when (sRow, sCol) is already SlotState.invalid armThickness is five
  @Test(expected = IllegalArgumentException.class)
  public void testEmptySpaceIsInvalidArmThicknessFive() {

    invalid = new EnglishSolitaireModel(5, 2, 2);
  }

  // exception when armThickness is negative and odd
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeNegativeOddArmThickness() {

    invalid = new EnglishSolitaireModel(-3);
  }

  // exception when armThickness is negative and odd with empty position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeNegativeOddArmThicknessEmpty() {

    invalid = new EnglishSolitaireModel(-3, 3, 3);
  }

  // exception when armThickness is negative and even
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeNegativeEvenArmThickness() {

    invalid = new EnglishSolitaireModel(-4);
  }

  // exception when armThickness is negative and even with empty position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeNegativeEvenArmThicknessEmpty() {

    invalid = new EnglishSolitaireModel(-4, 3, 3);
  }

  // exception when armThickness is positive and even
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializePositiveEvenArmThickness() {

    invalid = new EnglishSolitaireModel(4);
  }

  // exception when armThickness is positive and even with empty position
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializePositiveEvenArmThicknessEmpty() {

    invalid = new EnglishSolitaireModel(4, 3, 3);
  }

  // tests the initial score and then tests the score after a few moves
  @Test
  public void testGetScore() {

    // init tests
    assertEquals(32, constructorOne.getScore());
    assertEquals(216, constructorThree.getScore());
    assertEquals(104, constructorFour.getScore());
    assertEquals(0, armThicknessOne.getScore());

    // one move
    constructorOne.move(3, 5, 3, 3);
    assertEquals(31, constructorOne.getScore());

    // two moves
    constructorOne.move(1, 4, 3, 4);
    assertEquals(30, constructorOne.getScore());
  }

  // tests the getSlotAt the to and from positions before and after a move
  @Test
  public void testMove() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorOne.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorOne.getSlotAt(5, 3));
    constructorOne.move(5, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorOne.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorOne.getSlotAt(5, 3));
  }

  // exception for a one space invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveOneSpace() {

    constructorOne.move(2,3,3,3);
  }

  // exception for a three space invalid move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveThreeSpaces() {

    constructorOne.move(0,3,3,3);
  }

  //exception for diagonal move
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonal() {

    constructorOne.move(3, 5, 3, 3);
    constructorOne.move(1, 3, 3, 5);
  }

  // exception when to position is a Marble
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToPositionIsMarble() {

    constructorOne.move(2, 0, 2, 2);
  }

  // exception when to position is an Invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToPositionIsInvalid() {

    constructorOne.move(2, 0, 0, 0);
  }

  // exception when from position is an Empty
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFromPositionIsEmpty() {

    constructorOne.move(5, 3, 3, 3);
    constructorOne.move(2, 3, 4, 3);
    constructorOne.move(5, 3, 3, 3);
  }

  // exception when from position is an Invalid
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFromPositionIsInvalid() {

    constructorOne.move(1, 3, 3, 3);
    constructorOne.move(1, 1, 1, 3);
  }

  // exception when middle position is an Empty
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveNeighborIsEmpty() {

    constructorOne.move(1, 3, 3, 3);
    constructorOne.move(0, 3, 2, 3);
  }

  // exception when move is valid but out of bounds
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveOffBoard() {

    constructorOne.move(10, 10, 10, 8);
  }

  // exception when getSlotAt input is out of bounds positive
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlotAtInvalidPositive() {

    constructorOne.getSlotAt(10,10);
  }

  // exception when getSlotAt input is out of bounds negative
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlotAtInvalidNegative() {

    constructorOne.getSlotAt(-10,-10);
  }

  // board lengths for different armThicknesses
  @Test
  public void testGetBoardSize() {

    // init tests
    assertEquals(7, constructorOne.getBoardSize());
    assertEquals(19, constructorThree.getBoardSize());
    assertEquals(13, constructorFour.getBoardSize());
    assertEquals(1, armThicknessOne.getBoardSize());
  }

  // tests getScore after the game is one
  @Test
  public void testWinGetScore() {

    EnglishSolitaireModel modelState = new EnglishSolitaireModel();

    assertEquals(32, modelState.getScore());
    modelState.move(3, 5, 3, 3);
    assertEquals(31, modelState.getScore());
    modelState.move(1, 4, 3, 4);
    assertEquals(30, modelState.getScore());
    modelState.move(2, 6, 2, 4);
    assertEquals(29, modelState.getScore());
    modelState.move(4, 6, 2, 6);
    assertEquals(28, modelState.getScore());
    modelState.move(2, 3, 2, 5);
    assertEquals(27, modelState.getScore());
    modelState.move(2, 6, 2, 4);
    assertEquals(26, modelState.getScore());
    modelState.move(2, 1, 2, 3);
    assertEquals(25, modelState.getScore());
    modelState.move(0, 2, 2, 2);
    assertEquals(24, modelState.getScore());
    modelState.move(0, 4, 0, 2);
    assertEquals(23, modelState.getScore());
    modelState.move(3, 2, 1, 2);
    assertEquals(22, modelState.getScore());
    modelState.move(0, 2, 2, 2);
    assertEquals(21, modelState.getScore());
    modelState.move(5, 2, 3, 2);
    assertEquals(20, modelState.getScore());
    modelState.move(4, 0, 4, 2);
    assertEquals(19, modelState.getScore());
    modelState.move(2, 0, 4, 0);
    assertEquals(18, modelState.getScore());
    modelState.move(4, 3, 4, 1);
    assertEquals(17, modelState.getScore());
    modelState.move(4, 5, 4, 3);
    assertEquals(16, modelState.getScore());
    modelState.move(6, 4, 4, 4);
    assertEquals(15, modelState.getScore());
    modelState.move(6, 2, 6, 4);
    assertEquals(14, modelState.getScore());
    modelState.move(3, 4, 5, 4);
    assertEquals(13, modelState.getScore());
    modelState.move(6, 4, 4, 4);
    assertEquals(12, modelState.getScore());
    modelState.move(4, 0, 4, 2);
    assertEquals(11, modelState.getScore());
    modelState.move(3, 2, 1, 2);
    assertEquals(10, modelState.getScore());
    modelState.move(1, 2, 1, 4);
    assertEquals(9, modelState.getScore());
    modelState.move(1, 4, 3, 4);
    assertEquals(8, modelState.getScore());
    modelState.move(3, 4, 5, 4);
    assertEquals(7, modelState.getScore());
    modelState.move(5, 4, 5, 2);
    assertEquals(6, modelState.getScore());
    modelState.move(5, 2, 3, 2);
    assertEquals(5, modelState.getScore());
    modelState.move(3, 3, 1, 3);
    assertEquals(4, modelState.getScore());
    modelState.move(3, 1, 3, 3);
    assertEquals(3, modelState.getScore());
    modelState.move(4, 3, 2, 3);
    assertEquals(2, modelState.getScore());
    modelState.move(1, 3, 3, 3);

    // getScore with one marble left
    assertEquals(1, modelState.getScore());
  }

  // tests for each type of SlotState after the game is won
  @Test
  public void testWinGetSlotAt() {

    EnglishSolitaireModel modelState = new EnglishSolitaireModel();

    modelState.move(3, 5, 3, 3);
    modelState.move(1, 4, 3, 4);
    modelState.move(2, 6, 2, 4);
    modelState.move(4, 6, 2, 6);
    modelState.move(2, 3, 2, 5);
    modelState.move(2, 6, 2, 4);
    modelState.move(2, 1, 2, 3);
    modelState.move(0, 2, 2, 2);
    modelState.move(0, 4, 0, 2);
    modelState.move(3, 2, 1, 2);
    modelState.move(0, 2, 2, 2);
    modelState.move(5, 2, 3, 2);
    modelState.move(4, 0, 4, 2);
    modelState.move(2, 0, 4, 0);
    modelState.move(4, 3, 4, 1);
    modelState.move(4, 5, 4, 3);
    modelState.move(6, 4, 4, 4);
    modelState.move(6, 2, 6, 4);
    modelState.move(3, 4, 5, 4);
    modelState.move(6, 4, 4, 4);
    modelState.move(4, 0, 4, 2);
    modelState.move(3, 2, 1, 2);
    modelState.move(1, 2, 1, 4);
    modelState.move(1, 4, 3, 4);
    modelState.move(3, 4, 5, 4);
    modelState.move(5, 4, 5, 2);
    modelState.move(5, 2, 3, 2);
    modelState.move(3, 3, 1, 3);
    modelState.move(3, 1, 3, 3);
    modelState.move(4, 3, 2, 3);
    modelState.move(1, 3, 3, 3);

    // last marble
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, modelState.getSlotAt(3, 3));

    // empty
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, modelState.getSlotAt(2, 2));

    // invalid
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, modelState.getSlotAt(1, 1));

  }

  // tests isGameOver for all the moves and when there is one marble left
  @Test
  public void testWinIsGameOver() {

    EnglishSolitaireModel modelState = new EnglishSolitaireModel();

    modelState.move(3, 5, 3, 3);
    assertFalse(modelState.isGameOver());
    modelState.move(1, 4, 3, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(2, 6, 2, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(4, 6, 2, 6);
    assertFalse(modelState.isGameOver());
    modelState.move(2, 3, 2, 5);
    assertFalse(modelState.isGameOver());
    modelState.move(2, 6, 2, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(2, 1, 2, 3);
    assertFalse(modelState.isGameOver());
    modelState.move(0, 2, 2, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(0, 4, 0, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(3, 2, 1, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(0, 2, 2, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(5, 2, 3, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(4, 0, 4, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(2, 0, 4, 0);
    assertFalse(modelState.isGameOver());
    modelState.move(4, 3, 4, 1);
    assertFalse(modelState.isGameOver());
    modelState.move(4, 5, 4, 3);
    assertFalse(modelState.isGameOver());
    modelState.move(6, 4, 4, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(6, 2, 6, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(3, 4, 5, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(6, 4, 4, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(4, 0, 4, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(3, 2, 1, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(1, 2, 1, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(1, 4, 3, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(3, 4, 5, 4);
    assertFalse(modelState.isGameOver());
    modelState.move(5, 4, 5, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(5, 2, 3, 2);
    assertFalse(modelState.isGameOver());
    modelState.move(3, 3, 1, 3);
    assertFalse(modelState.isGameOver());
    modelState.move(3, 1, 3, 3);
    assertFalse(modelState.isGameOver());
    modelState.move(4, 3, 2, 3);
    assertFalse(modelState.isGameOver());
    modelState.move(1, 3, 3, 3);

    // isGameOver
    assertTrue(modelState.isGameOver());
  }

  // tests isGmeOver for when there is more than one marble left on the board but no more moves
  // are possible
  @Test
  public void testLoseIsGameOver() {

    constructorOne.move(3, 5, 3, 3);
    constructorOne.move(3, 2, 3, 4);
    constructorOne.move(3, 0, 3, 2);
    constructorOne.move(5, 3, 3, 3);
    constructorOne.move(4, 1, 4, 3);
    constructorOne.move(4, 4, 4, 2);
    constructorOne.move(6, 4, 4, 4);
    constructorOne.move(4, 5, 4, 3);
    constructorOne.move(4, 2, 4, 4);
    constructorOne.move(6, 2, 4, 2);
    constructorOne.move(3, 2, 5, 2);
    constructorOne.move(3, 4, 5, 4);
    constructorOne.move(1, 2, 3, 2);
    constructorOne.move(1, 4, 3, 4);
    constructorOne.move(2, 0, 2, 2);
    constructorOne.move(2, 6, 2, 4);
    constructorOne.move(4, 6, 2, 6);
    constructorOne.move(3, 2, 1, 2);
    constructorOne.move(3, 4, 1, 4);
    constructorOne.move(0, 2, 2, 2);
    constructorOne.move(0, 4, 2, 4);
    constructorOne.move(2, 3, 4, 3);
    constructorOne.move(0, 3, 2, 3);
    constructorOne.move(2, 3, 2, 1);

    assertTrue(this.constructorOne.isGameOver());
  }

  // cases when isGameOver returns false
  @Test
  public void testIsGameOverFalse() {

    assertFalse(constructorOne.isGameOver());
    constructorOne.move(5, 3, 3, 3);
    assertFalse(constructorOne.isGameOver());
  }

  // tests isGameOver for an armThickness one
  @Test
  public void testIsGameOverArmOne() {

    assertTrue(armThicknessOne.isGameOver());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlotAt() {

    invalid = new EnglishSolitaireModel();

    invalid.getSlotAt(10,10);
    invalid.getSlotAt(-1,-1);
    invalid.getSlotAt(5,-1);
  }
}