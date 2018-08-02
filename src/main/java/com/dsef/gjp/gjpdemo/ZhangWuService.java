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
    public List<zhangwu> select1(String startDate,String endDate){
        return zhangWuDao.select1(startDate,endDate);
    }

    public List<zhangwu> select2(String flname){
        return  zhangWuDao.select2(flname);
    }

    public List<zhangwu> select3(String zhanghu){
        return zhangWuDao.selec3(zhanghu);
    }

    public List<zhangwu> select4(double maxmoney,double minmoney){
        return zhangWuDao.selec4(maxmoney,minmoney);
    }
    public List<zhangwu> select5(int zwid){ return zhangWuDao.selec5(zwid); }

    public zhangwu addZhangWu(zhangwu zw){
        zhangWuDao.addZhangWu(zw);
        return zw;
    }
    public void editZhangWu(zhangwu zw){
        zhangWuDao.editZhangWu(zw);
    }

    public void deleteZhangWu(){
        zhangWuDao.deleteZhangWu();
    }
    public void delete1(int zwid){ zhangWuDao.delete1(zwid);}
    public void delete2(String flname){ zhangWuDao.delete2(flname);}
    public void delete3(double maxmoney,double minmoney){ zhangWuDao.delete3(maxmoney,minmoney);}
    public void delete4(String zhanghu){ zhangWuDao.delete4(zhanghu);}
    public void delete5(String startDate,String endDate){ zhangWuDao.delete5(startDate,endDate);}
}
