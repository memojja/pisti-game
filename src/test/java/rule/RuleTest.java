package rule;

import model.*;
import org.junit.Assert;
import org.junit.Test;

public class RuleTest {

    @Test
    public void given_point_when_two_ace_and_club_two_card_then_point_must_be_four(){
        PointChain c1 = new AceProcessor();
        PointChain c2 = new ClubTwoProcessor();
        PointChain c3 = new DiamondTenProcessor();
        PointChain c4 = new NoneProcessor();
        c1.setNext(c2);
        c2.setNext(c3);
        c3.setNext(c4);

        Player player = new SmartBot(1,"test-game");
        c1.process(new Card(Suit.CLUB,Value.TWO),player);

        Assert.assertEquals(player.getPoint(),2);

        c1.process(new Card(Suit.CLUB,Value.FIVE),player);
        c1.process(new Card(Suit.CLUB,Value.ACE),player);
        c1.process(new Card(Suit.CLUB,Value.ACE),player);

        Assert.assertEquals(player.getPoint(),4);

    }
}
