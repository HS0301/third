package com.kafka.third.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.third.dao.TblStatusDao;
import com.kafka.third.entity.TblStatus;
import com.kafka.third.service.TblStatusService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Slf4j
public class statusConsumer {


    @Resource
    private TblStatusService tblStatusService;
    @Autowired
    private TblStatusDao tblStatusdao;


    @KafkaListener(topics = "third")
    public void getKafkaInfo(ConsumerRecord record) {
        Object obj = record.value();
        ObjectMapper objm = new ObjectMapper();
        try {
            TblStatus tblStatus = objm.readValue(obj.toString(),TblStatus.class);
            tblStatusdao.insert(tblStatus);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
