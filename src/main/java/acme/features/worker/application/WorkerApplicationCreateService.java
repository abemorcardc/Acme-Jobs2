
package acme.features.worker.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application> {

	//	Internal state ---------------------

	@Autowired
	WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		//		boolean result;

		//		int applicationId;
		//		Application application;
		//		Job job;
		//		Employer employer;
		//		Principal principal;
		//
		//		applicationId = request.getModel().getInteger("id");
		//		application = this.repository.findOneById(applicationId);
		//		job = application.getJob();
		//		employer = job.getEmployer();
		//		principal = request.getPrincipal();
		//		result = employer.getUserAccount().getId() == principal.getAccountId();

		//		return result;
		return true;
	}

	@Override
	public Application instantiate(final Request<Application> request) {
		//
		//		Application result;
		//		int jobId;
		//		String jobReference;
		//		Worker idWorker;
		//		Principal principal;
		//
		//		jobId = request.getModel().getInteger("id");
		//		jobReference = this.repository.findJobReference(jobId);
		//
		//		principal = request.getPrincipal();
		//		idWorker = this.repository.findIdWorker(principal.getAccountId());
		//
		//		result = new Application();
		//		result.setReference(jobReference);
		//		result.setWorker(idWorker);
		//
		//		return result;

		Application result;

		result = new Application();

		result.setSkills("SKILL INSTANCIADO probando");
		return result;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		//		String jobReference = this.repository.findJobReferenceById(request.getModel().getInteger("id"));
		//		model.setAttribute("job", jobReference);
		request.unbind(entity, model, "reference", "deadline", "status", "statement");
		request.unbind(entity, model, "skills", "qualifications");
		request.unbind(entity, model, "job");
		request.unbind(entity, model, "worker");
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors); //ejemplo: request.bind(entity, errors, "moment");
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		//		Calendar calendar;
		//		Date minimumDeadline;
		//
		//		if (!errors.hasErrors("deadline")) {
		//			calendar = new GregorianCalendar();
		//			calendar.add(Calendar.DAY_OF_MONTH, 1);
		//			minimumDeadline = calendar.getTime();
		//			errors.state(request, entity.getDeadline().after(minimumDeadline), "deadline", "worker.application.error.deadline-future");
		//		}

	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);

	}

}
