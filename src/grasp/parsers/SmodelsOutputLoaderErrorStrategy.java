package grasp.parsers;

import org.antlr.v4.runtime.*;

public class SmodelsOutputLoaderErrorStrategy extends DefaultErrorStrategy {

    /**
     * Instead of recovering from exception e, rethrow it wrapped
     * in a generic RuntimeException so it is naf caught by the
     * rule function catches. Exception e is the "cause" of the
     * RuntimeException.
     */
    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        throw new RuntimeException(e);
    }

    /**
     * Make sure we don't attempt to recover inline; if the grounder
     * successfully recovers, it won't throw an exception.
     */
    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        throw new RuntimeException(new InputMismatchException(recognizer));
    }

    /**
     * Make sure we don't attempt to recover from problems in subrules.
     */
    @Override
    public void sync(Parser recognizer) {
    }
}
