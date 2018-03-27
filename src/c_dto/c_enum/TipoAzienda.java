package c_dto.c_enum;

//public class Stato {
//	public static final int Attivo=1;
//	public static final int Archiviato=2;
//}

public enum TipoAzienda {
	Cliente (1),
	Fornitore (2),
	Altro (3),
	Subagente (4),
	Segnalatore (5);

    private final int value;       

    private TipoAzienda(int s) {
    	value = s;
    }
    
    public static TipoAzienda fromValue(int x) {
    	TipoAzienda myState;
        switch(x) {
        case 1:
            myState= Cliente;
            break;
        case 2:
            myState= Fornitore;
            break;
        case 3:
            myState= Altro;
            break;
        case 4:
            myState= Subagente;
            break;
        default:
            myState= Segnalatore;
        }
        return myState;
    }
    
    public static int fromName(TipoAzienda x) {
    	int myState;
        switch(x) {
        case Cliente:
            myState= 1;
            break;
        case Fornitore:
            myState= 2;
            break;
        case Altro:
            myState= 3;
            break;
        case Subagente:
            myState= 4;
            break;
        default:
            myState= 5;
        }
        return myState;
    }
//    public boolean equalsName(String otherName) {
//        // (otherName == null) check is not needed because name.equals(null) returns false 
//        return name.equals(otherName);
//    }

//    public String toString() {
//       return this.name;
//    }
}
