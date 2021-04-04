/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.whoistheimpostor.model;

import java.util.Arrays;
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
            int monthNumber = 0;
            boolean verify = false;
            while (i != 10) {
                int j = 0;
                while (j != array.length) {
                    if (j != n[i]) {
                        array[c] = z[j][i];
                        if (c == 1000000 && digit == 1 && month == true) {
                            verify = true;
                            monthNumber = array[c].getMonth().getValue();
                        }
                        if (monthNumber != array[c].getMonth().getValue() && verify == true) {
                            array = Arrays.copyOfRange(array, 0, c - 1);
                            return array;
                        }
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

    public Log[] selectionSort(Log[] array, boolean month) {
        int i = 0;
        boolean verify = false;
        int monthNumber = 0;
        while (i != array.length) {
            int index = i;
            int j = i + 1;
            while (j != array.length) {
                if (month == true) {
                    String s = Integer.toString(array[j].getMonth().getValue() - array[index].getMonth().getValue());
                    if (s.charAt(0) == '-') {
                        index = j;
                    }
                } else {
                    String s = Integer.toString(array[j].getLog() - array[index].getLog());
                    if (s.charAt(0) == '-') {
                        index = j;
                    }
                }
                j++;
            }
            Log smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
            if (i == 1000000 && month == true) {
                verify = true;
                monthNumber = array[i].getMonth().getValue();
            }
            if (monthNumber != array[i].getMonth().getValue() && verify == true) {
                System.out.println(i);
                array = Arrays.copyOfRange(array, 0, i - 1);
                return array;
            }
            i++;
        }
        return array;
    }
}
