package grasp.components.inputlanguage

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Parameter {

    Literal literal       // TODO: normally terms should be only positive literals (i.e. atoms)
    Variable variable
    Integer constant

    ///////////////////////////////////////
    // qualifiers
    ///////////////////////////////////////

    Boolean isLiteral() {
        (literal != null)
    }

    Boolean isVariable() {
        (variable != null)
    }

    Boolean isConstant() {
        (constant != null)
    }

    ///////////////////////////////////////
    // builders
    ///////////////////////////////////////

    static Parameter build(Literal literal) {
        new Parameter(literal: literal)
    }

    static Parameter build(Integer constant) {
        new Parameter(constant: constant)
    }

    static Parameter build(Variable variable) {
        new Parameter(variable: variable)
    }

    ///////////////////////////////////////
    // views
    ///////////////////////////////////////

    String toString() {
        String output = ""

        if (literal != null) output += literal
        else if (variable != null) output += variable
        else if (constant != null) output += constant.toString()

        output
    }

}
