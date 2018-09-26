package use_case_diagram;

import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


public class UseCaseUMLFactory {
	static public class PointUseCase{
		//private String text;
		private UseCase useCase;
		private Actor actor;
		//private Association association;
		public PointUseCase(UseCase useCase){
			super();
			this.useCase=useCase;
		}
		public PointUseCase(Actor actor) {
			super();
			this.actor=actor;
		}
		
		public UseCase getUseCase() {
			return useCase;
		}
		
		public Actor getActor() {
			return actor;
		}
		
	}
	
	public static Model createModel(String name) {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(name);
		return model;
	}
	
	public static UseCase createUseCase(String text) {
		UseCase use = UMLFactory.eINSTANCE.createUseCase();
		use.setName(text);
		return use;
	}
	
	public static Actor createActor(Model model,String name) {
		Actor actor = (Actor) model.createPackagedElement(name,UMLPackage.eINSTANCE.getActor());
		actor.setName(name);
		return actor;
	}
	
	public static Include createInclude(UseCase from, UseCase to) {
		Include include = to.createInclude(from.getName(),from);
		return include;
	}
	
	public static Extend createExtend(UseCase from, UseCase to) {
		Extend extend =  to.createExtend(from.getName(), from);
		//you ke neng usecase de shun xu cuo le
		return extend;
	}
	
	public static UseCase createUseCase(Model m,String text) {
		//UseCase useCase =actor.createOwnedUseCase(text);
		//return useCase;
		UseCase uc = (UseCase) m.createPackagedElement(text, UMLPackage.eINSTANCE.getUseCase());
		return uc;
	}
	
	/*public static Generalization createGeneralization(Actor actor,UseCase useCase) {
		Generalization gene = actor.createGeneralization(useCase);
		return gene;
	}*/
	
	public static Association createAssociation(Actor actor, UseCase uc) {
		Association association = uc.createAssociation(false, AggregationKind.NONE_LITERAL, uc.getName(), 0, 1, actor, false, AggregationKind.NONE_LITERAL, actor.getName(), 0, 1);
		return association;
	}
}