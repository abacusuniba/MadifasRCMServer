package c_dto.OLD___a_abstract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

// //////import com.fasterxml.jackson.annotation.JsonBackReference;
//////import com.fasterxml.jackson.annotation.JsonManagedReference;
//// //////import com.fasterxml.jackson.annotation.JsonBackReference;
//import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
//// //////import com.fasterxml.jackson.annotation.JsonBackReference;
//// //////import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OrderBy;
import org.hibernate.cfg.beanvalidation.GroupsPerOperation;

import c_dto.OLD___b_real.Stato;

////import com.fasterxml.jackson.annotation.JsonManagedReference;

////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

////import com.google.gson.annotations.SerializedName;

import c_dto.b_real.CellulareContatto;
import c_dto.b_real.CentralinoAzienda;
import c_dto.b_real.CondizioneCommerciale;
import c_dto.b_real.Consorzio;
import c_dto.b_real.EmailAzienda;
import c_dto.b_real.FaxAzienda;
import c_dto.b_real.Minimo;
import c_dto.b_real.NoteAzienda;
import c_dto.b_real.NoteContatto;
import c_dto.b_real.Pagamento;
import c_dto.b_real.FormaGiuridica;
import c_dto.b_real.Fornitore;
import c_dto.b_real.GruppoSocietario;
import c_dto.b_real.Indirizzo_old;
import c_dto.b_real.Riferimento;
import c_dto.b_real.SchedaNetto;
import c_dto.b_real.Settore;
import c_dto.b_real.Sito;
import c_dto.b_real.Trasporto;

/**
 * si tratta della classe base che modella un generico utente
 * 
 * @author Rosario
 *
 */
@Entity
@Table(name="azienda")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="idtipo", discriminatorType=DiscriminatorType.INTEGER)
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Deprecated
public abstract class Azienda extends Primary implements Comparable<Azienda>{

	////@SerializedName("nome") 
	@Column(name="nome")//ragione sociale
	private String nome= new String();

	////@SerializedName("secondoNome") 
	@Column(name="secondonome")//estensione ragione sociale
	private String secondoNome= new String();

	////@SerializedName("piva") 
	@Column(name="piva")//partita IVA
	private String piva= new String();

	////@SerializedName("codfisc") 
	@Column(name="codfisc")//codice fiscale
	private String codfisc= new String();

	
	
	//cambiare in elenco di siti web
	////@SerializedName("sito") 
	@Column(name="sito")//rimuovere
	private String sito= new String();//rimuovere



	///*@JsonManagedReference*/("siti")
//	///*@JsonBackReference*/(value="sito")
	////@SerializedName("siti") 
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL)
	/*@JsonManagedReference*/ private List<Sito> siti=new ArrayList<>();

//		@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
//	//	@OrderBy(clause = "cognome")
//		private List<CondizioneCommerciale> condizioni = new ArrayList<>();
//
//	//	private List<CondizioneCommerciale> condizioni;
//	
//	@Transient
//	private List<CondizioneCommerciale> condCancellate = new ArrayList<>();
//
//	@Transient
//	private List<CondizioneCommerciale> condModificate = new ArrayList<>();
//
//	@Transient
//	private List<CondizioneCommerciale> condNuove = new ArrayList<>();

//		@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
//	//	@OrderBy(clause = "prodotto")
//		private List<SchedaNetto> scheda = new ArrayList<>();
//
//	//	private List<SchedaNetto> scheda;
//	@Transient
//	private List<SchedaNetto> schCancellate=new ArrayList<>();
//
//	@Transient
//	private List<SchedaNetto> schModificate=new ArrayList<>();
//
//	@Transient
//	private List<SchedaNetto> schNuove=new ArrayList<>();

