import java.util.Random;
import java.io.Console;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/form", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/output", (request, response) -> {
      HashMap model = new HashMap();
      String user1Input = request.queryParams("user1Input");
      String user2Input = computerChooses();
      String winner = checkWinner(user1Input, user2Input);

      model.put("user1Input", user1Input);
      model.put("user2Input", user2Input);
      model.put("winner", winner);
      model.put("template", "templates/output.vtl");


      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

    public static String computerChooses() {
      String user2Input = "";
      Random computerRandomGenerator = new Random();
      Integer computerNumber = computerRandomGenerator.nextInt(3);

      if ( computerNumber < 1 ) {
        user2Input = "rock";
      } else if( computerNumber > 0 && computerNumber < 2 ) {
        user2Input = "scissors";
      } else {
        user2Input = "paper";
      }
      return user2Input;
    }

    public static String checkWinner(String user1Input, String user2Input) {
       String winner = "";
       user1Input = user1Input.toLowerCase();
       user1Input = user1Input.replaceAll("//s+", "");

       if( user1Input.equals("rock") && user2Input.equals("scissors") ) {
         winner = "You win!";
       } else if( user1Input.equals("scissors") && user2Input.equals("paper") ) {
         winner = "You win!";
       } else if ( user1Input.equals("paper") && user2Input.equals("rock") ) {
         winner = "You win!";
       } else if ( user1Input.equals(user2Input) ) {
         winner = "It's a tie!";
       } else if( !user1Input.equals("rock") && !user1Input.equals("paper") && !user1Input.equals("scissors") ) {
         winner = "That is not a valid choice.";
       } else {
         winner = "The computer wins!";
       }
       return winner;
    }

}
