package c_dto.a_abstract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import c_dto.b_real.CentralinoAzienda;
import c_dto.b_real.Cliente;
import c_dto.b_real.EmailAzienda;
import c_dto.b_real.FaxAzienda;
import c_dto.b_real.FormaGiuridica;
import c_dto.b_real.NoteAzienda;
import c_dto.b_real.NoteContatto;
import c_dto.b_real.Riferimento;
import c_dto.b_real.Sito;
import c_dto.b_real.Strada;



//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class,
//		  property = "id")
public  abstract class Azienda extends Primary{

	private String nome= new String();

	private String secondonome= new String();

	private String piva= new String();

	private String codfisc= new String();
	
//	@Deprecated
//	private String sito= new String();//rimuovere
	 private List<Sito> siti=new ArrayList<>();
	public List<Sito> getSiti() {
		return siti;
	}

	public void setSiti(List<Sito> siti) {
//		this.siti = siti;
		this.siti = new ArrayList<>();
		this.siti.addAll(siti);
	}
	
	 private FormaGiuridica forma= new FormaGiuridica();


	private List<NoteAzienda> note=new ArrayList<>();
//	@JsonIgnore private List<NoteAzienda> noteCancellate=new ArrayList<>();
//	@JsonIgnore private List<NoteAzienda> noteModificate=new ArrayList<>();
//	@JsonIgnore private List<NoteAzienda> noteNuove=new ArrayList<>();
	 private List<CentralinoAzienda> centralino=new ArrayList<>();
	 private List<EmailAzienda> email=new ArrayList<>();

	

//	@JsonIgnore 
	private List<Strada> indirizzi=new ArrayList<>();
//	@JsonIgnore private List<Strada> indirizziRimossi=new ArrayList<>();
//	@JsonIgnore private List<Strada> indirizziAggiunti=new ArrayList<>();

	 private List<FaxAzienda> fax=new ArrayList<>();
	private List<Riferimento> riferimenti=new ArrayList<>();

//	@JsonIgnore private List<Riferimento> rimossi=new ArrayList<>();
//
//	@JsonIgnore private List<Riferimento> modificati=new ArrayList<>();
//
//	@JsonIgnore private List<Riferimento> nuovi=new ArrayList<>();

	
	@Override
	public int compareTo(DTOBase o) {
		Azienda n = (Azienda) o;
		int res = getNome().compareTo(n.getNome());// + super.compareTo(o);
		
		return res;
	}

