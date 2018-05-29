package com.jidi.standard.controller.standard;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jidi.standard.entity.IndexStatics;
import com.jidi.standard.service.standard.IndexStaticsService;
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
* Created by lichenghai on Tue May 29 23:48:51 GMT+08:00 2018.
*/
@RestController
@RequestMapping("/remove-me/standard-service/statics")
public class IndexStaticsController {
    @Resource
    private IndexStaticsService indexStaticsService;

    @PostMapping("/add")
    public Result add(@RequestBody IndexStatics indexStatics) {
   //     indexStatics.setGlobalStateType(StateUtils.STATE_NORMAL);
  //      indexStatics.setCreateTime(TextUtils.getNowTime());
        indexStaticsService.save(indexStatics);
        return ResultGenerator.genSuccessResult(indexStatics);
    }

    @PostMapping("/add-batch")
    public Result addBatch(@RequestBody List<IndexStatics> indexStatics) {
    /*
        for (IndexStatics api: indexStatics) {
            api.setGlobalStateType(StateUtils.STATE_NORMAL);
            api.setCreateTime(TextUtils.getNowTime());
        }
        */
        indexStaticsService.save(indexStatics);
        return ResultGenerator.genSuccessResult(indexStatics);
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam(required = true) Integer id) {
        indexStaticsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/edit")
    public Result update(@RequestBody IndexStatics indexStatics) {
        indexStaticsService.update(indexStatics);
        return ResultGenerator.genSuccessResult(indexStatics);
    }

    @GetMapping("/get")
    public Result detail(@RequestParam(required = true) Integer id) {
        IndexStatics indexStatics = indexStaticsService.get(id);
        return ResultGenerator.genSuccessResult(indexStatics);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "null") Map<String,Object> params) {
        Integer page = 0,size = 0;
        Condition condition = new Condition(IndexStatics.class);
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
        List<IndexStatics> list = indexStaticsService.list(condition);
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
