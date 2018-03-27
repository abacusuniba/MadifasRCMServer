package c_dto.c_enum;

//public class Stato {
//	public static final int Attivo=1;
//	public static final int Archiviato=2;
//}

public enum TipoUtente {
	Administrator (1),
	Manager (2),
	Employee (3);

    private final int value;       

    private TipoUtente(int s) {
    	value = s;
    }
    
    public static TipoUtente fromValue(int x) {
    	TipoUtente myState;
        switch(x) {
        case 1:
            myState= Administrator;
            break;
        case 2:
            myState= Manager;
            break;
        default:
            myState= Employee;
        }
        return myState;
    }
    
    public static int fromName(TipoUtente x) {
    	int myState;
        switch(x) {
        case Administrator:
            myState= 1;
            break;
        case Manager:
            myState= 2;
            break;
        default:
            myState= 3;
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
