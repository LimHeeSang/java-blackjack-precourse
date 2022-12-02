package domain.service;

import domain.user.Player;

import java.util.ArrayList;
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
}
