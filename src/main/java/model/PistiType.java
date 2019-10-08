package model;

public enum  PistiType {
    PISTI("Normal Pisti"),PISTI_WITH_JOKER("Pisti with Joker"),NORMAL("Normal");

    private String type;

    PistiType(String type) {
        this.type = type;
    }

    public String value(){
        return type;
    }

}
