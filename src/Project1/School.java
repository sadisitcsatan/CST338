package Project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {
    private String name;
    private ArrayList<Instructor> instructors = new ArrayList<>();
    private List<Course> courses = new ArrayList<Course>();
    private List<Student> students = new ArrayList<Student>();
    int errors;

    public School(String name) {
        this.name = name;
    }
    private static void listing (String[] list) {
        for(int i = 0; i<list.length; i++){
            System.out.println(list[i].trim());
        }
    }
    public void readData(String loc){
        File f = new File(loc);
        Scanner scan = null;
        int i = 0;
        int k = 0;
        int errors = 0;
        try {
            System.out.println("Finding file " + loc);
            scan = new Scanner(f);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        while(scan != null && scan.hasNext()){
            //grab first number read than many lines into instructors
            //grab next number read that many lines into courses
            //grab next number read tha many lines into students
            if(i == 0 || i == -1){
                i = scan.nextInt();
                //System.out.println("I = " + i);
                //System.out.println("K = " + k);
            }
            for(int j = i; j >= 0 && scan.hasNext(); j--){
                String input = scan.nextLine();
                //System.out.println(input);
                String[] split = input.split(",");
                if(split.length > 1) {
                    //System.out.println("------Testing------");
                    //System.out.print(split[0]);
                    //System.out.println(split.length);
                    if (k == 0) {
                        //System.out.println(split.length);
                        //System.out.println(split[1]);
                        if(split.length == 4) {
                            addInstructor(Integer.parseInt(split[0].trim()), split[1].trim(), split[2].trim(), split[3].trim());
                        }else {
                            errors++;
                        }
                        //System.out.println(split.length);
                    }
                    if (k == 1) {
                        if(split.length == 4) {
                            addCourse(Integer.parseInt(split[0].trim()), split[1], Integer.parseInt(split[2]), split[3]);
                            //System.out.println("ADDED " + getCourse(Integer.parseInt(split[0].trim())));
                        }else {
                            errors++;
                        }
                    }
                    if (k == 2) {
                        if (split.length == 2) {
                            addStudent(Integer.parseInt(split[0].trim()), split[1]);
                            //System.out.println("ADDED " + getStudent(Integer.parseInt(split[0].trim())));
                        }else{
                            errors++;
                        }
                    }
                }//else if (i == 0){
                //}
                i--;
            }
            //System.out.println(errors);
            k++;
            //System.out.println(k);
//            String input = scan.nextLine();
//            System.out.println(input);
//            String[] split = input.split(",");
//            System.out.println(split.length);
           //listing(input.split(","));

        }
//        for(int h = 0; h < instructors.size(); h++){
//            System.out.println(instructors.get(h));
//        }
        //System.out.println(instructors.to);
        this.errors = errors;
    }
    public void schoolInfo(){
        if(this.errors == 0) {
            System.out.print(this.instructors.size() + " Instructor(s) ");
            System.out.print(courses.size() + " Course(s) ");
            System.out.println(students.size() + " Student(s)");
        }else {
            System.out.println(this.errors + " errors");
        }
    }
    public void addInstructor(int id, String name, String email, String Phone){
        if(!checkInstructor(id)) {
            Instructor newInstructor = new Instructor(id, name, email, Phone);
            this.instructors.add(newInstructor);
            //System.out.println("ADDED " + getInstructor(id));
        }else   {
            System.out.println("Instructor id" + id +" already given");
        }
    }
    public void addCourse(int id,String course,int students,String loc){
        if(!checkCourse(id)) {
            Course newCourse = new Course(id, course, students, loc);
            this.courses.add(newCourse);
            //System.out.println("ADDED " + getCourse(id));
        }else {
            System.out.println("Course id "+ id+" already used");
        }
    }
    public void assignInstructor(int cID,int iID){
        int loc = 0;
        int oloc = 0;
        if(this.checkCourse(cID) && this.checkInstructor(iID)){
            for (int i = 0; i < this.courses.size(); i++){
                if(cID == this.courses.get(i).getId()){
                    loc = i;
                }
            }
            for (int j = 0; j < this.instructors.size(); j++){
                if(iID == this.instructors.get(j).getId()){
                    oloc = j;
                }
            }
            this.courses.get(loc).setInstructor(this.instructors.get(oloc).getId());
            this.instructors.get(oloc).setCourse(this.courses.get(loc).getId());
            //System.out.println(oloc);
            //System.out.println(getInstructor(oloc));
            //System.out.println("Instructor " + getInstructor(oloc) + " added to " + getCourse(loc));
        }else{
            if(!checkCourse(cID)){
                System.out.println("Course not found");
            }
            if(!checkInstructor(iID)){
                System.out.println("Instructor not found");
            }
        }
    }
    public boolean checkCourse(int id){
        for (int i = 0; i < this.courses.size(); i++){
            if(id == this.courses.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    public boolean checkInstructor(int id){
        for(int i = 0; i < this.instructors.size();i++){
            if(id == this.instructors.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    public boolean checkStudent(int id){
        for(int i = 0; i < this.students.size();i++){
            if(id == this.students.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    public void addStudent(int id,String name){
        if(!checkStudent(id)) {
            Student newStudent = new Student(name, id);
            this.students.add(newStudent);
        }else   {
            System.out.println("Student Id "+ id + " already assigned");
        }
    }
    public void register(int cId,int sId){
        int loc = 0;
        int oloc = 0;
        if(checkCourse(cId) && checkStudent(sId)){
            for(int i = 0; i < this.courses.size(); i++){
                if(cId == this.courses.get(i).getId()){
                    loc = i;
                }
            }
            for(int j = 0; j < this.students.size();j++){
                if(sId == this.students.get(j).getId()){
                    oloc = j;
                }
            }
            this.courses.get(loc).getStudents().add(this.students.get(oloc));
            this.courses.get(loc).getGrades().add(0.0);
        }else{
            if(!checkCourse(cId)){
                System.out.println("Course not found");
            }
            if(!checkStudent(sId)){
                System.out.println("Student not found");
            }
        }
    }
    public void unRegister(int cId, int sId){
        int loc = 0;
        int oloc = 0;
        if(checkCourse(cId) && checkStudent(sId)){
            loc = findCourse(cId);
            for(int j = 0; j < this.courses.get(loc).getStudents().size(); j ++){
                if(sId == this.courses.get(loc).getStudents().get(j).getId()){
                    oloc = j;
                }
            }
            this.courses.get(loc).getStudents().remove(oloc);
        }
    }
    public Instructor getInstructor(int id){
        int loc = 0;
        if(checkInstructor(id)){
            for(int i =0; i < this.instructors.size(); i++){
                if(id == this.instructors.get(i).getId()){
                    loc = i;
                }
            }
            System.out.println(this.instructors.get(loc));
            return this.instructors.get(loc);
        }
        return null;
    }
    public Student getStudent(int id){
        int loc = 0;
        if(checkStudent(id)){
            for(int i =0; i < this.students.size(); i++){
                if(id == this.students.get(i).getId()){
                    loc = i;
                }
            }
            return this.students.get(loc);
        }
        return null;
    }
    public void searchByEmail(String email){
        int loc = -1;
        for(int i = 0; i < this.instructors.size(); i++ ){
            if(email.equals(this.instructors.get(i).getEmail())){
                loc = i;
            }
        }
        if(loc == -1){
            System.out.println("email not found");
        }else{
            System.out.println("Employee Number: " + this.instructors.get(loc).getId() + ", Name: " + this.instructors.get(loc).getName());
        }
    }
    public void deleteCourse(int id){
        int iId = -1;
        int loc = -1;
        int oloc = -1;
        if(checkCourse(id)) {
            for (int i = 0; i < this.courses.size(); i++) {
                if (id == this.courses.get(i).getId()) {
                    loc = i;
                }
            }
            iId = this.courses.get(loc).getInstructor();
            this.courses.remove(loc);
            for(int j = 0; j < this.instructors.size(); j++){
                if(iId == this.instructors.get(j).getId()){
                    oloc = j;
                }
            }
            if(oloc != -1) {
                this.instructors.get(oloc).setCourse(0);
            }
        }
    }
    public void putScore(int cId,int sId, double score){
        int loc = -1;
        int oloc = -1;
        if(checkCourse(cId) && checkStudent(sId)){
            loc = findCourse(cId);
            for(int j = 0; j < this.courses.get(loc).getStudents().size(); j++){
                if(sId == this.courses.get(loc).getStudents().get(j).getId()){
                    oloc = j;
                }
            }
            this.courses.get(loc).getGrades().set(oloc,score);
        }else   {
            System.out.println("No student with ID "+ sId + " found in that course");
        }
    }
    public int findCourse(int id){
        if(checkCourse(id)) {
            for (int i = 0; i < this.courses.size(); i++) {
                if (id == this.courses.get(i).getId()) {
                    return i;
                }
            }
        }return -1;
    }
    public void courseInfo(){
        if(this.courses.size() > 0){
            System.out.println(this.courses.size() + " Courses with " );
            for(int i = 0; i < this.courses.size(); i++){
                System.out.print(this.courses.get(i).getId() + " (" + this.courses.get(i).getStudents().size() + " enrolled) ");
            }
        }
    }
    public Course getCourse(int id){
        if(checkCourse(id)) {
            int loc = findCourse(id);
                return this.courses.get(loc);
        }else{
            Course temp = new Course(0,"",0,"");
            return temp;
        }
    }
    public void courseInfo(int id){
        if(checkCourse(id)){
            int loc = findCourse(id);
            System.out.println(this.courses.get(loc).getStudents().size() + " students enrolled");
        }else{
            System.out.println("Course doesn't exist");
        }
    }
    public void graduateStudent(int id){
        int loc;
        if(checkStudent(id)){
            Student hold = getStudent(id);
            for(int i = 0; i < this.courses.size(); i++){
                if(courses.get(i).getStudents().contains(hold)){
                    loc = courses.get(i).getStudents().indexOf(hold);
                    courses.get(i).getStudents().remove(hold);
                    courses.get(i).getGrades().remove(courses.get(i).getGrades().get(loc));
                }
            }
            students.remove(hold);
        }else{
            System.out.println("Student not found");
        }
    }


}
