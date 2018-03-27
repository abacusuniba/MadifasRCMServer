package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

// //////import com.fasterxml.jackson.annotation.JsonBackReference;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OrderBy;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;

////import com.fasterxml.jackson.annotation.JsonBackReference;
////import com.fasterxml.jackson.annotation.JsonManagedReference;

//////import com.fasterxml.jackson.annotation.JsonBackReference;
//////import com.fasterxml.jackson.annotation.JsonManagedReference;

////import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

/**
 * si tratta della classe base che modella un generico utente
 * 
 * @author Rosario
 *
 */
@Entity
@Table(name="contatto")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"azienda"})
public class Riferimento extends DTOBase implements Comparable<Riferimento>{

	////@SerializedName("nome") 
	@Column(name="nome")//nome azienda
	private String nome;

	////@SerializedName("cognome") 
	@Column(name="cognome")//nome azienda
	private String cognome;
	
	////@SerializedName("titolo") 
	@ManyToOne
    @JoinColumn(name="idtitolo")
	private Titolo titolo;
	
	////@SerializedName("ruolo") 
	@ManyToOne
    @JoinColumn(name="idruolo")
	private Ruolo ruolo;
	

	///*@JsonManagedReference*/("notecontatto")
	/////*@JsonBackReference*/(value="notecontatto")
	////@SerializedName("note") 
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="riferimento", cascade=CascadeType.ALL, orphanRemoval=true)
	/*@JsonManagedReference*/ private List<NoteContatto> note=new ArrayList<>();

	///*@JsonManagedReference*/("cellularecontatto")
	/////*@JsonBackReference*/(value="cellularecontatto")
	////@SerializedName("cellulare") 
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="riferimento", cascade=CascadeType.ALL, orphanRemoval=true)
	/*@JsonManagedReference*/ private List<CellulareContatto> cellulare=new ArrayList<>();

	///*@JsonManagedReference*/("emailcontatto")
	/////*@JsonBackReference*/(value="emailcontatto")
	////@SerializedName("email") 
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="riferimento", cascade=CascadeType.ALL, orphanRemoval=true)
	/*@JsonManagedReference*/ private List<EmailContatto> email=new ArrayList<>();
	
	
	
	///*@JsonManagedReference*/("faxcontatto")
	/////*@JsonBackReference*/(value="faxcontatto")
	////@SerializedName("fax") 
	@LazyCollection(LazyCollectionOption.FALSE)
		@OneToMany(mappedBy="riferimento", cascade=CascadeType.ALL, orphanRemoval=true)
	////	@OneToMany(mappedBy="riferimento", cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	//	@OneToMany(mappedBy="riferimento", targetEntity=FaxContatto.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	//	@Fetch(FetchMode.SELECT)
	/*@JsonManagedReference*/ private List<FaxContatto> fax=new ArrayList<>();

	///*@JsonManagedReference*/("centralinocontatto")
	/////*@JsonBackReference*/(value="centralinocontatto")
	////@SerializedName("ufficio") 
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="riferimento", cascade=CascadeType.ALL, orphanRemoval=true)
	/*@JsonManagedReference*/ private List<CentralinoContatto> ufficio=new ArrayList<>();

	////@SerializedName("indirizzi") 
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany()
	@JoinTable(name="elencoindirizzi", joinColumns={@JoinColumn(name="idcontatto")}, inverseJoinColumns={@JoinColumn(name="idindirizzo")})
	private List<Indirizzo> indirizzi=new ArrayList<>();


	//	@ManyToOne
	///*@JsonBackReference*/("riferimenti")
//	///*@JsonManagedReference*/(value="riferimento")
//	@Expose(serialize = false)
	////@SerializedName("azienda") 
//	@ManyToOne(fetch=FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name="idazienda")
	private Azienda azienda;


	@Override
	public String toString() {
		try{
			return getCognome() + " " + getTitolo() + " " + getNome();
		}
		catch(Exception e){
			return getCognome() + " " + getNome();
		}
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
		
	}

	public Titolo getTitolo() {
		return titolo;
	}

	public void setTitolo(Titolo titolo) {
		this.titolo = titolo;
	}

public Azienda getAzienda() {
		return azienda;
	}

	@Transient
	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

//	public List<CellulareContatto> getCellulare() {
//		return cellulare;
//	}
//
//	public void setCellulare(List<CellulareContatto> cellulare) {
//		this.cellulare.clear();
//		Iterator<CellulareContatto> it=cellulare.iterator();
//		CellulareContatto elem;
//		while (it.hasNext()){
//			elem=it.next();
//			if (elem.getRiferimento()==null)
//				elem.setRiferimento(this);
//		}
//		this.cellulare.addAll(cellulare);
//	}
//
//	public List<EmailContatto> getEmail() {
//		return email;
//	}
//
//	public void setEmail(List<EmailContatto> email) {
//		this.email.clear();
//		Iterator<EmailContatto> it=email.iterator();
//		EmailContatto elem;
//		while (it.hasNext()){
//			elem=it.next();
//			if (elem.getRiferimento()==null)
//				elem.setRiferimento(this);
//		}
//		this.email.addAll(email);
//	}
//
//	public List<FaxContatto> getFax() {
//		return fax;
//	}
//
//	public void setFax(List<FaxContatto> fax) {
//		this.fax.clear();
//		Iterator<FaxContatto> it=fax.iterator();
//		FaxContatto elem;
//		while (it.hasNext()){
//			elem=it.next();
//			if (elem.getRiferimento()==null)
//				elem.setRiferimento(this);
//		}
//		this.fax.addAll(fax);
//	}
//
//	public List<CentralinoContatto> getUfficio() {
//		return ufficio;
//	}
//
//	public void setUfficio(List<CentralinoContatto> ufficio) {
//		this.ufficio.clear();
//		Iterator<CentralinoContatto> it=ufficio.iterator();
//		CentralinoContatto elem;
//		while (it.hasNext()){
//			elem=it.next();
//			if (elem.getRiferimento()==null)
//				elem.setRiferimento(this);
//		}
//		this.ufficio.addAll(ufficio);
//		
//	}
//
//	public List<Indirizzo> getIndirizzi() {
//		return indirizzi;
//	}
//
//	public void setIndirizzi(List<Indirizzo> indirizzi) {
//		this.indirizzi.clear();
////		Iterator<Indirizzo> it=indirizzi.iterator();
////		Indirizzo elem;
////		while (it.hasNext()){
////			elem=it.next();
////			if (elem.getRiferimento()==null)
////				elem.setRiferimento(this);
////		}
////		this.indirizzi = indirizzi;
//		this.indirizzi.addAll(indirizzi);
//	}
//
//	public List<NoteContatto> getNote() {
//		return note;
//	}
//
//	public void setNote(List<NoteContatto> note) {
//		this.note.clear();
//		Iterator<NoteContatto> it=note.iterator();
//		NoteContatto elem;
//		while (it.hasNext()){
//			elem=it.next();
//			if (elem.getRiferimento()==null)
//				elem.setRiferimento(this);
//		}
//		this.note.addAll(note);
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public int compareTo(Riferimento o) {
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
		compare=this.getCognome().toLowerCase().compareTo(o.getCognome().toLowerCase());
		
		if (compare==0)
		{
			compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
			if (compare==0)
			{
				compare=this.getId()-o.getId();
			}
		}
		
		
		return compare;
		
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

	
//	@ManyToOne
//	@JoinColumn(name = "idtitolo")
//	private Titolo titolo;
	
//	@ManyToOne
//	@JoinColumn(name = "idruolo")
//	private Ruolo ruolo;
	
	
	
	
}
