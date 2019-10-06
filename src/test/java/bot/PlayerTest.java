package bot;

import model.Card;
import model.Suit;
import model.Value;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class PlayerTest {
    private static List<Card> discardedCards = new ArrayList<>();
    private static List<Card> myCards = new ArrayList<>();

    @BeforeClass
    public static void init(){
        discardedCards.add(new Card(Suit.CLUB,Value.TWO));
        discardedCards.add(new Card(Suit.CLUB,Value.ACE));
        discardedCards.add(new Card(Suit.CLUB,Value.JACK));
        myCards.add(new Card(Suit.CLUB,Value.ACE));
    }

    @Test
    public void discard_card_test(){
        myCards.add(new Card(Suit.HEARTS,Value.QUEEN));

        Optional<Card> card = myCards
                .parallelStream()
                .filter(mycard -> discardedCards.parallelStream().anyMatch(mycard::equals))
                .findFirst();

        Assert.assertTrue(card.isPresent());
    }
}
