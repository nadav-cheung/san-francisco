package cn.com.nadav.sanfrancisco.web.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "san.francisco.web")
public class WebProperties {

    private String welcomeIndex = "welcome";

}
