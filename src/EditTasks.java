
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * This class is for editing the already created tasks.
 * We have to provide title name of the task to perform any modification.
 *
 *
 * @author Obaid Aftab
 * @version 2019.03.01
 */

public class EditTasks {

    /**
     * This method first checks if the file exist or not. If it exists then it
     * reads all the Task objects in the given file. It then asks the user to
     * give the title of the task they wish to change. If the task is found it
     * gives options to the user for how he wants to manipulate the data.
     *
     * the information in the file.
     *
     *
     * @return Returns an updated List based on the actions performed by the user.
     */
    public static List<Object> editTasksFromFile() throws IOException {

        UserInput addData = new UserInput();
        Tasks taskObject;
        List<Object> listOfTasks = new ArrayList<>(); // List for storing objects.
        File taskList = new File("/Users/obaidaftab/eclipse-workspace/ToDoListOb/tasksList.txt");


        if(taskList.exists() && !taskList.isDirectory()) {

            //File f = new File(fileName);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(taskList));
            //try {

            try {
                listOfTasks = (List<Object>) ois.readObject();

                System.out.println("----------------------------------- ");
                System.out.println("Edit tasks by providing task title |");
                System.out.println("(1) Update Task                    |");
                System.out.println("(2) Mark task as done              |");
                System.out.println("(3) Remove task                    |");
                System.out.println("----------------------------------- ");

                Scanner reader = new Scanner(System.in);  // Reading from System.in
                int options  = reader.nextInt(); // Scans the next token of the input as an int.

                boolean optionCheck = true;

                // WHILE LOOP TO CHECK IF CORRECT MENU OPTION IS ADDED
                while (optionCheck)
                {

                    if(options < 4 && options > 0) {
                        //optionCheck = false;
                        break;
                    }else
                        System.out.println("Add correct option");
                    options = reader.nextInt();
                }
                switch(options){

                    case 1: // UPDATE TASK

                        // INIRIALIZING OBJECT OF CLASS TASKS
                        taskObject = new Tasks();
                        System.out.println("> Enter title of the task you wish to update \n");
                        Scanner reader4 = new Scanner(System.in);
                        String titleToSearch = reader4.nextLine();

                        for (int i=0; i < listOfTasks.size(); i++) {

                            if (titleToSearch.toLowerCase().trim().equals(((Tasks) listOfTasks.get(i)).getTitle())) {

                                System.out.println("> Details of the task you wish to update: \n");
                                System.out.println(((Tasks) listOfTasks.get(i)).getDetails());
                                taskObject = addData.addNewTask();
                                System.out.println("> Updated Task: \n");
                                System.out.println(taskObject.getDetails());
                                listOfTasks.set(i, taskObject);
                                System.out.println("> Object found");
                                break;

                            }
                            else {
                                //System.out.println("> No such task exists in database");
                            }
                        }
                        break;

                    case 2: // MARK TASK AS DONE

                        System.out.println("> Give title of the task to mark it As completed");
                        taskObject = new Tasks();
                        Scanner reader5 = new Scanner(System.in);
                        String titleToSearch2 = reader5.nextLine();

                        for (int i=0; i < listOfTasks.size(); i++) {

                            if (titleToSearch2.toLowerCase().trim().equals(((Tasks) listOfTasks.get(i)).getTitle())) {
                                taskObject = (Tasks) listOfTasks.get(i);
                                System.out.println("> " + i++ + taskObject.getDetails());
                                taskObject.setStatus("completed");
                                listOfTasks.set(i, taskObject);
                                System.out.println("> Updated status " + ((Tasks) listOfTasks.get(i)).getDetails());
                                break;
                            }
                            else {
                                System.out.println("> No such task exists in database");
                            }
                        }
                        break;

                    case 3: // REMOVE TASK

                        // INIRIALIZING OBJECT OF CLASS TASKS
                        taskObject = new Tasks();
                        System.out.println("> Enter title of the task you wish to update \n");
                        Scanner reader6 = new Scanner(System.in);
                        String titleToSearch3 = reader6.nextLine();

                        Iterator<Object> it = listOfTasks.iterator();
                        while(it.hasNext()) {
                            Tasks ds = (Tasks) it.next();
                            if (titleToSearch3.toLowerCase().trim().equals(ds.getTitle())) {
                                it.remove();
                                System.out.println("> Task has been removed");
                                break;
                            }
                        }
                        //System.out.println("No such task exists in the database");
                        break;
                }
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //System.out.println("The Object has been read from the file");
            ois.close();
        }else {
            System.out.println("File does not exist");
        }
        return listOfTasks;
    }
}
