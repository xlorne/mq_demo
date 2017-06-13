package com.common.mysql.entity;

import com.lorne.core.framework.annotation.db.Generator;
import com.lorne.core.framework.annotation.db.Id;
import com.lorne.core.framework.annotation.db.Table;
import com.lorne.core.framework.model.BaseEntity;

/**
 * Created by lorne on 2017/6/12.
 */
@Table(name = "t_u_user")
public class User extends BaseEntity{

    private Integer id;
    
    private String name;

    private String pwd;


    @Id
    @Generator
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
