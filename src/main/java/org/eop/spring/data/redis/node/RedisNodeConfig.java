package org.eop.spring.data.redis.node;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 单节点配置
 * @author lixinjie
 * @since 2018-03-25
 */
@Configuration
@Import({RedisNodeConfigDev.class, RedisNodeConfigTest.class, RedisNodeConfigProd.class})
public class RedisNodeConfig {
	
	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	
	@Bean
	public RedisTemplate<?, ?> redisTemplate() {
		RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		//key必须是字符串，直接按UTF-8编码序列化为字节数组
		//value不做限制，使用Jdk自带的对象序列化为字节数组
		redisTemplate.setKeySerializer(redisTemplate.getStringSerializer());
		redisTemplate.setHashKeySerializer(redisTemplate.getStringSerializer());
		return redisTemplate;
	}
}
