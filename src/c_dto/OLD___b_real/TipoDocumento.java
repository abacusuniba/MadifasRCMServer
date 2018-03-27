package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.google.gson.annotations.SerializedName;

import javax.persistence.JoinColumn;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="tipodocumento")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class TipoDocumento extends DTOBase implements Comparable<TipoDocumento>{
	
	////@SerializedName("tipo") 
	@Column(name="tipo")//nome azienda
	private String tipo;
	
	////@SerializedName("showCondizioni") 
	@Column(name="showCondizioni")//nome azienda
	private boolean showCondizioni;
	
	////@SerializedName("showSpedizione") 
	@Column(name="showSpedizione")//nome azienda
	private boolean showSpedizione;
	
	////@SerializedName("showCollabs") 
	@Column(name="showCollabs")//nome azienda
	private boolean showCollabs;
	
	////@SerializedName("showAutoID") 
	@Column(name="showAutoID")//nome azienda
	private boolean showAutoID;
	
	////@SerializedName("showRiferimentoFittizio") 
	@Column(name="showRiferimentoFittizio")//nome azienda
	private boolean showRiferimentoFittizio;
	
	////@SerializedName("showCausale") 
	@Column(name="showCausale")//nome azienda
	private boolean showCausale;
	
	////@SerializedName("showFatturazione") 
	@Column(name="showFatturazione")//nome azienda
	private boolean showFatturazione;
	
	////@SerializedName("showSoloProdotti") 
	@Column(name="showSoloProdotti")//nome azienda
	private boolean showSoloProdotti;
	
	
//	
//	
//	
	
	
	
	
	
	////@SerializedName("movimentazione")
	@ManyToOne
	@JoinColumn(name = "idmovimentazione", nullable=false)
	private Movimentazione movimentazione;

	////@SerializedName("categoria") 
	@ManyToOne
	@JoinColumn(name = "idcategoria", nullable=false)
	private Categoria categoria;
	
	////@SerializedName("tipoazienda") 
	@ManyToOne
	@JoinColumn(name = "iddestinatario", nullable=false)
	private TipoAzienda tipoazienda;

	////@SerializedName("stato") 
	@ManyToOne
	@JoinColumn(name = "stato", nullable=false)
	private Stato stato;

	////@SerializedName("magazzino") 
	@ManyToOne
	@JoinColumn(name = "idmagazzino"/**/, nullable=false/**/)
	private Magazzino magazzino;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isShowCausale() {
		return showCausale;
	}

	public void setShowCausale(boolean showCausale) {
		this.showCausale = showCausale;
	}

	public boolean isShowFatturazione() {
		return showFatturazione;
	}

	public void setShowFatturazione(boolean showFatturazione) {
		this.showFatturazione = showFatturazione;
	}

	public boolean isShowSoloProdotti() {
		return showSoloProdotti;
	}

	public void setShowSoloProdotti(boolean showSoloProdotti) {
		this.showSoloProdotti = showSoloProdotti;
	}

	public TipoAzienda getTipoazienda() {
		return tipoazienda;
	}

	public void setTipoazienda(TipoAzienda tipoazienda) {
		this.tipoazienda = tipoazienda;
	}

	public Movimentazione getMovimentazione() {
		return movimentazione;
	}

	public void setMovimentazione(Movimentazione movimentazione) {
		this.movimentazione = movimentazione;
	}

	public boolean isShowCondizioni() {
		return showCondizioni;
	}

	public void setShowCondizioni(boolean showCondizioni) {
		this.showCondizioni = showCondizioni;
	}

//	public boolean isShowIndirizzi() {
//		return showIndirizzi;
//	}
//
//	public void setShowIndirizzi(boolean showIndirizzi) {
//		this.showIndirizzi = showIndirizzi;
//	}

	public boolean isShowCollabs() {
		return showCollabs;
	}

	public boolean isShowSpedizione() {
		return showSpedizione;
	}

	public void setShowSpedizione(boolean showSpedizione) {
		this.showSpedizione = showSpedizione;
	}

	public void setShowCollabs(boolean showCollabs) {
		this.showCollabs = showCollabs;
	}

	public boolean isShowAutoID() {
		return showAutoID;
	}

	public void setShowAutoID(boolean showAutoID) {
		this.showAutoID = showAutoID;
	}

	public boolean isShowRiferimentoFittizio() {
		return showRiferimentoFittizio;
	}

	public void setShowRiferimentoFittizio(boolean showRiferimentoFittizio) {
		this.showRiferimentoFittizio = showRiferimentoFittizio;
	}

	public Magazzino getMagazzino() {
		return magazzino;
	}

	public void setMagazzino(Magazzino magazzino) {
		this.magazzino = magazzino;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return getTipo();
	}
	
	public boolean contains(String s){
		boolean contain=false;
		
		String stringForFilter = tipo;
		
		
		
		stringForFilter=stringForFilter.toLowerCase();
		
		if (stringForFilter.indexOf(s.toLowerCase())>-1)
			contain=true;
		
		
		return contain;
}

	@Override
	public int compareTo(TipoDocumento o) {
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
		compare=getTipo().toLowerCase().compareTo(o.getTipo().toLowerCase());
		
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

}