//	@ManyToOne
//	@JoinColumn(name = "idconsorzio")
//	private Consorzio consorzio=new Consorzio();
//
//
//
//	@ManyToOne
//	@JoinColumn(name = "idgruppo")
//	private GruppoSocietario gruppo = new GruppoSocietario();

	//		@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
	//	//	@OrderBy(clause = "cognome")
	//		private List<CondizioneCommerciale> condizioni = new ArrayList<>();
	//
	//	//	private List<CondizioneCommerciale> condizioni;
	//	
	//	@Transient
	//	private List<CondizioneCommerciale> condCancellate = new ArrayList<>();
	//
	//	@Transient
	//	private List<CondizioneCommerciale> condModificate = new ArrayList<>();
	//
	//	@Transient
	//	private List<CondizioneCommerciale> condNuove = new ArrayList<>();
	
	//		@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
	//	//	@OrderBy(clause = "prodotto")
	//		private List<SchedaNetto> scheda = new ArrayList<>();
	//
	//	//	private List<SchedaNetto> scheda;
	//	@Transient
	//	private List<SchedaNetto> schCancellate=new ArrayList<>();
	//
	//	@Transient
	//	private List<SchedaNetto> schModificate=new ArrayList<>();
	//
	//	@Transient
	//	private List<SchedaNetto> schNuove=new ArrayList<>();
	
	//	@ManyToOne
	//	@JoinColumn(name = "idconsorzio")
	//	private Consorzio consorzio=new Consorzio();
	//
	//
	//
	//	@ManyToOne
	//	@JoinColumn(name = "idgruppo")
	//	private GruppoSocietario gruppo = new GruppoSocietario();
	
		////@SerializedName("forma") 
		@ManyToOne
		@JoinColumn(name = "idforma")
		private FormaGiuridica forma= new FormaGiuridica();


	
	///*@JsonManagedReference*/("note")
//	///*@JsonBackReference*/(value="noteazienda")
	////@SerializedName("note") 
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
	/*@JsonManagedReference*/ private List<NoteAzienda> note=new ArrayList<>();

	////@SerializedName("noteCancellate") 
	@Transient
	private List<NoteAzienda> noteCancellate=new ArrayList<>();

	////@SerializedName("noteModificate") 
	@Transient
	private List<NoteAzienda> noteModificate=new ArrayList<>();

	////@SerializedName("noteNuove") 
	@Transient
	private List<NoteAzienda> noteNuove=new ArrayList<>();

	///*@JsonManagedReference*/("centralino")
//	///*@JsonBackReference*/(value="centralinoazienda")
	////@SerializedName("centralino") 
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
	/*@JsonManagedReference*/ private List<CentralinoAzienda> centralino=new ArrayList<>();

	///*@JsonManagedReference*/("email")
//	///*@JsonBackReference*/(value="emailazienda")
	////@SerializedName("email") 
//	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
	/*@JsonManagedReference*/ private List<EmailAzienda> email=new ArrayList<>();

	

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//		@JoinTable(name = "aziendasettori", joinColumns = {@JoinColumn(name = "idazienda")}, inverseJoinColumns = { @JoinColumn(name = "idsettore")})	
//	//	private List<Settore> settori = new ArrayList<>();
//		private List<Settore> settori = new ArrayList<>();

	
//	@ManyToMany()
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
//	@ManyToMany(cascade= {CascadeType.PERSIST ,CascadeType.MERGE})
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="indazienda", catalog="databasercm",
				joinColumns={@JoinColumn(name="idazienda", nullable = false, updatable = false)},
				inverseJoinColumns={@JoinColumn(name="idindirizzo", nullable = false, updatable = false) })
	private List<Indirizzo_old> indirizzi=new ArrayList<>();

//	@LazyCollection(LazyCollectionOption.FALSE)
//	@OneToMany(mappedBy = "azienda", cascade={CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
//	private List<Indirizzo> indAziende=new ArrayList<>();
	
	
	////@SerializedName("stato") 
	@ManyToOne
	@JoinColumn(name = "stato", nullable=false)
	private Stato stato;

	///*@JsonManagedReference*/("fax")
	//	///*@JsonBackReference*/(value="faxazienda")
		////@SerializedName("fax") 
		@ElementCollection
		@LazyCollection(LazyCollectionOption.FALSE)
		@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
		/*@JsonManagedReference*/ private List<FaxAzienda> fax=new ArrayList<>();

	///*@JsonManagedReference*/("riferimenti")
