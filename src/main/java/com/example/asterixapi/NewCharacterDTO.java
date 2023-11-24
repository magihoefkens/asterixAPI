package com.example.asterixapi;

import lombok.With;

@With

public record NewCharacterDTO(String name, int age, String profession) {
}
