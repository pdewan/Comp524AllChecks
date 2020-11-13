package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class AndEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		if (checkNils(expr, environment))
		{
			return deepestValue(expr, environment);
		} else
		{
			return new NilAtom();
		}
	}
	
	public boolean checkNils(SExpression expr, Environment environment)
	{
		if (expr.getHead() instanceof Atom)
		{
			if (expr.getHead() instanceof TAtom)
			{
				if (expr.getTail() instanceof NilAtom)
				{
					return true;
				}
				return checkNils(expr.getTail(), environment);
			} else if (expr.getHead() instanceof NilAtom)
			{
				return false;
			} else if (expr.getTail() instanceof NilAtom)
			{
				return true;
			} else
			{
				return checkNils(expr.getTail(), environment);
			}
		} else if (expr.getHead() instanceof Task1 && expr.getTail() instanceof Task1)
		{
			if (expr.getHead().eval(environment) instanceof NilAtom)
			{
				return false;
			} else
			{
				return checkNils(expr.getTail(), environment);
			}
		} else if (expr.getTail() instanceof NilAtom)
		{
			if (expr.getHead() instanceof Task1)
			{
				if (expr.getHead().eval(environment) instanceof NilAtom)
				{
					return false;
				}
				else
				{
					return true;
				}
			} else
			{
				if (expr.getHead() instanceof NilAtom)
				{
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	
//	public boolean checkNils(SExpression expr)
//	{
//		if (expr.getHead() instanceof IdentifierAtom && expr.getTail() instanceof Task1)
//		{
//			return checkNils(expr.getTail());
//		} 
//		else if (!(expr.getHead() instanceof NilAtom) && expr.getHead() instanceof Atom)
//		{
//			return true;
//		} else if (expr.getHead() instanceof NilAtom && expr.getTail() instanceof NilAtom)
//		{
//			return false;
//		}
//		return checkNils(expr.getTail());
//	}
	
	public SExpression deepestValue(SExpression expr, Environment environment)
	{
		if (expr.getHead() instanceof Atom && !(expr.getHead() instanceof NilAtom) && !(expr.getHead() instanceof IdentifierAtom) && expr.getTail() instanceof NilAtom) 
		{
			return expr.getHead();
		} else if (expr.getHead() instanceof Task1 && expr.getTail() instanceof NilAtom)
		{
			return expr.getHead().eval(environment);
		}
		return deepestValue(expr.getTail(), environment);
	}
}
