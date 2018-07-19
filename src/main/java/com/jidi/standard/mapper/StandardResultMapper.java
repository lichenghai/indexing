package com.jidi.standard.mapper;

import com.jidi.standard.entity.StandardResult;
import com.jidi.standard.entity.vo.ResultForSearch;
import com.jidi.standard.utils.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StandardResultMapper extends Mapper<StandardResult> {
    public List<ResultForSearch> getResultForSearch(
            @Param("increaseType") Integer increaseType,
            @Param("commentType") Integer commentType,
            @Param("timeStart") Date timeStart,
            @Param("timeEnd") Date timeEnd,
            @Param("personId") Integer personId);

}