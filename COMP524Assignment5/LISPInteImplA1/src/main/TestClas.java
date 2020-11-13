package main;

import main.lisp.evaluator.environment.EnvironmentFactory;
import main.lisp.evaluator.parallel.args.ArgumentEvaluatorSingleton;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtomFactory;

public class TestClas {
	public static void main(String[] args) {
		ExpressionFactory.setClass(Task1.class);
		OpRegImpl.registerAll();
		ArgumentEvaluatorSingleton.setClass(AAEImpl.class);
		EnvironmentFactory.setClass(AbstractEnvSub.class);
		IdentifierAtomFactory.setClass(IdentifierAtomSub.class);
		gradingTools.comp524f19.assignment4.Assignment4Suite.main(args);		
	}

}
