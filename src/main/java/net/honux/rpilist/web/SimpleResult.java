package net.honux.rpilist.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SimpleResult implements Serializable {

    @JsonProperty
    private String status;
    @JsonProperty
    private String message;

    public SimpleResult(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
