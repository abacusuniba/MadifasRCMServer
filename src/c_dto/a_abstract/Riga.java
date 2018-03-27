package c_dto.a_abstract;

import c_dto.b_real.CausaleTrasporto;

public /* /abstract/**/ class Riga extends Primary{
	private int item;
	
	public int getItem() {
		return item;
	}


	public void setItem(int item) {
		this.item = item;
	}
	private int progressivo;
	public int getProgressivo() {
		return progressivo;
	}


	public void setProgressivo(int progressivo) {
		this.progressivo = progressivo;
	}




	@Override
	public String toString() {
		return "Nuova riga vuota - pos: " + progressivo;
	}


	@Override
	public int compareTo(DTOBase o) {
//		=0: le stringhe sono uguali
//		>0: o < this
//		<0: o > this
	
		Riga n = (Riga) o;
		int compare=0;
		
		
		if (getProgressivo()>n.getProgressivo())
			compare=1;
		else {
			if (getProgressivo()<n.getProgressivo())
				compare=-1;
		}
		
		return compare;
	}
	

}
