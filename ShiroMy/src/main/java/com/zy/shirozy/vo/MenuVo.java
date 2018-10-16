package com.zy.shirozy.vo;



import com.zy.shirozy.domain.Authority;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/14 15:49
 */
public class MenuVo {
    private Authority parent;

    public Authority getParent() {
        return parent;
    }

    public void setParent(Authority parent) {
        this.parent = parent;
    }

    public List<Authority> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Authority> childrens) {
        this.childrens = childrens;
    }

    private List<Authority> childrens;

    @Override
    public String toString() {
        return "MenuVo{" +
                "parent=" + parent +
                ", childrens=" + childrens +
                '}';
    }
}
