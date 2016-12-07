package com.ibolt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.sql.Statement;

public class ConnectFilemaker {
    private Connection con;
    private Statement stmt;

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return this.stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ConnectFilemaker() throws Exception {
        Class.forName("com.filemaker.jdbc.Driver").newInstance();
        //this.con = DriverManager.getConnection("jdbc:filemaker://192.168.100.3/PlanderX", "odbc", "odbc");
        //this.con = DriverManager.getConnection("jdbc:filemaker://10.203.51.242/PlanderHomologacao", "site", "fmjdbc78");
        this.con = DriverManager.getConnection("jdbc:filemaker://10.203.51.242/Plander", "site", "fmjdbc78");
        SQLWarning warning = null;
        warning = this.con.getWarnings();
        while (warning != null) {
            System.out.println("Warning: " + warning);
            warning = warning.getNextWarning();
        }
    }
}