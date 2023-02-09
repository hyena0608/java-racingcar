package racingcar.domain;

import static racingcar.messsages.ExceptionMessage.*;

import java.util.Objects;

public class Car {
	private static final int MAX_NAME_LENGTH = 5;

	private final String name;
	private int position;

	public Car(String name) {
		validateNameNullOrBlank(name);
		validateNameLength(name);
		this.name = name;
		position = 0;
	}

	public void move() {
		CarMovement carMovement = new CarMovement(new RandomNumberGenerator());
		if (carMovement.isMoveForward()) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	private void validateNameNullOrBlank(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateNameLength(String name) {
		int nameLength = name.length();
		if (nameLength > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION.getMessage());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Car)) {
			return false;
		}
		Car car = (Car)o;
		return position == car.position && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
