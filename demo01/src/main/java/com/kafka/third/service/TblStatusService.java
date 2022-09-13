package com.kafka.third.service;

import com.kafka.third.entity.TblStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (TblStatus)表服务接口
 *
 * @author makejava
 * @since 2022-05-30 10:32:30
 */
public interface TblStatusService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TblStatus queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tblStatus 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TblStatus> queryByPage(TblStatus tblStatus, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tblStatus 实例对象
     * @return 实例对象
     */
    TblStatus insert(TblStatus tblStatus);

    /**
     * 修改数据
     *
     * @param tblStatus 实例对象
     * @return 实例对象
     */
    TblStatus update(TblStatus tblStatus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过IP地址查找最新的相关数据
     * @param serverIp   指定IP地址
     * @return  TblStatus列表
     */
    List<TblStatus> queryTblStatus(String serverIp);

}
