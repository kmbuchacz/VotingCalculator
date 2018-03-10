package Validator;

import java.util.List;

import XMLParser.ReadXML;

public class BlockedListValidator {

	public static boolean validateUser(String userInput) {

		boolean invalidPesel = false; // When this boolean change to true that mean pesel passed by user is on blocked
										// list
		List<String> tempList = ReadXML.read();
		for (String blockedPesel : tempList) {
			if (blockedPesel.equals(userInput)) {
				invalidPesel = true;
			}
		}
		return invalidPesel;
	}
}
