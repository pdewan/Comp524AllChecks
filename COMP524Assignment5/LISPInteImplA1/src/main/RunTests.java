package main;
import main.lisp.interpreter.InterpreterController;
import main.lisp.interpreter.InterpreterControllerSingleton;
import main.lisp.interpreter.InterpreterModel;
import main.lisp.interpreter.InterpreterModelFactory;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.interpreter.InterpreterView;
import main.lisp.interpreter.InterpreterViewSingleton;
import main.lisp.interpreter.ObservableLispInterpreterWithEnvironment;
import main.lisp.parser.terms.ExpressionFactory;

public class RunTests {
	public static void main(String[] args) {
		ExpressionFactory.setClass(Task1.class);
		OpRegImpl.registerImpl();	
		OpRegImpl.registerAll();
		
		InterpreterModelFactory.setClass(ObservableLispInterpreterWithEnvironment.class);
		
		InterpreterModel interpreter = InterpreterModelSingleton.get();
		InterpreterView view = InterpreterViewSingleton.get();
		InterpreterController controller = InterpreterControllerSingleton.get();
		
		interpreter.registerPropertyChangeListener(view);
		controller.setModel(interpreter);
		
		controller.run();

		
	}
}
