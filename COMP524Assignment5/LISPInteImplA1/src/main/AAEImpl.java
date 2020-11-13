package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.parallel.args.AbstractArgumentEvaluator;
import main.lisp.parser.terms.SExpression;

public class AAEImpl extends AbstractArgumentEvaluator{

	@Override
	public List<SExpression> evaluate(List<SExpression> expressions, Environment env) {	
		if (LispInterpreterSettings.getEvaluationMode() == LispInterpreterSettings.EvaluationMode.EAGER && !LispInterpreterSettings.isEagerPool())
		{
			return evaluateParallelWithLambda(expressions, env);
		}
		if (LispInterpreterSettings.getEvaluationMode().toString().equalsIgnoreCase("normal"));
		{
			return evaluateSerial(expressions, env);
		}
	}

	@Override
	public List<SExpression> evaluateParallelWithThreadPool(List<SExpression> expressions, Environment env) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SExpression> evaluateParallelWithHelperClass(List<SExpression> expressions, Environment env) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<SExpression> evaluateParallelWithLambda(List<SExpression> expressions, Environment env) {
		// TODO Auto-generated method stub
		List<SExpression> evaled = new ArrayList<SExpression>();
		BasicJoiner joiner = new BasicJoiner(expressions.size() - 1);
		//SExpression[] evaled = new SExpression[expressions.size()];
		evaled.add(expressions.get(0));
		//evaled[0] = expressions.get(0);
		for (int i = 1; i < expressions.size(); i++)
		{
			final int c = i;
			final String nam = nextLambdaEvalThreadName();
			new Thread (() -> {
				Thread.currentThread().setName(nam);
				evaled.add(expressions.get(c).eval(env));
				//evaled[c] = expressions.get(c).eval(nEnv);
				joiner.finished();
				}).start();
		}
		//joiner.join();
		evaled.set(0, evaled.get(0).eval(env));
		//evaled[0] = evaled[0].eval(nEnv);
		//expressions.clear();
		//Collections.addAll(expressions, evaled);
		joiner.join();
		return expressions;
	}

	@Override
	public List<SExpression> evaluateSerial(List<SExpression> expressions, Environment env) {
		// TODO Auto-generated method stub
		List<SExpression> evaled = new ArrayList<SExpression>();
		for (SExpression sub : expressions)
		{
			evaled.add(sub.eval(env));
		}
		
		return evaled;
	}
	

}
