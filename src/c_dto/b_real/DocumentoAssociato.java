package c_dto.b_real;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import c_dto.a_abstract.DTOBase;
import c_dto.a_abstract.DocumentoAssociatoBase;
import c_dto.a_abstract.DocumentoBase;
import c_dto.a_abstract.Primary;
import c_dto.a_abstract.Riga;

public class DocumentoAssociato extends DocumentoAssociatoBase{
	




	
	private Documento documento;


	public Documento getDocumento() {
	return documento;
}

//public void setDocumento(Documento documento) {
//	this.documento = documento;
//}

@Override
public void setDocumento(DocumentoBase documento) {
	this.documento = (Documento) documento;
	
}


}
