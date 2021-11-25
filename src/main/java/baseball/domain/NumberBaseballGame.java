package baseball.domain;

import java.util.List;

public class NumberBaseballGame {
	private static final Integer BASEBALL_GAME_BALL_COUNT = 3;
	private static final Integer BASEBALL_GAME_NUMBER_RANGE_START = 1;
	private static final Integer BASEBALL_GAME_NUMBER_RANGE_END = 9;
	private static final String WRONG_LENGTH_INPUT = "입력할 숫자는 3자리만 가능합니다.";
	private static final String WRONG_RANGE_INPUT = "입력할 숫자는 1~9 사이만 가능합니다.";
	private static final String DUPLICATE_INPUT = "입력할 숫자는 서로 달라야 합니다.";

	private List<Integer> inputList;

	public void validateInputNumber(List<Integer> inputList) {
		this.inputList = inputList;
		validateLength();
		validateRange();
		validateDuplication();
	}

	private void validateLength() {
		if (inputList.size() != BASEBALL_GAME_BALL_COUNT) {
			throw new IllegalArgumentException(WRONG_LENGTH_INPUT);
		}
	}

	private void validateRange() {
		Boolean validateRangeResult = inputList.stream()
			.allMatch(number -> BASEBALL_GAME_NUMBER_RANGE_START <= number && number <= BASEBALL_GAME_NUMBER_RANGE_END);
		if (!validateRangeResult) {
			throw new IllegalArgumentException(WRONG_RANGE_INPUT);
		}
	}

	private void validateDuplication() {
		Boolean validateDuplicationResult = inputList.stream()
			.distinct()
			.count() != inputList.size();
		if (validateDuplicationResult) {
			throw new IllegalArgumentException(DUPLICATE_INPUT);
		}
	}
}
