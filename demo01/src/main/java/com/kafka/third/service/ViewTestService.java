package com.kafka.third.service;

import com.kafka.third.entity.ViewTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (ViewTest)表服务接口
 *
 * @author makejava
 * @since 2022-06-11 17:41:12
 */
public interface ViewTestService {

    /**
     *
     * @return 实例对象
     */
    List<ViewTest> queryById();

    /**
     * 分页查询
     *
     * @param viewTest 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ViewTest> queryByPage(ViewTest viewTest, PageRequest pageRequest);


}
