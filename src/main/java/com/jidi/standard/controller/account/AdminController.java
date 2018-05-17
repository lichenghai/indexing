package com.jidi.standard.controller.account;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jidi.standard.entity.Admin;
import com.jidi.standard.service.account.AdminService;
import com.jidi.standard.utils.Result;
import com.jidi.standard.utils.ResultGenerator;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by lichenghai on Wed Apr 04 12:46:59 GMT+08:00 2018.
*/
@RestController
@RequestMapping("/remove-me/account-service/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/add")
    public Result add(@RequestBody Admin admin) {
   //     admin.setGlobalStateType(StateUtils.STATE_NORMAL);
  //      admin.setCreateTime(TextUtils.getNowTime());
        adminService.save(admin);
        return ResultGenerator.genSuccessResult(admin);
    }

    @PostMapping("/add-batch")
    public Result addBatch(@RequestBody List<Admin> admin) {
    /*
        for (Admin api: admin) {
            api.setGlobalStateType(StateUtils.STATE_NORMAL);
            api.setCreateTime(TextUtils.getNowTime());
        }
        */
        adminService.save(admin);
        return ResultGenerator.genSuccessResult(admin);
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam(required = true) Integer id) {
        adminService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/edit")
    public Result update(@RequestBody Admin admin) {
        adminService.update(admin);
        return ResultGenerator.genSuccessResult(admin);
    }

    @GetMapping("/get")
    public Result detail(@RequestParam(required = true) Integer id) {
        Admin admin = adminService.get(id);
        return ResultGenerator.genSuccessResult(admin);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "null") Map<String,Object> params) {
        Integer page = 0,size = 0;
        Condition condition = new Condition(Admin.class);
        Example.Criteria criteria = condition.createCriteria();
        if(params != null) {
            for(String key: params.keySet()) {
                switch (key) {
                    case "page":
                        page = Integer.parseInt((String)params.get("page"));
                        break;
                    case "size":
                        size = Integer.parseInt((String)params.get("size"));
                        break;
                    default:
                    {
                        criteria.andEqualTo(key,params.get(key));
                    }
                        break;
                }
            }
        }
        if(page != 0 && size !=0) {
            PageHelper.startPage(page, size);
        }
        List<Admin> list = adminService.list(condition);
        if(page != 0 && size !=0) {
            PageInfo pageInfo = new PageInfo(list);
            Map<String,Object> result = new HashMap<String,Object>();
            result.put("list",list);
            result.put("total",pageInfo.getTotal());
            return ResultGenerator.genSuccessResult(result);
        } else {
            return ResultGenerator.genSuccessResult(list);
        }
    }



    @PostMapping("/login")
    public Result login(@RequestParam(defaultValue = "null") Map<String, Object> params) {
        Condition condition = new Condition(Admin.class);
        Example.Criteria criteria = condition.createCriteria();
        String account = params.get("account").toString();
        String password = params.get("password").toString();
        if (null == account || null == password || "".equals(account) || "".equals(password))
            return ResultGenerator.genFailResult("用户名或密码错误！");
        System.out.println("account:"+account+"password:"+password);

        criteria.andEqualTo("account", account);
        criteria.andEqualTo("password", password);

        List<Admin> list = adminService.list(condition);
        if (list.size() > 0)
            return ResultGenerator.genSuccessResult(list.get(0));
        else return ResultGenerator.genFailResult("用户名或密码错误！");
    }
}
