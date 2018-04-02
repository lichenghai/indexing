package com.jidi.standard.utils;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Optional;

/**
 * Created by wangh09 on Thu Jul 13 14:40:19 GMT+08:00 2017.
 */
public interface Service<T> {
    void save(T model);//持久化

    void save(List<T> models);//批量持久化

    void deleteById(Integer id);//通过主鍵刪除

    void deleteByIds(String ids);//批量刪除 eg：ids -> “1,2,3,4”

    int deleteByCondition(Condition condition);// 根据条件删除

    void update(T model);//更新

    T get(Integer id);//通过ID查找

    Optional<T> getOpt(Integer id);// 通过ID查找，返回optional

    T getBy(String fieldName, Object value) throws TooManyResultsException; //通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束

    List<T> listByIds(String ids);//通过多个ID查找//eg：ids -> “1,2,3,4”

    List<T> list(Condition condition);//根据条件查找

    List<T> listAll();//获取所有
}
