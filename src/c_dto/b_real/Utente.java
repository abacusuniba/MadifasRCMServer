package c_dto.b_real;
import java.util.ArrayList;
import java.util.List;

import c_dto.a_abstract.Primary;
import c_dto.c_enum.TipoUtente;



public class Utente extends Primary{

	private String nome;
	
	private String cognome;
	
	private String username;
	
	private String password;
	
	
	private TipoUtente tipoUtente;
	
	
	public TipoUtente getTipoUtente() {
		return tipoUtente;
	}
	public void setTipoUtente(TipoUtente tipoUtente) {
		this.tipoUtente = tipoUtente;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
