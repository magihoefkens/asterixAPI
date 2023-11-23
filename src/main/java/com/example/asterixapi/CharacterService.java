package com.example.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepo repo;
    public List<Character> getAllCharacters(){
        return repo.findAll();
    }
    public Character saveCharacter(Character character){
        return repo.save(character);
    }
}
