package main;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.environment.AbstractEnvironment;
import main.lisp.evaluator.environment.BasicScope;
import main.lisp.evaluator.environment.CopyableScope;
import main.lisp.evaluator.function.Function;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.IdentifierAtomFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.scanner.tokens.TokenFactory;
import main.lisp.scanner.tokens.TokenType;

public class AbstractEnvSub extends AbstractEnvironment{
	
	public AbstractEnvSub() {
		this(null);
	}
	
	public AbstractEnvSub(Environment parent)
	{
		super(parent);
	}
	

	@Override
	public synchronized Optional<SExpression> lookup(IdentifierAtom id) {
		if (!this.get(id).isEmpty())
		{
			return this.get(id);
		} else if (getParent() != null)
		{
			return getParent().lookup(id);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Function> lookupFun(IdentifierAtom id) {
		// TODO Auto-generated method stub
		if (!this.getFun(id).isEmpty())
		{
			return this.getFun(id);
		} else if (getParent() != null)
		{
			return getParent().lookupFun(id);
		}
		return Optional.empty();
	}
	
	public synchronized boolean isInScope(IdentifierAtom id) {
		Optional<SExpression> retVal = this.getScope().get(id);
		return (retVal.isPresent() || this.getScope().isSpecial(id));
	}

	@Override
	public synchronized void assign(IdentifierAtom id, SExpression value) {
		// mess up
		boolean nxt = true;
		AbstractEnvSub nEnv = this;
		do {
			if (!nEnv.isInScope(id)) {
				if (nEnv.getParent() != null) {
					nEnv = (AbstractEnvSub) nEnv.getParent();
				} else {
					nxt = false;
				}
			} else {
				nxt = false;
			}
		} while (nxt == true);
		nEnv.getScope().put(id, value);
		
	}

	@Override
	public void assignFun(IdentifierAtom id, Function value) {
		this.getScope().putFun(id, value);
	}

	@Override
	public Environment newChild() {
		// TODO Auto-generated method stub
		return new AbstractEnvSub(this);
	}

	@Override
	public Environment copy() {
		// TODO Auto-generated method stub
		// change for deep copy
		if (LispInterpreterSettings.deepCopyEnvironment)
		{
			Environment nEnv = new AbstractEnvSub(this);
			for (String str : this.getValueMap().keySet())
			{
				nEnv.put(IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, str))
					, this.lookup(IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, str))).get());
			}
			
			for (String str: this.getFunctionMap().keySet())
			{
				nEnv.putFun(IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, str))
						, this.lookupFun(IdentifierAtomFactory.newInstance(TokenFactory.newInstance(TokenType.IDENTIFIER, str))).get());
			}
			return nEnv;
		}
		return this;
	}

}
