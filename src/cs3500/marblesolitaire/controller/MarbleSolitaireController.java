package cs3500.marblesolitaire.controller;

/**
 * The controller takes the input from the user and decides what to do with it.
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire.
   * @throws IllegalStateException only if the controller is unable to successfully read
   *     input or transmit output
   */
  public void playGame();
}
