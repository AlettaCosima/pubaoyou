package com.pubaoyou.gateway.config;

import com.pubaoyou.gateway.swagger.SwaggerHeaderFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springcloud gateway config，用于设置拦截规则，配置方式同yaml，如是项目，可按照模块配置config，如userGateWayConfig，roleGateWayConfig
 */
@Configuration
@Slf4j
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        log.info("gateway init");
        // 路由构造器
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // 针对所有service开头的路径进行拦截匹配，并通过eurkea转发到服务端
        routes.route("service_hi", r -> {
            log.info("gateway init route service_hi");
            return r.path("/service/**").uri("lb://PUBAOYOU-SERVICE");
        });
        // swagger路径拦截配置，会截取访问请求/swagger，转发到对应的服务端
        routes.route("swagger_hi", r -> {
            log.info("gateway init route swagger_hi");
            return r.path("/swagger/**").filters(f -> f.stripPrefix(1).filter(new SwaggerHeaderFilter().apply(routes))).uri("lb://PUBAOYOU-SERVICE");
        });

        return routes.build();
    }
}
