package c_dto.OLD___b_real;
////import com.fasterxml.jackson.annotation.JsonIdentityInfo;
////import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
//import javax.persistence.DiscriminatorColumn;
//import javax.persistence.DiscriminatorType;
//import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorValue;

//@Entity
//@Table(name="stato")
//@AttributeOverrides({
//    @AttributeOverride(name="id", column=@Column(name="id")),
//    @AttributeOverride(name="nome", column=@Column(name="nome"))
//})
@DiscriminatorValue("2")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Archiviato extends Stato {
	
    private static Archiviato singleton=null;

	public static synchronized Archiviato getInstance() {
		if (singleton==null){
			singleton = new Archiviato();
		}
		return singleton;
	}
	
	private Archiviato(){
		setId(Integer.parseInt(this.getClass().getAnnotation( DiscriminatorValue.class ).value()));
		setNome(getClass().getSimpleName());
	}

	
}
