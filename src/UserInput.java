import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * A class that prompts user to add all the details  of a task (title, duedate, status, project).
 * It contains the setter and getter methods.
 *
 * @author Obaid Aftab
 * @version 2019.03.01
 */

public class UserInput{

    /**
     * This method asks user to give details of a new task
     *
     */
    public Tasks addNewTask() {

        String title = giveTitle();
        LocalDate dueDate = giveDueDate();
        String status = giveStatus();
        String project = giveProject();

        // Creating a new task by providing all user defined values as parameter
        Tasks taskObject2 = new Tasks(title, dueDate, status, project);

        return taskObject2;
    }

    /**
     * Method for giving new task a title
     * @return
     */
    public static String giveTitle() {


        //ASK USER TO GIVE TITLE

        System.out.println("Add title:");
        String title = EditTasks.getInput();
        return title;

    }

    /**
     * Method for giving new task a due date
     * @return
     */
    public static LocalDate giveDueDate() {


        /* *********************************
         *
         *  ASK USER FOR A DUE DATE
         */
        System.out.println("Add due date of the task in format: DD-MM-YYYY");
        // Scanner reader2 = new Scanner(System.in);

        // CHECK IF CORRECT DATE FORMAT IS PROVIDED AND ITS NOT IT PAST
        LocalDate dueDate = null;
        while(true) {
            String dateInput = EditTasks.getInput();
            try {

                // FORMAT CHECK
                dueDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH));

                // DATE CHECK (MAKE SURE DATE IS NOT IN PAST)
                if (dueDate.isAfter(LocalDate.now())) {
                    break;

                }else {
                    System.out.println("Cannot add date in past");
                    System.out.println("Add the date again");
                }
            } catch (Exception e) {
                System.out.println("You did not provide the proper format");
                System.out.println("Add the date again");
            }
        }
        return dueDate;

    }

    /**
     * Method for giving new task a status
     * @return
     */
    public static String giveStatus() {

        /* *********************************
         *
         *  ASK USER TO GIVE STATUS OF A PROJECT
         *  it accepts only 2 words, completed/pending
         *  if user enters any other word it will ask the user to enter a right option.
         */
        System.out.println("Status of the task: Completed, Pending ");
        String status= new String();
        while (true) {//while (reader3.hasNextLine()) {
            String temp1 = EditTasks.getInput();
            if (temp1.trim().toLowerCase().equals("completed") || temp1.trim().toLowerCase().equals("pending") )
            {
                System.out.println("Status updated as: " + temp1);
                status = temp1;
                break;
            }else
                System.out.println("You entered a wrong option");
        }
        return status;

    }

    /**
     * Method for assigning a project to newly created task.
     * @return
     */
    public static String giveProject() {

        /**********************************
         *
         * ASK USER FOR PROJECT NAME
         *
         */
        System.out.println("Add name of the project this task will belong to: ");
        String project = EditTasks.getInput();
        return project;

    }
}
