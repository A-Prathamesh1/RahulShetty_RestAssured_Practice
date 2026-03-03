package pojo;

public class User {
    private String name;
    private String email;
    private String role; // Getters/Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", role='" + role + '\'' + '}';
    }
}
