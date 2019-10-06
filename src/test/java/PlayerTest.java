import model.Card;
import model.Suit;
import model.Value;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerTest {
    private static List<Card> discardedCards = new ArrayList<>();
    private static List<Card> myCards = new ArrayList<>();
    private static Card card2;
    private static Card card;

    @BeforeClass
    public static void init(){
        discardedCards.add(new Card(Suit.CLUB,Value.TWO));
        discardedCards.add(new Card(Suit.CLUB,Value.ACE));
        discardedCards.add(new Card(Suit.CLUB,Value.JACK));
        myCards.add(new Card(Suit.CLUB,Value.ACE));
    }

    @Test
    public void ai(){
        myCards.add(new Card(Suit.HEARTS,Value.QUEEN));

        Optional<Card> card = myCards
                .parallelStream()
                .filter(mycard -> discardedCards.parallelStream().anyMatch(mycard::equals))
                .findFirst();

        Assert.assertTrue(card.isPresent());
    }
}
