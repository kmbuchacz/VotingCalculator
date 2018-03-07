package DAO;

import java.util.List;

import Entity.Client;

public interface ClientOperations {

	public void saveClient(Client tempClient);
	
	public List<Client> getClient();
	
}
