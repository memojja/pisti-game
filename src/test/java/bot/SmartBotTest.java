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
        setup(discardedCards, myCard);
    }

    @Test
    public void given_no_smart_card_when_discarded_card_aviable_then_user_must_discard_card() {
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
    public void given_card_when_discarded_card_aviable_then_user_must_discard_same_card() {
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
    public void given_joker_card_when_discarded_card_aviable_then_user_must_discard_joker_card() {
        Card card = new CardWithFacingUp(new Card(Suit.SPADES,Value.QUEEN));
        Card card1 = new Card(Suit.SPADES,Value.JACK);

        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCard = gameState.getPlayersCards().get(1);

        discardedCards.add(card);
        myCard.add(card1);
        Player smartBot = playerFactory.getPlayer(PlayerEnum.SMART_BOT,1,"test");

        Assert.assertEquals(Value.JACK,smartBot.logic(gameState).getNumber());

        //to other tests
        myCard.remove(card1);

    }

    private static void setup(List<Card> discardedCards, List<Card> myCard) {
        discardedCards.clear();
        myCard.clear();

        Card card = new CardWithFacingUp(new Card(Suit.SPADES, Value.TWO));
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

}
