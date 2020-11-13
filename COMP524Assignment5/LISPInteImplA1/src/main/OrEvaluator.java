package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class OrEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		return returnFirst(expr.getTail(), environment);
	}
	
	public SExpression returnFirst(SExpression expr, Environment environment)
	{
		if (expr.getHead() instanceof SExpressionSub && expr.getTail() instanceof SExpressionSub)
		{
			if (isCorrect(expr.getHead(), environment))
			{
				return expr.getHead().eval(environment);
			} else
			{
				return returnFirst(expr.getTail(), environment);
			}
		} else if (expr.getHead() instanceof IdentifierAtom)
		{
			return expr.eval(environment);
		} else if (expr.getTail() instanceof NilAtom)
		{
			if (expr.getHead() instanceof Atom && !(expr.getHead() instanceof NilAtom))
			{
				return expr.getHead();
			}
			return expr.getHead().eval(environment);
		} else if (expr.getHead() instanceof NilAtom)
		{
			return returnFirst(expr.getTail(), environment);
		} else if (expr.getHead() instanceof Atom && !(expr.getHead() instanceof NilAtom))
		{
			return expr.getHead();
		}
		{
			return new NilAtom();
		}
	}
	
//	public SExpression returnFirst(SExpression expr, Environment environment)
//	{
//		if (expr.getHead() instanceof IdentifierAtom && expr.getTail() instanceof Task1)
//		{
//			return returnFirst(expr.getTail(), environment);
//		} 
//		else if (expr.getHead() instanceof Atom && !(expr.getHead() instanceof IdentifierAtom) 
//				&& !(expr.getHead() instanceof NilAtom))
//		{
//			return expr.getHead();
//		} else if (expr.getHead() instanceof NilAtom && expr.getTail() instanceof NilAtom)
//		{
//			return new NilAtom();
//		}
//		
//		return returnFirst(expr.getTail(), environment);
//	}
	
	public boolean isCorrect(SExpression expr, Environment environment)
	{
		if (expr.eval(environment) instanceof NilAtom)
		{
			return false;
		} else if (expr.getHead() instanceof IdentifierAtom)
		{
			if (expr.eval(environment) instanceof NilAtom)
			{
				return false;
			}
			return true;
		}
		
		return true;
	}

}
