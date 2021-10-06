package baseball.model;

import nextstep.utils.Randoms;

public class Hitter {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    private String hits;

    public Hitter() {
        hits = "";
    }

    /**
     * 타격(랜덤번호) 추출
     *
     * @param bettingCount
     * @return 1부터 9까지 서로 다른 3자리 숫자를 출력
     */
    public String hitting(int bettingCount) {
        while (hits.length() < bettingCount) {
            swingBet();
        }

        return hits;
    }

    /**
     * 스윙 - 유효타격만 Hits에 추가
     */
    private void swingBet() {
        int random = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

        if (!hits.contains(String.valueOf(random))) {
            hits += random;
        }
    }

    /**
     * 타격결과 반환
     *
     * @return
     */
    public String getHits() {
        return hits;
    }

}
