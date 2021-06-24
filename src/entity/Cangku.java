package entity;

public class Cangku {
    private Integer cangku_id;
    private String name;
    private String location;
    private String phone;

    @Override
    public String toString() {
        return "cangku{" +
                "cangku_id=" + cangku_id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getCangku_id() {
        return cangku_id;
    }

    public void setCangku_id(Integer cangku_id) {
        this.cangku_id = cangku_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Cangku(String name, String location, String phone) {
        this.name = name;
        this.location = location;
        this.phone = phone;
    }
}
