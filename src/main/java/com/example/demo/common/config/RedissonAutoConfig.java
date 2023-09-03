//package com.example.demo.common.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.redisson.config.SingleServerConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//
//@Configuration
////@ConditionalOnClass(Config.class)
////@EnableConfigurationProperties(RedissonProperties.class)
//@Slf4j
//public class RedissonAutoConfig {
//    @Autowired
//    private RedissonProperties redissonProperties;
//
//    /**
//     * redisson配置
//     * @return 返回
//     */
////    @Bean
////    @ConditionalOnProperty(name = "spring.redisson.address")
////    public RedissonClient redissonSingle() {
////        log.info(">>>>>>>>>>>>>>>>>>>>>>" + redissonProperties.getAddress());
////        Config config = new Config();
////        SingleServerConfig serversConfig = config.useSingleServer()
////                .setAddress(redissonProperties.getAddress())
////                .setTimeout(redissonProperties.getTimeout())
////                .setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
////                .setConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize());
////        if (StringUtils.isNotEmpty(redissonProperties.getPassword())) {
////            log.info(">>>>>>>>>>>>>>>>>>>>>>" + redissonProperties.getPassword());
////            serversConfig.setPassword(redissonProperties.getPassword());
////        }
////        return Redisson.create(config);
////    }
//    @Bean(destroyMethod="shutdown") // 服务停止后调用 shutdown 方法。
//    public RedissonClient redisson() throws IOException {
//        // 1.创建配置
//        Config config = new Config();
//        // 集群模式
//        // config.useClusterServers().addNodeAddress("127.0.0.1:7004", "127.0.0.1:7001");
//        // 2.根据 Config 创建出 RedissonClient 示例。
//        config.useSingleServer().setAddress("127.0.0.1:6379");
//        return Redisson.create(config);
//    }
//
//}
