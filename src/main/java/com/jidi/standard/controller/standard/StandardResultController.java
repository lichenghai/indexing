package com.jidi.standard.controller.standard;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jidi.standard.entity.StandardResult;
import com.jidi.standard.service.standard.StandardResultService;
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
@RequestMapping("/remove-me/standard-service/result")
public class StandardResultController {
    @Resource
    private StandardResultService standardResultService;

    @PostMapping("/add")
    public Result add(@RequestBody StandardResult standardResult) {
   //     standardResult.setGlobalStateType(StateUtils.STATE_NORMAL);
  //      standardResult.setCreateTime(TextUtils.getNowTime());
        standardResultService.save(standardResult);
        return ResultGenerator.genSuccessResult(standardResult);
    }

    @PostMapping("/add-batch")
    public Result addBatch(@RequestBody List<StandardResult> standardResult) {
    /*
        for (StandardResult api: standardResult) {
            api.setGlobalStateType(StateUtils.STATE_NORMAL);
            api.setCreateTime(TextUtils.getNowTime());
        }
        */
        standardResultService.save(standardResult);
        return ResultGenerator.genSuccessResult(standardResult);
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam(required = true) Integer id) {
        standardResultService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/edit")
    public Result update(@RequestBody StandardResult standardResult) {
        standardResultService.update(standardResult);
        return ResultGenerator.genSuccessResult(standardResult);
    }

    @GetMapping("/get")
    public Result detail(@RequestParam(required = true) Integer id) {
        StandardResult standardResult = standardResultService.get(id);
        return ResultGenerator.genSuccessResult(standardResult);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "null") Map<String,Object> params) {
        Integer page = 0,size = 0;
        Condition condition = new Condition(StandardResult.class);
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
        List<StandardResult> list = standardResultService.list(condition);
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
}
