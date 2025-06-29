package org.mock.controller;

import org.mock.persistence.entity.Player;

import java.util.List;

public interface PlayerController {
    List<Player> findAll();
    Player findPlayerById(Long id);
    void savePlayer(Player player);
    void deletePlayer(Long id);
}
