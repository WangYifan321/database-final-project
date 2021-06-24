package entity;

public class Press {
    private Integer press_id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "press{" +
                "press_id=" + press_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Press(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getPress_id() {
        return press_id;
    }

    public void setPress_id(Integer press_id) {
        this.press_id = press_id;
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
}
