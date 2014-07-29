package cz.csob.poc.jsf.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import cz.csob.poc.jsf.model.BirthNumber;
import cz.csob.poc.jsf.model.Client;
import cz.csob.poc.jsf.model.Gender;

//@Service
//@Scope("singleton")
@Named
@ApplicationScoped
public class ClientService implements IClientService {
	private static Logger logger = LoggerFactory.getLogger(ClientService.class);
	
	private final List<Client> clientList;
	private int idGenerator = 1;
	
	public ClientService() {
		super();
		clientList = createClientList();
	}
	
	private List<Client> createClientList() {		
		List<Client> clientList = new ArrayList<Client>();
		
		clientList.add(new Client(idGenerator++, Gender.MALE, "Jiří", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), true, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Jan", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Luboš", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Proktor", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Qvído", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Waltr", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Emil", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Roman", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Trdlo", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Zdeněk", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), true, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Uwe", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Ivan", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Osman", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Petr", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Alfons", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Samaritán", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Donald", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Franta", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), true, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Gustav", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Hasan", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Karel", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Yenkee", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Xaver", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Corel", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Vaadin", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Bin Vaadin", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Normen", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Matěj", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Martin", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Narval", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Balík", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Vukovič", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Cecil", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Xylofon", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Yvenhow", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Lopaťák", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Kolohnát", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Jantar", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Haptislav", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Galoš", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.MALE, "Fíkus", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.FEMALE, "Qidoslava", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), true, null));
		clientList.add(new Client(idGenerator++, Gender.FEMALE, "Wormina", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.FEMALE, "Emilka", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.FEMALE, "Romana", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), true, null));
		clientList.add(new Client(idGenerator++, Gender.FEMALE, "Tatana", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.FEMALE, "Yvone", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		clientList.add(new Client(idGenerator++, Gender.FEMALE, "Udesda", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), true, null));
		clientList.add(new Client(idGenerator++, Gender.FEMALE, "Ikara", "Malkowich", new BirthNumber(795056, 5698), new BigDecimal("1455.78"), false, null));
		
		logger.trace("Returns list of item's count: " + clientList.size());
		
		return clientList;
	}

	@Override
	public synchronized List<Client> getClientList() {
		List<Client> clientListCopy = new ArrayList<>(clientList.size());
		for (Client client : clientList) {
			clientListCopy.add(Client.copy(client));
		}
		return clientListCopy;
	}

	@Override
	public synchronized Client getClient(int id) {
		for (Client client : clientList) {
			if (client.getId() == id) {
				return Client.copy(client);
			}
		}
		return null;
	}

	@Override
	public synchronized void saveClient(Client client) {
		Assert.notNull(client, "Null client can't be saved.");
		Client clientCopy = Client.copy(client);
		
		if (clientCopy.getId() == 0) {
			client.setId(idGenerator++);
			clientList.add(client);
			return;
		}
		
		for (int i = 0; i < clientList.size(); i++) {
			Client savedClient = clientList.get(i);
			if (savedClient.getId() == client.getId()) {
				clientList.set(i, client);
				return;
			}
			
		}
	}

}
