package com.kafka.third.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.third.entity.Result;
import com.kafka.third.entity.TblStatus;
import com.kafka.third.service.TblStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



/**
 * (TblStatus)表控制层
 *
 * @author makejava
 * @since 2022-05-30 10:32:26
 */
@RestController
@RequestMapping("tblStatus")
@Slf4j
public class TblStatusController {
    /**
     * 服务对象
     */
    @Resource
    private TblStatusService tblStatusService;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    /**
     * 分页查询
     *
     * @param tblStatus 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TblStatus>> queryByPage(TblStatus tblStatus, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tblStatusService.queryByPage(tblStatus, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TblStatus> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tblStatusService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tblStatus 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TblStatus> add(TblStatus tblStatus) {
        return ResponseEntity.ok(this.tblStatusService.insert(tblStatus));
    }

    /**
     * 编辑数据
     *
     * @param tblStatus 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TblStatus> edit(TblStatus tblStatus) {
        return ResponseEntity.ok(this.tblStatusService.update(tblStatus));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tblStatusService.deleteById(id));
    }

    /**
     *
     * 获取虚拟机中定时任务发送的虚拟机相关数据
     * @param tblStatus
     * @param request
     * @return
     */
    @PostMapping("tblStatusInfo")
    public TblStatus getTblStatusInfo(@RequestBody TblStatus tblStatus, HttpServletRequest request) {
        String serverIp = request.getRemoteAddr();
        tblStatus.setServerIp(serverIp);
        ObjectMapper objm = new ObjectMapper();
        try {
            String str = objm.writeValueAsString(tblStatus);
            kafkaTemplate.send("third",str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return tblStatus;
    }

    /**
     *
     * @param serverIp  指定ip地址
     * @return  分装好的数据
     */
    @GetMapping("queryTblStatus")
    public Result queryStatus(String serverIp) {
        Result result = new Result();
        List<TblStatus> tblStatusList = tblStatusService.queryTblStatus(serverIp);
        List<TblStatus> coll = tblStatusList.stream().sorted(Comparator.comparing(TblStatus::getCreateTime)).collect(Collectors.toList());
        result.setCode(0);
        result.setData(coll);
        return result;
    }

}

