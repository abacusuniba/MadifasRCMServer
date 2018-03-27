package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import c_dto.OLD___a_abstract.Azienda;
import c_dto.OLD___a_abstract.DTOBase;

@Entity
@Table(name="trasporto")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Trasporto extends DTOBase implements Comparable<Trasporto>{
	
	@Column(name="nome")//nome azienda
	private String nome;
	@ManyToOne
	@JoinColumn(name = "stato", nullable=false)
	private Stato stato;

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return getNome();
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

		public boolean contains(String s){
			boolean contain=false;
			
			String stringForFilter = nome;
			
			
			
			stringForFilter=stringForFilter.toLowerCase();
			
			if (stringForFilter.indexOf(s.toLowerCase())>-1)
				contain=true;
			
			
			return contain;
	}

		@Override
		public int compareTo(Trasporto o) {
			
			//=0: le stringhe sono uguali
			//>0: o < this
			//<0: o > this
			
			int compare;
			
			compare=getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
			
			if (compare==0)
			{
//				compare=this.getNome().toLowerCase().compareTo(o.getNome().toLowerCase());
//				if (compare==0)
//				{
					compare=this.getId()-o.getId();
//				}
			}
			
			
			return compare;
			
		}


}
