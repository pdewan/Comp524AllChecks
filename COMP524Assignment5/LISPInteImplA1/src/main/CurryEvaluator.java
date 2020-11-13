package main;

import java.util.ArrayList;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.BasicFunction;
import main.lisp.evaluator.function.FunctionFactory;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.IdentifierAtomFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.scanner.tokens.QuoteToken;
import main.lisp.scanner.tokens.Token;
import main.lisp.scanner.tokens.TokenFactory;
import main.lisp.scanner.tokens.TokenType;

public class CurryEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		SExpression expr2 = expr.getTail().getHead().eval(environment);
		Lambda fac;
		if (expr2 instanceof BasicFunction)
		{
			fac = ((BasicFunction) expr2).getLambda();
		} else {
		fac = LambdaFactory.newInstance(getArgs(expr.getTail().getHead().eval(environment).getTail().getHead(), environment, new ArrayList<>())
				,expr2.getTail().getTail());
		}
//		Lambda fac = LambdaFactory.newInstance(((Lambda) findDeepestExpr(expr, environment)).getArgumentNames(), expr2.getTail().getTail());
		IdentifierAtom[] args = fac.getArgumentNames();
		IdentifierAtom[] cArgs = getCArgs(args, countArgs(expr.getTail().getTail(), 0));
		if (expr2 instanceof BasicFunction)
		{
			// if expr2 evaluates to a function, need to return a function in order to maintain scoped environment
			return FunctionFactory.newInstance(LambdaFactory.newInstance(cArgs, createCurry(fac, cArgs, expr.getTail(), environment)),
					((BasicFunction) expr2).getEnvironment());
		}
		return LambdaFactory.newInstance(cArgs, createCurry(fac, cArgs, expr.getTail(), environment));
	}
	
	public IdentifierAtom[] getCArgs(IdentifierAtom[] org, int n)
	{
		ArrayList list = new ArrayList<IdentifierAtom>();
		for (int i = n; i < org.length; i++)
		{
			list.add(org[i]);
		}
		return (IdentifierAtom[]) list.toArray(new IdentifierAtom[list.size()]);
		
	}
	
	public SExpression createCurry(Lambda fac, IdentifierAtom[] args, SExpression expr, Environment env)
	{
//		return ExpressionFactory.newInstance((SExpression) IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "FUNCALL")), 
//						ExpressionFactory.newInstance(
//								ExpressionFactory.newInstance(IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "QUOTE")), fac)
//								, chainCurry(expr.getTail(), env, args)));
//		return ExpressionFactory.newInstance(
//				ExpressionFactory.newInstance((SExpression) IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "FUNCALL")), 
//						ExpressionFactory.newInstance(ExpressionFactory.newInstance(IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "QUOTE")), fac),
//								chainCurry(expr.getTail(), env, args))),
//				addCurryArgs(args, 0, env)
//				);
		
//		return ExpressionFactory.newInstance(
//				ExpressionFactory.newInstance((SExpression) IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "FUNCALL")), 
//						ExpressionFactory.newInstance(
//								ExpressionFactory.newInstance(
//										ExpressionFactory.newInstance(IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "QUOTE")), 
//													ExpressionFactory.newInstance(fac, new NilAtom())
//															  		), chainCurry(expr.getTail(), env, args)
//													  		  ), new NilAtom()
//								)),
//				addCurryArgs(args, 0, env)
//											);
		return ExpressionFactory.newInstance(
				ExpressionFactory.newInstance((SExpression) IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "FUNCALL")), 
						ExpressionFactory.newInstance(
								ExpressionFactory.newInstance(
										ExpressionFactory.newInstance(IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "QUOTE")), 
													ExpressionFactory.newInstance(fac, new NilAtom())
															  		), chainCurry(expr.getTail(), env, args)
													  		  ), new NilAtom()
								)), new NilAtom());
		
	}
	
	
	public SExpression chainCurry(SExpression expr, Environment env, IdentifierAtom[] args)
	{
		if (expr.getTail() instanceof NilAtom)
		{
			return ExpressionFactory.newInstance(
					ExpressionFactory.newInstance(
							IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "QUOTE")),
							ExpressionFactory.newInstance(expr.getHead().eval(env), new NilAtom())),
							addCurryArgs(args, 0, env));
		}
		return ExpressionFactory.newInstance(
				ExpressionFactory.newInstance(
						IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, "QUOTE")),
						ExpressionFactory.newInstance(expr.getHead().eval(env), new NilAtom())),
						chainCurry(expr.getTail(), env, args));
	}
	
	public SExpression addCurryArgs(IdentifierAtom[] args, int counter, Environment env)
	{
		if (counter < args.length - 1)
		{
			return ExpressionFactory.newInstance(args[counter], addCurryArgs(args, counter + 1, env));
		} else {
			return ExpressionFactory.newInstance(args[counter], new NilAtom());
		}
	}
	
	public int countArgs(SExpression expr, int c)
	{
		if (expr.getTail() instanceof NilAtom)
		{
			return c + 1;
		} else if (!(expr.getTail() instanceof Atom))
		{
			return countArgs(expr.getTail(), c + 1);
		} else {
			return c + 2;
		}
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
	
	public SExpression findDeepestExpr(SExpression expr, Environment env)
	{
		if (expr.getTail() instanceof NilAtom)
		{
			return expr.getHead().eval(env);
		} else if (expr.getTail() instanceof Atom) {
			return expr.getTail().eval(env);
		}
		return findDeepestExpr(expr.getTail(), env);
	}
}
