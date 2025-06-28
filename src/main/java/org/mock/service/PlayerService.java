package org.mock.service;

import org.mock.persistence.entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAll();
    Player findPlayerById(Long id);
    void savePlayer(Player player);
    void deletePlayer(Long id);
}
