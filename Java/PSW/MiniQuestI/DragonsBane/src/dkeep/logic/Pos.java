package dkeep.logic;

// Class to find the provided character position
public class Pos {
    public static int[] findHero(GameInfo game) {
        int[] pos = new int[2];
        for (int i = 0; i < game.getLength(); i++) {
            for (int k = 0; k < game.getLength(); k++) {
                if (game.getElement(i, k) == 2) {
                    pos[0] = i;
                    pos[1] = k;
                    return pos;
                }
            }
        }
        throw new IllegalArgumentException("Character not found");
    }
}
