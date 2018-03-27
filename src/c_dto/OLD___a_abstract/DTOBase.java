package c_dto.OLD___a_abstract;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;

//import com.google.gson.annotations.SerializedName;

import c_dto.b_real.CentralinoAzienda;



/**
*
* 
* @author Rosario
*
*/
@MappedSuperclass
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public abstract class DTOBase implements Serializable{
	
	////@SerializedName("id") 
	@Id @GeneratedValue
	@Column(name="id")
	private int id;//YouTube sucks!
//	private Integer idwithHashcode;
	
//	@Transient
//	private boolean modified;
	////@SerializedName("loaded") 
	@Transient
	private boolean loaded=false;
	public boolean isLoaded(){
		return loaded;
	}
	public void setLoaded(){
		loaded=true;
	}
	

	public abstract boolean isModified();
	public abstract boolean isEmpty();
//
//
//	public void setModified() {
//		this.modified = true;
//	}
//
//	public void setNotModified() {
//		this.modified = false;
//	}


	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	
	//rimuovere
	/**
	 * 
	 * @param id
	 */
	public void setId(int id){
		this.id=id;
	}
	
	@Override
	public boolean equals(Object obj) {
		DTOBase myDto=null;
		boolean result=false;
		
		if (obj != null){
			myDto = (DTOBase) obj;
//			result = ((this.getId() ==myDto.getId()) && (this.getId()!=0 || myDto.getId()!=0));
			result = (this.getId() ==myDto.getId());
		}
		
		return result;

	}
	
	@Override
	public int hashCode() {
//		idwithHashcode = new Integer(id);
//		
//		return idwithHashcode.hashCode();
		return id;
	}


}
