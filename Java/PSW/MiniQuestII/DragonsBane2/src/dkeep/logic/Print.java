package dkeep.logic;

// Class to print the maze content
public class Print {
    public static void maze(Map map) {
        for (int i = 0; i < map.getLength(); i++) {
            for (int k = 0; k < map.getLength(); k++) {
                switch (map.getElement(i, k)) {
                    case 1:
                        System.out.print("X ");
                        break;
                    case 2:
                        System.out.print("H ");
                        break;
                    case 3:
                        System.out.print("D ");
                        break;
                    case 4:
                        System.out.print("E ");
                        break;
                    case 5:
                        System.out.print("S ");
                        break;
                    case 0:
                        System.out.print("  ");
                        break;
                    case 6:
                        System.out.print("A ");
                        break;
                    case 7:
                        System.out.print("  ");
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid maze char");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
