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
 * @email 返回受托支付结果列表
 * @date 2019-12-24 11:32:33
 */
@Data
@ToString
public class Retentrstdpyrsltlistdto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	    //受托支付唯一标识
    @ApiModelProperty(value = "受托支付唯一标识", name = "ENTRSTD_PY_ONLY1_I_D")
    private String entrstdPyOnly1ID;
	
	    //付款通知书编号
    @ApiModelProperty(value = "付款通知书编号", name = "PYM_NTC_I_D")
    private String pymNtcID;
	
	    //成功标识
    @ApiModelProperty(value = "成功标识", name = "SCSS_I_D")
    private String scssID;
	

	/**
	 * 设置：受托支付唯一标识
	 */
	public void setEntrstdPyOnly1ID(String entrstdPyOnly1ID) {
		this.entrstdPyOnly1ID = entrstdPyOnly1ID;
	}
	/**
	 * 获取：受托支付唯一标识
	 */
	public String getEntrstdPyOnly1ID() {
		return entrstdPyOnly1ID;
	}
	/**
	 * 设置：付款通知书编号
	 */
	public void setPymNtcID(String pymNtcID) {
		this.pymNtcID = pymNtcID;
	}
	/**
	 * 获取：付款通知书编号
	 */
	public String getPymNtcID() {
		return pymNtcID;
	}
	/**
	 * 设置：成功标识
	 */
	public void setScssID(String scssID) {
		this.scssID = scssID;
	}
	/**
	 * 获取：成功标识
	 */
	public String getScssID() {
		return scssID;
	}
}