	public boolean contains(Azienda elem) {
		
	String thisNome = getNome()
			+ getSecondoNome()
			+ getPartitaIva()
			+ getCodiceFiscale();
//			+ getForma().toString();
	
	
	for (Strada i : indirizzi) {
		thisNome+= i.getCap().getCitta().getNome();
	}
	
	for (NoteAzienda nota: getNote()){
		thisNome+= nota.getNote();
		thisNome+= nota.getData();
	}
	
	for(Riferimento rif : getRiferimenti()){
		thisNome+= rif.getNome() + ""
				+ rif.getCognome()
//				+ rif.getTitolo().getTitolo()
//				+ rif.getRuolo().getRuolo()
				;
		
		for (NoteContatto nota: rif.getNote()){
			thisNome+= nota.getNote();
			thisNome+= nota.getData();
			
		}
		
	}
	thisNome= thisNome.replace(".", "").toLowerCase();
	
	String thatNome = elem.getNome().replace(".", "").toLowerCase();
//	return (getNome().toLowerCase().indexOf(elem.getNome())+getSigla().toLowerCase().indexOf(elem.getSigla())>=0) ? true : false;
	return (thisNome.indexOf(thatNome)>=0) ? true : false;
}
//		public boolean contains(String s){
//			boolean contain=false;
////			UTILIZZATI PER IL FILTRAGGIO
////			nome : String
////			secondoNome : String
////			piva : String
////			codfisc : String
////			sito : String
////			siti : List<Sito>
////			indirizzi : List<Strada>			
////			consorzio : Consorzio
////			gruppo : GruppoSocietario
////			forma : FormaGiuridica
////			settori : List<Settore>
////			riferimenti : List<Riferimento>
////			modificati : List<Riferimento>
////			nuovi : List<Riferimento>
////			note : List<NoteAzienda>
////			noteModificate : List<NoteAzienda>
////			noteNuove : List<NoteAzienda>
//			
//////			String stringForFilter = nome + secondoNome + piva + codfisc + sito 
//////					+ consorzio.getNome() + gruppo.getNome() + forma.getNome();
////			String stringForFilter = nome + secondoNome + piva + codfisc + sito + forma.getNome();
//			String stringForFilter = nome + secondoNome + piva + codfisc + sito;
//			try{
//				stringForFilter += forma.getNome();
//			}
//			catch (Exception e){
//				
//			}
//			
//			
//			
//			/* /
//			for (Sito c : siti){
//				stringForFilter += c.getNome();
//			}
//			
//			for (Settore c : settori){
//				stringForFilter += c.getNome();
//			}
//			
//			for(Strada c: indirizzi){
//				stringForFilter += c.getStrada().getNome() 
//						+ c.getCivico().getNumero() 
//						+ c.getStrada().getCapcitta().getCap().getNome() 
//						+ c.getStrada().getCapcitta().getCitta().getNome()
//						+ c.getStrada().getCapcitta().getCitta().getProvincia().getNome()
//						+ c.getStrada().getCapcitta().getCitta().getProvincia().getSigla()
//						+ c.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNome()
//						+ c.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNazione().getNome();
//			}
//			
//			for(Riferimento c: riferimenti){
////				UTILIZZATI PER IL FILTRAGGIO
////				nome : String
////				cognome : String
////				titolo : Titolo
////				ruolo : Ruolo
////				note : List<NoteContatto>
////				indirizzi : List<Strada>				
//				stringForFilter += c.getCognome() 
//						+ c.getNome()
//						+ c.getTitolo().getTitolo()
//						+ c.getRuolo().getRuolo();
//				
//				
//				for (NoteContatto c1 : c.getNote()){
//					stringForFilter += c1.getNote(); 
//				}
//				
//				for (Strada c1 : c.getIndirizzi()){
//					stringForFilter += c1.getStrada().getNome() 
//							+ c1.getCivico().getNumero() 
//							+ c1.getStrada().getCapcitta().getCap().getNome() 
//							+ c1.getStrada().getCapcitta().getCitta().getNome()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getNome()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getSigla()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNome()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNazione().getNome();
//				}
//				
////				NON UTILIZZATI PER IL FILTRAGGIO
////				cellulare : List<CellulareContatto>
////				email : List<EmailContatto>
////				fax : List<FaxContatto>
////				ufficio : List<CentralinoContatto>
//				
//				
//				
//			}
//			for(Riferimento c: modificati){
////				UTILIZZATI PER IL FILTRAGGIO
////				nome : String
////				cognome : String
////				titolo : Titolo
////				ruolo : Ruolo
////				note : List<NoteContatto>
////				indirizzi : List<Strada>				
//				stringForFilter += c.getCognome() 
//						+ c.getNome()
//						+ c.getTitolo().getTitolo()
//						+ c.getRuolo().getRuolo();
//				
//				
//				for (NoteContatto c1 : c.getNote()){
//					stringForFilter += c1.getNote(); 
//				}
//				
//				for (Strada c1 : c.getIndirizzi()){
//					stringForFilter += c1.getStrada().getNome() 
//							+ c1.getCivico().getNumero() 
//							+ c1.getStrada().getCapcitta().getCap().getNome() 
//							+ c1.getStrada().getCapcitta().getCitta().getNome()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getNome()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getSigla()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNome()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNazione().getNome();
//				}
//				
////				NON UTILIZZATI PER IL FILTRAGGIO
////				cellulare : List<CellulareContatto>
////				email : List<EmailContatto>
////				fax : List<FaxContatto>
////				ufficio : List<CentralinoContatto>
//				
//			}
//			for(Riferimento c: nuovi){
////				UTILIZZATI PER IL FILTRAGGIO
////				nome : String
////				cognome : String
////				titolo : Titolo
////				ruolo : Ruolo
////				note : List<NoteContatto>
////				indirizzi : List<Strada>				
//				stringForFilter += c.getCognome() 
//						+ c.getNome()
//						+ c.getTitolo().getTitolo()
//						+ c.getRuolo().getRuolo();
//				
//				
//				for (NoteContatto c1 : c.getNote()){
//					stringForFilter += c1.getNote(); 
//				}
//				
//				for (Strada c1 : c.getIndirizzi()){
//					stringForFilter += c1.getStrada().getNome() 
//							+ c1.getCivico().getNumero() 
//							+ c1.getStrada().getCapcitta().getCap().getNome() 
//							+ c1.getStrada().getCapcitta().getCitta().getNome()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getNome()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getSigla()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNome()
//							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNazione().getNome();
//				}
//				
////				NON UTILIZZATI PER IL FILTRAGGIO
////				cellulare : List<CellulareContatto>
////				email : List<EmailContatto>
////				fax : List<FaxContatto>
////				ufficio : List<CentralinoContatto>
//				
//			}
//			for (NoteAzienda c : note){
//				stringForFilter += c.getNote(); 
//			}
//			
//			for (NoteAzienda c : noteModificate){
//				stringForFilter += c.getNote(); 
//			}
//			
//			for (NoteAzienda c : noteNuove){
//				stringForFilter += c.getNote(); 
//			}
//			
//			//NON UTILIZZATI PER IL FILTRAGGIO
////			rimossi : List<Riferimento>
////			condizioni : List<CondizioneCommerciale>
////			condCancellate : List<CondizioneCommerciale>
////			condModificate : List<CondizioneCommerciale>
////			condNuove : List<CondizioneCommerciale>
////			scheda : List<SchedaNetto>
////			schCancellate : List<SchedaNetto>
////			schModificate : List<SchedaNetto>
////			schNuove : List<SchedaNetto>
////			noteCancellate : List<NoteAzienda>
////			centralino : List<CentralinoAzienda>
////			email : List<EmailAzienda>
////			fax : List<FaxAzienda>
//			
//			
//			/**/
//			stringForFilter=stringForFilter.toLowerCase();
//			
//			if (stringForFilter.indexOf(s.toLowerCase())>-1)
//				contain=true;
//			
//			
//			return contain;
//
//		}


		



//	public void setScheda(List<SchedaNetto> scheda) {
//		this.scheda.clear();
//		this.scheda.addAll(scheda);
//
//		schCancellate.clear();
//		schNuove.clear();
//		schModificate.clear();
//	}


//	public void addRiferimento(Riferimento rif) {
//		nuovi.add(rif);
//	}
//	
//	public void addNote(NoteAzienda rif) {
//		noteNuove.add(rif);
//	}
//	public void rimuoviNote(NoteAzienda rif) {
//		noteCancellate.add(rif);
//		
//		
//		noteModificate.remove(rif);
//		noteNuove.remove(rif);
//		note.remove(rif);
//		
//	}
//	public void modificaNote(NoteAzienda rif){
//		if (noteModificate.contains(rif)){
//			noteModificate.remove(rif);
//		}
//		noteModificate.add(rif);
//		
//		noteNuove.remove(rif);
//		note.remove(rif);
//	}
	
//	public void addScheda(SchedaNetto rif) {
//		schNuove.add(rif);
//	}
//	
//	
//	public void rimuoviScheda(SchedaNetto rif) {
//		schCancellate.add(rif);
//		
//		
//		schModificate.remove(rif);
//		schNuove.remove(rif);
//		scheda.remove(rif);
//		
//	}
//	
//	public void modificaScheda(SchedaNetto rif){
//		if (schModificate.contains(rif)){
//			schModificate.remove(rif);
//		}
//		schModificate.add(rif);
//		
//		schNuove.remove(rif);
//		scheda.remove(rif);
//	}
	
	
	
	
	
//	public void rimuoviRiferimento(Riferimento rif) {
//		rimossi.add(rif);
//		
//		
//		modificati.remove(rif);
//		nuovi.remove(rif);
//		riferimenti.remove(rif);
//		
//	}
	
//	public void addCondizione(CondizioneCommerciale rif) {
//		condNuove.add(rif);
//	}
//	
//	public void rimuoviCondizione(CondizioneCommerciale rif) {
////		rimossi.add(rif);
//		condCancellate.add(rif);
//		
////		modificati.remove(rif);
//		condModificate.remove(rif);
////		nuovi.remove(rif);
//		condNuove.remove(rif);
////		riferimenti.remove(rif);
//		condizioni.remove(rif);
//		
//	}
	
