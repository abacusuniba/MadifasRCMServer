package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SecondaryTable;

import c_dto.OLD___a_abstract.Azienda;

/**
*
* 
* @author Rosario
*
*/
@Entity
@DiscriminatorValue("5") //+   segnalatore
@SecondaryTable(name="collaboratore")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public final class Segnalatore extends Azienda {
	
}
