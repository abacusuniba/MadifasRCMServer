package b_tiers.b_business.OLD___c_businessobject;

import c_dto.OLD___b_real.Archiviato;
import c_dto.OLD___b_real.Consorzio;

//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;


public class BOConsorzio extends BOBase<Consorzio>{
//	private Class<T> clazz;	
	
	@SuppressWarnings("unchecked")
	public BOConsorzio(){
		setDao();
//		setDao(this.getClass().getGenericSuperclass());
//		
//		setDao((Class<? extends DTOBase>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

//	public void add(Consorzio c){
//		getDao().create(c);
//		
//		getMemory().put(c.getId(), c);
//		
//	}
//
//	public void update(Consorzio c) {
//		getDao().update(c);		
//	}

	public void delete(Consorzio c) {
//		getDao().delete(c);
		
		getMemory().remove(c.getId());
		if (!c.isLoaded())
		{
			c=(Consorzio) getDao().read(c);
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
