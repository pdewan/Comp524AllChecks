package main;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.interpreter.ObservableLispInterpreter;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.StringAtom;
import main.lisp.parser.terms.TAtom;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LoadEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		StringAtom sAtom = (StringAtom) expr.getTail().getHead();
		Path wiki_path = Paths.get(sAtom.getValue());

	    try {
	        List<String> lines = Files.readAllLines(wiki_path);

	        for (String line : lines) {
	          InterpreterModelSingleton.get().newInput(line);
	        }
	      } catch (IOException e) {
	        return new NilAtom();
	      }
	    return new TAtom();
	}

}
