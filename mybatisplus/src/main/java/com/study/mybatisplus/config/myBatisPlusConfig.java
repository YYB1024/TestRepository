package com.study.mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: mybatisplus
 * @ClassName: myBatisPlusConfig
 * @author：yangyanbin
 * @Desc：TODO
 * @date 2021/4/3 22:45
 * @Version: 1.0
 */
/*扫描指定包下的Mapper接口*/
@MapperScan("com.study.mybatisplus.mapper")
@Configuration
public class myBatisPlusConfig {
    /**
     *@Desc:乐观锁插件（固定的）
     *@param
     *@return:
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    /**
     * 逻辑删除插件
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
