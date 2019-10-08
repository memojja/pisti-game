package bot;

import model.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class DummyBotTest {

    private static GameState gameState;
    private static PlayerFactory playerFactory;

    @BeforeClass
    public static void init(){
        gameState = new GameState("Test-");
        playerFactory = new PlayerFactory();
        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(0);

        //All cards were randomly assigned. i have to setup to test.
        setup(discardedCards, myCard);
    }

    @Test

    public void given_card_when_discarded_card_aviable_then_user_must_discard_same_card() {
        Card card = new CardWithFacingUp(new Card(Suit.SPADES,Value.ACE));
        Card card1 = new Card(Suit.SPADES,Value.ACE);

        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(0);

        discardedCards.add(card);
        myCard.add(card1);

        Player dummyBot = playerFactory.getPlayer(PlayerEnum.DUMMY_BOT,0,"test");

        Assert.assertEquals(card1.getNumber(),dummyBot.logic(gameState).getNumber());
    }

    @Test
    public void given_joker_card_when_discarded_card_aviable_then_user_must_discard_joker_card() {
        Card card = new CardWithFacingUp(new Card(Suit.SPADES,Value.KING));
        Card card1 = new Card(Suit.SPADES,Value.JACK);

        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(0);


        discardedCards.add(card);
        myCard.add(card1);

        Player dummyBot = playerFactory.getPlayer(PlayerEnum.DUMMY_BOT,0,"test");

        Assert.assertEquals(Value.JACK,dummyBot.logic(gameState).getNumber());
    }

    private static void setup(List<Card> discardedCards, List<Card> myCard) {
        discardedCards.clear();
        myCard.clear();

        Card card = new CardWithFacingUp(new Card(Suit.CLUB, Value.TWO));
        Card card1 = new CardWithFacingUp(new Card(Suit.DIAMOND,Value.JACK));
        Card card2 = new CardWithFacingUp(new Card(Suit.SPADES,Value.ACE));
        discardedCards.add(card);
        discardedCards.add(card1);
        discardedCards.add(card2);

        Card card4 = new Card(Suit.CLUB,Value.FIVE);
        Card card5 = new Card(Suit.CLUB,Value.SEVEN);
        Card card6 = new Card(Suit.CLUB,Value.JACK);
        myCard.add(card4);
        myCard.add(card5);
        myCard.add(card6);
    }

}
