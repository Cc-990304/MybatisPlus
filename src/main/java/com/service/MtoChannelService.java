package com.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.domain.MtoChannel;
import com.mapper.MtoChannelMapper;
@Service
public class MtoChannelService{

    @Autowired
    private MtoChannelMapper mtoChannelMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return mtoChannelMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(MtoChannel record) {
        return mtoChannelMapper.insert(record);
    }

    
    public int insertSelective(MtoChannel record) {
        return mtoChannelMapper.insertSelective(record);
    }

    
    public MtoChannel selectByPrimaryKey(Integer id) {
        return mtoChannelMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(MtoChannel record) {
        return mtoChannelMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(MtoChannel record) {
        return mtoChannelMapper.updateByPrimaryKey(record);
    }

}
