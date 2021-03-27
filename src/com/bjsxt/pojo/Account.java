package com.bjsxt.pojo;

import java.util.Objects;

public class Account {
    private Integer aid;
    private String apwd;
    private Double money;
    private Integer uid;
    private User user;//存储账户对应的用户信息

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", apwd='" + apwd + '\'' +
                ", money=" + money +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(aid, account.aid) &&
                Objects.equals(apwd, account.apwd) &&
                Objects.equals(money, account.money) &&
                Objects.equals(uid, account.uid) &&
                Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, apwd, money, uid, user);
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account() {
    }

    public Account(Integer aid, String apwd, Double money, Integer uid, User user) {
        this.aid = aid;
        this.apwd = apwd;
        this.money = money;
        this.uid = uid;
        this.user = user;
    }
}
