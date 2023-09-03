///*
// * Copyright (c) 2015-2025 by HRT All rights reserved
// */
//package com.example.demo.logging;
//
//import com.crt.wallet.infra.common.secure.sensitivedata.SensitiveDataMasker;
//import com.crt.wallet.infra.common.secure.sensitivedata.SensitiveDataMaskerRegistry;
//import com.crt.wallet.infra.constants.annotation.MaskSensitiveData;
//import com.fasterxml.jackson.databind.BeanDescription;
//import com.fasterxml.jackson.databind.SerializationConfig;
//import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
//import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
//import org.springframework.util.StringUtils;
//
//import java.util.List;
//
///**
// * @description SensitiveDataGuardBeanSerializerModifier
// * @author <a href="mailto:wengyongyi@crc.com.hk">wengyongyi</a>
// * @since 2017年8月10日
// * @version 1.0.0
// */
//public class SensitiveDataGuardBeanSerializerModifier extends BeanSerializerModifier {
//	@Override
//	public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
//			List<BeanPropertyWriter> beanProperties) {
//		for (int i = 0; i < beanProperties.size(); i++) {
//			BeanPropertyWriter writer = beanProperties.get(i);
//			MaskSensitiveData ann = writer.getAnnotation(MaskSensitiveData.class);
//			if (null != ann) {
//				SensitiveDataMasker masker = null;
//				if (StringUtils.hasText(ann.maskerClassName())) {
//					masker = SensitiveDataMaskerRegistry.getSensitiveDataMasker(ann.maskerClassName());
//				}
//				writer.assignSerializer(new SensitiveDataSerializer(masker));
//			}
//		}
//		return beanProperties;
//	}
//
//}
