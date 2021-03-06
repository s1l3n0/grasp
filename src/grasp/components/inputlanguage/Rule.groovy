package grasp.components.inputlanguage

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
public class Rule {
    Formula head
    Formula body

    ///////////////////////////////////////
    // qualifiers
    ///////////////////////////////////////

    boolean isFact() {
        return body == null && head != null;
    }

    boolean isConstraint() {
        return body != null && head == null;
    }

    boolean isRule() {
        return body != null && head != null;
    }

    ///////////////////////////////////////
    // builders
    ///////////////////////////////////////

    static Rule build(Formula head, Formula body) {
        return new Rule(head: head, body: body)
    }

    static Rule build(Literal conclusion, Formula body) {
        Formula head = Formula.build(conclusion);
        return new Rule(head: head, body: body)
    }

    static Rule build(Literal fact) {
        Formula head = Formula.build(fact);
        return new Rule(head: head, body: null)
    }

    static Rule build(Literal conclusion, Literal premise) {
        Formula head = Formula.build(conclusion);
        Formula body = Formula.build(premise);
        return new Rule(head: head, body: body)
    }

    static Rule build(Literal conclusion, List<Literal> premises) {
        Formula head = Formula.build(conclusion);
        Formula body = Formula.buildFromLiterals(premises, Operator.AND);
        return new Rule(head: head, body: body)
    }

    static Rule build(List<Literal> conclusions, List<Literal> premises) {
        Formula head = Formula.buildFromLiterals(conclusions, Operator.AND);
        Formula body = Formula.buildFromLiterals(premises, Operator.AND);
        return new Rule(head: head, body: body)
    }

    ///////////////////////////////////////
    // converters
    ///////////////////////////////////////

    Formula toFormula() {
        if (body != null && head != null)
            Formula.build(body, head, Operator.IF)
        else if (body != null)
            Formula.build(head, Operator.NAF) // TODO CHECK
        else if (head != null)
            Formula.build(head, Operator.POS)
        else
            throw new RuntimeException("Empty formula not expected.")
    }

    ///////////////////////////////////////
    // views
    ///////////////////////////////////////

    String toString() {
        String output = ""

        if (head != null)
            output += head.toString()
        if (body != null) {
            output += " :- "
            output += body.toString()
        }
        output
    }

}