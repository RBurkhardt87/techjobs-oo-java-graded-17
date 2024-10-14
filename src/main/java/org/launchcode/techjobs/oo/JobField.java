package org.launchcode.techjobs.oo;

public abstract class JobField {

    //TODO: Declare the common fields:
    private int id;
    private static int nextId = 1;
    private String value;

    //TODO: Code the constructors:
    public JobField(){
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //TODO: Generate getters/setters:
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    //TODO: Add the toString() method:


    @Override
    public String toString() {
        return value;
    }

    //intelliJ suggested creating an isEmpty() method to check for empty fields because of inconvertible types.
    //isEmpty worked on the name because it was a String, but the others were objects the classes
    public boolean isEmpty(){
        return getValue().isEmpty();
    }
}
