package entity;

public class Book {
      private Integer book_id;
      private String name;
      private String author;
      private String type;
      private Integer price;
      private String img_url;
      private String press;
      private String cangkuname;
      private Integer num;
      private String description;

    public Book(Integer book_id,String name, String description,String author, String type, Integer price, String img_url, String press, String cangkuname, Integer num) {
        this.name = name;
        this.book_id = book_id;
        this.author = author;
        this.type = type;
        this.price = price;
        this.img_url = img_url;
        this.press = press;
        this.cangkuname = cangkuname;
        this.num = num;
        this.description=description;
    }

    public Book(String name, String author, String type, Integer price, String img_url, String press, String cangkuname, Integer num, String description) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.price = price;
        this.img_url = img_url;
        this.press = press;
        this.cangkuname = cangkuname;
        this.num = num;
        this.description = description;
    }

    @Override
    public String toString() {
        return "book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", img_url='" + img_url + '\'' +
                ", press='" + press + '\'' +
                ", cangkuname='" + cangkuname + '\'' +
                ", num=" + num +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getCangkuname() {
        return cangkuname;
    }

    public void setCangkuname(String cangkuname) {
        this.cangkuname = cangkuname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
