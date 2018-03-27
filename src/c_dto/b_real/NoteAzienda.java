package c_dto.b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.beans.Transient;

import c_dto.a_abstract.Secondary;

public class NoteAzienda extends Secondary{
	
	private String note;
	private String data;
	
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
//		return getNote();
		return getData() + "\n" + getNote();

	}

}