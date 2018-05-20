package com.lindaring.dictionary.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "simple.dictionary.log")
public class LogProperties {
    private Method method = new Method();
    private ExecutionTime executionTime = new ExecutionTime();

    @Data
    public static class Method {
        private boolean enabled;
    }

    @Data
    public static class ExecutionTime {
        private boolean enabled;
    }
}