	public void modificaRiferimento(Riferimento rif){
		
		int index = riferimenti.indexOf(rif);
		
		riferimenti.set(index, rif);
		
		
//		if (modificati.contains(rif)){
//			modificati.remove(rif);
//		}
//		modificati.add(rif);
//		
//		nuovi.remove(rif);
////		riferimenti.remove(rif);
//		riferimenti.removeAll(modificati);
	}
	
//	public void modificaCondizione(CondizioneCommerciale rif){
//		if (condModificate.contains(rif)){
//			condModificate.remove(rif);
//		}
//		condModificate.add(rif);
//		
//		condNuove.remove(rif);
//		condizioni.remove(rif);
//	}
	
	
	//	public List<SchedaNetto> getScheda() {
//		return scheda;
//	}
//	public List<SchedaNetto> getScheda() {
//		List<SchedaNetto> myList= new ArrayList<>();
//		
//		myList.addAll(scheda);
//		myList.addAll(schModificate);
//		myList.addAll(schNuove);
//		
//		Collections.sort(myList);
//		
////		return riferimenti;
//		return myList;
//	}




//	public Consorzio getConsorzio() {
//		return consorzio;
//	}
//
//	public void setConsorzio(Consorzio consorzio) {
//		this.consorzio = consorzio;
//	}
//
//
//
//
//	public GruppoSocietario getGruppo() {
//		return gruppo;
//	}
//
//	public void setGruppo(GruppoSocietario gruppo) {
//		this.gruppo = gruppo;
//	}




//	public List<Settore> getSettori(){
//		return settori;
//	}
//	
//	
//	
////		@OneToMany(fetch=FetchType.EAGER, mappedBy="azienda", cascade=CascadeType.ALL)
//
//		public void setSettori(List<Settore> settori) {
////		this.settori = settori;
//		this.settori.clear();
//		this.settori.addAll(settori);
//		
//	}




