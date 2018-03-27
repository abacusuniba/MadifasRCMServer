package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="indcivico")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Indirizzo extends DTOBase{
	
	////@SerializedName("civico") 
	@ManyToOne
	@JoinColumn(name="idcivico")
	private Civico civico;

	////@SerializedName("strada") 
	@ManyToOne
	@JoinColumn(name="idindirizzo")
	private Strada strada;
	
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@OneToMany(mappedBy = "indirizzo", cascade={CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
//	private List<IndirizzoAziendaPK> indAziende=new ArrayList<>();
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "indirizzi")
	private List<Azienda> aziende=new ArrayList<>();
//	
	public void addAzienda(Azienda a){
		if (!aziende.contains(a))
			aziende.add(a);
	}
	
	
//	
//	@ManyToOne
//	@JoinColumn(table="regione", name="idnazione")
//	private Nazione nazione;
//	
//	@ManyToOne
//	@JoinColumn(table="provincia", name="idregione")
//	private Regione regione;
//	
//	@ManyToOne
//	@JoinColumn(table="citta", name="idprovincia")
//	private Provincia provincia;
//	
//	@ManyToOne
//	@JoinColumn(table="capcitta", name="idcitta")
//	private Citta citta;
//	
//	@ManyToOne
//	@JoinColumn(table="capcitta", name="idcap")
//	private CAP cap;
	
	

	public Civico getCivico() {
		return civico;
	}

	public void setCivico(Civico civico) {
		this.civico = civico;
	}

	public Strada getStrada() {
		return strada;
	}

	public void setStrada(Strada strada) {
		this.strada = strada;
	}
	
	@Override
	public String toString() {
		
		//via pisa, 7 - 76125 Trani (BT) - Italia
		
		String s=getStrada().getNome() + ", " + getCivico().toString() + " - " + getStrada().getCapcitta().toString();
//		return getStrada().toString();
		return s;
		
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
