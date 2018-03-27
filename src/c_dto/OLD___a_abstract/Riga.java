package c_dto.OLD___a_abstract;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

//import com.google.gson.annotations.SerializedName;

@MappedSuperclass
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public /* /abstract/**/ class Riga extends DTOBase implements Comparable<Riga>{
	////@SerializedName("progressivo") 
	@Column(name="progressivo")//nome azienda
	private int progressivo;
	public int getProgressivo() {
		return progressivo;
	}


	public void setProgressivo(int progressivo) {
		this.progressivo = progressivo;
	}


	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(Riga o) {
		
		//=0: le stringhe sono uguali
		//>0: o < this
		//<0: o > this
		
		int compare;
		
		compare=this.getProgressivo()-o.getProgressivo();
		
		if (compare==0)
		{
				compare=this.getId()-o.getId();
		}
		
		
		return compare;
		
	}
	
	@Override
	public String toString() {
		return "Nuova riga vuota - pos: " + progressivo;
	}


}
