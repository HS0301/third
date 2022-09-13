package com.kafka.third.entity;

import java.io.Serializable;

/**
 * (ViewTest)实体类
 *
 * @author makejava
 * @since 2022-06-11 17:41:12
 */
public class ViewTest implements Serializable {
    private static final long serialVersionUID = -15073186374649948L;

    private String id;
    private String cpuUsage;
    
    private String diskUsage;
    
    private String memoryUsage;
    
    private String serverIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(String cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public String getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(String diskUsage) {
        this.diskUsage = diskUsage;
    }

    public String getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(String memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

}

