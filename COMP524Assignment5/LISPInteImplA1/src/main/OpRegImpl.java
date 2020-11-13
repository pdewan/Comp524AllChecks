package main;

import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.OperationRegisterer;
import main.lisp.evaluator.basic.AtomEvaluator;
import main.lisp.evaluator.basic.CarEvaluator;
import main.lisp.evaluator.basic.CdrEvaluator;
import main.lisp.evaluator.basic.ConsEvaluator;
import main.lisp.evaluator.basic.DifferenceEvaluator;
import main.lisp.evaluator.basic.EqEvaluator;
import main.lisp.evaluator.basic.EqualsEvaluator;
import main.lisp.evaluator.basic.NotEqualsEvaluator;
import main.lisp.evaluator.basic.NullEvaluator;
import main.lisp.evaluator.basic.ProductEvaluator;
import main.lisp.evaluator.basic.QuotientEvaluator;
import main.lisp.evaluator.basic.SumEvaluator;

/**
 * The {@code BasicOperationRegisterer} class provides a means for registering
 * the basic operations required in a minimal lisp interpreter. Only a subset
 * of the necessary lisp operations are included.
 * 
 * @author Andrew Vitkus
 *
 */
public class OpRegImpl implements OperationRegisterer {
	
	/**
	 * Registers the basic arithmetic operations as <em>+</em>, <em>-</em>, <em>*</em>, and <em>/</em>.
	 * @see SumEvalutor
	 * @see DiferenceEvaluator
	 * @see ProductEvaluator
	 * @see QuotientEvaluator
	 */
	public static void registerArithmetic() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("+", new SumEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("-", new DifferenceEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("*", new ProductEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("/", new QuotientEvaluator());
	}
	
	/**
	 * Registers several basic operations for working with S-Expressions directly.
	 * This set consists of <em>car</car>, <em>cdr</em>, <em>cons</em>, <em>atom</em>, <em>null</em>.
	 * 
	 * @see CarEvaluator
	 * @see CdrEvaluator
	 * @see ConsEvaluator
	 * @see AtomEvaluator
	 * @see NullEvaluator
	 */
	public static void registerExpressionFunctions() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("CAR", new CarEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("cdr", new CdrEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("cons", new ConsEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("atom", new AtomEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("null", new NullEvaluator());
	}

	/**
	 * Registers a sample comparison expression: <em>eq</eq>, <em>=</em>, <em>/=</em>.
	 * 
	 * @see EqEvaluator
	 * @see EqualsEvaluator
	 * @see NotEqualsEvaluator
	 */
	public static void registerComparison() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("eq", new EqEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("=", new EqualsEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("/=", new NotEqualsEvaluator());
	}
	
	/**
	 * Registers the sample arithmetic, expression, and conditional operations.
	 * 
	 */
	public static void registerImpl() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("QUOTE", new QuoteEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("LIST", new ListEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("EVAL", new EvalEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator(">", new LTEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("<", new GTEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator(">=", new LTEEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("<=", new GTEEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("NOT", new NotEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("OR", new OrEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("AND", new AndEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("LOAD", new LoadEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("COND", new CondEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("SETQ", new SetqEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("LAMBDA", new LambdaEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("FUNCALL",  new FunCall());
		BuiltinOperationManagerSingleton.get().registerEvaluator("FUNCTION", new FunctionEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("LET", new LetEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("CURRY", new CurryEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("DEFUN", new DeFunEvaluator());
	}
	public static void registerAll() {
		registerArithmetic();
		registerExpressionFunctions();
		registerComparison();
		registerImpl();
	}

	/**
	 * Registers all basic operations.
	 * 
	 * @see #registerAll();
	 */
	public void registerOperations() {
		registerAll();
	}
}
