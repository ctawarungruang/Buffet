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
public class projectdatabase {
    private final String host;
    private final String username;
    private final String passwords;
    private final String usedbname;
    public static String dbhost;
    public static String dbusername;
    public static String dbpasswords;
    public static String dbusedbname;
    public projectdatabase(){
        this.host = "www.cascap.in.th";
        this.username = "purify";
        this.passwords = "purifybykie";
        this.usedbname = "buffete_center";
        // default constructur
    }
    public void dbconfig()
    {
        dbhost=this.host;
        dbusername=this.username;
        dbpasswords=this.passwords;
        dbusedbname=this.usedbname;
    }
    public void dbconfig(String vhost,String vuser, String vpass, String vdb)
    {
        dbhost=vhost;
        dbusername=vuser;
        dbpasswords=vpass;
        dbusedbname=vdb;
    }
    
    public static String getHost()
    {
        return dbhost;
    }
    
    public static String getUsername()
    {
        return dbusername;
    }
    
    public static String getPasswords()
    {
        return dbpasswords;
    }
    
    public static String getDBName()
    {
        return dbusedbname;
    }
    
    public static String getDBTableName()
    {
        return "buffete_tbdata";
    }
    
}
