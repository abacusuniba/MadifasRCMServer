package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

//////import com.fasterxml.jackson.annotation.JsonManagedReference;
// //////import com.fasterxml.jackson.annotation.JsonBackReference;
//// //////import com.fasterxml.jackson.annotation.JsonBackReference;
//// //////import com.fasterxml.jackson.annotation.JsonBackReference;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;

////import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.google.gson.annotations.SerializedName;

import c_dto.OLD___a_abstract.Azienda;

/**
*
* 
* @author Rosario
*
*/
@Entity
@DiscriminatorValue("1") //C
//@SecondaryTable(name="Partecipante")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Cliente extends Azienda {


	
	///*@JsonManagedReference*/("condizioni")
//	///*@JsonBackReference*/(value="condizionecommerciale")
	////@SerializedName("condizioni") 
	@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
//	@OrderBy(clause = "cognome")
	/*@JsonManagedReference*/ private List<CondizioneCommerciale> condizioni = new ArrayList<>();

//	private List<CondizioneCommerciale> condizioni;

	////@SerializedName("condCancellate") 
@Transient
private List<CondizioneCommerciale> condCancellate = new ArrayList<>();

	////@SerializedName("condModificate") 
@Transient
private List<CondizioneCommerciale> condModificate = new ArrayList<>();

	////@SerializedName("condNuove") 
@Transient
private List<CondizioneCommerciale> condNuove = new ArrayList<>();






////@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
@ElementCollection
@LazyCollection(LazyCollectionOption.FALSE)
@ManyToMany(cascade= CascadeType.ALL)
//@Fetch(FetchMode.SELECT)
@JoinTable(name = "aziendasettori", catalog = "databasercm", joinColumns = {
		@JoinColumn(name = "idazienda", nullable = false, updatable = false) },
		inverseJoinColumns = { @JoinColumn(name = "idsettore",
				nullable = false, updatable = false) })
private List<Settore> settori = new ArrayList<>();



	///*@JsonManagedReference*/("scheda")
//	///*@JsonBackReference*/(value="schedanetto")
	////@SerializedName("scheda") 
@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
//	@OrderBy(clause = "prodotto")
/*@JsonManagedReference*/ private List<SchedaNetto> scheda = new ArrayList<>();

//	private List<SchedaNetto> scheda;
	////@SerializedName("schCancellate") 
@Transient
private List<SchedaNetto> schCancellate=new ArrayList<>();

	////@SerializedName("schModificate") 
@Transient
private List<SchedaNetto> schModificate=new ArrayList<>();

	////@SerializedName("schNuove") 
@Transient
private List<SchedaNetto> schNuove=new ArrayList<>();



	////@SerializedName("consorzio") 
@ManyToOne
@JoinColumn(name = "idconsorzio")
private Consorzio consorzio=new Consorzio();



	////@SerializedName("gruppo") 
@ManyToOne
@JoinColumn(name = "idgruppo")
private GruppoSocietario gruppo = new GruppoSocietario();

public void addCondizione(CondizioneCommerciale rif) {
	condNuove.add(rif);
}

public void rimuoviCondizione(CondizioneCommerciale rif) {
//	rimossi.add(rif);
	condCancellate.add(rif);
	
//	modificati.remove(rif);
	condModificate.remove(rif);
//	nuovi.remove(rif);
	condNuove.remove(rif);
//	riferimenti.remove(rif);
	condizioni.remove(rif);
	
}
	
	
	
public void modificaCondizione(CondizioneCommerciale rif){
	if (condModificate.contains(rif)){
		condModificate.remove(rif);
	}
	condModificate.add(rif);
	
	condNuove.remove(rif);
	condizioni.remove(rif);
}
public List<CondizioneCommerciale> getCondizioni() {
	List<CondizioneCommerciale> myList= new ArrayList<>();
	
	myList.addAll(condizioni);
	myList.addAll(condModificate);
	myList.addAll(condNuove);
	
	Collections.sort(myList);
	
//	return riferimenti;
	return myList;
}
public void setCondizioni(List<CondizioneCommerciale> condizioni) {
this.condizioni.clear();
this.condizioni.addAll(condizioni);

condCancellate.clear();
condNuove.clear();
condModificate.clear();

}
	
