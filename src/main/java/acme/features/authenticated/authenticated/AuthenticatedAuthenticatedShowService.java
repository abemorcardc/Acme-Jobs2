
package acme.features.authenticated.authenticated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAuthenticatedShowService implements AbstractShowService<Authenticated, Authenticated> {

	// Internal State ------------------------------------------------------

	@Autowired
	AuthenticatedAuthenticatedRepository repository;


	// AbstractListService<Auditor, AuditorRecord> interface ------------

	@Override
	public boolean authorise(final Request<Authenticated> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Authenticated> request, final Authenticated entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		String username = entity.getUserAccount().getUsername();
		model.setAttribute("username", username);
		request.unbind(entity, model);

	}

	@Override
	public Authenticated findOne(final Request<Authenticated> request) {
		assert request != null;

		Authenticated result;
		int authenticatedId;

		authenticatedId = request.getModel().getInteger("id");
		result = this.repository.findOneById(authenticatedId);

		return result;
	}

}
