package b_tiers.b_business.OLD___c_businessobject;


//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

//import org.codehaus.jackson.map.util.Comparators;

import c_dto.a_abstract.Azienda;
import c_dto.a_abstract.DTOBase;
import c_dto.OLD___b_real.Administrator;
import c_dto.OLD___b_real.Archiviato;
import c_dto.OLD___b_real.Cliente;
import c_dto.OLD___b_real.Employee;
import c_dto.OLD___b_real.Manager;
import c_dto.OLD___b_real.Riferimento;
import c_dto.OLD___b_real.Stato;
import c_dto.OLD___b_real.Utente;

public class BOCliente extends BOBase<Cliente>{
//	private Class<T> clazz;	
	
	@SuppressWarnings("unchecked")
	public BOCliente(){
		setDao();
//		setDao(this.getClass().getGenericSuperclass());
//		
//		setDao((Class<? extends DTOBase>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	
//	public void add(Cliente c){
//		getDao().create(c);
//		
//		getMemory().put(c.getId(), c);
//	}
//	
//	public void update(Cliente c){
////		try{
//		
//		getDao().update(c);
////		}catch(Exception e){
////			e.printStackTrace();
////		}
//		
//		getMemory().put(c.getId(), c);
//	}
	
	public void delete(Cliente c){
//		getDao().delete(c);
		
		getMemory().remove(c.getId());
		if (!c.isLoaded())
		{
			c=(Cliente) getDao().read(c);
			c.setStato(Archiviato.getInstance());
		}
		
//		getDao().delete(c);
		getDao().update(c);
		
		
	}
	
	
	@Override
		public ArrayList<Cliente> getArray() {
			ArrayList<Cliente> array= new ArrayList<>();
			
			for (Cliente c : super.getArray()){
				if (!c.getStato().equals(Archiviato.getInstance())){
					array.add(c);
				}
			}
			
			return array;
		}
	
	
	
	public void filter(String table, String str){
		//con "table" mi ricavo i campi a cui fa riferimento
		
		
		
	}
	
	
	


//	public void delete(Riferimento rif){
//	}


//	public void add(Riferimento rif) {
//	}
	
	
	
	
	
	
//	public Utente findUser(String u, String p){
//		Utente user=null;
//		
//		Iterator<Entry<Integer, DTOBase>> i = getMemory();
//		
//		while(i.hasNext() & user==null){
//			user=(Utente) i.next().getValue();
//			
//			if (user.getUsername().equals(u) & user.getPassword().equals(p))
//				user=(Utente) getDao().read(user);
//			else
//				user=null;
//		}
////		if (user instanceof Manager)
////			System.out.println("Manager");
////		if (user instanceof Employee)
////			System.out.println("Employee");
////		if (user instanceof Administrator)
////			System.out.println("Administrator");
//		
//		
//		return user;
//	}
	
	
}
