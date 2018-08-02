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
    /**
     * @查询全部
     * 返回全部的账户
     */
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

    /**
     * @条件查询1
     * 按起止时间查询
     * 返回该条件的账户
     * */
    public List<zhangwu> select1(String startDate,String endDate){
        try {
            String sql = "SELECT * FROM zhangwu WHERE createtime BETWEEN ? AND ?";
            Object[] param = {startDate, endDate};
            return queryRunner.query(sql, new BeanListHandler<>(zhangwu.class), param);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("条件查询失败");
        }
    }

    /**
     * @条件查询2
     * 按消费方式查询
     * 返回该条件的账户
     * */
    public List<zhangwu> select2(String flname){
        try {
            String sql = "SELECT * FROM zhangwu WHERE flname = ?";
            return queryRunner.query(sql,new BeanListHandler<>(zhangwu.class),flname);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("条件查询失败");
        }
    }

    /**
     * @条件查询3
     * 按账户查询
     * 返回该条件的所有账户
     */
    public List<zhangwu> selec3(String zhanghu){
        try {
            String sql = "SELECT * FROM zhangwu WHERE zhanghu = ?";
            return queryRunner.query(sql,new BeanListHandler<>(zhangwu.class),zhanghu);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("条件查询失败");
        }
    }

    /**
     * @条件查询4
     * 按花费金额查询
     * 返回该条件的所有账户
     */
    public List<zhangwu> selec4(double maxmoney,double minmoney){
        try {
            String sql = "SELECT * FROM zhangwu WHERE money BETWEEN ? AND ?";
//            Object[] param = {maxmoney, minmoney};
            return queryRunner.query(sql,new BeanListHandler<>(zhangwu.class),minmoney,maxmoney);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("条件查询失败");
        }
    }
    /**
     * @条件查询5
     * 根据id查询
     * 其他调用
     * */
    public List<zhangwu> selec5(int zwid){
        try {
            String sql = "SELECT * FROM zhangwu WHERE zwid";
//            Object[] param = {maxmoney, minmoney};
            return queryRunner.query(sql,new BeanListHandler<>(zhangwu.class),zwid);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("条件查询失败");
        }
    }
    /**
     * @填写消费信息
     * 无返回值
     */
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

    /**
     * @编辑消费信息
     * */
    public void editZhangWu(zhangwu zw){
        try {
            String sql = "UPDATE zhangwu SET flname=?,money=?,zhanghu=?,description=? WHERE zwid=?";
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getDescription(),zw.getZwid()};
            queryRunner.update(sql,params);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("编辑账务失败");
        }
    }

    /**
     * @删除全部
     * 无返回值
     * */
    public void deleteZhangWu() {
        try {
            String sql = "DELETE FROM zhangwu";
            queryRunner.update(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * @删除方式1
     * 根据id删除
     * 无返回值
     * */
    public void delete1(int zwid){
        try {
            String sql = "DELETE FROM zhangwu WHERE zwid=?";
            queryRunner.update(sql,zwid);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("删除账务失败");
        }
    }
    /**
     * @删除方式2
     * 根据方式同一类型删除
     * 无返回值
     * */
    public void delete2(String flname){
        try {
            String sql = "DELETE FROM zhangwu WHERE flname=?";
            queryRunner.update(sql,flname);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("删除账务失败");
        }
    }

    /**
     * @删除方式3
     * 根据支出金额范围删除
     * 无返回值
     * */
    public void delete3(double maxmoney,double minmoney){
        try {
            String sql = "DELETE FROM zhangwu WHERE money BETWEEN ? AND ?";
            Object[] param = {minmoney,maxmoney};
            queryRunner.update(sql,param);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("删除账务失败");
        }
    }

    /**
     * @删除方式4
     * 根据账户删除
     * 无返回值
     * */
    public void delete4(String zhanghu){
        try {
            String sql = "DELETE FROM zhangwu WHERE zhanghu=?";
            queryRunner.update(sql,zhanghu);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("删除账务失败");
        }
    }

    /**
     * @删除方式4
     * 根据消费时间删除
     * 无返回值
     * */
    public void delete5(String startDate, String endDate){
        try {
            String sql = "DELETE FROM zhangwu WHERE createtime=?  BETWEEN ? AND ?";
            Object[] param ={startDate,endDate};
            queryRunner.update(sql,param);
        }catch (SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("删除账务失败");
        }
    }
}