public void setScheda(List<SchedaNetto> scheda) {
	this.scheda.clear();
	this.scheda.addAll(scheda);

	schCancellate.clear();
	schNuove.clear();
	schModificate.clear();
}



public void addScheda(SchedaNetto rif) {
	schNuove.add(rif);
}


public void rimuoviScheda(SchedaNetto rif) {
	schCancellate.add(rif);
	
	
	schModificate.remove(rif);
	schNuove.remove(rif);
	scheda.remove(rif);
	
}

public void modificaScheda(SchedaNetto rif){
	if (schModificate.contains(rif)){
		schModificate.remove(rif);
	}
	schModificate.add(rif);
	
	schNuove.remove(rif);
	scheda.remove(rif);
}


public List<SchedaNetto> getScheda() {
	List<SchedaNetto> myList= new ArrayList<>();
	
	myList.addAll(scheda);
	myList.addAll(schModificate);
	myList.addAll(schNuove);
	
	Collections.sort(myList);
	
//	return riferimenti;
	return myList;
}

public Consorzio getConsorzio() {
	return consorzio;
}

public void setConsorzio(Consorzio consorzio) {
	this.consorzio = consorzio;
}




public GruppoSocietario getGruppo() {
	return gruppo;
}

public void setGruppo(GruppoSocietario gruppo) {
	this.gruppo = gruppo;
}




public List<Settore> getSettori(){
	return settori;
}




	public void setSettori(List<Settore> settori) {
//	this.settori = settori;
//		try{
//			this.settori.clear();
//		}
//		catch(Exception e){
//			this.settori=new ArrayList<>();
//		}
//	this.settori.addAll(settori);
	
	this.settori= new ArrayList<>();
	this.settori.addAll(settori);
}



public boolean isModified() {
	
	boolean modified = super.isModified();
	
	modified = modified || (condNuove.size()>0 || condCancellate.size()>0 || condModificate.size()>0);

	modified = modified || (schNuove.size()>0 || schCancellate.size()>0 || schModificate.size()>0);
	
	
	
	return modified;

}
	
	
	
	
	
	

	
	//consorzio
	
	
	
	
	
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


