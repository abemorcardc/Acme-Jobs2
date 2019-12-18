
package acme.features.authenticated.messageThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messageThreads.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageThreadShowService implements AbstractShowService<Authenticated, MessageThread> {

	// Internal State ------------------------------------------------------

	@Autowired
	AuthenticatedMessageThreadRepository repository;


	// AbstractListService<Auditor, AuditorRecord> interface ------------

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

		Authenticated creator = this.repository.findCreatorNameByThreadID(entity.getId());
		String creatorName = creator.getUserAccount().getUsername();
		model.setAttribute("creatorName", creatorName);
		Boolean isCreator = request.getPrincipal().getUsername().equals(creatorName);
		model.setAttribute("isCreator", isCreator);
		request.unbind(entity, model, "title", "creationMoment");

	}

	@Override
	public MessageThread findOne(final Request<MessageThread> request) {
		assert request != null;

		MessageThread result;
		int messageThreadId;

		messageThreadId = request.getModel().getInteger("id");
		result = this.repository.findOneById(messageThreadId);

		return result;
	}

}
