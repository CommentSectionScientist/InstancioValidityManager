package org.example;

import java.time.LocalDate;

@ValidityDate(date = "2023-01-01")
public class EntityData extends AbstractEntityData{

    LocalDate getDate(){
        return validityManager.getDate();
    }
}
