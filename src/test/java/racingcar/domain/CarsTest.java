package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
	Cars cars;

	@BeforeEach
	void setup() {
		cars = new Cars();
	}

	@DisplayName("자동차 이름 List로 Cars 등록 성공 테스트")
	@ParameterizedTest(name = "carNames = {0}, expectedSize = {1}")
	@MethodSource("carNamesDummy")
	void generateCarsSuccessTest(List<String> carNames, int expectedSize) {
		cars.generateCars(carNames);
		assertThat(cars.getCars()).hasSize(expectedSize);
	}

	@DisplayName("자동차 이름 갯수 0개거나 1개일 때 에러 발생 테스트")
	@ParameterizedTest(name = "carNames = {0}")
	@MethodSource("carNamesOneOrZeroDummy")
	void generateCarsOneOrZero(List<String> carNames) {
		assertThatThrownBy(() -> cars.generateCars(carNames))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 이름 목록 중 중복 존재 시 에러 발생 테스트")
	@ParameterizedTest(name = "carNames = {0}")
	@MethodSource("carNamesDuplicatedDummy")
	void generateCarsDuplicate(List<String> carNames) {
		assertThatThrownBy(() -> cars.generateCars(carNames))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("Cars 자동차 이동 정상 작동 테스트")
	@Test
	void moveCarsTest() {
		org.junit.jupiter.api.Assertions.assertDoesNotThrow(cars::moveCars);
	}

	static Stream<Arguments> carNamesDummy() {
		return Stream.of(
			Arguments.arguments(List.of("aaaa", "bbbb", "cccc"), 3),
			Arguments.arguments(List.of("가나다라", "가나다라마", "가나다"), 3),
			Arguments.arguments(List.of("1234", "123", "12"), 3)
		);
	}

	static Stream<Arguments> carNamesOneOrZeroDummy() {
		return Stream.of(
			Arguments.arguments(List.of("aaaa"),
			Arguments.arguments(Collections.emptyList()))
		);
	}

	static Stream<Arguments> carNamesDuplicatedDummy() {
		return Stream.of(
			Arguments.arguments(List.of("aaaa", "aaaa")),
			Arguments.arguments(List.of("aaaa", "a", "aaaa"))
		);
	}
}