package com.guigu.instructional.system.mapper;

import com.guigu.instructional.po.AuthortyInfo;
import com.guigu.instructional.po.AuthortyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthortyInfoMapper {
    int countByExample(AuthortyInfoExample example);

    int deleteByExample(AuthortyInfoExample example);

    int deleteByPrimaryKey(Integer authortyId);

    int insert(AuthortyInfo record);

    int insertSelective(AuthortyInfo record);

    List<AuthortyInfo> selectByExample(AuthortyInfoExample example);

    AuthortyInfo selectByPrimaryKey(Integer authortyId);

    int updateByExampleSelective(@Param("record") AuthortyInfo record, @Param("example") AuthortyInfoExample example);

    int updateByExample(@Param("record") AuthortyInfo record, @Param("example") AuthortyInfoExample example);

    int updateByPrimaryKeySelective(AuthortyInfo record);

    int updateByPrimaryKey(AuthortyInfo record);
}