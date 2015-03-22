package ch01_threadmanage.daemonthreadcreateandrun;

import java.util.Date;

/**
 * Created by Hank on 2015/3/21.
 */
public class Event {
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
