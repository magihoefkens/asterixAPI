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
    public Character getCharacterById(String id) throws CharacterNotFoundException{
        return repo.findById(id)
                .orElseThrow(()->new CharacterNotFoundException("Character mit der Id: "+id+" wurde nicht gefunden!"));
    }
    public List<Character> saveCharacters(List<Character> characters){
        return repo.saveAll(characters);
    }

    public Character updateCharacter(String id, Character character) throws CharacterNotFoundException {
        Character findCharacter=getCharacterById(id);
        return repo.save(character);
    }

    public void delete(String id) throws CharacterNotFoundException{
        Character findCharacter=getCharacterById(id);
        repo.delete(findCharacter);
    }
}
