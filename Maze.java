package project5;

/**
 * A class with a recursive method that finds and prints out all solutions to the given
 * maze. Mazes are assumed to be input as 2d arrays of chars where '1' represents a wall,
 * '0' represents an open space, 'b' represents the start position and 'e' represents
 * the end position. The solutions that are printed out will contain the multiple instances
 * of the char 'p' which represents the current path/solution.
 *
 * @author Quintin Bucheit
 */
public class Maze
{
    private char[][] maze;
    private int rows; // number of rows
    private int cols; // number of columns
    private int numSolutions;

    /**
     * Constructor.
     *
     * @param r number of rows in the maze
     * @param c number of columns in the maze
     * @param m maze
     */
    public Maze(int r, int c, char[][] m)
    {
        rows = r;
        cols = c;
        maze = new char[r][c];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                maze[i][j] = m[i][j];
            }
        }

        // checks to be sure that there is a start position in the maze
        if (getStartR() == -1 || getStartC() == -1)
            System.out.println("There is no starting position.");

        // checks to be sure that there is an end position in the maze
        if (getEndR() == -1 || getEndC() == -1)
            System.out.println("There is no ending position.");
    }

    /**
     * Finds and prints out all possible solutions to this maze.
     *
     * @param r current row
     * @param c current column
     */
    public void solve(int r, int c)
    {
        // base case
        if (isEAdjacent(r, c)) // if "e" is adjacent then the maze is solved
        {
            maze[r][c] = 'p';
            numSolutions++;
            print();
        }
        else // recursive case
        {
            if ((r - 1 >= 0) && (maze[r - 1][c] == '0'))
            {
                maze[r - 1][c] = 'p';
                solve(r - 1, c);
            }
            if ((c + 1 < cols) && (maze[r][c + 1] == '0'))
            {
                maze[r][c + 1] = 'p';
                solve(r, c + 1);
            }
            if ((r + 1 < rows) && (maze[r + 1][c] == '0'))
            {
                maze[r + 1][c] = 'p';
                solve(r + 1, c);
            }
            if ((c - 1 >= 0) && (maze[r][c - 1] == '0'))
            {
                maze[r][c - 1] = 'p';
                solve(r, c - 1);
            }
        }
        maze[r][c] = '0'; // backtracking
    }

    /**
     * Checks to see if 'e' is adjacent.
     *
     * @param r current row
     * @param c current column
     * @return true if 'e' is adjacent false otherwise
     */
    private boolean isEAdjacent(int r, int c)
    {
        return  ((r - 1 >= 0) && (maze[r - 1][c] == 'e')) ||
                ((c + 1 < cols) && (maze[r][c + 1] == 'e')) ||
                ((r + 1 < rows) && (maze[r + 1][c] == 'e')) ||
                ((c - 1 >= 0) && (maze[r][c - 1] == 'e'));
    }

    /**
     * Finds the row where the starting point 'b' is located. If no 'b' is found,
     * returns -1.
     *
     * @return row where 'b' is located else -1 if no 'b' is found
     */
    public int getStartR()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if(maze[i][j] == 'b')
                {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Finds the column where the starting point 'b' is located. If no 'b' is found,
     * returns -1.
     *
     * @return column where 'b' is located else -1 if no 'b' is found
     */
    public int getStartC()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if(maze[i][j] == 'b')
                {
                    return j;
                }
            }
        }
        return -1;
    }

    /**
     * Finds the row where the end point 'e' is located. If no 'e' is found,
     * returns -1.
     *
     * @return row where 'e' is located else -1 if no 'e' is found
     */
    public int getEndR()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if(maze[i][j] == 'e')
                {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Finds the column where the end point 'e' is located. If no 'e' is found,
     * returns -1.
     *
     * @return column where 'e' is located else -1 if no 'e'is found
     */
    public int getEndC()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if(maze[i][j] == 'e')
                {
                    return j;
                }
            }
        }
        return -1;
    }

    /**
     * Prints out the current state of the maze.
     */
    public void print()
    {
        System.out.println("Solution number: " + numSolutions);
        System.out.println();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
