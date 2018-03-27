package b_tiers.b_business.b_services;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
//import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import b_tiers.b_business.c_businessobject.b_real.BOAltro;
import b_tiers.b_business.c_businessobject.b_real.BOCap;
import b_tiers.b_business.c_businessobject.b_real.BOCapCitta;
import b_tiers.b_business.c_businessobject.b_real.BOCategoria;
import b_tiers.b_business.c_businessobject.b_real.BOCausaleTrasporto;
import b_tiers.b_business.c_businessobject.b_real.BOCitta;
import b_tiers.b_business.c_businessobject.b_real.BOCivico;
import b_tiers.b_business.c_businessobject.b_real.BOCliente;
import b_tiers.b_business.c_businessobject.b_real.BOConsorzio;
import b_tiers.b_business.c_businessobject.b_real.BODocumento;
import b_tiers.b_business.c_businessobject.b_real.BOForma;
import b_tiers.b_business.c_businessobject.b_real.BOFornitore;
//import b_tiers.b_business.c_businessobject.b_real.BOGruppoAzienda;
import b_tiers.b_business.c_businessobject.b_real.BOGruppoProdotto;
import b_tiers.b_business.c_businessobject.b_real.BOGruppoSocietario;
import b_tiers.b_business.c_businessobject.b_real.BOIndirizzo;
import b_tiers.b_business.c_businessobject.b_real.BOIva;
import b_tiers.b_business.c_businessobject.b_real.BOLayout;
import b_tiers.b_business.c_businessobject.b_real.BOLingua;
import b_tiers.b_business.c_businessobject.b_real.BOMagazzino;
import b_tiers.b_business.c_businessobject.b_real.BOMinimo;
import b_tiers.b_business.c_businessobject.b_real.BOMovimentazione;
import b_tiers.b_business.c_businessobject.b_real.BONazione;
import b_tiers.b_business.c_businessobject.b_real.BOPagamento;
import b_tiers.b_business.c_businessobject.b_real.BOParametro;
import b_tiers.b_business.c_businessobject.b_real.BOPercentualeCollaboratore;
import b_tiers.b_business.c_businessobject.b_real.BOPercentualeFornitore;
import b_tiers.b_business.c_businessobject.b_real.BOProdotto;
import b_tiers.b_business.c_businessobject.b_real.BOProvincia;
import b_tiers.b_business.c_businessobject.b_real.BORegione;
import b_tiers.b_business.c_businessobject.b_real.BORiferimento;
import b_tiers.b_business.c_businessobject.b_real.BORuolo;
import b_tiers.b_business.c_businessobject.b_real.BOSegnalatore;
import b_tiers.b_business.c_businessobject.b_real.BOServer;
import b_tiers.b_business.c_businessobject.b_real.BOSettore;
import b_tiers.b_business.c_businessobject.b_real.BOSottoGruppoProdotto;
import b_tiers.b_business.c_businessobject.b_real.BOStrada;
import b_tiers.b_business.c_businessobject.b_real.BOSubAgente;
import b_tiers.b_business.c_businessobject.b_real.BOTempoConsegna;
import b_tiers.b_business.c_businessobject.b_real.BOTipoDocumento;
import b_tiers.b_business.c_businessobject.b_real.BOTitolo;
import b_tiers.b_business.c_businessobject.b_real.BOTrasporto;
import b_tiers.b_business.c_businessobject.b_real.BOUM;
import b_tiers.b_business.c_businessobject.b_real.BOUtente;
import b_tiers.b_business.c_businessobject.b_real.BOValidita;
import c_dto.a_abstract.Azienda;
import c_dto.a_abstract.DTOBase;
import c_dto.b_real.Altro;
import c_dto.b_real.CAP;
import c_dto.b_real.CAPCitta;
import c_dto.b_real.Categoria;
import c_dto.b_real.CausaleTrasporto;
import c_dto.b_real.Citta;
//import c_dto.b_real.Civico;
import c_dto.b_real.Cliente;
import c_dto.b_real.Consorzio;
import c_dto.b_real.Documento;
import c_dto.b_real.DocumentoSub;
import c_dto.b_real.FormaGiuridica;
import c_dto.b_real.Fornitore;
import c_dto.b_real.GruppoAziende;
import c_dto.b_real.GruppoProdotto;
import c_dto.b_real.GruppoSocietario;
//import c_dto.b_real.Indirizzo;
import c_dto.b_real.Iva;
import c_dto.b_real.Layout;
import c_dto.b_real.Lingua;
import c_dto.b_real.Magazzino;
import c_dto.b_real.Minimo;
//import c_dto.b_real.Movimentazione;
import c_dto.b_real.Nazione;
import c_dto.b_real.Pagamento;
import c_dto.b_real.Parametro;
import c_dto.b_real.PercentualeCollaboratore;
import c_dto.b_real.PercentualeFornitore;
import c_dto.b_real.Prodotto;
import c_dto.b_real.Provincia;
import c_dto.b_real.Regione;
import c_dto.b_real.Riferimento;
import c_dto.b_real.Ruolo;
import c_dto.b_real.Segnalatore;
import c_dto.b_real.Server;
import c_dto.b_real.Settore;
import c_dto.b_real.SottoGruppoProdotto;
import c_dto.b_real.Strada;
import c_dto.b_real.SubAgente;
import c_dto.b_real.TempoConsegna;
import c_dto.b_real.TipoDocumento;
import c_dto.b_real.Titolo;
import c_dto.b_real.Trasporto;
import c_dto.b_real.UM;
import c_dto.b_real.Utente;
import c_dto.b_real.Validita;

public class ASUtente extends AppServiceBase{
	private BOUtente boUtente;
	
	
//	private BONazione boNazione;
//	private BORegione boRegione;
//	private BOProvincia boProvincia;
//	private BOCitta boCitta;
//	private BOCap boCap;
//	private BOCapCitta boCapCitta;
//	private BOStrada boStrada;
//	private BOCivico boCivico;
//	private BOIndirizzo boIndirizzo;
//	private BOForma boForma;
//	private BOGruppoAzienda boGruppoAzienda;
//	private BOConsorzio boConsorzio;
//	private BOMinimo boMinimo;
//	private BOTrasporto boTrasporto;
//	private BOPagamento boPagamento;
//	private BOSettore boSettore;
//	private BOCliente boCliente;

	
	
	
	
	
	
	
	
	
	
	
	
	
//	private BOCategoria busObjCategoria;
	private BOServer busObjServer;
	private BOParametro busObjParametro;
	private BOCliente busObjCliente;
	private BOFornitore busObjFornitore;
	private BOSubAgente busObjSubAgente;
	private BOSegnalatore busObjSegnalatore;
	private BOAltro busObjAltro;
	private BOSettore busObjSettore;
//	private BOGruppoAzienda busObjGruppoSocietario;
	private BOGruppoSocietario busObjGruppoSocietario;
	private BOConsorzio busObjConsorzio;
	private BOPagamento busObjPagamento;
	private BOTrasporto busObjTrasporto;
	private BOMinimo busObjMinimo;
	private BOCap busObjCAP;
	private BOCitta busObjCitta;
	private BOProvincia busObjProvincia;
	private BORegione busObjRegione;
	private BONazione busObjNazione;
	private BOTempoConsegna busObjTempoConsegna;
	private BOProdotto busObjProdotto;
	private BOGruppoProdotto busObjGruppoProdotto;
	private BOSottoGruppoProdotto busObjSottoGruppoProdotto;
	private BOPercentualeFornitore busObjPercentualeFornitore;
	private BOUM busObjUM;


	private BOValidita busObjValidita;
	private BOMagazzino busObjMagazzino;
	private BOCausaleTrasporto busObjCausaleTrasporto;
	private BODocumento busObjDocumento;
	private BOTipoDocumento busObjTipoDocumento;
	private BOLayout busObjLayout;
	private BOCategoria busObjCategoria;
//	private BOMovimentazione busObjMovimentazione;
//	private BOTipoAzienda busObjTipoAzienda;
	private BOIva busObjIva;
	private BOPercentualeCollaboratore busObjPercentualeCollaboratore;
	private BOForma busObjFormaGiuridica;
	private BOTitolo busObjTitolo;
	private BORuolo busObjRuolo;
	private BOCapCitta busObjCapCitta;
	private BOStrada busObjStrada;
//	private BOCivico busObjCivico;
	
	
	
