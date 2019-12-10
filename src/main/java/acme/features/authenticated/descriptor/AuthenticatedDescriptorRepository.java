
package acme.features.authenticated.descriptor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.descriptors.Descriptor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedDescriptorRepository extends AbstractRepository {

	@Query("select d from Descriptor d where d.id = ?1")
	Descriptor findOneById(int id);

	@Query("select j.descriptor from Job j where j.id = ?1")
	Descriptor findOneByJobId(int jobId);

	@Query("select j.reference from Job j where j.id = ?1")
	String findReferenceByJobId(int jobId);

}
