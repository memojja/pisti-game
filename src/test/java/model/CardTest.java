package model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CardTest {


    @Test
    public void card_object_referance_test(){
        Card card = new Card(Suit.CLUB,Value.ACE);
        CardWithFacingUp cardWithFacingUp = new CardWithFacingUp(card);

        Assert.assertEquals(card,cardWithFacingUp);

        Assert.assertNotEquals(card.isFront(),cardWithFacingUp.isFront());
    }

    @Test
    public void validate_get_same_card_does_not_matter_facing_state(){
        Card card = new Card(Suit.CLUB,Value.ACE);
        CardWithFacingUp cardWithFacingUp = new CardWithFacingUp(card);

        List<Card> cards = new ArrayList<>();
        cards.add(card);

        Assert.assertTrue(cards.contains(cardWithFacingUp));
    }
}
