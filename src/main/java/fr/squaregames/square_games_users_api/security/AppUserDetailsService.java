package fr.squaregames.square_games_users_api.security;

import fr.squaregames.square_games_users_api.entity.User;
import fr.squaregames.square_games_users_api.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public AppUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userService.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Utilisateur inconnu : " + username
                        )
                );

        return new AppUserDetails(user);
    }
}