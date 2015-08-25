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
public class TBProject {
    public static String projid;
    public static String projname;
    public static String projdetail;

    TBProject() {
        // defaul value on constructor
        projid = "";
        projname = "";
        projdetail = "";
    }
    
    TBProject(String vprojid, String vprojname, String vprojdetail) 
    {
        projid = vprojid;
        projname = vprojname;
        projdetail = vprojdetail;
    }
    
    public void TBProject()
    {
        projid = "";
        projname = "Un define";
        projdetail = "";
    }
    
    public void setEmpty()
    {
        // defaul value on constructor
        projid = "";
        projname = "";
        projdetail = "";
    }
    
    public void setProjID(String v)
    {
        projid=v;
    }
    public void setProjName(String v)
    {
        projname=v;
    }
    public void setProjDetail(String v)
    {
        projdetail=v;
    }
    public static String getProjID()
    {
        return projid;
    }
    public static String getProjName()
    {
        return projname;
    }
    
    public static String getProjDetail()
    {
        return projdetail;
    }

    
}
