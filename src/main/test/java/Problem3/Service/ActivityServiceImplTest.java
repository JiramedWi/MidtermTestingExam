package Problem3.Service;

import Problem3.Dao.ActivityDao;
import Problem3.Entity.Activity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.closeTo;

class ActivityServiceImplTest {
    ActivityDao activityDao;
    String Date1 = "19/11/2021";
    Date loyKratongDate = new SimpleDateFormat("dd/MM/yyyy").parse(Date1);

    String Date2begin = "6/10/2021";
    String Date2end = "14/10/2021";
    Date vegetarianBg = new SimpleDateFormat("dd/MM/yyyy").parse(Date2begin);
    Date vegetarianend = new SimpleDateFormat("dd/MM/yyyy").parse(Date2end);

    String Date3begin = "1/11/2021";
    String Date3end = "30/11/2021";
    Date noNutBg = new SimpleDateFormat("dd/MM/yyyy").parse((Date3begin));
    Date noNutEnd = new SimpleDateFormat("dd/MM/yyyy").parse((Date3end));

    Date firstNov = new SimpleDateFormat("dd/MM/yyyy").parse((Date3begin));
    Date endNov = new SimpleDateFormat("dd/MM/yyyy").parse((Date3end));



    @BeforeEach
    void init() {
        activityDao = mock(ActivityDao.class);
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(001, "Loy kra tong", loyKratongDate, loyKratongDate));
        activities.add(new Activity(002, "Vegetarian Festival", vegetarianBg, vegetarianend));
        activities.add(new Activity(003, "No nut November", noNutBg, noNutEnd));
        when(activityDao.getActivities()).thenReturn(activities);
    }

    ActivityServiceImplTest() throws ParseException {
    }

    @Test
    void getActivitiesInNovember() {
        ActivityServiceImpl activityService = new ActivityServiceImpl();
        activityService.setActivityDao(activityDao);
        assertThat(activityService.getActivityList(firstNov,endNov),hasItems(
                new Activity(001, "Loy kra tong", loyKratongDate, loyKratongDate),
                new Activity(003, "No nut November", noNutBg, noNutEnd)
        ));
        verify(activityService).setActivityDao(activityDao);
        verify(activityService).isInDate(firstNov,endNov);

        InOrder inOrder = inOrder(activityService);
        inOrder.verify(activityService).setActivityDao(activityDao);
        inOrder.verify(activityService).getActivityList(firstNov,endNov);
        inOrder.verify(activityService).isInDate(firstNov,endNov);
    }

}