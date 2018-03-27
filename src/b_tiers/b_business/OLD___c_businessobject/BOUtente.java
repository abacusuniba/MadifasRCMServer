package b_tiers.b_business.OLD___c_businessobject;


//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;

import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.Map.Entry;

import c_dto.a_abstract.DTOBase;
import c_dto.OLD___b_real.Administrator;
import c_dto.OLD___b_real.Employee;
import c_dto.OLD___b_real.Manager;
import c_dto.OLD___b_real.Utente;

public class BOUtente extends BOBase<Utente>{
//	private Class<T> clazz;	
	
	@SuppressWarnings("unchecked")
	public BOUtente(){
		setDao();
//		setDao(this.getClass().getGenericSuperclass());
//		
//		setDao((Class<? extends DTOBase>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	public Utente findUser(String u, String p){
		Utente user=null;
		
		Iterator<Entry<Integer, DTOBase>> i = getMemory().entrySet().iterator();
		
		while(i.hasNext() & user==null){
//			user=(Utente) i.next().getValue();
			
			if (user.getUsername().equals(u) & user.getPassword().equals(p))
				user=(Utente) getDao().read(user);
			else
				user=null;
		}
		
		return user;
	}
	
	
}
