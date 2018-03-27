package c_dto.b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.beans.Transient;

import c_dto.a_abstract.Secondary;

public class EmailContatto extends Secondary{
	
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		
		EmailContatto c = (EmailContatto) obj;
		
		return c.getEmail().equals(this.getEmail());
	}
	@Override
	public String toString() {
		return getEmail();

	}

}