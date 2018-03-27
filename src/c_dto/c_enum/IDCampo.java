package c_dto.c_enum;

//public class Stato {
//	public static final int Attivo=1;
//	public static final int Archiviato=2;
//}

public enum IDCampo {
	TIPO(1,"Tipo"),
	NUMERO (2, "Numero"),
	DATA (3,"Data"),
	PAGINA(4,"Pagina"),
	PAGAMENTO(5,"Pagamento"),
	TRASPORTO(6,"Trasporto"),
	RIFERIMENTO(7,"Riferimento"),
	CLIENTE(8,"Cliente"),
	FORNITORE(9,"Fornitore"),
	PROGRESSIVO(10,"Progressivo"),
	DESCRIZIONE(11,"Descrizione"),
	QUANTITA(12,"Quantità"),
	PREZZO(13,"Prezzo"),
	SCONTO(14,"Sconto"),
	TOTRIGA(15,"Totale riga"),
	TOTMERCE(16,"Totale Merce"),
	IMPONIBILE(17,"Imponibile"),
	TOTSCONTO(18,"Totale sconto"),
	IVA(19,"Iva"),
	TOTIVA(20,"Totale Iva"),
	TOTALE(21,"Totale documento"),
	
	
	TEMPI(22,"Tempi di consegna"),
	DATACONSEGNAR(23,"Consegna richiesta"),
	DATACONSEGNAP(24,"Consegna prevista");

    private final int value;       
    private final String text;       

    private IDCampo(int s, String t) {
    	value = s;
    	text=t;
    }
    
    public static IDCampo fromValue(int x) {
    	IDCampo myState = null;
        switch(x) {
        case 1:
            myState= TIPO;
            break;
        case 2:
            myState= NUMERO;
            break;
        case 3:
            myState= DATA;
            break;
        case 4:
            myState= PAGINA;
            break;
        case 5:
            myState= PAGAMENTO;
            break;
        case 6:
            myState= TRASPORTO;
            break;
        case 7:
            myState= RIFERIMENTO;
            break;
        case 8:
            myState= CLIENTE;
            break;
        case 9:
            myState= FORNITORE;
            break;
        case 10:
            myState= PROGRESSIVO;
            break;
        case 11:
            myState= DESCRIZIONE;
            break;
        case 12:
            myState= QUANTITA;
            break;
        case 13:
            myState= PREZZO;
            break;
        case 14:
            myState= SCONTO;
            break;
        case 15:
            myState= TOTRIGA;
            break;
        case 16:
            myState= TOTMERCE;
            break;
        case 17:
            myState= IMPONIBILE;
            break;
        case 18:
            myState= TOTSCONTO;
            break;
        case 19:
            myState= IVA;
            break;
        case 20:
            myState= TOTIVA;
            break;
        case 21:
            myState= TOTALE;
            break;
        case 22:
            myState= TEMPI;
            break;
        case 23:
            myState= DATACONSEGNAR;
            break;
        case 24:
            myState= DATACONSEGNAP;
            break;
//        case 4:
//            myState= Subagente;
//            break;
//        default:
//            myState= Segnalatore;
        }
        return myState;
    }
    
    public static int fromName(IDCampo x) {
    	int myState = 0;
        switch(x) {
        case TIPO:
            myState= 1;
            break;
        case NUMERO:
            myState= 2;
            break;
        case DATA:
            myState= 3;
            break;
        case PAGINA:
            myState= 4;
            break;
        case PAGAMENTO:
            myState= 5;
            break;
        case TRASPORTO:
            myState= 6;
            break;
        case RIFERIMENTO:
            myState= 7;
            break;
        case CLIENTE:
            myState= 8;
            break;
        case FORNITORE:
            myState= 9;
            break;
        case PROGRESSIVO:
            myState= 10;
            break;
        case DESCRIZIONE:
            myState= 11;
            break;
        case QUANTITA:
            myState= 12;
            break;
        case PREZZO:
            myState= 13;
            break;
        case SCONTO:
            myState= 14;
            break;
        case TOTRIGA:
            myState= 15;
            break;
        case TOTMERCE:
            myState= 16;
            break;
        case IMPONIBILE:
            myState= 17;
            break;
        case TOTSCONTO:
            myState= 18;
            break;
        case IVA:
            myState= 19;
            break;
        case TOTIVA:
            myState= 20;
            break;
        case TOTALE:  
            myState= 21;
            break;
        case TEMPI:  
            myState= 22;
            break;
        case DATACONSEGNAR:  
            myState= 23;
            break;
        case DATACONSEGNAP:  
            myState= 24;
            break;
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
