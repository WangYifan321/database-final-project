package entity;

public class Vip {
    private Integer vip_id;
    private String name;
    private String password;
    private String username;
    private String sex;
    private String personid;
    private String phone;
    private String address;

    public Vip( String name, String password, String username, String sex, String personid, String phone, String address) {

        this.name = name;
        this.password = password;
        this.username = username;
        this.sex = sex;
        this.personid = personid;
        this.phone = phone;
        this.address = address;
    }

    public Vip(Integer vip_id, String name, String password, String username, String sex, String personid, String phone, String address) {
        this.vip_id = vip_id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.sex = sex;
        this.personid = personid;
        this.phone = phone;
        this.address = address;
    }

    public Vip() {
    }

    @Override
    public String toString() {
        return "vip{" +
                "vip_id=" + vip_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", personid='" + personid + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getVip_id() {
        return vip_id;
    }

    public void setVip_id(Integer vip_id) {
        this.vip_id = vip_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
