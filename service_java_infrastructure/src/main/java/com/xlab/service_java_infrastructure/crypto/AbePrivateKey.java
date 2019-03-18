/*
 * module: fundermental
 * file: AbePrivateKey.java
 * date: 3/14/19 11:25 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure.crypto;

import it.unisa.dia.gas.jpbc.Element;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AbePrivateKey {
    /*
     * A private key
     */
    /**
     * G2
     **/
    Element d;
    ArrayList<Bsw07PrivateKeyComponent> components;
    AbePublicKey pubKey;

    public AbePrivateKey(Element d, ArrayList<Bsw07PrivateKeyComponent> components, AbePublicKey pubKey) {
        this.d = d;
        this.components = components;
        this.pubKey = pubKey;
    }

    public static AbePrivateKey readFromFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            return readFromStream(fis);
        }
    }

    public static AbePrivateKey readFromStream(InputStream stream) throws IOException {
        AbeInputStream abeStream = new AbeInputStream(stream);
        AbePublicKey pubKey = AbePublicKey.readFromStream(abeStream);
        abeStream.setPublicKey(pubKey);
        Element d = abeStream.readElement();
        int compsLength = abeStream.readInt();
        ArrayList<Bsw07PrivateKeyComponent> components = new ArrayList<Bsw07PrivateKeyComponent>(compsLength);

        for (int i = 0; i < compsLength; i++) {
            components.add(Bsw07PrivateKeyComponent.readFromStream(abeStream));
        }
        return new AbePrivateKey(d, components, pubKey);
    }

    public AbePublicKey getPublicKey() {
        return pubKey;
    }

    /**
     * @return a new privatekey, where d and the component list has been duplicated. The list elements have NOT been duplicated.
     */
    public AbePrivateKey duplicate() {
        ArrayList<Bsw07PrivateKeyComponent> duplicatedComponents = new ArrayList<Bsw07PrivateKeyComponent>(components.size());
        for (Bsw07PrivateKeyComponent cur : components) {
            // should each component also be duplicated? only necessary if components are altered somewhere, which they are not
            duplicatedComponents.add(cur);
        }
        return new AbePrivateKey(d.duplicate(), duplicatedComponents, pubKey);
    }

    public Element getD() {
        return d;
    }

    public List<Bsw07PrivateKeyComponent> getComponents() {
        return components;
    }

    public Bsw07PrivateKeyComponent getSatisfyingComponent(Element hashedAttribute) {
        for (int i = 0; i < components.size(); i++) {
            Bsw07PrivateKeyComponent component = components.get(i);
            if (component.hashedAttribute.isEqual(hashedAttribute)) {
                return component;
            }
        }
        return null;
    }

    public AbePrivateKey newKeyWithAddedAttributes(List<Bsw07PrivateKeyComponent> newComponents) {
        AbePrivateKey newKey = this.duplicate();
        newKey.components.addAll(newComponents);
        return newKey;
    }

    public void writeToStream(OutputStream stream) throws IOException {
        AbeOutputStream abeStream = new AbeOutputStream(stream, pubKey);
        pubKey.writeToStream(abeStream);
        abeStream.writeElement(d);
        int compsLength = components.size();
        abeStream.writeInt(compsLength);
        for (Bsw07PrivateKeyComponent component : components) {
            component.writeToStream(abeStream);
        }
    }

    public void writeToFile(File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            writeToStream(fos);
        }
    }
}