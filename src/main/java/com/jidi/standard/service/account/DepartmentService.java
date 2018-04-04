package com.jidi.standard.service.account;

import com.jidi.standard.mapper.DepartmentMapper;
import com.jidi.standard.entity.Department;
import com.jidi.standard.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lichenghai on Wed Apr 04 12:46:59 GMT+08:00 2018.
 */
@Service
@Transactional
public class DepartmentService extends AbstractService<Department> {
    @Resource
    private DepartmentMapper departmentMapper;

}