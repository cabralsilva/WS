package com.ibolt.services;

import com.ibolt.util.ConnectFilemaker;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlServices {
    ConnectFilemaker cf;
    Statement sttm;

    public void CreateConnection() throws Exception {
        System.out.println("Criando a Conexão");
        this.cf = new ConnectFilemaker();
        this.sttm = this.cf.getCon().createStatement();
    }

    public void CloseConnection() {
        System.out.println("Fechou a Conexão");
        try {
            this.sttm.close();
            this.cf.getCon().close();
            super.finalize();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public ConnectFilemaker getCf() {
        return this.cf;
    }

    public void setCf(ConnectFilemaker cf) {
        this.cf = cf;
    }

    public Statement getSttm() {
        return this.sttm;
    }

    public void setSttm(Statement sttm) {
        this.sttm = sttm;
    }
}