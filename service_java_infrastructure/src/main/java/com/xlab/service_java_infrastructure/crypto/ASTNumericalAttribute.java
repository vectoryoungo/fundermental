/*
 * module: fundermental
 * file: ASTNumericalAttribute.java
 * date: 3/15/19 4:51 PM
 * author: VectorJu
 */

package com.xlab.service_java_infrastructure.crypto;

import java.math.BigInteger;

public class ASTNumericalAttribute extends SimpleNode {
    private String name;
    private String op;
    private BigInteger value;
    
    
    public ASTNumericalAttribute(int id) {
        super(id);
    }

    public ASTNumericalAttribute(ParseTree p, int id) {
        super(p, id);
    }
    
    public void setValues(String name, String op, String number) {
        this.name = name;
        this.op = op;
        this.value = new BigInteger(number);
    }

    public String getName() {
        return name;
    }
    
    public String getOp() {
        return op;
    }
    
    public BigInteger getValue() {
        return value;
    }
    
    public String toString() {
        return "NumericalAttribute: " + name + " " + op + " " + value;
    }
}