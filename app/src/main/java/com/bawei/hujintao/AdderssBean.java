package com.bawei.hujintao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * date:2020/3/5 0005
 * author:胡锦涛(Administrator)
 * function:
 */
@Entity
public class AdderssBean {
    @Id(autoincrement = true)
    Long id;
    String sheng;
    String shi;
    String qu;
    @Generated(hash = 606685421)
    public AdderssBean(Long id, String sheng, String shi, String qu) {
        this.id = id;
        this.sheng = sheng;
        this.shi = shi;
        this.qu = qu;
    }
    @Generated(hash = 1989678152)
    public AdderssBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSheng() {
        return this.sheng;
    }
    public void setSheng(String sheng) {
        this.sheng = sheng;
    }
    public String getShi() {
        return this.shi;
    }
    public void setShi(String shi) {
        this.shi = shi;
    }
    public String getQu() {
        return this.qu;
    }
    public void setQu(String qu) {
        this.qu = qu;
    }
}
