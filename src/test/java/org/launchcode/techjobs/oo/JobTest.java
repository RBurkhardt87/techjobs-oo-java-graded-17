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
        String actual1 = String.valueOf(job3.getEmployer());
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
        String actual4 = String.valueOf(job3.getCoreCompetency());
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
}
