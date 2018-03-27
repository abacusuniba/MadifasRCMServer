package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//import com.google.gson.annotations.SerializedName;

import c_dto.OLD___a_abstract.DTOBase;

/**
 * si tratta della classe base che modella un generico utente
 * 
 * @author Rosario
 *
 */
@Entity
@Table(name="stato")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="id", discriminatorType=DiscriminatorType.INTEGER)
//@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Stato extends DTOBase{
	

	////@SerializedName("nome") 
	@Column(name="nome")
	private String nome;

	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}
//	/**
//	 * 
//	 * @param nome
//	 */
	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	
//	@Override
//	public boolean equals(Object arg0) {
//		Stato s = (Stato) arg0;
//		
//		return (this.getId() == s.getId() & this.getNome().equals(s.getNome()));
//
//	}
	
	@Override
	public String toString() {
		return getNome();

	}
	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
