package com.jingdianjichi.auth.application.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@TableName("auth_user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;


    private Integer isDeleted;


}
