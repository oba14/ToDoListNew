package Test_class;

/*
 * Test method to test MenuOptions class
 */

import org.junit.Test;

import Main_class.MenuOptions;

import static org.junit.Assert.assertEquals;

public class MenuOptionsTest {


	@Test
	public void testCountTasksMarkedDone() {
		// Setup
		final long expectedResult = 0L;

		// Run the test
		final long result = MenuOptions.countTasksMarkedDone();

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testCountTasksMarkedNotDone() {
		// Setup
		final long expectedResult = 0L;

		// Run the test
		final long result = MenuOptions.countTasksMarkedNotDone();

		// Verify the results
		assertEquals(expectedResult, result);
	}
}
