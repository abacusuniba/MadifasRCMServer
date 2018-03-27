package b_tiers.b_business.b_services;

import java.util.ArrayList;
import java.util.Collections;

//import b_tiers.b_business.c_businessobject.BOAltro;
//import b_tiers.b_business.c_businessobject.BOCAP;
//import b_tiers.b_business.c_businessobject.BOCategoria;
//import b_tiers.b_business.c_businessobject.BOCausaleTrasporto;
//import b_tiers.b_business.c_businessobject.BOCitta;
//import b_tiers.b_business.c_businessobject.BOCliente;
//import b_tiers.b_business.c_businessobject.BOSubAgente;
//import b_tiers.b_business.c_businessobject.BOTipoAzienda;
//import b_tiers.b_business.c_businessobject.BOConsorzio;
//import b_tiers.b_business.c_businessobject.BODocumento;
//import b_tiers.b_business.c_businessobject.BOFormaGiuridica;
//import b_tiers.b_business.c_businessobject.BOFornitore;
//import b_tiers.b_business.c_businessobject.BOGruppoProdotto;
//import b_tiers.b_business.c_businessobject.BOGruppoSocietario;
//import b_tiers.b_business.c_businessobject.BOIndirizzo;
//import b_tiers.b_business.c_businessobject.BOIva;
//import b_tiers.b_business.c_businessobject.BOMagazzino;
//import b_tiers.b_business.c_businessobject.BOMinimo;
//import b_tiers.b_business.c_businessobject.BOMovimentazione;
//import b_tiers.b_business.c_businessobject.BONazione;
//import b_tiers.b_business.c_businessobject.BOPagamento;
//import b_tiers.b_business.c_businessobject.BOPercentualeCollaboratore;
//import b_tiers.b_business.c_businessobject.BOPercentualeFornitore;
//import b_tiers.b_business.c_businessobject.BOProdotto;
//import b_tiers.b_business.c_businessobject.BOProvincia;
//import b_tiers.b_business.c_businessobject.BORegione;
//import b_tiers.b_business.c_businessobject.BORuolo;
//import b_tiers.b_business.c_businessobject.BOSegnalatore;
//import b_tiers.b_business.c_businessobject.BOSettore;
//import b_tiers.b_business.c_businessobject.BOSottogruppoProdotto;
//import b_tiers.b_business.c_businessobject.BOTipoDocumento;
//import b_tiers.b_business.c_businessobject.BOTitolo;
//import b_tiers.b_business.c_businessobject.BOTrasporto;
//import b_tiers.b_business.c_businessobject.BOUM;
//import b_tiers.b_business.c_businessobject.BOValidita;
//import c_dto.a_abstract.Azienda;
//import c_dto.b_real.Altro;
//import c_dto.b_real.Archiviato;
//import c_dto.b_real.Attivo;
//import c_dto.b_real.CAP;
//import c_dto.b_real.Categoria;
//import c_dto.b_real.CausaleTrasporto;
//import c_dto.b_real.Citta;
//import c_dto.b_real.Cliente;
//import c_dto.b_real.CondizioneCommerciale;
//import c_dto.b_real.SubAgente;
//import c_dto.b_real.TipoAzienda;
//import c_dto.b_real.Consorzio;
//import c_dto.b_real.Documento;
//import c_dto.b_real.FormaGiuridica;
//import c_dto.b_real.Fornitore;
//import c_dto.b_real.GruppoProdotto;
//import c_dto.b_real.GruppoSocietario;
//import c_dto.b_real.Indirizzo;
//import c_dto.b_real.Iva;
//import c_dto.b_real.Magazzino;
//import c_dto.b_real.Minimo;
//import c_dto.b_real.Movimentazione;
//import c_dto.b_real.Nazione;
//import c_dto.b_real.NoteAzienda;
//import c_dto.b_real.Pagamento;
//import c_dto.b_real.PercentualeCollaboratore;
//import c_dto.b_real.PercentualeFornitore;
//import c_dto.b_real.Prodotto;
//import c_dto.b_real.Provincia;
//import c_dto.b_real.FormaGiuridica;
//import c_dto.b_real.Regione;
//import c_dto.b_real.Riferimento;
//import c_dto.b_real.Ruolo;
//import c_dto.b_real.SchedaNetto;
//import c_dto.b_real.Segnalatore;
//import c_dto.b_real.Settore;
//import c_dto.b_real.SottogruppoProdotto;
//import c_dto.b_real.TipoDocumento;
//import c_dto.b_real.Titolo;
//import c_dto.b_real.Trasporto;
//import c_dto.b_real.UM;
//import c_dto.b_real.Validita;


