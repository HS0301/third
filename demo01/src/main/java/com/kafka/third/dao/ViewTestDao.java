package com.kafka.third.dao;

import com.kafka.third.entity.ViewTest;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ViewTest)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-11 17:41:11
 */
public interface ViewTestDao {

    /**
     *
     * @return 实例对象
     */
    List<ViewTest> queryById();

    /**
     * 查询指定行数据
     *
     * @param viewTest 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ViewTest> queryAllByLimit(@Param("viewTest") ViewTest viewTest, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param viewTest 查询条件
     * @return 总行数
     */
    long count(ViewTest viewTest);


}

