package study;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

	private final String one = "1";
	private final String oneTwo = "1, 2";
	private final String setOneTwo = "(1,2)";
	private final String separator = "\\s*,\\s*";
	private final String abc = "abc";

	@DisplayName("길이가 1인 문자열 split() 사용하여 나누는 테스트")
	@Test
	void splitOneTest() {
		String[] splitOne = one.split(separator);
		assertThat(splitOne).containsExactly("1");
	}

	@DisplayName("길이가 2이상인 문자열 split() 사용하여 나누는 테스트")
	@Test
	void splitOneTwoTest() {
		String[] splitOneTwo = oneTwo.split(separator);
		assertThat(splitOneTwo).contains("1", "2");
	}

	@DisplayName("substring 메서드를 활용하여 문자열에서 괄호 제거 확인하는 테스트")
	@Test
	void splitSetOneTwoTest() {
		String splitOneTwo = setOneTwo.substring(1, setOneTwo.length() - 1);
		assertThat(splitOneTwo).isEqualTo("1,2");
	}

	@DisplayName("split 메서드를 활용하여 괄호 제거 확인하는 테스트")
	@Test
	void splitSetOneTwoTestVer2() {
		String splitOneTwo = setOneTwo.split("[(|)]")[1];
		assertThat(splitOneTwo).isEqualTo("1,2");
	}

	@DisplayName("String 클래스 특정 인덱스 문자 가져오는 테스트")
	@Test
	void selectSpecificCharacterTest() {
		char a = abc.charAt(0);
		char b = abc.charAt(1);
		char c = abc.charAt(2);
		org.junit.jupiter.api.Assertions.assertAll(
			() -> assertThat(a).isEqualTo('a'),
			() -> assertThat(b).isEqualTo('b'),
			() -> assertThat(c).isEqualTo('c')
		);
	}

	@DisplayName("범위 밖의 인덱스로 특정 문자열 가져왔을 때 예외 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, 3})
	void selectOutOfRangeIndexExceptionTest(int outOfRangeIndex) {
		assertThatThrownBy(() -> abc.charAt(outOfRangeIndex))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}


}
