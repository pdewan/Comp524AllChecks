package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class EvalEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		return expr.getTail().getHead().eval(environment).eval(environment);
	}
//	public SExpression evalRep(SExpression expr, Environment environment)
//	{
//		if (expr.getHead() instanceof IdentifierAtom && expr.getTail() instanceof NilAtom)
//		{
//			return expr.getHead();
//		}
//		if (expr.getHead() instanceof IdentifierAtom)
//		{
//			return evalRep(expr.eval(environment), environment);
//		} else if (expr.getTail() instanceof NilAtom)
//		{
//			return evalRep(expr.getHead(), environment);
//		}
//		return evalRep(expr.getTail(), environment);
//	}
//	
//	public SExpression evalRep(SExpression expr, Environment environment)
//	{
//		if (expr.getHead() instanceof IdentifierAtom && !(expr.getTail() instanceof NilAtom))
//		{
//			return evalRep(expr.eval(environment), environment);
//		} 
//		else if (expr.getHead() instanceof IdentifierAtom && expr.getTail() instanceof Task1)
//		{
//			return evalRep(expr.eval(environment), environment);
//		}
//		else if (expr.getTail() instanceof Task1)
//		{
//			return evalRep(expr.getTail(), environment);
//		} else if (expr.getHead() instanceof IdentifierAtom && expr.getTail() instanceof NilAtom)
//		{
//			return expr;
//		}
//		else if (expr.getHead() instanceof Atom && !(expr.getHead() instanceof NilAtom) && !(expr.getHead() instanceof IdentifierAtom)
//			&& expr.getTail() instanceof Atom && !(expr.getTail() instanceof NilAtom) && !(expr.getTail() instanceof IdentifierAtom))
//		{
//			return expr;
//		}
//		else if (expr.getHead() instanceof Atom && expr.getTail() instanceof NilAtom)
//		{
//			return expr;
//		}
//		else
//		{
//			return evalRep(expr.getHead(), environment);
//		}
//	}
	

}
