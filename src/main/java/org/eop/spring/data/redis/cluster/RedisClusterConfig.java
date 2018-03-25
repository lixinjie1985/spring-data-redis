package org.eop.spring.data.redis.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 集群配置
 * @author lixinjie
 * @since 2018-03-25
 */
@Configuration
@Import({RedisClusterConfigDev.class, RedisClusterConfigTest.class, RedisClusterConfigProd.class})
public class RedisClusterConfig {

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;
	
	@Bean
	public RedisTemplate<?, ?> redisTemplate() {
		RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}
}
