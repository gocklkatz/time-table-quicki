package io.gocklkatz;

//Room instances do not change during solving,
//so Room is also a problem fact.
public class Room {

    private String name;

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
