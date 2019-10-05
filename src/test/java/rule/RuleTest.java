package rule;

import model.Card;
import model.Suit;
import model.Value;
import org.junit.Assert;
import org.junit.Test;
import rule.continously.AceProcessor;
import rule.continously.ClubTwoProcessor;
import rule.continously.DiamondTenProcessor;
import rule.continously.NoneProcessor;
import simulation.Player;

public class RuleTest {

    @Test
    public void ace_one_point(){
        PointChain c1 = new AceProcessor();
        PointChain c2 = new ClubTwoProcessor();
        PointChain c3 = new DiamondTenProcessor();
        PointChain c4 = new NoneProcessor();
        c1.setNext(c2);
        c2.setNext(c3);
        c3.setNext(c4);

        Player player = new Player(1);
        c1.process(new Card(Suit.CLUB,Value.TWO),player);

        Assert.assertEquals(player.getPoint(),2);

        c1.process(new Card(Suit.CLUB,Value.FIVE),player);
        c1.process(new Card(Suit.CLUB,Value.ACE),player);
        c1.process(new Card(Suit.CLUB,Value.ACE),player);

        Assert.assertEquals(player.getPoint(),4);

    }
}
