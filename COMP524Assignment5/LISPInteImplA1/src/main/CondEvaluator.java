package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class CondEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		return iterateThrough(expr, environment);
	}
	
	public SExpression iterateThrough(SExpression expr, Environment environment)
	{	
		if (expr.getHead() instanceof TAtom)
		{
			return expr.getTail().getHead();
		}
		else if (expr.getHead() instanceof Task1 && expr.getTail() instanceof Task1)
		{
			if (isCorrect(expr.getHead(), environment))
			{
				return expr.getHead().getTail().getHead().eval(environment);
				//return expr.getHead().getTail().eval(environment);
			} 
			else if(expr.getTail() instanceof NilAtom) 
			{
				return new NilAtom();
			}
			else
			{
				return iterateThrough(expr.getTail(), environment);
			}
			
		}
		if (!(expr.getTail() instanceof NilAtom))
		{
			return iterateThrough(expr.getTail(), environment);
		} else if (expr.getHead().getHead() instanceof TAtom)
		{
			return expr.getHead().getTail().getHead().eval(environment);
		} else
		{
			return iterateThroughHead(expr.getHead(), environment);
		}
	}
	
	public SExpression iterateThroughHead(SExpression expr, Environment environment)
	{	
		if (expr.getHead() instanceof TAtom)
		{
			return expr.getTail().getHead();
		} else if (expr.getHead() instanceof NilAtom)
		{
			return new NilAtom();
		}
		else if (expr.getHead() instanceof Task1 && expr.getTail() instanceof Task1)
		{
			if (isCorrect(expr.getHead(), environment))
			{
				return expr.getTail().getHead().eval(environment);
			} 
			else
			{
				//return iterateThrough(expr.getTail(), environment);
				return new NilAtom();
			}
			
		}
		if (!(expr.getTail() instanceof NilAtom))
		{
			return iterateThrough(expr.getTail(), environment);
		} else
		{
			return iterateThroughHead(expr.getHead(), environment);
		}
	}
	
	public boolean isCorrect(SExpression expr, Environment environment)
	{
		if (expr.getHead() instanceof IdentifierAtom)
		{
			if (expr.eval(environment) instanceof NilAtom)
			{
				return false;
			}
			return true;
		} else if (expr.getHead().eval(environment) instanceof NilAtom)
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
