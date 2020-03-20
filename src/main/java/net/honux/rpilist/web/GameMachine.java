package net.honux.rpilist.web;

import org.springframework.data.annotation.Id;

import java.util.Set;

public class GameMachine {

    @Id
    private Long id;
    private GameType type;
    private Set<Game> games;

    public GameMachine(GameType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    @Override
    public String toString() {
        return "GameMachine{" +
                "id=" + id +
                ", type=" + type +
                //", games=" + games.size() +
                '}';
    }

}