		public List<EmailAzienda> getEmail() {
		return email;
	}

	public void setEmail(List<EmailAzienda> email) {
//		if (!areEquals(this.email, email)){
			this.email = new ArrayList<>();
			this.email.addAll(email);
//			List<EmailAzienda> rem = new ArrayList<>();
//			
//			for (EmailAzienda f : this.email){
//				if (!email.contains(f)){
////					this.email.remove(f);
//					rem.add(f);
//				}
//			}
//			
////			this.email.removeAll(rem);//rimuovo quelli "eliminati"
////			email.removeAll(this.email);//rimuovo quelli gi� presenti
////			this.email.addAll(email);//aggiungo quelli "nuovi"
//			this.email = new ArrayList<>();
//			this.email.addAll(email);
//			
//			for (EmailAzienda f : rem){
////				int index = this.email.indexOf(f);
//				f.setAzienda(null);
////				this.email.set(index, f);
//			}
//			
//			
//		}
	}

    
//	private void updateList(List<? extends DTOBase> src, List<? extends DTOBase> dst){
//		List<? extends DTOBase> rimossi = new ArrayList<>();
//	
//		for (DTOBase f : dst){
//		if (!src.contains(f)){
//			rimossi.add(f);
//		}
//		dst.removeAll(rimossi);//rimuovo quelli "eliminati"
//		src.removeAll(dst);//rimuovo quelli gi� presenti
//		dst.addAll(src);//aggiungo quelli "nuovi"
//	}
		
		
		
		
	private boolean areEquals(List<? extends DTOBase> list1, List<? extends DTOBase> list2){
        //null checking
        if(list1==null && list2==null)
            return true;
        if((list1 == null && list2 != null) || (list1 != null && list2 == null))
            return false;

        if(list1.size()!=list2.size())
            return false;
        for(DTOBase itemList1: list1)
        {
            if(!list2.contains(itemList1))
                return false;
        }

        return true;
    }
	
	
	public void setIndirizzi(List<Strada> indirizzi) {
////		this.indirizzi = indirizzi;
////		this.indirizzi.clear();
		this.indirizzi= new ArrayList<>();
		this.indirizzi.addAll(indirizzi);
		
////		this.indAziende = new ArrayList<>();
//		
//		List<Strada> rem = new ArrayList<>();
//		
//		for (StradaAzienda f : this.indAziende){
//			
//			if (f.getAzienda().equals(this)){
//				Strada f2 = f.getStrada();
//				if (!indirizzi.contains(f2)){
//					rem.add(f);
//				}
//			}
//		}
//		this.indAziende.removeAll(rem);//rimuovo quelli "eliminati"
//		indirizzi.removeAll(this.indAziende);//rimuovo quelli gi� presenti
//		this.indAziende.addAll(indirizzi);//aggiungo quelli "nuovi"
//		
	}

		public String getSecondoNome() {
		return secondonome;
	}
	public void setSecondoNome(String secondoNome) {
		this.secondonome = secondoNome;
	}

