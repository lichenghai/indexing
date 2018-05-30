package com.jidi.standard.service.standard;

import com.jidi.standard.mapper.IndexStaticsMapper;
import com.jidi.standard.entity.IndexStatics;
import com.jidi.standard.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by lichenghai on Tue May 29 23:48:51 GMT+08:00 2018.
 */
@Service
@Transactional
public class IndexStaticsService extends AbstractService<IndexStatics> {
    @Resource
    private IndexStaticsMapper indexStaticsMapper;


    /**
     * 根据起止时间，查询统计结果
      * @param personId:用户id
     * @param departmentId：所在部门id
     * @param timeStart：开始时间
     * @param timeEnd：结束时间
     * @return
     */
    public List<IndexStatics> search(int personId, int departmentId, Date timeStart, Date timeEnd) {
        return indexStaticsMapper.search(personId, departmentId, timeStart, timeEnd);
    }
}