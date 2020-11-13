package main;

import java.util.ArrayList;

import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.BasicFunction;
import main.lisp.evaluator.function.BasicLambda;
import main.lisp.evaluator.function.Function;
import main.lisp.evaluator.function.FunctionFactory;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class SExpressionSub extends Task1{

	public SExpressionSub(SExpression head, SExpression tail) {
		super(head, tail);
		// TODO Auto-generated constructor stub
	}
	
	public SExpression eval(Environment environment)
	{
		if (getHead() instanceof BasicFunction)
		{
			BasicFunction fun = (BasicFunction)getHead();
			Environment cEnv = assignVals(fun.getEnvironment().newChild(), fun.getLambda(), 
					getVals(this.getTail(), environment, new ArrayList<>()), environment, this.getTail());
			return fun.getLambda().eval(cEnv);
		}else if (getHead() instanceof IdentifierAtom) {
			String operator = ((IdentifierAtom)getHead()).getValue();
			Evaluator eval = BuiltinOperationManagerSingleton.get().getEvaluator(operator);
			SExpression val;
			try 
			{
			val = environment.lookupFun((IdentifierAtom)getHead()).get();
			} catch (Exception e)
			{
				if (eval == null) {
					throw new IllegalStateException("No evaluator registered for operator '" + operator + "'");
				}
				return eval.eval(this, environment);
				
			}
			Environment cEnv = assignVals(((BasicFunction) val).getEnvironment(), ((BasicFunction) val).getLambda(),
					getVals(getTail(), environment, new ArrayList<SExpression>()), environment, getTail());
			return ((BasicFunction) val).getLambda().eval(cEnv);
		} else if (getHead() instanceof Task1)
		{
			if (getHead().getHead() instanceof BasicFunction)
			{
				BasicFunction fun = (BasicFunction)getHead();
				return fun.getLambda().eval(fun.getEnvironment());
			}
			String operator = ((IdentifierAtom)getHead().getHead()).getValue();
			Evaluator eval = BuiltinOperationManagerSingleton.get().getEvaluator(operator);
			if (!operator.equalsIgnoreCase("LAMBDA"))
			{
				Lambda fac = (Lambda) getHead().eval(environment);
				Environment cEnv = assignVals(environment.newChild(), fac, 
						 getVals(this.getTail(), environment, new ArrayList<SExpression>()), environment, this.getTail());
				return fac.eval(cEnv);
				
			}
			Lambda fac = (Lambda) eval.eval(this,  environment);
			Environment cEnv = assignVals(environment.newChild(), fac, 
					 getVals(this.getTail(), environment, new ArrayList<SExpression>()), environment, this.getTail());
			return fac.eval(cEnv);
			
		} else if (getHead() instanceof BasicLambda)
		{
			Lambda fac = (Lambda)getHead();
			Environment cEnv = assignVals(environment.newChild(), fac, 
					 getVals(this.getTail(), environment, new ArrayList<SExpression>()), environment, this.getTail());;
			return fac.eval(cEnv);
		}
		else
		{
			throw new IllegalStateException("Expression does not start with an operator");
		}
	}
	
	public SExpression[] getVals(SExpression expr, Environment environment, ArrayList list)
	{
		if (expr instanceof Atom)
		{
			list.add(expr.eval(environment));
			return (SExpression[]) list.toArray(new SExpression[list.size()]);
		}
		list.add(expr.getHead().eval(environment));
		if (expr.getTail() instanceof NilAtom)
		{
			return (SExpression[]) list.toArray(new SExpression[list.size()]);
		}
		return getVals(expr.getTail(), environment, list);
	}
	
	
//	public SExpression[] getVals(SExpression expr, Environment environment, ArrayList<SExpression> list)
//	{
//		if (expr instanceof Atom)
//		{
//			if (expr instanceof IdentifierAtom)
//			{
//				list.add(expr.eval(environment));
//				return list.toArray(new SExpression[list.size()]);
//			}
//			list.add(expr);
//			return list.toArray(new SExpression[list.size()]);
//		}
//		if (expr instanceof Task1)
//		{
//			if (expr.getTail() instanceof Atom && !(expr.getTail() instanceof NilAtom))
//			{
//				if (expr instanceof IdentifierAtom)
//				{
//					list.add(expr.eval(environment));
//					return list.toArray(new SExpression[list.size()]);
//				}
//				list.add(expr);
//				return list.toArray(new SExpression[list.size()]);
//			}
//			else if (expr.getTail() instanceof NilAtom && expr.getHead() instanceof Atom && !(expr.getHead() instanceof IdentifierAtom))
//			{
//				if (expr instanceof IdentifierAtom)
//				{
//					list.add(expr.getHead().eval(environment));
//					return list.toArray(new SExpression[list.size()]);
//				}
//				list.add(expr.getHead());
//				//list.add(expr);
//				return list.toArray(new SExpression[list.size()]);
//			} else
//			{
//			if (expr instanceof IdentifierAtom)
//			{
//				list.add(expr.getHead().eval(environment));
//			} else
//			{
//				// list.add(expr.getHead();
//				if (expr.getHead() instanceof IdentifierAtom)
//				{
//					list.add(expr.getHead().eval(environment));
////					if (!(expr.getTail() instanceof NilAtom))
////					{
////						//list.add(expr.getHead().eval(environment));
////						if (expr.getTail().getHead() instanceof IdentifierAtom && expr.getTail().getTail() instanceof Task1)
////						{
////							list.add(expr.getTail().getHead().eval(environment));
////						} else
////						{
////							list.add(expr.getHead().eval(environment));
////						}
////					} else
////					{
////						list.add(expr.getHead().eval(environment));
////					}
//				}
//				else if (expr.getHead() instanceof Task1)
//				{
//					if (expr.getHead().getHead() instanceof IdentifierAtom)
//					{
//						list.add(expr.getHead().eval(environment));
//					}
//				}
////				else if (expr.getHead() instanceof Atom && expr.getTail() instanceof Task1 && expr.isList())
////				{
////					list.add(expr);
////					return list.toArray(new SExpression[list.size()]);
////				} 
//				else
//				{
//					list.add(expr.getHead());
//				}
//			}
//			}
//		}
//		if (expr.getTail() instanceof NilAtom)
//		{
//			return list.toArray(new SExpression[list.size()]);
//		}
//		return getVals(expr.getTail(), environment, list);
//	}
	
	public Environment assignVals(Environment cEnv, Lambda fac, SExpression[] values, Environment environment, SExpression expr)
	{
		if (fac.getArgumentNames().length == 1)
		{
			if (expr instanceof IdentifierAtom)
			{
				cEnv.makeLocalSpecial(fac.getArgumentNames()[0]);
				cEnv.assign(fac.getArgumentNames()[0], expr.eval(environment));
				return cEnv;
			}
			if (values.length > 0)
			{
				if (values[0] instanceof Atom)
				{
					cEnv.makeLocalSpecial(fac.getArgumentNames()[0]);
					cEnv.assign(fac.getArgumentNames()[0], values[0]);
					return cEnv;
				} else if (expr instanceof Task1)
				{
				    if  (values[0] instanceof Task1 && expr.getTail() instanceof NilAtom)
					{
				    	cEnv.makeLocalSpecial(fac.getArgumentNames()[0]);
						cEnv.assign(fac.getArgumentNames()[0], values[0]);
						return cEnv;
					}
				}
			}
			cEnv.assign(fac.getArgumentNames()[0], expr);
			return cEnv;
		}
		for (int i = 0; i < fac.getArgumentNames().length; i++)
		{
			if (i < values.length) 
			{
//					if (values[i] instanceof Task1)
//					{
//						if (values[i].getHead() instanceof Atom && !(values[i].getHead() instanceof NilAtom) && !(values[i].getHead() instanceof IdentifierAtom))
//						{
//							cEnv.assign(fac.getArgumentNames()[i], values[i].getHead());
//						} else
//						{
//							cEnv.assign(fac.getArgumentNames()[i], values[i]);
//						}
//						
//					} else {
					cEnv.makeLocalSpecial(fac.getArgumentNames()[i]);
					cEnv.assign(fac.getArgumentNames()[i], values[i]);
//					}
			}
		}
		return cEnv;
	}

}
