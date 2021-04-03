/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.whoistheimpostor.model;

import java.io.Serializable;

/**
 *
 * @author ronie
 */
public class Log implements Serializable{
    private Month month;
    private int log;
    private String msg;
    private String user;

    /**
     * @return the month
     */
    public Month getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(Month month) {
        this.month = month;
    }

    /**
     * @return the log
     */
    public int getLog() {
        return log;
    }

    /**
     * @param log the log to set
     */
    public void setLog(int log) {
        this.log = log;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    
}
