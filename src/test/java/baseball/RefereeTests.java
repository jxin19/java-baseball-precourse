package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("심판 기능을 테스트합니다.")
public class RefereeTests {

    @DisplayName("3개 숫자중 동일한 위치의 숫자가 동일하면 스트라이크로 판단합니다.")
    @ParameterizedTest
    @CsvSource(value = {"123,123", "125,135", "512,561"}, delimiter = ',')
    public void 스트라이크(String pitches, String hits) {
        final boolean valid = pitches.charAt(0) == hits.charAt(0);
        assertThat(valid).isTrue();
    }

    @DisplayName("3개 숫자중 위치가 다른 숫자가 존재하면 볼로 판단합니다.")
    @ParameterizedTest
    @CsvSource(value = {"312,123", "125,561", "512,751"}, delimiter = ',')
    public void 볼(String pitches, String hits) {
        boolean valid = false;

        for (int index = 0; index < pitches.length(); index++) {
            if (hits.indexOf(pitches.charAt(index)) > -1) {
                valid = true;
                break;
            }
        }

        assertThat(valid).isTrue();
    }

}
