package ohtu;

import java.util.ArrayList;

public class Submission {
    private String student_number;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private String week;
    private int hours;
    private int countedAlldone;
    ArrayList<Integer> list;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        doneToArray();
        int allDone = countDone();
        String rep = "Viikko"+week+": tehtyjä tehtäviä yhteensä: "+allDone+", aikaa kului "+hours+" tuntia, "+whichAssignmentsAreDone();
        return rep;
    }
    
    public void doneToArray() {
        list = new  ArrayList<Integer>();
        if (a1){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a2){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a3){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a4){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a5){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a6){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a7){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a8){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a9){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a10){
            list.add(1);
        } else{
            list.add(0);
        }
        if (a11){
            list.add(1);
        } else{
            list.add(0);
        }
    }
    
    public String whichAssignmentsAreDone() {
        String tehty="tehdyt tehtävät: ";
        for (int done : list){
            tehty+=" "+done;
        }
        return tehty;
    }
    
    public int countDone() {
        int doneAssignment = 0;
        countedAlldone = 0;
        for (int done : list){
            doneAssignment += done;
            countedAlldone += done;
        }
        return doneAssignment;
    }
    
    public int getCountedAlldone() {
        return countedAlldone;
    }

    public boolean isA1() {
        return a1;
    }

    public void setA1(boolean a1) {
        this.a1 = a1;
    }

    public boolean isA2() {
        return a2;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    public boolean isA3() {
        return a3;
    }

    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    public boolean isA4() {
        return a4;
    }

    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    public boolean isA5() {
        return a5;
    }

    public void setA5(boolean a5) {
        this.a5 = a5;
    }

    public boolean isA6() {
        return a6;
    }

    public void setA6(boolean a6) {
        this.a6 = a6;
    }

    public boolean isA7() {
        return a7;
    }

    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    public boolean isA8() {
        return a8;
    }

    public void setA8(boolean a8) {
        this.a8 = a8;
    }

    public boolean isA9() {
        return a9;
    }

    public void setA9(boolean a9) {
        this.a9 = a9;
    }

    public boolean isA10() {
        return a10;
    }

    public void setA10(boolean a10) {
        this.a10 = a10;
    }
    
    public boolean isA11() {
        return a11;
    }

    public void setA11(boolean a11) {
        this.a11 = a11;
    }
    
    public String getWeek(){
        return week;
    }
    
    public void setWeek(String week) {
        this.week = week;
    }
    
    public int getHours() {
        return hours;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    
}