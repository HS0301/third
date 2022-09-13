package com.kafka.third.service.impl;

import com.kafka.third.entity.ViewTest;
import com.kafka.third.dao.ViewTestDao;
import com.kafka.third.service.ViewTestService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ViewTest)表服务实现类
 *
 * @author makejava
 * @since 2022-06-11 17:41:12
 */
@Service("viewTestService")
public class ViewTestServiceImpl implements ViewTestService {
    @Resource
    private ViewTestDao viewTestDao;

    /**
     *
     * @param
     * @return 实例对象
     */
    @Override
    public List<ViewTest> queryById() {
        return this.viewTestDao.queryById();
    }

    /**
     * 分页查询
     *
     * @param viewTest 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ViewTest> queryByPage(ViewTest viewTest, PageRequest pageRequest) {
        long total = this.viewTestDao.count(viewTest);
        return new PageImpl<>(this.viewTestDao.queryAllByLimit(viewTest, pageRequest), pageRequest, total);
    }


}
