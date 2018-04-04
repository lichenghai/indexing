package com.jidi.standard.service.standard;

import com.jidi.standard.mapper.IndexDetailMapper;
import com.jidi.standard.entity.IndexDetail;
import com.jidi.standard.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lichenghai on Wed Apr 04 12:46:59 GMT+08:00 2018.
 */
@Service
@Transactional
public class IndexDetailService extends AbstractService<IndexDetail> {
    @Resource
    private IndexDetailMapper indexDetailMapper;

}