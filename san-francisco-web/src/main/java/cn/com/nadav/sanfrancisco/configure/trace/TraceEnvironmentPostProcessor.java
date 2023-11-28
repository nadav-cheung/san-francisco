package cn.com.nadav.sanfrancisco.configure.trace;

import brave.context.slf4j.MDCScopeDecorator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * Adds default properties for the application:
 * <ul>
 * <li>logging pattern level that prints trace information (e.g. trace ids)</li>
 * </ul>
 *
 * @author Dave Syer
 * @author Marcin Grzejszczak
 * @since 2.0.0
 */
@AutoConfiguration
@ConditionalOnClass(MDCScopeDecorator.class)
public class TraceEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private static final String PROPERTY_SOURCE_NAME = "defaultProperties";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment,
                                       SpringApplication application) {
        Map<String, Object> map = new HashMap<String, Object>();
        // This doesn't work with all logging systems but it's a useful default so you see
        // traces in logs without having to configure it.
        if (Boolean
                .parseBoolean(environment.getProperty("spring.tracing.console.enabled", "false"))) {
            map.put("logging.pattern.level", "%5p [${spring.application.name:} %X{traceId:-} %X{spanId:-}]");
        }
        addOrReplace(environment.getPropertySources(), map);
    }

    private void addOrReplace(MutablePropertySources propertySources,
                              Map<String, Object> map) {
        MapPropertySource target = null;
        if (propertySources.contains(PROPERTY_SOURCE_NAME)) {
            PropertySource<?> source = propertySources.get(PROPERTY_SOURCE_NAME);
            if (source instanceof MapPropertySource) {
                target = (MapPropertySource) source;
                for (String key : map.keySet()) {
                    if (!target.containsProperty(key)) {
                        target.getSource().put(key, map.get(key));
                    }
                }
            }
        }
        if (target == null) {
            target = new MapPropertySource(PROPERTY_SOURCE_NAME, map);
        }
        if (!propertySources.contains(PROPERTY_SOURCE_NAME)) {
            propertySources.addLast(target);
        }
    }

}

