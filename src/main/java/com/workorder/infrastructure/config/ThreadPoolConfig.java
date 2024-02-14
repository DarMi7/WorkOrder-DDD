package com.workorder.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author darmi
 */
@Configuration
public class ThreadPoolConfig {

  @Bean(name = "listenerWorkExecutor")
  public ThreadPoolTaskExecutor listenerWorkExecutor() {
    return getThreadPoolTaskExecutor(64, 128, 10, 1024, "work-async-");
  }

  private ThreadPoolTaskExecutor getThreadPoolTaskExecutor(int corePoolSize, int maxPoolSize,
      int keepAliveTime, int queueCapacity, String threadNamePrefix) {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    executor.setQueueCapacity(queueCapacity);
    executor.setKeepAliveSeconds(keepAliveTime);
    executor.setThreadNamePrefix(threadNamePrefix);
    executor.initialize();
    return executor;
  }
}
