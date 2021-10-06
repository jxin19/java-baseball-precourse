package baseball.model;

public class Referee {

    private final String PRINT_BALL_COUNT_PATTERN = "%d 스트라이크 ";
    private final String PRINT_STRIKE_COUNT_PATTERN = "%d 볼";
    private final String PRINT_GAME_OVER_PATTERN = "\r\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String PRINT_NOTHING = "낫싱";

    private BallCount ballCount;

    public Referee() {
        ballCount = new BallCount();
    }

    /**
     * 투구결과 판단
     *
     * @param pitches
     * @param hits
     * @return
     */
    public void judge(String pitches, String hits) {
        if (pitches.length() <= 0) {
            return;
        }

        int index = pitches.length() - 1;
        judgeStrike(pitches, hits, index); // 스트라이크 판단
        judgeBall(pitches, hits, index); // 볼 판단
        judge(pitches.substring(0, pitches.length() - 1), hits);
    }

    /**
     * 스트라이크 판단
     *
     * @param pitches
     * @param hits
     * @param index
     */
    private void judgeStrike(String pitches, String hits, int index) {
        if (pitches.charAt(index) == hits.charAt(index)) {
            ballCount.strike();
        }
    }

    /**
     * 볼인지 판단
     *
     * @param pitches
     * @param hits
     * @param index
     */
    private void judgeBall(String pitches, String hits, int index) {
        if (hits.substring(0, index).indexOf(pitches.charAt(index)) > -1) {
            ballCount.ball();
        }
    }

    /**
     * 게임결과 선언(출력)
     *
     * @param pitchingCount
     */
    public void printResult(int pitchingCount) {
        String resultMessage = (ballCount.hasStrikeCount()) ? String.format(PRINT_BALL_COUNT_PATTERN, ballCount.getStrikeCount()) : "";
        resultMessage += (ballCount.hasBallCount()) ? String.format(PRINT_STRIKE_COUNT_PATTERN, ballCount.getBallCount()) : "";
        resultMessage += (ballCount.isOut(pitchingCount)) ? String.format(PRINT_GAME_OVER_PATTERN, pitchingCount) : "";
        resultMessage += ballCount.isNothing() ? PRINT_NOTHING : "";

        System.out.println(resultMessage);
    }

    /**
     * 볼카운트 반환
     *
     * @return
     */
    public BallCount getBallCount() {
        return ballCount;
    }

}
