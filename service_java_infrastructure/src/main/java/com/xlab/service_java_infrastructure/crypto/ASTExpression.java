/*
 * module: fundermental
 * file: ASTExpression.java
 * date: 3/15/19 4:51 PM
 * author: VectorJu
 */

package com.xlab.service_java_infrastructure.crypto;

public class ASTExpression extends SimpleNode {
	private String type = null;

	public ASTExpression(int id) {
		super(id);
	}

	public ASTExpression(ParseTree p, int id) {
		super(p, id);
	}

	public void setType(String type) throws ParseException {
		if (this.type != null) {
			if (!this.type.equals(type)) throw new ParseException("Different Type already set. (Dont mix and/or without parenthesis)");
		} else {
			this.type = type;
		}
	}

	public String getType() {
		return type;
	}

	public String toString() {
		return "Expressiontype: " + type;
	}
}
