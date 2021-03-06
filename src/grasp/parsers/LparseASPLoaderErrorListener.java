package grasp.parsers;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.ArrayList;
import java.util.List;

public class LparseASPLoaderErrorListener extends BaseErrorListener {

    public List<String> errors = new ArrayList<String>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
        System.out.print("line " + line + ":" + charPositionInLine + " " + msg);
        errors.add("line " + line + ":" + charPositionInLine + " " + msg);
    }
}