package org.mock.persistence.repository;

import org.mock.persistence.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ImplPlayerRepository implements PlayerRepository {
    private List<Player> playerDtabase = new ArrayList<>(List.of(
            new Player(1L, "Lionel Messi", "Inter Miami", "Delantero"),
            new Player(2L, "Cristiano Ronaldo", "Al Nassr", "Delantero"),
            new Player(3L, "Neymar Jr.", "Paris Saint-Germain", "Delantero"),
            new Player(4L, "Kylian Mbappé", "Paris Saint-Germain", "Delantero")
    ));

    @Override
    public List<Player> findAll() {
        System.out.println(" -> Método findAll real!");
        return this.playerDtabase;
    }

    @Override
    public Player findPlayerById(Long id) {
        System.out.println(" -> Método findPlayerById real!");
        return this.playerDtabase.stream().filter(player -> player.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void savePlayer(Player player) {
        System.out.println(" -> Método save real!");
        this.playerDtabase.add(player);
    }

    @Override
    public void deletePlayer(Long id) {
        System.out.println(" -> Método delete real!");
        this.playerDtabase.removeIf(player -> player.getId() == id);
    }
}
