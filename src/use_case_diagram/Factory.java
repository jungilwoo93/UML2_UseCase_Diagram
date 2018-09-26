package use_case_diagram;

import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UseCase;

public class Factory {
	private Model model;
	private Actor actor;
	private UseCase useCase;
	private UseCase sousUseCase;
	private Context context = new Context();
	
	public Model getModel() {
		return model;
	}
	
	public Actor getActor() {
		return actor;
	}
	
	public UseCase getUseCase()
	{
		return useCase;
	}
	
	public UseCase getSousUseCase() {
		return sousUseCase;
	}
	
	public void pushModel (String name) {
		Model m = UseCaseUMLFactory.createModel(name);
		model = m;
		context.push(m);
	}
	
	public void pushActor(String name) {
		//Model model = (Model) context.top();
		Actor a = UseCaseUMLFactory.createActor(model,name);
		actor = a;
		context.push(a);
	}
	
	public void pushUseCase(String text) {
		//Model model = (Model) context.top();
		UseCase u = UseCaseUMLFactory.createUseCase(model, text);
		useCase = u;
		context.push(u);
	}
	
	public void addSousUseCase(String use) {
		UseCase u = UseCaseUMLFactory.createUseCase(use);
		sousUseCase = u;
	}
	
	public void addIncludeUseCase(UseCase from,UseCase to) {
		//UseCase u = (UseCase) context.top();
		UseCaseUMLFactory.createInclude(from, to);
		//context.push(o);
	}
	
	public void addExtendUseCase(UseCase from,UseCase to) {
		//UseCase u = (UseCase) context.top();
		UseCaseUMLFactory.createExtend(from, to);
	}
	
	public void addAssociation(Actor actor, UseCase uc) {
		UseCaseUMLFactory.createAssociation(actor, uc);
	}
	
	public void pop() {
		context.pop();
	}
}
