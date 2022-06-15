package com.mayank;

abstract class Details { // Concept : Abstraction
     String program;
     String branch;
     String prn;
     String name;
}

public class StudentDetails extends Details {



    StudentDetails(String[] sdetails){
        setPrn(sdetails[0]);
        setName(sdetails[1]);
        setProgram(sdetails[2]);
        setBranch(sdetails[3]);
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }


    public void setPrn(String prn) {
        this.prn = prn;
    }

    public String getPrn() {
        return prn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    String getStudentDetails(){
        return "Program: "+getProgram()+"\nBranch: "+getBranch()+"\nPRN: "+getPrn()+"\nName: "+getName()+"\n\n";
    }
}