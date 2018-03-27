package c_dto.b_real;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;

public class CivicoComparator_old implements Comparator<Civico_old> {
	@Override
    public int compare(Civico_old a, Civico_old b) {
		
//        int compare1 = a.getData().compareTo(b.getData())*(-1);
        
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
        		compare2+=1;
        	}
    		else if(aNumero<bNumero) {
        		compare2+=-1;
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
						compare2+=1;
					}
					else if (aNumeroS.compareTo(String.valueOf(bNumero))<0){
						compare2+=-1;
					}
					else compare2+=0;
	    		}
	    		else if (bNumeroS.length()>0) {
					if (bNumeroS.compareTo(String.valueOf(aNumero))>0){
						compare2+=-1;
					}
					else if (bNumeroS.compareTo(String.valueOf(aNumero))<0){
						compare2+=1;
					}
					else compare2+=0;
	    		}
        }
        
        
        
        
        
        
        
//        int compare3 = a.getTipo().getTipo().compareTo(b.getTipo().getTipo());
        
        
        
//        return (compare1 == 0) ? ((compare2 == 0) ? compare3 : compare2) : compare1;
        return compare2;
////		return (x < y) ? -1 : ((x == y) ? 0 : 1); 
    }
}