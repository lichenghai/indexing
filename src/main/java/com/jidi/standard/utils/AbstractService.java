package com.jidi.standard.utils;


import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 * Created by wangh09 on Thu Jul 13 14:40:19 GMT+08:00 2017.
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    private Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public Condition newCondition() {
        return new Condition(modelClass);
    }

    public void save(T model) {
        mapper.insertSelective(model);
    }

    public void save(List<T> models) {
        mapper.insertAll(models);
    }

    public void deleteById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public int deleteByCondition(Condition condition) {
        return mapper.deleteByCondition(condition);
    }

    public void update(T model) {
        mapper.updateByPrimaryKeySelective(model);
    }

    public T get(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Optional<T> getOpt(Integer id) {
        return Optional.ofNullable(this.get(id));
    }

    @Override
    public T getBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<T> listByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    public List<T> list(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    public List<T> listAll() {
        return mapper.selectAll();
    }
}
