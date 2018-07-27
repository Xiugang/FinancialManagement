package com.dsef.gjp.gjpdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author D.S.E.F
 * @date 2018/7/16
 */
@Service
public class ZhangWuService {
    @Autowired
    private ZhangWuDao zhangWuDao;

    public List<zhangwu> selectAll(){
        return zhangWuDao.selectAll();
    }
    public List<zhangwu> select(String startDate,String endDate){
        return zhangWuDao.select(startDate,endDate);
    }
    public zhangwu addZhangWu(zhangwu zw){
        zhangWuDao.addZhangWu(zw);
        return zw;
    }
    public void editZhangWu(zhangwu zw){
        zhangWuDao.editZhangWu(zw);
    }

    public void deleteZhangWu(int zwid){
        zhangWuDao.deleteZhangWu(zwid);
    }
}
