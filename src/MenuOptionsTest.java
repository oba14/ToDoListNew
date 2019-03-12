import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MenuOptionsTest {


    @Test
    public void testCountTasksMarkedDone() {
        // Setup
        final long expectedResult = 6;

        // Run the test
        final long result = MenuOptions.countTasksMarkedDone();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCountTasksMarkedNotDone() {
        // Setup
        final long expectedResult = 9;

        // Run the test
        final long result = MenuOptions.countTasksMarkedNotDone();

        // Verify the results
        assertEquals(expectedResult, result);
    }

}
