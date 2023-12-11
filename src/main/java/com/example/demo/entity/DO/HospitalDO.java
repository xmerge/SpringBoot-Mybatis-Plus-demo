package com.example.demo.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 医院表
 * </p>
 *
 * @author Xmerge
 * @since 2023-12-11
 */
@Getter
@Setter
@TableName("tb_hospital")
public class HospitalDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 医院名称
     */
    @TableField("title")
    private String title;

    /**
     * 审核状态,1:审核通过；0：待审核
     */
    @TableField("audit_status")
    private Byte auditStatus;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
