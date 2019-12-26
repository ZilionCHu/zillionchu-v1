package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * 
 * 货押商品品种查询接口实体类
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-24 17:41:03
 */
@Data
@ToString
public class Hycmdtyvrtyclassdto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	
	    //货押商品目录ID
    @ApiModelProperty(value = "货押商品目录ID", name = "HY_CMDTY_VRTY_CLASS_I_D")
    @Max(value = 32, message = "货押商品目录ID超长")
    private String hyCmdtyVrtyClassID;
	

	/**
	 * 设置：货押商品目录ID
	 */
	public void setHyCmdtyVrtyClassID(String hyCmdtyVrtyClassID) {
		this.hyCmdtyVrtyClassID = hyCmdtyVrtyClassID;
	}
	/**
	 * 获取：货押商品目录ID
	 */
	public String getHyCmdtyVrtyClassID() {
		return hyCmdtyVrtyClassID;
	}
}
