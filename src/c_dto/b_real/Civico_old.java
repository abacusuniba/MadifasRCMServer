package c_dto.b_real;
import c_dto.a_abstract.DTOBase;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.Primary;
import d_utils.StringBuilderQuery;

public class Civico_old extends Primary{
	
	private String numero;
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return getNumero();
	}

	public boolean contains(Civico_old elem) {
//		return (getNome().toLowerCase().indexOf(elem.getNome())+getSigla().toLowerCase().indexOf(elem.getSigla())>=0) ? true : false;
		return (getNumero().toLowerCase().indexOf(elem.getNumero().toLowerCase())>=0) ? true : false;
	}
	
	@Override
	public int compareTo(DTOBase o) {
		int compare=0;
		long aNumero=0;
		String aNumeroS="";
		String bNumeroS="";
		long bNumero=0;
		if (o!=null) {
			Civico_old n = (Civico_old) o;
			
			if (getNumero().matches("[0-9]+")) {
				aNumero=Long.parseLong(getNumero());
			}
			else {
				aNumeroS=getNumero();
				bNumeroS=n.getNumero();
			}
			if (n.getNumero().matches("[0-9]+")) {
				bNumero=Long.parseLong(n.getNumero());
			}
			else {
				aNumeroS=getNumero();
				bNumeroS=n.getNumero();
			}
			
			
			if (aNumeroS.length()>0 || bNumeroS.length()>0) {
				compare=aNumeroS.compareTo(bNumeroS);
			}
			else {
		        	if (aNumero>bNumero) {
		        		compare+=1;
		        	}
		    		else if(aNumero<bNumero) {
		        		compare+=-1;
		    		}
		    		else {
		    			compare+=0;
		    		}
				
			}
			
			
			
			
			
			
		}
		return compare;
		
//		Civico n = (Civico) o;
////		int res = getNumero().compareTo(n.getNumero());// + super.compareTo(o);
//		
//      try {
//		long aNumero=0;
//      String aNumeroS="";
//      
//      long bNumero=0;
//      String bNumeroS="";
////		return res;
//		
//		
//		
//		
//		
//		
//		
////        int compare1 = a.getData().compareTo(b.getData())*(-1);
//        
//        int compare2=0;
////        = a.getNumero().compareTo(b.getNumero())*(-1);
////        long aNumero=0;
////        String aNumeroS="";
////        
////        long bNumero=0;
////        String bNumeroS="";
//        		
//        try {
//        	aNumero=Long.parseLong(getNumero());
//        }
//        catch(Exception e) {
//        	aNumeroS=getNumero();
//        }
//        
//        
//        try {
//        	bNumero=Long.parseLong(n.getNumero());
//        }
//        catch(Exception e) {
//        	bNumeroS=n.getNumero();
//        }
//       
//        
//        if (aNumeroS.length()==0 && bNumeroS.length()==0) {
//        	//sono entrambi numeri interamente numerici
//        	if (aNumero>bNumero) {
//        		compare2+=1;
//        	}
//    		else if(aNumero<bNumero) {
//        		compare2+=-1;
//    		}
//    		else {
//    			compare2+=0;
//    		}
//        }
//        else if (aNumeroS.length()!=0 && bNumeroS.length()!=0) {
//        	//entrambi contengono simboli
//            compare2=getNumero().compareTo(n.getNumero())*(-1);
//        }
//        else {
//	    		if (aNumeroS.length()>0) {
//					if (aNumeroS.compareTo(String.valueOf(bNumero))>0){
//						compare2+=1;
//					}
//					else if (aNumeroS.compareTo(String.valueOf(bNumero))<0){
//						compare2+=-1;
//					}
//					else compare2+=0;
//	    		}
//	    		else if (bNumeroS.length()>0) {
//					if (bNumeroS.compareTo(String.valueOf(aNumero))>0){
//						compare2+=-1;
//					}
//					else if (bNumeroS.compareTo(String.valueOf(aNumero))<0){
//						compare2+=1;
//					}
//					else compare2+=0;
//	    		}
//        }
//        
//         
//        
//        
//        
//        
//        
////        int compare3 = a.getTipo().getTipo().compareTo(b.getTipo().getTipo());
//        
//        
//        
////        return (compare1 == 0) ? ((compare2 == 0) ? compare3 : compare2) : compare1;
////		return (x < y) ? -1 : ((x == y) ? 0 : 1); 
//		return compare2;
//		
//      }
//      catch(Exception e) {
//    	  System.out.print("");
//      }
//	return 0;
		
	}


}