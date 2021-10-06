package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("투수 기능을 테스트합니다.")
public class PitcherTests {

    @DisplayName("1~9 사이 이외의 숫자만 사용할 수 있습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "213"})
    public void 유효한_숫자_입력(String value) {
        final boolean valid = value.matches("[1-9]\\d\\d");
        assertThat(valid).isTrue();
    }

    @DisplayName("1~9 사이 이외의 숫자로 사용할 수 없습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"4AB", "!12", "12가"})
    public void 유효하지_않은_숫자_입력(String value) {
        final boolean valid = value.matches("[1-9]\\d\\d");
        assertThat(valid).isFalse();
    }

    @DisplayName("입력한 숫자가 중복되지 않는지 확인합니다.")
    @ParameterizedTest
    @ValueSource(strings = "123")
    public void 중복문자_체크_성공(String value) {
        boolean noDuplicated = duplicatedCharacters(value);
        assertThat(noDuplicated).isTrue().isNotNull();
    }

    @DisplayName("입력한 숫자가 중복되는지 확인합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"122", "112", "121", "111"})
    public void 중복문자_체크_실패(String value) {
        boolean noDuplicated = duplicatedCharacters(value);
        assertThat(noDuplicated).isFalse().isNotNull();
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

}
