package cs3500.marblesolitaire.model;

import org.junit.Test;

import cs3500.marblesolitaire.model.BetterModel.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link EuropeanSolitaireModel}.
 */
public class EuropeanSolitaireModelTest {

  EuropeanSolitaireModel constructorDefault = new EuropeanSolitaireModel();
  EuropeanSolitaireModel constructorArmFive = new EuropeanSolitaireModel(5);
  EuropeanSolitaireModel constructorHoleZeroThree = new EuropeanSolitaireModel(0,3);

  @Test
  public void testGetSlotAtDefaultMarble() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(2,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(4,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(5,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(5,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,constructorDefault.getSlotAt(1,1));
  }

  @Test
  public void testGetSlotAtDefaultEmpty() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,constructorDefault.getSlotAt(3,3));
  }

  @Test
  public void testGetSlotAtDefaultInvalid() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(6,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(6,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(5,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,6));
  }

  @Test
  public void testGetSlotAtHoleZeroThreeMarble() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorHoleZeroThree.getSlotAt(2,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorHoleZeroThree.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorHoleZeroThree.getSlotAt(5,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorHoleZeroThree.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
            constructorHoleZeroThree.getSlotAt(3,2));
  }

  @Test
  public void testGetSlotAtHoleZeroThreeEmpty() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,constructorHoleZeroThree.getSlotAt(0,3));
  }

  @Test
  public void testGetSlotAtHoleZeroThreeInvalid() {
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(6,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(6,5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(5,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,constructorDefault.getSlotAt(0,6));
  }

  @Test
  public void testGetScoreConstructors() {
    assertEquals(36, constructorDefault.getScore());
    assertEquals(128, constructorArmFive.getScore());
    assertEquals(36, constructorHoleZeroThree.getScore());
  }

  @Test
  public void testMove() {
    assertEquals(36,constructorDefault.getScore());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorDefault.getSlotAt(5, 3));

    constructorDefault.move(5, 3, 3, 3);

    assertEquals(35,constructorDefault.getScore());
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, constructorDefault.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, constructorDefault.getSlotAt(5, 3));
  }

  @Test
  public void testTwoMoves() {
    assertEquals(36, constructorDefault.getScore());

    constructorDefault.move(3, 5, 3, 3);

    assertEquals(35, constructorDefault.getScore());

    constructorDefault.move(1, 4, 3, 4);

    assertEquals(34, constructorDefault.getScore());
  }

  @Test
  public void testGetBoardSize() {

    assertEquals(7, constructorDefault.getBoardSize());
    assertEquals(13, constructorArmFive.getBoardSize());
    assertEquals(7, constructorHoleZeroThree.getBoardSize());
  }

  @Test
  public void testIsGameOverFalse() {

    assertFalse(constructorDefault.isGameOver());
    constructorDefault.move(5, 3, 3, 3);
    assertFalse(constructorDefault.isGameOver());
  }

  @Test
  public void testWin() {

    EuropeanSolitaireModel win = new EuropeanSolitaireModel(0, 2);

    win.move(0, 4, 0, 2);
    win.move(2, 3, 0, 3);
    win.move(1, 1, 1, 3);
    win.move(0, 3, 2, 3);
    win.move(1, 5, 1, 3);
    win.move(3, 2, 1, 2);
    win.move(2, 0, 2, 2);
    win.move(3, 0, 3, 2);
    win.move(5, 1, 3, 1);
    win.move(4, 3, 4, 1);
    win.move(6, 2, 4, 2);
    win.move(6, 3, 4, 3);
    win.move(5, 5, 5, 3);
    win.move(3, 4, 5, 4);
    win.move(3, 6, 3, 4);
    win.move(4, 6, 4, 4);
    win.move(4, 1, 2, 1);
    win.move(1, 2, 1, 4);
    win.move(4, 3, 4, 1);
    win.move(4, 0, 4, 2);
    win.move(3, 2, 1, 2);
    win.move(0, 2, 2, 2);
    win.move(5, 4, 5, 2);
    win.move(3, 4, 5, 4);
    win.move(6, 4, 4, 4);
    win.move(1, 4, 3, 4);
    win.move(2, 6, 2, 4);
    win.move(5, 2, 3, 2);
    win.move(2, 2, 4, 2);
    win.move(2, 4, 2, 2);
    win.move(2, 1, 2, 3);
    win.move(2, 3, 4, 3);
    win.move(3, 4, 5, 4);
    win.move(4, 2, 4, 4);
    win.move(4, 4, 6, 4);

    assertTrue(win.isGameOver());
    assertEquals(1, win.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveOneSpace() {

    constructorDefault.move(2,3,3,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveThreeSpaces() {

    constructorDefault.move(0,3,3,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonal() {

    constructorDefault.move(3, 5, 3, 3);
    constructorDefault.move(1, 3, 3, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToPositionIsMarble() {

    constructorDefault.move(2, 0, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveToPositionIsInvalid() {

    constructorDefault.move(2, 0, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFromPositionIsEmpty() {

    constructorDefault.move(5, 3, 3, 3);
    constructorDefault.move(2, 3, 4, 3);
    constructorDefault.move(5, 3, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveFromPositionIsInvalid() {

    constructorDefault.move(1, 3, 3, 3);
    constructorDefault.move(0, 1, 0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveNeighborIsEmpty() {

    constructorDefault.move(1, 3, 3, 3);
    constructorDefault.move(0, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveOffBoard() {

    constructorDefault.move(10, 10, 10, 8);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlotAtInvalidPositive() {

    constructorDefault.getSlotAt(10,10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetSlotAtInvalidNegative() {

    constructorDefault.getSlotAt(-10,-10);
  }

}