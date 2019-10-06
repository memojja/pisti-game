package bot;

import model.*;
import org.junit.BeforeClass;

public class SmartBotTest {

    private static GameState gameState;

    @BeforeClass
    public static void init(){
        gameState = new GameState("test");
    }

}
