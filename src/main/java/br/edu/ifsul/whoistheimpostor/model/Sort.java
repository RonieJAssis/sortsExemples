/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.whoistheimpostor.model;

import java.util.LinkedList;

/**
 *
 * @author ronie
 */
public class Sort {

    public Log[] countingSort(Log[] array, int max, boolean month) {

        int[] temporaryArray = new int[max + 1];
        int i = 0;
        if (month == true) {
            while (i != array.length) {
                temporaryArray[array[i].getMonth().getValue()]++;
                i++;
            }
        } else {
            while (i != array.length) {
                temporaryArray[array[i].getLog()]++;
                i++;
            }
        }
        i = 1;
        while (i != max + 1) {
            temporaryArray[i] = temporaryArray[i] + temporaryArray[i - 1];
            i++;
        }

        Log[] auxArray = new Log[array.length];
        i = array.length - 1;
        if (month == true) {
            while (i != -1) {
                auxArray[temporaryArray[array[i].getMonth().getValue()] - 1] = array[i];
                temporaryArray[array[i].getMonth().getValue()]--;
                i--;
            }
        } else {
            while (i != -1) {
                auxArray[temporaryArray[array[i].getLog()] - 1] = array[i];
                temporaryArray[array[i].getLog()]--;
                i--;
            }
        }
        return auxArray;
    }

    public Log[] radixSort(Log[] array, boolean month) {
        int digit = 0;
        int maxDigits;
        if (month == true) {
            maxDigits = 2;
        } else {
            maxDigits = Integer.toString(array.length).length();
        }
        while (digit != maxDigits) {
            int power = (int) Math.pow(10, digit + 1);
            Log z[][] = new Log[array.length][10];
            int n[] = new int[10];
            int i = 0;
            while (i != array.length) {
                int num;
                if (month == true) {
                    num = array[i].getMonth().getValue();
                } else {
                    num = array[i].getLog();
                }
                z[n[(num % power) / (power / 10)]][(num % power) / (power / 10)] = array[i];
                n[(num % power) / (power / 10)]++;
                i++;
            }
            i = 0;
            int c = 0;
            while (i != 10) {
                int j = 0;
                while (j != array.length) {
                    if (j != n[i]) {
                        array[c] = z[j][i];
                        c++;
                    } else {
                        break;
                    }
                    j++;
                }
                i++;
            }

            digit++;
        }
        return array;
    }

    public Log[] bucketSort(Log[] array, int max, boolean month) {
        int bucketNumber = max / 5;

        LinkedList[] B = new LinkedList[bucketNumber];
        int i = 0;
        while (i != array.length) {
            int j = bucketNumber - 1;
            while (true) {
                if (j < 0) {
                    break;
                }
                if (month == true) {
                    if (array[i].getMonth().getValue() >= (j * 5)) {
                        B[j].add(array[i]);
                        break;
                    }
                } else {
                    if (array[i].getLog() >= (j * 5)) {
                        B[j].add(array[i]);
                        break;
                    }
                }
                j--;
            }
            i++;
        }
        int number = 0;
        i=0;
        while(i!=bucketNumber){
            Log[] aux = new Log[B[i].size()];
            int j=0;
            while(j!=aux.length){
                aux[j] = (Log)B[i].get(j);
                j++;
            }
            if(month==true){
                this.countingSort(aux,12, month);
            }else{
                this.countingSort(aux, aux.length, month);
            }
            
            //this.radixSort(aux, month);
            j=0;
            while(j!=aux.length){

                array[number]=aux[j];
                number++;
                j++;
            }    
            i++;
        }
        return array;
    }
}