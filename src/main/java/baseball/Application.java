package baseball;

public class Application {

    public static void main(String[] args) {
        while (true) {
            boolean isStrikeOut = BaseballGame.play(); // 게임시작
            BaseballGame.chooseResumeOrStop(isStrikeOut); // 게임 재시작/종료 선택
        }
    }

}
