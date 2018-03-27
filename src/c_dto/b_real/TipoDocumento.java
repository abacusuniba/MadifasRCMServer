package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import java.util.ArrayList;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.c_enum.Movimentazione;
import c_dto.c_enum.TipoAzienda;

public class TipoDocumento extends Primary{
	
	private String tipo;
	private String diciturafile;
	private String vocefile;
//	private ArrayList<Layout> layout = new ArrayList<>();
	private Layout layout;
	
//	public ArrayList<Layout> getLayout() {
//		return layout;
//	}
//
//	public void setLayout(ArrayList<Layout> layout) {
//		this.layout.addAll(layout);
//	}

	public String getVocefile() {
		return vocefile;
	}

	public Layout getLayout() {
		return layout;
	}

	public void setLayout(Layout layOut) {
		this.layout = layOut;
	}

	public void setVocefile(String vocefile) {
		this.vocefile = vocefile;
	}

	private Lingua lingua;
	
	public String getDiciturafile() {
		return diciturafile;
	}

	public void setDiciturafile(String diciturafile) {
		this.diciturafile = diciturafile;
	}

	public Lingua getLingua() {
		return lingua;
	}

	public void setLingua(Lingua lingua) {
		this.lingua = lingua;
	}

	private boolean showCondizioni;
	
	private boolean showSpedizione;
	
	private boolean showCollabs;
	
	private boolean showAutoID;
	
	private boolean showRiferimentoFittizio;
	
	private boolean showCausale;
	
	private boolean showFatturazione;
	
	private boolean showSoloProdotti;
	
	
	
	
	private boolean showColCodice;
	private boolean showColSigla;
	private boolean showColQuantita;
	private boolean showColPrezzo;
	private boolean showColTempi;
	private boolean showColConsegnaR;
	private boolean showColConsegnaP;
	
	public boolean isShowColCodice() {
		return showColCodice;
	}

	public void setShowColCodice(boolean showColCodice) {
		this.showColCodice = showColCodice;
	}

	public boolean isShowColSigla() {
		return showColSigla;
	}

	public void setShowColSigla(boolean showColSigla) {
		this.showColSigla = showColSigla;
	}

	public boolean isShowColQuantita() {
		return showColQuantita;
	}

	public void setShowColQuantita(boolean showColQuantita) {
		this.showColQuantita = showColQuantita;
	}

	public boolean isShowColPrezzo() {
		return showColPrezzo;
	}

	public void setShowColPrezzo(boolean showColPrezzo) {
		this.showColPrezzo = showColPrezzo;
	}

	public boolean isShowColTempi() {
		return showColTempi;
	}

	public void setShowColTempi(boolean showColTempi) {
		this.showColTempi = showColTempi;
	}

	public boolean isShowColConsegnaR() {
		return showColConsegnaR;
	}

	public void setShowColConsegnaR(boolean showColConsegnaR) {
		this.showColConsegnaR = showColConsegnaR;
	}

	public boolean isShowColConsegnaP() {
		return showColConsegnaP;
	}

	public void setShowColConsegnaP(boolean showColConsegnaP) {
		this.showColConsegnaP = showColConsegnaP;
	}

	private Movimentazione movimentazione;

	private Categoria categoria;
	
	private TipoAzienda tipoazienda;


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

	

//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		return false;
//	}

	public boolean contains(TipoDocumento elem) {
		return (getTipo().toLowerCase().indexOf(elem.getTipo().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		TipoDocumento n = (TipoDocumento) o;
		int compare=0;
		
		compare=getTipo().toLowerCase().compareTo(n.getTipo().toLowerCase());
		if (compare==0){
			compare=super.compareTo(o);
		}
		
		return compare;
	}
}
