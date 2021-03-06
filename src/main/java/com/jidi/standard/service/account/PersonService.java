package com.jidi.standard.service.account;

import com.jidi.standard.mapper.PersonMapper;
import com.jidi.standard.entity.Person;
import com.jidi.standard.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lichenghai on Wed Apr 04 12:46:59 GMT+08:00 2018.
 */
@Service
@Transactional
public class PersonService extends AbstractService<Person> {
    @Resource
    private PersonMapper personMapper;

}