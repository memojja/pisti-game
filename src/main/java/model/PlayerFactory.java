package model;

/**
 *
 * A factory class to create a player
 */
public class PlayerFactory {

  /**
   * produces bot according to given game
   *
   * @param playerEnum
   * @param index
   * @param gameName
   * @return player
   */
  public Player getPlayer(PlayerEnum playerEnum,int index, String gameName){
    if(PlayerEnum.DUMMY_BOT.equals(playerEnum)){
      return new DummyBot(index,gameName);
    }else if(PlayerEnum.SMART_BOT.equals(playerEnum)){
      return new SmartBot(index,gameName);
    }else{
        throw new RuntimeException("There is no aviable enum." + playerEnum.toString());
    }
  }

}
