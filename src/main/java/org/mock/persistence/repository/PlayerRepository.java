package org.mock.persistence.repository;

import org.mock.persistence.entity.Player;

import java.util.List;

public interface PlayerRepository {
    List<Player> findAll();
    Player findPlayerById(Long id);
    void savePlayer(Player player);
    void deletePlayer(Long id);
}
