package com.study.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;


/**
 * @ProjectName: mybatisplus
 * @ClassName: MyMetaAotoTime
 * @author：yangyanbin
 * @Desc：时间(版本号自动)自动填充
 * @date 2021/4/3 18:17
 * @Version: 1.0
 */
@Component
public class MyMetaAotoTime implements MetaObjectHandler {

    //使用mp实现添加操作就会执行此方法
    @Override
    public void insertFill(MetaObject metaObject) {
        //metaObject:元数据：数据的数据（表中的字段）
        this.setFieldValByName("gmtCreated", LocalDateTime.now(),metaObject);
        this.setFieldValByName("gmtModified", LocalDateTime.now(),metaObject);
        //版本号自动填充起始为1（用于乐观锁）
        this.setFieldValByName("version",1,metaObject);


    }
    //使用mp实现修改操作就会执行此方法
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified",LocalDateTime.now(),metaObject);

    }
}
