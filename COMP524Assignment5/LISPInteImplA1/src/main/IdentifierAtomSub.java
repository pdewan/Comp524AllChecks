package main;

import java.util.NoSuchElementException;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.scanner.tokens.Token;
import main.lisp.scanner.tokens.TokenFactory;
import main.lisp.scanner.tokens.TokenType;

public class IdentifierAtomSub extends IdentifierAtom{

	public IdentifierAtomSub(Token token) {
		super(token);
	}

	public IdentifierAtomSub(String string) {
		this(TokenFactory.newInstance(TokenType.IDENTIFIER, string));
	}
	
	public SExpression eval(Environment environment)
	{
		try {
		if (environment.lookup(this).get() instanceof Task1)
		{
			if (environment.lookup(this).get().getTail() instanceof NilAtom)
			{
				//return environment.lookup(this).get().eval(environment).getHead();
				if (environment.lookup(this).get().getHead() instanceof Task1)
				{
					if (environment.lookup(this).get().getHead().getHead() instanceof IdentifierAtom)
					{
						return environment.lookup(this).get().getHead().eval(environment);
					}
					return environment.lookup(this).get();
				} 
				if (environment.lookup(this).get().getHead() instanceof Atom && !(environment.lookup(this).get().getHead() instanceof IdentifierAtom))
				{
					return environment.lookup(this).get();
				}
//				if (environment.lookup(this).get().getTail() instanceof NilAtom && environment.lookup(this).get().getHead() instanceof Task1)
//				{
//					return environment.lookup(this).get();
//				}
				return environment.lookup(this).get().getHead();
			}
			return environment.lookup(this).get();
		}
		} catch (NoSuchElementException e)
		{
		return environment.getParent().lookup(this).get();
		}
		return environment.lookup(this).get();
	}

}
