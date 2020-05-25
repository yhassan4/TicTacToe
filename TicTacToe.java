import java.util.*;

public class TicTacToe {
  private int size;
  private String[] playersNames;
  private char[][] grid;
  private int changePlayer = 2;
  private boolean caught;
  private int row, col;

  public TicTacToe(int size, String[] playersNames){
    this.size = size;
    this.playersNames = playersNames;
    initializeGrid();
  }

  public void play(){
    getPosition();
    print();
  }

  private void initializeGrid(){
    // create a double array of 'size' number of rows and columns
    grid = new char[size][size];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        grid[i][j] = '-';
      }
    }
  }

  public void setPlayer(){
    if (changePlayer % 2 == 0) {
      System.out.print(playersNames[0]);
    } else {
      System.out.print(playersNames[1]);
    }
  }

  public void getPosition(){
    do {
      try {
        Scanner in = new Scanner(System.in);
        setPlayer(); System.out.print(", enter a row: ");
        row = (in.nextInt() - 1);
        System.out.print("Now enter a column: ");
        col = (in.nextInt() - 1);
        checkUserInput();
      } catch(InputMismatchException e) {
        caught = true;
        System.out.println("Please enter a correct row number and a column number!");
      }
    } while (caught);
  }

  public void checkUserInput(){
    if ((row > size || row < 0) || (col > size || col < 0)) {
      System.out.println("Row or column has to be in the range of 0 and " + size);
      caught = true;
    } else {
      setPosition();
      caught = false;
    }
  }

  public void setPosition(){
    if (!isOccupied()) {
      if (changePlayer % 2 == 0) {
        grid[row][col] = 'X';
      } else {
        grid[row][col] = 'O';
      }
      changePlayer();
    } else {
      System.out.println("Pick another spot");
      getPosition();
    }
  }

  public void changePlayer(){
    changePlayer++;
  }

  public void print(){
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        System.out.print(grid[i][j] + "  ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public boolean isFull(){
    int countEmptySlot = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '-') {
          countEmptySlot++;
        }
      }
    }
    if (countEmptySlot > 0) {
      return false;
    } else {
      return true;
    }
  }

  public boolean isOccupied(){
    if (grid[row][col] == '-') {
      return false;
    } else {
      return true;
    }
  }

  public boolean winner(){
    boolean bool = false;
    int indexHorizontal = 0;
    while (indexHorizontal < grid.length) {
      if (bool) {
        changePlayer();
        setPlayer(); System.out.println(" has won the game!");
        return bool;
      } else {
        for (int i = 0; i < grid.length; i++) {
          if (grid[indexHorizontal][0] == grid[indexHorizontal][i] && grid[indexHorizontal][i] != '-') {
            bool = true;
          } else {
            bool = false;
            break;
          }
        }
      }
      if (bool && (indexHorizontal == (grid.length - 1))) {
        changePlayer();
        setPlayer(); System.out.println(" has won the game!");
        return bool;
      } else {
        indexHorizontal++;
      }
    }

    int indexV = 0;
    while (indexV < grid.length) {
      if (bool) {
        changePlayer();
        setPlayer(); System.out.println(" has won the game!");
        return bool;
      } else {
        for (int i = 0; i < grid.length; i++) {
          if (grid[0][indexV] == grid[i][indexV] && grid[i][indexV] != '-') {
            bool = true;
          } else {
            bool = false;
            break;
          }
        }
      }
      if (bool && (indexV == (grid.length - 1))) {
        changePlayer();
        setPlayer(); System.out.println(" has won the game!");
        return bool;
      } else {
        indexV++;
      }
    }

    for (int i = 0; i < grid.length; i++) {
      if (grid[0][0] == grid[i][i] && grid[i][i] != '-') {
        bool = true;
      } else {
        bool = false;
        break;
      }
    }
    if (bool) {
      changePlayer();
      setPlayer(); System.out.println(" has won the game!");
      return bool;
    }

    for (int i = grid.length - 1, j = 0; j < grid.length; i--, j++) {
      if (grid[grid.length - 1][0] == grid[i][j] && grid[i][j] != '-') {
        bool = true;
      } else {
        bool = false;
        break;
      }
    }
    if (bool) {
      changePlayer();
      setPlayer(); System.out.println(" has won the game!");
      return bool;
    }

    return bool;
  }
}
