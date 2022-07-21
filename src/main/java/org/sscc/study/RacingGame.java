package org.sscc.study;

import java.util.List;
import java.util.Vector;

public class RacingGame {
    private Round round;
    private List<Roster> roundResults = new Vector<>();
    private Integer roundCount;

    public RacingGame(Integer carCount, Integer roundCount) {
        this(new Round(new Roster(carCount)), roundCount);
    }

    public RacingGame(Round round, Integer roundCount) {
        this.round = round;
        this.roundCount = roundCount;
    }

    public List<Roster> gameResult() {
        for (int i = 0; i < roundCount; i++) {
            roundResults.add(round.roundResult());
        }
        return roundResults;
    }
}
