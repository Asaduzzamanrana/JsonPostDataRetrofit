package com.example.postjsondata;

public class OurDataSet {
    String name;
    String hobby;
    json json;

    public com.example.postjsondata.json getJson() {
        return json;
    }

    public void setJson(com.example.postjsondata.json json) {
        this.json = json;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public OurDataSet() {
    }

    public OurDataSet(String name, String hobby) {
        this.name = name;
        this.hobby = hobby;
    }
}

