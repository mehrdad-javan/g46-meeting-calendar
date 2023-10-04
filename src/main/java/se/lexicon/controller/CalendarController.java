package se.lexicon.controller;

import se.lexicon.dao.MeetingCalendarDao;
import se.lexicon.dao.UserDao;
import se.lexicon.exception.CalendarExceptionHandler;
import se.lexicon.model.MeetingCalendar;
import se.lexicon.model.User;
import se.lexicon.view.CalendarView;

public class CalendarController {

    // dependencies
    private CalendarView view;
    private UserDao userDao;
    private MeetingCalendarDao calendarDao;

    // fields
    private boolean isLoggedIn;
    private String username;

    public CalendarController(CalendarView view, UserDao userDao, MeetingCalendarDao calendarDao) {
        this.view = view;
        this.userDao = userDao;
        this.calendarDao = calendarDao;
    }

    public void run() {

        while (true) {
            view.displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 0:
                    register();
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    createCalendar();
                    break;
                case 3:
                    //todo: call meeting method
                    break;
                case 4:
                    //todo: call delete calendar method
                    break;
                case 5:
                    //todo: call display calendar method
                    break;
                case 6:
                    isLoggedIn = false;
                    break;
                case 7:
                    System.exit(0);
                    break;

                default:
                    view.displayWarningMessage("Invalid choice. Please select a valid option.");
            }

        }

    }


    private int getUserChoice() {
        String operationType = view.promoteString();
        int choice = -1;
        try {
            choice = Integer.parseInt(operationType);
        } catch (NumberFormatException e) {
            view.displayErrorMessage("Invalid input. Please enter a number.");
        }
        return choice;
    }


    private void register() {
        view.displayMessage("Enter you username:");
        String username = view.promoteString();
        User registeredUser = userDao.createUser(username);
        view.displayUser(registeredUser);
    }

    private void login() {
        User user = view.promoteUserForm();
        try {
            isLoggedIn = userDao.authenticate(user);
            username = user.getUsername();
            view.displaySuccessMessage("Login successful.");
        } catch (Exception e) {
            CalendarExceptionHandler.handelException(e);
        }

    }


    private void createCalendar() {
        if (!isLoggedIn) {
            view.displayWarningMessage("You need to login first.");
            return;
        }

        String calendarTitle = view.promoteCalendarForm();
        MeetingCalendar createdMeetingCalendar = calendarDao.createMeetingCalendar(calendarTitle, username);
        view.displaySuccessMessage("Calendar created successfully. ;)");
        view.displayCalendar(createdMeetingCalendar);

    }


}
