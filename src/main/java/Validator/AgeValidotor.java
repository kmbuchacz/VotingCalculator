package Validator;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import Layout.InvalidPesel;

public class AgeValidotor {

	static boolean validateAge = false;

	public static boolean ageValidator(String voterPesel) {
		
			int yearOfBirth = Integer.parseInt(voterPesel.substring(0, 2));
			int monthOfBirth = Integer.parseInt(voterPesel.substring(2, 4));
			int monthOfBirthFirstNumber = Integer.parseInt(voterPesel.substring(2, 3));
			int dayOfBirth = Integer.parseInt(voterPesel.substring(4, 6));
			
			
			if (monthOfBirthFirstNumber==2||monthOfBirthFirstNumber==3) {
				yearOfBirth=2000+yearOfBirth;
				monthOfBirth=monthOfBirth-20;}
			else if(monthOfBirthFirstNumber==0||monthOfBirthFirstNumber==1) 
				yearOfBirth=1900+yearOfBirth;
			else if (monthOfBirthFirstNumber==8||monthOfBirthFirstNumber==9) {
				yearOfBirth=1800+yearOfBirth;
				monthOfBirth=monthOfBirth-80;}
			else if (monthOfBirthFirstNumber==4||monthOfBirthFirstNumber==5) {
				yearOfBirth=2100+yearOfBirth;
				monthOfBirth=monthOfBirth-30;}
			else if (monthOfBirthFirstNumber==6||monthOfBirthFirstNumber==7) {
				yearOfBirth=2200+yearOfBirth;
				monthOfBirth=monthOfBirth-60;
			}
				
				
			LocalDate birthdate = new LocalDate (yearOfBirth, monthOfBirth, dayOfBirth);
			LocalDate now = new LocalDate();
			int age = Years.yearsBetween(birthdate, now).getYears();
					if (age>=18) {
						validateAge=true;
					}
	
		
	return validateAge;}

}
