package com.mapper;

import com.domain.MtoChannel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MtoChannelMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(MtoChannel record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(MtoChannel record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    MtoChannel selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MtoChannel record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MtoChannel record);
}