	private BOLingua busObjLingua;
	
	
//	private BORiferimento busObjRiferimento;
//	
////	public void start(){}
////	private BOUtente users;//nel business object ci metto l'hashmap per contenere i dati
//	private BOUtente users;
//	
//	
//	public ASUtente(){
////		startServerListener();
////		new MultiServer();
//	}
//	
//	public Utente login(Utente u){
//		users= new BOUtente();
//		
//		return users.findUser(u.getUsername(), u.getPassword());
//		
//	}
//	
	public ArrayList<DTOBase> elenco (Parametro n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjParametro.readAll();
		}
		catch (NullPointerException e){
			busObjParametro = new BOParametro();
			lista=busObjParametro.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elenco (Server n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjServer.readAll();
		}
		catch (NullPointerException e){
			busObjServer = new BOServer();
			lista=busObjServer.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencosub (Server n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
//		try{
			lista=busObjServer.readAll(n);
//		}
//		catch (NullPointerException e){
//			busObjServer = new BOServer();
//			lista=busObjServer.readAll();
//		}
		return lista;
	}
	public void aggiorna(Parametro c){
		
		
		// verifica sistema operativo del client
		
		
		
		busObjParametro.update(c);
	}
	
	public ASUtente() {
		boUtente = new BOUtente();
		
		
		busObjServer= new BOServer();
		
//		//inizializzazioni di prova
		busObjParametro = new BOParametro();
		
		busObjNazione = new BONazione();
		busObjTempoConsegna= new BOTempoConsegna();
		busObjRegione = new BORegione();
		busObjProvincia = new BOProvincia();
		busObjCitta = new BOCitta();
		busObjCAP = new BOCap();
		busObjCapCitta = new BOCapCitta();
		busObjStrada = new BOStrada();
//		busObjCivico = new BOCivico();
//		busObjIndirizzo = new BOIndirizzo();
		busObjMinimo = new BOMinimo();
		busObjTrasporto = new BOTrasporto();
		busObjPagamento = new BOPagamento();
		busObjSettore = new BOSettore();
		busObjFormaGiuridica = new BOForma();
		busObjGruppoSocietario = new BOGruppoSocietario();
//		busObjConsorzio = new BOConsorzio();
		busObjFornitore = new BOFornitore();
		busObjCliente = new BOCliente();
		busObjSubAgente = new BOSubAgente();
		busObjSegnalatore = new BOSegnalatore();
		busObjAltro = new BOAltro();
		busObjRuolo = new BORuolo();
		busObjTitolo = new BOTitolo();
////		busObjCategoria = new BOCategoria();
		busObjProdotto = new BOProdotto();
		busObjUM = new BOUM();
		
		busObjGruppoProdotto = new BOGruppoProdotto();
		busObjSottoGruppoProdotto = new BOSottoGruppoProdotto();
		
		busObjMagazzino = new BOMagazzino();
		busObjPercentualeFornitore = new BOPercentualeFornitore();
		busObjValidita = new BOValidita();
		busObjConsorzio = new BOConsorzio();
//		busObjSettore = new BOSettore();
		busObjCausaleTrasporto = new BOCausaleTrasporto();
		
		busObjCategoria = new BOCategoria();
		busObjDocumento = new BODocumento((Parametro) busObjParametro.readAll().get(0));
		busObjTipoDocumento = new BOTipoDocumento();
//		busObjMovimentazione = new BOMovimentazione();
		busObjPercentualeCollaboratore = new BOPercentualeCollaboratore();
		busObjIva = new BOIva();
		busObjLingua= new BOLingua();
		busObjLayout = new BOLayout();
//		busObjRiferimento= new BORiferimento();
	}
	
	
	public Utente login(Utente u){
		
		boUtente.findUser(u);
		
		return u;
		
	}
	
//	private void _________________________________inizio_titolo(){}	
//	public ArrayList<DTOBase> elenco (Titolo n){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		try{
//			lista=busObjTitolo.readAll();
//		}
//		catch (NullPointerException e){
//			busObjTitolo = new BOTitolo();
//			lista=busObjTitolo.readAll();
//		}
//		return lista;
//	}
//	private void _________________________________fine_titolo(){}	
//	public void leggi(Parametro n){
//		busObjParametro.read(null);
//	}
//	private void _________________________________inizio_Indirizzo(){}	
//	public void crea(Indirizzo c){
//		//c.setStato(Attivo.getInstance());
//		busObjIndirizzo.create(c);
//	}
//	public void leggi(Indirizzo n){
//		busObjIndirizzo.read(n);
//	}
//	public ArrayList<DTOBase> elenco (Indirizzo n){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		try{
//			lista=busObjIndirizzo.readAll();
//		}
//		catch (NullPointerException e){
//			busObjIndirizzo = new BOIndirizzo();
//			lista=busObjIndirizzo.readAll();
//		}
//		return lista;
//	}
//	@Deprecated
//	public ArrayList<DTOBase> elencocancellati (Indirizzo n){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		try{
//			lista=busObjIndirizzo.readDeleted();
//		}
//		catch (NullPointerException e){
//			busObjIndirizzo = new BOIndirizzo();
//			lista=busObjIndirizzo.readDeleted();
//		}
//		return lista;
//	}
//	public void cancella(Indirizzo c){
//		busObjIndirizzo.delete(c);
//	}
//	public void aggiorna(Indirizzo c){
//		busObjIndirizzo.update(c);
//		
//		
////		for (DTOBase d :busObjCliente.readAll()) {
////			Cliente cl = (Cliente) d;
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
////			
////			for (Riferimento r : cl.getRiferimenti()) {
////				x=r.getIndirizzi().indexOf(c);
////				r.getIndirizzi().set(x, c);
////			}
////		}
////		for (DTOBase d :busObjFornitore.readAll()) {
////			Fornitore cl = (Fornitore) d;
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
////			
////			for (Riferimento r : cl.getRiferimenti()) {
////				x=r.getIndirizzi().indexOf(c);
////				r.getIndirizzi().set(x, c);
////			}
////		}
////		for (DTOBase d :busObjSegnalatore.readAll()) {
////			Segnalatore cl = (Segnalatore) d;
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
////			
////			for (Riferimento r : cl.getRiferimenti()) {
////				x=r.getIndirizzi().indexOf(c);
////				r.getIndirizzi().set(x, c);
////			}
////		}
////		for (DTOBase d :busObjSubAgente.readAll()) {
////			SubAgente cl = (SubAgente) d;
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
////			
////			for (Riferimento r : cl.getRiferimenti()) {
////				x=r.getIndirizzi().indexOf(c);
////				r.getIndirizzi().set(x, c);
////			}
////		}
////		for (DTOBase d :busObjAltro.readAll()) {
////			Altro cl = (Altro) d;
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
////			
////			for (Riferimento r : cl.getRiferimenti()) {
////				x=r.getIndirizzi().indexOf(c);
////				r.getIndirizzi().set(x, c);
////			}
////		}
////		
//		
//		
//		
//		
//	}
//	public ArrayList<DTOBase> filtra (Indirizzo n){
//		ArrayList<DTOBase> lista=busObjIndirizzo.readAll();
//		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
//		
//		
//		for (int i =0; i< lista.size(); i++){
//			Indirizzo elem = (Indirizzo) lista.get(i);
//			
//			if (elem.contains(n)){
//				listaFiltrata.add(elem);
//			}
//			
//		}
//		
//		return listaFiltrata;
//	}
//	private void _________________________________fine_Indirizzo(){}	
//	private void _________________________________inizio_Civico(){}	
//	public void crea(Civico c){
//		//c.setStato(Attivo.getInstance());
//		busObjCivico.create(c);
//	}
//	public void leggi(Civico n){
//		busObjCivico.read(n);
//	}
//	public ArrayList<DTOBase> elenco (Civico n){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		try{
//			lista=busObjCivico.readAll();
//		}
//		catch (NullPointerException e){
//			busObjCivico = new BOCivico();
//			lista=busObjCivico.readAll();
//		}
//		return lista;
//	}
//	@Deprecated
//	public ArrayList<DTOBase> elencocancellati (Civico n){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		try{
//			lista=busObjCivico.readDeleted();
//		}
//		catch (NullPointerException e){
//			busObjCivico = new BOCivico();
//			lista=busObjCivico.readDeleted();
//		}
//		return lista;
//	}
//	public void cancella(Civico c){
//		busObjCivico.delete(c);
//	}
//	public void aggiorna(Civico c){
//		busObjCivico.update(c);
//	}
//	public ArrayList<DTOBase> filtra (Civico n){
//		ArrayList<DTOBase> lista=busObjCivico.readAll();
//		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
//		
//		
//		for (int i =0; i< lista.size(); i++){
//			Civico elem = (Civico) lista.get(i);
//			
//			if (elem.contains(n)){
//				listaFiltrata.add(elem);
//			}
//			
//		}
//		
//		return listaFiltrata;
//	}
//	private void _________________________________fine_Civico(){}	
	private void _________________________________inizio_CAPCitta(){}	
	public void crea(CAPCitta c){
		//c.setStato(Attivo.getInstance());
		busObjCapCitta.create(c);
	}
	public void leggi(CAPCitta n){
		busObjCapCitta.read(n);
	}
	public ArrayList<DTOBase> elenco (CAPCitta n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCapCitta.readAll();
		}
		catch (NullPointerException e){
			busObjCapCitta = new BOCapCitta();
			lista=busObjCapCitta.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (CAPCitta n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCapCitta.readDeleted();
		}
		catch (NullPointerException e){
			busObjCapCitta = new BOCapCitta();
			lista=busObjCapCitta.readDeleted();
		}
		return lista;
	}
	public void cancella(CAPCitta c){
		busObjCapCitta.delete(c);
	}
	public void aggiorna(CAPCitta c){
		busObjCapCitta.update(c);
	}
	public ArrayList<DTOBase> filtra (CAPCitta n){
		ArrayList<DTOBase> lista=busObjCapCitta.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			CAPCitta elem = (CAPCitta) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_CAPCitta(){}	
	private void _________________________________inizio_Strada(){}	
	public void crea(Strada c){
		//c.setStato(Attivo.getInstance());
		busObjStrada.create(c);
	}
	public void leggi(Strada n){
		busObjStrada.read(n);
	}
	public ArrayList<DTOBase> elenco (Strada n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjStrada.readAll();
		}
		catch (NullPointerException e){
			busObjStrada = new BOStrada();
			lista=busObjStrada.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (Strada n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjStrada.readDeleted();
		}
		catch (NullPointerException e){
			busObjStrada = new BOStrada();
			lista=busObjStrada.readDeleted();
		}
		return lista;
	}
	public void cancella(Strada c){
		busObjStrada.delete(c);
	}
	public void aggiorna(Strada c){
		busObjStrada.update(c);
		
		
//		for (DTOBase dto : busObjIndirizzo.readAll()) {
//			Indirizzo item = (Indirizzo) dto;
//			if (item.getStrada().equals(c)) {
//				item.setStrada(c);
//				System.out.print("");
////				busObjIndirizzo.update(item);
////				busObjIndirizzo.reload(item);
//			}
//		}
		
		
		
//		for (DTOBase dto: busObjFornitore.readAll()) {
//			Fornitore item = (Fornitore) dto;
//			boolean found=false;
//			
//			Iterator<Indirizzo> iter = item.getIndirizzi().iterator();
//			while (iter.hasNext() && ! found) {
//				if (iter.next().getStrada().equals(c)) {
//					found=true;
//					busObjFornitore.reload(item);
//					System.out.print("");
//				}
//			}
//			
////			if ((index=item.getIndirizzi().indexOf(c))>=0) {
////				busObjFornitore.reload(item);
//////				item.getIndirizzi().set(index, c);
////			}
//			
//		}
//		for (DTOBase dto: busObjCliente.readAll()) {
//			Cliente item = (Cliente) dto;
//			boolean found=false;
//			
//			Iterator<Indirizzo> iter = item.getIndirizzi().iterator();
//			while (iter.hasNext() && ! found) {
//				if (iter.next().getStrada().equals(c)) {
//					found=true;
//					busObjCliente.reload(item);
//					System.out.print("");
//				}
//			}
//			
////			if ((index=item.getIndirizzi().indexOf(c))>=0) {
////				busObjFornitore.reload(item);
//////				item.getIndirizzi().set(index, c);
////			}
//			
//		}
//		for (DTOBase dto: busObjSegnalatore.readAll()) {
//			Segnalatore item = (Segnalatore) dto;
//			boolean found=false;
//			
//			Iterator<Indirizzo> iter = item.getIndirizzi().iterator();
//			while (iter.hasNext() && ! found) {
//				if (iter.next().getStrada().equals(c)) {
//					found=true;
//					busObjSegnalatore.reload(item);
//					System.out.print("");
//				}
//			}
//			
////			if ((index=item.getIndirizzi().indexOf(c))>=0) {
////				busObjFornitore.reload(item);
//////				item.getIndirizzi().set(index, c);
////			}
//			
//		}
//		
//		for (DTOBase dto: busObjSubAgente.readAll()) {
//			SubAgente item = (SubAgente) dto;
//			boolean found=false;
//			
//			Iterator<Indirizzo> iter = item.getIndirizzi().iterator();
//			while (iter.hasNext() && ! found) {
//				if (iter.next().getStrada().equals(c)) {
//					found=true;
//					busObjSubAgente.reload(item);
//					System.out.print("");
//				}
//			}
//			
////			if ((index=item.getIndirizzi().indexOf(c))>=0) {
////				busObjFornitore.reload(item);
//////				item.getIndirizzi().set(index, c);
////			}
//			
//		}
//		for (DTOBase dto: busObjAltro.readAll()) {
//			Altro item = (Altro) dto;
//			boolean found=false;
//			
//			Iterator<Indirizzo> iter = item.getIndirizzi().iterator();
//			while (iter.hasNext() && ! found) {
//				if (iter.next().getStrada().equals(c)) {
//					found=true;
//					busObjAltro.reload(item);
//					System.out.print("");
//				}
//			}
//			
////			if ((index=item.getIndirizzi().indexOf(c))>=0) {
////				busObjFornitore.reload(item);
//////				item.getIndirizzi().set(index, c);
////			}
//			
//		}
		
		
//		busObjCliente.updateSubItem(c);
//		busObjFornitore.updateSubItem(c);
//		busObjSegnalatore.updateSubItem(c);
//		busObjSubAgente.updateSubItem(c);
//		busObjAltro.updateSubItem(c);
		
//		for (DTOBase cl : busObjIndirizzo.readAll()) {
//			Indirizzo x =(Indirizzo) cl;
//			if (x.getStrada().equals(c)) {
//				x.setStrada(c);
////				busObjIndirizzo.reload(x);
//			}
//		}
		
//		for (DTOBase d :busObjCliente.readAll()) {
//		Cliente cl = (Cliente) d;
//		for (Indirizzo ind : cl.getIndirizzi()) {
//			if (ind.getStrada().equals(c))
//				busObjCliente.reload(ind);
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
//		}
//	}
//	for (DTOBase d :busObjFornitore.readAll()) {
//		Fornitore cl = (Fornitore) d;
//		for (Indirizzo ind : cl.getIndirizzi()) {
//			if (ind.getStrada().equals(c))
//				ind.setStrada(c);
////				busObjFornitore.reload(ind);
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
//		}
//	}
//	for (DTOBase d :busObjSegnalatore.readAll()) {
//		Segnalatore cl = (Segnalatore) d;
//		for (Indirizzo ind : cl.getIndirizzi()) {
//			if (ind.getStrada().equals(c))
//				busObjSegnalatore.reload(ind);
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
//		}
//	}
//	for (DTOBase d :busObjSubAgente.readAll()) {
//		SubAgente cl = (SubAgente) d;
//		for (Indirizzo ind : cl.getIndirizzi()) {
//			if (ind.getStrada().equals(c))
//				busObjSubAgente.reload(ind);
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
//		}
//	}
//	for (DTOBase d :busObjAltro.readAll()) {
//		Altro cl = (Altro) d;
//		for (Indirizzo ind : cl.getIndirizzi()) {
//			if (ind.getStrada().equals(c))
//				busObjAltro.reload(ind);
////			int x =cl.getIndirizzi().indexOf(c);
////			cl.getIndirizzi().set(x, c);
//		}
//	}
		
	}
	public ArrayList<DTOBase> filtra (Strada n){
		ArrayList<DTOBase> lista=busObjStrada.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Strada elem = (Strada) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Strada(){}	
	private void _________________________________inizio_Lingua(){}	
	public void crea(Lingua c){
		//c.setStato(Attivo.getInstance());
		busObjLingua.create(c);
	}
	public void leggi(Lingua n){
		busObjLingua.read(n);
	}
	public ArrayList<DTOBase> elenco (Lingua n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjLingua.readAll();
		}
		catch (NullPointerException e){
			busObjLingua = new BOLingua();
			lista=busObjLingua.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (Lingua n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjLingua.readDeleted();
		}
		catch (NullPointerException e){
			busObjLingua = new BOLingua();
			lista=busObjLingua.readDeleted();
		}
		return lista;
	}
	public void cancella(Lingua c){
		busObjLingua.delete(c);
	}
	public void aggiorna(Lingua c){
		busObjLingua.update(c);
	}
	public ArrayList<DTOBase> filtra (Lingua n){
		ArrayList<DTOBase> lista=busObjLingua.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Lingua elem = (Lingua) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Lingua(){}	
	private void _________________________________inizio_nazione(){}	
	public void crea(Nazione c){
		//c.setStato(Attivo.getInstance());
		busObjNazione.create(c);
	}
	public void leggi(Nazione n){
		busObjNazione.read(n);
	}
	public ArrayList<DTOBase> elenco (Nazione n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjNazione.readAll();
		}
		catch (NullPointerException e){
			busObjNazione = new BONazione();
			lista=busObjNazione.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (Nazione n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjNazione.readDeleted();
		}
		catch (NullPointerException e){
			busObjNazione = new BONazione();
			lista=busObjNazione.readDeleted();
		}
		return lista;
	}
	public void cancella(Nazione c){
		busObjNazione.delete(c);
	}
	public void aggiorna(Nazione c){
		busObjNazione.update(c);
	}
	public ArrayList<DTOBase> filtra (Nazione n){
		ArrayList<DTOBase> lista=busObjNazione.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Nazione elem = (Nazione) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_nazione(){}	
	private void _________________________________inizio_TempoConsegna(){}	
	public void crea(TempoConsegna c){
		//c.setStato(Attivo.getInstance());
		busObjTempoConsegna.create(c);
	}
	public void leggi(TempoConsegna n){
		busObjTempoConsegna.read(n);
	}
	public ArrayList<DTOBase> elenco (TempoConsegna n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjTempoConsegna.readAll();
		}
		catch (NullPointerException e){
			busObjTempoConsegna = new BOTempoConsegna();
			lista=busObjTempoConsegna.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (TempoConsegna n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjTempoConsegna.readDeleted();
		}
		catch (NullPointerException e){
			busObjTempoConsegna = new BOTempoConsegna();
			lista=busObjTempoConsegna.readDeleted();
		}
		return lista;
	}
	public void cancella(TempoConsegna c){
		busObjTempoConsegna.delete(c);
	}
	public void aggiorna(TempoConsegna c){
		busObjTempoConsegna.update(c);
	}
	public ArrayList<DTOBase> filtra (TempoConsegna n){
		ArrayList<DTOBase> lista=busObjTempoConsegna.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			TempoConsegna elem = (TempoConsegna) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_TempoConsegna(){}	
	private void _________________________________inizio_regione(){}	
	public void crea(Regione c){
		//c.setStato(Attivo.getInstance());
		busObjRegione.create(c);
	}
	public void leggi(Regione n){
		busObjRegione.read(n);
//		System.out.println(n.toString());
	}
	public ArrayList<DTOBase> elenco (Regione n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjRegione.readAll();
		}
		catch (NullPointerException e){
			busObjRegione = new BORegione();
			lista=busObjRegione.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (Regione n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjRegione.readDeleted();
		}
		catch (NullPointerException e){
			busObjRegione = new BORegione();
			lista=busObjRegione.readDeleted();
		}
		return lista;
	}
	public void cancella(Regione c){
		busObjRegione.delete(c);
	}
	public void aggiorna(Regione c){
		busObjRegione.update(c);
	}
	public ArrayList<DTOBase> filtra (Regione n){
		ArrayList<DTOBase> lista=busObjRegione.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Regione elem = (Regione) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_regione(){}	
	private void _________________________________inizio_provincia(){}	
	public void crea(Provincia c){
		//c.setStato(Attivo.getInstance());
		busObjProvincia.create(c);
	}
	public void leggi(Provincia n){
		busObjProvincia.read(n);
	}
	public ArrayList<DTOBase> elenco (Provincia n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjProvincia.readAll();
		}
		catch (NullPointerException e){
			busObjProvincia = new BOProvincia();
			lista=busObjProvincia.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (Provincia n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjProvincia.readDeleted();
		}
		catch (NullPointerException e){
			busObjProvincia = new BOProvincia();
			lista=busObjProvincia.readDeleted();
		}
		return lista;
	}
	public void cancella(Provincia c){
		busObjProvincia.delete(c);
	}
	public void aggiorna(Provincia c){
		busObjProvincia.update(c);
	}
	public ArrayList<DTOBase> filtra (Provincia n){
		ArrayList<DTOBase> lista=busObjProvincia.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Provincia elem = (Provincia) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_provincia(){}	
	private void _________________________________inizio_citta(){}	
	public void crea(Citta c){
		//c.setStato(Attivo.getInstance());
		busObjCitta.create(c);
	}
	public void leggi(Citta n){
		busObjCitta.read(n);
	}
	public ArrayList<DTOBase> elenco (Citta n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCitta.readAll();
		}
		catch (NullPointerException e){
			busObjCitta = new BOCitta();
			lista=busObjCitta.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (Citta n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCitta.readDeleted();
		}
		catch (NullPointerException e){
			busObjCitta = new BOCitta();
			lista=busObjCitta.readDeleted();
		}
		return lista;
	}
	public void cancella(Citta c){
		busObjCitta.delete(c);
	}
	public void aggiorna(Citta c){
		busObjCitta.update(c);
	}
	public ArrayList<DTOBase> filtra (Citta n){
		ArrayList<DTOBase> lista=busObjCitta.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Citta elem = (Citta) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_citta(){}	
	private void _________________________________inizio_CAP(){}	
	public void crea(CAP c){
		//c.setStato(Attivo.getInstance());
		busObjCAP.create(c);
	}
	public void leggi(CAP n){
		busObjCAP.read(n);
	}
	public ArrayList<DTOBase> elenco (CAP n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCAP.readAll();
		}
		catch (NullPointerException e){
			busObjCAP = new BOCap();
			lista=busObjCAP.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (CAP n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCAP.readDeleted();
		}
		catch (NullPointerException e){
			busObjCAP = new BOCap();
			lista=busObjCAP.readDeleted();
		}
		return lista;
	}
	public void cancella(CAP c){
		busObjCAP.delete(c);
	}
	public void aggiorna(CAP c){
		busObjCAP.update(c);
	}
	public ArrayList<DTOBase> filtra (CAP n){
		ArrayList<DTOBase> lista=busObjCAP.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			CAP elem = (CAP) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_CAP(){}	
	private void _________________________________inizio_forma(){}	
	public void crea(FormaGiuridica c){
		//c.setStato(Attivo.getInstance());
		busObjFormaGiuridica.create(c);
	}
	public void leggi(FormaGiuridica n){
		busObjFormaGiuridica.read(n);
	}
	public ArrayList<DTOBase> elenco (FormaGiuridica n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjFormaGiuridica.readAll();
		}
		catch (NullPointerException e){
			busObjFormaGiuridica = new BOForma();
			lista=busObjFormaGiuridica.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (FormaGiuridica n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjFormaGiuridica.readDeleted();
		}
		catch (NullPointerException e){
			busObjFormaGiuridica = new BOForma();
			lista=busObjFormaGiuridica.readDeleted();
		}
		return lista;
	}
	public void cancella(FormaGiuridica c){
		busObjFormaGiuridica.delete(c);
	}
	public void aggiorna(FormaGiuridica c){
		busObjFormaGiuridica.update(c);
	}
	public ArrayList<DTOBase> filtra (FormaGiuridica n){
		ArrayList<DTOBase> lista=busObjFormaGiuridica.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			FormaGiuridica elem = (FormaGiuridica) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_forma(){}	
	private void _________________________________inizio_altri(){}	
	public void crea(Altro c){
		//c.setStato(Attivo.getInstance());
		busObjAltro.create(c);
	}
	public void leggi(Altro n){
		busObjAltro.read(n);
	}
	public ArrayList<DTOBase> elenco (Altro n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjAltro.readAll();
		}
		catch (NullPointerException e){
			busObjAltro = new BOAltro();
			lista=busObjAltro.readAll();
		}
		return lista;
	}
	@Deprecated
	public ArrayList<DTOBase> elencocancellati (Altro n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjAltro.readDeleted();
		}
		catch (NullPointerException e){
			busObjAltro = new BOAltro();
			lista=busObjAltro.readDeleted();
		}
		return lista;
	}
	public void cancella(Altro c){
		busObjAltro.delete(c);
	}
	public void aggiorna(Altro c){
		busObjAltro.update(c);
	}
	public ArrayList<DTOBase> filtra (Altro n){
		ArrayList<DTOBase> lista=busObjAltro.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Altro elem = (Altro) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_altri(){}	
	private void _________________________________inizio_percentualeCollaboratore(){}	
	public void crea(PercentualeCollaboratore c){
		//c.setStato(Attivo.getInstance());
		busObjPercentualeCollaboratore.create(c);
	}
	public void leggi(PercentualeCollaboratore n){
		busObjPercentualeCollaboratore.read(n);
	}
	public ArrayList<DTOBase> elenco (PercentualeCollaboratore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjPercentualeCollaboratore.readAll();
		}
		catch (NullPointerException e){
			busObjPercentualeCollaboratore = new BOPercentualeCollaboratore();
			lista=busObjPercentualeCollaboratore.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (PercentualeCollaboratore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjPercentualeCollaboratore.readDeleted();
		}
		catch (NullPointerException e){
			busObjPercentualeCollaboratore = new BOPercentualeCollaboratore();
			lista=busObjPercentualeCollaboratore.readDeleted();
		}
		return lista;
	}
	public void cancella(PercentualeCollaboratore c){
		busObjPercentualeCollaboratore.delete(c);
	}
	public void aggiorna(PercentualeCollaboratore c){
		busObjPercentualeCollaboratore.update(c);
	}
	public ArrayList<DTOBase> filtra (PercentualeCollaboratore n){
		ArrayList<DTOBase> lista=busObjPercentualeCollaboratore.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			PercentualeCollaboratore elem = (PercentualeCollaboratore) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_percentualeCollaboratore(){}	
	private void _________________________________inizio_segnalatore(){}	
	public void crea(Segnalatore c){
		//c.setStato(Attivo.getInstance());
		busObjSegnalatore.create(c);
	}
	public void leggi(Segnalatore n){
		busObjSegnalatore.read(n);
	}
	public ArrayList<DTOBase> elenco (Segnalatore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjSegnalatore.readAll();
		}
		catch (NullPointerException e){
			busObjSegnalatore = new BOSegnalatore();
			lista=busObjSegnalatore.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Segnalatore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjSegnalatore.readDeleted();
		}
		catch (NullPointerException e){
			busObjSegnalatore = new BOSegnalatore();
			lista=busObjSegnalatore.readDeleted();
		}
		return lista;
	}
	public void cancella(Segnalatore c){
		busObjSegnalatore.delete(c);
	}
	public void aggiorna(Segnalatore c){
		busObjSegnalatore.update(c);
	}
	public ArrayList<DTOBase> filtra (Segnalatore n){
		ArrayList<DTOBase> lista=busObjSegnalatore.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Segnalatore elem = (Segnalatore) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_segnalatore(){}	
	private void _________________________________inizio_subagente(){}	
	public void crea(SubAgente c){
		//c.setStato(Attivo.getInstance());
		busObjSubAgente.create(c);
	}
	public void leggi(SubAgente n){
		busObjSubAgente.read(n);
	}
	public ArrayList<DTOBase> elenco (SubAgente n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjSubAgente.readAll();
		}
		catch (NullPointerException e){
			busObjSubAgente = new BOSubAgente();
			lista=busObjSubAgente.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (SubAgente n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjSubAgente.readDeleted();
		}
		catch (NullPointerException e){
			busObjSubAgente = new BOSubAgente();
			lista=busObjSubAgente.readDeleted();
		}
		return lista;
	}
	public void cancella(SubAgente c){
		busObjSubAgente.delete(c);
	}
	public void aggiorna(SubAgente c){
		busObjSubAgente.update(c);
	}
	public ArrayList<DTOBase> filtra (SubAgente n){
		ArrayList<DTOBase> lista=busObjSubAgente.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			SubAgente elem = (SubAgente) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_subagente(){}	
	private void _________________________________inizio_validita(){}	
	public void crea(Validita c){
		//c.setStato(Attivo.getInstance());
		busObjValidita.create(c);
	}
	public void leggi(Validita n){
		busObjValidita.read(n);
	}
	public ArrayList<DTOBase> elenco (Validita n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjValidita.readAll();
		}
		catch (NullPointerException e){
			busObjValidita = new BOValidita();
			lista=busObjValidita.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Validita n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjValidita.readDeleted();
		}
		catch (NullPointerException e){
			busObjValidita = new BOValidita();
			lista=busObjValidita.readDeleted();
		}
		return lista;
	}
	public void cancella(Validita c){
		busObjValidita.delete(c);
	}
	public void aggiorna(Validita c){
		busObjValidita.update(c);
	}
	public ArrayList<DTOBase> filtra (Validita n){
		ArrayList<DTOBase> lista=busObjValidita.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Validita elem = (Validita) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_validita(){}	
	private void _________________________________inizio_percentualefornitore(){}	
	public void crea(PercentualeFornitore c){
		//c.setStato(Attivo.getInstance());
		busObjPercentualeFornitore.create(c);
	}
	public void leggi(PercentualeFornitore n){
		busObjPercentualeFornitore.read(n);
	}
	public ArrayList<DTOBase> elenco (PercentualeFornitore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjPercentualeFornitore.readAll();
		}
		catch (NullPointerException e){
			busObjPercentualeFornitore = new BOPercentualeFornitore();
			lista=busObjPercentualeFornitore.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (PercentualeFornitore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjPercentualeFornitore.readDeleted();
		}
		catch (NullPointerException e){
			busObjPercentualeFornitore = new BOPercentualeFornitore();
			lista=busObjPercentualeFornitore.readDeleted();
		}
		return lista;
	}
	public void cancella(PercentualeFornitore c){
		busObjPercentualeFornitore.delete(c);
	}
	public void aggiorna(PercentualeFornitore c){
		busObjPercentualeFornitore.update(c);
	}
	public ArrayList<DTOBase> filtra (PercentualeFornitore n){
		ArrayList<DTOBase> lista=busObjPercentualeFornitore.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			PercentualeFornitore elem = (PercentualeFornitore) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_percentualefornitore(){}	
	private void _________________________________inizio_fornitore(){}	
	public void crea(Fornitore c){
		//c.setStato(Attivo.getInstance());
		busObjFornitore.create(c);
	}
	public void leggi(Fornitore n){
		busObjFornitore.read(n);
	}
	public ArrayList<DTOBase> elenco (Fornitore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjFornitore.readAll();
		}
		catch (NullPointerException e){
			busObjFornitore = new BOFornitore();
			lista=busObjFornitore.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Fornitore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjFornitore.readDeleted();
		}
		catch (NullPointerException e){
			busObjFornitore = new BOFornitore();
			lista=busObjFornitore.readDeleted();
		}
		return lista;
	}
	public void cancella(Fornitore c){
		busObjFornitore.delete(c);
	}
	public void aggiorna(Fornitore c){
		busObjFornitore.update(c);
		
		
		ArrayList<DTOBase> lista = busObjDocumento.readAll();
		
		for(DTOBase myDto : lista) {
			Documento doc = (Documento) myDto;
			
			Azienda a = doc.getFornitore();
			
			if (a!=null) {
				if (a.equals(c)) {
					a.setNome(c.getNome());
					a.setForma(c.getForma());
					a.setSecondoNome(c.getSecondoNome());
				}
			}
			
		}
		
		
		
	}
	public ArrayList<DTOBase> filtra (Fornitore n){
		ArrayList<DTOBase> lista=busObjFornitore.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Fornitore elem = (Fornitore) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_fornitore(){}	
	private void _________________________________inizio_consorzio(){}	
	public void crea(Consorzio c){
		//c.setStato(Attivo.getInstance());
		busObjConsorzio.create(c);
	}
	public void leggi(Consorzio n){
		busObjConsorzio.read(n);
	}
	public ArrayList<DTOBase> elenco (Consorzio n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjConsorzio.readAll();
		}
		catch (NullPointerException e){
			busObjConsorzio = new BOConsorzio();
			lista=busObjConsorzio.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Consorzio n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjConsorzio.readDeleted();
		}
		catch (NullPointerException e){
			busObjConsorzio = new BOConsorzio();
			lista=busObjConsorzio.readDeleted();
		}
		return lista;
	}
	public void cancella(Consorzio c){
		busObjConsorzio.delete(c);
	}
	public void aggiorna(Consorzio c){
		busObjConsorzio.update(c);
	}
	public ArrayList<DTOBase> filtra (Consorzio n){
		ArrayList<DTOBase> lista=busObjConsorzio.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Consorzio elem = (Consorzio) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_consorzio(){}	
	private void _________________________________inizio_GruppoSocietario(){}	
	public void crea(GruppoSocietario c){
		//c.setStato(Attivo.getInstance());
		busObjGruppoSocietario.create(c);
	}
	public void leggi(GruppoSocietario n){
		busObjGruppoSocietario.read(n);
	}
	public ArrayList<DTOBase> elenco (GruppoSocietario n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjGruppoSocietario.readAll();
		}
		catch (NullPointerException e){
			busObjGruppoSocietario = new BOGruppoSocietario();
			lista=busObjGruppoSocietario.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (GruppoSocietario n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjGruppoSocietario.readDeleted();
		}
		catch (NullPointerException e){
			busObjGruppoSocietario = new BOGruppoSocietario();
			lista=busObjGruppoSocietario.readDeleted();
		}
		return lista;
	}
	public void cancella(GruppoSocietario c){
		busObjGruppoSocietario.delete(c);
	}
	public void aggiorna(GruppoSocietario c){
		busObjGruppoSocietario.update(c);
	}
	private void _________________________________fine_GruppoSocietario(){}	
	private void _________________________________inizio_settore(){}	
	public void crea(Settore c){
		//c.setStato(Attivo.getInstance());
		busObjSettore.create(c);
	}
	public void leggi(Settore n){
		busObjSettore.read(n);
	}
	public ArrayList<DTOBase> elenco (Settore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjSettore.readAll();
		}
		catch (NullPointerException e){
			busObjSettore = new BOSettore();
			lista=busObjSettore.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Settore n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjSettore.readDeleted();
		}
		catch (NullPointerException e){
			busObjSettore = new BOSettore();
			lista=busObjSettore.readDeleted();
		}
		return lista;
	}
	public void cancella(Settore c){
		busObjSettore.delete(c);
	}
	public void aggiorna(Settore c){
		busObjSettore.update(c);
	}
	public ArrayList<DTOBase> filtra (Settore n){
		ArrayList<DTOBase> lista=busObjSettore.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Settore elem = (Settore) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_settore(){}	
	private void _________________________________inizio_Minimo(){}	
	public void crea(Minimo c){
		//c.setStato(Attivo.getInstance());
		busObjMinimo.create(c);
	}
	public void leggi(Minimo n){
		busObjMinimo.read(n);
	}
	public ArrayList<DTOBase> elenco (Minimo n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjMinimo.readAll();
		}
		catch (NullPointerException e){
			busObjMinimo = new BOMinimo();
			lista=busObjMinimo.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Minimo n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjMinimo.readDeleted();
		}
		catch (NullPointerException e){
			busObjMinimo = new BOMinimo();
			lista=busObjMinimo.readDeleted();
		}
		return lista;
	}
	public void cancella(Minimo c){
		busObjMinimo.delete(c);
	}
	public void aggiorna(Minimo c){
		busObjMinimo.update(c);
	}
	public ArrayList<DTOBase> filtra (Minimo n){
		ArrayList<DTOBase> lista=busObjMinimo.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Minimo elem = (Minimo) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Minimo(){}	
	private void _________________________________inizio_Trasporto(){}	
	public void crea(Trasporto c){
		//c.setStato(Attivo.getInstance());
		busObjTrasporto.create(c);
	}
	public void leggi(Trasporto n){
		busObjTrasporto.read(n);
	}
	public ArrayList<DTOBase> elenco (Trasporto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjTrasporto.readAll();
		}
		catch (NullPointerException e){
			busObjTrasporto = new BOTrasporto();
			lista=busObjTrasporto.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Trasporto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjTrasporto.readDeleted();
		}
		catch (NullPointerException e){
			busObjTrasporto = new BOTrasporto();
			lista=busObjTrasporto.readDeleted();
		}
		return lista;
	}
	public void cancella(Trasporto c){
		busObjTrasporto.delete(c);
	}
	public void aggiorna(Trasporto c){
		busObjTrasporto.update(c);
	}
	public ArrayList<DTOBase> filtra (Trasporto n){
		ArrayList<DTOBase> lista=busObjTrasporto.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Trasporto elem = (Trasporto) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Trasporto(){}	
	private void _________________________________inizio_Pagamento(){}	
	public void crea(Pagamento c){
		//c.setStato(Attivo.getInstance());
		busObjPagamento.create(c);
	}
	public void leggi(Pagamento n){
		busObjPagamento.read(n);
	}
	public ArrayList<DTOBase> elenco (Pagamento n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjPagamento.readAll();
		}
		catch (NullPointerException e){
			busObjPagamento = new BOPagamento();
			lista=busObjPagamento.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Pagamento n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjPagamento.readDeleted();
		}
		catch (NullPointerException e){
			busObjPagamento = new BOPagamento();
			lista=busObjPagamento.readDeleted();
		}
		return lista;
	}
	public void cancella(Pagamento c){
		busObjPagamento.delete(c);
	}
	public void aggiorna(Pagamento c){
		busObjPagamento.update(c);
	}
	public ArrayList<DTOBase> filtra (Pagamento n){
		ArrayList<DTOBase> lista=busObjPagamento.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Pagamento elem = (Pagamento) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Pagamento(){}	
	private void _________________________________inizio_Cliente(){}	
	public void crea(Cliente c){
		//c.setStato(Attivo.getInstance());
		busObjCliente.create(c);
	}
	public void leggi(Cliente n){
		busObjCliente.read(n);
	}
	public ArrayList<DTOBase> elenco (Cliente n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCliente.readAll();
		}
		catch (NullPointerException e){
			busObjCliente = new BOCliente();
			lista=busObjCliente.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Cliente n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCliente.readDeleted();
		}
		catch (NullPointerException e){
			busObjCliente = new BOCliente();
			lista=busObjCliente.readDeleted();
		}
		return lista;
	}
	public void cancella(Cliente c){
		busObjCliente.delete(c);
	}
	public void aggiorna(Cliente c){
		busObjCliente.update(c);
		
		
		
		ArrayList<DTOBase> lista = busObjDocumento.readAll();
		
		for(DTOBase myDto : lista) {
			Documento doc = (Documento) myDto;
			
			Riferimento r = doc.getRiferimento();

			if (r!=null) {
				Azienda a=null;
				 a = r.getAzienda();
				if (a.equals(c)) {
					a.setNome(c.getNome());
					a.setForma(c.getForma());
					a.setSecondoNome(c.getSecondoNome());
				}
			}
			
		}
		
		
		
	}
	public ArrayList<DTOBase> filtra (Cliente n){
		ArrayList<DTOBase> lista=busObjCliente.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Cliente elem = (Cliente) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Cliente(){}	
	private void _________________________________inizio_UM(){}	
	public void crea(UM c){
		//c.setStato(Attivo.getInstance());
		busObjUM.create(c);
	}
	public void leggi(UM n){
		busObjUM.read(n);
	}
	public ArrayList<DTOBase> elenco (UM n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjUM.readAll();
		}
		catch (NullPointerException e){
			busObjUM = new BOUM();
			lista=busObjUM.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (UM n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjUM.readDeleted();
		}
		catch (NullPointerException e){
			busObjUM = new BOUM();
			lista=busObjUM.readDeleted();
		}
		return lista;
	}
	public void cancella(UM c){
		busObjUM.delete(c);
	}
	public void aggiorna(UM c){
		busObjUM.update(c);
	}
	public ArrayList<DTOBase> filtra (UM n){
		ArrayList<DTOBase> lista=busObjUM.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			UM elem = (UM) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_UM(){}	
	private void _________________________________inizio_GruppoProdotto(){}	
	public void crea(GruppoProdotto c){
		//c.setStato(Attivo.getInstance());
		busObjGruppoProdotto.create(c);
	}
	public void leggi(GruppoProdotto n){
		busObjGruppoProdotto.read(n);
	}
	public ArrayList<DTOBase> elenco (GruppoProdotto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjGruppoProdotto.readAll();
		}
		catch (NullPointerException e){
			busObjGruppoProdotto = new BOGruppoProdotto();
			lista=busObjGruppoProdotto.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (GruppoProdotto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjGruppoProdotto.readDeleted();
		}
		catch (NullPointerException e){
			busObjGruppoProdotto = new BOGruppoProdotto();
			lista=busObjGruppoProdotto.readDeleted();
		}
		return lista;
	}
	public void cancella(GruppoProdotto c){
		busObjGruppoProdotto.delete(c);
	}
	public void aggiorna(GruppoProdotto c){
		busObjGruppoProdotto.update(c);
	}
	public ArrayList<DTOBase> filtra (GruppoProdotto n){
		ArrayList<DTOBase> lista=busObjGruppoProdotto.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			GruppoProdotto elem = (GruppoProdotto) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_GruppoProdotto(){}	
	private void _________________________________inizio_SottoGruppoProdotto(){}	
	public void crea(SottoGruppoProdotto c){
		//c.setStato(Attivo.getInstance());
		busObjSottoGruppoProdotto.create(c);
	}
	public void leggi(SottoGruppoProdotto n){
		busObjSottoGruppoProdotto.read(n);
	}
	public ArrayList<DTOBase> elenco (SottoGruppoProdotto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjSottoGruppoProdotto.readAll();
		}
		catch (NullPointerException e){
			busObjSottoGruppoProdotto = new BOSottoGruppoProdotto();
			lista=busObjSottoGruppoProdotto.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (SottoGruppoProdotto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjSottoGruppoProdotto.readDeleted();
		}
		catch (NullPointerException e){
			busObjSottoGruppoProdotto = new BOSottoGruppoProdotto();
			lista=busObjSottoGruppoProdotto.readDeleted();
		}
		return lista;
	}
	public void cancella(SottoGruppoProdotto c){
		busObjSottoGruppoProdotto.delete(c);
	}
	public void aggiorna(SottoGruppoProdotto c){
		busObjSottoGruppoProdotto.update(c);
	}
	public ArrayList<DTOBase> filtra (SottoGruppoProdotto n){
		ArrayList<DTOBase> lista=busObjSottoGruppoProdotto.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			SottoGruppoProdotto elem = (SottoGruppoProdotto) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_SottoGruppoProdotto(){}	
	private void _________________________________inizio_Iva(){}	
	public void crea(Iva c){
		//c.setStato(Attivo.getInstance());
		busObjIva.create(c);
	}
	public void leggi(Iva n){
		busObjIva.read(n);
	}
	public ArrayList<DTOBase> elenco (Iva n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjIva.readAll();
		}
		catch (NullPointerException e){
			busObjIva = new BOIva();
			lista=busObjIva.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Iva n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjIva.readDeleted();
		}
		catch (NullPointerException e){
			busObjIva = new BOIva();
			lista=busObjIva.readDeleted();
		}
		return lista;
	}
	public void cancella(Iva c){
		busObjIva.delete(c);
	}
	public void aggiorna(Iva c){
		busObjIva.update(c);
	}
	public ArrayList<DTOBase> filtra (Iva n){
		ArrayList<DTOBase> lista=busObjIva.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Iva elem = (Iva) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Iva(){}	
	private void _________________________________inizio_Magazzino(){}	
	public void crea(Magazzino c){
		//c.setStato(Attivo.getInstance());
		busObjMagazzino.create(c);
	}
	public void leggi(Magazzino n){
		busObjMagazzino.read(n);
	}
	public ArrayList<DTOBase> elenco (Magazzino n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjMagazzino.readAll();
		}
		catch (NullPointerException e){
			busObjMagazzino = new BOMagazzino();
			lista=busObjMagazzino.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Magazzino n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjMagazzino.readDeleted();
		}
		catch (NullPointerException e){
			busObjMagazzino = new BOMagazzino();
			lista=busObjMagazzino.readDeleted();
		}
		return lista;
	}
	public void cancella(Magazzino c){
		busObjMagazzino.delete(c);
	}
	public void aggiorna(Magazzino c){
		busObjMagazzino.update(c);
	}
	public ArrayList<DTOBase> filtra (Magazzino n){
		ArrayList<DTOBase> lista=busObjMagazzino.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Magazzino elem = (Magazzino) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Magazzino(){}	
	private void _________________________________inizio_CausaleTrasporto(){}	
	public void crea(CausaleTrasporto c){
		//c.setStato(Attivo.getInstance());
		busObjCausaleTrasporto.create(c);
	}
	public void leggi(CausaleTrasporto n){
		busObjCausaleTrasporto.read(n);
	}
	public ArrayList<DTOBase> elenco (CausaleTrasporto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCausaleTrasporto.readAll();
		}
		catch (NullPointerException e){
			busObjCausaleTrasporto = new BOCausaleTrasporto();
			lista=busObjCausaleTrasporto.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (CausaleTrasporto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCausaleTrasporto.readDeleted();
		}
		catch (NullPointerException e){
			busObjCausaleTrasporto = new BOCausaleTrasporto();
			lista=busObjCausaleTrasporto.readDeleted();
		}
		return lista;
	}
	public void cancella(CausaleTrasporto c){
		busObjCausaleTrasporto.delete(c);
	}
	public void aggiorna(CausaleTrasporto c){
		busObjCausaleTrasporto.update(c);
	}
	public ArrayList<DTOBase> filtra (CausaleTrasporto n){
		ArrayList<DTOBase> lista=busObjCausaleTrasporto.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			CausaleTrasporto elem = (CausaleTrasporto) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_CausaleTrasporto(){}	
	private void _________________________________inizio_Prodotto(){}	
	public void crea(Prodotto c){
		//c.setStato(Attivo.getInstance());
		busObjProdotto.create(c);
	}
	public void leggi(Prodotto n){
		busObjProdotto.read(n);
	}
	public ArrayList<DTOBase> elenco (Prodotto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjProdotto.readAll();
		}
		catch (NullPointerException e){
			busObjProdotto = new BOProdotto();
			lista=busObjProdotto.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Prodotto n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjProdotto.readDeleted();
		}
		catch (NullPointerException e){
			busObjProdotto = new BOProdotto();
			lista=busObjProdotto.readDeleted();
		}
		return lista;
	}
	public void cancella(Prodotto c){
		busObjProdotto.delete(c);
	}
	public void aggiorna(Prodotto c){
		busObjProdotto.update(c);
	}
	public ArrayList<DTOBase> filtra (Prodotto n){
		ArrayList<DTOBase> lista=busObjProdotto.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Prodotto elem = (Prodotto) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Prodotto(){}	
	private void _________________________________inizio_TipoDocumento(){}	
	public void crea(TipoDocumento c){
		//c.setStato(Attivo.getInstance());
		busObjTipoDocumento.create(c);
	}
	public void leggi(TipoDocumento n){
		busObjTipoDocumento.read(n);
	}
	public ArrayList<DTOBase> elenco (TipoDocumento n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjTipoDocumento.readAll();
		}
		catch (NullPointerException e){
			busObjTipoDocumento = new BOTipoDocumento();
			lista=busObjTipoDocumento.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (TipoDocumento n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjTipoDocumento.readDeleted();
		}
		catch (NullPointerException e){
			busObjTipoDocumento = new BOTipoDocumento();
			lista=busObjTipoDocumento.readDeleted();
		}
		return lista;
	}
	public void cancella(TipoDocumento c){
		busObjTipoDocumento.delete(c);
	}
	public void aggiorna(TipoDocumento c){
		busObjTipoDocumento.update(c);
		
		
		ArrayList<DTOBase> lista = busObjDocumento.readAll();
		
		for(DTOBase myDto : lista) {
			Documento doc = (Documento) myDto;
			
			if (doc.getTipo().equals(c)) {
				doc.setTipo(c);
			}
			
		}
		
		
		
		
		
	}
	public ArrayList<DTOBase> filtra (TipoDocumento n){
		ArrayList<DTOBase> lista=busObjTipoDocumento.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			TipoDocumento elem = (TipoDocumento) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_TipoDocumento(){}	
	private void _________________________________inizio_Layout(){}	
	public void crea(Layout c){
		//c.setStato(Attivo.getInstance());
		busObjLayout.create(c);
	}
	public void leggi(Layout n){
		busObjLayout.read(n);
	}
	public ArrayList<DTOBase> elenco (Layout n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjLayout.readAll();
		}
		catch (NullPointerException e){
			busObjLayout = new BOLayout();
			lista=busObjLayout.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Layout n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjLayout.readDeleted();
		}
		catch (NullPointerException e){
			busObjLayout = new BOLayout();
			lista=busObjLayout.readDeleted();
		}
		return lista;
	}
	public void cancella(Layout c){
		busObjLayout.delete(c);
	}
	public void aggiorna(Layout c){
		busObjLayout.update(c);
	}
	public ArrayList<DTOBase> filtra (Layout n){
		ArrayList<DTOBase> lista=busObjLayout.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Layout elem = (Layout) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Layout(){}	
	private void _________________________________inizio_Categoria(){}	
	public void crea(Categoria c){
		//c.setStato(Attivo.getInstance());
		busObjCategoria.create(c);
	}
	public void leggi(Categoria n){
		busObjCategoria.read(n);
	}
	public ArrayList<DTOBase> elenco (Categoria n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCategoria.readAll();
		}
		catch (NullPointerException e){
			busObjCategoria = new BOCategoria();
			lista=busObjCategoria.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Categoria n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjCategoria.readDeleted();
		}
		catch (NullPointerException e){
			busObjCategoria = new BOCategoria();
			lista=busObjCategoria.readDeleted();
		}
		return lista;
	}
	public void cancella(Categoria c){
		busObjCategoria.delete(c);
	}
	public void aggiorna(Categoria c){
		busObjCategoria.update(c);
	}
	public ArrayList<DTOBase> filtra (Categoria n){
		ArrayList<DTOBase> lista=busObjCategoria.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Categoria elem = (Categoria) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Categoria(){}	
	private void _________________________________inizio_Documento(){}	
	public void crea(Documento c){
		//c.setStato(Attivo.getInstance());
		
		if (c.getTipo().isShowAutoID()) {
			//genera automaticamente il numero
			//numero automatico
			int maxDoc = 0;
			maxDoc=0;
			
			String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			
			ArrayList<DTOBase> listaDocs = busObjDocumento.readAll();
					
//					(ArrayList<Documento>) execute(cmd3);
			
			for (DTOBase b : listaDocs){
				Documento d = (Documento) b;
				if (d.getTipo().getCategoria().equals(c.getTipo().getCategoria()) && d.getData().contains(year)){
					int next = Integer.parseInt(d.getNumero());
					if (next > maxDoc)
						maxDoc = next;
				}
			}
			c.setNumero((maxDoc+1) + "");
//			txtNumero.setText((maxDoc+1) + "");
			
			Calendar date = Calendar.getInstance();
			
			String anno = String.valueOf(date.get(Calendar.YEAR));
			String mese = String.valueOf(date.get(Calendar.MONTH)+1);
			if (Integer.parseInt(mese)<10){
				mese= "0" + mese;
			}
			String giorno = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
			if (Integer.parseInt(giorno)<10){
				giorno= "0" + giorno;
			}
			
			c.setData(anno + "-" + mese + "-" + giorno);
			c.setDatarev(anno + "-" + mese + "-" + giorno);
//			txtData.setText(anno + "-" + mese + "-" + giorno);
			
			
			
		}
		
		busObjDocumento.create(c);
//		creapdf(c);
		
		
	}
	public void leggi(Documento n){
		busObjDocumento.read(n);
	}
	
	
	public void creapdf(DocumentoSub n){
		busObjDocumento.creaPDF(n);
	}
	public void creaxls(Documento n){
		busObjDocumento.creaXLS(n);
	}
	
	
	public void cancellapdf(Documento n){
		busObjDocumento.setRootDocument(busObjParametro.readAll().get(0));
		busObjDocumento.cancellaPDF(n);
		
	}
		public void creapdf(Documento n){
		
		
		
		
		busObjDocumento.setRootDocument(busObjParametro.readAll().get(0));
		busObjDocumento.creaPDF(n);
		
		
////		busObjDocumento.read(n);
//		
//		Parametro param = (Parametro) busObjParametro.readAll().get(0);
// 	   
//// 	   Documento d = tblAziende.getItems().get(getTableRow().getIndex());
// 	   
// 	   OutputStream outputStream = null;
// 	   
//        try {    
//     	   
//            //now write the PDF content to the output stream
//            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
//                    .withLocale(Locale.ITALIAN);
//
//                LocalDate date = formatter.parseLocalDate(n.getData());
//
////                System.out.println(date.getYear());  // 2012
////                System.out.println(date.getMonthOfYear()); // 8
////                System.out.println(date.getDayOfMonth());   // 18
//            	   
//          	   String filePath = param.getRoot() + File.separator;
//          	   
//          	 filePath += n.getRiferimento().getAzienda().getNome() + File.separator;
//
//          	filePath += n.getRiferimento().getAzienda().getNome() + "_" + date.getYear() + File.separator;
//
//       	   String fileName = "";
//       	fileName += n.getData() + "-" + n.getTipo().getDiciturafile() + " " + n.getNumero() + "-" + date.getYear() + " x ";
//  	   		      
//       	fileName += n.getProdotti().get(0).getProdotto().getFornitore().getNome() + " (R" + n.getRiferimento().getAzienda().getId() + "_" + n.getRiferimento().getId() + ")";
//  	   		      
//  	   		      
//  	   		      
////  	   		      n.getProdotti().get(0).getProdotto().getFornitore();
//  	   		      
//     	   
//     	   
////     	   if (n.getRiferimento()!=null) {
////	        	   fileName += n.getRiferimento().getCognome();
////     		   
////     	   }
//     	   fileName+= ".pdf";
//     	   
//           try {
//         	   outputStream = new FileOutputStream(filePath + fileName);
//           } 
//           catch(Exception e){
////        	   e.printStackTrace();
//        	   new File(filePath).mkdirs();
//         	   outputStream = new FileOutputStream(filePath + fileName);
//         }
// 	   
//     	   
//// 	       public void writePdf(OutputStream outputStream) throws Exception {
//	           Document document = new Document(PageSize.A4.rotate(),1,1,1,1);
//	           
//	           PdfWriter writer = PdfWriter.getInstance(document, outputStream);
//	            
//	           document.open();
//	           
//	           Image img = Image.getInstance(ClassLoader.getSystemResource("b_tiers/b_business/b_services/logorcm.png"));
//	           
//	           img.scaleAbsolute(70.0f, 70.0f);
//	           float xPos=2.0f;
//	           float yPos=PageSize.A4.getWidth()-img.getScaledHeight();
////	           img.setAbsolutePosition(50.0f, 65.0f);
//	           img.setAbsolutePosition(xPos,yPos);
//	           document.add(img);
//	           
//	           
//	           String nomeDocumento="Offerta";
//	           
//	           PdfContentByte canvas = writer.getDirectContent();
//   	           float llx=15;
//   	           float lly=15;
//   	           float urx=15;
//   	           float ury=15;
////   	           Rectangle rect = new Rectangle(xPos+img.getScaledWidth(), PageSize.A4.getWidth()-2, 35, 15);
//   	           Rectangle rect = new Rectangle(llx,lly,urx,ury);
//   	           rect.setBorder(Rectangle.BOX);
//   	           rect.setBorderWidth(2);
//   	           canvas.rectangle(rect);	           
//	           
////	           Phrase phrase = new Phrase();
//////	           phrase.add(new Chunk(img,(PageSize.A4.getWidth()-10), (PageSize.A4.getHeight())-10));
////	           phrase.add(new Chunk(img,100, 0));
////	           document.add(new Paragraph(phrase));
////	           document.addTitle("Test PDF");
////	           document.addSubject("Testing email PDF");
////	           document.addKeywords("iText, email");
////	           document.addAuthor("Jee Vang");
////	           document.addCreator("Jee Vang");
//	            
////	           Paragraph paragraph = new Paragraph();
////	           paragraph.add(new Chunk("RCM s.a.s. | via Pisa, 7 - 76125 Trani (BT) - Italy | Tel: +39 0883/486694 - Fax: +39 0884/402049 - E-mail: info@rcmagency.com - Web: www.rcmagency.com - C.F./P.I. 06922820722"));
////	           Font font = new Font(FontFamily.HELVETICA);
////	           font.setSize(11);
////	           paragraph.setFont(font);
////	           document.add(paragraph);
//	            
//	           
//	           
//	           PdfContentByte cb = writer.getDirectContent();
//	           BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
//	           cb.saveState();
//	           cb.beginText();
////	           cb.moveText(2.5f, 2.5f);
//	           cb.setFontAndSize(bf, 7);
//	           String txt = "RCM s.a.s. | via Pisa, 7 - 76125 Trani (BT) - Italy | Tel: +39 0883/486694 - Fax: +39 0884/402049 - E-mail: info@rcmagency.com - Web: www.rcmagency.com - C.F./P.I. 06922820722";
////	           cb.showText("RCM s.a.s. | via Pisa, 7 - 76125 Trani (BT) - Italy | Tel: +39 0883/486694 - Fax: +39 0884/402049 - E-mail: info@rcmagency.com - Web: www.rcmagency.com - C.F./P.I. 06922820722");
//	           cb.showTextAligned(cb.ALIGN_CENTER, txt, PageSize.A4.getHeight()/2, 2.0f, 0.0f);
//	           cb.endText();
//	           cb.restoreState();
//	           document.close();
////	           outputStream.close();
//	           writer.close();
//	           
//	           
//	           Desktop.getDesktop().open(new File(filePath + fileName));
////     	   
//////            byte[] bytes = outputStream.toByteArray();
//        }catch(Exception e) {
//        	e.printStackTrace();
//        }
//	   
//		
	}
	public ArrayList<DTOBase> elenco (Documento n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
//		try{
			lista=busObjDocumento.readAll();
//		}
//		catch (NullPointerException e){
//			busObjDocumento = new BODocumento();
//			lista=busObjDocumento.readAll();
//		}
		return lista;
	}
//	public ArrayList<DTOBase> elencocancellati (Documento n){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		try{
//			lista=busObjDocumento.readDeleted();
//		}
//		catch (NullPointerException e){
//			busObjDocumento = new BODocumento();
//			lista=busObjDocumento.readDeleted();
//		}
//		return lista;
//	}
	public void cancella(Documento c){
		busObjDocumento.delete(c);
	}
	public void aggiorna(Documento c){
		busObjDocumento.update(c);
//		cancellapdf(c);
//		creapdf(c);
	}
	public ArrayList<DTOBase> filtra (Documento n){
		ArrayList<DTOBase> lista=busObjDocumento.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Documento elem = (Documento) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Documento(){}	
//	private void _________________________________inizio_Movimentazione(){}	
//	public void crea(Movimentazione c){
//		//c.setStato(Attivo.getInstance());
//		busObjMovimentazione.create(c);
//	}
//	public void leggi(Movimentazione n){
//		busObjMovimentazione.read(n);
//	}
//	public ArrayList<DTOBase> elenco (Movimentazione n){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		try{
//			lista=busObjMovimentazione.readAll();
//		}
//		catch (NullPointerException e){
//			busObjMovimentazione = new BOMovimentazione();
//			lista=busObjMovimentazione.readAll();
//		}
//		return lista;
//	}
//	public ArrayList<DTOBase> elencocancellati (Movimentazione n){
//		ArrayList<DTOBase> lista=new ArrayList<>();
//		
//		try{
//			lista=busObjMovimentazione.readDeleted();
//		}
//		catch (NullPointerException e){
//			busObjMovimentazione = new BOMovimentazione();
//			lista=busObjMovimentazione.readDeleted();
//		}
//		return lista;
//	}
//	public void cancella(Movimentazione c){
//		busObjMovimentazione.delete(c);
//	}
//	public void aggiorna(Movimentazione c){
//		busObjMovimentazione.update(c);
//	}
//	private void _________________________________fine_Movimentazione(){}	
	private void _________________________________inizio_Titolo(){}	
	public void crea(Titolo c){
		//c.setStato(Attivo.getInstance());
		busObjTitolo.create(c);
	}
	public void leggi(Titolo n){
		busObjTitolo.read(n);
	}
	public ArrayList<DTOBase> elenco (Titolo n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjTitolo.readAll();
		}
		catch (NullPointerException e){
			busObjTitolo = new BOTitolo();
			lista=busObjTitolo.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Titolo n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjTitolo.readDeleted();
		}
		catch (NullPointerException e){
			busObjTitolo = new BOTitolo();
			lista=busObjTitolo.readDeleted();
		}
		return lista;
	}
	public void cancella(Titolo c){
		busObjTitolo.delete(c);
	}
	public void aggiorna(Titolo c){
		busObjTitolo.update(c);
	}
	public ArrayList<DTOBase> filtra (Titolo n){
		ArrayList<DTOBase> lista=busObjTitolo.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Titolo elem = (Titolo) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Titolo(){}	
	private void _________________________________inizio_Ruolo(){}	
	public void crea(Ruolo c){
		//c.setStato(Attivo.getInstance());
		busObjRuolo.create(c);
	}
	public void leggi(Ruolo n){
		busObjRuolo.read(n);
	}
	public ArrayList<DTOBase> elenco (Ruolo n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjRuolo.readAll();
		}
		catch (NullPointerException e){
			busObjRuolo = new BORuolo();
			lista=busObjRuolo.readAll();
		}
		return lista;
	}
	public ArrayList<DTOBase> elencocancellati (Ruolo n){
		ArrayList<DTOBase> lista=new ArrayList<>();
		
		try{
			lista=busObjRuolo.readDeleted();
		}
		catch (NullPointerException e){
			busObjRuolo = new BORuolo();
			lista=busObjRuolo.readDeleted();
		}
		return lista;
	}
	public void cancella(Ruolo c){
		busObjRuolo.delete(c);
	}
	public void aggiorna(Ruolo c){
		busObjRuolo.update(c);
	}
	public ArrayList<DTOBase> filtra (Ruolo n){
		ArrayList<DTOBase> lista=busObjRuolo.readAll();
		ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
		
		
		for (int i =0; i< lista.size(); i++){
			Ruolo elem = (Ruolo) lista.get(i);
			
			if (elem.contains(n)){
				listaFiltrata.add(elem);
			}
			
		}
		
		return listaFiltrata;
	}
	private void _________________________________fine_Ruolo(){}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//		public ArrayList<DTOBase> elenco (TipoAzienda p){
////			return busObjTipoDocumento.readAll();
//			try{
//				return busObjTipoAzienda.readAll();
//			}
//			catch (NullPointerException e){
//				busObjTipoAzienda = new BOTipoAzienda();
//				return busObjTipoAzienda.readAll();
//			}
//		}


		
//		public void dimentica (Cliente c){
//			busObjCliente.getMemory().put(c.getId(), busObjCliente.getDao().read(c));
//			busObjCliente.getTemp().clear();
//		}
//		public void dimentica (Fornitore c){
//			busObjFornitore.getMemory().put(c.getId(), busObjFornitore.getDao().read(c));
//			busObjFornitore.getTemp().clear();
//		}
//		public void dimentica (SubAgente c){
//			busObjSubAgente.getMemory().put(c.getId(), busObjSubAgente.getDao().read(c));
//			busObjSubAgente.getTemp().clear();
//		}
//		public void dimentica (Segnalatore c){
//			busObjSegnalatore.getMemory().put(c.getId(), busObjSegnalatore.getDao().read(c));
//			busObjSegnalatore.getTemp().clear();
//		}
//		public void dimentica (Altro c){
//			busObjAltro.getMemory().put(c.getId(), busObjAltro.getDao().read(c));
//			busObjAltro.getTemp().clear();
//		}
//		public void dimentica (Pagamento c){
//			busObjPagamento.getMemory().put(c.getId(), busObjPagamento.getDao().read(c));
//			busObjPagamento.getTemp().clear();
//		}
//		public void dimentica (Trasporto c){
//			busObjTrasporto.getMemory().put(c.getId(), busObjTrasporto.getDao().read(c));
//			busObjTrasporto.getTemp().clear();
//		}
//		public void dimentica (Minimo c){
//			busObjMinimo.getMemory().put(c.getId(), busObjMinimo.getDao().read(c));
//			busObjMinimo.getTemp().clear();
//		}
//		public void dimentica (Settore c){
//			busObjSettore.getMemory().put(c.getId(), busObjSettore.getDao().read(c));
//			busObjSettore.getTemp().clear();
//		}
//		public void dimentica (GruppoSocietario c){
//			busObjGruppoSocietario.getMemory().put(c.getId(), busObjGruppoSocietario.getDao().read(c));
//			busObjGruppoSocietario.getTemp().clear();
//		}
//		public void dimentica (Consorzio c){
//			busObjConsorzio.getMemory().put(c.getId(), busObjConsorzio.getDao().read(c));
//			busObjConsorzio.getTemp().clear();
//		}
//		public void dimentica (PercentualeFornitore c){
//			busObjPercentualeFornitore.getMemory().put(c.getId(), busObjPercentualeFornitore.getDao().read(c));
//			busObjPercentualeFornitore.getTemp().clear();
//		}
//		public void dimentica (PercentualeCollaboratore c){
//			busObjPercentualeCollaboratore.getMemory().put(c.getId(), busObjPercentualeCollaboratore.getDao().read(c));
//			busObjPercentualeCollaboratore.getTemp().clear();
//		}
//		public void dimentica (Validita c){
//			busObjValidita.getMemory().put(c.getId(), busObjValidita.getDao().read(c));
//			busObjValidita.getTemp().clear();
//		}
//		public void dimentica (FormaGiuridica c){
//			busObjFormaGiuridica.getMemory().put(c.getId(), busObjFormaGiuridica.getDao().read(c));
//			busObjFormaGiuridica.getTemp().clear();
//		}
//		public void dimentica (Nazione c){
//			busObjNazione.getMemory().put(c.getId(), busObjNazione.getDao().read(c));
//			busObjNazione.getTemp().clear();
//		}
//		public void dimentica (Regione c){
//			busObjRegione.getMemory().put(c.getId(), busObjRegione.getDao().read(c));
//			busObjRegione.getTemp().clear();
//		}
//		public void dimentica (Provincia c){
//			busObjProvincia.getMemory().put(c.getId(), busObjProvincia.getDao().read(c));
//			busObjProvincia.getTemp().clear();
//		}
//		public void dimentica (Citta c){
//			busObjCitta.getMemory().put(c.getId(), busObjCitta.getDao().read(c));
//			busObjCitta.getTemp().clear();
//		}
//		public void dimentica (Prodotto c){
//			busObjProdotto.getMemory().put(c.getId(), busObjProdotto.getDao().read(c));
//			busObjProdotto.getTemp().clear();
//		}
//		public void dimentica (Magazzino c){
//			busObjMagazzino.getMemory().put(c.getId(), busObjMagazzino.getDao().read(c));
//			busObjMagazzino.getTemp().clear();
//		}
//		public void dimentica (Documento c){
//			busObjDocumento.getMemory().put(c.getId(), busObjDocumento.getDao().read(c));
//			busObjDocumento.getTemp().clear();
//		}
//		public void dimentica (TipoDocumento c){
//			busObjTipoDocumento.getMemory().put(c.getId(), busObjTipoDocumento.getDao().read(c));
//			busObjTipoDocumento.getTemp().clear();
//		}
//

//		public Cliente leggi(Cliente c){
//			
//			
//			
//				//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//				Cliente cl = (Cliente) busObjCliente.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjCliente.getMemory().put(c.getId(), busObjCliente.getDao().read(c));
//					cl = (Cliente) busObjCliente.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				e.printStackTrace();
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjCliente.getTemp().indexOf(c);
//				cl=(Cliente) busObjCliente.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//
//		public Fornitore leggi(Fornitore c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Fornitore cl = (Fornitore) busObjFornitore.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjFornitore.getMemory().put(c.getId(), busObjFornitore.getDao().read(c));
//					cl = (Fornitore) busObjFornitore.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjFornitore.getTemp().indexOf(c);
//				cl=(Fornitore) busObjFornitore.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public SubAgente leggi(SubAgente c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			SubAgente cl = (SubAgente) busObjSubAgente.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjSubAgente.getMemory().put(c.getId(), busObjSubAgente.getDao().read(c));
//					cl = (SubAgente) busObjSubAgente.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjSubAgente.getTemp().indexOf(c);
//				cl=(SubAgente) busObjSubAgente.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Segnalatore leggi(Segnalatore c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Segnalatore cl = (Segnalatore) busObjSegnalatore.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjSegnalatore.getMemory().put(c.getId(), busObjSegnalatore.getDao().read(c));
//					cl = (Segnalatore) busObjSegnalatore.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjSegnalatore.getTemp().indexOf(c);
//				cl=(Segnalatore) busObjSegnalatore.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Altro leggi(Altro c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Altro cl = (Altro) busObjAltro.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjAltro.getMemory().put(c.getId(), busObjAltro.getDao().read(c));
//					cl = (Altro) busObjAltro.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjAltro.getTemp().indexOf(c);
//				cl=(Altro) busObjAltro.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Pagamento leggi(Pagamento c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Pagamento cl = (Pagamento) busObjPagamento.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjPagamento.getMemory().put(c.getId(), busObjPagamento.getDao().read(c));
//					cl = (Pagamento) busObjPagamento.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjPagamento.getTemp().indexOf(c);
//				cl=(Pagamento) busObjPagamento.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Trasporto leggi(Trasporto c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Trasporto cl = (Trasporto) busObjTrasporto.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjTrasporto.getMemory().put(c.getId(), busObjTrasporto.getDao().read(c));
//					cl = (Trasporto) busObjTrasporto.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjTrasporto.getTemp().indexOf(c);
//				cl=(Trasporto) busObjTrasporto.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Minimo leggi(Minimo c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Minimo cl = (Minimo) busObjMinimo.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjMinimo.getMemory().put(c.getId(), busObjMinimo.getDao().read(c));
//					cl = (Minimo) busObjMinimo.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjMinimo.getTemp().indexOf(c);
//				cl=(Minimo) busObjMinimo.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Settore leggi(Settore c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Settore cl = (Settore) busObjSettore.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjSettore.getMemory().put(c.getId(), busObjSettore.getDao().read(c));
//					cl = (Settore) busObjSettore.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjSettore.getTemp().indexOf(c);
//				cl=(Settore) busObjSettore.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public GruppoSocietario leggi(GruppoSocietario c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			GruppoSocietario cl = (GruppoSocietario) busObjGruppoSocietario.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjGruppoSocietario.getMemory().put(c.getId(), busObjGruppoSocietario.getDao().read(c));
//					cl = (GruppoSocietario) busObjGruppoSocietario.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjGruppoSocietario.getTemp().indexOf(c);
//				cl=(GruppoSocietario) busObjGruppoSocietario.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Consorzio leggi(Consorzio c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Consorzio cl = (Consorzio) busObjConsorzio.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjConsorzio.getMemory().put(c.getId(), busObjConsorzio.getDao().read(c));
//					cl = (Consorzio) busObjConsorzio.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjConsorzio.getTemp().indexOf(c);
//				cl=(Consorzio) busObjConsorzio.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public PercentualeFornitore leggi(PercentualeFornitore c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			PercentualeFornitore cl = (PercentualeFornitore) busObjPercentualeFornitore.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjPercentualeFornitore.getMemory().put(c.getId(), busObjPercentualeFornitore.getDao().read(c));
//					cl = (PercentualeFornitore) busObjPercentualeFornitore.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjPercentualeFornitore.getTemp().indexOf(c);
//				cl=(PercentualeFornitore) busObjPercentualeFornitore.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public PercentualeCollaboratore leggi(PercentualeCollaboratore c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			PercentualeCollaboratore cl = (PercentualeCollaboratore) busObjPercentualeCollaboratore.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjPercentualeCollaboratore.getMemory().put(c.getId(), busObjPercentualeCollaboratore.getDao().read(c));
//					cl = (PercentualeCollaboratore) busObjPercentualeCollaboratore.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjPercentualeCollaboratore.getTemp().indexOf(c);
//				cl=(PercentualeCollaboratore) busObjPercentualeCollaboratore.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Validita leggi(Validita c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Validita cl = (Validita) busObjValidita.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjValidita.getMemory().put(c.getId(), busObjValidita.getDao().read(c));
//					cl = (Validita) busObjValidita.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjValidita.getTemp().indexOf(c);
//				cl=(Validita) busObjValidita.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public FormaGiuridica leggi(FormaGiuridica c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			FormaGiuridica cl = (FormaGiuridica) busObjFormaGiuridica.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjFormaGiuridica.getMemory().put(c.getId(), busObjFormaGiuridica.getDao().read(c));
//					cl = (FormaGiuridica) busObjFormaGiuridica.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjFormaGiuridica.getTemp().indexOf(c);
//				cl=(FormaGiuridica) busObjFormaGiuridica.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Nazione leggi(Nazione c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Nazione cl = (Nazione) busObjNazione.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjNazione.getMemory().put(c.getId(), busObjNazione.getDao().read(c));
//					cl = (Nazione) busObjNazione.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjNazione.getTemp().indexOf(c);
//				cl=(Nazione) busObjNazione.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Regione leggi(Regione c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Regione cl = (Regione) busObjRegione.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjRegione.getMemory().put(c.getId(), busObjRegione.getDao().read(c));
//					cl = (Regione) busObjRegione.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjRegione.getTemp().indexOf(c);
//				cl=(Regione) busObjRegione.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Provincia leggi(Provincia c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Provincia cl = (Provincia) busObjProvincia.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjProvincia.getMemory().put(c.getId(), busObjProvincia.getDao().read(c));
//					cl = (Provincia) busObjProvincia.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjProvincia.getTemp().indexOf(c);
//				cl=(Provincia) busObjProvincia.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Citta leggi(Citta c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Citta cl = (Citta) busObjCitta.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjCitta.getMemory().put(c.getId(), busObjCitta.getDao().read(c));
//					cl = (Citta) busObjCitta.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjCitta.getTemp().indexOf(c);
//				cl=(Citta) busObjCitta.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Prodotto leggi(Prodotto c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Prodotto cl = (Prodotto) busObjProdotto.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjProdotto.getMemory().put(c.getId(), busObjProdotto.getDao().read(c));
//					cl = (Prodotto) busObjProdotto.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
////				e.printStackTrace();
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjProdotto.getTemp().indexOf(c);
//				cl=(Prodotto) busObjProdotto.getTemp().get(index);
//				cl=null;
//			}
//			
//			
//			return cl;
//		}
//		public Magazzino leggi(Magazzino c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Magazzino cl = (Magazzino) busObjMagazzino.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjMagazzino.getMemory().put(c.getId(), busObjMagazzino.getDao().read(c));
//					cl = (Magazzino) busObjMagazzino.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
////				e.printStackTrace();
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjMagazzino.getTemp().indexOf(c);
//				cl=(Magazzino) busObjMagazzino.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public Documento leggi(Documento c){
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Documento cl = (Documento) busObjDocumento.getMemory().get(c.getId());
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjDocumento.getMemory().put(c.getId(), busObjDocumento.getDao().read(c));
//					cl = (Documento) busObjDocumento.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				e.printStackTrace();
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjDocumento.getTemp().indexOf(c);
//				cl=(Documento) busObjDocumento.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//		public TipoDocumento leggi(TipoDocumento c){
//			
//			TipoDocumento cl=null;
//			try{
//				//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//				/*TipoDocumento*/ cl = (TipoDocumento) busObjTipoDocumento.getMemory().get(c.getId());
//			}
//			catch(Exception e){
//				busObjTipoDocumento = new BOTipoDocumento();
//				
//				//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//				/*TipoDocumento*/ cl = (TipoDocumento) busObjTipoDocumento.getMemory().get(c.getId());
//			}
//			
//			
//			try{
//				if (!cl.isModified() && !cl.isLoaded()){
//					//inserimento in "memoria"
//					busObjTipoDocumento.getMemory().put(c.getId(), busObjTipoDocumento.getDao().read(c));
//					cl = (TipoDocumento) busObjTipoDocumento.getMemory().get(c.getId());
//				}
//				
//			}
//			catch(Exception e){
//				e.printStackTrace();
//				//l'oggetto non si trova in RAM (vuol dire che si trova nella memoria temporanea)
//				int index = busObjTipoDocumento.getTemp().indexOf(c);
//				cl=(TipoDocumento) busObjTipoDocumento.getTemp().get(index);
//			}
//			
//			
//			return cl;
//		}
//
//		public ArrayList<Cliente> filtra (Cliente i){
//			ArrayList<Cliente> array;
//			
//			
//				array =busObjCliente.readAll();
//			String street="";
//			String myAddress=i.getNome().toLowerCase();
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//					
//			}
//			
//			
//			return array;
//			
//		}
//		public ArrayList<Fornitore> filtra (Fornitore i){
//			ArrayList<Fornitore> array;
//			
//			
//				array =busObjFornitore.readAll();
//			String street="";
//			String myAddress=i.getNome().toLowerCase();
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//					
//			}
//			
//			
//			return array;
//			
//		}
//		public ArrayList<SubAgente> filtra (SubAgente i){
//			ArrayList<SubAgente> array;
//			
//			
//			
//				array =busObjSubAgente.readAll();
//			String street="";
//			String myAddress=i.getNome().toLowerCase();
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//					
//			}
//			
//			
//			return array;
//			
//		}
//		public ArrayList<Segnalatore> filtra (Segnalatore i){
//			ArrayList<Segnalatore> array;
//			
//			
//			
//				array =busObjSegnalatore.readAll();
//			String street="";
//			String myAddress=i.getNome().toLowerCase();
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//					
//			}
//			
//			
//			return array;
//			
//		}
//		public ArrayList<Altro> filtra (Altro i){
//			ArrayList<Altro> array;
//			
//			
//			
//				array =busObjAltro.readAll();
//			String street="";
//			String myAddress=i.getNome().toLowerCase();
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//					
//			}
//			
//			
//			return array;
//			
//		}
//		public ArrayList<Pagamento> filtra (Pagamento i){
//			ArrayList<Pagamento> array;
//			
//			
//			
//				array =busObjPagamento.readAll();
//			String street="";
//			String myAddress=i.getNome().toLowerCase();
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//					
//			}
//			
//			
//			return array;
//			
//		}
//		public ArrayList<Trasporto> filtra (Trasporto i){
//			ArrayList<Trasporto> array;
//			
//			
//			
//				array =busObjTrasporto.readAll();
//			String street="";
//			String myAddress=i.getNome().toLowerCase();
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//					
//			}
//			
//			
//			return array;
//			
//		}
//		public ArrayList<Minimo> filtra (Minimo i){
//			ArrayList<Minimo> array;
//			
//				array =busObjMinimo.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<Settore> filtra (Settore i){
//			ArrayList<Settore> array;
//			
//				array =busObjSettore.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<GruppoSocietario> filtra (GruppoSocietario i){
//			ArrayList<GruppoSocietario> array;
//			
//				array =busObjGruppoSocietario.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<Consorzio> filtra (Consorzio i){
//			ArrayList<Consorzio> array;
//			
//				array =busObjConsorzio.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<PercentualeFornitore> filtra (PercentualeFornitore i){
//			ArrayList<PercentualeFornitore> array;
//			
//				array =busObjPercentualeFornitore.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<PercentualeCollaboratore> filtra (PercentualeCollaboratore i){
//			ArrayList<PercentualeCollaboratore> array;
//			
//				array =busObjPercentualeCollaboratore.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<Validita> filtra (Validita i){
//			ArrayList<Validita> array;
//			
//				array =busObjValidita.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<FormaGiuridica> filtra (FormaGiuridica i){
//			ArrayList<FormaGiuridica> array;
//			
//				array =busObjFormaGiuridica.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<Nazione> filtra (Nazione i){
//			ArrayList<Nazione> array;
//			
//				array =busObjNazione.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<Regione> filtra (Regione i){
//			ArrayList<Regione> array;
//			
//				array =busObjRegione.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<Provincia> filtra (Provincia i){
//			ArrayList<Provincia> array;
//			
//				array =busObjProvincia.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<Citta> filtra (Citta i){
//			ArrayList<Citta> array;
//			
//				array =busObjCitta.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<Prodotto> filtra (Prodotto i){
//			ArrayList<Prodotto> array=null;
//			
//			try{
//				array =busObjProdotto.readAll();
//			}	
//			catch(Exception e){
//				busObjProdotto = new BOProdotto();
//				array =busObjProdotto.readAll();
//			}
//				
//				
//				
////			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//				else{
//					if (i.getFornitore()!=null){
//						//filtraggio dei prodotti per il documento in esame
//						if(array.get(index).getFornitore()==null || !array.get(index).getFornitore().equals(i.getFornitore())){
//							//il fornitore del prodotto in posizione "index" � inesistente oppure non coincide
//							array.remove(index);
//						}
//					}
//					else{
//						//filtraggio sull'elenco dei prodotti nella maschera: DatiDocumento.fxml
//					}
//					
////					if (i.getFornitore()!=null && !array.get(index).getFornitore().equals(i.getFornitore()))
////						array.remove(index);
//					
//					
//					
//				}
//			}
//			
//			return array;
//		}
//		public ArrayList<Magazzino> filtra (Magazzino i){
//			ArrayList<Magazzino> array;
//			
//				array =busObjMagazzino.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNome());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<Documento> filtra (Documento i){
//			ArrayList<Documento> array;
//			
//				array =busObjDocumento.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getNumero());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//		public ArrayList<TipoDocumento> filtra (TipoDocumento i){
//			ArrayList<TipoDocumento> array;
//			
//				array =busObjTipoDocumento.readAll();
//			String street="";
//			String myAddress=String.valueOf(i.getTipo());
//			
//			for (int index= array.size()-1; index>-1; index--){
//				//pseudo-override del contains per le aziende
//				if (!array.get(index).contains(myAddress))
//					array.remove(index);
//			}
//			
//			return array;
//		}
//
		private void _0000000000000000000note_azienda(){}
//	public void crea(NoteAzienda rif){
//		
//		if (rif.getAzienda() instanceof Cliente){
//			//seleziono l'azienda	
//			((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).createNote(rif);
//		}
//		else if (rif.getAzienda() instanceof Fornitore){
//			//seleziono l'azienda	
//			((Fornitore) busObjFornitore.getMemory().get(rif.getAzienda().getId())).createNote(rif);
//		}
//		else if (rif.getAzienda() instanceof SubAgente){
//			//seleziono l'azienda	
//			((SubAgente) busObjSubAgente.getMemory().get(rif.getAzienda().getId())).createNote(rif);
//		}
//		else if (rif.getAzienda() instanceof Segnalatore){
//			//seleziono l'azienda	
//			((Segnalatore) busObjSegnalatore.getMemory().get(rif.getAzienda().getId())).createNote(rif);
//		}
//		else if (rif.getAzienda() instanceof Altro){
//			//seleziono l'azienda	
//			((Altro) busObjAltro.getMemory().get(rif.getAzienda().getId())).createNote(rif);
//		}
//				
//	}
//
//	public void cancella(NoteAzienda rif){
//		
//		if (rif.getAzienda() instanceof Cliente){
//			//seleziono l'azienda	
//			((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).rimuoviNote(rif);
//		}
//		else if (rif.getAzienda() instanceof Fornitore){
//			//seleziono l'azienda	
//			((Fornitore) busObjFornitore.getMemory().get(rif.getAzienda().getId())).rimuoviNote(rif);
//		}
//		else if (rif.getAzienda() instanceof SubAgente){
//			//seleziono l'azienda	
//			((SubAgente) busObjSubAgente.getMemory().get(rif.getAzienda().getId())).rimuoviNote(rif);
//		}
//		else if (rif.getAzienda() instanceof Segnalatore){
//			//seleziono l'azienda	
//			((Segnalatore) busObjSegnalatore.getMemory().get(rif.getAzienda().getId())).rimuoviNote(rif);
//		}
//		else if (rif.getAzienda() instanceof Altro){
//			//seleziono l'azienda	
//			((Altro) busObjAltro.getMemory().get(rif.getAzienda().getId())).rimuoviNote(rif);
//		}
//	}
//
//	public void aggiorna(NoteAzienda rif){
//				
//			if (rif.getAzienda() instanceof Cliente){
//				//seleziono l'azienda	
//				((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).modificaNote(rif);
//			}
//			else if (rif.getAzienda() instanceof Fornitore){
//				//seleziono l'azienda	
//				((Fornitore) busObjFornitore.getMemory().get(rif.getAzienda().getId())).modificaNote(rif);
//			}
//			else if (rif.getAzienda() instanceof SubAgente){
//				//seleziono l'azienda	
//				((SubAgente) busObjSubAgente.getMemory().get(rif.getAzienda().getId())).modificaNote(rif);
//			}
//			else if (rif.getAzienda() instanceof Segnalatore){
//				//seleziono l'azienda	
//				((Segnalatore) busObjSegnalatore.getMemory().get(rif.getAzienda().getId())).modificaNote(rif);
//			}
//			else if (rif.getAzienda() instanceof Altro){
//				//seleziono l'azienda	
//				((Altro) busObjAltro.getMemory().get(rif.getAzienda().getId())).modificaNote(rif);
//			}
//	}
	private void _1111111111111111111note_azienda(){}
	private void _0000000000000000000riferimenti(){}
//	public void crea(Riferimento rif){
//		
//		Azienda c=rif.getAzienda();
//		
//		if (c instanceof Cliente){
//			c = (Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.createRiferimento(rif);
//				busObjCliente.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().createRiferimento(rif);
//				busObjCliente.getTemp().create(rif.getAzienda());
//			}
//		}
//		else if (c instanceof Fornitore){
//			c = (Fornitore) busObjFornitore.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.createRiferimento(rif);
//				busObjFornitore.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().createRiferimento(rif);
//				busObjFornitore.getTemp().create(rif.getAzienda());
//			}
//		}
//		else if (c instanceof SubAgente){
//			c = (SubAgente) busObjSubAgente.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.createRiferimento(rif);
//				busObjSubAgente.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().createRiferimento(rif);
//				busObjSubAgente.getTemp().create(rif.getAzienda());
//			}
//		}
//		else if (c instanceof Segnalatore){
//			c = (Segnalatore) busObjSegnalatore.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.createRiferimento(rif);
//				busObjSegnalatore.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().createRiferimento(rif);
//				busObjSegnalatore.getTemp().create(rif.getAzienda());
//			}
//		}
//		else if (c instanceof Altro){
//			c = (Altro) busObjAltro.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.createRiferimento(rif);
//				busObjAltro.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().createRiferimento(rif);
//				busObjAltro.getTemp().create(rif.getAzienda());
//			}
//		}
//		
//				
//	}
//
//	public void aggiorna(Riferimento rif){
////			((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).modificaRiferimento(rif);
//			
//			
//			if (rif.getAzienda() instanceof Cliente){
//				//seleziono l'azienda	
//				((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).modificaRiferimento(rif);
//			}
//			else if (rif.getAzienda() instanceof Fornitore){
//				//seleziono l'azienda	
//				((Fornitore) busObjFornitore.getMemory().get(rif.getAzienda().getId())).modificaRiferimento(rif);
//			}
//			else if (rif.getAzienda() instanceof SubAgente){
//				//seleziono l'azienda	
//				((SubAgente) busObjSubAgente.getMemory().get(rif.getAzienda().getId())).modificaRiferimento(rif);
//			}
//			else if (rif.getAzienda() instanceof Segnalatore){
//				//seleziono l'azienda	
//				((Segnalatore) busObjSegnalatore.getMemory().get(rif.getAzienda().getId())).modificaRiferimento(rif);
//			}
//			else if (rif.getAzienda() instanceof Altro){
//				//seleziono l'azienda	
//				((Altro) busObjAltro.getMemory().get(rif.getAzienda().getId())).modificaRiferimento(rif);
//			}
//			
//			
//	}
//
//	public void cancella(Riferimento rif){
//		
//		
//		Azienda c=rif.getAzienda();
//		
//		if (c instanceof Cliente){
//			c = (Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.rimuoviRiferimento(rif);
//				busObjCliente.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().rimuoviRiferimento(rif);
//				busObjCliente.getTemp().create(rif.getAzienda());
//			}
//		}
//		else if (c instanceof Fornitore){
//			c = (Fornitore) busObjFornitore.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.rimuoviRiferimento(rif);
//				busObjFornitore.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().rimuoviRiferimento(rif);
//				busObjFornitore.getTemp().create(rif.getAzienda());
//			}
//		}
//		else if (c instanceof SubAgente){
//			c = (SubAgente) busObjSubAgente.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.rimuoviRiferimento(rif);
//				busObjSubAgente.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().rimuoviRiferimento(rif);
//				busObjSubAgente.getTemp().create(rif.getAzienda());
//			}
//		}
//		else if (c instanceof Segnalatore){
//			c = (Segnalatore) busObjSegnalatore.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.rimuoviRiferimento(rif);
//				busObjSegnalatore.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().rimuoviRiferimento(rif);
//				busObjSegnalatore.getTemp().create(rif.getAzienda());
//			}
//		}
//		else if (c instanceof Altro){
//			c = (Altro) busObjAltro.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.rimuoviRiferimento(rif);
//				busObjAltro.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().rimuoviRiferimento(rif);
//				busObjAltro.getTemp().create(rif.getAzienda());
//			}
//		}
//		
//		
//		
//				
//				
//			}
//
	private void _1111111111111111111riferimenti(){}

//	public void crea(CondizioneCommerciale rif){
//		
//		((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).createCondizione(rif);
//		
//		
//	}
//
//	public void aggiorna(CondizioneCommerciale rif){
//		
//	((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).modificaCondizione(rif);
//		
//	}
//
//	public void cancella(CondizioneCommerciale rif){
//		
//		((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).rimuoviCondizione(rif);
//		
//		
//	}
//
//	public void crea(SchedaNetto rif){
//		
//		((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).createScheda(rif);
//		
//		
//	}
//
//	public void aggiorna(SchedaNetto rif){
//		
//	((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).modificaScheda(rif);
//		
//	}
//
//	public void cancella(SchedaNetto rif){
//		
//		((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).rimuoviScheda(rif);
//		
//		
//	}
//
	private void _01(){}
	private void ____________________2(){}
	//	public Riferimento leggi(Riferimento c){
	////		busObjCLiente.create(c);
	//		
	//		return (Riferimento) busObjCLiente.getSelected();
	////		return (Cliente) busObjCLiente.getDao().read(c);
	//////		return (Cliente) busObjCLiente.getMemory().get(c.getId());
	//	}
		
	//	public void apri(Cliente c){
	//		busObjCLiente.setSelected(c);
	//	}
	//	
	//	public void apri(Riferimento c){
	//		busObjCLiente.setSelected(c);
	//	}
		
		
private void ____________________3(){}

	

	
	
//	public Riferimento leggi(Riferimento c){
////		busObjCLiente.create(c);
//		
//		return (Riferimento) busObjCLiente.getSelected();
////		return (Cliente) busObjCLiente.getDao().read(c);
//////		return (Cliente) busObjCLiente.getMemory().get(c.getId());
//	}
	
//	public void apri(Cliente c){
//		busObjCLiente.setSelected(c);
//	}
//	
//	public void apri(Riferimento c){
//		busObjCLiente.setSelected(c);
//	}
	
	
//	public void crea(Fornitore f){
//		busObjFornitore.create(f);
//	}
	
//	public void crea(Collaboratore c){
//		busObjContatto.create(c);
//	}
	
	
	
	
	
	
	
	
	
//	public ArrayList<DTOBase> elenco (CAP c){
////		return busObjCAP.readAll();
//		try{
//			return busObjCAP.readAll();
//		}
//		catch (NullPointerException e){
//			busObjCAP = new BOCap();
//			return busObjCAP.readAll();
//		}
//	}
	
	
	
	






	
	
	
	
//	public ArrayList<Indirizzo> elenco (Indirizzo i){
//		return busObjIndirizzo.readAll();
//	}
//public ArrayList<DTOBase> filtra (Indirizzo n){
//	ArrayList<DTOBase> lista=busObjIndirizzo.readAll();
//	ArrayList<DTOBase> listaFiltrata=new ArrayList<>();
//	
//	
//	for (int i =0; i< lista.size(); i++){
//		Indirizzo elem = (Indirizzo) lista.get(i);
//		if (elem.contains(n)){
//			listaFiltrata.add(elem);
//		}
//		
//	}
//	
//	return listaFiltrata;
//}
	
//	public ArrayList<DTOBase> filtra (Indirizzo i){
//		ArrayList<DTOBase> array;
//		
//		try{
//			array =busObjIndirizzo.readAll();
//		}catch(NullPointerException e){
//			busObjIndirizzo = new BOIndirizzo();
//			array =busObjIndirizzo.readAll();
//		}
//		
//		
//		String street="";
//		String myAddress=i.getStrada().getNome().toLowerCase();
//		
//		for (int index= array.size()-1; index>-1; index--){
////			if (!array.get(index).getStrada().getNome().contains(i.getStrada().getNome()))
////				array.remove(index);
//			
//			street = array.get(index).toString().toLowerCase();
//			
//			if (street.indexOf(myAddress)<0)
//				array.remove(index);
//			
////			if ((array.get(index).getStrada().getNome().indexOf(i.getStrada().getNome()) + array.get(index).getStrada().getNome().indexOf(i.getStrada().getNome().toUpperCase()))<0){
////				array.remove(index);
////			}			
//			
//				
//		}
//		
//		
//		return array;
//		
//	}
	
	
	
	

}
