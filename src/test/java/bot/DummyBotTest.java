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
        discardedCards.clear();
        myCard.clear();

        Card card = new CardWithFacingUp(new Card(Suit.CLUB,Value.TWO));
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

    @Test
    public void must_be_return_same_card() {
        Card card = new CardWithFacingUp(new Card(Suit.SPADES,Value.ACE));
        Card card1 = new Card(Suit.SPADES,Value.ACE);

        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(0);

        discardedCards.add(card);
        myCard.add(card1);

        Player dummyBot = playerFactory.getPlayer(PlayerEnum.DUMMY_BOT,0,"test");

        Assert.assertEquals(card1,dummyBot.logic(gameState));
    }

    @Test
    public void must_be_return_joker_card() {
        Card card = new CardWithFacingUp(new Card(Suit.SPADES,Value.FIVE));
        Card card1 = new Card(Suit.SPADES,Value.TWO);

        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(0);

        discardedCards.add(card);
        myCard.add(card1);

        Player dummyBot = playerFactory.getPlayer(PlayerEnum.DUMMY_BOT,0,"test");

        Assert.assertEquals(myCard.get(2),dummyBot.logic(gameState));
    }

}
