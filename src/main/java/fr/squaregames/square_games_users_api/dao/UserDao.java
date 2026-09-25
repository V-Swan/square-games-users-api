package fr.squaregames.square_games_users_api.dao;

import fr.squaregames.square_games_users_api.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    User upsert(User user);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    List<User> findAll();

    void delete(Long id);

    boolean existsById(Long id);
}