package b_tiers.b_business.OLD___c_businessobject;


//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import c_dto.a_abstract.DTOBase;
import c_dto.OLD___b_real.Administrator;
import c_dto.OLD___b_real.Archiviato;
import c_dto.OLD___b_real.Cliente;
import c_dto.OLD___b_real.SubAgente;
import c_dto.OLD___b_real.Employee;
import c_dto.OLD___b_real.Fornitore;
import c_dto.OLD___b_real.Manager;
import c_dto.OLD___b_real.Utente;

public class BOSubAgente extends BOBase<SubAgente>{
//	private Class<T> clazz;	
	
	@SuppressWarnings("unchecked")
	public BOSubAgente(){
		setDao();
//		setDao(this.getClass().getGenericSuperclass());
//		
//		setDao((Class<? extends DTOBase>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

//	public void add(SubAgente c){
//		getDao().create(c);
//		
//		getMemory().put(c.getId(), c);
//		
//	}
//
//	public void update(SubAgente c) {
//		getDao().update(c);
//	}

	public void delete(SubAgente c){
//		getDao().delete(c);
		
		getMemory().remove(c.getId());
		if (!c.isLoaded())
		{
			c=(SubAgente) getDao().read(c);
			c.setStato(Archiviato.getInstance());
		}
		
//		getDao().delete(c);
		getDao().update(c);
		
		
	}
	
	
	
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
