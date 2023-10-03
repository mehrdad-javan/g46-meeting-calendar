package se.lexicon.dao;

import se.lexicon.exception.AuthenticationFailedException;
import se.lexicon.exception.UserExpiredException;
import se.lexicon.model.User;

import java.util.Optional;

public interface UserDao {

    User createUser(String username);

    Optional<User> findByUsername(String username);

    boolean authenticate(User user) throws AuthenticationFailedException, UserExpiredException;

    // add more methods according to project functionalities...

}
