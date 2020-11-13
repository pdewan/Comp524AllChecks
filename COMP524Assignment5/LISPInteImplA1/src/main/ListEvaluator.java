package main;

import java.util.ArrayList;
import java.util.List;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.parallel.args.AbstractArgumentEvaluator;
import main.lisp.evaluator.parallel.args.ArgumentEvaluator;
import main.lisp.evaluator.parallel.args.ArgumentEvaluatorSingleton;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.QuoteAtom;
import main.lisp.parser.terms.SExpression;

public class ListEvaluator implements Evaluator{
	public SExpression eval(SExpression expr, Environment environment) {
		if (LispInterpreterSettings.getEvaluationMode() != LispInterpreterSettings.EvaluationMode.EAGER)
		{
			if (expr.getTail() instanceof NilAtom)
			{
				return new NilAtom();
			}
			return toList(expr.getTail(), environment);	
		} else {
		List<SExpression> exprs = ArgumentEvaluator.split(expr.getTail());
		exprs = ArgumentEvaluatorSingleton.get().evaluate(exprs, environment);
		return makeList(exprs, environment);
		}
	}
	
	public SExpression toList(SExpression expr, Environment environment) 
	{
		if (expr.getTail() instanceof NilAtom)
		{
			return ExpressionFactory.newInstance(expr.getHead().eval(environment), new NilAtom());
		}
		return ExpressionFactory.newInstance(expr.getHead().eval(environment), toList(expr.getTail(), environment));
	}
	
	public SExpression makeList(List<SExpression> exprs, Environment env)
	{
		if (exprs.size() == 1)
		{
			return ExpressionFactory.newInstance(exprs.remove(0).eval(env), new NilAtom());
		}
		return ExpressionFactory.newInstance(exprs.remove(0).eval(env), makeList(exprs, env));
	}
	
	public ArrayList<SExpression> getSExpr(SExpression expr, ArrayList<SExpression> list)
	{
		list.add(expr.getHead());
		if (expr.getTail() instanceof NilAtom)
		{
			return list;
		}
		return getSExpr(expr.getTail(), list);
	}
	
	
//	public SExpression toList(SExpression expr, Environment environment)
//	{
//		if (expr.getHead() instanceof IdentifierAtom && !(expr.getHead() instanceof NilAtom) && expr.getTail() instanceof NilAtom)
//		{
//			return ExpressionFactory.newInstance(expr.eval(environment), new NilAtom());
//		} 
//		else if (expr.getHead() instanceof NilAtom && expr.getTail() instanceof NilAtom)
//		{
//			return ExpressionFactory.newInstance(new NilAtom(), new NilAtom());
//		} else if (expr.getHead() instanceof QuoteAtom)
//		{
//			return ExpressionFactory.newInstance(expr.getHead().eval(environment), toList(expr.getTail(), environment));
//		} else if (expr.getHead() instanceof Task1 && expr.getTail() instanceof Task1)
//		{
//			return ExpressionFactory.newInstance(expr.getHead().eval(environment), toList(expr.getTail(), environment));
//		} else if (expr.getHead() instanceof IdentifierAtom)
//		{
//			return ExpressionFactory.newInstance(expr.getHead().eval(environment), toList(expr.getTail(), environment));
//		} 
//		else if (expr.getHead() instanceof Task1 && expr.getTail() instanceof NilAtom)
//		{
//			return ExpressionFactory.newInstance(expr.eval(environment), new NilAtom());
//		}
//		else if (expr.getHead() instanceof Atom && !(expr.getHead() instanceof IdentifierAtom) 
//				&& !(expr.getHead() instanceof NilAtom) && expr.getTail() instanceof NilAtom)
//		{
//			return expr;
//		}
//		else if (expr.getHead() instanceof NilAtom && expr.getTail() instanceof NilAtom)
//		{
//			return new NilAtom();
//		}
//		return ExpressionFactory.newInstance(expr.getHead(), toList(expr.getTail(), environment));
//	}
	
//	public SExpression getDeepestNode(SExpression expr, SExpression last)
//	{
//		if (expr.getTail() instanceof NilAtom && !(expr.getHead() instanceof NilAtom))
//		{
//			return getDeepestNode(expr.getHead(), last);
//		}
//		
//		return getDeepestNode(expr.getTail(), last);
//	}
}
