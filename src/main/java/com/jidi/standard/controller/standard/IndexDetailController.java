package com.jidi.standard.controller.standard;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jidi.standard.entity.IndexDetail;
import com.jidi.standard.service.standard.IndexDetailService;
import com.jidi.standard.utils.Result;
import com.jidi.standard.utils.ResultGenerator;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import org.apache.commons.fileupload.disk.DiskFileItem;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;

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
    public Result list(@RequestParam(defaultValue = "null") Map<String, Object> params) {
        Integer page = 0, size = 0;
        Condition condition = new Condition(IndexDetail.class);
        Example.Criteria criteria = condition.createCriteria();
        if (params != null) {
            for (String key : params.keySet()) {
                switch (key) {
                    case "page":
                        page = Integer.parseInt((String) params.get("page"));
                        break;
                    case "size":
                        size = Integer.parseInt((String) params.get("size"));
                        break;
                    default: {
                        criteria.andEqualTo(key, params.get(key));
                    }
                    break;
                }
            }
        }
        if (page != 0 && size != 0) {
            PageHelper.startPage(page, size);
        }
        List<IndexDetail> list = indexDetailService.list(condition);
        if (page != 0 && size != 0) {
            PageInfo pageInfo = new PageInfo(list);
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("list", list);
            result.put("total", pageInfo.getTotal());
            return ResultGenerator.genSuccessResult(result);
        } else {
            return ResultGenerator.genSuccessResult(list);
        }
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam(value = "template", required = true) MultipartFile template, @RequestParam(value = "department", required = true) Integer departmentId) {
        IndexDetail model = new IndexDetail();
        try {
            InputStream is = template.getInputStream();
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("文件解析失败！");
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int fatherId = 0;

        // 正文内容从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            model = new IndexDetail();
            row = sheet.getRow(i);
            String level = getCellFormatValue(row.getCell(0));
            if ("0.0".equals(level)) {
                model.setDepartmentId(departmentId);
                model.setIndexName(getCellFormatValue(row.getCell(1)));
                model.setLevel(0);
                indexDetailService.save(model);
                fatherId = model.getId();
            } else {
                model.setDepartmentId(departmentId);
                model.setIndexName(getCellFormatValue(row.getCell(1)));
                model.setIncreaseName(getCellFormatValue(row.getCell(2)));
                model.setIncreasePoint(Double.parseDouble(getCellFormatValue(row.getCell(3))));
                model.setIncreaseUnit(getCellFormatValue(row.getCell(4)));
                model.setDecreaseName(getCellFormatValue(row.getCell(5)));
                model.setDecreasePoint(Double.parseDouble(getCellFormatValue(row.getCell(6))));
                model.setDecreaseUnit(getCellFormatValue(row.getCell(7)));
                model.setLevel(1);
                model.setFatherId(fatherId);
                indexDetailService.save(model);
           }

        }
        return ResultGenerator.genSuccessResult("上传成功！");
    }

    /**
     * 根据HSSFCell类型设置数据
     *
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }
}
