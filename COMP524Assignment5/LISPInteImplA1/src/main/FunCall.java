package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.BasicLambda;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class FunCall implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		Environment cEnv = new AbstractEnvSub(environment);
		SExpression fac;
		if (expr.getTail().getHead() instanceof IdentifierAtom && expr.getTail().getTail() instanceof BasicLambda)
		{
			fac = expr.getTail().getTail().eval(environment);
		}
		if (expr.getTail().getHead() instanceof Task1)
		{
			fac = expr.getTail().getHead().eval(environment);
		}
		else
		{
			fac = environment.lookup((IdentifierAtom) expr.getTail().getHead()).get();
		}
		if (fac instanceof IdentifierAtom)
		{
			//fac = ExpressionFactory.newInstance(fac.eval(cEnv), expr.getTail().getTail().getHead()).eval(cEnv);
			try {
			fac = ExpressionFactory.newInstance(fac.eval(cEnv), expr.getTail().getTail()).eval(cEnv);
			return fac;
			} catch (Exception e)
			{
				fac = ExpressionFactory.newInstance(fac, expr.getTail().getTail()).eval(cEnv);
				return fac;
			}
		} 
		if (expr.getTail().getTail() instanceof SExpressionSub)
		{
			if (expr.getTail().getTail().getHead() instanceof Task1 && !(expr.getTail().getTail().getTail() instanceof Task1) && !(expr.getTail().getTail().getTail() instanceof NilAtom))
			{
				// Previously working one below, trying to fix extra nil appearing at end of new
				fac = ExpressionFactory.newInstance(fac, ExpressionFactory.newInstance(expr.getTail().getTail().getHead().eval(environment), new NilAtom())).eval(cEnv);
				//fac = ExpressionFactory.newInstance(fac, expr.getTail().getTail().getHead().eval(environment)).eval(cEnv);
				return fac;
			} 
			//else if (expr.getTail().getHead() instanceof IdentifierAtom && !(expr.getTail().getTail().getTail() instanceof NilAtom))
			else
			{
				fac = ExpressionFactory.newInstance(fac, expr.getTail().getTail()).eval(cEnv);
				return fac;
			}
		}
		if (fac instanceof Atom && !(fac instanceof NilAtom))
		{
			return fac;
		}
		if (expr.getTail().getTail() instanceof Atom)
		{
			fac = ExpressionFactory.newInstance(fac, expr.getTail().getTail().eval(environment)).eval(cEnv);
			//fac = ExpressionFactory.newInstance(fac, expr.getTail().getTail());
			return fac;
		}
		else if (expr.getTail().getTail().getHead() instanceof Atom)
		{
			fac = ExpressionFactory.newInstance(fac, ExpressionFactory.newInstance(expr.getTail().getTail().getHead().eval(environment), new NilAtom())).eval(cEnv);
			return fac;
		}
		fac = ExpressionFactory.newInstance(fac, expr.getTail().getTail().getHead().eval(environment)).eval(cEnv);
		return fac;
	}

}
