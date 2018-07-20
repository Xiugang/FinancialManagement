package com.dsef.gjp.gjpdemo.view;

import com.dsef.gjp.gjpdemo.controller.zhangwucontroller;
import com.dsef.gjp.gjpdemo.domain.zhangwu;
import java.util.List;
import java.util.Scanner;

/**
 * @author D.S.E.F
 * @date 2018/7/16
 * 视图层
 * 五个功能模块
 *      查询
 *      多条件查询
 *      添加
 *      编辑
 *      删除
 */
public class mainview {
    private zhangwucontroller controller = new zhangwucontroller();

    public void run(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    addZhangWu();
                    break;
                case 2:
                    editZhangWu();
                    break;
                case 3:
                    deleteZhangWu();
                    break;
                case 4:
                    selectZhangwu();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("error");
                    break;
            }

        }
    }

    public void selectZhangwu(){
        System.out.println("1.查询所有，2.条件查询");
        Scanner sc = new Scanner(System.in);
        int selectChooser = sc.nextInt();
        switch (selectChooser){
            case 1:
                selectAll();
                break;
            case 2:
                select();
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    public void selectAll(){
        List<zhangwu> list = controller.selectAll();
        if (list.size() != 0) {
            print(list);
        }else
            { System.out.println("没有查询到数据");}

    }
    public void select(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入开始日期：");
        String startDate = scanner.nextLine();
        System.out.print("请输入结果日期：");
        String endDate = scanner.nextLine();
        List<zhangwu> list = controller.select(startDate,endDate);
        if (list.size() != 0) {
            print(list);
        }else
        { System.out.println("没有查询到数据");}
    }
    private void print(List<zhangwu> list){
        System.out.println("ID\t类别\t账户\t金额\t时间\t说明\t");
        for (zhangwu zw : list) {
            System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getZhanghu()+"\t"
                    +zw.getMoney()+"\t"+zw.getCreatetime()+"\t"+zw.getDescription()+"\t");
        }
    }
    public void addZhangWu(){
        System.out.println("选择的添加账务功能，请输入以下内容");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入分类名称");
        String flname = scanner.next();
        System.out.println("输入金额");
        double money = scanner.nextDouble();
        System.out.println("输入账户");
        String zhanghu = scanner.next();
        System.out.println("输入日期：格式XXXX-XX-xx");
        String createtime = scanner.next();
        System.out.println("输入具体描述");
        String description = scanner.next();
        zhangwu zw = new zhangwu(0, flname, money, zhanghu, createtime, description);
        controller.addZhangWu(zw);
        System.out.println("添加成功");
    }

    public void editZhangWu(){
        selectAll();
        System.out.println("选择的是编辑功能，请输入数据");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入ID");
        int zwid = scanner.nextInt();
        System.out.println("输入分类名称");
        String flname = scanner.next();
        System.out.println("输入金额");
        double money = scanner.nextDouble();
        System.out.println("输入账户");
        String zhanghu = scanner.next();
        System.out.println("输入日期：格式XXXX-XX-xx");
        String createtime = scanner.next();
        System.out.println("输入具体描述");
        String description = scanner.next();
        zhangwu zw = new zhangwu(0, flname, money, zhanghu, createtime, description);
        controller.editZhangWu(zw);
        System.out.println("编辑成功");

    }
    public void deleteZhangWu(){
        selectAll();
        System.out.println("选择的是删除功能，请输入序号即可");
        int zwid = new Scanner(System.in).nextInt();
        controller.deleteZhangWu(zwid);
        System.out.println("删除成功");
    }
}
