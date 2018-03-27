package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import c_dto.OLD___a_abstract.DTOBase;

//import com.google.gson.annotations.SerializedName;


///**
// * si tratta della classe base che modella un generico utente
// * 
// * @author Rosario
// *
// */
//@Entity
//@Table(name="azienda")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="idtipo", discriminatorType=DiscriminatorType.INTEGER)
@Entity
@Table(name="Utente")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.INTEGER)
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Utente extends DTOBase{

//	@Column(name="nome")//nome azienda
	////@SerializedName("nome") 
	@Column(name="nome")
	private String nome;
	
	////@SerializedName("cognome") 
	@Column(name="cognome")
	private String cognome;
	
	////@SerializedName("username") 
	@Column(name="username")
	private String username;
	
	////@SerializedName("password") 
	@Column(name="password")
	private String password;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
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
	
	
	
//
//
//	@Column(name="piva")
//	private String piva;	
//
//	@Column(name="codfisc")
//	private String codfisc;
//
//	@Column(name="sito")
//	private String sito;
//
////	@OneToMany(mappedBy="azienda", targetEntity=CentralinoAzienda.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
//	@OneToMany(mappedBy="azienda", fetch=FetchType.EAGER)
//	public List<CentralinoAzienda> centralino;
//
//	@OneToMany(mappedBy="azienda", fetch=FetchType.EAGER)
//	public List<FaxAzienda> fax;
//
//	@OneToMany(mappedBy="azienda", fetch=FetchType.EAGER)
//	public List<NoteAzienda> note;
//
//	
//	public List<CentralinoAzienda> getCentralino() {
//		return centralino;
//	}
//	public void setCentralino(List<CentralinoAzienda> centralino) {
//		this.centralino = centralino;
//	}
//	public List<FaxAzienda> getFax() {
//		return fax;
//	}
//	public void setFax(List<FaxAzienda> fax) {
//		this.fax = fax;
//	}
//	public List<NoteAzienda> getNote() {
//		return note;
//	}
//	public void setNote(List<NoteAzienda> note) {
//		this.note = note;
//	}
//	//	public void setStato(Stato stato) {
////		this.stato = stato;
////	}
////
////	public Stato getStato() {
////		return stato;
////	}
//	/**
//	 * 
//	 * @return
//	 */
//	public String getNome() {
//		return nome;
//	}
//	/**
//	 * 
//	 * @param nome
//	 */
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//	public String getPartitaIva() {
//		return piva;
//	}
//	public void setPartitaIva(String piva) {
//		this.piva = piva;
//	}
//	public String getCodiceFiscale() {
//		return codfisc;
//	}
//	public void setCodiceFiscale(String codfisc) {
//		this.codfisc = codfisc;
//	}
//	public String getSito() {
//		return sito;
//	}
//	public void setSito(String sito) {
//		this.sito = sito;
//	}
	
}
