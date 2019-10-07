package model;

public class PlayerFactory {

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
