import java.util.Random;
import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console myConsole = System.console();
    System.out.println("Do you want rock, paper, or scissors?");
    String user1Input = myConsole.readLine();
    String user2Input = computerChooses();
    String winner = checkWinner(user1Input, user2Input);
    System.out.println("You chose: " + user1Input + ". The computer chose " + user2Input + ". ");
  }



    public static String computerChooses() {
      String user2Input = "";

      Random computerRandomGenerator = new Random();
      Integer computerNumber = computerRandomGenerator.nextInt(3);
      if (computerNumber < 1) {
        user2Input = "rock";
      } else if(computerNumber > 0 && computerNumber < 2) {
        user2Input = "scissors";
      } else {
        user2Input = "paper";
      }
      return user2Input;
    }

    public static String checkWinner(String user1Input, String user2Input) {

       String result = "";

       user1Input = user1Input.toLowerCase();
       user1Input = user1Input.replaceAll("//s+", "");

       if( user1Input == "rock" && user2Input == "scissors" ) {
         result = "Player 1 wins!";
       } else if( user1Input == "scissors" && user2Input == "paper" ) {
         result = "Player 1 wins!";
       } else if ( user1Input == "paper" && user2Input == "rock") {
         result = "Player 1 wins!";
       } else if ( user1Input == user2Input) {
         result = "It's a tie!";
       } else {
         result = "The computer wins!";
       }
       return result;
    }

}
