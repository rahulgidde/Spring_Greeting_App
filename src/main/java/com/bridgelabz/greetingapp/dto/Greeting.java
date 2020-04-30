package com.bridgelabz.greetingapp.dto;

public class Greeting {
    private String name;
    private long count;

    public Greeting(long incrementAndGet, String format) {
        this.count = incrementAndGet;
        this.name = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
