package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * 
 * 
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-23 17:28:53
 */
@Data
@ToString
public class Videointerfacedto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	    //借据编号
    @ApiModelProperty(value = "借据编号", name = "DEBIT_I_D")
    @NotNull(message = "借据编号 不能为空!")
    @Max(value = 40, message = "借据编号超长")
    private String debitID;
	
	    //nihao
    @ApiModelProperty(value = "nihao", name = "IMG_INDX")
    @NotNull(message = "nihao 不能为空!")
    @Max(value = 2000, message = "nihao超长")
    private String imgIndx;

	/**
	 * 设置：借据编号
	 */
	public void setDebitID(String debitID) {
		this.debitID = debitID;
	}
	/**
	 * 获取：借据编号
	 */
	public String getDebitID() {
		return debitID;
	}
	/**
	 * 设置：nihao
	 */
	public void setImgIndx(String imgIndx) {
		this.imgIndx = imgIndx;
	}
	/**
	 * 获取：nihao
	 */
	public String getImgIndx() {
		return imgIndx;
	}
}
