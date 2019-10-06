package simulation;

import model.Dummybot;
import model.GameState;
import model.Player;
import org.apache.log4j.Logger;
import service.GameService;

import java.util.UUID;
import java.util.stream.IntStream;

public class GameImpl implements Runnable {

    private String gameId;
    private Player[] players;
    private GameState gameState;
    private GameService gameService;
    private int userActionCount = 0;
    private int count=0;

    final static Logger logger = Logger.getLogger(String.valueOf(GameImpl.class));

    public GameImpl(){
        gameId = UUID.randomUUID().toString();
        players = new Player[4];
        IntStream.range(0,4)
                .forEach(i -> {
                   players[i] = new Dummybot(i);
                });
        gameState = new GameState();
        gameService = new GameService();
    }

    @Override
    public void run() {
        Thread.currentThread().setName(gameId);
        logger.debug(gameId + " game is starting");
        play();
    }


    void play(){

        while (!gameState.isFinished()){
            userActionCount++;

            int turn = gameState.getTurn();
            Player player = players[turn];

            player.play(gameState);

            if(userActionCount == 16 && gameState.getGiveCardCount() !=3){
                gameState.giveFourCardAllOfPlayer();
                userActionCount = 0;
            }
            gameState.incrementTurn();
            count++;
        }

        //if game finished, last player must take discarded cards.
        gameService.calculateUserPoint(gameState,gameState.getDiscardedCards(),players[gameState.getTurn()],true);
        //TODO calculate majority
        calculateMajority(players);



        logger.debug(gameId + " game has been finished");
        logger.debug(gameId + " game Collected Card Index : " + gameState.getCollectedCardIndex());
        logger.debug(gameId + " game count : " + count);

        IntStream.range(0,4).forEach(i -> logger.debug(gameId + " Player "+ i + " " + players[i].getPoint()));


    }

    private void calculateMajority(Player[] players) {

    }

    private int calculateScoreDiscardedCard() {
        gameState.getDiscardedCards();//TODO
        return 1;
    }



}
