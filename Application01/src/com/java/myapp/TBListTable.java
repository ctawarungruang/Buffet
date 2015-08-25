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
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author DAMASAC
 */
public class TBListTable {
    Connection connect = null;
    Statement s = null;
    private static String[] tableName;
    private static String[] tableDetail;
    
    /**
     *
     * List of project for use to show on project
     */
    
    
    // get list project on databases
    public void loadListTable(DefaultListModel model,int index)
    {
        String projname;
        // connect แบบ mysql
        try{// assign user and password 
            projectdatabase dbconfig = new projectdatabase();
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://"+dbconfig.getHost()+"/"+dbconfig.getDBName() +
                        "?user="+dbconfig.getUsername()+"&password="+dbconfig.getPasswords());

            s = connect.createStatement();
            
            projectList projls = new projectList();
            projname=projls.getProjName(index);
            
            //Query for load all project on server
            String sql = "SELECT * FROM  db_listtables ";
            sql = sql+"where projname=\""+projname+"\" ";
            //sql = sql+"where projname=\"file43\" ";
            sql = sql+"order by tb_order ";

            ResultSet rec = s.executeQuery(sql);
            // get row count
            rec.last();
            int size=0;
            size = rec.getRow();
            tableName = new String[size];
            tableDetail = new String[size];
            rec.beforeFirst();
            //JOptionPane.showMessageDialog(null, "SQL:"+sql);
            //System.out.println(ASCII2Unicode(sql));
           
            //Clear list all old items on cb
            //model.clear();
            //model.addElement("xxxx");
            //model.clear();
            
            model.clear();
            int row=1;
            while((rec!=null) && (rec.next()))
            {	
                //model.addElement(ASCII2Unicode(rec.getString("tb_name")).toUpperCase()+": "+ASCII2Unicode(rec.getString("tb_detail")));
                model.addElement(row+"-"+ASCII2Unicode(rec.getString("tb_name")).toUpperCase());
                //System.out.println(ASCII2Unicode(rec.getString("tb_name")));
                tableName[row-1]=ASCII2Unicode(rec.getString("tb_name"));
                tableDetail[row-1]=ASCII2Unicode(rec.getString("tb_detail"));
                row++;
            }
            //ls = new JList( model );
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "error:"+e.getMessage());
            e.printStackTrace();
        }
        
        
    }
    public static String getTableName(int index)
    {
        return tableName[index];
    }
    public static String getTableDetail(int index)
    {
        return tableDetail[index];
    }
}
