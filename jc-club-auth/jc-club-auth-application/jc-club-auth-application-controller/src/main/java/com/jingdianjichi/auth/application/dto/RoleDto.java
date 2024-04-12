package com.jingdianjichi.auth.application.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@TableName("auth_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色唯一标识
     */
    private String roleKey;



    /**
     * 是否被删除 0未删除 1已删除
     */
    @TableLogic
    private Integer isDeleted;


}
