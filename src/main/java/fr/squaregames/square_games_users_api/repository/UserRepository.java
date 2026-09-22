package fr.squaregames.square_games_users_api.repository;

import fr.squaregames.square_games_users_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}