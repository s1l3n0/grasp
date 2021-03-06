package grasp.components.inputlanguage

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Term {

    ExtLiteral extLiteral
    Variable variable
    Integer number

    ///////////////////////////////////////
    // qualifier
    ///////////////////////////////////////

    Boolean isVariable() {
        return (variable != null)
    }

    Boolean isNumber() {
        return (number != null)
    }

    Boolean isExtLiteral() {
        return (extLiteral != null)
    }

    Boolean isLiteral() {
        return (extLiteral != null && extLiteral.isLiteral())
    }

    Boolean isAtom() {
        return (extLiteral != null && extLiteral.isAtom())
    }

    Boolean isIdentifier() {
        return (extLiteral != null && extLiteral.isIdentifier())
    }

    ///////////////////////////////////////
    // operations
    ///////////////////////////////////////

    Term negate() {
        if (extLiteral != null)
            build(extLiteral.negate())
        else
            throw new RuntimeException("Negation on a naf literal term.")
    }

    Literal getLiteral() {
        return extLiteral.literal
    }

    ///////////////////////////////////////
    // builders
    ///////////////////////////////////////

    static build(String functor) {
        new Term(
                extLiteral: ExtLiteral.build(functor)
        )
    }

    static build(Literal literal) {
        new Term(
                extLiteral: ExtLiteral.build(literal)
        )
    }

    static build(ExtLiteral extLiteral) {
        new Term(
                extLiteral: extLiteral
        )
    }

    ///////////////////////////////////////
    // views
    ///////////////////////////////////////

    String toString() {
        String output = ""

        if (extLiteral != null) output += extLiteral.toString()
        else if (variable != null) output += variable.toString()
        else if (number != null) output += number

        output
    }

    String toASP() {
        String output = ""

        if (extLiteral != null) output += extLiteral.toASP()
        else if (variable != null) output += variable.toString()
        else if (number != null) output += number

        output
    }
}
