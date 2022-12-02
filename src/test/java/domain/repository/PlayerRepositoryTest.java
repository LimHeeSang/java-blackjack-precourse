package domain.repository;

import domain.user.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerRepositoryTest {

    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        playerRepository = new PlayerRepository();
    }

    @Test
    void 플레이어를_저장하기() {
        Player pobi = new Player("pobi", 10000, new ArrayList<>());
        Player savePlayer = playerRepository.save(pobi);

        assertThat(savePlayer).isEqualTo(pobi);
    }

    @Test
    void 플레이어를_모두_조회하기() {
        Player pobi = new Player("pobi", 10000, new ArrayList<>());
        Player jason = new Player("jason", 20000, new ArrayList<>());

        playerRepository.save(pobi);
        playerRepository.save(jason);
        List<Player> players = playerRepository.findAll();

        assertThat(players).contains(pobi, jason);
    }
}
