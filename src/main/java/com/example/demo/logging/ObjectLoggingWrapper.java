package com.example.demo.logging;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.nio.file.SensitivityWatchEventModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName ObjectLoggingWrapper
 * @Description
 * @Author ian
 * @Date 2021/7/20 21:19
 * @Version 1.0.0
 **/
public class ObjectLoggingWrapper {

    private final static Logger logger = LoggerFactory.getLogger(ObjectLoggingWrapper.class);
    private final static ObjectMapper objectMapper = new ObjectMapper() {
        private static final long serialVersionUID = 1L;
        {
            setSerializationInclusion(JsonInclude.Include.ALWAYS);
            configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
            configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
//            setSerializerFactory(getSerializerFactory().withSerializerModifier(new Sensitiv));

        }
    };
}
