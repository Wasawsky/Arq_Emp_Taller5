package edu.eci.arep.sparkDocker;

public class Message {
    private String msg;
    private String date;

    public Message(String msg, String date) {
        this.msg = msg;
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message [date=" + date + ", msg=" + msg + "]";
    }

    
}
