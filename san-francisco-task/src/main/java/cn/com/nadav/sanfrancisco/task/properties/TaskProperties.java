package cn.com.nadav.sanfrancisco.task.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "san.francisco.task")
public class TaskProperties {


}
