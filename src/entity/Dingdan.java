package entity;

import java.util.Date;

public class Dingdan {
    private Integer shi_money;
    private Integer ying_money;
    private Integer vip_id;
    private Integer dingdan_id;
    private String state;
    private Date time;

    @Override
    public String toString() {
        return "dingdan{" +
                "shi_money=" + shi_money +
                ", ying_money=" + ying_money +
                ", vip_id=" + vip_id +
                ", dingdan_id=" + dingdan_id +
                ", state='" + state + '\'' +
                ", time=" + time +
                '}';
    }

    public Dingdan(Integer shi_money, Integer ying_money, Integer vip_id, Integer dingdan_id, String state, Date time) {
        this.shi_money = shi_money;
        this.ying_money = ying_money;
        this.vip_id = vip_id;
        this.dingdan_id = dingdan_id;
        this.state = state;
        this.time = time;
    }

    public Integer getShi_money() {
        return shi_money;
    }

    public void setShi_money(Integer shi_money) {
        this.shi_money = shi_money;
    }

    public Integer getYing_money() {
        return ying_money;
    }

    public void setYing_money(Integer ying_money) {
        this.ying_money = ying_money;
    }

    public Integer getVip_id() {
        return vip_id;
    }

    public void setVip_id(Integer vip_id) {
        this.vip_id = vip_id;
    }

    public Integer getDingdan_id() {
        return dingdan_id;
    }

    public void setDingdan_id(Integer dingdan_id) {
        this.dingdan_id = dingdan_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Dingdan(Integer shi_money, Integer ying_money, Integer vip_id, String state, Date time) {
        this.shi_money = shi_money;
        this.ying_money = ying_money;
        this.vip_id = vip_id;
        this.state = state;
        this.time = time;
    }
}
