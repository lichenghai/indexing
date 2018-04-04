package com.jidi.standard.controller.standard;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jidi.standard.entity.IndexDetail;
import com.jidi.standard.service.standard.IndexDetailService;
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
@RequestMapping("/remove-me/standard-service/detail")
public class IndexDetailController {
    @Resource
    private IndexDetailService indexDetailService;

    @PostMapping("/add")
    public Result add(@RequestBody IndexDetail indexDetail) {
   //     indexDetail.setGlobalStateType(StateUtils.STATE_NORMAL);
  //      indexDetail.setCreateTime(TextUtils.getNowTime());
        indexDetailService.save(indexDetail);
        return ResultGenerator.genSuccessResult(indexDetail);
    }

    @PostMapping("/add-batch")
    public Result addBatch(@RequestBody List<IndexDetail> indexDetail) {
    /*
        for (IndexDetail api: indexDetail) {
            api.setGlobalStateType(StateUtils.STATE_NORMAL);
            api.setCreateTime(TextUtils.getNowTime());
        }
        */
        indexDetailService.save(indexDetail);
        return ResultGenerator.genSuccessResult(indexDetail);
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam(required = true) Integer id) {
        indexDetailService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/edit")
    public Result update(@RequestBody IndexDetail indexDetail) {
        indexDetailService.update(indexDetail);
        return ResultGenerator.genSuccessResult(indexDetail);
    }

    @GetMapping("/get")
    public Result detail(@RequestParam(required = true) Integer id) {
        IndexDetail indexDetail = indexDetailService.get(id);
        return ResultGenerator.genSuccessResult(indexDetail);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "null") Map<String,Object> params) {
        Integer page = 0,size = 0;
        Condition condition = new Condition(IndexDetail.class);
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
        List<IndexDetail> list = indexDetailService.list(condition);
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
