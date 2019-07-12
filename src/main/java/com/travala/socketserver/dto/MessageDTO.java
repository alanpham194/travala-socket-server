package com.travala.socketserver.dto;

import com.fasterxml.jackson.databind.JsonNode;

public class MessageDTO {
    private String token;
    private JsonNode data;

    public String getToken() {
        return token;
    }

    public MessageDTO setToken(String token) {
        this.token = token;
        return this;
    }

    public JsonNode getData() {
        return data;
    }

    public MessageDTO setData(JsonNode data) {
        this.data = data;
        return this;
    }
}
