package b_tiers.b_business.c_businessobject.a_abstract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import b_tiers.c_integration.a_dao.DAO;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.b_real.Documento;
import c_dto.b_real.DocumentoComparator;
import c_dto.c_enum.Stato;
import d_utils.StringBuilderQuery;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseNewBOBase<T>{
	protected final Class<?> myClass=(Class<? extends DTOBase>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//	
//	
////	@Deprecated
////	private static final HashMap<Class<?>, HashMap<Long, DTOBase>> memory = new HashMap<>();
////	
////	@Deprecated
////	protected final void addElement(DTOBase o){
////		memory.get(myClass).put(o.getId(), o);
//////		memory.get(o.getClass()).put(o.getId(), o);
////}
////	@Deprecated
////	protected final void removeElement(DTOBase o){
////		memory.get(myClass).remove(o.getId());
//////		memory.get(myClass).get(o.getId()).setStato(Stato.Archiviato);
//////		o.setStato(Stato.Archiviato);
////}
////	@Deprecated
////	protected HashMap<Long, DTOBase> getMemory() {
////		return memory.get(myClass);
////	}
//	
//	
//	@SuppressWarnings("unchecked")
	protected final void startMemory(){
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
		DAO.retreiveMemory(myClass);
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////		
///////////////////////////////////////////////////////////////////////////////////////////////////////////		
///////////////////////////////////////////////////////////////////////////////////////////////////////////		
//	public void updateSubItem(DTOBase item) {
//		
//	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////		
///////////////////////////////////////////////////////////////////////////////////////////////////////////		
///////////////////////////////////////////////////////////////////////////////////////////////////////////		
////		
////		
////		
////		
////		
////		ResultSet rs = null;
////		if (memory.get(myClass)==null){
////			memory.put(myClass, new HashMap<>());
////			
////			//carica tutto l'elenco pre-filtrato di oggetti
////			rs=DAO.loadAll(myClass);
////			
//////			Object[] array= new Object[2];
//////			array[0] = myClass.getSimpleName().toLowerCase();
////			try{
////				while (rs.next()){
////					Object item = myClass.newInstance();
////								
////					for (String it: DAO.getFilteredFields(myClass).split(", ")){
////						
////						//ricavo l'attributo sulla base del nome
////						Field f = retrieveField(it, myClass);
////						
////						//lo rendo accessibile
////						f.setAccessible(true);
////						
////						//e lo vado ad avvalorare
////						//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
////						String column = DAO.getColumn(it, myClass);
////						
////						if (!List.class.isAssignableFrom(f.getType())){
////							if (!DTOBase.class.isAssignableFrom(f.getType())){
////	//						if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
////								//valuta attributo atomico
////								String atomicClassName = f.getType().getSimpleName().toLowerCase();
////	//							String column = DAO.getColumn(it, myClass);
////								if (f.getType().isEnum()){
////									switch(atomicClassName){
////									case "stato":
////										f.set(item, Stato.fromValue(rs.getInt(column)));
////										break;
////									default:
////										break;
////									}
////								}
////								else{
////									switch(atomicClassName){
////									case "string":
////										f.set(item, rs.getString(column));
////										break;
////									case "long":
////										f.set(item, rs.getLong(column));
////										break;
////									case "double":
////										f.set(item, rs.getDouble(column));
////										break;
////									case "float":
////										f.set(item, rs.getFloat(column));
////										break;
////									case "int":
////										f.set(item, rs.getInt(column));
////										break;
////									default:
////										break;
////									}
////								}
////							}
////							else{
////								//caricare i campi "filtrati" del sottotipo
////	//							DTOBase subItem = loadSubMemory(f.getType())
////								HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////								f.set(item, subElements.get(rs.getLong(column)));
////	//							f.set(item, loadSubMemory(f.getType()));
////							}
////							}
////						else{
//////							System.out.println("Lista elementi");
////							
////							ArrayList<DTOBase> lista = new ArrayList<>();// (ArrayList<DTOBase>) f.get(o);
////							subStartMemory(f, lista);
////							
////							
////							
//////
//////							
//////							ResultSet rs2=null;
//////							//gestire gli array
//////							@SuppressWarnings("unused")
//////							StringBuilderQuery subQuery = new StringBuilderQuery(readQuery);
//////							
//////							ArrayList<DTOBase> lista = new ArrayList<>();// (ArrayList<DTOBase>) f.get(o);
//////							
//////				            Type type = f.getGenericType();
//////
//////				            if (type instanceof ParameterizedType) {
//////
//////				                ParameterizedType pType = (ParameterizedType)type;
//////				                Type[] arr = pType.getActualTypeArguments();
//////				                Class<?> innerClass = (Class<?>) arr[0];
//////				                
////////				                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
////////				                subQuery.setField(2, getTable(innerClass));
//////				                
//////				                String externalID = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).externalKey;
//////				                
////////				                if(f.getName().toLowerCase().equals("riferimenti")){
////////				                	System.out.print("");
////////				                }
//////				                
//////				                
//////			                	ArrayList<StringBuilderQuery> subQueries = new ArrayList<>();
//////				                if (externalID!=null){
////////				                	Field innerField = retrieveField("stato", innerClass);
//////				                	boolean found=false;
//////					                subQuery.setField(1, "stato");
//////					                subQuery.setField(2, getTable(innerClass));
//////				                	subQuery.setField(3, externalID + "=" + o.getId());
//////				                	try{
//////				                		ResultSet myRS = getConnection().createStatement().executeQuery(subQuery.toString());
//////				                		found=true;
//////				                	}catch(SQLException e){
//////				                		//
//////				                		System.out.print("");
//////				                	}
//////				                	
//////				                	subQuery = new StringBuilderQuery(readQuery);
//////					                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
//////					                subQuery.setField(2, getTable(innerClass));
//////				                	subQuery.setField(3, externalID + "=" + o.getId());
//////				                	if (found==true){
//////				                		subQuery.append(" and stato=" + Stato.fromName(Stato.Attivo));
//////				                	}
//////				                	
//////////				                	Field innerField = retrieveField("stato", innerClass);
////////				                	
////////					                subQuery.setField(1, getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column);
////////					                subQuery.setField(2, getTable(innerClass));
////////				                	subQuery.setField(3, externalID + "=" + o.getId());
//////////				                	if (innerField!=null){
//////////				                		subQuery.append(" and stato=" + Stato.fromName(Stato.Attivo));
//////////				                	}
//////				                	
//////				                }
//////				                else{
//////				                	Iterator<Entry<String, String>> external = fieldMapper.get(o.getClass().getSimpleName().toLowerCase()).targets.entrySet().iterator();
//////				                	HashMap<String, String> external2 = fieldMapper.get(innerClass.getSimpleName().toLowerCase()).targets;
//////				                	
//////				                	boolean found =false;
//////				                	while (!found){
//////				                		Entry<String, String> x = external.next();
//////				                		
//////				                		if (external2.containsKey(x.getKey())){
//////				                			found=true;
//////				    	                	subQuery.setField(1, external2.get(x.getKey()) + " as id");
//////				    		                subQuery.setField(2, x.getKey());
//////				    		                subQuery.setField(3, x.getValue() + "=" + o.getId());
//////				                		}
//////				                	}
//////				                	
//////				                	
//////				                	
//////					                ResultSet rs4 = getConnection().createStatement().executeQuery(subQuery.toString());
//////					                String columns = getAllColumns(innerClass) + ", " + fieldMapper.get(innerClass.getSimpleName().toLowerCase()).coupleId.column;
//////					                String table = getTable(innerClass);
//////
//////					                while(rs4.next()){
//////										subQuery = new StringBuilderQuery(readQuery);
//////						                subQuery.setField(1, columns);
//////						                subQuery.setField(2, table);
//////					                	String ids ="id=" + rs4.getString("id");
//////					                	
//////					                	subQuery.setField(3, ids);
//////					                	subQueries.add(subQuery);
//////					                }
//////					                subQuery=null;
//////
//////					                
//////				                }
//////				                	
//////				                
////////				                try {
//////				                if (subQuery!=null){
////////					    			statement2 = getConnection().createStatement();
//////										rs2=getConnection().createStatement().executeQuery(subQuery.toString());
//////										
//////										lista = subRead(innerClass, rs2, memory2);
//////				                }
//////				                else{
//////				                	for (StringBuilderQuery query : subQueries){
//////				                		rs2=getConnection().createStatement().executeQuery(query.toString());
//////				                		lista.addAll(subRead(innerClass, rs2, memory2));
//////				                	}
//////				                }
//////									f.set(o, lista);
//////									
//////				            }
//////							
////						}							
////						
//////						String className = f.getType().getSimpleName().toLowerCase();
////						
//////						array[1]=it;
//////						String column = DAO.getColumnFiltered(array);
//////						switch(className){
//////						case "string":
////////							String column = DAO.getColumnFiltered(array);
//////							f.set(item, rs.getString(column));
//////							break;
//////						case "long":
////////							String column = DAO.getColumnFiltered(array);
//////							f.set(item, rs.getLong(column));
//////							break;
//////						case "stato":
////////							value += "" + Stato.fromName((Stato) field.get(o)) + "";
////////							String column = DAO.getColumnFiltered(array);
//////							f.set(item, Stato.fromValue(rs.getInt(column)));
//////							break;
//////						default:
//////							break;
//////						}
////////						f.set(item, value);
////						
////					}
////					addElement((DTOBase) item);
////				}
//////				System.out.print("");
////			}
////			catch (Exception e){
////				e.printStackTrace();
////			}
////			
////			
//////			try {
//////				while(rs.next()){
//////					Object item = myClass.newInstance();
//////					
//////					for (String s : DAO.getFilteredColumns(myClass).split(", ")){
//////						Field f = null;
//////					}
//////					
//////				}
//////			} catch (SQLException | InstantiationException | IllegalAccessException e) {
//////				e.printStackTrace();
//////			}			
////			
////		}
//////		return rs;
//	}
//
//
//
//
////	@Deprecated
////	private void subStartMemory(Field fx, ArrayList<DTOBase> itemx) {
////		// TODO Auto-generated method stub
////		Class<?> type = (Class<?>) ((ParameterizedType)fx.getGenericType()).getActualTypeArguments()[0];
////
////		ResultSet rs2 = DAO.loadAll(type);
////		
////		try{
////			while (rs2.next()){
////				DTOBase item = (DTOBase) type.newInstance();
////							
////				for (String it: DAO.getFilteredFields(type).split(", ")){
////					
////					//ricavo l'attributo sulla base del nome
////					Field f = retrieveField(it, type);
////					
////					//lo rendo accessibile
////					f.setAccessible(true);
////					
////					//e lo vado ad avvalorare
////					//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
////					String column = DAO.getColumn(it, type);
////					
////					if (!List.class.isAssignableFrom(f.getType())){
////						if (!DTOBase.class.isAssignableFrom(f.getType())){
//////						if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
////							//valuta attributo atomico
////							String atomicClassName = f.getType().getSimpleName().toLowerCase();
//////							String column = DAO.getColumn(it, type);
////							if (f.getType().isEnum()){
////								switch(atomicClassName){
////								case "stato":
////									f.set(item, Stato.fromValue(rs2.getInt(column)));
////									break;
////								default:
////									break;
////								}
////							}
////							else{
////								switch(atomicClassName){
////								case "string":
////									f.set(item, rs2.getString(column));
////									break;
////								case "long":
////									f.set(item, rs2.getLong(column));
////									break;
////								case "double":
////									f.set(item, rs2.getDouble(column));
////									break;
////								case "float":
////									f.set(item, rs2.getFloat(column));
////									break;
////								case "int":
////									f.set(item, rs2.getInt(column));
////									break;
////								default:
////									break;
////								}
////							}
////						}
////						else{
////							//caricare i campi "filtrati" del sottotipo
//////							DTOBase subItem = loadSubMemory(f.getType())
////							HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f.getType());
////							f.set(item, subElements.get(rs2.getLong(column)));
//////							f.set(item, loadSubMemory(f.getType()));
////							}
////					}
////					else{
////						ArrayList<DTOBase> lista = new ArrayList<>();// (ArrayList<DTOBase>) f.get(o);
////						subStartMemory(f, lista);
////					}							
////					
////				}
////				itemx.add(item);
//////				addElement((DTOBase) item);
////			}
//////			System.out.print("");
////		}
////		catch (Exception e){
////			e.printStackTrace();
////		}
////		
////		
////	}
//	
////	@Deprecated
////	private HashMap getSubMemory(Class<?> type) {
////	
////		ResultSet rs2 = null;
////		if (memory.get(type)==null){
////			memory.put(type, new HashMap<>());
////			
////			//carica tutto l'elenco pre-filtrato di oggetti
////			rs2=DAO.loadAll(type);
////			
//////			Object[] array= new Object[2];
//////			array[0] = type.getSimpleName().toLowerCase();
////			try{
////				while (rs2.next()){
////					Object item2 = type.newInstance();
////								
////					for (String it2: DAO.getFilteredFields(type).split(", ")){
////						
////						//ricavo l'attributo sulla base del nome
////						Field f2 = retrieveField(it2, type);
////						
////						//lo rendo accessibile
////						f2.setAccessible(true);
////						
////						//e lo vado ad avvalorare
////						//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
////						String column2 = DAO.getColumn(it2, type);
////						
////						if (!DTOBase.class.isAssignableFrom(f2.getType())){
//////						if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
////							//valuta attributo atomico
////							String atomicClassName = f2.getType().getSimpleName().toLowerCase();
//////							String column = DAO.getColumn(it, type);
////							if (f2.getType().isEnum()){
////								switch(atomicClassName){
////								case "stato":
////									f2.set(item2, Stato.fromValue(rs2.getInt(column2)));
////									break;
////								default:
////									break;
////								}
////							}
////							else{
////								switch(atomicClassName){
////								case "string":
////									f2.set(item2, rs2.getString(column2));
////									break;
////								case "long":
////									f2.set(item2, rs2.getLong(column2));
////									break;
////								default:
////									break;
////								}
////							}
////						}
////						else{
////							//caricare i campi "filtrati" del sottotipo
//////							DTOBase subItem = loadSubMemory(f.getType())
////							@SuppressWarnings("unchecked")
////							HashMap<Class<?>, HashMap<Long, DTOBase>> subElements = getSubMemory(f2.getType());
////							f2.set(item2, subElements.get(rs2.getLong(column2)));
//////							f.set(item, loadSubMemory(f.getType()));
////						}
////						
////					}
//////					addElement((DTOBase) item2);
////					memory.get(item2.getClass()).put(((DTOBase) item2).getId(), (DTOBase) item2);
////				}
//////				System.out.print("");
////			}
////			catch (Exception e){
////				e.printStackTrace();
////			}
////			
////			
////			
////		}
////		return memory.get(type);
////	}
//	//	@SuppressWarnings("unused")
//	
//	
//	
////	@Deprecated
////	private DTOBase loadSubMemory(Class<?> subClassElement) {
////		
////		ResultSet rs = null;
////		if (memory.get(subClassElement)==null){
////			memory.put(subClassElement, new HashMap<>());
////			
////			//carica tutto l'elenco pre-filtrato di oggetti
////			rs=DAO.loadAll(subClassElement);
////			
//////			Object[] array= new Object[2];
//////			array[0] = subClassElement.getSimpleName().toLowerCase();
////			try{
////				while (rs.next()){
////					Object item = subClassElement.newInstance();
////								
////					for (String it: DAO.getFilteredFields(subClassElement).split(", ")){
////						
////						//ricavo l'attributo sulla base del nome
////						Field f = retrieveField(it, subClassElement);
////						
////						//lo rendo accessibile
////						f.setAccessible(true);
////						
////						//e lo vado ad avvalorare
////						//(solo se attributo "atomico" - ovvero non sottoclasse di DTOBase)
////						if (!DTOBase.class.isAssignableFrom(f.getType())){
//////						if (!f.getType().isAssignableFrom(DTOBase.class)/* / && !f.getType().isEnum()/**/){
////							//valuta attributo atomico
////							String atomicClassName = f.getType().getSimpleName().toLowerCase();
////							String column = DAO.getColumn(it, subClassElement);
////							if (f.getType().isEnum()){
////								switch(atomicClassName){
////								case "stato":
////									f.set(item, Stato.fromValue(rs.getInt(column)));
////									break;
////								default:
////									break;
////								}
////							}
////							else{
////								switch(atomicClassName){
////								case "string":
////									f.set(item, rs.getString(column));
////									break;
////								case "long":
////									f.set(item, rs.getLong(column));
////									break;
////								default:
////									break;
////								}
////							}
////						}
////						else{
////							//caricare i campi "filtrati" del sottotipo
////							f.set(item, loadSubMemory(f.getType()));
////						}
////						
////						
////					}
////					addElement((DTOBase) item);
////				}
////				System.out.print("");
////			}
////			catch (Exception e){
////				e.printStackTrace();
////			}
////			
////			
////			
////		}
////		
////		return null;
////	}
//	
//	private Field retrieveField(String it, Class<?> type) {
//		Field f = null;
//		Class<?> superClass = type;
//		boolean found = false;
//		while(!found){
//			try {
//				f = superClass.getDeclaredField(it);
//				found=true;
//			} catch (Exception/*NoSuchFieldException | SecurityException*/ e1) {
//				superClass = superClass.getSuperclass();
//			}
//		}
//		return f;
//	}
//	public final void create(DTOBase o) {
//		o.setStato(Stato.Attivo);
//		DAO.createNew(o);
//	}
//	
//	
//	
//	public final void read(DTOBase o){
////		DAO.read(o, memory);
//		DAO.read(o);
//	}
//	
////	public abstract ArrayList<? extends DTOBase> readAll();
//	public final ArrayList<DTOBase> readAll(){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		Class<T> persistentClass = (Class<T>)
//				   ((ParameterizedType)getClass().getGenericSuperclass())
//				      .getActualTypeArguments()[0];
//		
//		Iterator<Entry<Long, DTOBase>> it = DAO.getAll(persistentClass);
////		Iterator<Entry<Long, DTOBase>> it = getMemory().entrySet().iterator();
//		DTOBase n;
//		while(it.hasNext()){
//			n = it.next().getValue();
//			if (n.getStato()==Stato.Attivo || n.getStato()==null)
//			lista.add(n);
////			System.out.println(n.getId() + ": " + ((Documento)n).getData().toLowerCase());
//		}
//		
//		
//		Collections.sort(lista);
//		
//		
////		try{
////		System.out.print("");
////			Collections.sort(lista, new DocumentoComparator());
////		}
////		catch (Exception e){
////			e.printStackTrace();
////			System.out.print("errore");
////		}
//		
//		return lista;
//	}
//	@Deprecated
//	public final ArrayList<DTOBase> readDeleted(){
//		return null;
////		ArrayList<DTOBase> lista=new ArrayList<>();
////		
////		Iterator<Entry<Long, DTOBase>> it = getMemory().entrySet().iterator();
////		
////		while(it.hasNext()){
////			DTOBase n = it.next().getValue();
////			if (n.getStato()==Stato.Archiviato)
////			lista.add(n);
////		}
////		
////		Collections.sort(lista);
////		
////		return lista;
//	}
//	
//	public final void update(DTOBase o) {
//		DAO.updateNew(o);
//	};
////	public abstract void delete(DTOBase o);
//	public final void delete(DTOBase o) {
//////		Nazione n=(Nazione) o;
//////		n.setStato(Stato.Archiviato);
////		removeElement(o);
//		
//		DAO.deleteNew(o);
////		DAO.update(o);
//	}
	
}
