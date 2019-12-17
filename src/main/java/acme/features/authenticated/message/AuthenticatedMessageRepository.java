
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messages.Message;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.id = ?1")
	Message findOneById(int id);

	//@Query("select j from Job j where j.employer.id =?1 ")
	//Collection<Job> findManyByEmployerId(int employerId);

	@Query("select m from Message m where m.messageThread.id = ?1 ")
	Collection<Message> findManyByMessageThreadId(int messageThreadId);

	//"select a from Announcement a where datediff(current_timestamp, a.moment)<30")
}
