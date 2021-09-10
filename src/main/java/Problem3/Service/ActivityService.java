package Problem3.Service;

import Problem3.Entity.Activity;

import java.util.Date;
import java.util.List;

public interface ActivityService {
    public List<Activity> getActivityList(Date begin, Date end);
}
