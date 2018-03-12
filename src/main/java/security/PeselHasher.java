package security;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class PeselHasher {
	
	public static String getHash(byte[] inputBytes) {
		String hashValue="";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(inputBytes);
			byte [] digestedBytes = messageDigest.digest();
			hashValue= DatatypeConverter.printHexBinary(digestedBytes);
			
		}catch(Exception e){
			System.out.println("This error comes from HASH method");
			e.printStackTrace();
		}
		return hashValue;
	}
	

}
