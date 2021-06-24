package entity;

public class Admin {
    private Integer admin_id;
    private String name;
    private String username;
    private String password;

    public Admin(Integer admin_id, String name, String username, String password) {
        this.admin_id = admin_id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Admin() {
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
