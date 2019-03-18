/*
 * module: fundermental
 * file: ASTOf.java
 * date: 3/15/19 4:51 PM
 * author: VectorJu
 */

package com.xlab.service_java_infrastructure.crypto;

public class ASTOf extends SimpleNode {
	private int number;

	public ASTOf(int id) {
		super(id);
	}

	public ASTOf(ParseTree p, int id) {
		super(p, id);
	}

	public void setNumber(String numberString) {
		this.number = Integer.parseInt(numberString);
	}

	public int getNumber() {
		return number;
	}

	public String toString() {
		return "Of: " + number;
	}
}
