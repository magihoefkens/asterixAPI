package com.example.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepo extends MongoRepository<Character,String> {

    public Optional<Character> findByName(String name);
    public Optional<Character> findByAge(int age);
    public Optional<Character> findByProfession(String profession);
    public Optional<List<Character>> findAllByProfession(String profession);


}
