package com.dsef.gjp.gjpdemo;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author D.S.E.F
 * @date 2018/7/16
 */
@RestController
@Slf4j
public class ZhangWuController {

    @Autowired
    private ZhangWuService zhangWuService;
//    final static Logger logger  =  LoggerFcactory.getLogger(ZhangWuController.class );

    /**
     * @全部查询
     * */
    @RequestMapping(value = "selectAll",method = RequestMethod.GET)
    @ApiOperation(value = "查询全部账户",notes = "显示所有的消费信息")
    public List<zhangwu> selectAll(){
        return zhangWuService.selectAll();
    }

    /**
     * @条件查询1
     * 根据消费的起止时间查询
     * */
    @RequestMapping(value = "selectForDate",method = RequestMethod.GET)
    @ApiOperation(value = "根据消费时间段查询",notes = "起止时间的格式XXXX-XX-xx")
    public List<zhangwu> select(@RequestParam(value = "startDate") String startDate,
                                @RequestParam(value = "endDate") String endDate){
        if (zhangWuService.select1(startDate,endDate).isEmpty())
            System.out.println("没有消费记录");
        return zhangWuService.select1(startDate,endDate);
    }

    /**
     * @条件查询2
     * 通过花费方式查询
     * */
    @RequestMapping(value = "selectForFlname",method = RequestMethod.GET)
    @ApiOperation(value = "根据消费方式去查询",notes = "消费方式")
    public List<zhangwu> select2(@RequestParam(value = "flname") String flname){
        if (zhangWuService.select2(flname).isEmpty())
            System.out.println("没有消费记录");
        return zhangWuService.select2(flname);
    }

    /**
     * @条件查询3
     * 通过账户查询
     * */
    @RequestMapping(value = "selectForZhanghu",method = RequestMethod.GET)
    @ApiOperation(value = "根据消费方式去查询",notes = "消费方式")
    public List<zhangwu> select3(@RequestParam(value = "zhanghu") String zhanghu){
        if (zhangWuService.select3(zhanghu).isEmpty())
            System.out.println("没有消费记录");
        return zhangWuService.select3(zhanghu);
    }

    /**
     * @条件查询4
     * 通过花费金额去查询
     * */
    @RequestMapping(value = "selectForMoney",method = RequestMethod.GET)
    @ApiOperation(value = "根据消费金额段查询",notes = "金额范围")
    public List<zhangwu> select4(@RequestParam(value = "maxmoney",defaultValue = "1000") double maxmoney,
                                @RequestParam(value = "minmoney",defaultValue = "0") double minmoney){
        if (zhangWuService.select4(minmoney,maxmoney).isEmpty())
            System.out.println("没有消费记录");
        return zhangWuService.select4(maxmoney,minmoney);
    }

    /**
     * @添加消费信息
     * */
    @RequestMapping(value = "addZhangWu",method = RequestMethod.GET)
    @ApiOperation(value = "添加账户",notes = "账户信息不能为空")
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

    /**
     * @编辑账务信息
     * 时间不允许修改
     * */
    @RequestMapping(value = "editZhangWu",method = RequestMethod.PUT)
    @ApiOperation(value = "编辑账户",notes = "不允许修改时间")
    public void editZhangWu(@RequestParam(value = "zwid") int zwid,
                             @RequestParam(value = "flname") String flname,
                             @RequestParam(value = "money") double money,
                             @RequestParam(value = "zhanghu") String zhanghu,
                             @RequestParam(value = "description") String description){
        if (zhangWuService.select5(zwid).isEmpty())
            System.out.println("该消费记录被删除或没有该消费记录");

        zhangwu zw = new zhangwu(zwid,flname,money,zhanghu,"XXXX-XX-xx",description);
        zhangWuService.editZhangWu(zw);
    }

    /**
     * @删除全部信息
     * 该操作不可撤销
     * 加密操作，密码：root
     * */
    @RequestMapping(value = "delectAll",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除账户",notes = "账户信息不能为空")
    public String deleteZhangWu(@RequestParam(value = "password") String passward){
        if (passward != "root")
            return "密码错误";
        zhangWuService.deleteZhangWu();
        return "删除成功";
    }

    /**
     * @删除方式1
     * 根据id删除
     * 备注：该方法最后应该放弃
     * */
    @RequestMapping(value = "delectForId",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据ID删除",notes = "ID需通过查询全部知道")
    public String delete1(@RequestParam(value = "zwid") int zwid){
        if (zhangWuService.select5(zwid).isEmpty())
            System.out.println("该消息不存在");
        zhangWuService.delete1(zwid);
        return "该条消费信息全部删除";
    }

    /**
     * @删除方式2
     * 根据消费名删除同一类型消费
     * */
    @RequestMapping(value = "delectForFlname",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据消费名删除",notes = "该消费类型会被都删除")
    public String delete2(@RequestParam(value = "flname") String flname){
        if (zhangWuService.select2(flname).isEmpty())
            System.out.println("不存在该类消息");
        zhangWuService.delete2(flname);
        return "删除成功";
    }

    /**
     * @删除方式3
     * 根据消费名删除同一类型消费
     * */
    @RequestMapping(value = "delectForMoney",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据消费金额删除",notes = "该消费金额范围都将删除")
    public String delect3(@RequestParam(value = "maxmoney",defaultValue = "0") double maxmoney,
                          @RequestParam(value = "minmoney",defaultValue = "0") double minmoney){
        if (maxmoney < minmoney)
            return "最大金额要大于最小金额";
        if (zhangWuService.select4(maxmoney,minmoney).isEmpty())
            System.out.println("不存在此类消息");
        zhangWuService.delete3(maxmoney,minmoney);
        return "删除成功";
    }

    /**
     * @删除方式4
     * 根据支出账户删除同一类型消费
     * */
    @RequestMapping(value = "delectForZhanghu",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据支出账户删除",notes = "该支出账户类型都将删除")
    public String delect4(@RequestParam(value = "zhanghu") String zhanghu){
        if (zhangWuService.select3(zhanghu).isEmpty())
            System.out.println("不存在此类消息" );
        zhangWuService.delete4(zhanghu);
        return "删除成功";
    }

    /**
     * @删除方式5
     * 根据消费名删除同一类型消费
     * */
    @RequestMapping(value = "delectForDate",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据消费时间删除",notes = "该消费时间范围都将删除")
    public String delect5(@RequestParam(value = "startDate") String startDate,
                          @RequestParam(value = "endDate") String endDate){
        if (zhangWuService.select1(startDate,endDate).isEmpty())
            System.out.println("不存在该类消息");
        zhangWuService.delete5(startDate,endDate);
        return "删除成功";
    }
}
