package org.launchcode.techjobs.oo;

import java.util.Objects;

import static java.lang.System.lineSeparator;


public class Job extends JobField {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.      <---- DONE
    //Constructor 1: initialize a unique ID
    public Job() {
        id = nextId;
        nextId++;
    }

    //Constructor 2: Calls the first constructor & passes in the other five fields
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.    <---- DONE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.   <---- DONE
    //Getters for fields (aside from nextID)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }


    //Setters for fields (aside from id and nextID)
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }


    //TODO: Create a toString method using TDD
    @Override
    public String toString() {
        String newline = System.lineSeparator();
        if(getName()==null && getEmployer()==null && getLocation()==null && getPositionType()==null && getCoreCompetency()==null){
            return "OOPS! This job does not seem to exist.";
        } else {
            return newline +
                    "ID: " + getId() + newline +
                    "Name: " + (getName() == null || getName().isEmpty() ? "Data not available" : getName()) + newline +
                    "Employer: " + (getEmployer() == null || getEmployer().getValue().isEmpty() ? "Data not available" : getEmployer()) + newline +
                    "Location: " + (getLocation() == null || getLocation().getValue().isEmpty() ? "Data not available" : getLocation()) + newline +
                    "Position Type: " + (getPositionType() == null || getPositionType().getValue().isEmpty()? "Data not available" : getPositionType()) + newline +
                    "Core Competency: " + (getCoreCompetency() == null || getCoreCompetency().getValue().isEmpty() ? "Data not available" : getCoreCompetency()) + newline;
        }
        }


}

//Ternary: condition ? exprIfTrue : exprIfFalse