import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void checkWinner_rockBeatsScissors_Player1Wins() {
    App appTest = new App();
    assertEquals("Player 1 wins!", appTest.checkWinner("rock", "scissors"));
  }
  @Test
  public void checkWinner_scissorsBeatsPaper_Player1Wins() {
    App appTest = new App();
    assertEquals("Player 1 wins!", appTest.checkWinner("scissors", "paper"));
  }
  @Test
  public void checkWinner_paperBeatsRock_Player1Wins() {
    App appTest = new App();
    assertEquals("Player 1 wins!", appTest.checkWinner("paper", "rock"));
  }

  @Test
  public void computerChooses_shouldBeAString_true() {
  App appTest = new App();
  String computerChoice =  appTest.computerChooses();
  assertEquals(true, computerChoice instanceof String);
}

}
