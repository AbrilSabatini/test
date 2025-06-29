package org.mock.controller;

import org.mock.persistence.entity.Player;
import org.mock.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class ImplPlayerController implements PlayerController {
    private PlayerService playerService;

    public ImplPlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Player> findAll() {
        return playerService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Player findPlayerById(@PathVariable Long id) {
        return playerService.findPlayerById(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}
