package com.dsef.gjp.gjpdemo.controller;

import com.dsef.gjp.gjpdemo.domain.zhangwu;
import com.dsef.gjp.gjpdemo.service.zhangwuservice;

import java.util.List;

/**
 * @author D.S.E.F
 * @date 2018/7/16
 */
public class zhangwucontroller {
    private zhangwuservice service = new zhangwuservice();
    public List<zhangwu> selectAll(){
        return service.selectAll();
    }
    public List<zhangwu> select(String startDate,String endDate){
        return service.select(startDate,endDate);
    }
    public void addZhangWu(zhangwu zw){
        service.addZhangWu(zw);
    }
    public void editZhangWu(zhangwu zw){
        service.editZhangWu(zw);
    }

    public void deleteZhangWu(int zwid){
        service.deleteZhangWu(zwid);
    }
}
