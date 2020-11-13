package main;

import java.util.ArrayList;
import java.util.function.Function;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.FunctionFactory;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class DeFunEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		 Environment cEnv = environment.copy();
		 Lambda fac = LambdaFactory.newInstance(getArgs(expr.getTail().getTail().getHead(), new ArrayList<IdentifierAtom>()), expr.getTail().getTail().getTail());
		 environment.assignFun((IdentifierAtom)expr.getTail().getHead(), FunctionFactory.newInstance(fac, cEnv));
		 return FunctionFactory.newInstance(fac, cEnv);
	}
	
	public IdentifierAtom[] getArgs(SExpression expr, ArrayList<IdentifierAtom> list)
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
		return getArgs(expr.getTail(), list);
	}

}
