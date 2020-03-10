package net.honux.rpilist.web;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {

    @JsonProperty
    private String path;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private String imagePath;

    @JsonProperty
    private String rating;

    @JsonProperty
    private String releaseDate;

    @JsonProperty
    private String developer;

    @JsonProperty
    private String publisher;

    @JsonProperty
    private String genre;

    @JsonProperty
    private String players;

    @JsonProperty
    private String playCount;

    @JsonProperty
    private String lastPlayed;


    public Game(String path, String name, String description, String imagePath, String rating,
                String releaseDate, String developer, String publisher, String genre, String players,
                String playCount, String lastPlayed) {
        this.path = path;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.developer = developer;
        this.publisher = publisher;
        this.genre = genre;
        this.players = players;
        this.playCount = playCount;
        this.lastPlayed = lastPlayed;
    }

    public String getInfo() {
        return "Game{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", image='" + imagePath + '\'' +

                '}';

    }

    public String getShortDescription() {
        if (description == null || description.equals("") || description.length() < 10) return "";
        return description.substring(0, 10);
    }

    @Override
    public String toString() {
        return "Game{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", description='" + getShortDescription() + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", rating='" + rating + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", developer='" + developer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", players='" + players + '\'' +
                ", playCount='" + playCount + '\'' +
                ", lastPlayed='" + lastPlayed + '\'' +
                '}';
    }
}
