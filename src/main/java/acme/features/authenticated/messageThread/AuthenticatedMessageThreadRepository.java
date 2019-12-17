
package acme.features.authenticated.messageThread;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messageThreads.MessageThread;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageThreadRepository extends AbstractRepository {

	@Query("select mt from MessageThread mt where mt.id = ?1")
	MessageThread findOneById(int messageThreadId);

	@Query("select mt.creator from MessageThread mt where mt.id = ?1")
	Authenticated findCreatorNameByThreadID(int messageThreadId);

	@Query("select mt from MessageThread mt where mt in (select m.messageThread from Message m where m.author.id = ?1)")
	Collection<MessageThread> findManyByUserAccountId(int authenticatedId);

	@Query("select mt from MessageThread mt")
	List<MessageThread> findMany();

	@Query("select amt.messageThread from Authenticated_MessageThread amt where amt.authenticated.id=?1")
	List<MessageThread> findManyByAuthenticated(int authenticatedId);
}
