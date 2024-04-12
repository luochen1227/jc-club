package com.jingdianjichi.auth.infra.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@TableName("auth_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 权限类型 0菜单 1操作
     */
    private Byte type;

    /**
     * 菜单路由
     */
    private String menuUrl;

    /**
     * 状态 0启用 1禁用
     */
    private Byte status;

    /**
     * 展示状态 0展示 1隐藏
     */
    @TableField("`show`")
    private Byte show;

    /**
     * 图标
     */
    private String icon;

    /**
     * 权限唯一标识
     */
    private String permissionKey;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否被删除 0为删除 1已删除
     */
    @TableLogic
    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getShow() {
        return show;
    }

    public void setShow(Byte show) {
        this.show = show;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Permission{" +
            "id = " + id +
            ", name = " + name +
            ", parentId = " + parentId +
            ", type = " + type +
            ", menuUrl = " + menuUrl +
            ", status = " + status +
            ", show = " + show +
            ", icon = " + icon +
            ", permissionKey = " + permissionKey +
            ", createdBy = " + createdBy +
            ", createdTime = " + createdTime +
            ", updateBy = " + updateBy +
            ", updateTime = " + updateTime +
            ", isDeleted = " + isDeleted +
        "}";
    }
}
