package entity;

import java.util.Date;

public class Comment {
    private Integer comment_id;
    private Integer book_id;
    private Integer vip_id;
    private String content;
    private Date time;

    public Comment(Integer book_id, Integer vip_id, String content, Date time) {
        this.book_id = book_id;
        this.vip_id = vip_id;
        this.content = content;
        this.time = time;
    }

    @Override
    public String toString() {
        return "comment{" +
                "comment_id=" + comment_id +
                ", book_id=" + book_id +
                ", vip_id=" + vip_id +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getVip_id() {
        return vip_id;
    }

    public void setVip_id(Integer vip_id) {
        this.vip_id = vip_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
