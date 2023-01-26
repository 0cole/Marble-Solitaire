package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.SimpleModel.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.BetterModel.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.BetterModel.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * This is the main class for MarbleSolitaire. It plays a game based on which type is input by the
 * user and considers other factors that affect the design.
 */
public final class MarbleSolitaire {
  /**
   * The main method.
   * @param args the inputs from the user that determine the design of the game
   */
  public static void main(String[] args) {

    int size = 0;
    int row = 0;
    int col = 0;

    String type = args[0];

    for (int i = 0; i < args.length; i++) {

      if (args[i].equals("-size")) {
        try {
          size = Integer.parseInt(args[i + 1]);

          if (size == 0) {
            throw new IllegalArgumentException("size input must be greater than one");
          }

        } catch (NumberFormatException e) {
          throw new IllegalArgumentException("size input must be an integer");
        }
      }

      if (args[i].equals("-hole")) {
        try {
          row = Integer.parseInt(args[i + 1]) - 1;
          col = Integer.parseInt(args[i + 2]) - 1;
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException("row and col input must be an integer");
        }
      }
    }

    switch (type) {

      case "english":
        if (size == 0) {
          size = 3;
        }
        if (row == 0 && col == 0) {
          row = (size * 3 - 2) / 2;
          col = (size * 3 - 2) / 2;
        }

        EnglishSolitaireModel englishModel = new EnglishSolitaireModel(size, row, col);
        MarbleSolitaireView englishView = new MarbleSolitaireTextView(englishModel);
        MarbleSolitaireController englishController =
                new MarbleSolitaireControllerImpl(englishModel, englishView,
                        new InputStreamReader(System.in));

        englishController.playGame();
        break;

      case "european":
        if (size == 0) {
          size = 3;
        }
        if (row == 0 && col == 0) {
          row = (size * 3 - 2) / 2;
          col = (size * 3 - 2) / 2;
        }

        EuropeanSolitaireModel europeanModel = new EuropeanSolitaireModel(size, row, col);
        MarbleSolitaireView europeanView = new MarbleSolitaireTextView(europeanModel);
        MarbleSolitaireController europeanController =
                new MarbleSolitaireControllerImpl(europeanModel, europeanView,
                        new InputStreamReader(System.in));

        europeanController.playGame();
        break;

      case "triangular":
        if (size == 0) {
          size = 5;
        }

        TriangleSolitaireModel triangleModel = new TriangleSolitaireModel(size, row, col);
        MarbleSolitaireView triangleView = new TriangleSolitaireTextView(triangleModel);
        MarbleSolitaireController triangleController =
                new MarbleSolitaireControllerImpl(triangleModel, triangleView,
                new InputStreamReader(System.in));

        triangleController.playGame();
        break;

      default:
        break;
    }
  }
}