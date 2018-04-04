package com.jidi.standard.service.standard;

import com.jidi.standard.mapper.IndexStaticsMapper;
import com.jidi.standard.entity.IndexStatics;
import com.jidi.standard.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lichenghai on Wed Apr 04 12:46:59 GMT+08:00 2018.
 */
@Service
@Transactional
public class IndexStaticsService extends AbstractService<IndexStatics> {
    @Resource
    private IndexStaticsMapper indexStaticsMapper;

}