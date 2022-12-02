package domain.service;

import domain.user.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerRepositoryTest {

    @Test
    void 플레이어를_저장하기() {
        PlayerRepository playerRepository = new PlayerRepository();

        Player pobi = new Player("pobi", 10000, new ArrayList<>());
        Player savePlayer = playerRepository.save(pobi);

        assertThat(savePlayer).isEqualTo(pobi);
    }
}
