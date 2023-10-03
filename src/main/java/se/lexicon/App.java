package se.lexicon;

import se.lexicon.dao.UserDao;
import se.lexicon.dao.impl.UserDaoImpl;
import se.lexicon.dao.impl.db.MeetingCalendarDbConnection;
import se.lexicon.exception.AuthenticationFailedException;
import se.lexicon.exception.CalendarExceptionHandler;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try {
            UserDao userDao = new UserDaoImpl(MeetingCalendarDbConnection.getConnection());
            //User createdUser = userDao.createUser("admin");
            //System.out.println("createdUser.userInfo() = " + createdUser.userInfo());
            //Optional<User> userOptional = userDao.findByUsername("admin");
            //if (userOptional.isPresent()){
            //    System.out.println(userOptional.get().userInfo());
            //}

            boolean isAuthenticate = userDao.authenticate(new User("1234", "1234"));
            System.out.println("You are logged in...");
        } catch (Exception e) {
            CalendarExceptionHandler.handelException(e);

        }


    }
}
