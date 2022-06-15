package com.mayank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        String csvPath = "D:\\qr-code-based-student-grade-report\\sampledata.csv"; // source path
        String data, path; // data to embed in QR code at destination path
        boolean condtion = true;
        Scanner input = new Scanner(System.in);
        String prn;
        String choice;

        while (condtion){
            System.out.println();
            System.out.println("-------------MENU-------------");
            System.out.println("  1. ENTER PRN & GET QR CODE");
            System.out.println("  2. EXIT");
            System.out.println("------------------------------");
            System.out.println();


            System.out.print("ENTER YOUR CHOICE: ");
            choice = input.nextLine();

            switch (choice){
                case "1":
                    System.out.print("Enter PRN: ");
                    prn = input.nextLine();
                    CSV csv = new CSV(prn);

                    if(csv.getPRN(csv.readAllRecords(csvPath))){
                        StudentDetails sd = new StudentDetails(csv.readStudentDetails(csv.readAllRecords(csvPath))); // setting STUDENT DETAILS
                        CourseDetailsENTC cd = new CourseDetailsENTC();
                        cd.createScoreMap(csv.readCourseDetails(csv.readAllRecords(csvPath))); // creating SCORE MAP by reading the COURSE DETAILS from ALL DETAILS

                        data = sd.getStudentDetails()+cd.getScoreMap();  // data to be embbed in QR code
                        path = String.format("D:\\qr-code-based-student-grade-report\\QRCODES\\%s.png",prn);  //  destination path

                        QR qr = new QR();
                        qr.generateQR(data,path);
                        qr.openQR(path);
                    }

                    else{
                        System.out.println("PRN NOT FOUND IN CSV FILE!!");
                    }

                    break;


                case "2":
                    System.out.println("THANK YOU");
                    condtion = false;
                    break;


                default:
                    System.out.println("INVALID CHOICE!!!");
            }
        }
    }
}
