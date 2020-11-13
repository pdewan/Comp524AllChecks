package main;

import java.util.ArrayList;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.BasicLambda;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class LambdaEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		 Environment cEnv = new AbstractEnvSub(environment);
		 if (expr.getHead() instanceof IdentifierAtom)
		 {
			 return expr;
		 }
		
		 Lambda fac = LambdaFactory.newInstance(getArgs(expr.getHead().getTail().getHead(), 
				environment, new ArrayList<IdentifierAtom>()), expr.getHead().getTail().getTail());
		 if (expr.getHead().getTail().getHead() instanceof NilAtom)
		 {
			 return fac;
		 }
		 return fac;
	}
	
	public IdentifierAtom[] getArgs(SExpression expr, Environment environment, ArrayList<IdentifierAtom> list)
	{
		if (expr instanceof NilAtom)
		{
			return list.toArray(new IdentifierAtom[list.size()]);
		}
		list.add((IdentifierAtom) expr.getHead());
		if (expr.getTail() instanceof NilAtom)
		{
			return list.toArray(new IdentifierAtom[list.size()]);
		}
		return getArgs(expr.getTail(), environment, list);
	}	
}