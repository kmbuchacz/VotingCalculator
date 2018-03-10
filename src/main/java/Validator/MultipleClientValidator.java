package Validator;

import DAO.ClientOperationsImpl;
import Entity.Client;
import Security.PeselHasher;

public class MultipleClientValidator {

	ClientOperationsImpl operator = new ClientOperationsImpl();

	public boolean MulitpleClient(String voterPesel) {

		boolean onList = false; // this value will change to true if user is already on dataBase
		for (Client tempClient2 : operator.getClient()) {
			boolean voteChecker = false;
			if (tempClient2.isPassedVote() != 0) {
				voteChecker = true;
			}
			if (tempClient2.getPesel().equals(PeselHasher.getHash(voterPesel.getBytes())) && voteChecker) {
				onList = true;
			}
		}
		return onList;
	}

}
