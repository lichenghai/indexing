package com.jidi.standard.service.standard;

import com.jidi.standard.mapper.StandardResultMapper;
import com.jidi.standard.entity.StandardResult;
import com.jidi.standard.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lichenghai on Wed Apr 04 12:46:59 GMT+08:00 2018.
 */
@Service
@Transactional
public class StandardResultService extends AbstractService<StandardResult> {
    @Resource
    private StandardResultMapper standardResultMapper;

}