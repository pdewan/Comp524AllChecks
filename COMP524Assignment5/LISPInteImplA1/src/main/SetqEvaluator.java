package main;

import java.util.Optional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.BasicFunction;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class SetqEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		return setSQ(expr.getTail(), environment);
	}
	
	private SExpression setSQ(SExpression expr, Environment environment)
	{
		if (expr.getTail().getHead() instanceof Task1)
		{
			if (expr.getTail().getHead().getHead() instanceof IdentifierAtom)
			{
				environment.assign((IdentifierAtom) expr.getHead(), expr.getTail().getHead().eval(environment));
				return environment.lookup((IdentifierAtom) expr.getHead()).get();
			}
		} else if (expr.getTail() instanceof SExpression)
		{
			environment.assign((IdentifierAtom) expr.getHead(), expr.getTail().getHead());
			return environment.lookup((IdentifierAtom) expr.getHead()).get();
		}
		{
		environment.assign((IdentifierAtom) expr.getHead(), expr.getTail());
		} 
		if (environment.lookup((IdentifierAtom) expr.getHead()).get() instanceof Task1)
		{
			return environment.lookup((IdentifierAtom) expr.getHead()).get().getHead();
		}
		return environment.lookup((IdentifierAtom) expr.getHead()).get();
	}

}
