/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.myapp;

import static com.java.myapp.purify.ASCII2Unicode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chaiwat
 */
public class TBView {
    Connection connect = null;
    Statement s = null;
    private static String[] fields;
    
    // get list project on databases
    public void loadShowTable(DefaultTableModel model,int index)
    {
        this.fieldViews(model);
    }
    
    public void fieldViews(DefaultTableModel model)
    {
        // connect แบบ mysql
        int size = 0;
        int row = 0;
        try{// assign user and password 
            projectdatabase dbconfig = new projectdatabase();
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://"+dbconfig.getHost()+"/"+dbconfig.getDBName() +
                        "?user="+dbconfig.getUsername()+"&password="+dbconfig.getPasswords());

            s = connect.createStatement();
            
            //Query for load all project on server
            String sql = "desc  ";

            ResultSet rec = s.executeQuery(sql);
            rec.last();
            size = rec.getRow();
            fields = new String[size];
            rec.beforeFirst();
           
            //Clear list all old items on cb
            //cb.removeAllItems();
            while((rec!=null) && (rec.next()))
            {	
                //cb.addItem(ASCII2Unicode(rec.getString("projdetails")));
                fields[row]=ASCII2Unicode(rec.getString("Field"));
                row++;
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "error:"+e.getMessage());
            e.printStackTrace();
        }
    }
    
}
