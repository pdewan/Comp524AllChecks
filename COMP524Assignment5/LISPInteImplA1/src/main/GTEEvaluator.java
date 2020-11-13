package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class GTEEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		return calculate(expr.getTail(), environment);
	}
	
	public SExpression calculate(SExpression expr, Environment environment)
	{
		if (getFirstElement(expr, environment) <= getSecondElement(expr, environment))
		{
			return new TAtom();
		}
		else 
		{
		return new NilAtom();
		}
	}
	
	public Double getFirstElement(SExpression expr, Environment environment)
	{
		if (expr.getHead() instanceof IdentifierAtom)
		{
			return Double.parseDouble(expr.eval(environment).toString());
		}
		else if (expr instanceof Atom && !(expr instanceof NilAtom) && !(expr instanceof IdentifierAtom))
		{
			return Double.parseDouble(expr.toString());
		}
		else if (expr.getHead() instanceof Atom && expr.getTail() instanceof Task1 && !(expr.getHead() instanceof NilAtom) && !(expr.getHead() instanceof IdentifierAtom))
		{
			return Double.parseDouble(expr.getHead().toString());
		} else if (expr.getHead() instanceof Task1 && expr.getTail() instanceof Task1)
		{
			return getFirstElement(expr.getHead(), environment);
		}
		return getFirstElement(expr.getTail(), environment);
	}
	
	public Double getSecondElement(SExpression expr, Environment environment)
	{
		if (expr instanceof Atom && !(expr instanceof NilAtom) && !(expr instanceof IdentifierAtom))
		{
			return Double.parseDouble(expr.eval(environment).toString());
		}
		else if (expr.getHead() instanceof IdentifierAtom)
		{
			return Double.parseDouble(expr.eval(environment).toString());
		}
		else if (expr.getHead() instanceof Atom && expr.getTail() instanceof NilAtom && !(expr.getHead() instanceof NilAtom) && !(expr.getHead() instanceof IdentifierAtom))
		{
			return Double.parseDouble(expr.getHead().toString());
		}
		else if (expr.getHead() instanceof Task1 && expr.getTail() instanceof Task1)
		{
			return getSecondElement(expr.getTail(), environment);
		} 
		else if (expr.getHead() instanceof Task1 && expr.getTail() instanceof NilAtom)
		{
			return getSecondElement(expr.getHead(), environment);
		}
		return getSecondElement(expr.getTail(), environment);
	}

}
