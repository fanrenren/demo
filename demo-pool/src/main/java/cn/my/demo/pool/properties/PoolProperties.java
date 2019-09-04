package cn.my.demo.pool.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = PoolProperties.PROJECT_PREFIX)
public class PoolProperties {
    public static  final String PROJECT_PREFIX = "project.object";
    /**
     * 最大空闲
     */
    private int maxIdle = 5;
    /**
     * 最大总数
     */
    private int maxTotal = 20;
    /**
     * 最小空闲
     */
    private int minIdle = 2;

    /**
     * 初始化连接数
     */
    private int initialSize = 3;
}
