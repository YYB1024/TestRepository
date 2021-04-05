package com.study.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


import java.time.LocalDateTime;


/**
 * @ProjectName: mybatisplus
 * @ClassName: User
 * @author：yangyanbin
 * @Desc：实体类
 * @date 2021/4/3 16:42
 * @Version: 1.0
 */
@SuppressWarnings("all")
@Data
public class User {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //gmt_created
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreated;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;//版本号
}
