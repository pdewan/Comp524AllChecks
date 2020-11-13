package main;

import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class Task1 extends BasicExpression {

	public Task1(SExpression head, SExpression tail) {
		super(head, tail);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isList()
	{
		if (this.getTail() instanceof NilAtom && !(this.getHead() instanceof NilAtom))
		{
			return true;
		} else if (this.getTail() instanceof Atom && !(this.getTail() instanceof NilAtom) && this.getHead() instanceof Atom)
		{
			return false;
		} else if (this.getHead() instanceof NilAtom)
		{
			return false;
		}
		return this.getTail().isList();
	}
	
	public String toStringAsSExpressionDeep() {
		return "(" + this.getHead().toStringAsSExpressionDeep() + " " + "." + " " + this.getTail().toStringAsSExpressionDeep() + ")";
		
	}
	
	public String toStringAsSExpression()
	{
		return "(" + this.getHead().toString() + " " + "." + " " + this.getTail().toString() + ")";
	}
	
	public String toStringAsList()
	{
		if (!(this.getHead() instanceof NilAtom) && this.getTail() instanceof NilAtom)
		{
			return this.getHead().toString();
		} 
		return this.getHead().toString() + " " + this.getTail().toStringAsList();
	}
	
	public String toString()
	{
		return this.isList()? "(" + this.toStringAsList() + ")" : this.toStringAsSExpression();
	}
}

