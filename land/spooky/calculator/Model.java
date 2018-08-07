package land.spooky.calculator;

/**
 * @author Daniel Gelber
 * @version 1.0
 * Created       - July 7, 2018
 * Last Modified - July 7, 2018
 * 
 * The model class for the Calculator. It contains the logic
 * used to perform any operation on the numbers given.
 */
public class Model {

    /**
     * The maximum amount of digits that can ever be
     * displayed on the output. User will be unable to 
     * get more digits shown by any means.
     */
    public static int digitLimit = 18;

    /**
     * Performs any necessary calculation
     *
     * @param num1 the first operand
     * @param num2 the second operand
     * @param operator the operation to be applied
     * @return the result of the operation, or the first number
     *         if the operation is '='
     */
    public static long calculate(long num1, long num2, String operator) {

	switch (operator) {

	case "+":
	    return num1 + num2;
	case "-":
	    return num1 - num2;
	case "*":
	    return num1 * num2;
	case "/":
	    if (num2 == 0)
		return 0;
	    return num1 / num2;
	case "=":
	    return num1;

	}

	return 0;

    }

}
