/*
 * module: fundermental
 * file: SerializableFactory4Marshalling.java
 * date: 6/27/19 5:13 PM
 * author: VectorJu
 */

/**
 * @create 2019-06-27 17:13
 * @desc
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

public class SerializableFactory4Marshalling {

    public static MarshallingDecoder buildMarshallingDecorder() {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration marshallingConfiguration = new MarshallingConfiguration();
        marshallingConfiguration.setVersion(5);

        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(marshallerFactory,marshallingConfiguration);
        MarshallingDecoder decoder = new MarshallingDecoder(provider,1024*1024*1);
        return decoder;
    }

    public static MarshallingEncoder buildMarshallingEncode() {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration marshallingConfiguration = new MarshallingConfiguration();
        marshallingConfiguration.setVersion(5);
        MarshallerProvider provider = new DefaultMarshallerProvider(marshallerFactory,marshallingConfiguration);
        MarshallingEncoder encoder = new MarshallingEncoder(provider);
        return encoder;
    }
}

