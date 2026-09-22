package fr.squaregames.square_games_users_api.controller;

import fr.squaregames.square_games_users_api.entity.User;
import fr.squaregames.square_games_users_api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Créer un utilisateur",
            description = "Crée un nouvel utilisateur."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Utilisateur créé avec succès"
    )
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @Operation(
            summary = "Récupérer un utilisateur",
            description = "Récupère un utilisateur à partir de son identifiant."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Utilisateur trouvé"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Utilisateur inexistant"
    )
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Operation(
            summary = "Supprimer un utilisateur",
            description = "Supprime un utilisateur à partir de son identifiant."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Utilisateur supprimé avec succès"
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @Operation(
            summary = "Vérifier l'existence d'un utilisateur",
            description = "Vérifie si un utilisateur existe à partir de son identifiant."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Vérification effectuée"
    )
    @GetMapping("/{id}/valid")
    public boolean existsById(@PathVariable Long id) {
        return userService.existsById(id);
    }
}

