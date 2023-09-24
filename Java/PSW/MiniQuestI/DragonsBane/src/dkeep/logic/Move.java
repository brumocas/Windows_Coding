package dkeep.logic;


public class Move {
    /* Returns:
        o -> Game Over // Hitted the Dragon
        1 -> In the Game
        2 -> Game Win

        0 -> empty cell
        1 -> wall
        s
        2 -> Hero
        3 -> Dragon
        4 -> Exit
        5 -> Key
     */

    public static int moveHero(GameInfo game, char move) {
        // variable to save pos
        int[] pos;
        int i = 0, k = 0;

        // Find Hero position
        pos = Pos.findHero(game);
        i = pos[0];
        k = pos[1];

        switch (move) {
            case 'w':
                // Check if you pick the key
                if (game.getElement(i - 1, k) == 5 && !game.getkeystatus()) game.takeKey();

                // Check if you hit the Dragon edge
                if (Dimensions.check(i - 2, k, game.getLength())) {
                    if (game.getElement(i - 2, k) == 3 || game.getElement(i - 1, k - 1) == 3 || game.getElement(i - 1, k + 1) == 3) {
                        game.setElement(i - 1, k, 2);
                        game.setElement(i, k, 0);
                        return 0;
                    }
                }

                // Check if you hit the wall
                if (game.getElement(i - 1, k) != 1) {
                    game.setElement(i - 1, k, 2);
                    game.setElement(i, k, 0);
                    return 1;
                }
                return 1;

            case 's':
                // Check if you pick the key
                if (game.getElement(i + 1, k) == 5 && !game.getkeystatus()) game.takeKey();

                // Check if you hit the Dragon edge
                if (Dimensions.check(i + 2, k, game.getLength())) {
                    if (game.getElement(i + 2, k) == 3 || game.getElement(i + 1, k - 1) == 3 || game.getElement(i + 1, k + 1) == 3) {
                        game.setElement(i + 1, k, 2);
                        game.setElement(i, k, 0);
                        return 0;
                    }
                }

                // Check if you hit the wall
                if (game.getElement(i + 1, k) != 1) {
                    game.setElement(i + 1, k, 2);
                    game.setElement(i, k, 0);
                    return 1;
                }
                return 1;

            case 'a':

                // Check if you pick the key
                if (game.getElement(i, k - 1) == 5 && !game.getkeystatus()) game.takeKey();

                // Check if you hit the Dragon edge
                if (Dimensions.check(i, k - 2, game.getLength())) {
                    if (game.getElement(i, k - 2) == 3 || game.getElement(i + 1, k - 1) == 3 || game.getElement(i - 1, k - 1) == 3) {
                        game.setElement(i, k - 1, 2);
                        game.setElement(i, k, 0);
                        return 0;
                    }
                }

                // Check if you hit the wall
                if (game.getElement(i, k - 1) != 1) {
                    game.setElement(i, k - 1, 2);
                    game.setElement(i, k, 0);
                    return 1;
                }
                return 1;

            case 'd':

                // Check if you pick the key
                if (game.getElement(i, k + 1) == 5 && !game.getkeystatus()) game.takeKey();

                // Check if you hit the Dragon edge
                if (Dimensions.check(i, k + 2, game.getLength())) {
                    if (game.getElement(i, k + 2) == 3 || game.getElement(i - 1, k + 1) == 3 || game.getElement(i + 1, k + 1) == 3) {
                        game.setElement(i, k + 1, 2);
                        game.setElement(i, k, 0);
                        return 0;
                    }
                }

                // Check if you hit the Exit and are able to go through
                if (game.getElement(i, k + 1) == 4 && game.getkeystatus()) {
                    game.setElement(i, k + 1, 2);
                    game.setElement(i, k, 0);
                    return 2;
                }

                // Check if you hit the wall
                if (game.getElement(i, k + 1) != 1 && game.getElement(i, k + 1) != 4) {
                    game.setElement(i, k + 1, 2);
                    game.setElement(i, k, 0);
                    return 1;
                }
                return 1;

            default:
                System.out.println("Invalid move");
                return 1;
        }
    }
}
