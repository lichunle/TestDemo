package com.example.demo.common.config;

import com.example.demo.common.utils.CertNoSecureHelper;
import com.example.demo.interceptor.RestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfig {

//    @Bean
//    public CertNoSecureHelper createCertNoSecureHelper() throws Exception {
//        List<String> keyList1 = new ArrayList<>();
//        keyList1.add("vBbwHMFdUIlu0GO2EnmDmw==");
//        List<String> keyList2 = new ArrayList<>();
//        keyList2.add("06YqAvZjKnkLYx8KCxGTow==");
//        return new CertNoSecureHelper(keyList1, keyList2);
//    }

//    @Bean
//    public RestInterceptor restInterceptorBean() {
//        return new RestInterceptor();
//    }
}
