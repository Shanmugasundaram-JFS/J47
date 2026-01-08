/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author sunda
 */
public class TodoService 
{
        TodoRepository tsr = new TodoRepository();
   
    public String removeTask(){
        return null;
    }
    public ObservableList<Todomodel> getTask() throws ClassNotFoundException, SQLException{
        return tsr.getTasks();
    }

    String deleteTask(String taskId) throws ClassNotFoundException, SQLException {
        return tsr.deleteTaskByTaskId(taskId);
    }

    String addTask(String text) throws ClassNotFoundException, SQLException {
        Date d = new Date();
        String taskId = "TSK-"+d.getTime();
        return tsr.addTask(text,taskId);
    }

    
}