//	///*@JsonBackReference*/(value="riferimento")
	////@SerializedName("riferimenti") 
		@ElementCollection
		@LazyCollection(LazyCollectionOption.FALSE)
		@OneToMany(mappedBy="azienda", cascade=CascadeType.ALL, orphanRemoval=true)
//		@OrderBy(clause = "cognome")
	/*@JsonManagedReference*/ private List<Riferimento> riferimenti=new ArrayList<>();

	////@SerializedName("rimossi") 
	@Transient
	private List<Riferimento> rimossi=new ArrayList<>();

	////@SerializedName("modificati") 
	@Transient
	private List<Riferimento> modificati=new ArrayList<>();

	////@SerializedName("nuovi") 
	@Transient
	private List<Riferimento> nuovi=new ArrayList<>();

	

		//	public void setSettori(List<Settore> settori) {
	//		Iterator<Settore> it=settori.iterator();
	//		Settore elem;
	//		while (it.hasNext()){
	//			elem=it.next();
	//			if (!elem.getAziende().contains(this))
	//				elem.getAziende().add(this);
	//		}
	//		this.settori = settori;
	//	}
	
	
	
	
//		@Transient
//	private int ____________________________________________1;

		public Stato getStato() {
		return stato;
	}


	public void setStato(Stato stato) {
		this.stato = stato;
	}


		public boolean contains(String s){
			boolean contain=false;
//			UTILIZZATI PER IL FILTRAGGIO
//			nome : String
//			secondoNome : String
//			piva : String
//			codfisc : String
//			sito : String
//			siti : List<Sito>
//			indirizzi : List<Indirizzo>			
//			consorzio : Consorzio
//			gruppo : GruppoSocietario
//			forma : FormaGiuridica
//			settori : List<Settore>
//			riferimenti : List<Riferimento>
//			modificati : List<Riferimento>
//			nuovi : List<Riferimento>
//			note : List<NoteAzienda>
//			noteModificate : List<NoteAzienda>
//			noteNuove : List<NoteAzienda>
			
////			String stringForFilter = nome + secondoNome + piva + codfisc + sito 
////					+ consorzio.getNome() + gruppo.getNome() + forma.getNome();
//			String stringForFilter = nome + secondoNome + piva + codfisc + sito + forma.getNome();
			String stringForFilter = nome + secondoNome + piva + codfisc + sito;
			try{
				stringForFilter += forma.getNome();
			}
			catch (Exception e){
				
			}
			
			
			
			/* /
			for (Sito c : siti){
				stringForFilter += c.getNome();
			}
			
			for (Settore c : settori){
				stringForFilter += c.getNome();
			}
			
			for(Indirizzo c: indirizzi){
				stringForFilter += c.getStrada().getNome() 
						+ c.getCivico().getNumero() 
						+ c.getStrada().getCapcitta().getCap().getNome() 
						+ c.getStrada().getCapcitta().getCitta().getNome()
						+ c.getStrada().getCapcitta().getCitta().getProvincia().getNome()
						+ c.getStrada().getCapcitta().getCitta().getProvincia().getSigla()
						+ c.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNome()
						+ c.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNazione().getNome();
			}
			
			for(Riferimento c: riferimenti){
//				UTILIZZATI PER IL FILTRAGGIO
//				nome : String
//				cognome : String
//				titolo : Titolo
//				ruolo : Ruolo
//				note : List<NoteContatto>
//				indirizzi : List<Indirizzo>				
				stringForFilter += c.getCognome() 
						+ c.getNome()
						+ c.getTitolo().getTitolo()
						+ c.getRuolo().getRuolo();
				
				
				for (NoteContatto c1 : c.getNote()){
					stringForFilter += c1.getNote(); 
				}
				
				for (Indirizzo c1 : c.getIndirizzi()){
					stringForFilter += c1.getStrada().getNome() 
							+ c1.getCivico().getNumero() 
							+ c1.getStrada().getCapcitta().getCap().getNome() 
							+ c1.getStrada().getCapcitta().getCitta().getNome()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getNome()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getSigla()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNome()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNazione().getNome();
				}
				
//				NON UTILIZZATI PER IL FILTRAGGIO
//				cellulare : List<CellulareContatto>
//				email : List<EmailContatto>
//				fax : List<FaxContatto>
//				ufficio : List<CentralinoContatto>
				
				
				
			}
			for(Riferimento c: modificati){
//				UTILIZZATI PER IL FILTRAGGIO
//				nome : String
//				cognome : String
//				titolo : Titolo
//				ruolo : Ruolo
//				note : List<NoteContatto>
//				indirizzi : List<Indirizzo>				
				stringForFilter += c.getCognome() 
						+ c.getNome()
						+ c.getTitolo().getTitolo()
						+ c.getRuolo().getRuolo();
				
				
				for (NoteContatto c1 : c.getNote()){
					stringForFilter += c1.getNote(); 
				}
				
				for (Indirizzo c1 : c.getIndirizzi()){
					stringForFilter += c1.getStrada().getNome() 
							+ c1.getCivico().getNumero() 
							+ c1.getStrada().getCapcitta().getCap().getNome() 
							+ c1.getStrada().getCapcitta().getCitta().getNome()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getNome()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getSigla()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNome()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNazione().getNome();
				}
				
//				NON UTILIZZATI PER IL FILTRAGGIO
//				cellulare : List<CellulareContatto>
//				email : List<EmailContatto>
//				fax : List<FaxContatto>
//				ufficio : List<CentralinoContatto>
				
			}
			for(Riferimento c: nuovi){
//				UTILIZZATI PER IL FILTRAGGIO
//				nome : String
//				cognome : String
//				titolo : Titolo
//				ruolo : Ruolo
//				note : List<NoteContatto>
//				indirizzi : List<Indirizzo>				
				stringForFilter += c.getCognome() 
						+ c.getNome()
						+ c.getTitolo().getTitolo()
						+ c.getRuolo().getRuolo();
				
				
				for (NoteContatto c1 : c.getNote()){
					stringForFilter += c1.getNote(); 
				}
				
				for (Indirizzo c1 : c.getIndirizzi()){
					stringForFilter += c1.getStrada().getNome() 
							+ c1.getCivico().getNumero() 
							+ c1.getStrada().getCapcitta().getCap().getNome() 
							+ c1.getStrada().getCapcitta().getCitta().getNome()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getNome()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getSigla()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNome()
							+ c1.getStrada().getCapcitta().getCitta().getProvincia().getRegione().getNazione().getNome();
				}
				
//				NON UTILIZZATI PER IL FILTRAGGIO
//				cellulare : List<CellulareContatto>
//				email : List<EmailContatto>
//				fax : List<FaxContatto>
//				ufficio : List<CentralinoContatto>
				
			}
			for (NoteAzienda c : note){
				stringForFilter += c.getNote(); 
			}
			
			for (NoteAzienda c : noteModificate){
				stringForFilter += c.getNote(); 
			}
			
			for (NoteAzienda c : noteNuove){
				stringForFilter += c.getNote(); 
			}
			
			//NON UTILIZZATI PER IL FILTRAGGIO
//			rimossi : List<Riferimento>
//			condizioni : List<CondizioneCommerciale>
//			condCancellate : List<CondizioneCommerciale>
//			condModificate : List<CondizioneCommerciale>
//			condNuove : List<CondizioneCommerciale>
//			scheda : List<SchedaNetto>
//			schCancellate : List<SchedaNetto>
//			schModificate : List<SchedaNetto>
//			schNuove : List<SchedaNetto>
//			noteCancellate : List<NoteAzienda>
//			centralino : List<CentralinoAzienda>
//			email : List<EmailAzienda>
//			fax : List<FaxAzienda>
			
			
			/**/
			stringForFilter=stringForFilter.toLowerCase();
			
			if (stringForFilter.indexOf(s.toLowerCase())>-1)
				contain=true;
			
			
			return contain;

		}


		



