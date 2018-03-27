package b_tiers.b_business.OLD___c_businessobject;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import b_tiers.c_integration.a_dao.DaoRCM;
import c_dto.a_abstract.DTOBase;



public abstract class BOBase<T> {
	
private class DTOInfo{
	public DTOBase myDto;
	public boolean modificato;
}
	
	private HashMap<Integer, DTOBase> memory;
	private DaoRCM dbRCM;
	
	//memoria termporanea
	private ArrayList<DTOBase> temp;
	
//	private DTOBase selectedIndex=null;
	
	
//	public void setDao(Class<? extends DTOBase> c){
//		
//		dbRCM=new DaoRCM(c);
//		memory=dbRCM.readAll();
//	}
//	public void setDao(Type t){
//		
////		dbRCM=new DaoRCM(c);
////		memory=dbRCM.readAll();
//	}
	
//	public DTOBase getSelected() {
//		return selectedIndex;
//	}
//
//	public void setSelected(DTOBase selectedIndex) {
//		this.selectedIndex = selectedIndex;
//	}

	public ArrayList<DTOBase> getTemp() {
		return temp;
	}

	public void setDao(){
		
//		dbRCM=new DaoRCM((Class<? extends DTOBase>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
//		memory=dbRCM.readAll();
		temp=new ArrayList<>();
	}

	public HashMap<Integer, DTOBase> getMemory() {
		return memory;
	}

	public DaoRCM getDao() {
		return dbRCM;
	}
	
	public ArrayList<T> getArray() {
		ArrayList<T> array= new ArrayList<>();
		
		Iterator<Entry<Integer, DTOBase>> it = getMemory().entrySet().iterator();
		
		while (it.hasNext())
			array.add((T) it.next().getValue());

		return array;
	}
	
	
	
	
	
	
	
	public void add(DTOBase c){
//		getDao().create(c);
//		
//		getMemory().put(c.getId(), c);
	}
	
	public void update(DTOBase c){
//		try{
		
//		getDao().update(c);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
//		getMemory().put(c.getId(), c);
	}
	
	
//	private boolean isEmpty(DTOBase id){
//		
//		Object obj=null;
//		  
//		boolean empty=false;
//
//		try {
//			
////			obj= getDtoMap().get(id.getId()).getClass().getDeclaredMethod(XmlUtil.getEmptyFieldName(id.getClass().getSimpleName()), null).invoke(getDtoMap().get(id.getId()), null);
//			obj= getDtoMap().get(id.getId()).getClass().getMethod(XmlUtil.getEmptyFieldName(id.getClass().getSimpleName()), null).invoke(getDtoMap().get(id.getId()), null);
//			
//			if (obj == null){
//				empty=true;
//			}
//		} catch (IllegalAccessException | IllegalArgumentException
//				| InvocationTargetException | NoSuchMethodException
//				| SecurityException e1) {
//			obj=null;
//		}
//		
//		return empty;
//	}
	
	
}
