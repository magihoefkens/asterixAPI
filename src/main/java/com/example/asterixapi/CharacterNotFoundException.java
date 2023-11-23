package com.example.asterixapi;

public class CharacterNotFoundException extends Exception {
    public CharacterNotFoundException() {
    }

    public CharacterNotFoundException(String message) {
        super(message);
    }
}
