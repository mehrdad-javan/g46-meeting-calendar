package se.lexicon;

import se.lexicon.controller.CalendarController;
import se.lexicon.dao.MeetingCalendarDao;
import se.lexicon.dao.UserDao;
import se.lexicon.dao.impl.MeetingCalendarDaoImpl;
import se.lexicon.dao.impl.UserDaoImpl;
import se.lexicon.dao.impl.db.MeetingCalendarDbConnection;
import se.lexicon.view.CalendarConsoleUI;
import se.lexicon.view.CalendarView;

import java.sql.Connection;

public class App {

    public static void main(String[] args) {

        System.setProperty("log4j.configurationFile", "log4j2.properties");

        Connection mysqlConnection = MeetingCalendarDbConnection.getConnection();
        CalendarView view = new CalendarConsoleUI();
        UserDao userDao = new UserDaoImpl(mysqlConnection);
        MeetingCalendarDao calendarDao = new MeetingCalendarDaoImpl(mysqlConnection);

        CalendarController controller = new CalendarController(view, userDao, calendarDao);
        controller.run();

    }

}
