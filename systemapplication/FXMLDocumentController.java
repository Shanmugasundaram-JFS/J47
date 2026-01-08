/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author sunda
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane task;
    @FXML
    private TextField taskinput;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    private ObservableList<Todomodel> ss;
    private TodoService ts=new TodoService();
    @FXML
    private ListView tasklist;
    long date;
    @FXML
    private Button refresh;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try{
        ss =ts.getTask();
        tasklist.setItems(ss);
        
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            System.out.println(ex);
        }
        
    }    

    @FXML
    private void add(ActionEvent event)throws ClassNotFoundException, SQLException {
        String s=ts.addTask(taskinput.getText());
        if(s.equals("Success"))
        {
            ss.clear();
            ss =ts.getTask();
            tasklist.setItems(ss);
        }
     
    }

    @FXML
    private void delete(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        Todomodel tm =(Todomodel) tasklist.getSelectionModel().getSelectedItem();
        System.out.println(tm.getTaskId());
        String result=ts.deleteTask(tm.getTaskId());
        if(result.equals("Success"))
        {
           ss.remove(tm);
        }

    }

    
    @FXML
    private void refresh(ActionEvent event) throws ClassNotFoundException, SQLException 
    {
        System.out.println(new Date(date));
        ss.clear();
        ss=ts.getTask();
        tasklist.setItems(ss);
    }
    
    
    }
    
