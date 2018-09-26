package use_case_diagram;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
//import org.eclipse.uml2.uml.AggregationKind;
//import org.eclipse.uml2.uml.Class;
//import org.eclipse.uml2.uml.Enumeration;
//import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
//import org.eclipse.uml2.uml.Model;
//import org.eclipse.uml2.uml.PrimitiveType;
///import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import java_cup.runtime.ComplexSymbolFactory;

public class UseCaseUML {
	private String dir;
	// private boolean compiler = false;
	
	public UseCaseUML(String dir) {
		super();
		this.dir = dir;
	}
	
	/*private Actor createSample () {
		//UseCase useCase;
		Model siteWeb = UseCaseUMLFactory.createModel("Website");
		Actor siteUser = UseCaseUMLFactory.createActor("Site User");
		siteUser.setIsLeaf(true);
		UseCase useCase1=UseCaseUMLFactory.createUseCase(siteUser,"Search dorcs - full text");
		UseCase useCase2 = useCase1.createOwnedUseCase("Download docs");
		useCase1.createInclude(useCase2.getName(), useCase2);
		//UseCaseUMLFactory.createAssociation(siteUser, true, AggregationKind.NONE_LITERAL, " ", 0, useCase1, true, AggregationKind.NONE_LITERAL, "", 0, 0);
		//createAssociation(customerClass, true, AggregationKind.NONE_LITERAL,
			//	"orders", 0, LiteralUnlimitedNatural.UNLIMITED, purchaseOrderClass,
				//true, AggregationKind.NONE_LITERAL, "customer", 1, 1);
		//useCase1.createOwnedUseCase(useCase2.getName());
		//UseCaseUMLFactory.createGeneralization(siteUser, useCase1);
		//save(siteUser,"exemple");
		return siteUser;
	}*/
	
	private Model readSample (String input) {
		Model actor = null;
		try {
	    	ComplexSymbolFactory csf = new ComplexSymbolFactory ();
	    	Lexer l = new Lexer(new FileReader(input+".txt"));
	    	l.setSymbolFactory(csf);
	    	Parser p = new Parser(l, csf);
	    	p.parse();
	    	actor = p.getModel();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return actor;
	}
	
	private void save (Model actor, String output) {
		String directory = new File(dir).getAbsolutePath();
		URI uri = URI.createFileURI(directory).appendSegment(output).appendFileExtension(UMLResource.FILE_EXTENSION);
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet);
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(actor);
		//resource.getContents().add(useCase);
		try {
			resource.save(null);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String dir = null;
		switch (args.length) {
		case 0 : dir = "."; break;
		case 1 : dir = args[0]; break;
		default : break;
		}
		if (dir == null) return;
		
		UseCaseUML sample = new UseCaseUML(dir);

		Model model = sample.readSample("websiteEx");
		
		if (model != null) sample.save(model, "websiteEx" );
		

	}

}
