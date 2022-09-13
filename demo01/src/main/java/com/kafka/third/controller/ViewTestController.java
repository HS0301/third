package com.kafka.third.controller;

import com.kafka.third.entity.ViewTest;
import com.kafka.third.service.ViewTestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ViewTest)表控制层
 *
 * @author makejava
 * @since 2022-06-11 17:41:10
 */
@RestController
@RequestMapping("viewTest")
public class ViewTestController {
    /**
     * 服务对象
     */
    @Resource
    private ViewTestService viewTestService;

    /**
     * 分页查询
     *
     * @param viewTest 筛选条件
     * @return 查询结果
     */
    @GetMapping()
    public ResponseEntity<Page<ViewTest>> queryByPage(ViewTest viewTest, Integer page,Integer limit) {
        PageRequest pageRequest=  PageRequest.of(page-1,limit);
        return ResponseEntity.ok(this.viewTestService.queryByPage(viewTest, pageRequest));
    }

    /**
     *
     * @return 全部数据
     */
    @GetMapping("test")
    public ResponseEntity<List<ViewTest>> queryById() {
        return ResponseEntity.ok(this.viewTestService.queryById());
    }


}

