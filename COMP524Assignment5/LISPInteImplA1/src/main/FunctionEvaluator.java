package main;

import java.util.ArrayList;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.FunctionFactory;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class FunctionEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		//Environment StaticEnvironment = environment;
		Environment cEnv = new AbstractEnvSub(environment);
		 if (expr.getHead() instanceof IdentifierAtom)
		 {
			 Lambda fac = LambdaFactory.newInstance(getArgs(expr.getTail().getHead().getTail().getHead(), environment, new ArrayList<IdentifierAtom>()), expr.getTail().getHead().getTail().getTail());
			 return FunctionFactory.newInstance(fac, environment);
		 }
		
		 Lambda fac = LambdaFactory.newInstance(getArgs(expr.getHead().getTail().getHead(), 
				environment, new ArrayList<IdentifierAtom>()), expr.getHead().getTail().getTail());
		 if (expr.getHead().getTail().getHead() instanceof NilAtom)
		 {
			 return fac.eval(cEnv);
		 }
//		 cEnv = assignVals(cEnv.newChild(), fac, 
//				 getVals(expr.getTail(), environment, new ArrayList<SExpression>()), environment, expr.getTail());
//		 
		 return FunctionFactory.newInstance(fac, environment);
	}
	
	public IdentifierAtom[] getArgs(SExpression expr, Environment environment, ArrayList<IdentifierAtom> list)
	{
		if (expr instanceof NilAtom)
		{
			return list.toArray(new IdentifierAtom[list.size()]);
		}
		list.add((IdentifierAtom) expr.getHead());
		if (expr.getTail() instanceof NilAtom)
		{
			return list.toArray(new IdentifierAtom[list.size()]);
		}
		return getArgs(expr.getTail(), environment, list);
	}
	
	public SExpression[] getVals(SExpression expr, Environment environment, ArrayList<SExpression> list)
	{
		if (expr instanceof Atom)
		{
			if (expr instanceof IdentifierAtom)
			{
				list.add(expr.eval(environment));
				return list.toArray(new SExpression[list.size()]);
			}
			list.add(expr);
			return list.toArray(new SExpression[list.size()]);
		}
		if (expr instanceof Task1)
		{
			if (expr.getTail() instanceof Atom && !(expr.getTail() instanceof NilAtom))
			{
				if (expr instanceof IdentifierAtom)
				{
					list.add(expr.eval(environment));
					return list.toArray(new SExpression[list.size()]);
				}
				list.add(expr);
				return list.toArray(new SExpression[list.size()]);
			}
			else if (expr.getTail() instanceof NilAtom && expr.getHead() instanceof Atom && !(expr.getHead() instanceof IdentifierAtom))
			{
				if (expr instanceof IdentifierAtom)
				{
					list.add(expr.getHead().eval(environment));
					return list.toArray(new SExpression[list.size()]);
				}
				list.add(expr.getHead());
				//list.add(expr);
				return list.toArray(new SExpression[list.size()]);
			} else
			{
			if (expr instanceof IdentifierAtom)
			{
				list.add(expr.getHead().eval(environment));
			} else
			{
				// list.add(expr.getHead();
				if (expr.getHead() instanceof IdentifierAtom)
				{
					list.add(expr.getHead().eval(environment));
				}
				else if (expr.getHead() instanceof Task1)
				{
					if (expr.getHead().getHead() instanceof IdentifierAtom)
					{
						list.add(expr.getHead().eval(environment));
					}
				}
//				else if (expr.getHead() instanceof Atom && expr.getTail() instanceof Task1 && expr.isList())
//				{
//					list.add(expr);
//					return list.toArray(new SExpression[list.size()]);
//				} 
				else
				{
					list.add(expr.getHead());
				}
			}
			}
		}
		if (expr.getTail() instanceof NilAtom)
		{
			return list.toArray(new SExpression[list.size()]);
		}
		return getVals(expr.getTail(), environment, list);
	}
	
	public Environment assignVals(Environment cEnv, Lambda fac, SExpression[] values, Environment environment, SExpression expr)
	{
		if (fac.getArgumentNames().length == 1)
		{
			if (expr instanceof IdentifierAtom)
			{
				cEnv.assign(fac.getArgumentNames()[0], expr.eval(environment));
				return cEnv;
			}
			if (values.length > 0)
			{
				if (values[0] instanceof Atom)
				{
					cEnv.assign(fac.getArgumentNames()[0], values[0]);
					return cEnv;
				} else if (expr instanceof Task1)
				{
				    if  (values[0] instanceof Task1 && expr.getTail() instanceof NilAtom)
					{
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
					cEnv.assign(fac.getArgumentNames()[i], values[i]);
//					}
			}
		}
		
		return cEnv;
		
	}

	public Environment specialAssignVal(Environment cEnv, Lambda fac, SExpression expr)
	{
		cEnv.assign(fac.getArgumentNames()[0], expr);
		return cEnv;
	}
}

