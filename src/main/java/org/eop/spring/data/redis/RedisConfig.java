package org.eop.spring.data.redis;

import org.eop.spring.data.redis.cluster.RedisClusterConfig;
import org.eop.spring.data.redis.node.RedisNodeConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lixinjie
 * @since 2018-03-25
 */
@Configuration
@Import({RedisNodeConfig.class, RedisClusterConfig.class})
public class RedisConfig {

}
