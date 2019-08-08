/*
 * module: fundermental
 * file: Client.java
 * date: 8/8/19 4:31 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 16:31
 * @desc test visitor combine composite
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.visitorcombinebridge;

public class Client {

    public static void main(String[] args) {
        Component root = new Composite("Clothes");
        Component manClothes = new Composite("manClothes");
        Component womanClothes = new Composite("womanClothes");

        Component shirtLeaf = new Leaf("shirt");
        Component jackLeaf = new Leaf("jack");
        Component skirtLeaf = new Leaf("skirt");
        Component suitesLeaf = new Leaf("suites");


        root.addChild(manClothes);
        root.addChild(womanClothes);

        manClothes.addChild(shirtLeaf);
        manClothes.addChild(jackLeaf);

        womanClothes.addChild(skirtLeaf);
        womanClothes.addChild(suitesLeaf);

        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.setRoot(root);

        Visitor printVisitor = new PrintNameVisitor();
        objectStructure.handleRequest(printVisitor);
    }
}