public class ASAdministrator extends AppServiceBase{
	//livello admin
//	private BOCategoria busObjCategoria;
//	private BOCliente busObjCliente;
//	private BOFornitore busObjFornitore;
//	private BOSubAgente busObjSubAgente;
//	private BOSegnalatore busObjSegnalatore;
//	private BOAltro busObjAltro;
//	private BOSettore busObjSettore;
//	private BOGruppoSocietario busObjGruppoSocietario;
//	private BOConsorzio busObjConsorzio;
//	private BOPagamento busObjPagamento;
//	private BOTrasporto busObjTrasporto;
//	private BOMinimo busObjMinimo;
//	private BOCAP busObjCAP;
//	private BOCitta busObjCitta;
//	private BOProvincia busObjProvincia;
//	private BORegione busObjRegione;
//	private BONazione busObjNazione;
//	private BOProdotto busObjProdotto;
//	private BOGruppoProdotto busObjGruppoProdotto;
//	private BOSottogruppoProdotto busObjSottogruppoProdotto;
//	private BOPercentualeFornitore busObjPercentualeFornitore;
//	private BOUM busObjUM;
//	private BOValidita busObjValidita;
//	private BOMagazzino busObjMagazzino;
//	private BOCausaleTrasporto busObjCausaleTrasporto;
//	private BODocumento busObjDocumento;
//	private BOTipoDocumento busObjTipoDocumento;
//	private BOMovimentazione busObjMovimentazione;
//	private BOTipoAzienda busObjTipoAzienda;
//	private BOIva busObjIva;
//	private BOPercentualeCollaboratore busObjPercentualeCollaboratore;
//	private BOFormaGiuridica busObjFormaGiuridica;
//	private BOTitolo busObjTitolo;
//	private BORuolo busObjRuolo;
///////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
//	
//	private BOUM busObjUM;
//	private BOIndirizzo busObjIndirizzo;
	
