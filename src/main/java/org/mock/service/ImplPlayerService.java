package org.mock.service;

import org.mock.persistence.entity.Player;
import org.mock.persistence.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplPlayerService implements PlayerService {
    private PlayerRepository playerRepository;

    public ImplPlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public Player findPlayerById(Long id) {
        return this.playerRepository.findPlayerById(id);
    }

    @Override
    public void savePlayer(Player player) {
        this.playerRepository.savePlayer(player);
    }

    @Override
    public void deletePlayer(Long id) {
        this.playerRepository.deletePlayer(id);
    }
}
