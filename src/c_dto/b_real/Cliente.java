package c_dto.b_real;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import c_dto.a_abstract.Azienda;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class Cliente extends Azienda {


	
	/*@JsonManagedReference*/ private List<CondizioneCommerciale> condizioni = new ArrayList<>();

//private List<CondizioneCommerciale> condCancellate = new ArrayList<>();

//private List<CondizioneCommerciale> condModificate = new ArrayList<>();

//private List<CondizioneCommerciale> condNuove = new ArrayList<>();


private List<Settore> settori = new ArrayList<>();



/*@JsonManagedReference*/ private List<SchedaNetto> scheda = new ArrayList<>();

//private List<SchedaNetto> schCancellate=new ArrayList<>();
//
//private List<SchedaNetto> schModificate=new ArrayList<>();
//
//private List<SchedaNetto> schNuove=new ArrayList<>();



private Consorzio consorzio=new Consorzio();



private GruppoSocietario gruppo = new GruppoSocietario();

//public void addCondizione(CondizioneCommerciale rif) {
////	condNuove.add(rif);
//	condizioni.add(rif);
//}

//public void rimuoviCondizione(CondizioneCommerciale rif) {
//////	rimossi.add(rif);
////	condCancellate.add(rif);
////	
//////	modificati.remove(rif);
////	condModificate.remove(rif);
//////	nuovi.remove(rif);
////	condNuove.remove(rif);
//////	riferimenti.remove(rif);
//	condizioni.remove(rif);
//	
//}
	
	
	
//public void modificaCondizione(CondizioneCommerciale rif){
//	if (condModificate.contains(rif)){
//		condModificate.remove(rif);
//	}
//	condModificate.add(rif);
//	
//	condNuove.remove(rif);
//	condizioni.remove(rif);
//}
public List<CondizioneCommerciale> getCondizioni() {
//	List<CondizioneCommerciale> myList= new ArrayList<>();
//	
//	myList.addAll(condizioni);
//	myList.addAll(condModificate);
//	myList.addAll(condNuove);
//	
////	Collections.sort(myList);
//	
////	return riferimenti;
//	return myList;
	return condizioni;
}
public void setCondizioni(List<CondizioneCommerciale> condizioni) {
this.condizioni.clear();
this.condizioni.addAll(condizioni);

//condCancellate.clear();
//condNuove.clear();
//condModificate.clear();

}
	
public void setScheda(List<SchedaNetto> scheda) {
	this.scheda.clear();
	this.scheda.addAll(scheda);
//
//	schCancellate.clear();
//	schNuove.clear();
//	schModificate.clear();
}



//public void addScheda(SchedaNetto rif) {
//	schNuove.add(rif);
//}


//public void rimuoviScheda(SchedaNetto rif) {
//	schCancellate.add(rif);
//	
//	
//	schModificate.remove(rif);
//	schNuove.remove(rif);
//	scheda.remove(rif);
//	
//}

//public void modificaScheda(SchedaNetto rif){
//	if (schModificate.contains(rif)){
//		schModificate.remove(rif);
//	}
//	schModificate.add(rif);
//	
//	schNuove.remove(rif);
//	scheda.remove(rif);
//}


public List<SchedaNetto> getScheda() {
//	List<SchedaNetto> myList= new ArrayList<>();
//	
//	myList.addAll(scheda);
//	myList.addAll(schModificate);
//	myList.addAll(schNuove);
//	
////	Collections.sort(myList);
//	
////	return riferimenti;
//	return myList;
	return scheda;
}

public Consorzio getConsorzio() {
	return consorzio;
}

public void setConsorzio(Consorzio consorzio) {
	this.consorzio = consorzio;
}




public GruppoSocietario getGruppo() {
	return gruppo;
}

public void setGruppo(GruppoSocietario gruppo) {
	this.gruppo = gruppo;
}




public List<Settore> getSettori(){
	return settori;
}




	public void setSettori(List<Settore> settori) {
//	this.settori = settori;
//		try{
//			this.settori.clear();
//		}
//		catch(Exception e){
//			this.settori=new ArrayList<>();
//		}
//	this.settori.addAll(settori);
	
	this.settori= new ArrayList<>();
	this.settori.addAll(settori);
}



}



