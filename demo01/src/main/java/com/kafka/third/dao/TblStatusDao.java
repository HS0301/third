package com.kafka.third.dao;

import com.kafka.third.entity.TblStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TblStatus)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-30 10:32:27
 */

public interface TblStatusDao {

    /**
     * 通过ID查询单条数据
     *
     * @param serverIp 指定ip地址
     * @return 实例对象
     */
    List<TblStatus> queryTblStatus(@Param("serverIp") String serverIp);

    /**
     * 查询指定行数据
     *
     * @param tblStatus 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TblStatus> queryAllByLimit(TblStatus tblStatus, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tblStatus 查询条件
     * @return 总行数
     */
    long count(TblStatus tblStatus);

    /**
     * 新增数据
     *
     * @param tblStatus 实例对象
     * @return 影响行数
     */
    int insert(TblStatus tblStatus);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TblStatus> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TblStatus> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TblStatus> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TblStatus> entities);

    /**
     * 修改数据
     *
     * @param tblStatus 实例对象
     * @return 影响行数
     */
    int update(TblStatus tblStatus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
}

