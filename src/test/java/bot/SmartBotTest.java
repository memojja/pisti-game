package bot;

import model.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class SmartBotTest {

    private static GameState gameState;
    private static PlayerFactory playerFactory;

    @BeforeClass
    public static void init(){
        gameState = new GameState("Test-");
        playerFactory = new PlayerFactory();
        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(1);

        //All cards were randomly assigned. i have to setup to test.
        discardedCards.clear();
        myCard.clear();

        Card card = new CardWithFacingUp(new Card(Suit.SPADES,Value.TWO));
        Card card1 = new CardWithFacingUp(new Card(Suit.SPADES,Value.ACE));
        Card card2 = new CardWithFacingUp(new Card(Suit.SPADES,Value.ACE));
        discardedCards.add(card);
        discardedCards.add(card1);
        discardedCards.add(card2);

        Card card4 = new Card(Suit.CLUB,Value.FIVE);
        Card card5 = new Card(Suit.CLUB,Value.SEVEN);
        Card card6 = new Card(Suit.CLUB,Value.EIGHT);
        myCard.add(card4);
        myCard.add(card5);
        myCard.add(card6);

    }

    @Test
    public void must_be_return_discarded_card() {
        Card card = new CardWithFacingUp(new Card(Suit.SPADES,Value.ACE));
        Card card1 = new Card(Suit.SPADES,Value.TWO);

        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(1);

        discardedCards.add(card);
        myCard.add(card1);

        Player smartBot = playerFactory.getPlayer(PlayerEnum.SMART_BOT,1,"test");

        Assert.assertEquals(card1,smartBot.logic(gameState));
    }

    @Test
    public void must_be_return_same_card() {
        Card card = new CardWithFacingUp(new Card(Suit.SPADES,Value.ACE));
        Card card1 = new Card(Suit.SPADES,Value.ACE);

        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(1);

        discardedCards.add(card);
        myCard.add(card1);

        Player smartBot = playerFactory.getPlayer(PlayerEnum.SMART_BOT,1,"test");

        Assert.assertEquals(card1,smartBot.logic(gameState));
    }


    @Test
    public void must_be_return_joker_card() {
        Card card = new CardWithFacingUp(new Card(Suit.SPADES,Value.QUEEN));
        Card card1 = new Card(Suit.SPADES,Value.JACK);

        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(1);

        discardedCards.add(card);
        myCard.add(card1);

        Player smartBot = playerFactory.getPlayer(PlayerEnum.SMART_BOT,1,"test");

        Assert.assertEquals(Value.JACK,smartBot.logic(gameState).getNumber());
    }



}
