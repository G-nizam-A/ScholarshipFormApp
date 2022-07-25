package com.example.scholarship;

public class studentData {
    String addName, addRollno, addCourse;

    public studentData(String addName, String addRollno, String addCourse) {
        this.addName = addName;
        this.addRollno = addRollno;
        this.addCourse = addCourse;
    }

    public String getAddName() {
        return addName;
    }

    public String getAddRollno() {
        return addRollno;
    }

    public String getAddCourse() {
        return addCourse;
    }


    public void setAddName(String addName) {
        this.addName = addName;
    }

    public void setAddRollno(String addRollno) {
        this.addRollno = addRollno;
    }

    public void setAddCourse(String addCourse) {
        this.addCourse = addCourse;
    }

    @Override
    public String toString() {
        return "studentData{" +
                "addName='" + addName + '\'' +
                ", addRollno='" + addRollno + '\'' +
                ", addCourse='" + addCourse + '\'' +
                '}';
    }
}
