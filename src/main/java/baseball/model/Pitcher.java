package baseball.model;

import nextstep.utils.Console;

public class Pitcher {

    private final String NUMBER_INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private final String INVALID_INPUT_VALUES_ALERT_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    private short maxPitchingCount; // 최대 투구수
    private String pitches; // 투구결과

    public Pitcher(short maxPitchingCount) {
        this.maxPitchingCount = maxPitchingCount;
    }

    /**
     * 투구
     */
    public void pitching() {
        System.out.println(NUMBER_INPUT_REQUEST_MESSAGE);
        pitches = Console.readLine();

        if (invalidInputValues()) {
            System.out.println(INVALID_INPUT_VALUES_ALERT_MESSAGE);
            pitching();
        }
    }

    /**
     * 입력한 문자 유효성 검사
     *
     * @return
     */
    private boolean invalidInputValues() {
        return pitches.length() > maxPitchingCount || !pitches.matches("[1-9]\\d\\d") || !duplicatedCharacters(pitches);
    }

    /**
     * 중복문자 체크
     *
     * @return 중복여부 반환
     */
    private boolean duplicatedCharacters(String chars) {
        if (chars.equals("")) {
            return true;
        }
        String substr = chars.substring(1);
        if (substr.indexOf(chars.charAt(0)) == -1) {
            return duplicatedCharacters(substr);
        }
        return false;
    }

    /**
     * 투구결과 반환
     *
     * @return
     */
    public String getPitches() {
        return pitches;
    }

}
