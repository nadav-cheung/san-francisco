package cn.com.nadav.sanfrancisco.share.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "san.francisco.share")
public class ShareProperties {

    private String welcomeIndex;

}
