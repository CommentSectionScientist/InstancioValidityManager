package org.example;

import java.time.LocalDate;

public class ValidityManager {
    private final ValidityDate validityDate;
    public ValidityManager(AbstractEntityData abstractEntityData) {
        this.validityDate = abstractEntityData.getClass().getAnnotation(ValidityDate.class);
    }

    LocalDate getDate(){
        return LocalDate.parse(validityDate.date());
    }
}
