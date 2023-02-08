package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("Set 필드 내부 요소 개수 확인 테스트")
	@Test
	void setSizeCheckTest() {
		final int setSize = numbers.size();
		assertThat(setSize).isEqualTo(3);
	}

	@DisplayName("Set 필드의 contains 메소드 활용하여 요소 확인 테스트")
	@ParameterizedTest(name = "input = {0}")
	@ValueSource(ints={1,2,3})
	void setContainsCheckTest(int input) {
		assertThat(numbers.contains(input)).isTrue();
	}

	@DisplayName("Set 필드의 contains 메소드 활용하여 요소가 포함되는지 확인 테스트")
	@ParameterizedTest(name = "input = {0}, expected = {1}")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void setContainsExactlyCheckTest(int input, boolean expected) {
		Assertions.assertEquals(expected, numbers.contains(input));
	}
}
