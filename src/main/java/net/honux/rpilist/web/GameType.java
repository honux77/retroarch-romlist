package net.honux.rpilist.web;

import org.springframework.beans.factory.annotation.Value;

public enum GameType {

    ARCADE("/arcade"),
    NES("/nes"),
    SNES("/snes");

    private String romPath;

    private final static String listname = "/gamelist.xml";
    private String dir;

    private GameType(String dir) {
        this.dir = dir;
    }

    public String dir() {
        return dir;
    }

    public String listFilename() {
        return dir + listname;
    }
}
