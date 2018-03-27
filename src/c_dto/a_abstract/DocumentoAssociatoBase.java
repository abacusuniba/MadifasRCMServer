package c_dto.a_abstract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public abstract class DocumentoAssociatoBase extends Primary{
	




	
//	private DocumentoBase documento;


		public abstract DocumentoBase getDocumento();
//		{
//		return documento;
//	}

	public abstract void setDocumento(DocumentoBase documento);
//	{
//		this.documento = documento;
//	}



}
