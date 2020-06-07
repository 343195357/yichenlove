package com.yc.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.yc.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yiChenLove
 * @since 2020-06-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_config")
@ApiModel(value="SysConfig对象", description="")
public class SysConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String key;

    private String value;

    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
