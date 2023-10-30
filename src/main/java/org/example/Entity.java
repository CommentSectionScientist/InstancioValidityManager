package org.example;

import java.time.LocalDate;

public class Entity {

    EntityData entityData = new EntityData();

    public LocalDate getDate(){
        return entityData.getDate();
    }
}
