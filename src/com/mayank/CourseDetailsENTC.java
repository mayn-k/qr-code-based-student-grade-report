package com.mayank;

import java.util.HashMap;


public class CourseDetailsENTC {
    String course[] = {"Probability & Statistics",
            "Engineering Circuit Analysis",
            "Data Structures",
            "Digital System Design",
            "Signals & Linear Systems",
            "Electronics Workshop",
            "Fundamentals of Electrical Machines & Drives"};
    
    int maxCourseMarks[] = {125,
            125,
            125,
            125,
            100,
            50,
            50};

    HashMap<String, Integer> scoreMap = new HashMap<>();

    void createScoreMap(int marks[]){
        for (int i = 0; i < course.length; i++){
            scoreMap.put(course[i],marks[i]);
        }
    }

    String getScoreMap(){
        String data = "";

        for (int i = 0; i < course.length; i++) {
            data += course[i]+": "+scoreMap.get(course[i])+"/"+maxCourseMarks[i]+"\n";
        }
        return data;
    }
}