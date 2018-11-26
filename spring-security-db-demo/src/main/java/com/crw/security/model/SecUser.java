package com.crw.security.model;

import lombok.Data;

@Data
public class SecUser {

    public static final String DEFAULT_ROLE = "ROLE_USER";

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sec_user.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sec_user.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sec_user.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sec_user.nick_name
     *
     * @mbg.generated
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sec_user.roles
     *
     * @mbg.generated
     */
    private String roles;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sec_user.create_at
     *
     * @mbg.generated
     */
    private Long createAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sec_user.update_at
     *
     * @mbg.generated
     */
    private Long updateAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sec_user
     *
     * @mbg.generated
     */
    public SecUser(Long id, String userName, String password, String nickName, String roles, Long createAt, Long updateAt) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.roles = roles;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sec_user.id
     *
     * @return the value of sec_user.id
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sec_user.user_name
     *
     * @return the value of sec_user.user_name
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sec_user.password
     *
     * @return the value of sec_user.password
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sec_user.nick_name
     *
     * @return the value of sec_user.nick_name
     * @mbg.generated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sec_user.roles
     *
     * @return the value of sec_user.roles
     * @mbg.generated
     */
    public String getRoles() {
        return roles;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sec_user.create_at
     *
     * @return the value of sec_user.create_at
     * @mbg.generated
     */
    public Long getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sec_user.update_at
     *
     * @return the value of sec_user.update_at
     * @mbg.generated
     */
    public Long getUpdateAt() {
        return updateAt;
    }
}