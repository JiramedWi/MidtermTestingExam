package Problem3.Service;

import Problem3.Dao.ActivityDao;
import Problem3.Entity.Activity;

import java.util.Date;
import java.util.List;

public class ActivityServiceImpl implements ActivityService {
    ActivityDao activityDao;

    @Override
    public List<Activity> getActivityList(Date begin, Date end) {
        if(isInDate(begin,end)==true){
            return null;
        }
        return null;
    }

    public boolean isInDate(Date begin, Date end) {
        return true;
    }

    public void setActivityDao(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }
}
