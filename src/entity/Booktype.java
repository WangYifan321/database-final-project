package entity;

public class Booktype {
    private  String name;
    private  String description;
    private Integer type_id;

    public Booktype() {
    }

    public Booktype(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "booktype{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type_id=" + type_id +
                '}';
    }
}
