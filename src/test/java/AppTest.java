import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void checkWinner_rockBeatsScissors_true() {
    App appTest = new App();
    assertEquals(true, appTest.checkWinner("rock", "scissors"));
  }
}
