package com.study.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.mybatisplus.entity.User;
import com.study.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;
    /**
     *@Desc:查询user表所有数据
     *@param 
     *@return:void
     */
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    @Test
    public void insertUser(){
        User user = new User();
        user.setName("葵花宝典");
        user.setAge(10);
        user.setEmail("libai@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void updatetUser(){
        User user = new User();
        user.setId(1378297773990395905L);
        user.setAge(1200);
        int update = userMapper.updateById(user);
        System.out.println(update);
    }
    /**
     *@Desc:测试乐观锁
     *@param null
     *@return:
     */
    @Test
    public void testOptimisticLocker(){
        //1、根据id查询
        User user = userMapper.selectById(1378364394029297666L);
        //2、进行修改
        user.setAge(200);
        userMapper.updateById(user);
    }
    /**
     *@Desc:通过多个id批量查询
     *@param
     *@return:
     */
    @Test
    public void testSelectByIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);

    }
    /**
     *@Desc:分页查询
     *@param
     *@return:void
     */
    @Test
    public void testPageSelect(){
        //1、创建page对象
        //传入参数（当前页和每页显示的记录数）
        Page<User> page = new Page<>(1, 4);
        //2、调用mp分页查询方法
        //调用mp分页查询过程中，底层封装（把分页所有数据封装到page对象里面）
        IPage<User> iPage = userMapper.selectPage(page, null);
        //通过page对象获取分页数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据的list集合
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getPages());//得到当前的总页数

        System.out.println(page.hasNext());//是否有下一页
        System.out.println(page.hasPrevious());//是否有上一页

    }
    /**
     *@Desc:根据id进行物理删除
     *@param
     *@return:void
     */
    @Test
    public void testDeleteById(){
        int result = userMapper.deleteById(1L);
        System.out.println(result);

    }
    /**
     *@Desc:批量删除
     *@param
     *@return:void
     */
    @Test
    public void testDeleteByIds(){
        int result = userMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);

    }
    /**
     *@Desc:根据id进行逻辑删除标志位改变为1
     *@param
     *@return:void
     * UPDATE user SET is_deleted=1 WHERE id=? AND is_deleted=0
     */
    @Test
    public void testDeleteById2(){
        int result = userMapper.deleteById(1379066255045206018L);
        System.out.println(result);

    }




}
