/*
 * module: fundermental
 * file: ASTExpression.java
 * date: 3/15/19 4:51 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
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
