package com.jidi.standard.service.account;

import com.jidi.standard.mapper.RelationsMapper;
import com.jidi.standard.entity.Relations;
import com.jidi.standard.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lichenghai on Wed Apr 04 12:46:59 GMT+08:00 2018.
 */
@Service
@Transactional
public class RelationsService extends AbstractService<Relations> {
    @Resource
    private RelationsMapper relationsMapper;

}