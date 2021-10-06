package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("타자 기능을 테스트합니다.")
public class HitterTests {

    @DisplayName("기존 문자열과 새 문자가 중복되지 않는지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2", "12,3", "123,4"}, delimiter = ',')
    public void 중복없는_숫자_추가(String hits, String newHit) {
        final boolean valid = !hits.contains(newHit);
        assertThat(valid).isTrue().isNotNull();
    }

    @DisplayName("기존 문자열과 새 문자가 중복되는지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "12,2", "123,3"}, delimiter = ',')
    public void 중복있는_숫자_추가(String hits, String newHit) {
        final boolean valid = !hits.contains(newHit);
        assertThat(valid).isFalse();
    }

}
