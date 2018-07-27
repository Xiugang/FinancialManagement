package com.dsef.gjp.gjpdemo;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author D.S.E.F
 * @date 2018/7/16
 */
@RestController
public class ZhangWuController {

    @Autowired
    private ZhangWuService zhangWuService;

    @RequestMapping(value = "添加账户",method = RequestMethod.GET)
    @ApiOperation(value = "账户信息",notes = "账户信息不能为空")
    @ApiImplicitParams({ })
    public String addZhangWu(@RequestParam(value = "flname") String flname,
                           @RequestParam(value = "money") double money,
                           @RequestParam(value = "zhanghu") String zhanghu,
                           @RequestParam(value = "createtime") String createtime,
                           @RequestParam(value = "description") String description
                           ){
        zhangwu zw = new zhangwu(0,flname,money,zhanghu,createtime,description);
        zhangWuService.addZhangWu(zw);
        System.out.println(zw);
        return "添加成功";
    }

    @RequestMapping(value = "编辑账户",method = RequestMethod.GET)
    @ApiOperation(value = "对已有消费进行修改",notes = "账户信息不能为空")
    public void editZhangWuu(@RequestParam(value = "zwid") int zwid,
                             @RequestParam(value = "flname") String flname,
                             @RequestParam(value = "money") double money,
                             @RequestParam(value = "zhanghu") String zhanghu,
                             @RequestParam(value = "createtime") String createtime,
                             @RequestParam(value = "description") String description){
        zhangwu zw = new zhangwu(zwid,flname,money,zhanghu,createtime,description);
        zhangWuService.editZhangWu(zw);
    }

    @RequestMapping(value = "删除账户",method = RequestMethod.GET)
    @ApiOperation(value = "账户信息",notes = "账户信息不能为空")
    public String deleteZhangWu(@RequestParam(value = "zwid") int zwid){
        zhangWuService.deleteZhangWu(zwid);
        return "删除成功";
    }

    @RequestMapping(value = "查询全部账户",method = RequestMethod.GET)
    @ApiOperation(value = "显示所有的消费信息",notes = "默认显示全部消费信息")
    public List<zhangwu> selectAll(){
        return zhangWuService.selectAll();
    }
//
    @RequestMapping(value = "查询账户",method = RequestMethod.GET)
    @ApiOperation(value = "查询某一时间段的消费信息",notes = "按消费起止时间查询")
    public List<zhangwu> select(@RequestParam String startDate,
                                @RequestParam String endDate){
        return zhangWuService.select(startDate,endDate);
    }

//    public List<zhangwu> selectAll(){
//        return zhangWuService.selectAll();
//    }
//    public List<zhangwu> select(String startDate,String endDate){
//        return service.select(startDate,endDate);
//    }
//
//    public void editZhangWu(zhangwu zw){
//        service.editZhangWu(zw);
//    }
//
//    public void deleteZhangWu(int zwid){
//        service.deleteZhangWu(zwid);
//    }
}
