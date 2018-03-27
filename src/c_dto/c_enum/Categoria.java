package c_dto.c_enum;

//public class Stato {
//	public static final int Attivo=1;
//	public static final int Archiviato=2;
//}

public enum Categoria {
	Fatture (1),
	Offerte (2),
	Ordini (3),
	DettagliOrdine (4);

    private final int value;       

    private Categoria(int s) {
    	value = s;
    }
    
    public static Categoria fromValue(int x) {
    	Categoria myState;
        switch(x) {
        case 1:
            myState= Fatture;
            break;
        case 2:
            myState= Offerte;
            break;
        case 3:
            myState= Ordini;
            break;
        default:
            myState= DettagliOrdine;
        }
        return myState;
    }
    
    public static int fromName(Categoria x) {
    	int myState;
        switch(x) {
        case Fatture:
            myState= 1;
            break;
        case Offerte:
            myState= 2;
            break;
        case Ordini:
            myState= 3;
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
