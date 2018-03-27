package c_dto.b_real;

import c_dto.a_abstract.Primary;

public class CondizioneCommerciale extends Primary{
	
	private Pagamento pagamento;
	
	private Trasporto trasporto;
	
	private Minimo minimo;
	
	private Fornitore fornitore;
	
//	/*@JsonIgnore*/ private Cliente azienda;

//	public Cliente getAzienda() {
//		return azienda;
//	}
//
//	public void setAzienda(Cliente azienda) {
//		this.azienda = azienda;
//	}

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


	


}




//package c_dto.b_real;
//
//import c_dto.a_abstract.Primary;
//
//public class CondizioneCommerciale extends Primary{
//	
//	private Pagamento pagamento;
//	
//	private Trasporto trasporto;
//	
//	private Minimo minimo;
//	
//	private Fornitore fornitore;
//	
//	/*@JsonIgnore*/ private Cliente azienda;
//
//	public Cliente getAzienda() {
//		return azienda;
//	}
//
//	public void setAzienda(Cliente azienda) {
//		this.azienda = azienda;
//	}
//
//	public Pagamento getPagamento() {
//		return pagamento;
//	}
//
//	public void setPagamento(Pagamento pagamento) {
//		this.pagamento = pagamento;
//	}
//
//	public Trasporto getTrasporto() {
//		return trasporto;
//	}
//
//	public void setTrasporto(Trasporto trasporto) {
//		this.trasporto = trasporto;
//	}
//
//	public Minimo getMinimo() {
//		return minimo;
//	}
//
//	public void setMinimo(Minimo minimo) {
//		this.minimo = minimo;
//	}
//
//	public Fornitore getFornitore() {
//		return fornitore;
//	}
//
//	public void setFornitore(Fornitore fornitore) {
//		this.fornitore = fornitore;
//	}
//
//	@Override
//	public String getCreateQuery() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUpdateQuery() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public String getSubQuery() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	
//
//
//}
