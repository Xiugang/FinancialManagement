package com.dsef.gjp.gjpdemo;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author D.S.E.F
 * @date 2018/7/16
 */
@Repository
public class ZhangWuDao {
    private QueryRunner queryRunner = new QueryRunner(jdbcutils.getDataSource());
    public List<zhangwu> selectAll(){
        try {
            String sql = "SELECT * FROM zhangwu";
            List<zhangwu> list = queryRunner.query(sql, new BeanListHandler<>(zhangwu.class));
            System.out.println(list);
            return list;
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("查询所有账务失败");
        }
    }

    public List<zhangwu> select(String startDate,String endDate){
        try {

            String sql = "SELECT * FROM zhangwu WHERE createtime BETWEEN ? AND ?";
            Object[] param = {startDate, endDate};
            return queryRunner.query(sql, new BeanListHandler<>(zhangwu.class), param);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("条件查询失败");
        }
    }

    public void addZhangWu(zhangwu zw){
        try {
            String sql = "INSERT INTO zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
            queryRunner.update(sql,params);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("账务添加失败");
        }
    }

    public void editZhangWu(zhangwu zw){
        try {
            String sql = "UPDATE zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
            queryRunner.update(sql,params);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("编辑账务失败");
        }
    }

    public void deleteZhangWu(int zwid){
        try {
            String sql = "DELETE FROM zhangwu WHERE zwid=?";
            queryRunner.update(sql,zwid);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("删除账务失败");
        }
    }
}


