package Utilities;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class CheckRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Integer EmployeeNoCheckRegix(JTextField txtField) {
		Integer employeeno = null;
		if(IntegerNoCheckRegex(txtField.getText())!= null) {
			employeeno = IntegerNoCheckRegex(txtField.getText());
		} else {
			// Input is not a valid integer
						JOptionPane.showMessageDialog(null, "工號錯誤。請與人資確認！（備註：工號為Integer）", "Information",
								JOptionPane.INFORMATION_MESSAGE);
		}
		return employeeno;
	}
	
	
	public static Integer QtyNoCheckRegix(JTextField txtField) {
		Integer number = null;
		if(IntegerNoCheckRegex(txtField.getText())!= null || IntegerNoCheckRegex(txtField.getText())>=0) {
			number = IntegerNoCheckRegex(txtField.getText());
		} else {
			// Input is not a valid integer
						JOptionPane.showMessageDialog(null, "請填寫 >=0 的 integer 數字", "Information",
								JOptionPane.INFORMATION_MESSAGE);
		}
		return number;
	}
	
	public static Integer QtyJSpinnerCheckRegix(JSpinner spField) {
		Integer number = null;
		if(IntegerNoCheckRegex(spField.getValue().toString())!= null && IntegerNoCheckRegex(spField.getValue().toString())>=0) {
			number = IntegerNoCheckRegex(spField.getValue().toString());
		} else {
			// Input is not a valid integer
						JOptionPane.showMessageDialog(null, "請填寫 >=0 的 integer 數字", "Information",
								JOptionPane.INFORMATION_MESSAGE);
		}
		return number;
	}
	
	
	public static Integer IntegerNoCheckRegex(String txtfromInput) {
		Integer integerNo = null;
		// Define the RegEx pattern for integer validation
		String integerPattern = "^\\d+$"; // Matches positive and negative integers
		// Create the pattern object
		Pattern pattern = Pattern.compile(integerPattern);
		// Prompt the user for input
		String userInput = txtfromInput;
		// Validate input using regex
		if (pattern.matcher(userInput).matches()) {
			// Input is a valid integer
			 integerNo = Integer.parseInt(txtfromInput);
		} 
		return integerNo;
	}
}

