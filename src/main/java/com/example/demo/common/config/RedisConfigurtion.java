package com.example.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfigurtion {

    /**
     * 配置自定义redisTemplate
     * RedisAutoConfiguration SpringBoot自动帮我们在容器中生成了一个RedisTemplate和一个StringRedisTemplate。
     * 但是，这个RedisTemplate的泛型是Object,Object
     * redis 配置中心自动刷新目前不支持
     *
     * @param lettuceConnectionFactory lettuceConnectionFactory
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());

        //json序列化
        template.setValueSerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

//    /**
//     * jackson序列化
//     *
//     * @return RedisSerializer
//     */
//    @Bean
//    public RedisSerializer<Object> jackson2JsonRedisSerializer() {
//        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        serializer.setObjectMapper(om);
//        return serializer;
//    }
//
//    /**
//     * fastJson序列化
//     *
//     * @return RedisSerializer
//     */
//    @Bean
//    public RedisSerializer<Object> fastJson2JsonRedisSerializer() {
//        FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer(Object.class) {
//            @Override
//            public byte[] serialize(Object o) throws SerializationException {
//                return super.serialize(o);
//            }
//
//            @Override
//            public Object deserialize(byte[] bytes) throws SerializationException {
//                return super.deserialize(bytes);
//            }
//        };
//        //ParserConfig
//        return serializer;
//    }
//
//    /**
//     * 配置缓存管理
//     * 注意：在redisTemplate配置的不会生效，需要在RedisCacheConfiguration单独配置
//     *
//     * @param lettuceConnectionFactory lettuceConnectionFactory
//     * @return CacheManager
//     */
//    @Bean
//    public CacheManager cacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
//        //配置 RedisCacheManager，使用 cache 注解管理 redis 缓存
//        //1.
//        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
//        //设置缓存的默认过期时间 30分钟
//        defaultCacheConfig = defaultCacheConfig.entryTtl(Duration.ofMinutes(30))
//                //key string 序列化
//                .serializeKeysWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(new StringRedisSerializer()))
//                //value json序列化
//                .serializeValuesWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(jackson2JsonRedisSerializer()))
//                //不缓存空置
//                .disableCachingNullValues();
//        //2.初始化缓存空间
//        Set<String> cacheNames = new HashSet<>();
//        cacheNames.add("timeGroupOneLevel");
//        cacheNames.add("timeGroupTwoLevel");
//        //3.对每个缓存空间应用不通的配置
//        Map<String, RedisCacheConfiguration> caches = new HashMap<>(6);
//        caches.put("timeGroupOneLevel", defaultCacheConfig);
//        caches.put("timeGroupTwoLevel", defaultCacheConfig.entryTtl(Duration.ofMinutes(1)));
//        //4.自定义缓存配置
//        RedisCacheManager cacheManager = RedisCacheManager.builder(lettuceConnectionFactory)
//                .initialCacheNames(cacheNames).withInitialCacheConfigurations(caches).build();
//
//        return cacheManager;
//    }

//    @Bean
//    public RedisUtils redisUtils() {
//        return new RedisUtils();
//    }
}