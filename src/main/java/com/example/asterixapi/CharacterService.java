package com.example.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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
    public Character findByName(String name)throws CharacterNotFoundException{
        return repo.findByName(name)
                .orElseThrow(()->new CharacterNotFoundException("The Character with the name: "+ name+" couldn't be found"));

    }
    public Character findByAge(int age)throws CharacterNotFoundException{
        return repo.findByAge(age)
                .orElseThrow(()-> new CharacterNotFoundException("The Character with the age"+age+" couldn#t be found"));
    }

    public Character findByProfession(String profession)throws CharacterNotFoundException{
        return repo.findByProfession(profession)
                .orElseThrow(()->new CharacterNotFoundException("The Character with the profession: "+ profession+" couldn't be found"));

    }
    public List<Character> findAllByProfession(String profession)throws CharacterNotFoundException{
        return repo.findAllByProfession(profession)
                .orElseThrow(()->new CharacterNotFoundException("For the profession:"+ profession+" no characters found"));
    }
}