//	public void setScheda(List<SchedaNetto> scheda) {
//		this.scheda.clear();
//		this.scheda.addAll(scheda);
//
//		schCancellate.clear();
//		schNuove.clear();
//		schModificate.clear();
//	}


	public void addRiferimento(Riferimento rif) {
		nuovi.add(rif);
	}
	
	public void addNote(NoteAzienda rif) {
		noteNuove.add(rif);
	}
	public void rimuoviNote(NoteAzienda rif) {
		noteCancellate.add(rif);
		
		
		noteModificate.remove(rif);
		noteNuove.remove(rif);
		note.remove(rif);
		
	}
	public void modificaNote(NoteAzienda rif){
		if (noteModificate.contains(rif)){
			noteModificate.remove(rif);
		}
		noteModificate.add(rif);
		
		noteNuove.remove(rif);
		note.remove(rif);
	}
	
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
	
	
	
	
	
	public void rimuoviRiferimento(Riferimento rif) {
		rimossi.add(rif);
		
		
		modificati.remove(rif);
		nuovi.remove(rif);
		riferimenti.remove(rif);
		
	}
	
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
	
	
	public void setIndirizzi(List<Indirizzo_old> indirizzi) {
////		this.indirizzi = indirizzi;
////		this.indirizzi.clear();
		this.indirizzi= new ArrayList<>();
		this.indirizzi.addAll(indirizzi);
		
////		this.indAziende = new ArrayList<>();
//		
//		List<Indirizzo> rem = new ArrayList<>();
//		
//		for (IndirizzoAzienda f : this.indAziende){
//			
//			if (f.getAzienda().equals(this)){
//				Indirizzo f2 = f.getIndirizzo();
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
		return secondoNome;
	}
	public void setSecondoNome(String secondoNome) {
		this.secondoNome = secondoNome;
	}

	public List<Indirizzo_old> getIndirizzi() {
		return indirizzi;
	}
