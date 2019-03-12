/**
 * Main class of A Simple To Do List
 * Tasks are created and edited by the user.
 *
 * @author Obaid.Aftab
 * @version 2019.03.01
 */

public class MainStartToDoList {

    /**
     * Main has call to two methods.
     * alwaysFirstRead() -> this will read the tasks from the file.
     * printWelcome() -> this prints the main menu and has a call to add choices method
     *
     * @param args
     */
    public static void main(String[] args) {

        MenuOptions.alwaysFirstRead(); // Call to this method will check if a file with already created tasks exist.
        MenuOptions.printWelcome(); // Call to this method will print the menu options and start the program.

    }
}

