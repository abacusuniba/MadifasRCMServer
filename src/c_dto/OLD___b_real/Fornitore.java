package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SecondaryTable;

import c_dto.OLD___a_abstract.Azienda;

/**
 * si tratta della classe che modella il manager di competizione
 * 
 * @author Rosario
 *
 */
@Entity
@DiscriminatorValue("2") //F
@SecondaryTable(name="fornitore")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public final class Fornitore extends Azienda {


	
}
