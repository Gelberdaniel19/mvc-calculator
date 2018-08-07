package land.spooky.calculator;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

/**
 * @author Daniel Gelber
 * @version 1.0
 * Created       - July 12, 2018
 * Last Modified - July 12, 2018
 *
 * The Controller for the Calculator, linking the GUI
 * with the logic. Handles all input.
 */
public class Controller {

    @FXML
    private Text output;
    private long storedNum = 0;
    private String operator;
    
    /**
     * This method is called every time the user presses a key on the
     * numberpad. It updates the display.
     * 
     * @param event the event triggered
     */
    @FXML
    private void processNumpad(ActionEvent event) {

	// Do nothing if the input limit is reached
	if (output.getText().length() + (Long.toString(storedNum)).length() >= Model.digitLimit)
	    return;

	// Append the typed number to the output box
	String value = ((Button)event.getSource()).getText();
	if (output.getText().equals("0") || output.getText().equals(Long.toString(storedNum))) {
	    output.setText(value);
	}
	else {
	    output.setText(output.getText() + value);
	}
	
    }

    /**
     * This method is called every time the user presses an operator.
     *
     * @param event the event triggered
     */
    @FXML
    private void processOperator(ActionEvent event) {

	// Sort the information needed
	String value = ((Button)event.getSource()).getText();
	long typedNum = Long.parseLong(output.getText());

	// If there is no active operator, set it and exit
	if (operator == null) {
	    operator = value;
	    storedNum = typedNum;
	    return;
	}

	// Assign the result of the operation to memory and
	// show that on the output.
	storedNum = Model.calculate(storedNum, typedNum, operator);
	output.setText(Long.toString(storedNum));

	// Remove the active operator if the user pressed '='
	// Otherwise set the active operator accordingly
	if (value.equals("=")) 
	    operator = null;       
	else 
	    operator = value;
	    
    }

    /**
     * This method clears the memory.
     *
     * @param event the event triggered
     */
    @FXML
    private void processClear(ActionEvent event) {

	storedNum = 0;
	output.setText("0");
	operator = null;

    }

}
