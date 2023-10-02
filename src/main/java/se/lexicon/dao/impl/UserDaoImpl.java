package se.lexicon.dao.impl;

import se.lexicon.dao.UserDao;
import se.lexicon.dao.impl.db.MeetingCalendarDbConnection;
import se.lexicon.exception.AuthenticationFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public User createUser(String username) {
        String query = "";
        try (
                Connection connection = MeetingCalendarDbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            // todo: implement it in continue...

        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public boolean authenticate(User user) throws AuthenticationFailedException, UserExpiredException {
        return false;
    }
}
