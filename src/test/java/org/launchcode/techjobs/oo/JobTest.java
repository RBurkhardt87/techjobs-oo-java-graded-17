package org.launchcode.techjobs.oo;

import org.junit.Test;

import javax.swing.text.Position;

import static org.junit.Assert.*;


public class JobTest {

    //TODO: Test the empty constructor: ids of each object shouldn't equal
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(),job2.getId());

}

    // use getters to check the values for assertEquals--There were 2 ways: One that went from job object to param object and then got the value.
    // IntelliJ suggested wrapping the jobObject.paramObject in a String.valueOf, which allowed access to the param object as a String I think....
    // It was kind of tricky doing the assertTrue() without having the new objects stored in their own variables. Not sure if this is done correctly... but it passes
    //TODO: Test the full constructor:
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "Product tester";
        String actual = job3.getName();
        assertEquals(expected, actual);
        assertTrue(job3 instanceof Job);

        String expected1 = "ACME";
        String actual1 = job3.getEmployer().getValue();
        assertEquals(expected1, actual1);
        assertTrue(job3.getEmployer() instanceof Employer);

        String expected2 = "Desert";
        String actual2 = job3.getLocation().getValue();
        assertEquals(expected2, actual2);
        assertTrue(job3.getLocation() instanceof Location);

        String expected3 = "Quality control";
        String actual3 = job3.getPositionType().getValue();
        assertEquals(expected3, actual3);
        assertTrue(job3.getPositionType() instanceof PositionType);

        String expected4 = "Persistence" ;
        String actual4 = job3.getCoreCompetency().getValue();
        assertEquals(expected4, actual4);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }



    //TODO: Test the equals method:
    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job4.equals(job5));
    }



    //TODO: toString should return a blank line before and after the job info
    //use assertEquals to verify
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        String actual = job6.toString();
        boolean actual1 = job6.toString().startsWith(System.lineSeparator());
        boolean actual2 = job6.toString().endsWith(System.lineSeparator());

//        String expected = System.lineSeparator() + System.lineSeparator();
//      assertEquals(expected, actual);     <--- I DO NOT UNDERSTAND HOW TO DO THIS AS AN EQUAL. WHEN I START BUILDING MORE FOR toString, TEST FAILS BECAUSE THEY AREN'T EQUAL ANYMORE

//        assertTrue(actual.startsWith(System.lineSeparator()));
//        assertTrue(actual.endsWith(System.lineSeparator()));
        //What about this... why wouldn't this work. Testing true for true with assertEquals()
        assertEquals(true, actual1);
        assertEquals(true, actual2);
    }



    //TODO: toString should contain a label for each field, followed by the data stored in that field. Each field should be on its own line
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actual = job6.toString();
        String expected = System.lineSeparator() + "ID: " + job6.getId() + System.lineSeparator() + "Employer: " + job6.getEmployer() +
                System.lineSeparator() + "Location: " + job6.getLocation() + System.lineSeparator() + "Position Type: " + job6.getPositionType() +
                System.lineSeparator() + "Core Competencies: " + job6.getCoreCompetency() + System.lineSeparator();
        assertEquals(expected, actual);
    }


    //So... the job will always have an ID. This field can't come up as Data not available because it is set with the constructor and not a arg passed in...right?
    //TODO: If a field is empty, the method should add, “Data not available” after the label.
    @Test
    public void testToStringHandlesEmptyField(){
        Job job6 = new Job();

        String actual = job6.toString();
        String expected = System.lineSeparator() + "ID: " + job6.getId() + System.lineSeparator() + "Employer: Data not available" +
                System.lineSeparator() + "Location: Data not available" + System.lineSeparator() + "Position Type: Data not available" +
                System.lineSeparator() + "Core Competencies: Data not available" + System.lineSeparator();;
        assertEquals(expected, actual);
    }


    //This messes with the test above. I can't just add a field arg in to make them different because neither of the two constructors would allow it. How do I test these two
    //different tests using the empty job constructor
    //TODO: (Optional) If a Job object ONLY contains data for the id field, the method should return, “OOPS! This job does not seem to exist.”
    @Test
    public void testForJobsThatDontExist(){
        Job job6 = new Job();
        String actual = job6.toString();
        String expected = "OOPS! This job does not seem to exist.";
    }
}
