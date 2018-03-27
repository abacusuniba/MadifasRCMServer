package c_dto.c_enum;

//public class Stato {
//	public static final int Attivo=1;
//	public static final int Archiviato=2;
//}

public enum Colonna {
//	Codice (1, "Codice prodotto"),
	Sigla (1,"Sigla prodotto"),
	Quantita (2, "Quantità"),
	Prezzo (3, "Prezzo"),
	Tempi(4, "Tempi di consegna"),
	ConsegnaRich(5, "Consegna richiesta"),
	ConsegnaPrev(6, "Consegna prevista");

    private final int value;       
    private final String text;       

    private Colonna(int s, String t) {
    	value = s;
    	text=t;
    }
    
    public static Colonna fromValue(int x) {
    	Colonna myState;
        switch(x) {
//        case 1:
//            myState= Codice;
//            break;
        case 1:
            myState= Sigla;
            break;
        case 2:
            myState= Quantita;
            break;
        case 3:
            myState= Prezzo;
            break;
        case 4:
            myState= Tempi;
            break;
        case 5:
            myState= ConsegnaRich;
            break;
        default:
            myState= ConsegnaPrev;
            break;
//        case 4:
//            myState= Subagente;
//            break;
//        default:
//            myState= Segnalatore;
        }
        return myState;
    }
    
    public static int fromName(Colonna x) {
    	int myState;
        switch(x) {
//        case Codice:
//            myState= 1;
//            break;
        case Sigla:
            myState= 1;
            break;
        case Quantita:
            myState= 2;
            break;
        case Prezzo:
            myState= 3;
            break;
        case Tempi:
            myState= 4;
            break;
        case ConsegnaRich:
            myState= 5;
            break;
        default:
            myState= 6;
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
