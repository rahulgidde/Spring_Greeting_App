package com.bridgelabz.greetingapp.dto;

public class Greeting {
    private String format;
    private long count;

    public Greeting(long incrementAndGet, String format) {
        this.count = incrementAndGet;
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String name) {
        this.format = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