//package c_dto.b_real;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import c_dto.a_abstract.Azienda;
//
//public class Cliente extends Azienda {
//
//
//	
//	/*@JsonManagedReference*/ private List<CondizioneCommerciale> condizioni = new ArrayList<>();
//
//private List<CondizioneCommerciale> condCancellate = new ArrayList<>();
//
//private List<CondizioneCommerciale> condModificate = new ArrayList<>();
//
//private List<CondizioneCommerciale> condNuove = new ArrayList<>();
//
//
//private List<Settore> settori = new ArrayList<>();
//
//
//
///*@JsonManagedReference*/ private List<SchedaNetto> scheda = new ArrayList<>();
//
//private List<SchedaNetto> schCancellate=new ArrayList<>();
//
//private List<SchedaNetto> schModificate=new ArrayList<>();
//
//private List<SchedaNetto> schNuove=new ArrayList<>();
//
//
//
//private Consorzio consorzio=new Consorzio();
//
//
//
//private GruppoSocietario gruppo = new GruppoSocietario();
//
//public void addCondizione(CondizioneCommerciale rif) {
//	condNuove.add(rif);
//}
//
//public void rimuoviCondizione(CondizioneCommerciale rif) {
////	rimossi.add(rif);
//	condCancellate.add(rif);
//	
////	modificati.remove(rif);
//	condModificate.remove(rif);
////	nuovi.remove(rif);
//	condNuove.remove(rif);
////	riferimenti.remove(rif);
//	condizioni.remove(rif);
//	
//}
//	
//	
//	
//public void modificaCondizione(CondizioneCommerciale rif){
//	if (condModificate.contains(rif)){
//		condModificate.remove(rif);
//	}
//	condModificate.add(rif);
//	
//	condNuove.remove(rif);
//	condizioni.remove(rif);
//}
//public List<CondizioneCommerciale> getCondizioni() {
//	List<CondizioneCommerciale> myList= new ArrayList<>();
//	
//	myList.addAll(condizioni);
//	myList.addAll(condModificate);
//	myList.addAll(condNuove);
//	
////	Collections.sort(myList);
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
//	
//public void setScheda(List<SchedaNetto> scheda) {
//	this.scheda.clear();
//	this.scheda.addAll(scheda);
//
//	schCancellate.clear();
//	schNuove.clear();
//	schModificate.clear();
//}
//
//
//
//public void addScheda(SchedaNetto rif) {
//	schNuove.add(rif);
//}
//
//
//public void rimuoviScheda(SchedaNetto rif) {
//	schCancellate.add(rif);
//	
//	
//	schModificate.remove(rif);
//	schNuove.remove(rif);
//	scheda.remove(rif);
//	
//}
//
//public void modificaScheda(SchedaNetto rif){
//	if (schModificate.contains(rif)){
//		schModificate.remove(rif);
//	}
//	schModificate.add(rif);
//	
//	schNuove.remove(rif);
//	scheda.remove(rif);
//}
//
//
//public List<SchedaNetto> getScheda() {
//	List<SchedaNetto> myList= new ArrayList<>();
//	
//	myList.addAll(scheda);
//	myList.addAll(schModificate);
//	myList.addAll(schNuove);
//	
////	Collections.sort(myList);
//	
////	return riferimenti;
//	return myList;
//}
//
//public Consorzio getConsorzio() {
//	return consorzio;
//}
//
//public void setConsorzio(Consorzio consorzio) {
//	this.consorzio = consorzio;
//}
//
//
//
//
//public GruppoSocietario getGruppo() {
//	return gruppo;
//}
//
//public void setGruppo(GruppoSocietario gruppo) {
//	this.gruppo = gruppo;
//}
//
//
//
//
//public List<Settore> getSettori(){
//	return settori;
//}
//
//
//
//
//	public void setSettori(List<Settore> settori) {
////	this.settori = settori;
////		try{
////			this.settori.clear();
////		}
////		catch(Exception e){
////			this.settori=new ArrayList<>();
////		}
////	this.settori.addAll(settori);
//	
//	this.settori= new ArrayList<>();
//	this.settori.addAll(settori);
//}
//
//	@Override
//	public String getCreateQuery() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getUpdateQuery() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public String getSubQuery() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//}