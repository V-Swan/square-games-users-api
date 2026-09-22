package fr.squaregames.square_games_users_api.dao;

import fr.squaregames.square_games_users_api.entity.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> findById(Long id);

    User upsert(User user);

    void delete(Long id);

    boolean existsById(Long id);
}