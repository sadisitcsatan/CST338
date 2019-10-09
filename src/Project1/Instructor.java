package Project1;

public class Instructor {
    private String name;
    private String email;
    private String phone;
    private int id;
    private int course;

    public Instructor( int id, String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", course=" + course +
                '}';
    }
}
