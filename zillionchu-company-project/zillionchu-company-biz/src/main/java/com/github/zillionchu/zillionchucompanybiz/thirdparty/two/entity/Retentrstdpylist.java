package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * 
 * 融资信息返回受托支付列表
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-24 16:53:10
 */
@Data
@ToString
public class Retentrstdpylist extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	
	    //受托支付唯一标识
    @ApiModelProperty(value = "受托支付唯一标识", name = "ENTRSTD_PY_ONLY1_I_D")
    private String entrstdPyOnly1ID;
	
	    //付款通知书编号
    @ApiModelProperty(value = "付款通知书编号", name = "PYM_NTC_I_D")
    private String pymNtcID;
	
	    //受托支付对象账号
    @ApiModelProperty(value = "受托支付对象账号", name = "ENTRSTD_PY_OBJ_ACC_NO")
    private String entrstdPyObjAccNo;
	
	    //受托支付金额
    @ApiModelProperty(value = "受托支付金额", name = "ENTRSTD_PY_AMT")
    private String entrstdPyAmt;

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
	 * 设置：受托支付对象账号
	 */
	public void setEntrstdPyObjAccNo(String entrstdPyObjAccNo) {
		this.entrstdPyObjAccNo = entrstdPyObjAccNo;
	}
	/**
	 * 获取：受托支付对象账号
	 */
	public String getEntrstdPyObjAccNo() {
		return entrstdPyObjAccNo;
	}
	/**
	 * 设置：受托支付金额
	 */
	public void setEntrstdPyAmt(String entrstdPyAmt) {
		this.entrstdPyAmt = entrstdPyAmt;
	}
	/**
	 * 获取：受托支付金额
	 */
	public String getEntrstdPyAmt() {
		return entrstdPyAmt;
	}
}
