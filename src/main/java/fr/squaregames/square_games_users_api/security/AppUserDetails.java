package fr.squaregames.square_games_users_api.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AppUserDetails implements UserDetails {

    private final Long id;
    private final String username;
    private final String role;
    private final String password;

    public AppUserDetails(
            Long id,
            String username,
            String role
    ) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.password = "";
    }

    public AppUserDetails(
            fr.squaregames.square_games_users_api.entity.User user
    ) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.password = user.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(role)
        );
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}