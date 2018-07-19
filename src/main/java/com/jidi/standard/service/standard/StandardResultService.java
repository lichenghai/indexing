package com.jidi.standard.service.standard;

import com.jidi.standard.entity.vo.ResultForSearch;
import com.jidi.standard.mapper.StandardResultMapper;
import com.jidi.standard.entity.StandardResult;
import com.jidi.standard.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lichenghai on Wed Apr 04 12:46:59 GMT+08:00 2018.
 */
@Service
@Transactional
public class StandardResultService extends AbstractService<StandardResult> {
    @Resource
    private StandardResultMapper standardResultMapper;

    /**
     * 前台查询页面
     * @param increaseType:得分、扣分
     *         commentType:是否含评语
     *         timeStart、  timeEnd:开始、截止时间
     *         personId:人员id
     * @return
     */
    public List<ResultForSearch> getResultForSearch(int increaseType, int commentType, Date timeStart,Date timeEnd,int personId){
        return standardResultMapper.getResultForSearch(increaseType,0,timeStart,timeEnd,personId);
    }

}