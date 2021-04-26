/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.whoistheimpostor.model;

/**
 *
 * @author ronie
 */
public enum Month {
    //logs.txt
    January(1),
    February(2),
    March(3),
    April(4),
    May(5),
    June(6),
    July(7),
    August(8),
    September(9),
    October(10),
    November(11),
    December(12);
    
    //worstCase.txt
    //january(1),
    //february(2),
    //march(3),
    //april(4),
    //may(5),
    //june(6),
    //july(7),
    //august(8),
    //september(9),
    //october(10),
    //november(11),
    //december(12);

    private int value;

    Month(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}