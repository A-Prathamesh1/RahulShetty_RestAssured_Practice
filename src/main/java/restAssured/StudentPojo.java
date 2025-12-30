package restAssured;

public class StudentPojo {
    String id;
    String name;
    int age;
    String gender;
    String email;
    String[] subjects = new String[4];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public static void main(String[] args) {
        System.out.println("HW!");
        StudentPojo s = new StudentPojo();
        System.out.println("subjects length :" + s.subjects.length);
        s.setAge(33);
        s.setEmail("psausekar@gmail.com");
        s.setGender("Male");
        s.setId("eq7948");
        s.setName("Prathamesh");
        String[] sub = {"Math", "English", "Hindi", "Science"};
        s.setSubjects(sub);

    }
}
