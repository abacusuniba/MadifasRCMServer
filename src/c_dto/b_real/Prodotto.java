package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import java.util.ArrayList;
import java.util.List;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;

public class Prodotto extends Primary{
	
	private String codice;

	private String nome;

	private double prezzo;

	private float peso;

	private UM um;

	private ArrayList<Descrizione> descrizioni=new ArrayList<>();
	
	

	public ArrayList<Descrizione> getDescrizioni() {
		return descrizioni;
	}

	public void setDescrizioni(List<Descrizione> descrizioni) {
		this.descrizioni.clear();
		this.descrizioni.addAll(descrizioni);
	}
	
	private Fornitore fornitore;
	public SottoGruppoProdotto getGruppo() {
		return gruppo;
	}

	public void setGruppo(SottoGruppoProdotto gruppo) {
		this.gruppo = gruppo;
	}

	private SottoGruppoProdotto gruppo;

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}


	public Fornitore getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}

	public UM getUm() {
		return um;
	}

	public void setUm(UM um) {
		this.um = um;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return getNome();

	}

	public boolean contains(Prodotto elem) {
		String contenuto = getNome() + "" + getCodice();
		
		for (Descrizione des : getDescrizioni()) {
			contenuto += des.getDescrizione()+"";
		}
		
		
		return (contenuto.toLowerCase().indexOf(elem.getNome().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		Prodotto n = (Prodotto) o;
		int compare=0;
		
//		try{
			compare=getNome().toLowerCase().compareTo(n.getNome().toLowerCase());
//			compare+=getCodice().toLowerCase().compareTo(n.getCodice().toLowerCase());
			if (compare==0){
				compare=super.compareTo(o);
			}
//		}
//		catch(Exception e){
//			System.out.print("");
//		}
		
		return compare;
	}
	
	
}
