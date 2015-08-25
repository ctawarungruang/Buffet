/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    เป้าหมายของ projectList คือ
        -> ได้ list ของ project ออกมาจาก Table project
            แล้ว ส่งข้อมูลออกไปยัง array หรือ list ของ string เพื่อนำไปใช้แสดงข้อมูล
 */
package com.java.myapp;

import static com.java.myapp.purify.ASCII2Unicode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author DAMASAC
 */
public class projectList {
    Connection connect = null;
    Statement s = null;
    private static String[] projname;
    
    /**
     *
     * List of project for use to show on project
     */
    
    
    // get list project on databases
    public void loadProjectList(JComboBox cb)
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
            String sql = "SELECT *,substr(projdetail,1,40) as projdetails FROM  project order by projname ";

            ResultSet rec = s.executeQuery(sql);
            rec.last();
            size = rec.getRow();
            projname = new String[size];
            rec.beforeFirst();
           
            //Clear list all old items on cb
            cb.removeAllItems();
            while((rec!=null) && (rec.next()))
            {	
                cb.addItem(ASCII2Unicode(rec.getString("projdetails")));
                projname[row]=ASCII2Unicode(rec.getString("projname"));
                row++;
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "error:"+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static String getProjName(int index)
    {
        return projname[index];
    }
}
