package character;

import java.util.UUID;

/*
 * This is the base class of Hero and Monster
 * */
public class Character {
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String name;
    private UUID id;

    public Character(String name){
        this.name = name;
        this.id = UUID.randomUUID();
    }
}
