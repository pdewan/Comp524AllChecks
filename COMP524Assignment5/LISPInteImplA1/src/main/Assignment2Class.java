package main;
import main.lisp.evaluator.environment.EnvironmentFactory;
import main.lisp.evaluator.parallel.args.ArgumentEvaluator;
import main.lisp.evaluator.parallel.args.ArgumentEvaluatorSingleton;
import main.lisp.interpreter.InterpreterController;
import main.lisp.interpreter.InterpreterControllerSingleton;
import main.lisp.interpreter.InterpreterModel;
import main.lisp.interpreter.InterpreterModelFactory;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.interpreter.InterpreterView;
import main.lisp.interpreter.InterpreterViewSingleton;
import main.lisp.interpreter.ObservableLispInterpreterWithEnvironment;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtomFactory;

public class Assignment2Class {
	public static void main(String[] args) {
		ExpressionFactory.setClass(SExpressionSub.class);
		OpRegImpl.registerImpl();	
		OpRegImpl.registerAll();
		EnvironmentFactory.setClass(AbstractEnvSub.class);
		IdentifierAtomFactory.setClass(IdentifierAtomSub.class);
		ArgumentEvaluatorSingleton.setClass(AAEImpl.class);
//		
//		InterpreterModelFactory.setClass(ObservableLispInterpreterWithEnvironment.class);
//		
//		InterpreterModel interpreter = InterpreterModelSingleton.get();
//		InterpreterView view = InterpreterViewSingleton.get();
//		InterpreterController controller = InterpreterControllerSingleton.get();
//		
//		interpreter.registerPropertyChangeListener(view);
//		controller.setModel(interpreter);
//		
//		controller.run();
		Main.main(args);

		
	}
}
