package it.unibo.rest.android;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.unibo.rest.android.dto.CheckDto;
import it.unibo.user.dao.factories.FactoryDao;
import it.unibo.user.domain.Utenti;
import iterator.ConteinerOfList;
import iterator.Iterator;

@Path("/client")
public class ClientService {
	
	private CheckDto checkDto;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CheckDto check(@QueryParam("name") String name, @QueryParam("surname") String surname){
		
		checkDto = new CheckDto();
		
		for(Iterator<Utenti> iter = new ConteinerOfList<Utenti>(FactoryDao.getInstance().getUserDao().getAll(Utenti.class)).getIterator(); iter.hasNext();){
			
			Utenti user = iter.next();
			if((user.getName()).equals(name) && (user.getSurname()).equals(surname)){
				checkDto.setOk(true);
			}
		}
		return checkDto;
	}
	
	@POST
	@Path("/usereg")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CheckDto addUser(Utenti user){
		checkDto = new CheckDto();
		try{
			FactoryDao.getInstance().getUserDao().save(user);
			checkDto.setOk(true);
		}
		catch(Exception e){
			checkDto.setOk(false);
			e.printStackTrace();
		}
		return checkDto;
	}

}
