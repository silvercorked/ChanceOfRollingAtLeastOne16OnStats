package chance.character.rolls;

import java.math.BigDecimal;

public class Runner {

	public static void main(String[] args) {
		BigDecimal timesRolled = BigDecimal.ZERO;
		BigDecimal timesCharacterHad16OrGreater = BigDecimal.ZERO;
		BigDecimal maxRuns = new BigDecimal("10000000");
		for(; timesRolled.compareTo(maxRuns) <= 0; timesRolled = timesRolled.add(BigDecimal.ONE)) {
			ThreeD6DropLowplus1net td = new ThreeD6DropLowplus1net();
			int[] current = td.getStats();
			for (int i = 0; i < current.length; i++) {
				if (current[i] >= 16) {
					timesCharacterHad16OrGreater = timesCharacterHad16OrGreater.add(BigDecimal.ONE);
					System.out.println("Amount of characters that had at least 1 16: " + timesCharacterHad16OrGreater.toString());
					System.out.println("Amount of runs so far: " + timesRolled.toString());
					break;
				}
			}
			try {
				System.out.println("Running Chance: " + (timesCharacterHad16OrGreater.divide(timesRolled)));
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
		}
		String.format("Percentage of character having, at least, 1 16 in stat rolls: %s over %s trials with %s successes.", timesCharacterHad16OrGreater.divide(timesRolled).toString(), timesRolled.toString(), timesCharacterHad16OrGreater.toString());
	}

}
