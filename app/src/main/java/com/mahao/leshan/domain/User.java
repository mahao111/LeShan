package com.mahao.leshan.domain;

public class User {
    private Integer id;

    private String name;

    private String phone;

    private String birth;

    private  String sex;

    public User() {
    }

    public User(Integer id, String name, String phone, String birth, String sex) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
