package c_dto.c_enum;

//public class Stato {
//	public static final int Attivo=1;
//	public static final int Archiviato=2;
//}

public enum Stato {
	Attivo (1),
	Archiviato (2);

    private final int value;       

    private Stato(int s) {
    	value = s;
    }
    
    public static Stato fromValue(int x) {
    	Stato myState;
        switch(x) {
        case 1:
            myState= Attivo;
            break;
        default:
            myState= Archiviato;
        }
        return myState;
    }
    
    public static int fromName(Stato x) {
    	int myState;
        switch(x) {
        case Attivo:
            myState= 1;
            break;
        default:
            myState= 2;
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
