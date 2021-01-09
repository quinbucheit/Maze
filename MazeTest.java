package project5;

/**
 * Tests the Maze class.
 *
 * @author Quintin Bucheit
 */
public class MazeTest
{
    public static void main(String[] args)
    {
        char[][] m1 = {{'1', '1', '1', '1', '1'},
                       {'b', '0', '0', '0', '1'},
                       {'1', '0', '1', '0', '1'},
                       {'1', '0', '0', 'e', '1'},
                       {'1', '1', '1', '1', '1'}};

        char[][] m2 = {{'1', '1', '1', '1', '1', '1', '1', '1'},
                       {'b', '0', '0', '0', '0', '0', '0', '1'},
                       {'1', '0', '1', '1', '0', '1', '0', '1'},
                       {'1', '0', '1', '1', '0', '1', '0', '1'},
                       {'1', '0', '0', '0', '0', '0', 'e', '1'},
                       {'1', '1', '1', '1', '1', '1', '1', '1'}};

        Maze maze1 = new Maze(5, 5, m1);
        System.out.println("Maze 1 Solutions: ");
        maze1.solve(maze1.getStartR(), maze1.getStartC());

        System.out.println();

        Maze maze2 = new Maze(6, 8, m2);
        System.out.println("Maze 2 Solutions: ");
        maze2.solve(maze2.getStartR(), maze2.getStartC());
    }
}
