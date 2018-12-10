package com.loveindc.preference.dao;

import com.loveindc.preference.entity.UserPreference;
import com.loveindc.preference.vo.UserPreferenceVO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserPreferenceDAO {
    @Insert("insert into user_preference(id) values(#{id})")
    int create(@Param("id") int id);

    @Select("select * from user_preference where id = #{id}")
    UserPreference getById(@Param("id") int id);

    @Update("update user_preference set sports=#{sports}, music=#{music}, technology=#{technology}, politics=#{politics}, " +
            "art=#{art}, literature=#{literature}, game=#{game}, movie=#{movie}, cooking=#{cooking}, finance=#{finance} where id = #{id}")
//            + "values(#{id}, #{sports}, #{music}, #{technology}, #{politics}, #{art}, #{literature}, #{game}, #{movie}, #{cooking}, #{finance})")
    int update(UserPreference userPreference);
}
