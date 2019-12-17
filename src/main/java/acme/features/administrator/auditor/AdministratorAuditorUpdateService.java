
package acme.features.administrator.auditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorAuditorUpdateService implements AbstractUpdateService<Administrator, Auditor> {

	@Autowired
	AdministratorAuditorRepository repository;


	@Override
	public boolean authorise(final Request<Auditor> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Auditor> request, final Auditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Auditor> request, final Auditor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "responsabilityStatement", "accepted");

	}

	@Override
	public Auditor findOne(final Request<Auditor> request) {
		assert request != null;

		Auditor result;
		Principal principal;
		int userAccountId;

		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();

		result = this.repository.findOneAuditorByUserAccountId(userAccountId);

		return result;
	}

	@Override
	public void validate(final Request<Auditor> request, final Auditor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean accepted = request.getModel().getBoolean("accepted");

		Boolean r1 = accepted == true || accepted == false;
		errors.state(request, r1, "status", "administrator.auditor.error.accepted");

	}

	@Override
	public void update(final Request<Auditor> request, final Auditor entity) {
		// TODO Auto-generated method stub

	}
}
