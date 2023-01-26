package cs3500.marblesolitaire.model;

import org.junit.Test;

import cs3500.marblesolitaire.model.BetterModel.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link TriangleSolitaireModel}.
 */
public class TriangleSolitaireModelTest {

  TriangleSolitaireModel invalid;
  TriangleSolitaireModel constructorDefault = new TriangleSolitaireModel();
  TriangleSolitaireModel constructorSizeNine = new TriangleSolitaireModel(9);
  TriangleSolitaireModel constructorHoleFourFour = new TriangleSolitaireModel(4,4);
  TriangleSolitaireModel constructorSizeSixHoleFourFour = new TriangleSolitaireModel(6,4,4);

  @Test
  public void testGetSlotAtDefaultMarble() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(4,4));
  }

  @Test
  public void testGetSlotAtDefaultEmpty() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,constructorDefault.getSlotAt(0,0));
  }

  @Test
  public void testGetSlotAtDefaultInvalid() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(1,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(3,4));
  }

  @Test
  public void testGetSlotAtSizeNineMarble() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorSizeNine.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorSizeNine.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorSizeNine.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorSizeNine.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorSizeNine.getSlotAt(4,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorSizeNine.getSlotAt(5,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorSizeNine.getSlotAt(6,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorSizeNine.getSlotAt(7,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorSizeNine.getSlotAt(8,8));
  }

  @Test
  public void testGetSlotAtSizeNineEmpty() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,constructorSizeNine.getSlotAt(0,0));
  }

  @Test
  public void testGetSlotAtSizeNineInvalid() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorSizeNine.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorSizeNine.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorSizeNine.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorSizeNine.getSlotAt(0,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorSizeNine.getSlotAt(1,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorSizeNine.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorSizeNine.getSlotAt(3,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorSizeNine.getSlotAt(5,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorSizeNine.getSlotAt(7,8));
  }

  @Test
  public void testGetSlotAtHoleFourFourMarble() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorHoleFourFour.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorHoleFourFour.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorHoleFourFour.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorHoleFourFour.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorHoleFourFour.getSlotAt(3,3));
  }

  @Test
  public void testGetSlotAtHoleFourFourEmpty() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,constructorHoleFourFour.getSlotAt(4,4));
  }

  @Test
  public void testGetSlotAtHoleFourFourInvalid() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorHoleFourFour.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorHoleFourFour.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorHoleFourFour.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorHoleFourFour.getSlotAt(0,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorHoleFourFour.getSlotAt(1,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorHoleFourFour.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorHoleFourFour.getSlotAt(3,4));
  }

  @Test
  public void testGetSlotAtHoleSizeSixFourFourMarble() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorSizeSixHoleFourFour.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorSizeSixHoleFourFour.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorSizeSixHoleFourFour.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorSizeSixHoleFourFour.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorSizeSixHoleFourFour.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorSizeSixHoleFourFour.getSlotAt(4,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorSizeSixHoleFourFour.getSlotAt(5,5));
  }

  @Test
  public void testGetSlotAtHoleSizeSixFourFourEmpty() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,constructorHoleFourFour.getSlotAt(4,4));
  }

  @Test
  public void testGetSlotAtHoleSizeSixFourFourInvalid() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(0,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(0,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(0,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(1,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(3,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(3,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(3,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
            constructorSizeSixHoleFourFour.getSlotAt(4,5));
  }

  @Test
  public void testGetScoreConstructors() {
    assertEquals(14, constructorDefault.getScore());
    assertEquals(44, constructorSizeNine.getScore());
    assertEquals(14, constructorHoleFourFour.getScore());
    assertEquals(20, constructorSizeSixHoleFourFour.getScore());

  }

  @Test
  public void testGetScoreAfterOneMove() {
    assertEquals(14, constructorDefault.getScore());

    constructorDefault.move(2,0,0,0);

    assertEquals(13, constructorDefault.getScore());

    assertEquals(44, constructorSizeNine.getScore());

    constructorSizeNine.move(2,0,0,0);

    assertEquals(43, constructorSizeNine.getScore());
  }

  @Test
  public void testGetScoreAfterTwoMoves() {
    assertEquals(14, constructorDefault.getScore());

    constructorDefault.move(2,0,0,0);

    assertEquals(13, constructorDefault.getScore());

    constructorDefault.move(4,0,2,0);

    assertEquals(12, constructorDefault.getScore());


    assertEquals(44, constructorSizeNine.getScore());

    constructorSizeNine.move(2,0,0,0);

    assertEquals(43, constructorSizeNine.getScore());

    constructorSizeNine.move(4,0,2,0);

    assertEquals(42, constructorSizeNine.getScore());
  }

  @Test
  public void testIsGameOverFalse() {

    assertFalse(constructorDefault.isGameOver());
    constructorDefault.move(2, 2, 0, 0);
    assertFalse(constructorDefault.isGameOver());
  }

  @Test
  public void testMoveGetSlotAtRegular() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorDefault.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorDefault.getSlotAt(2,0));
    constructorDefault.move(2,0,0,0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorDefault.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(2,0));
  }

  @Test
  public void testMoveRegularDiagonalUpRight() {

    constructorDefault.move(2,0,0,0);

    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorDefault.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            constructorDefault.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            constructorDefault.getSlotAt(2,0));
  }

  @Test
  public void testMoveRegularDiagonalUpLeft() {

    constructorDefault.move(2,2,0,0);

    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorDefault.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            constructorDefault.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            constructorDefault.getSlotAt(2,2));
  }

  @Test
  public void testMoveRegularDiagonalDownRight() {
    constructorDefault.move(2,2,0,0);
    constructorDefault.move(4,2,2,2);
    constructorDefault.move(2,0,4,2);

    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorDefault.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            constructorDefault.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            constructorDefault.getSlotAt(2,0));
  }

  @Test
  public void testMoveRegularDiagonalDownLeft() {
    constructorDefault.move(2,2,0,0);
    constructorDefault.move(4,2,2,2);

    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorDefault.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            constructorDefault.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            constructorDefault.getSlotAt(4,2));
  }

  @Test
  public void testMoveGetSlotAtDiagonal() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorDefault.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorDefault.getSlotAt(2,2));
    constructorDefault.move(2,2,0,0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorDefault.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(2,2));
    constructorDefault.move(4,0,2,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorDefault.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(3,1));

  }

  @Test
  public void testGetBoardSize() {
    assertEquals(5, constructorDefault.getBoardSize());
    assertEquals(9, constructorSizeNine.getBoardSize());
    assertEquals(6, constructorSizeSixHoleFourFour.getBoardSize());
  }

  @Test
  public void testGetScoreDefault() {
    assertEquals(14,constructorDefault.getScore());
    assertEquals(44,constructorSizeNine.getScore());
  }

  @Test
  public void testWin() {

    TriangleSolitaireModel win = new TriangleSolitaireModel();

    win.move(2,0,0,0);
    win.move(2,2,2,0);
    win.move(0,0,2,2);
    win.move(3,0,1,0);
    win.move(4,2,2,0);
    win.move(3,3,3,1);
    win.move(1,0,3,0);
    win.move(3,0,3,2);
    win.move(4,4,4,2);
    win.move(4,1,4,3);
    win.move(2,2,4,2);
    win.move(4,3,4,1);
    win.move(4,0,4,2);

    assertTrue(win.isGameOver());
    assertEquals(1, win.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlotAt() {

    invalid = new TriangleSolitaireModel();

    invalid.getSlotAt(6,6);
    invalid.getSlotAt(-1,-1);
    invalid.getSlotAt(5,-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeHoleOffBoardInvalidDefaultSize() {

    invalid = new TriangleSolitaireModel(0,1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeHoleOffBoardInvalidSizeSix() {

    invalid = new TriangleSolitaireModel(6,0,1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeHoleOffBoardPositive() {

    invalid = new TriangleSolitaireModel(6, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeHoleOffBoardNegative() {

    invalid = new TriangleSolitaireModel(-1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeHoleNegativeRow() {

    invalid = new TriangleSolitaireModel(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeHoleOffBoard() {

    invalid = new TriangleSolitaireModel(0, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeSizeNegativeHolePositive() {

    invalid = new TriangleSolitaireModel(-5,1,1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidInitializeSizeNegativeHoleNegative() {

    invalid = new TriangleSolitaireModel(-1, -1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveSameSpace() {

    constructorDefault.move(0,0,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDistanceOneRow() {

    constructorDefault.move(0,2,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDistanceOneCol() {

    constructorDefault.move(0,1,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDistanceOneBoth() {

    constructorDefault.move(1,1,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDistanceThreeRow() {

    constructorDefault.move(3,0,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDistanceThreeCol() {

    constructorDefault.move(0,3,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDistanceThreeBoth() {

    constructorDefault.move(3,3,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToMarble() {

    constructorDefault.move(2,2,2,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToInvalid() {

    constructorDefault.move(2,2,2,4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToInvalidNegativeFrom() {

    constructorDefault.move(-2,-2,0,0);
  }

}