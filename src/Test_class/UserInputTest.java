package Test_class;

/*
 * A class to test UserInput class 
 */
import org.junit.Test;

import User_Input.UserInput;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class UserInputTest {

 

    @Test
    public void testGiveTitle() {
        // Setup
        final String expectedResult = "obaid";

        // Run the test
        final String result = UserInput.giveTitle();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    
    @Test
    public void testGiveDueDate() {
        // Setup
        final LocalDate expectedResult = LocalDate.of(2020, 1, 1);

        // Run the test
        final LocalDate result = UserInput.giveDueDate();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGiveStatus() {
        // Setup
        final String expectedResult = "pending";

        // Run the test
        final String result = UserInput.giveStatus();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGiveProject() {
        // Setup
        final String expectedResult = "family";

        // Run the test
        final String result = UserInput.giveProject();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
