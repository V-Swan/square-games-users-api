package fr.squaregames.square_games_users_api.dao;

import fr.squaregames.square_games_users_api.repository.UserRepository;
import fr.squaregames.square_games_users_api.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserDao implements UserDao {

    private final UserRepository userRepository;

    public JpaUserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User upsert(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
