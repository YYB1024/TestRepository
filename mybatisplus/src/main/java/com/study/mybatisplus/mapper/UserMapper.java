package com.study.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.mybatisplus.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Repeatable;

/**
 * @ProjectName: mybatisplus
 * @ClassName: UserMapper
 * @author：yangyanbin
 * @Desc：TODO
 * @date 2021/4/3 16:44
 * @Version: 1.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
