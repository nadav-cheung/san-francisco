package cn.com.nadav.sanfrancisco.configure.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author cheung nadav
 * @date 8/3/23
 */
@Configuration(proxyBeanMethods = false)
@MapperScan(basePackages = "cn.com.nadav.sanfrancisco.dao")
@ConditionalOnProperty(prefix = "san.francisco.dao", name = "enable", havingValue = "true", matchIfMissing = true)
public class SanFranciscoDaoAutoConfiguration {
}
