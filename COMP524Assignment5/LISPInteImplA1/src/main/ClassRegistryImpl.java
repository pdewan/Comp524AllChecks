package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationRegisterer;
import main.lisp.evaluator.parallel.args.ArgumentEvaluator;
import main.lisp.evaluator.parallel.pool.ThreadPool;
import main.lisp.evaluator.parallel.pool.ThreadPoolWorker;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import main.util.parallel.Joiner;
import main.util.parallel.MutableJoiner;

public class ClassRegistryImpl implements ClassRegistryA4{

	@Override
	public Class<?> getMain() {
		// TODO Auto-generated method stub
		return Assignment2Class.class;
		//return RunTests.class;
	}

	@Override
	public Class<? extends OperationRegisterer> getCustomOperationRegisterer() {
		// TODO Auto-generated method stub
		return OpRegImpl.class;
	}

	@Override
	public Class<? extends SExpression> getStringFormattingSExpression() {
		// TODO Auto-generated method stub
		return Task1.class;
	}

	@Override
	public Class<? extends Evaluator> getQuoteEvaluator() {
		// TODO Auto-generated method stub
		return QuoteEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getEvalEvaluator() {
		// TODO Auto-generated method stub
		return EvalEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getLoadEvaluator() {
		// TODO Auto-generated method stub
		return LoadEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getCondEvaluator() {
		// TODO Auto-generated method stub
		return CondEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getListEvaluator() {
		// TODO Auto-generated method stub
		return ListEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getLTEvaluator() {
		// TODO Auto-generated method stub
		return LTEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getGTEvaluator() {
		// TODO Auto-generated method stub
		return GTEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getLTEEvaluator() {
		// TODO Auto-generated method stub
		return LTEEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getGTEEvaluator() {
		// TODO Auto-generated method stub
		return GTEEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getAndEvaluator() {
		// TODO Auto-generated method stub
		return AndEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getOrEvaluator() {
		// TODO Auto-generated method stub
		return OrEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getNotEvaluator() {
		// TODO Auto-generated method stub
		return NotEvaluator.class;
	}

	@Override
	public Class<? extends OperationRegisterer> getStatefulOperationRegisterer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends SExpression> getLambdaCallingSExpression() {
		// TODO Auto-generated method stub
		return SExpressionSub.class;
	}

	@Override
	public Class<? extends IdentifierAtom> getIdentifierAtomWithLookup() {
		// TODO Auto-generated method stub
		return IdentifierAtomSub.class;
	}

	@Override
	public Class<? extends Environment> getNestedLexicalEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Evaluator> getBasicFuncallEvaluator() {
		// TODO Auto-generated method stub
		return FunCall.class;
	}

	@Override
	public Class<? extends Evaluator> getLambdaEvaluator() {
		// TODO Auto-generated method stub
		return LambdaEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getSetqEvaluator() {
		// TODO Auto-generated method stub
		return SetqEvaluator.class;
	}

	@Override
	public Class<? extends OperationRegisterer> getAdditionalStatefulOperationRegisterer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends SExpression> getFunctionCallingSExpression() {
		// TODO Auto-generated method stub
		return SExpressionSub.class;
	}

	@Override
	public Class<? extends Environment> getNestedDynamicEnvironment() {
		// TODO Auto-generated method stub
		return AbstractEnvSub.class;
	}

	@Override
	public Class<? extends Evaluator> getDefparameterEvaluator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Evaluator> getDefvarEvaluator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Evaluator> getLetEvaluator() {
		// TODO Auto-generated method stub
		return LetEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getFunctionEvaluator() {
		// TODO Auto-generated method stub
		return FunctionEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getDefunEvaluator() {
		// TODO Auto-generated method stub
		return DeFunEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getCompleteFuncallEvaluator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Evaluator> getCurryEvaluator() {
		// TODO Auto-generated method stub
		return CurryEvaluator.class;
	}

	@Override
	public Class<? extends Evaluator> getDefcurryEvaluator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Joiner> getImmutableJoiner() {
		// TODO Auto-generated method stub
		return BasicJoiner.class;
	}

	@Override
	public Class<? extends MutableJoiner> getMutableJoiner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends OperationRegisterer> getEagerOperationRegisterer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends ThreadPool> getThreadPool() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends ThreadPoolWorker> getThreadPoolWorker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends ArgumentEvaluator> getArgumentEvaluator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends SExpression> getEagerSExpression() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Evaluator> getEagerCurry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Evaluator> getEagerDefcurry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Evaluator> getEagerFuncall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Evaluator> getEagerAnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Evaluator> getEagerOr() {
		// TODO Auto-generated method stub
		return EagerOr.class;
	}

	@Override
	public Class<? extends Evaluator> getEagerList() {
		// TODO Auto-generated method stub
		return EListEvaluator.class;
	}

	@Override
	public Class<?> getServerMain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getClientMain() {
		// TODO Auto-generated method stub
		return null;
	}

}
