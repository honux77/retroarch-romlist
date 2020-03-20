package net.honux.rpilist.web;

public enum GameType {

    ARCADE("arcade"),
    NES("nes"),
    SNES("snes"),
    MEGADRIVE("megadrive"),
    NEOGEO("neogeo");

    private final static String listname = "/gamelist.xml";
    private String dir;

    GameType(String dir) {
        this.dir = dir;
    }

    public String listFilename() {
        return dir + "/" + listname;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
