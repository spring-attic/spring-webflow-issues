package cz.csob.poc.jsf.service;

import cz.csob.poc.jsf.model.Client;

import java.util.List;

public interface IClientService {

	public List<Client> getClientList();
	
	public Client getClient(int id);
	
	public void saveClient(Client client);
}
