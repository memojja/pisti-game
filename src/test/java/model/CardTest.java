package model;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {


    @Test
    public void cardObjectReferanceTest(){
        Card card = new Card(Suit.CLUB,Value.ACE);
        CardWithFacingUp cardWithFacingUp = new CardWithFacingUp(card);

        Assert.assertSame(card.getNumber(),cardWithFacingUp.getNumber());
        Assert.assertSame(card.getSuit(),cardWithFacingUp.getSuit());

        Assert.assertNotSame(card.isFront(),cardWithFacingUp.isFront());
    }
}
