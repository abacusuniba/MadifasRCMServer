package c_dto.a_abstract;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import c_dto.c_enum.Stato;

@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" )
public abstract class DTOBase implements Serializable, Comparable<DTOBase>{
	
	
//	private boolean locked;
//	public void lock() {
//		locked=true;
//	}
//	public void unlock() {
//		locked=false;
//	}
//	public boolean isLocked() {
//		return locked;
//	}
	
	
//	public abstract String getSubQuery();
////////////////////////////////////////////////
////////////////////////////////////////////////
	private long id;//contatore a 64-bit
	private int priority=0;//indicatore di priorità
						//più è basso il numero, più è alta la priorità
						//più è alto il numero, più è bassa la priorità
	
	public void incPriority() {
		priority++;
	}
	
	public int getPriority() {
		return priority;
	}

	public long getId() {
		return id;
	}
//	public int getPriority() {
//		return priority;
//	}
//	public void setPriority(int priority) {
//		this.priority = priority;
//	}
	public void setId(long id) {
		this.id = id;
	}
////////////////////////////////////////////////
////////////////////////////////////////////////
//	@Deprecated
//	private String table;//
//	
//	@Deprecated
//	public String getTable() {
//		return table;
//	}
//	@Deprecated
//	public void setTable(String table) {
//		this.table = table;
//	}
////////////////////////////////////////////////
////////////////////////////////////////////////
	private Stato stato;
	
	
	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}
////////////////////////////////////////////////
////////////////////////////////////////////////
	
	
	//QUERIES GENERATOR
//	public abstract String getCreateQuery();
//	public abstract String getReadQuery();
//	public abstract String getReadAllQuery();
//	public abstract String getUpdateQuery();
//	public abstract String getDeleteQuery();
	
	@Override
	public int compareTo(DTOBase o) {
//		long x = this.getId();
//		long y = o.getId();
//		return (x < y) ? -1 : ((x == y) ? 0 : 1); 
		
		return (int) (getId()-o.getId());
	}
	
	@Override
	public boolean equals(Object o) {
		boolean equals;
		try{
			equals=(getId()==((DTOBase)o).getId()) && getClass().equals(o.getClass());
		}
		catch(Exception e){
			equals=false;
		}
		return equals;//(getId()==((DTOBase)o).getId());
	}
	
//	public Field retrieveField(String it) {
//		Field f = null;
//		Class<?> superClass = getClass();
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
}
