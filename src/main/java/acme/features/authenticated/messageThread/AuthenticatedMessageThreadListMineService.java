
package acme.features.authenticated.messageThread;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThreads.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageThreadListMineService implements AbstractListService<Authenticated, MessageThread> {

	// Internal State ------------------------------------------------------

	@Autowired
	AuthenticatedMessageThreadRepository repository;


	// AbstractListService<Authenticated, Announcemen> interface ------------

	@Override
	public boolean authorise(final Request<MessageThread> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment");
	}

	@Override
	public List<MessageThread> findMany(final Request<MessageThread> request) {
		assert request != null;

		List<MessageThread> result = new ArrayList<MessageThread>();

		result = this.repository.findManyByAuthenticated(request.getPrincipal().getActiveRoleId());
		/*
		 * int authenticatedId = request.getPrincipal().getActiveRoleId();
		 * List<MessageThread> allMessageThreads = this.repository.findMany();
		 *
		 * List<MessageThread> messageThreadsUser = new ArrayList<MessageThread>();
		 *
		 * for (MessageThread mt : allMessageThreads) {
		 * List<Integer> usersIds = new ArrayList<Integer>();
		 * for (Authenticated a : mt.getUsers()) {
		 * usersIds.add(a.getId());
		 * }
		 * if (usersIds.contains(authenticatedId)) {
		 * messageThreadsUser.add(mt);
		 */

		//result.addAll(messageThreadsUser);
		return result;

	}
}
