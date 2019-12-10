
package acme.entities.mandatoryDuties;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.entities.descriptors.Descriptor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MandatoryDuty extends DomainEntity {

	//serialisation identifier

	private static final long	serialVersionUID	= 1L;

	//atributos

	@NotBlank
	private String				title;

	@NotBlank
	private String				dutyDescription;

	@NotNull
	@Range(min = 0, max = 100)
	private Integer				percentage;

	// Relationships ---------------------------------------
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Descriptor			descriptor;
}
