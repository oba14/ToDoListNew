
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to add task details (title, duedate, status, project).
 * It contains the setter and getter methods.
 * It has 4 private field that can be accessed by the setter and getter methods within the class.
 *
 * @author Obaid Aftab
 * @version 2019.03.01
 */

public class Tasks implements Serializable{


    private static final long serialVersionUID = 1L;
    private String taskTitle;
    private LocalDate dueDate;
    private String status;
    private String project;

    public Tasks() {} // Constructor with no parameters

    // Constructor that takes 4 parameters provided by the user in class UserInput.
    public Tasks(String taskTitle, LocalDate dueDate, String status, String project) {

        this.taskTitle = taskTitle;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
    }

    /**
     * Return the title of task.
     *
     */
    public String getTitle()
    {
        return taskTitle;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title)
    {
        this.taskTitle = title;
    }

    /**
     *
     * @return due date.
     */
    public LocalDate getDueDate()
    {
        return dueDate;
    }

    /**
     *
     * @param dueDate
     */
    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    /**
     * @return status of the project.
     */
    public String getStatus()
    {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * Return project name
     */
    public String getProject()
    {
        return project;
    }

    /**
     *
     * @param project
     */
    public void setProject(String project)
    {
        this.project = project;
    }

    /**
     *
     * Return a string containing details
     */
    public String getDetails()
    {
        return (
                " Title = " + taskTitle + ", " + " Due date = " + dueDate + ", " + " Status = " + status + ", " + " project = " + project);
    }

}





