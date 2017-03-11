package com.pengjinfei.mybatis.domain;

/**
 * Created by Pengjinfei on 2017/3/11.
 * Description:
 */
public class JobInstance {

    private Integer jobInstanceId;

    private Integer version;

    private String jobName;

    private String jobKey;

    public JobInstance() {
    }

    public Integer getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(Integer jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobKey() {
        return jobKey;
    }

    public void setJobKey(String jobKey) {
        this.jobKey = jobKey;
    }
}

