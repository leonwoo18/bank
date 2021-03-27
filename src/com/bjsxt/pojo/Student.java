package com.bjsxt.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Student {
    @Value("${sid}")
    private Integer sid;
    @Value("王五")
    private String sname;
    @Value("${fav}")
    private String fav;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", fav='" + fav + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sid, student.sid) &&
                Objects.equals(sname, student.sname) &&
                Objects.equals(fav, student.fav);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, fav);
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public Student() {
    }

    public Student(Integer sid, String sname, String fav) {
        this.sid = sid;
        this.sname = sname;
        this.fav = fav;
    }
}
