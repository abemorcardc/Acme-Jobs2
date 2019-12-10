
package acme.entities.descriptors;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Descriptor extends DomainEntity {

	//serialisation identifier

	private static final long serialVersionUID = 1L;

	//atributos
	@NotBlank
	private String jobDescription;

}
