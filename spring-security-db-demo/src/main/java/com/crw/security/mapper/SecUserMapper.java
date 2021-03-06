package com.crw.security.mapper;

import com.crw.security.model.SecUser;
import com.crw.security.model.SecUserExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SecUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @SelectProvider(type=SecUserSqlProvider.class, method="countByExample")
    long countByExample(SecUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @DeleteProvider(type=SecUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(SecUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @Delete({
        "delete from sec_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @Insert({
        "insert into sec_user (id, user_name, ",
        "password, nick_name, ",
        "roles, create_at, ",
        "update_at)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{roles,jdbcType=VARCHAR}, #{createAt,jdbcType=BIGINT}, ",
        "#{updateAt,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(SecUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @InsertProvider(type=SecUserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSelective(SecUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @SelectProvider(type=SecUserSqlProvider.class, method="selectByExample")
    List<SecUser> selectByExample(SecUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, user_name, password, nick_name, roles, create_at, update_at",
        "from sec_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    SecUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @UpdateProvider(type=SecUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SecUser record, @Param("example") SecUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @UpdateProvider(type=SecUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SecUser record, @Param("example") SecUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @UpdateProvider(type=SecUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SecUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    @Update({
        "update sec_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "roles = #{roles,jdbcType=VARCHAR},",
          "create_at = #{createAt,jdbcType=BIGINT},",
          "update_at = #{updateAt,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SecUser record);

    @Select({
            "select * from sec_user where user_name = #{userName}"
    })
    SecUser selectByUserName(String userName);
}