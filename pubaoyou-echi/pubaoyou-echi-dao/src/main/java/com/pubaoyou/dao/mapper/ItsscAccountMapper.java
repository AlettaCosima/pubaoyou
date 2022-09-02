package com.pubaoyou.dao.mapper;

import com.pubaoyou.dao.models.ItsscAccount;
import com.pubaoyou.dao.models.ItsscAccountExample;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ItsscAccountMapper {

//    long countByExample(ItsscAccountExample example);
//
//    int deleteByExample(ItsscAccountExample example);
//
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(ItsscAccount record);
//
//    int insertSelective(ItsscAccount record);

    List<ItsscAccount> selectByExample(ItsscAccountExample example);

//
//    ItsscAccount selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") ItsscAccount record, @Param("example") ItsscAccountExample example);
//
//    int updateByExample(@Param("record") ItsscAccount record, @Param("example") ItsscAccountExample example);
//
//    int updateByPrimaryKeySelective(ItsscAccount record);
//
//    int updateByPrimaryKey(ItsscAccount record);
}