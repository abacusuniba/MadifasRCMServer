package c_dto.b_real;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//import org.codehaus.jackson.annotate.JsonIgnore;

import c_dto.a_abstract.Azienda;
import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;




@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class Riferimento extends Primary{
	
	
	private Azienda azienda;

	public Azienda getAzienda() {
		return azienda;
	}


	private String nome;
	private String cognome;
	private Titolo titolo;
	private Ruolo ruolo;
	/*@JsonIgnore*/ private List<NoteContatto> note=new ArrayList<>();
	/*@JsonIgnore*/ private List<CellulareContatto> cellulare=new ArrayList<>();
	/*@JsonIgnore*/ private List<EmailContatto> email=new ArrayList<>();
	/*@JsonIgnore*/ private List<FaxContatto> fax=new ArrayList<>();
	/*@JsonIgnore*/ private List<CentralinoContatto> ufficio=new ArrayList<>();
	/*@JsonIgnore*/ private List<Strada> indirizzi=new ArrayList<>();
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
	public Titolo getTitolo() {
		return titolo;
	}
	public void setTitolo(Titolo titolo) {
		this.titolo = titolo;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	public List<NoteContatto> getNote() {
		return note;
	}
	public void setNote(List<NoteContatto> note) {
//		this.note = note;
		this.note.clear();
		this.note.addAll(note);
	}
	public List<CellulareContatto> getCellulare() {
		return cellulare;
	}
	public void setCellulare(List<CellulareContatto> cellulare) {
		this.cellulare.clear();
		this.cellulare.addAll(cellulare);
	}
	public List<EmailContatto> getEmail() {
		return email;
	}
	public void setEmail(List<EmailContatto> email) {
		this.email.clear();
		this.email.addAll(email);
	}
	public List<FaxContatto> getFax() {
		return fax;
	}
	public void setFax(List<FaxContatto> fax) {
		this.fax.clear();
		this.fax.addAll(fax);
	}
	public List<CentralinoContatto> getUfficio() {
		return ufficio;
	}
	public void setUfficio(List<CentralinoContatto> ufficio) {
		this.ufficio.clear();
		this.ufficio.addAll(ufficio);
	}
	public List<Strada> getIndirizzi() {
		return indirizzi;
	}
	public void setIndirizzi(List<Strada> indirizzi) {
//		this.indirizzi = indirizzi;
		this.indirizzi.clear();
		this.indirizzi.addAll(indirizzi);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return getCognome() + " " + getNome();
		return getCognome();
	}
	
	@Override
	public int compareTo(DTOBase o) {
		int res =0;
		if (o!=null) {
			Riferimento n = (Riferimento) o;
			 res = getCognome().compareTo(n.getCognome());// + super.compareTo(o);
			
			return res;
			
		}
		// TODO Auto-generated method stub
		return res;
	}


}