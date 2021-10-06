package baseball;

import baseball.model.Referee;
import baseball.model.Hitter;
import baseball.model.Pitcher;
import nextstep.utils.Console;

public class BaseballGame {

    private static final short GAME_BALL_COUNT = 3; // 최대 투구 수
    private static final String CHOOSE_RESUME_OR_STOP_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String COMMAND_RESUME = "1";
    private static final String COMMAND_STOP = "2";
    private static final String INVALID_INPUT_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    /**
     * 게임시작
     *
     * @return 3스트라이크(게임종료) 여부 반환
     */
    public static boolean play() {
        Pitcher pitcher = new Pitcher(GAME_BALL_COUNT); // 투수(선언)
        pitcher.pitching(); // 투구
        Hitter hitter = new Hitter(); // 타자(선언)
        hitter.hitting(GAME_BALL_COUNT); // 타격
        Referee referee = new Referee(); // 심판(선언)
        referee.judge(pitcher.getPitches(), hitter.getHits()); // 심판의 투구결과 판단
        referee.printResult(pitcher.getPitches().length()); // 게임결과 선언(출력)
        return pitcher.getPitches().length() == referee.getBallCount().getStrikeCount();
    }

    /**
     * 게임 재시작/종료 선택
     *
     * @param isStrikeOut
     */
    public static void chooseResumeOrStop(boolean isStrikeOut) {
        if (!isStrikeOut) {
            return;
        }

        String command = inputCommand();
        validateCommand(command);
        gameOver(command);
    }

    /**
     * 입력값 유효성 검사
     *
     * @param command
     */
    private static void validateCommand(String command) {
        if (!command.equals(COMMAND_RESUME) && !command.equals(COMMAND_STOP)) {
            System.out.println(INVALID_INPUT_MESSAGE);
            chooseResumeOrStop(false);
        }
    }

    /**
     * 명령어 입력
     *
     * @return
     */
    private static String inputCommand() {
        System.out.println(CHOOSE_RESUME_OR_STOP_MESSAGE);
        return Console.readLine();
    }

    /**
     * 게임 종료
     *
     * @param command
     */
    private static void gameOver(String command) {
        if (command.equals(COMMAND_STOP)) {
            System.exit(0);
        }
    }

}
