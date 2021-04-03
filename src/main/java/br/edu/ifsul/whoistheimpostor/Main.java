/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.whoistheimpostor;

import br.edu.ifsul.whoistheimpostor.model.Log;
import br.edu.ifsul.whoistheimpostor.model.Sort;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author ronie
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        Log[] logsArray = objectMapper.readValue(new File("./src/main/java/repository/logs.txt"), Log[].class);
        Sort sort = new Sort();
        logsArray=sort.countingSort(logsArray,12, true);
        //logsArray=sort.radixSort(logsArray, true);
        //logsArray=sort.bucketSort(logsArray, 12, true);
        int necessaryIndex = 1;
        int firstIndex=0,lastIndex=-1;
        for(Log log : logsArray){
            lastIndex++;
            if(log.getMonth().getValue()!=necessaryIndex){
                if(lastIndex-1>=1000000){
                    lastIndex--;
                    break;
                }
                firstIndex=lastIndex;
                necessaryIndex++;
            }
        }
        necessaryIndex = 1000000-firstIndex;
        Log[] monthLogs = Arrays.copyOfRange(logsArray, firstIndex, lastIndex);
        monthLogs = sort.countingSort(monthLogs, monthLogs.length, false);
        //monthLogs = sort.radixSort(monthLogs, false);
        //monthLogs=sort.bucketSort(monthLogs, monthLogs.length, true);
        System.out.println("The Impostor is "+ monthLogs[necessaryIndex].getUser()+" in "+monthLogs[necessaryIndex].getMonth()+" log: "+monthLogs[necessaryIndex].getLog());

    }
    
}



