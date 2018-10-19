package com.zy.shirozy.domain;

import java.util.Date;

public class Focususer {
    private Integer id;

    private Integer uidTo;

    private Integer uidBe;

    private Date createdate;

    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUidTo() {
        return uidTo;
    }

    public void setUidTo(Integer uidTo) {
        this.uidTo = uidTo;
    }

    public Integer getUidBe() {
        return uidBe;
    }

    public void setUidBe(Integer uidBe) {
        this.uidBe = uidBe;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}