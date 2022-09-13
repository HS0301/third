package com.kafka.third.service.impl;

import com.kafka.third.entity.TblStatus;
import com.kafka.third.dao.TblStatusDao;
import com.kafka.third.service.TblStatusService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TblStatus)表服务实现类
 *
 * @author makejava
 * @since 2022-05-30 10:32:31
 */
@Service("tblStatusService")
public class TblStatusServiceImpl implements TblStatusService {
    @Resource
    private TblStatusDao tblStatusDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TblStatus queryById(Integer id) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param tblStatus 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TblStatus> queryByPage(TblStatus tblStatus, PageRequest pageRequest) {
        long total = this.tblStatusDao.count(tblStatus);
        return new PageImpl<>(this.tblStatusDao.queryAllByLimit(tblStatus, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tblStatus 实例对象
     * @return 实例对象
     */
    @Override
    public TblStatus insert(TblStatus tblStatus) {
        this.tblStatusDao.insert(tblStatus);
        return tblStatus;
    }

    /**
     * 修改数据
     *
     * @param tblStatus 实例对象
     * @return 实例对象
     */
    @Override
    public TblStatus update(TblStatus tblStatus) {
        this.tblStatusDao.update(tblStatus);
        return this.queryById(tblStatus.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tblStatusDao.deleteById(id) > 0;
    }

    /**
     *
     * @param serverIp   指定IP地址
     * @return
     */
    @Override
    public List<TblStatus> queryTblStatus(String serverIp) {
        return this.tblStatusDao.queryTblStatus(serverIp);
    }
}
