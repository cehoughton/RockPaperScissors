public class App {
  public static void main(String[] args) {}


    public Boolean checkWinner(String userInput, String computerResult) {
       userInput = userInput.toLowerCase();
       userInput = userInput.replaceAll("//s+", "");

       if (computerResult == "scissors" && userInput == "rock") {
         return true;
       }
       return false;
    }
}
