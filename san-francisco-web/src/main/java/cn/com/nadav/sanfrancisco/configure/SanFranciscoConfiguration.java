package cn.com.nadav.sanfrancisco.configure;


import cn.com.nadav.sanfrancisco.dao.properties.CommonProperties;
import cn.com.nadav.sanfrancisco.dao.properties.DaoProperties;
import cn.com.nadav.sanfrancisco.service.properties.ServiceProperties;
import cn.com.nadav.sanfrancisco.share.properties.ShareProperties;
import cn.com.nadav.sanfrancisco.task.properties.TaskProperties;
import cn.com.nadav.sanfrancisco.web.properties.WebProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({
        CommonProperties.class,
        DaoProperties.class,
        ServiceProperties.class,
        TaskProperties.class,
        WebProperties.class,
        ShareProperties.class
})
public class SanFranciscoConfiguration {
}
