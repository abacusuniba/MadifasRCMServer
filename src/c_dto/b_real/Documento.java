package c_dto.b_real;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.DocumentoBase;
import c_dto.a_abstract.Primary;
import c_dto.a_abstract.Riga;
import com.fasterxml.jackson.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class Documento extends DocumentoBase{
//	public static final Comparator<Documento> valComparator = new Comparator<Documento>() {
//	    @Override
//	    public int compare(Documento v1, Documento v2) {
//	    	int compareTo = v1.getData().toLowerCase().compareTo(v2.getData().toLowerCase());
//	    	compareTo+= v1.getNumero().toLowerCase().compareTo(v2.getNumero().toLowerCase());
//	        
//	        return compareTo;
//	    }
//	};	

	
	


private Documento successivo;




	/*@JsonManagedReference*/ 
		/*@JsonManagedReference*/ private List<RigaProdotto> prodotti = new ArrayList<>();
		/*@JsonManagedReference*/ 
		/*@JsonManagedReference*/ private List<DocumentoSub> revisioni = new ArrayList<>();
		/*@JsonManagedReference*/ private List<DocumentoAssociato> documenti = new ArrayList<>();
		/*@JsonManagedReference*/ private List<DocumentoAssociatoSub> documentisub = new ArrayList<>();
		public List<DocumentoAssociatoSub> getDocumentisub() {
			return documentisub;
		}

		public void setDocumentisub(List<DocumentoAssociatoSub> documentisub) {
			this.documentisub = documentisub;
		}

		/*@JsonManagedReference*/ 
		/*@JsonManagedReference*/ private List<RigaTesto> testo = new ArrayList<>();
		public List<DocumentoAssociato> getDocumenti() {
			return documenti;
		}

		public void setDocumenti(List<DocumentoAssociato> documenti) {
			this.documenti = documenti;
		}



		public List<DocumentoSub> getRevisioni() {
			return revisioni;
		}

		public void setRevisioni(List<DocumentoSub> revisioni) {
			this.revisioni = revisioni;
		}




	public List<RigaTesto> getTesto() {
		return testo;
	}

	public void setTesto(List<RigaTesto> testo) {
		this.testo = testo;
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
	
	
	
	public List<RigaProdotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<RigaProdotto> prodotti) {
		this.prodotti = prodotti;
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