public FormaGiuridica getForma() {
		return forma;
	}
public List<Riferimento> getRiferimenti() {
	List<Riferimento> myList= new ArrayList<>();
	
	myList.addAll(riferimenti);
	
	myList.removeAll(modificati);
	myList.addAll(modificati);
	
	myList.addAll(nuovi);
	
	Collections.sort(myList);
	
//	return riferimenti;
	return myList;
}
public void setRiferimenti(List<Riferimento> riferimenti) {
//this.riferimenti.clear();
this.riferimenti = new ArrayList<>();
this.riferimenti.addAll(riferimenti);

rimossi.clear();
nuovi.clear();
modificati.clear();

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
		myList.addAll(noteModificate);
		myList.addAll(noteNuove);
		
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

		noteCancellate.clear();
		noteNuove.clear();
		noteModificate.clear();
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
	public String getSito() {
		return sito;
	}
	public void setSito(String sito) {
		this.sito = sito;
	}
	
	@Override
	public String toString() {
		String text = "";
		
		try{
			text =getNome() + " " + getForma().toString();
		}
		catch(Exception e){
			text =getNome()/* + " __|__"*/;
		}
////		return getNome() + " " + getForma().toString();
//		return getNome();
		return text;
	}
	
	
	@Override
	public boolean isModified() {
		
		boolean modified = (nuovi.size()>0 || rimossi.size()>0 || modificati.size()>0);
		
//		modified = modified || (condNuove.size()>0 || condCancellate.size()>0 || condModificate.size()>0);

//		modified = modified || (schNuove.size()>0 || schCancellate.size()>0 || schModificate.size()>0);
		
		modified = modified || (noteNuove.size()>0 || noteCancellate.size()>0 || noteModificate.size()>0);
		
		
		return modified;

	}
	
	@Override
	public boolean isEmpty() {
		
		return (getIndirizzi().size()==0);

	}
	
	
	@Override
	public int compareTo(Azienda o) {
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
		compare=getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
		
		if (compare==0)
		{
//			compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
//			if (compare==0)
//			{
				compare=this.getId()-o.getId();
//			}
		}
		
		
		return compare;
		
	}
	
	
	
}
