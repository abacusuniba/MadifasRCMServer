package c_dto.b_real;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.DocumentoAssociatoBase;
import c_dto.a_abstract.DocumentoBase;
import c_dto.a_abstract.Primary;

public class DocumentoAssociatoComparator implements Comparator<DocumentoAssociatoBase> {
	@Override
    public int compare(DocumentoAssociatoBase ax, DocumentoAssociatoBase bx) {
		
		
		DocumentoBase a = ax.getDocumento();
		DocumentoBase b = bx.getDocumento();
		
        int compare1 = a.getData().compareTo(b.getData())*(-1);
        
        int compare5 = a.getDatarev().compareTo(b.getDatarev())*(-1);
        
        int compare2=0;
//        = a.getNumero().compareTo(b.getNumero())*(-1);
        long aNumero=0;
        String aNumeroS="";
        long bNumero=0;
        String bNumeroS="";
        		
        try {
        	aNumero=Long.parseLong(a.getNumero());
        }
        catch(Exception e) {
        	aNumeroS=a.getNumero();
        }
        
        
        try {
        	bNumero=Long.parseLong(b.getNumero());
        }
        catch(Exception e) {
        	bNumeroS=b.getNumero();
        }
       
        
        if (aNumeroS.length()==0 && bNumeroS.length()==0) {
        	//sono entrambi numeri interamente numerici
        	if (aNumero>bNumero) {
        		compare2+=-1;
        	}
    		else if(aNumero<bNumero) {
        		compare2+=1;
    		}
    		else {
    			compare2+=0;
    		}
        }
        else if (aNumeroS.length()!=0 && bNumeroS.length()!=0) {
        	//entrambi contengono simboli
            compare2=a.getNumero().compareTo(b.getNumero())*(-1);
        }
        else {
	    		if (aNumeroS.length()>0) {
					if (aNumeroS.compareTo(String.valueOf(bNumero))>0){
						compare2+=-1;
					}
					else if (aNumeroS.compareTo(String.valueOf(bNumero))<0){
						compare2+=1;
					}
					else compare2+=0;
	    		}
	    		else if (bNumeroS.length()>0) {
					if (bNumeroS.compareTo(String.valueOf(aNumero))>0){
						compare2+=1;
					}
					else if (bNumeroS.compareTo(String.valueOf(aNumero))<0){
						compare2+=-1;
					}
					else compare2+=0;
	    		}
        }
        
        
        
        
        
        
        
        int compare3 = a.getTipo().getTipo().compareTo(b.getTipo().getTipo());
        
        int compare4=0;
        if (a.getRevisione()<b.getRevisione())
        	compare4=-1;
        else if(a.getRevisione()>b.getRevisione())
        	compare4=+1;
        
        return (compare1 == 0) ?
        			((compare5 == 0) ? 
                			((compare2 == 0) ? 
                					((compare3 == 0) ? compare4 : compare3) : 
                					compare2) : 
        					compare5) : 
        			compare1;
//		return (x < y) ? -1 : ((x == y) ? 0 : 1); 
    }
}