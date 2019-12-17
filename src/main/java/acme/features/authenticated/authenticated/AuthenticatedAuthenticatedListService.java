
package acme.features.authenticated.authenticated;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAuthenticatedListService implements AbstractListService<Authenticated, Authenticated> {

	// Internal State ------------------------------------------------------

	@Autowired
	AuthenticatedAuthenticatedRepository repository;


	// AbstractListService<Authenticated, Announcemen> interface ------------

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
	public Collection<Authenticated> findMany(final Request<Authenticated> request) {
		assert request != null;

		Collection<Authenticated> result = this.repository.findManyUsersByThreadId(request.getModel().getInteger("id"));
		return result;

	}
}
