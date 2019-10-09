package Project1;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String title;
    private String building;
    private int instructor;
    List<Student> students;
    List<Double> grades = new ArrayList<Double>();

    public Course(int id, String title, int students, String building) {
        this.id = id;
        this.title = title;
        this.students = new ArrayList<Student>(students);
        this.building = building;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBuilding() {
        return building;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getInstructor() {
        return instructor;
    }

    public void setInstructor(int instructor) {
        this.instructor = instructor;
    }

    public List<Double> getGrades() {
        return grades;
    }
    public void updateLocation(String loc){ this.building = loc; }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", building='" + building + '\'' +
                ", instructor=" + instructor +
                ", students=" + students.size() +
                ", grades=" + grades +
                '}';
    }
}
