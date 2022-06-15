package com.mayank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

import java.util.List;
import java.util.stream.Stream;

// [Timestamp, PRN, Full Name, Program, Branch,
// Probability & Statistics (Out off 125), Engineering Circuit Analysis (Out off 125), Data Structures (Out off 125),
// Digital System Design (Out off 125), Signals & Linear Systems (Out off 100),
// Electronics Workshop (Out off 50), Fundamentals of Electrical Machines & Drives (Out off 50)]

class CSV {
    String PRN;

    CSV(String PRN){
        this.PRN = PRN;
    }
    List<String[]> readAllRecords(String file){
        List<String[]> allData = null;
        try {
            FileReader f = new FileReader(file);
            CSVReader cr = new CSVReaderBuilder(f).withSkipLines(1).build();
            allData = cr.readAll();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

        return  allData;
    }


    String[] readStudentDetails(List<String[]> allData){
        String sdetails[] = new String[4];

        for (String [] i: allData) {

            for (String j :
                    i) {
                if (j.contentEquals(this.PRN)){
                    for (int k = 1; k <= 4;k++){
                        sdetails[k-1] = i[k];
                    }
                }
            }

        }


        return sdetails;
    }

    int[] readCourseDetails(List<String[]> allData){
        String cdetails[] = new String[7];

        for (String [] i: allData) {

            for (String j :
                    i) {
                if (j.contentEquals(this.PRN)){
                    for (int k = 5; k <= 11;k++){
                        cdetails[k-5] = i[k];
                    }
                }
            }

        }

        return Stream.of(cdetails).mapToInt(Integer::parseInt).toArray();
    }


    Boolean getPRN(List<String[]> allData){

        for (String[] i: allData){
            for (String j: i){
                if(j.contentEquals(this.PRN)){
                    return true;
                }
            }

        }
        return false;
    }
}




