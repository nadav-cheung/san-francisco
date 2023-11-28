package cn.com.nadav.sanfrancisco.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "san.francisco.service")
public class ServiceProperties {




}
