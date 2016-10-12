package org.spring.mybatis.example.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.spring.mybatis.example.domain.security.AuthorityGroup;

@Mapper
public interface AuthorityGroupRepository {

    @Select("SELECT * FROM authority_group WHERE id = #{id}")
    @Results({
            @Result(property = "createdBy", column = "created_by")
    })
    AuthorityGroup findById(@Param("id") final Long id);

    @Insert("INSERT INTO authority_group (created_by, name, description) VALUES (#{createdBy}, #{name}, #{description})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(final AuthorityGroup authorityGroup);

    @Delete("DELETE FROM authority_group WHERE id = #{id}")
    int delete(@Param("id") final Long id);

    @Update("UPDATE authority_group " +
            "SET " +
            "   created_by = #{createdBy}, " +
            "   name = #{name}, " +
            "   description = #{description} " +
            "WHERE id = #{id}")
    int update(final AuthorityGroup authorityGroup);

}
