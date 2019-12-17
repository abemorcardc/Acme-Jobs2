
package acme.features.administrator.auditor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorAuditorRepository extends AbstractRepository {

	//
	//	@Query("select a from Application a where a.worker.id =?1")
	//	Collection<Auditor> findManyByWorkerId(int workerId);
	//
	//	@Query("select j from Job j where j.id = ?1")
	//	Job findJobById(int id);
	//
	//	@Query("select a from Worker w where w.id = ?1")
	//	Auditor findAuditorById(int id);
	//
	//	@Query("select j.reference from Job j where j.id =?1")
	//	String findJobReference(int jobId);

	//	@Query("select a from Auditor a where a.id = ?1")
	//	Auditor findOneById(int id);

	@Query("select a from Auditor a where a.userAccount.id = ?1")
	Auditor findOneAuditorByUserAccountId(int id);

	@Query("select a from Auditor a")
	Collection<Auditor> findManyAuditor();

	@Query("select a from Auditor a where a.id = ?1")
	Auditor findOneAuditorById(int id);

}
