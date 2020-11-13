package main;

import java.util.List;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.parallel.args.ArgumentEvaluator;
import main.lisp.evaluator.parallel.args.ArgumentEvaluatorSingleton;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class EagerOr implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		List<SExpression> exprs = ArgumentEvaluator.split(expr.getTail());
		exprs = ArgumentEvaluatorSingleton.get().evaluate(exprs, environment);
		for (SExpression exp : exprs)
		{
			if (!(exp instanceof NilAtom))
			{
				return exp.eval(environment);
			}
		}
		return new NilAtom();
	}

}
