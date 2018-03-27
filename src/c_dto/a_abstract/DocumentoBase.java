package c_dto.a_abstract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import c_dto.a_abstract.Riga;
import c_dto.b_real.Fornitore;
import c_dto.b_real.Minimo;
import c_dto.b_real.Pagamento;
import c_dto.b_real.Riferimento;
import c_dto.b_real.TipoDocumento;
import c_dto.b_real.Trasporto;

import com.fasterxml.jackson.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public abstract 	class DocumentoBase extends Primary{
//	public static final Comparator<Documento> valComparator = new Comparator<Documento>() {
//	    @Override
//	    public int compare(Documento v1, Documento v2) {
//	    	int compareTo = v1.getData().toLowerCase().compareTo(v2.getData().toLowerCase());
//	    	compareTo+= v1.getNumero().toLowerCase().compareTo(v2.getNumero().toLowerCase());
//	        
//	        return compareTo;
//	    }
//	};	
	
	
	
	
	
	private String numero;

	private Float totale;
	
	private int revisione;
	
	private String data;

	private String datarev;

	private Fornitore fornitore;

	private Riferimento riferimento;

	private TipoDocumento tipo;

	private Trasporto trasporto;

	private Pagamento pagamento;

	private Minimo minimo;

	public int getRevisione() {
		return revisione;
	}

	public void setRevisione(int revisione) {
		this.revisione = revisione;
	}



//	private Cliente cliente;
//
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}

	public void setTotale(Float totale) {
		this.totale = totale;
	}



	public String getDatarev() {
		return datarev;
	}

	public void setDatarev(String datarev) {
		this.datarev = datarev;
	}



		public Fornitore getFornitore() {
			return fornitore;
		}

		public void setFornitore(Fornitore fornitore) {
			this.fornitore = fornitore;
		}



		public Trasporto getTrasporto() {
		return trasporto;
	}

	public void setTrasporto(Trasporto trasporto) {
		this.trasporto = trasporto;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Minimo getMinimo() {
		return minimo;
	}

	public void setMinimo(Minimo minimo) {
		this.minimo = minimo;
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

	
//	public List<Riga> getRigheX() {
//		
//		
//		ArrayList<Riga> lista = new ArrayList<>();
//		
//		int i=0;
//		int j=0;
//		int k=0;
//		RigaProdotto rigaA;
//		RigaTesto rigaB;
//		
//		while (i< prodotti.size() && j< testo.size()) {
//			rigaA=prodotti.get(i);
//			rigaB=testo.get(j);
//			
//			if (rigaA.getProgressivo() < rigaB.getProgressivo()) {
//				lista.add(rigaA);
//				i++;
//			}
//			else {
//				lista.add(rigaB);
//				j++;
//			}
//		}
//		while (i< prodotti.size()) {
//			lista.add(prodotti.get(i++));
//		}
//		while (j< testo.size()) {
//			lista.add(testo.get(j++));
//		}
//		
//		
//		Collections.sort(lista);
//	
//		return lista;
//	}
	
	
	
	public Riferimento getRiferimento() {
		return riferimento;
	}

	public void setRiferimento(Riferimento riferimento) {
		this.riferimento = riferimento;
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

	public boolean contains(DocumentoBase elem) {
		String textConverted="";
		try{
			textConverted = getData() + " " + getNumero() + " " + getTipo().getTipo() + " " + getRiferimento().getCognome() + " " + getRiferimento().getNome() + " " + getRiferimento().getAzienda().toString();
		}
		catch(Exception e){
			textConverted = getData() + " " + getNumero() + " " + getTipo().getTipo();
			
		}
		
		return (textConverted.toLowerCase().indexOf(elem.getNumero().toLowerCase())>=0) ? true : false;
	}
	
//	@Override
//	public int compareTo(DTOBase o) {
////		=0: le stringhe sono uguali
////		>0: o < this
////		<0: o > this
//	
//		Documento n = (Documento) o;
////		int compare1=0;
////		int compare2=0;
//		int finalCompare1=0;
//		
////		try{
//		finalCompare1 = getData().toLowerCase().compareTo(n.getData().toLowerCase());
////		compare2=getNumero().toLowerCase().compareTo(n.getNumero().toLowerCase());
////		
////		if (compare1>0){
////			finalCompare++;
////		}
////		else{
////			if (compare1<0)
////				finalCompare--;
////		}
////		if (compare2>0){
////			finalCompare++;
////		}
////		else{
////			if (compare2<0)
////				finalCompare--;
////		}
//		
//////			compare1=getData().toLowerCase().compareTo(n.getData().toLowerCase());
//////			compare+=getCodice().toLowerCase().compareTo(n.getCodice().toLowerCase());
//////			finalCompare = compare1 + compare2;
//			if (finalCompare1==0){
//				
//				long thisNumero=0;
//				String thisNumeroS="";
//				
//				try {
//					thisNumero=Long.parseLong(getNumero());
//				}
//				catch (Exception e) {
//					thisNumeroS=getNumero();
//				}
//				
//				
//				long nNumero=0;
//				String nNumeroS="";
//				try {
//					nNumero=Long.parseLong(n.getNumero());
//				}
//				catch (Exception e) {
//					nNumeroS=n.getNumero();
//				}
//				
////				System.out.println(thisNumero + "  |  " + thisNumeroS);
////				System.out.println(nNumero + "  |  " + nNumeroS);
//				
//				
//				
//				
//				
//				if (thisNumeroS.length()==0 && nNumeroS.length()==0) {
//					//entrambi i numeri sono puramente numerici
////					finalCompare=0;
//					if (thisNumero>nNumero) {
//						finalCompare1+=1;
//					}
//					else if(thisNumero<nNumero){
//						finalCompare1+=-1;
//					}
//					else finalCompare1+=0;
//					
//				}
//				else {
//					if (thisNumeroS.length()>0) {
//						if (thisNumeroS.compareTo(String.valueOf(nNumero))>0){
//							finalCompare1+=1;
//						}
//						else if (thisNumeroS.compareTo(String.valueOf(nNumero))<0){
//							finalCompare1+=-1;
//						}
//						else finalCompare1+=0;
////						finalCompare1 += thisNumeroS.compareTo(String.valueOf(nNumero));
//					}
//					else if(nNumeroS.length()>0) {
//						if (nNumeroS.compareTo(String.valueOf(thisNumero))*(-1)>0){
//							finalCompare1+=1;
//						}
//						if (nNumeroS.compareTo(String.valueOf(thisNumero))*(-1)<0){
//							finalCompare1+=-1;
//						}
//						else finalCompare1+=0;
////						finalCompare1 += nNumeroS.compareTo(String.valueOf(thisNumero))*(-1);
//					}
//					
//				}
//				
//				
//				
//			
////				finalCompare=super.compareTo(o);
//			}
//////		}
//////		catch(Exception e){
//////			System.out.print("");
//////		}
//		
//		return finalCompare1;
//	}
}
