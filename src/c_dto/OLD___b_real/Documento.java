package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//////import com.fasterxml.jackson.annotation.JsonManagedReference;
// //////import com.fasterxml.jackson.annotation.JsonBackReference;
//// //////import com.fasterxml.jackson.annotation.JsonBackReference;
////////import com.fasterxml.jackson.annotation.JsonManagedReference;

////import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.google.gson.annotations.SerializedName;

import c_dto.OLD___a_abstract.DTOBase;

import javax.persistence.JoinColumn;


@Entity
@Table(name="documento")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Documento extends DTOBase implements Comparable<Documento>{
	
	////@SerializedName("numero") 
	@Column(name="numero")//nome azienda
	private String numero;

	////@SerializedName("totale") 
	@Column(name="totale")//nome azienda
	private Float totale;

	//	public void setTotale(double totale) {
	//		this.totale = totale;
	//	}
	
	
	
	public void setTotale(Float totale) {
		this.totale = totale;
	}



		////@SerializedName("data") 
		@Column(name="data")//nome azienda
		private String data;

	////@SerializedName("stato") 
	@ManyToOne
	@JoinColumn(name = "stato", nullable=false)
	private Stato stato;

	//	@ManyToOne
	////@SerializedName("riferimento") 
	@ManyToOne
	@JoinColumn(name = "idcontatto", nullable=true)
	private Riferimento riferimento;

//	///*@JsonBackReference*/(value="rigaprodotto")
	///*@JsonManagedReference*/("prodotti")
	////@SerializedName("prodotti") 
		//il mappedby fa riferimento all'attributo "di ritorno" della classe inserita nella lista
		@OneToMany(mappedBy="documento", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	/*@JsonManagedReference*/ private List<RigaProdotto> prodotti = new ArrayList<>();

	
	//	///*@JsonBackReference*/(value="rigaprodotto")
	///*@JsonManagedReference*/("prodotti")
	////@SerializedName("prodotti") 
		//il mappedby fa riferimento all'attributo "di ritorno" della classe inserita nella lista
		@OneToMany(mappedBy="documento", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	/*@JsonManagedReference*/ private List<RigaTesto> testo = new ArrayList<>();

	////@SerializedName("tipo") 
	@ManyToOne
	@JoinColumn(name="idtipo")
	private TipoDocumento tipo;

	public List<RigaTesto> getTesto() {
		return testo;
	}

	public void setTesto(List<RigaTesto> testo) {
		this.testo = testo;
	}

	public float getTotale() {
		float tot;
		try{
			tot=totale.floatValue();
		}
		catch(NullPointerException e){
			tot=0;
		}
		
		return tot;
	}

//	public void setTotale(double totale) {
//		this.totale = totale;
//	}



	
	
	
	
	public List<RigaProdotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<RigaProdotto> prodotti) {
		this.prodotti = prodotti;
	}



	public Riferimento getRiferimento() {
		return riferimento;
	}

	public void setRiferimento(Riferimento riferimento) {
		this.riferimento = riferimento;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TipoDocumento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocumento tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Documento o) {

		
		GregorianCalendar cal = new GregorianCalendar(Locale.ITALY);
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare=0;
		
//		compare=this.getCognome().toLowerCase().compareTo(o.getCognome().toLowerCase());
		try {
			//data documento nel ns gestionale + data documento cliente
			compare+=ft.parse(getData()).compareTo(ft.parse(o.getData()));
//			compare+=getTipo().getTipo().compareTo(o.getTipo().getTipo());
//			//compare+=Integer.parseInt(getNumero())-Integer.parseInt(o.getNumero());
//			compare+=getNumero().compareTo(o.getNumero());
////			compare+=getRiferimento().getAzienda().compareTo(o.getRiferimento().getAzienda());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	
	
	public boolean contains(String s){
		boolean contain=false;
		
//		String stringForFilter = nome;
		String stringForFilter = getData() + "" + getNumero() + "" + getTipo().toString();
		
		
		
		stringForFilter=stringForFilter.toLowerCase();
		
		if (stringForFilter.indexOf(s.toLowerCase())>-1)
			contain=true;
		
		
		return contain;
}
	
}
