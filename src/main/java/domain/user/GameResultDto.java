package domain.user;

import java.util.List;

public class GameResultDto {

    private final List<GameResult> gameResults;

    public GameResultDto(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    static class GameResult {
        private final String name;
        private final double price;

        public GameResult(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }
}
