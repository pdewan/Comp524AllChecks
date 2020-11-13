package main;

import java.util.List;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.parallel.args.ArgumentEvaluator;
import main.lisp.evaluator.parallel.args.ArgumentEvaluatorSingleton;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class EListEvaluator implements Evaluator{

	@Override
	public synchronized SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		List<SExpression> exprs = ArgumentEvaluator.split(expr.getTail());
		exprs = ArgumentEvaluatorSingleton.get().evaluate(exprs, environment);
		return makeList(exprs, environment);
	}

	public SExpression makeList(List<SExpression> exprs, Environment env)
	{
		if (exprs.size() == 1)
		{
			return ExpressionFactory.newInstance(exprs.remove(0).eval(env), new NilAtom());
		}
		return ExpressionFactory.newInstance(exprs.remove(0).eval(env), makeList(exprs, env));
	}
}
