package com.kafka.third.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TblStatus)实体类
 *
 * @author makejava
 * @since 2022-05-30 10:32:28
 */
@Data
public class TblStatus implements Serializable {
    private static final long serialVersionUID = -67961806326239577L;
    
    private Integer id;
    
    private Float cpuUsage;
    
    private Float memoryUsage;
    
    private Float diskUsage;
    
    private String serverIp;
    
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(Float cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Float getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Float memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Float getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(Float diskUsage) {
        this.diskUsage = diskUsage;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

