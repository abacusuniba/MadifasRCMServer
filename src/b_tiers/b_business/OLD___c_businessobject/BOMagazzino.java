package b_tiers.b_business.OLD___c_businessobject;

import c_dto.OLD___b_real.Archiviato;
import c_dto.OLD___b_real.Magazzino;
import c_dto.OLD___b_real.Prodotto;

public class BOMagazzino extends BOBase<Magazzino>{
//	private Class<T> clazz;	
	
	@SuppressWarnings("unchecked")
	public BOMagazzino(){
		setDao();
//		setDao(this.getClass().getGenericSuperclass());
//		
//		setDao((Class<? extends DTOBase>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public void delete(Magazzino c) {
//		getDao().delete(c);
		
		getMemory().remove(c.getId());
		if (!c.isLoaded())
		{
			c=(Magazzino) getDao().read(c);
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
