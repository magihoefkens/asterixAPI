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
    public List<Character> saveCharacters(@RequestBody List<NewCharacterDTO> characters){
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

    @GetMapping("/findById/{id}")
    public Character findById(@PathVariable String id) throws CharacterNotFoundException{
        return service.getCharacterById(id);
    }

    @GetMapping("/findByName/{name}")
    public Character findByName(@PathVariable String name) throws CharacterNotFoundException{
        return service.findByName(name);
    }
    @GetMapping("/findByAge/{age}")
    public Character findByAge(@PathVariable int age) throws CharacterNotFoundException{
        return service.findByAge(age);
    }
    @GetMapping("/findByProfession/{profession}")
    public Character findByProfession(@PathVariable String profession) throws CharacterNotFoundException{
        return service.findByProfession(profession);
    }
    @GetMapping("/findAllByProfession/{profession}")
    public List<Character> findAllByProfession(@PathVariable String profession) throws CharacterNotFoundException{
        return service.findAllByProfession(profession);
    }
    @GetMapping("/findAverageAgeByProfession/{profession}")
    public double findAverageAgeByProfession(@PathVariable String profession) throws CharacterNotFoundException{
        return countAverage(service.findAllByProfession(profession));
    }
    private double countAverage(List<Character> characters){
        double average=0;

        for (Character character:characters
             ) {
            average+=character.age();
            
        }
        return average/characters.size();
    }
}
