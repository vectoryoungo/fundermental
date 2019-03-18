/*
 * module: fundermental
 * file: ASTOf.java
 * date: 3/15/19 4:51 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
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
