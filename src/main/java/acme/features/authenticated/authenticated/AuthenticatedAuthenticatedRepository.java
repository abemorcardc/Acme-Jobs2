
package acme.features.authenticated.authenticated;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuthenticatedRepository extends AbstractRepository {

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findOneById(int Authenticated);

	//@Query("select mt.users from MessageThread mt where mt.id = ?1")
	//Collection<Authenticated> findUsersById(int messageThreadId);

	@Query("select amt.authenticated from Authenticated_MessageThread amt where amt.messageThread.id =?1 ")
	Collection<Authenticated> findManyUsersByThreadId(int messageThreadId);
}
