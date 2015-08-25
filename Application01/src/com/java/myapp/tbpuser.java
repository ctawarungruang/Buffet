/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.myapp;

/**
 *
 * @author DAMASAC
 */
public class tbpuser {
    private String u_pid;
    private String u_name;
    private String u_surname;
    public static String pid;
    public static String name;
    public static String surname;
    
    public void tbpuser()
    {
        // defaul value on constructor
        this.u_pid = "";
        this.u_name = "Un define";
        this.u_surname = "";
    }
    
    public void setupUser()
    {
        pid=this.u_pid;
        name=this.u_name;
        surname=this.u_surname;
    }
    
    public void setupUser(String vpid,String vname,String vsurname)
    {
        pid=vpid;
        name=vname;
        surname=vsurname;
    }
    
    public void setPid(String vpid)
    {
        pid=vpid;
    }
    public void setName(String vname)
    {
        name=vname;
    }
    public void setSurname(String vsurname)
    {
        surname=vsurname;
    }
    
    public static String getPid()
    {
        return pid;
    }
    
    public static String getName()
    {
        return name;
    }
    
    public static String getSurname()
    {
        return surname;
    }
    
}
