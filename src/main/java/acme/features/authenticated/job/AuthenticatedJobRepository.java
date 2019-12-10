
package acme.features.authenticated.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneById(int id);

	//@Query("select j from Job j where j.employer.id =?1 ")
	//Collection<Job> findManyByEmployerId(int employerId);

	@Query("select j from Job j where current_timestamp < j.deadline and j.finalMode = true")
	Collection<Job> findMany();

	//"select a from Announcement a where datediff(current_timestamp, a.moment)<30")
}
