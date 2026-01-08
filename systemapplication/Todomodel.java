/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

/**
 *
 * @author sunda
 */
public class Todomodel 
{
    private String TaskId;
    private String Task;


    public String getTaskId() {
        return TaskId;
    }
    
    @Override
    public String toString() 
    {
       return Task;
        
    }

    public void setTaskId(String TaskId) {
        this.TaskId = TaskId;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String Task) {
        this.Task = Task;
    }

    
}
    
