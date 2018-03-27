package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.SecondaryTable;

import c_dto.OLD___a_abstract.Azienda;

///**
//*
//* 
//* @author Rosario
//*
//*/
@Entity
@DiscriminatorValue("3")
////@SecondaryTable(name="Partecipante")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Employee extends Utente {
	
	
	
//	
//	@Override
//	public String toString() {
//
//		return getNome();
//	}
//	
//	@Column(table="Partecipante", name="src")
//	private String src;
//
//	@Column(table="Partecipante", name="dataSrc")
//	private Date dataSrc;
//	
//	@Column(table="Partecipante", name="codFisc")
//	private String codFisc;
//	
//	@Column(table="Partecipante", name="tesseraSan")
//	private String tesseraSan;
//	
//	@Column(table="Partecipante", name="datanascita")
//	private Date datanascita;
//	
//	@Column(table="Partecipante", name="indirizzo")
//	private String indirizzo;
//	
//	@Column(table="Partecipante", name="sesso")
//	private char sesso;
////	private Character sesso;
//
//	/**
//	 * 
//	 * @return
//	 */
//	public String getSrc() {
//		return src;
//	}
//	/**
//	 * 
//	 * @param src
//	 */
//	public void setSrc(String src) {
//		this.src = src;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public Date getDataSrc() {
//		return dataSrc;
//	}
//	/**
//	 * 
//	 * @param dataSrc
//	 */
//	public void setDataSrc(Date dataSrc) {
//		this.dataSrc = dataSrc;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public String getCodFisc() {
//		return codFisc;
//	}
//	/**
//	 * 
//	 * @param codFisc
//	 */
//	public void setCodFisc(String codFisc) {
//		this.codFisc = codFisc;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public String getTesseraSan() {
//		return tesseraSan;
//	}
//	/**
//	 * 
//	 * @param tesseraSan
//	 */
//	public void setTesseraSan(String tesseraSan) {
//		this.tesseraSan = tesseraSan;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public Date getDatanascita() {
//		return datanascita;
//	}
//	/**
//	 * 
//	 * @param datanascita
//	 */
//	public void setDatanascita(Date datanascita) {
//		this.datanascita = datanascita;
//	}
//
//	/**
//	 * 
//	 * @return
//	 */
//	public String getIndirizzo() {
//		return indirizzo;
//	}
//	/**
//	 * 
//	 * @param indirizzo
//	 */
//	public void setIndirizzo(String indirizzo) {
//		this.indirizzo = indirizzo;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public char getSesso() {
//		return sesso;
//	}
//	/**
//	 * 
//	 * @param sesso
//	 */
//	public void setSesso(char sesso) {
//		this.sesso = sesso;
//	}	
//	
////@Override
////public boolean equals(Object arg0) {
////	
////	boolean result=false;
////
////	try {
////		result= (boolean) this.getClass().getSuperclass().getSuperclass().getMethod("equals", arg0.getClass()).invoke(getClass().getSuperclass().getSuperclass(), arg0);
////	} catch (IllegalAccessException | IllegalArgumentException
////			| InvocationTargetException | NoSuchMethodException
////			| SecurityException e) {
////		// TODO Auto-generated catch block
////	}
////	return result;
////}

}
