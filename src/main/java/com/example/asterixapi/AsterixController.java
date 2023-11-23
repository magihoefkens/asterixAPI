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

        return service.getAllCharacters();


    }
    @PostMapping
    public List<Character> saveCharacters(@RequestBody List<Character> characters){
        return service.saveCharacters(characters);
    }
    @PutMapping("/{id}")
    public Character update(@PathVariable String id,@RequestBody Character character) throws CharacterNotFoundException{
        return service.updateCharacter(id,character);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id)throws CharacterNotFoundException{
        service.delete(id);
    }



}
