import java.util.Scanner;   
public class TicTacToeApp
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);
      System.out.print("Player 1, Enter your name: ");
      String name1 = kbd.nextLine();

      System.out.print("Player 2, Enter your name: ");
      String name2 = kbd.nextLine();

      System.out.print("Enter the size of the Tic-Tac-Toe game (must be higher than 2): ");
      int size = kbd.nextInt();
      while (size < 3) {
        System.out.print("Enter the size of the Tic-Tac-Toe game (must be higher than 2): ");
        size = kbd.nextInt();
      }

      String[] playerNames = {name1, name2};

      TicTacToe ttt1 = new TicTacToe(size, playerNames);
      while(!ttt1.isFull() && !ttt1.winner())
      {
         ttt1.play();
      }
      if (ttt1.isFull()) {
        System.out.println("The game is a tie!");
      }
   }
}
