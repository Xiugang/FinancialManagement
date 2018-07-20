package com.dsef.gjp.gjpdemo.service;

import com.dsef.gjp.gjpdemo.dao.zhangwudao;
import com.dsef.gjp.gjpdemo.domain.zhangwu;
import java.util.List;

/**
 * @author D.S.E.F
 * @date 2018/7/16
 */
public class zhangwuservice {
    private zhangwudao dao = new zhangwudao();
    public List<zhangwu> selectAll(){
        return dao.selectAll();
    }
    public List<zhangwu> select(String startDate,String endDate){
        return dao.select(startDate,endDate);
    }
    public void addZhangWu(zhangwu zw){
        dao.addZhangWu(zw);
    }
    public void editZhangWu(zhangwu zw){
        dao.editZhangWu(zw);
    }

    public void deleteZhangWu(int zwid){
        dao.deleteZhangWu(zwid);
    }
}