//package c_dto.b_real;
//////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//////import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.SecondaryTable;
//import javax.persistence.Transient;
//
////////import com.fasterxml.jackson.annotation.JsonManagedReference;
//// //////import com.fasterxml.jackson.annotation.JsonBackReference;
////// //////import com.fasterxml.jackson.annotation.JsonBackReference;
////// //////import com.fasterxml.jackson.annotation.JsonBackReference;
//////////import com.fasterxml.jackson.annotation.JsonManagedReference;
//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;
//
//////import com.fasterxml.jackson.annotation.JsonManagedReference;
//
////import com.google.gson.annotations.SerializedName;
//
//import c_dto.OLD___a_abstract.Azienda;
//
///**
//*
//* 
//* @author Rosario
//*
//*/
//@Entity
//@DiscriminatorValue("1") //C
////@SecondaryTable(name="Partecipante")
////@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//public class Cliente extends Azienda {
//
//
//	
//	///*@JsonManagedReference*/("condizioni")
////	///*@JsonBackReference*/(value="condizionecommerciale")
//	////@SerializedName("condizioni") 
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
////	@OrderBy(clause = "cognome")
//	/*@JsonManagedReference*/ private List<CondizioneCommerciale> condizioni = new ArrayList<>();
//
////	private List<CondizioneCommerciale> condizioni;
//
//	////@SerializedName("condCancellate") 
//@Transient
//private List<CondizioneCommerciale> condCancellate = new ArrayList<>();
//
//	////@SerializedName("condModificate") 
//@Transient
//private List<CondizioneCommerciale> condModificate = new ArrayList<>();
//
//	////@SerializedName("condNuove") 
//@Transient
//private List<CondizioneCommerciale> condNuove = new ArrayList<>();
//	
//
//
//
//
//
//	//@LazyCollection(LazyCollectionOption.FALSE)
//	@LazyCollection(LazyCollectionOption.TRUE)
//	@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
//	private List<Settore> settori = new ArrayList<>();
//
//	///*@JsonManagedReference*/("scheda")
////	///*@JsonBackReference*/(value="schedanetto")
//	////@SerializedName("scheda") 
//@LazyCollection(LazyCollectionOption.FALSE)
//@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
////	@OrderBy(clause = "prodotto")
///*@JsonManagedReference*/ private List<SchedaNetto> scheda = new ArrayList<>();
//
////	private List<SchedaNetto> scheda;
//	////@SerializedName("schCancellate") 
//@Transient
//private List<SchedaNetto> schCancellate=new ArrayList<>();
//
//	////@SerializedName("schModificate") 
//@Transient
//private List<SchedaNetto> schModificate=new ArrayList<>();
//
//	////@SerializedName("schNuove") 
//@Transient
//private List<SchedaNetto> schNuove=new ArrayList<>();
//
//
//
//	////@SerializedName("consorzio") 
//@ManyToOne
//@JoinColumn(name = "idconsorzio")
//private Consorzio consorzio=new Consorzio();
//
//
//
//	////@SerializedName("gruppo") 
//@ManyToOne
//@JoinColumn(name = "idgruppo")
//private GruppoSocietario gruppo = new GruppoSocietario();
//
//public void addCondizione(CondizioneCommerciale rif) {
//	condNuove.add(rif);
//}
//
//public void rimuoviCondizione(CondizioneCommerciale rif) {
////	rimossi.add(rif);
//	condCancellate.add(rif);
//	
////	modificati.remove(rif);
//	condModificate.remove(rif);
////	nuovi.remove(rif);
//	condNuove.remove(rif);
////	riferimenti.remove(rif);
//	condizioni.remove(rif);
//	
//}
//	
//	
//	
//public void modificaCondizione(CondizioneCommerciale rif){
//	if (condModificate.contains(rif)){
//		condModificate.remove(rif);
//	}
//	condModificate.add(rif);
//	
//	condNuove.remove(rif);
//	condizioni.remove(rif);
//}
//public List<CondizioneCommerciale> getCondizioni() {
//	List<CondizioneCommerciale> myList= new ArrayList<>();
//	
//	myList.addAll(condizioni);
//	myList.addAll(condModificate);
//	myList.addAll(condNuove);
//	
//	Collections.sort(myList);
//	
////	return riferimenti;
//	return myList;
//}
//public void setCondizioni(List<CondizioneCommerciale> condizioni) {
//this.condizioni.clear();
//this.condizioni.addAll(condizioni);
//
//condCancellate.clear();
//condNuove.clear();
//condModificate.clear();
//
//}
//	
//public void setScheda(List<SchedaNetto> scheda) {
//	this.scheda.clear();
//	this.scheda.addAll(scheda);
//
//	schCancellate.clear();
//	schNuove.clear();
//	schModificate.clear();
//}
//
//
//
//public void addScheda(SchedaNetto rif) {
//	schNuove.add(rif);
//}
//
//
//public void rimuoviScheda(SchedaNetto rif) {
//	schCancellate.add(rif);
//	
//	
//	schModificate.remove(rif);
//	schNuove.remove(rif);
//	scheda.remove(rif);
//	
//}
//
//public void modificaScheda(SchedaNetto rif){
//	if (schModificate.contains(rif)){
//		schModificate.remove(rif);
//	}
//	schModificate.add(rif);
//	
//	schNuove.remove(rif);
//	scheda.remove(rif);
//}
//
//
//public List<SchedaNetto> getScheda() {
//	List<SchedaNetto> myList= new ArrayList<>();
//	
//	myList.addAll(scheda);
//	myList.addAll(schModificate);
//	myList.addAll(schNuove);
//	
//	Collections.sort(myList);
//	
////	return riferimenti;
//	return myList;
//}
//
//public Consorzio getConsorzio() {
//	return consorzio;
//}
//
//public void setConsorzio(Consorzio consorzio) {
//	this.consorzio = consorzio;
//}
//
//
//
//
//public GruppoSocietario getGruppo() {
//	return gruppo;
//}
//
//public void setGruppo(GruppoSocietario gruppo) {
//	this.gruppo = gruppo;
//}
//
//
//
//
//public List<Settore> getSettori(){
//	return settori;
//}
//
//
//
//
//	public void setSettori(List<Settore> settori) {
////	this.settori = settori;
//	this.settori.clear();
//	this.settori.addAll(settori);
//	
//}
//
//
//
//public boolean isModified() {
//	
//	boolean modified = super.isModified();
//	
//	modified = modified || (condNuove.size()>0 || condCancellate.size()>0 || condModificate.size()>0);
//
//	modified = modified || (schNuove.size()>0 || schCancellate.size()>0 || schModificate.size()>0);
//	
//	
//	
//	return modified;
//
//}
//	
//	
//	
//	
//	
//	
//
//	
//	//consorzio
//	
//	
//	
//	
//	
////	
////	@Override
////	public String toString() {
////
////		return getNome();
////	}
////	
////	@Column(table="Partecipante", name="src")
////	private String src;
////
////	@Column(table="Partecipante", name="dataSrc")
////	private Date dataSrc;
////	
////	@Column(table="Partecipante", name="codFisc")
////	private String codFisc;
////	
////	@Column(table="Partecipante", name="tesseraSan")
////	private String tesseraSan;
////	
////	@Column(table="Partecipante", name="datanascita")
////	private Date datanascita;
////	
////	@Column(table="Partecipante", name="indirizzo")
////	private String indirizzo;
////	
////	@Column(table="Partecipante", name="sesso")
////	private char sesso;
//////	private Character sesso;
////
////	/**
////	 * 
////	 * @return
////	 */
////	public String getSrc() {
////		return src;
////	}
////	/**
////	 * 
////	 * @param src
////	 */
////	public void setSrc(String src) {
////		this.src = src;
////	}
////	/**
////	 * 
////	 * @return
////	 */
////	public Date getDataSrc() {
////		return dataSrc;
////	}
////	/**
////	 * 
////	 * @param dataSrc
////	 */
////	public void setDataSrc(Date dataSrc) {
////		this.dataSrc = dataSrc;
////	}
////	/**
////	 * 
////	 * @return
////	 */
////	public String getCodFisc() {
////		return codFisc;
////	}
////	/**
////	 * 
////	 * @param codFisc
////	 */
////	public void setCodFisc(String codFisc) {
////		this.codFisc = codFisc;
////	}
////	/**
////	 * 
////	 * @return
////	 */
////	public String getTesseraSan() {
////		return tesseraSan;
////	}
////	/**
////	 * 
////	 * @param tesseraSan
////	 */
////	public void setTesseraSan(String tesseraSan) {
////		this.tesseraSan = tesseraSan;
////	}
////	/**
////	 * 
////	 * @return
////	 */
////	public Date getDatanascita() {
////		return datanascita;
////	}
////	/**
////	 * 
////	 * @param datanascita
////	 */
////	public void setDatanascita(Date datanascita) {
////		this.datanascita = datanascita;
////	}
////
////	/**
////	 * 
////	 * @return
////	 */
////	public String getIndirizzo() {
////		return indirizzo;
////	}
////	/**
////	 * 
////	 * @param indirizzo
////	 */
////	public void setIndirizzo(String indirizzo) {
////		this.indirizzo = indirizzo;
////	}
////	/**
////	 * 
////	 * @return
////	 */
////	public char getSesso() {
////		return sesso;
////	}
////	/**
////	 * 
////	 * @param sesso
////	 */
////	public void setSesso(char sesso) {
////		this.sesso = sesso;
////	}	
////	
//////@Override
//////public boolean equals(Object arg0) {
//////	
//////	boolean result=false;
//////
//////	try {
//////		result= (boolean) this.getClass().getSuperclass().getSuperclass().getMethod("equals", arg0.getClass()).invoke(getClass().getSuperclass().getSuperclass(), arg0);
//////	} catch (IllegalAccessException | IllegalArgumentException
//////			| InvocationTargetException | NoSuchMethodException
//////			| SecurityException e) {
//////		// TODO Auto-generated catch block
//////	}
//////	return result;
//////}
//
//}
