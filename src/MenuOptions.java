import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOptions {

    static List<Object> listForWriting = new ArrayList<>(); // list for writing new tasks

    public static void printWelcome()
    {
        System.out.println("----------------------------------------------  ");
        System.out.println(">> Welcome to ToDoly                           |");
        System.out.println("You have " + countTasksMarkedNotDone() + " tasks to do and " + countTasksMarkedDone() + " tasks are done   |" );
        System.out.println("(1) Show Task List (by date or project)        |");
        System.out.println("(2) Add New Task                               |");
        System.out.println("(3) Edit Task (update, mark as done, remove)   |");
        System.out.println("(4) Save                                       |");
        System.out.println("(5) Quit                                       |");
        System.out.println("----------------------------------------------  ");


        addChoices();
    }

    /**
     * When the ToDolist starts the first thing the program does is to read the tasks from the file.
     */
    public static void alwaysFirstRead() {
        //Always read from the file first to store a copy of the tasks stored in the file.
        try {
            listForWriting = ReadWriteTask.alwaysReadListFromFile();
            for(Object first: listForWriting) {
                //System.out.println("> " + ((Tasks) first).getDetails());
            }
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }

    /**
     * This method counts how many tasks have been completed
     */
    public static long countTasksMarkedDone() {
        return listForWriting.stream().filter(s -> "completed".equals(((Tasks) s).getStatus()))
                .count();
    }

    /**
     * This method counts how many tasks are pending
     */
    public static long countTasksMarkedNotDone() {
        return listForWriting.stream().filter(s -> "pending".equals(((Tasks) s).getStatus()))
                .count();

    }

    /**
     * This method asks the user to provide options related to the tasks.
     *
     */

    public static void addChoices() {

        UserInput addData = new UserInput(); // creating object of class UserInput

        System.out.println("Choose options 1-4");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int options  = reader.nextInt(); // Scans the next token of the input as an int.
        boolean optionCheck = true;

        // WHILE LOOP TO CHECK IF CORRECT MENU OPTION IS ADDED
        while (optionCheck)
        {
            if(options < 6 && options > 0) {
                //optionCheck = false;
                break;
            }else
                System.out.println("Add correct option");
            options = reader.nextInt();
        }

        switch(options){

            case 1:

                // Show task list
                System.out.println("Option 1 selected: Show Task list");

                try {

                    // CALLING ReadFromFile METHOD FROM CLASS ReadWriteTask
                    ReadWriteTask.readListFromFile();

                } catch (IOException e1) {
                    // catch block
                    e1.printStackTrace();
                }
                printWelcome();
                break;

            case 2:
                // Add anew task

                // INITIALIZING OBJECT OF CLASS TASKS
                Tasks taskObject = new Tasks();

                System.out.println("Option 2 selected");
                System.out.println("Add a new Task");
                try {
                    // Call method to add new tasks
                    taskObject = addData.addNewTask();
                    listForWriting.add(taskObject); // adding newly created task to arrayList
                }catch (NullPointerException e) {
                    System.out.println("Added wrong details");
                }

                System.out.println("Do you want to add another task");
                System.out.println("Enter Yes to add new task or press any letter to Go Back to Main Menu");
                Scanner addTaskChoice = new Scanner(System.in);

                while(addTaskChoice.nextLine().trim().toLowerCase().equals("yes")) {
                    try {
                        // Call method to add new tasks
                        System.out.println("Please add new Task");
                        taskObject = addData.addNewTask();
                        listForWriting.add(taskObject);
                        System.out.println("\n");
                        System.out.println("Do you want to add another task");
                        System.out.println("Enter YES to add new task or press any letter to Go Back to Main Menu");
                        //addTaskChoice.nextLine();
                    }catch (NullPointerException e) {
                        System.out.println("Added wrong details");
                    }
                }
                printWelcome();
                break;

            case 3:
                // Edit tasks
                System.out.println("Option 3 selected");
                System.out.println("(3) Edit Task (update, mark as done, remove)");
                try {
                    listForWriting = EditTasks.editTasksFromFile();
                    int k =1;
                    for(Object first: listForWriting) {

                        System.out.println(">" + k++ + " " + ((Tasks) first).getDetails());
                    }
                } catch (IOException e) {
                    // catch block
                    e.printStackTrace();
                }
                printWelcome();
                break;

            case 4:
                //save the list of tasks

                ReadWriteTask inputOutput= new ReadWriteTask();
                System.out.println("> Option 4 selected");
                System.out.println("> Save");
                try {
                    inputOutput.writeListToFile(listForWriting);
                } catch (Exception e) {
                    // catch block
                    e.printStackTrace();
                }
                printWelcome();
                break;

            case 5:
                System.out.println("You have opted to quit");
                System.out.println("Good Bye");
                System.exit(0);
                break;

            default:
                System.out.println("invalid option");
        }
    }

}
