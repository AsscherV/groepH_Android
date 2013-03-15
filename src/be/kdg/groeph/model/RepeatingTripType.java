package be.kdg.groeph.model;

import be.kdg.groeph.model.Null.Nullable;

import java.io.Serializable;

public class RepeatingTripType implements Serializable, Nullable {

    private int id;

    private String repeatingType;

    public RepeatingTripType() {

    }

    public String getRepeatingType() {
        return repeatingType;
    }

    public void setRepeatingType(String repeatingType) {
        this.repeatingType = repeatingType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public String toString() {
        return repeatingType;
    }

}
