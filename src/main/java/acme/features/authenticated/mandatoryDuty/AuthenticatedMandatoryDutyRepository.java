
package acme.features.authenticated.mandatoryDuty;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.mandatoryDuties.MandatoryDuty;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMandatoryDutyRepository extends AbstractRepository {

	@Query("select a from InvestorRecord a")
	Collection<MandatoryDuty> findManyAll();

	@Query("select m from MandatoryDuty m where m.descriptor.id = ?1")
	Collection<MandatoryDuty> findManybyDescriptorId(int id);

	@Query("select m from MandatoryDuty m where m.id = ?1")
	MandatoryDuty findOneById(int id);

}
