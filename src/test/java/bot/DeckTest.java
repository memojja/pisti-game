package bot;

import model.Card;
import model.Deck;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

  @Test
  public void deck_test(){
    Deck deck = new Deck();
    Deck deck1 = new Deck();
    Deck deck2 = new Deck();

    Card card = deck.getCards().get(0);
    Card card1 = deck1.getCards().get(0);
    Card card2 = deck2.getCards().get(0);

    Assert.assertNotEquals(card,card1);
    Assert.assertNotEquals(card2,card1);
    Assert.assertNotEquals(card2,card);

  }
}

