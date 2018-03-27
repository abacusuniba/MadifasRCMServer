package b_tiers.b_business.OLD___c_businessobject;

import c_dto.OLD___b_real.Iva;

public class BOIva extends BOBase<Iva>{
//	private Class<T> clazz;	
	
	@SuppressWarnings("unchecked")
	public BOIva(){
		setDao();
//		setDao(this.getClass().getGenericSuperclass());
//		
//		setDao((Class<? extends DTOBase>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
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
