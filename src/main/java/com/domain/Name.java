package com.domain;

import lombok.Data;

@Data
public class Name {

    private String first;
    private String second;

    public Name() {

    }

    public Name(String first, String second) {

        if(first.isEmpty() || second.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty!");
        }

        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }
}
