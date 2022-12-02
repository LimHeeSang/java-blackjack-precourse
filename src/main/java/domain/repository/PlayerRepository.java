package domain.repository;

import domain.user.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerRepository {

    private final List<Player> players;

    public PlayerRepository() {
        players = new ArrayList<>();
    }


    public Player save(Player player) {
        players.add(player);
        return player;
    }

    public List<Player> findAll() {
        return Collections.unmodifiableList(players);
    }
}
