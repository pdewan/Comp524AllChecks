package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class NotEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		if (expr.getTail().getHead() instanceof SExpressionSub)
		{
			if (expr.getTail().getHead().eval(environment) instanceof NilAtom)
			{
			return new TAtom();
			}
			return new NilAtom();
		} else 
		{
			return new NilAtom();
		}
	}

}