	public List<Strada> getIndirizzi() {
		return indirizzi;
	}
	
//	public List<Strada> getIndirizziRimossi() {
//		return indirizziRimossi;
//	}
//	public List<Strada> getIndirizziAggiunti() {
//		return indirizziAggiunti;
//	}
//	
//	public void rimuoviStrada(Strada i){
//		indirizziRimossi.add(i);
//		indirizzi.remove(i);
//	}
//	
//	public void aggiungiStrada(Strada i){
//		indirizziAggiunti.add(i);
//		
//	}
	
	
public FormaGiuridica getForma() {
		return forma;
	}
public List<Riferimento> getRiferimenti() {
//	List<Riferimento> myList= new ArrayList<>();
//	
//	myList.addAll(riferimenti);
//	
//	myList.removeAll(modificati);
//	myList.addAll(modificati);
//	
//	myList.addAll(nuovi);
//	
////	Collections.sort(myList);
//	
////	return riferimenti;
//	return myList;
//	
	return riferimenti;
	
}
public void setRiferimenti(List<Riferimento> riferimenti) {
//this.riferimenti.clear();
	
	
this.riferimenti.clear();
this.riferimenti.addAll(riferimenti);
//for (Riferimento rif: riferimenti) {
//	this.riferimenti.add(rif);
//}
	
	
//this.riferimenti = new ArrayList<>();
//this.riferimenti.addAll(riferimenti);
//
//rimossi.clear();
//nuovi.clear();
//modificati.clear();

}
//public List<CondizioneCommerciale> getCondizioni() {
//	List<CondizioneCommerciale> myList= new ArrayList<>();
//	
//	myList.addAll(condizioni);
//	myList.addAll(condModificate);
//	myList.addAll(condNuove);
//	
//	Collections.sort(myList);
//	
////	return riferimenti;
//	return myList;
//}
//public void setCondizioni(List<CondizioneCommerciale> condizioni) {
//this.condizioni.clear();
//this.condizioni.addAll(condizioni);
//
//condCancellate.clear();
//condNuove.clear();
//condModificate.clear();
//
//}

	public void setForma(FormaGiuridica forma) {
		this.forma = forma;
	}
	public List<CentralinoAzienda> getCentralino() {
		return centralino;
	}
	public void setCentralino(List<CentralinoAzienda> centralino) {
		
//		if (!areEquals(this.centralino, centralino)){
			this.centralino = new ArrayList<>();
			this.centralino.addAll(centralino);
////			List<CentralinoAzienda> rem = new ArrayList<>();
////			
////			for (CentralinoAzienda f : this.centralino){
////				if (!centralino.contains(f)){
//////					this.email.remove(f);
////					rem.add(f);
////				}
////			}
////			
////			this.centralino.removeAll(rem);//rimuovo quelli "eliminati"
////			centralino.removeAll(this.centralino);//rimuovo quelli gi� presenti
////			this.centralino.addAll(centralino);//aggiungo quelli "nuovi"
//		}

	}
	public List<FaxAzienda> getFax() {
		return fax;
	}
	public void setFax(List<FaxAzienda> fax) {
//		if (!areEquals(this.fax, fax)){
			this.fax = new ArrayList<>();
			this.fax.addAll(fax);
////			List<FaxAzienda> rem = new ArrayList<>();
////			
////			for (FaxAzienda f : this.fax){
////				if (!fax.contains(f)){
//////					this.email.remove(f);
////					rem.add(f);
////				}
////			}
////			
////			this.fax.removeAll(rem);//rimuovo quelli "eliminati"
////			fax.removeAll(this.fax);//rimuovo quelli gi� presenti
////			this.fax.addAll(fax);//aggiungo quelli "nuovi"
//		}
	}
	public List<NoteAzienda> getNote() {
//		return note;
		List<NoteAzienda> myList= new ArrayList<>();
		
		myList.addAll(note);
//		myList.addAll(noteModificate);
//		myList.addAll(noteNuove);
		
//		Collections.sort(myList);
		
//		return riferimenti;
		return myList;
	}
//	public void setNote(List<NoteAzienda> note) {
//		this.note = note;
//	}
	public void setNote(List<NoteAzienda> note) {
		this.note.clear();
		this.note.addAll(note);

//		noteCancellate.clear();
//		noteNuove.clear();
//		noteModificate.clear();
	}
	//	public void setStato(Stato stato) {
//		this.stato = stato;
//	}
//
//	public Stato getStato() {
//		return stato;
//	}
	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPartitaIva() {
		return piva;
	}
	public void setPartitaIva(String piva) {
		this.piva = piva;
	}
	public String getCodiceFiscale() {
		return codfisc;
	}
	public void setCodiceFiscale(String codfisc) {
		this.codfisc = codfisc;
	}
//	@Deprecated
//	public String getSito() {
//		return sito;
//	}
//	@Deprecated
//	public void setSito(String sito) {
//		this.sito = sito;
//	}
	
	@Override
	public String toString() {
		String text = "";
		
		try{
			text =getNome() + " " + getForma().toString();
		}
		catch(Exception e){
			text =getNome()/* + " __|__"*/;
		}
		
//		if (riferimenti!=null && riferimenti.size()>0) {
//			for (Riferimento r : riferimenti) {
//				text +=r.getNome() + " " + r.getCognome();
//			}
//		}
		
////		return getNome() + " " + getForma().toString();
//		return getNome();
		return text;
	}
	
}
