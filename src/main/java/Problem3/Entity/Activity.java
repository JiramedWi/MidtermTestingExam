package Problem3.Entity;

import java.util.Date;

public class Activity {
    Integer id;
    String name;
    Date begin;
    Date end;

    public Activity(Integer id, String name, Date begin, Date end) {
        this.id = id;
        this.name = name;
        this.begin = begin;
        this.end = end;
    }
}
