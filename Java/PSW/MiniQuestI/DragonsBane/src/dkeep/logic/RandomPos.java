package dkeep.logic;

public class RandomPos {
    public static void hero(GameInfo game) {
        int i, k;

        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (game.getElement(i, k) == 1 || game.getElement(i, k) == 4);

        game.setElement(i, k, 2);
    }

    public static void key(GameInfo game) {
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (game.getElement(i, k) == 1 || game.getElement(i, k) == 2);
        game.setElement(i, k, 5);
    }

    public static void Dragon(GameInfo game) {
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (game.getElement(i, k) == 1 || game.getElement(i,k) == 2|| game.getElement(i, k) == 3
                || game.getElement(i, k) == 4 && game.getElement(i, k) == 5 || forbiddenDragonPos(i, k, game));
        game.setElement(i, k, 3);
    }

    public static boolean forbiddenDragonPos(int i, int k, GameInfo game) {

        // Dragon can´t block the exit
        if ((i == 4 || i == 5 || i == 6) && k == 8)
            return true;

        // Forbidden pos for the dragon
        if (((i == 6 || i == 5 || i == 4) && k == 1) || (i == 5 && k == 2))
            return true;

        // Dragon is near the key
        if (game.getElement(i - 1, k) == 5 || game.getElement(i + 1, k) == 5 || game.getElement(i, k - 1) == 5
                || game.getElement(i, k + 1) == 5)
            return true;

        // Dragon is near the Hero
        if (game.getElement(i - 1, k) == 2 || game.getElement(i + 1, k) == 2 || game.getElement(i, k - 1) == 2
                || game.getElement(i, k + 1) == 2)
            return true;

        return false;
    }


}
