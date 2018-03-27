package c_dto.c_enum;

//public class Stato {
//	public static final int Attivo=1;
//	public static final int Archiviato=2;
//}

public enum Movimentazione {
	Aggiunge (1, "Aggiunge prodotti al magazzino selezionato"),
	Sottrae (2,"Sottrae prodotti al magazzino selezionato"),
	Invariato (3, "Il magazzino rimane invariato");

    private final int value;       
    private final String text;       

    private Movimentazione(int s, String t) {
    	value = s;
    	text=t;
    }
    
    public static Movimentazione fromValue(int x) {
    	Movimentazione myState;
        switch(x) {
        case 1:
            myState= Aggiunge;
            break;
        case 2:
            myState= Sottrae;
            break;
        default:
            myState= Invariato;
            break;
//        case 4:
//            myState= Subagente;
//            break;
//        default:
//            myState= Segnalatore;
        }
        return myState;
    }
    
    public static int fromName(Movimentazione x) {
    	int myState;
        switch(x) {
        case Aggiunge:
            myState= 1;
            break;
        case Sottrae:
            myState= 2;
            break;
//        case Altro:
//            myState= 3;
//            break;
//        case Subagente:
//            myState= 4;
//            break;
        default:
            myState= 3;
        }
        return myState;
    }
    
    
    
    public String getFullText() {
        return text;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return getFullText();
    }
    
//    public boolean equalsName(String otherName) {
//        // (otherName == null) check is not needed because name.equals(null) returns false 
//        return name.equals(otherName);
//    }

//    public String toString() {
//       return this.name;
//    }
}
