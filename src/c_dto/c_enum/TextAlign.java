package c_dto.c_enum;

//public class Stato {
//	public static final int Attivo=1;
//	public static final int Archiviato=2;
//}

public enum TextAlign {
//	Aggiunge (1, "Aggiunge prodotti al magazzino selezionato"),
//	Sottrae (2,"Sottrae prodotti al magazzino selezionato"),
//	Invariato (3, "Il magazzino rimane invariato");
	LEFT(1),
	CENTER(2),
	RIGHT(3);

    private final int value;       
//    private final String text;       

    private TextAlign(int s/*, String t*/) {
    	value = s;
//    	text=t;
    }
    
    public static TextAlign fromValue(int x) {
    	TextAlign myState;
        switch(x) {
        case 1:
            myState= LEFT;
            break;
        case 2:
            myState= CENTER;
            break;
        default:
            myState= RIGHT;
            break;
//        case 4:
//            myState= Subagente;
//            break;
//        default:
//            myState= Segnalatore;
        }
        return myState;
    }
    
    public static int fromName(TextAlign x) {
    	int myState;
        switch(x) {
        case LEFT:
            myState= 1;
            break;
        case CENTER:
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
    
    
    
//    public String getFullText() {
//        return text;
//    }
    
//    @Override
//    public String toString() {
//    	// TODO Auto-generated method stub
//    	return getFullText();
//    }
    
//    public boolean equalsName(String otherName) {
//        // (otherName == null) check is not needed because name.equals(null) returns false 
//        return name.equals(otherName);
//    }

//    public String toString() {
//       return this.name;
//    }
}
