package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class LetEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		Environment cEnv = new AbstractEnvSub(environment);
		return expr.getTail().getTail().getHead().eval(setVars(expr.getTail().getHead(), cEnv, environment));
	}
	
	public Environment setVars(SExpression expr, Environment cEnv, Environment environment)
	{
		cEnv.makeLocalSpecial((IdentifierAtom) expr.getHead().getHead());
		cEnv.assign((IdentifierAtom) expr.getHead().getHead(), expr.getHead().getTail().getHead().eval(environment));
		
		if (expr.getTail() instanceof NilAtom)
		{
			return cEnv;
		}
		
		return setVars(expr.getTail(), cEnv, environment);
		
	}
	

}
