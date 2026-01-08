/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
public class TodoRepository 
{
    private static Connection con = null;
    
    private Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ToDolist", "postgres", "Shm@20012022");
    }
    
    ObservableList<Todomodel> getTasks() throws ClassNotFoundException, SQLException
    {
        ObservableList<Todomodel> l = FXCollections.observableArrayList();
        if(con==null)
            con=getConnection();
        
        Statement smt = con.createStatement();
        ResultSet rs =smt.executeQuery("select * from todo");
        while (rs.next()) {            
            Todomodel tm = new Todomodel();
            tm.setTask(rs.getString("task"));
            tm.setTaskId(rs.getString("taskid"));
            l.add(tm);
        }
        return l;
    }

    String deleteTaskByTaskId(String taskId) throws ClassNotFoundException, SQLException {
        if(con==null)
            con=getConnection();
        PreparedStatement ps = con.prepareStatement("delete from todo where taskid=?");
        ps.setString(1, taskId);
        int i=ps.executeUpdate();
        if(i>0)
        {
            return "Success";
        }
        return "Failure"; 
    }

    String addTask(String task, String taskId) throws ClassNotFoundException, SQLException {
        if(con==null)
            con=getConnection();
       PreparedStatement ps = con.prepareStatement("insert into todo values(?,?)");
       ps.setString(1, taskId);
       ps.setString(2, task);
       int i =ps.executeUpdate();
       if(i>0)
       {
           return "Success";
       }
       return "Failure";
    }
}
  

    
