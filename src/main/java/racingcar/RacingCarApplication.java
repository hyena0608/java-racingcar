package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.car.CarMovement;
import racingcar.domain.game.Cars;
import racingcar.domain.game.GameManager;
import racingcar.domain.number.NumberGenerator;
import racingcar.domain.number.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

	public static void main(String[] args) {
		final InputView inputView = new InputView();
		final OutputView outputView = new OutputView();
		final NumberGenerator numberGenerator = new RandomNumberGenerator();
		final CarMovement carMovement = new CarMovement(numberGenerator);
		final Cars cars = new Cars();
		final GameManager gameManager = new GameManager(carMovement, cars);
		final GameController gameController = new GameController(inputView, outputView, gameManager);

		// enum을 활용한 차량 이동 버전(V1)
		// gameController.playGameV1();

		// 전략 패턴을 활용한 차량 이동 버전(V2)
		gameController.playGameV2();
	}
}