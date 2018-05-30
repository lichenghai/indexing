package com.jidi.standard.mapper;

import com.jidi.standard.entity.IndexStatics;
import com.jidi.standard.utils.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IndexStaticsMapper extends Mapper<IndexStatics> {
    public List<IndexStatics> search(
            @Param("personId") Integer personId,
            @Param("departmentId") Integer departmentId,
            @Param("timeStart") Date timeStart,
            @Param("timeEnd") Date timeEnd);
}