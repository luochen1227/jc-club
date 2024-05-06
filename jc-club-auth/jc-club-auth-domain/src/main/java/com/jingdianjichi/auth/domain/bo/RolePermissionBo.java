package com.jingdianjichi.auth.domain.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 角色权限关联表
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@TableName("auth_role_permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RolePermissionBo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long permissionId;

    private List<Long> permissionIdList;

    @TableLogic
    private Integer isDeleted;

}
