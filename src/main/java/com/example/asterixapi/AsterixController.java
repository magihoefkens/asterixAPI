package com.example.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("asterix/characters")
@RequiredArgsConstructor
public class AsterixController {
    private final CharacterService service;
    @GetMapping
    public List<Character> getAllCharacter(){

        return List.of(
                new Character("1", "Asterix", 35, "Krieger"),
                new Character("2", "Obelix", 35, "Lieferant"),
                new Character("3", "Miraculix", 60, "Druide"),
                new Character("4", "Majestix", 60, "Häuptling"),
                new Character("5", "Troubadix", 25, "Barden"),
                new Character("6", "Gutemine", 35, "Häuptlingsfrau"),
                new Character("7", "Idefix", 5, "Hund"),
                new Character("8", "Geriatrix", 70, "Rentner"),
                new Character("9", "Automatix", 35, "Schmied"),
                new Character("10", "Grockelix", 35, "Fischer")
        );


    }
    @PostMapping
    public Character saveCharacter(@RequestBody Character character){
        return service.saveCharacter(character);
    }

}
