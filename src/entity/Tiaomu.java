package entity;

public class Tiaomu {
    private Integer tiaomu_id;
    private Integer num;
    private Integer money;
    private String book_name;
    private String img_url;
    private String username;
    private int state;

    public Tiaomu(Integer tiaomu_id, Integer num, Integer money, String book_name, String img_url, int state) {
        this.tiaomu_id = tiaomu_id;
        this.num = num;
        this.money = money;
        this.book_name = book_name;
        this.img_url = img_url;
        this.state = state;
    }

    public Tiaomu(Integer tiaomu_id, Integer num, Integer money, String book_name, String img_url, String username) {
        this.tiaomu_id = tiaomu_id;
        this.num = num;
        this.money = money;
        this.book_name = book_name;
        this.img_url = img_url;
        this.username = username;
    }

    public Tiaomu(Integer num, Integer money, String book_name, String img_url, String username) {
        this.num = num;
        this.money = money;
        this.book_name = book_name;
        this.img_url = img_url;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTiaomu_id() {
        return tiaomu_id;
    }

    public void setTiaomu_id(Integer tiaomu_id) {
        this.tiaomu_id = tiaomu_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "tiaomu{" +
                "tiaomu_id=" + tiaomu_id +
                ", num=" + num +
                ", money=" + money +
                ", book_name='" + book_name + '\'' +
                ", img_url='" + img_url + '\'' +
                ", state=" + state +
                '}';
    }
}
