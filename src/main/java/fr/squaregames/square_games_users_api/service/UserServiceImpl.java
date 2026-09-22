package fr.squaregames.square_games_users_api.service;

import fr.squaregames.square_games_users_api.dao.UserDao;
import fr.squaregames.square_games_users_api.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User create(User user) {
        return userDao.upsert(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public boolean existsById(Long id) {
        return userDao.existsById(id);
    }
}