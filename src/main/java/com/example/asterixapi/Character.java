package com.example.asterixapi;

import lombok.Data;
import lombok.With;
@With

public record Character(String id, String name, int age, String profession) {

    public Character name(String name){
        return new Character(this.id,name,this.age,this.profession);
    }
    public Character age(int age){
        return new Character(this.id,this.name,age,this.profession);
    }

    public Character profession(String profession){
        return new Character(this.id,this.name,this.age,profession);
    }
}
