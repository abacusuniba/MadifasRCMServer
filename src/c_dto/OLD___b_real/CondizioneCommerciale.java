package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;

////import com.fasterxml.jackson.annotation.JsonBackReference;

//////import com.fasterxml.jackson.annotation.JsonBackReference;
//////import com.fasterxml.jackson.annotation.JsonManagedReference;

////////import com.fasterxml.jackson.annotation.JsonManagedReference;

////import com.google.gson.annotations.Expose;

////import com.fasterxml.jackson.annotation.JsonIgnoreProperties;//import com.fasterxml.jackson.annotation.JsonIgnore;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="condizioni")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
//@JsonIgnoreProperties({"azienda"})
public class CondizioneCommerciale extends DTOBase implements Comparable<CondizioneCommerciale>{
	
	////@SerializedName("pagamento") 
	@ManyToOne
    @JoinColumn(name="idpagamento")
	private Pagamento pagamento;
	
	////@SerializedName("trasporto") 
	@ManyToOne
    @JoinColumn(name="idtrasporto")
	private Trasporto trasporto;
	
	////@SerializedName("minimo") 
	@ManyToOne
    @JoinColumn(name="idminimo")
	private Minimo minimo;
	
	////@SerializedName("fornitore") 
	@ManyToOne
    @JoinColumn(name="idfornitore")
	private Fornitore fornitore;
	
	///*@JsonBackReference*/("condizioni")
//	///*@JsonManagedReference*/(value="condizionecommerciale")
//	@Expose(serialize = false)
	////@SerializedName("azienda") 
	@ManyToOne
    @JoinColumn(name="idazienda")
	/*@JsonIgnore*/ private Cliente azienda;
	////@SerializedName("stato") 
	@ManyToOne
	@JoinColumn(name = "stato", nullable=false)
	private Stato stato;

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public Cliente getAzienda() {
		return azienda;
	}

	@Transient
	public void setAzienda(Cliente azienda) {
		this.azienda = azienda;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Trasporto getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(Trasporto trasporto) {
		this.trasporto = trasporto;
	}

	public Minimo getMinimo() {
		return minimo;
	}

	public void setMinimo(Minimo minimo) {
		this.minimo = minimo;
	}

	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
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
	
	@Override
	public int compareTo(CondizioneCommerciale o) {
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
//		compare=this.getCognome().toLowerCase().compareTo(o.getCognome().toLowerCase());
		compare=this.getFornitore().getNome().toLowerCase().compareTo(o.getFornitore().getNome().toLowerCase());
		
		if (compare==0)
		{
//			compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
//			if (compare==0)
//			{
				compare=this.getId()-o.getId();
//			}
		}
		
		
		return compare;
		
	}


	


}