	public ASAdministrator(){
		
//		busObjCLiente= new BOCliente();
//		busObjFornitore= new BOFornitore();
//		busObjCollaboratore= new BOSubAgente();
//		busObjSegnalatore= new BOSegnalatore();
//		busObjAltro= new BOAltro();
//		busObjSettore = new BOSettore();
//		busObjGruppo = new BOGruppo();
//		busObjConsorzio = new BOConsorzio();
//		busObjPagamento=new BOPagamento();
//		busObjTrasporto= new BOTrasporto();
//		busObjMinimo = new BOMinimo();
//		busObjCAP = new BOCAP();
//		busObjCitta = new BOCitta();
//		busObjProvincia = new BOProvincia();
//		busObjRegione = new BORegione();
//		busObjNazione = new BONazione();
//		busObjProdotto = new BOProdotto();
//		busObjGruppoProdotto = new BOGruppoProdotto();
//		busObjSottogruppoProdotto = new BOSottogruppoProdotto();
//		busObjPercentualeFornitore = new BOPercentualeF();
//		busObjUM = new BOUM();
//		busObjValidita = new BOValidita();
//		busObjMagazzino = new BOMagazzino();
//		busObjCausaleTrasporto = new BOCausaleTrasporto();
//		busObjDocumento= new BODocumento();
//		busObjTipoDocumento= new BOTipoDocumento();
//		busObjIva = new BOIva();
//		busObjPercentualeC = new BOPercentualeC();
//		busObjFormaGiuridica = new BOFormaGiuridica();
///////////////////////////////////////////////////////////////////////////
		
		
//		
//		busObjIndirizzo = new BOIndirizzo();
		
	}

//	private void ____________________inizio_elenco(){}
//	
//	public ArrayList<Categoria> elenco(Categoria c){
//		
//		try{
//			return busObjCategoria.getArray();
//		}
//		catch (NullPointerException e){
//			busObjCategoria = new BOCategoria();
////			thread.start();
//			return busObjCategoria.getArray();
//		}
//
//	}
//	public ArrayList<Cliente> elenco(Cliente c){
//		
//		try{
//			return busObjCliente.getArray();
//		}
//		catch (NullPointerException e){
//			busObjCliente = new BOCliente();
////			thread.start();
//			return busObjCliente.getArray();
//		}
//
//	}
//
//	//	public Riferimento leggi(Riferimento c){
//		////		busObjCLiente.add(c);
//		//		
//		//		return (Riferimento) busObjCLiente.getSelected();
//		////		return (Cliente) busObjCLiente.getDao().read(c);
//		//////		return (Cliente) busObjCLiente.getMemory().get(c.getId());
//		//	}
//			
//		//	public void apri(Cliente c){
//		//		busObjCLiente.setSelected(c);
//		//	}
//		//	
//		//	public void apri(Riferimento c){
//		//		busObjCLiente.setSelected(c);
//		//	}
//			
//			
//	//		public ArrayList<Fornitore> elenco(Fornitore f){
//	//		//		return busObjFornitore.getArray();
//	//				try{
//	//					return busObjFornitore.getArray();
//	//				}
//	//				catch (NullPointerException e){
//	//					busObjFornitore = new BOFornitore();
//	//					return busObjFornitore.getArray();
//	//				}
//	//			}
//		public ArrayList<Fornitore> elenco(Fornitore c){
//				
//				try{
//					return busObjFornitore.getArray();
//				}
//				catch (NullPointerException e){
//					busObjFornitore = new BOFornitore();
//		//			thread.start();
//					return busObjFornitore.getArray();
//				}
//		
//			}
//		public ArrayList<SubAgente> elenco (SubAgente c){
////			return busObjCollaboratore.getArray();
//			try{
//				return busObjSubAgente.getArray();
//			}
//			catch (NullPointerException e){
//				busObjSubAgente = new BOSubAgente();
//				return busObjSubAgente.getArray();
//			}
//		}
//
//		public ArrayList<Segnalatore> elenco (Segnalatore c){
//			try{
//				return busObjSegnalatore.getArray();
//			}
//			catch (NullPointerException e){
//				busObjSegnalatore = new BOSegnalatore();
//				return busObjSegnalatore.getArray();
//			}
//		}
//		public ArrayList<Altro> elenco (Altro c){
//			try{
//				return busObjAltro.getArray();
//			}
//			catch (NullPointerException e){
//				busObjAltro = new BOAltro();
//				return busObjAltro.getArray();
//			}
//		}
//		public ArrayList<Pagamento> elenco (Pagamento c){
////			return busObjPagamento.getArray();
//			try{
//				return busObjPagamento.getArray();
//			}
//			catch (NullPointerException e){
//				busObjPagamento = new BOPagamento();
//				return busObjPagamento.getArray();
//			}
//		}
//		public ArrayList<Trasporto> elenco (Trasporto c){
////			return busObjTrasporto.getArray();
//			try{
//				return busObjTrasporto.getArray();
//			}
//			catch (NullPointerException e){
//				busObjTrasporto = new BOTrasporto();
//				return busObjTrasporto.getArray();
//			}
//		}
//		public ArrayList<Minimo> elenco (Minimo c){
////			return busObjMinimo.getArray();
//			try{
//				return busObjMinimo.getArray();
//			}
//			catch (NullPointerException e){
//				busObjMinimo = new BOMinimo();
//				return busObjMinimo.getArray();
//			}
//		}
//		public ArrayList<Settore> elenco (Settore c){
////			return busObjSettore.getArray();
//			try{
//				return busObjSettore.getArray();
//			}
//			catch (NullPointerException e){
//				busObjSettore = new BOSettore();
//				return busObjSettore.getArray();
//			}
//		}
//		public ArrayList<GruppoSocietario> elenco (GruppoSocietario c){
////			return busObjGruppo.getArray();
//			try{
//				return busObjGruppoSocietario.getArray();
//			}
//			catch (NullPointerException e){
//				busObjGruppoSocietario = new BOGruppoSocietario();
//				return busObjGruppoSocietario.getArray();
//			}
//		}
//		public ArrayList<Consorzio> elenco (Consorzio c){
////			return busObjConsorzio.getArray();
//			try{
//				return busObjConsorzio.getArray();
//			}
//			catch (NullPointerException e){
//				busObjConsorzio = new BOConsorzio();
//				return busObjConsorzio.getArray();
//			}
//		}
//		public ArrayList<PercentualeFornitore> elenco (PercentualeFornitore p){
////			return busObjPercentualeFornitore.getArray();
//			try{
//				return busObjPercentualeFornitore.getArray();
//			}
//			catch (NullPointerException e){
//				busObjPercentualeFornitore = new BOPercentualeFornitore();
//				return busObjPercentualeFornitore.getArray();
//			}
//		}
//////////////////////////////////////////////////////////////////////////////////////////////////		
//		public ArrayList<PercentualeCollaboratore> elenco (PercentualeCollaboratore p){
////			return busObjPercentualeC.getArray();
//			try{
//				return busObjPercentualeCollaboratore.getArray();
//			}
//			catch (NullPointerException e){
//				busObjPercentualeCollaboratore = new BOPercentualeCollaboratore();
//				return busObjPercentualeCollaboratore.getArray();
//			}
//		}
//		public ArrayList<Validita> elenco (Validita r){
////			return busObjValidita.getArray();
//			try{
//				return busObjValidita.getArray();
//			}
//			catch (NullPointerException e){
//				busObjValidita = new BOValidita();
//				return busObjValidita.getArray();
//			}
//		}
//		public ArrayList<FormaGiuridica> elenco (FormaGiuridica p){
////			return busObjFormaGiuridica.getArray();
//			try{
//				return busObjFormaGiuridica.getArray();
//			}
//			catch (NullPointerException e){
//				busObjFormaGiuridica = new BOFormaGiuridica();
//				return busObjFormaGiuridica.getArray();
//			}
//		}
//		public ArrayList<Nazione> elenco (Nazione c){
////			return busObjNazione.getArray();
//			try{
//				return busObjNazione.getArray();
//			}
//			catch (NullPointerException e){
//				busObjNazione = new BONazione();
//				return busObjNazione.getArray();
//			}
//		}
//		public ArrayList<Regione> elenco (Regione c){
////			return busObjRegione.getArray();
//			try{
//				return busObjRegione.getArray();
//			}
//			catch (NullPointerException e){
//				busObjRegione = new BORegione();
//				return busObjRegione.getArray();
//			}
//		}
//		public ArrayList<Provincia> elenco (Provincia c){
////			return busObjProvincia.getArray();
//			try{
//				return busObjProvincia.getArray();
//			}
//			catch (NullPointerException e){
//				busObjProvincia = new BOProvincia();
//				return busObjProvincia.getArray();
//			}
//		}
//		public ArrayList<Citta> elenco (Citta c){
////			return busObjCitta.getArray();
//			try{
//				return busObjCitta.getArray();
//			}
//			catch (NullPointerException e){
//				busObjCitta = new BOCitta();
//				return busObjCitta.getArray();
//			}
//		}
//		public ArrayList<Prodotto> elenco (Prodotto p){
////			return busObjProdotto.getArray();
//			try{
//				return busObjProdotto.getArray();
//			}
//			catch (NullPointerException e){
//				busObjProdotto = new BOProdotto();
//				return busObjProdotto.getArray();
//			}
//		}
//		public ArrayList<Magazzino> elenco (Magazzino r){
////			return busObjMagazzino.getArray();
//			try{
//				return busObjMagazzino.getArray();
//			}
//			catch (NullPointerException e){
//				busObjMagazzino = new BOMagazzino();
//				return busObjMagazzino.getArray();
//			}
//		}
//		public ArrayList<Documento> elenco (Documento p){
////			return busObjDocumento.getArray();
//			try{
//				return busObjDocumento.getArray();
//			}
//			catch (NullPointerException e){
//				busObjDocumento = new BODocumento();
//				
////				for (Documento d : busObjDocumento.getArray()){
////					System.out.println(d.getId() + ": " + d.getProdotti().size());
////				}
//				
//				return busObjDocumento.getArray();
//			}
//		}
//		public ArrayList<TipoDocumento> elenco (TipoDocumento p){
////			return busObjTipoDocumento.getArray();
//			try{
//				return busObjTipoDocumento.getArray();
//			}
//			catch (NullPointerException e){
//				busObjTipoDocumento = new BOTipoDocumento();
//				return busObjTipoDocumento.getArray();
//			}
//		}
//		public ArrayList<Movimentazione> elenco (Movimentazione p){
////			return busObjTipoDocumento.getArray();
//			try{
//				return busObjMovimentazione.getArray();
//			}
//			catch (NullPointerException e){
//				busObjMovimentazione = new BOMovimentazione();
//				return busObjMovimentazione.getArray();
//			}
//		}
//		public ArrayList<TipoAzienda> elenco (TipoAzienda p){
////			return busObjTipoDocumento.getArray();
//			try{
//				return busObjTipoAzienda.getArray();
//			}
//			catch (NullPointerException e){
//				busObjTipoAzienda = new BOTipoAzienda();
//				return busObjTipoAzienda.getArray();
//			}
//		}
//
//		private void ____________________fine_elenco(){}
//		private void ____________________inizio_crea(){}
//		public void crea(Cliente c){
//			c.setStato(Attivo.getInstance());
//			busObjCliente.add(c);
//		}
//
//		public void crea(Fornitore c){
//			c.setStato(Attivo.getInstance());
//			busObjFornitore.add(c);
//		}
//
//		public void crea(SubAgente c){
//			c.setStato(Attivo.getInstance());
//			busObjSubAgente.add(c);
//		}
//
//		public void crea(Segnalatore c){
//			c.setStato(Attivo.getInstance());
//			busObjSegnalatore.add(c);
//		}
//		public void crea(Altro c){
//			c.setStato(Attivo.getInstance());
//			busObjAltro.add(c);
//		}
//		public void crea(Pagamento c){
//			c.setStato(Attivo.getInstance());
//			busObjPagamento.add(c);
//		}
//		public void crea(Trasporto c){
//			c.setStato(Attivo.getInstance());
//			busObjTrasporto.add(c);
//		}
//		public void crea(Minimo c){
//			c.setStato(Attivo.getInstance());
//			busObjMinimo.add(c);
//		}
//		public void crea(Settore c){
//			c.setStato(Attivo.getInstance());
//			busObjSettore.add(c);
//		}
//		public void crea(GruppoSocietario c){
//			c.setStato(Attivo.getInstance());
//			busObjGruppoSocietario.add(c);
//		}
//		public void crea(Consorzio c){
//			c.setStato(Attivo.getInstance());
//			busObjConsorzio.add(c);
//		}
//		public void crea(PercentualeFornitore c){
//			c.setStato(Attivo.getInstance());
//			busObjPercentualeFornitore.add(c);
//		}
//		public void crea(PercentualeCollaboratore c){
//			c.setStato(Attivo.getInstance());
//			busObjPercentualeCollaboratore.add(c);
//		}
//		public void crea(Validita c){
//			c.setStato(Attivo.getInstance());
//			busObjValidita.add(c);
//		}
//		public void crea(FormaGiuridica c){
//			c.setStato(Attivo.getInstance());
//			busObjFormaGiuridica.add(c);
//		}
//		public void crea(Nazione c){
//			c.setStato(Attivo.getInstance());
//			busObjNazione.add(c);
//		}
//		public void crea(Regione c){
//			c.setStato(Attivo.getInstance());
//			busObjRegione.add(c);
//		}
//		public void crea(Provincia c){
//			c.setStato(Attivo.getInstance());
//			busObjProvincia.add(c);
//		}
//		public void crea(Citta c){
//			c.setStato(Attivo.getInstance());
//			busObjCitta.add(c);
//		}
//		public void crea(Prodotto c){
//			c.setStato(Attivo.getInstance());
//			busObjProdotto.add(c);
//		}
//		public void crea(Magazzino c){
//			c.setStato(Attivo.getInstance());
//			busObjMagazzino.add(c);
//		}
//		public void crea(Documento c){
//			c.setStato(Attivo.getInstance());
//			busObjDocumento.add(c);
//		}
//		public void crea(TipoDocumento c){
//			c.setStato(Attivo.getInstance());
//			busObjTipoDocumento.add(c);
//		}
//
//		private void ____________________fine_crea(){}
//		private void ____________________inizio_aggiorna(){}
//		public void aggiorna(Cliente c){
//					busObjCliente.update(c);
//		}
//		public void aggiorna(Fornitore c){
//			busObjFornitore.update(c);
//		}
//		public void aggiorna(SubAgente c){
//			busObjSubAgente.update(c);
//		}
//		public void aggiorna(Segnalatore c){
//			busObjSegnalatore.update(c);
//		}
//		public void aggiorna(Altro c){
//			busObjAltro.update(c);
//		}
//		public void aggiorna(Pagamento c){
//			busObjPagamento.update(c);
//		}
//		public void aggiorna(Trasporto c){
//			busObjTrasporto.update(c);
//		}
//		public void aggiorna(Minimo c){
//			busObjMinimo.update(c);
//		}
//		public void aggiorna(Settore c){
//			busObjSettore.update(c);
//		}
//		public void aggiorna(GruppoSocietario c){
//			busObjGruppoSocietario.update(c);
//		}
//		public void aggiorna(Consorzio c){
//			busObjConsorzio.update(c);
//		}
//		public void aggiorna(PercentualeFornitore c){
//			busObjPercentualeFornitore.update(c);
//		}
//		public void aggiorna(PercentualeCollaboratore c){
//			busObjPercentualeCollaboratore.update(c);
//		}
//		public void aggiorna(Validita c){
//			busObjValidita.update(c);
//		}
//		public void aggiorna(FormaGiuridica c){
//			busObjFormaGiuridica.update(c);
//		}
//		public void aggiorna(Nazione c){
//			busObjNazione.update(c);
//		}
//		public void aggiorna(Regione c){
//			busObjRegione.update(c);
//		}
//		public void aggiorna(Provincia c){
//			busObjProvincia.update(c);
//		}
//		public void aggiorna(Citta c){
//			busObjCitta.update(c);
//		}
//		public void aggiorna(Prodotto c){
//			busObjProdotto.update(c);
//		}
//		public void aggiorna(Magazzino c){
//			busObjMagazzino.update(c);
//		}
//		public void aggiorna(Documento c){
//			busObjDocumento.update(c);
//		}
//		public void aggiorna(TipoDocumento c){
//			busObjTipoDocumento.update(c);
//		}
//		
//		private void ____________________fine_aggiorna(){}
//		private void ____________________inizio_dimentica(){}
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
//		private void ____________________fine_dimentica(){}
//		private void ____________________inizio_cancella(){}
//		public void cancella(Cliente c){
//			busObjCliente.delete(c);
//		}
//		public void cancella(Fornitore c){
//			busObjFornitore.delete(c);
//		}
//		public void cancella(SubAgente c){
//			busObjSubAgente.delete(c);
//		}
//		public void cancella(Segnalatore c){
//			busObjSegnalatore.delete(c);
//		}
//		public void cancella(Altro c){
//			busObjAltro.delete(c);
//		}
//		public void cancella(Pagamento c){
//			busObjPagamento.delete(c);
//		}
//		public void cancella(Trasporto c){
//			busObjTrasporto.delete(c);
//		}
//		public void cancella(Minimo c){
//			busObjMinimo.delete(c);
//		}
//		public void cancella(Settore c){
//			busObjSettore.delete(c);
//		}
//		public void cancella(GruppoSocietario c){
//			busObjGruppoSocietario.delete(c);
//		}
//		public void cancella(Consorzio c){
//			busObjConsorzio.delete(c);
//		}
//		public void cancella(PercentualeFornitore c){
//			busObjPercentualeFornitore.delete(c);
//		}
//		public void cancella(PercentualeCollaboratore c){
//			busObjPercentualeCollaboratore.delete(c);
//		}
//		public void cancella(Validita c){
//			busObjValidita.delete(c);
//		}
//		public void cancella(FormaGiuridica c){
//			busObjFormaGiuridica.delete(c);
//		}
//		public void cancella(Nazione c){
//			busObjNazione.delete(c);
//		}
//		public void cancella(Regione c){
//			busObjRegione.delete(c);
//		}
//		public void cancella(Provincia c){
//			busObjProvincia.delete(c);
//		}
//		public void cancella(Citta c){
//			busObjCitta.delete(c);
//		}
//		public void cancella(Prodotto c){
//			busObjProdotto.delete(c);
//		}
//		public void cancella(Magazzino c){
//			busObjMagazzino.delete(c);
//		}
//		public void cancella(Documento c){
//			busObjDocumento.delete(c);
//		}
//		public void cancella(TipoDocumento c){
//			busObjTipoDocumento.delete(c);
//		}
//
//		private void ____________________fine_cancella(){}
//		private void ____________________inizio_leggi(){}
//		public Cliente leggi(Cliente c){
//			
//			
//			
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			Cliente cl = (Cliente) busObjCliente.getMemory().get(c.getId());
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
////				e.printStackTrace();
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
//			//leggo dalla memoria "centrale" (che si trova, ovviamente, in RAM)
//			TipoDocumento cl = (TipoDocumento) busObjTipoDocumento.getMemory().get(c.getId());
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
//		private void ____________________fine_leggi(){}
//		private void ____________________inizio_filtra(){}
//		public ArrayList<Cliente> filtra (Cliente i){
//			ArrayList<Cliente> array;
//			
//			
//				array =busObjCliente.getArray();
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
//				array =busObjFornitore.getArray();
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
//				array =busObjSubAgente.getArray();
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
//				array =busObjSegnalatore.getArray();
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
//				array =busObjAltro.getArray();
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
//				array =busObjPagamento.getArray();
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
//				array =busObjTrasporto.getArray();
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
//				array =busObjMinimo.getArray();
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
//				array =busObjSettore.getArray();
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
//				array =busObjGruppoSocietario.getArray();
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
//				array =busObjConsorzio.getArray();
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
//				array =busObjPercentualeFornitore.getArray();
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
//				array =busObjPercentualeCollaboratore.getArray();
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
//				array =busObjValidita.getArray();
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
//				array =busObjFormaGiuridica.getArray();
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
//				array =busObjNazione.getArray();
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
//				array =busObjRegione.getArray();
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
//				array =busObjProvincia.getArray();
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
//				array =busObjCitta.getArray();
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
//			ArrayList<Prodotto> array;
//			
//				array =busObjProdotto.getArray();
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
//		public ArrayList<Magazzino> filtra (Magazzino i){
//			ArrayList<Magazzino> array;
//			
//				array =busObjMagazzino.getArray();
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
//				array =busObjDocumento.getArray();
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
//				array =busObjTipoDocumento.getArray();
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
//		private void ____________________fine_filtra(){}
//		private void _0000000000000000000note_azienda(){}
//	public void crea(NoteAzienda rif){
//		
//		if (rif.getAzienda() instanceof Cliente){
//			//seleziono l'azienda	
//			((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).addNote(rif);
//		}
//		else if (rif.getAzienda() instanceof Fornitore){
//			//seleziono l'azienda	
//			((Fornitore) busObjFornitore.getMemory().get(rif.getAzienda().getId())).addNote(rif);
//		}
//		else if (rif.getAzienda() instanceof SubAgente){
//			//seleziono l'azienda	
//			((SubAgente) busObjSubAgente.getMemory().get(rif.getAzienda().getId())).addNote(rif);
//		}
//		else if (rif.getAzienda() instanceof Segnalatore){
//			//seleziono l'azienda	
//			((Segnalatore) busObjSegnalatore.getMemory().get(rif.getAzienda().getId())).addNote(rif);
//		}
//		else if (rif.getAzienda() instanceof Altro){
//			//seleziono l'azienda	
//			((Altro) busObjAltro.getMemory().get(rif.getAzienda().getId())).addNote(rif);
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
//	private void _1111111111111111111note_azienda(){}
//	private void _0000000000000000000riferimenti(){}
//	public void crea(Riferimento rif){
//		
//		Azienda c=rif.getAzienda();
//		
//		if (c instanceof Cliente){
//			c = (Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.addRiferimento(rif);
//				busObjCliente.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().addRiferimento(rif);
//				busObjCliente.getTemp().add(rif.getAzienda());
//			}
//		}
//		else if (c instanceof Fornitore){
//			c = (Fornitore) busObjFornitore.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.addRiferimento(rif);
//				busObjFornitore.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().addRiferimento(rif);
//				busObjFornitore.getTemp().add(rif.getAzienda());
//			}
//		}
//		else if (c instanceof SubAgente){
//			c = (SubAgente) busObjSubAgente.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.addRiferimento(rif);
//				busObjSubAgente.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().addRiferimento(rif);
//				busObjSubAgente.getTemp().add(rif.getAzienda());
//			}
//		}
//		else if (c instanceof Segnalatore){
//			c = (Segnalatore) busObjSegnalatore.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.addRiferimento(rif);
//				busObjSegnalatore.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().addRiferimento(rif);
//				busObjSegnalatore.getTemp().add(rif.getAzienda());
//			}
//		}
//		else if (c instanceof Altro){
//			c = (Altro) busObjAltro.getMemory().get(rif.getAzienda().getId());
//			try{
//				c.addRiferimento(rif);
//				busObjAltro.getMemory().put(c.getId(), c);
//			}
//			catch (Exception e){
//				rif.getAzienda().addRiferimento(rif);
//				busObjAltro.getTemp().add(rif.getAzienda());
//			}
//		}
//		
//				
//	}
//
//	public void aggiorna(Riferimento rif){
//			((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).modificaRiferimento(rif);
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
//				busObjCliente.getTemp().add(rif.getAzienda());
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
//				busObjFornitore.getTemp().add(rif.getAzienda());
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
//				busObjSubAgente.getTemp().add(rif.getAzienda());
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
//				busObjSegnalatore.getTemp().add(rif.getAzienda());
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
//				busObjAltro.getTemp().add(rif.getAzienda());
//			}
//		}
//		
//		
//		
//				
//				
//			}
//
//	private void _1111111111111111111riferimenti(){}
//
//	public void crea(CondizioneCommerciale rif){
//		
//		((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).addCondizione(rif);
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
//		((Cliente) busObjCliente.getMemory().get(rif.getAzienda().getId())).addScheda(rif);
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
//	private void _01(){}
//	private void ____________________2(){}
//	//	public Riferimento leggi(Riferimento c){
//	////		busObjCLiente.add(c);
//	//		
//	//		return (Riferimento) busObjCLiente.getSelected();
//	////		return (Cliente) busObjCLiente.getDao().read(c);
//	//////		return (Cliente) busObjCLiente.getMemory().get(c.getId());
//	//	}
//		
//	//	public void apri(Cliente c){
//	//		busObjCLiente.setSelected(c);
//	//	}
//	//	
//	//	public void apri(Riferimento c){
//	//		busObjCLiente.setSelected(c);
//	//	}
//		
//		
//private void ____________________3(){}
//
//	
//
//	
//	
////	public Riferimento leggi(Riferimento c){
//////		busObjCLiente.add(c);
////		
////		return (Riferimento) busObjCLiente.getSelected();
//////		return (Cliente) busObjCLiente.getDao().read(c);
////////		return (Cliente) busObjCLiente.getMemory().get(c.getId());
////	}
//	
////	public void apri(Cliente c){
////		busObjCLiente.setSelected(c);
////	}
////	
////	public void apri(Riferimento c){
////		busObjCLiente.setSelected(c);
////	}
//	
//	
////	public void crea(Fornitore f){
////		busObjFornitore.add(f);
////	}
//	
////	public void crea(Collaboratore c){
////		busObjContatto.add(c);
////	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public ArrayList<CAP> elenco (CAP c){
////		return busObjCAP.getArray();
//		try{
//			return busObjCAP.getArray();
//		}
//		catch (NullPointerException e){
//			busObjCAP = new BOCAP();
//			return busObjCAP.getArray();
//		}
//	}
//	
//	
//	
//	
//
//
//	public ArrayList<GruppoProdotto> elenco (GruppoProdotto p){
////		return busObjGruppoProdotto.getArray();
//		try{
//			return busObjGruppoProdotto.getArray();
//		}
//		catch (NullPointerException e){
//			busObjGruppoProdotto = new BOGruppoProdotto();
//			return busObjGruppoProdotto.getArray();
//		}
//	}
//
//	public ArrayList<SottogruppoProdotto> elenco (SottogruppoProdotto p){
////		return busObjSottogruppoProdotto.getArray();
//		try{
//			return busObjSottogruppoProdotto.getArray();
//		}
//		catch (NullPointerException e){
//			busObjSottogruppoProdotto = new BOSottogruppoProdotto();
//			return busObjSottogruppoProdotto.getArray();
//		}
//	}
//
//
//	public ArrayList<UM> elenco (UM r){
////		return busObjUM.getArray();
//		try{
//			return busObjUM.getArray();
//		}
//		catch (NullPointerException e){
//			busObjUM = new BOUM();
//			return busObjUM.getArray();
//		}
//	}
//
//
//
//	public ArrayList<CausaleTrasporto> elenco (CausaleTrasporto r){
////		return busObjCausaleTrasporto.getArray();
//		try{
//			return busObjCausaleTrasporto.getArray();
//		}
//		catch (NullPointerException e){
//			busObjCausaleTrasporto = new BOCausaleTrasporto();
//			return busObjCausaleTrasporto.getArray();
//		}
//	}
//
//	
//	
//	public ArrayList<Iva> elenco (Iva p){
////		return busObjIva.getArray();
//		try{
//			return busObjIva.getArray();
//		}
//		catch (NullPointerException e){
//			busObjIva = new BOIva();
//			return busObjIva.getArray();
//		}
//	}
//
//
//
//	public ArrayList<Titolo> elenco (Titolo p){
////		return busObjFormaGiuridica.getArray();
//		try{
//			return busObjTitolo.getArray();
//		}
//		catch (NullPointerException e){
//			busObjTitolo = new BOTitolo();
//			return busObjTitolo.getArray();
//		}
//	}
//
//	public ArrayList<Ruolo> elenco (Ruolo p){
////		return busObjFormaGiuridica.getArray();
//		try{
//			return busObjRuolo.getArray();
//		}
//		catch (NullPointerException e){
//			busObjRuolo = new BORuolo();
//			return busObjRuolo.getArray();
//		}
//	}
//
//	
//	
//	
//	
////	public ArrayList<Indirizzo> elenco (Indirizzo i){
////		return busObjIndirizzo.getArray();
////	}
//	
//	public ArrayList<Indirizzo> filtra (Indirizzo i){
//		ArrayList<Indirizzo> array;
//		
//		try{
//			array =busObjIndirizzo.getArray();
//		}catch(NullPointerException e){
//			busObjIndirizzo = new BOIndirizzo();
//			array =busObjIndirizzo.getArray();
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

	
	
//	ASThread thread = new ASThread();
	
//	public class ASThread extends Thread{
//		
//		@Override
//		public void run() {
//			loadClienti();
//			
//			
////			busObjCliente : BOCliente
//			
//			
////			busObjFornitore : BOFornitore
////			busObjCollaboratore : BOSubAgente
////			busObjSegnalatore : BOSegnalatore
////			busObjAltro : BOAltro
////			busObjSettore : BOSettore
////			busObjGruppo : BOGruppo
////			busObjConsorzio : BOConsorzio
////			busObjPagamento : BOPagamento
////			busObjTrasporto : BOTrasporto
////			busObjMinimo : BOMinimo
////			busObjCAP : BOCAP
////			busObjCitta : BOCitta
////			busObjProvincia : BOProvincia
////			busObjRegione : BORegione
////			busObjNazione : BONazione
////			busObjProdotto : BOProdotto
////			busObjGruppoProdotto : BOGruppoProdotto
////			busObjSottogruppoProdotto : BOSottogruppoProdotto
////			busObjPercentualeFornitore : BOPercentualeF
////			busObjUM : BOUM
////			busObjValidita : BOValidita
////			busObjMagazzino : BOMagazzino
////			busObjCausaleTrasporto : BOCausaleTrasporto
////			busObjDocumento : BODocumento
////			busObjTipoDocumento : BOTipoDocumento
////			busObjIva : BOIva
////			busObjPercentualeC : BOPercentualeC
////			busObjFormaGiuridica : BOFormaGiuridica
////			busObjTitolo : BOTitolo
////			busObjRuolo : BORuolo
////			busObjIndirizzo : BOIndirizzo			
//			
//
//		}
//		
//		
//		public void loadClienti(){
//			
//			while (busObjCliente==null){
//				
//			}
//			
//			for (Cliente c : busObjCliente.getArray()){
//				busObjCliente.getMemory().put(c.getId(), busObjCliente.getDao().read(c));
//			}
//		}
//		
//	}
	
	
	
}
