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
    public Month getMonth() {
        return month;
    }
    public void setMonth(Month month) {
        this.month = month;
    }
    public int getLog() {
        return log;
    }
    public void setLog(int log) {
        this.log = log;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
}
