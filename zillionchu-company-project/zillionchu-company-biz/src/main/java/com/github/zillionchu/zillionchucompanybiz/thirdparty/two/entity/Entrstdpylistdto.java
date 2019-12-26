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
 * @email 受托支付列表信息
 * @date 2019-12-24 11:38:45
 */
@Data
@ToString
public class Entrstdpylistdto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	    //受托支付唯一标识
    @ApiModelProperty(value = "受托支付唯一标识", name = "ENTRSTD_PY_ONLY1_I_D")
	@NotNull(message = "受托支付唯一标 不能为空!")
    @Max(value = 40, message = "受托支付唯一标识超长")
    private String entrstdPyOnly1ID;
	
	    //付款通知书编号
    @ApiModelProperty(value = "付款通知书编号", name = "PYM_NTC_I_D")
    @Max(value = 40, message = "付款通知书编号超长")
    private String pymNtcID;
	
	    //受托支付通知信息
    @ApiModelProperty(value = "受托支付通知信息", name = "ENTRSTD_PY_NTC_INF")
    @Max(value = 60, message = "受托支付通知信息超长")
    private String entrstdPyNtcInf;
	
	    //是否更改受托支付对象信息
    @ApiModelProperty(value = "是否更改受托支付对象信息", name = "WTHR_UP_ENTRSTD_PY_OBJ_INF")
	@NotNull(message = "是否更改受托支付对象信息 不能为空!")
    @Max(value = 1, message = "是否更改受托支付对象信息超长")
    private String wthrUpEntrstdPyObjInf;
	
	    //受托支付对象户名
    @ApiModelProperty(value = "受托支付对象户名", name = "ENTRSTD_PY_OBJ_ACC_NM")
    @Max(value = 200, message = "受托支付对象户名超长")
    private String entrstdPyObjAccNm;
	
	    //受托支付对象账号
    @ApiModelProperty(value = "受托支付对象账号", name = "ENTRSTD_PY_OBJ_ACC_NO")
    @Max(value = 40, message = "受托支付对象账号超长")
    private String entrstdPyObjAccNo;
	
	    //汇入行名
    @ApiModelProperty(value = "汇入行名", name = "IW_BK_NM")
    @Max(value = 80, message = "汇入行名超长")
    private String iwBkNm;
	
	    //汇入行号
    @ApiModelProperty(value = "汇入行号", name = "IW_BK_NO")
    @Max(value = 40, message = "汇入行号超长")
    private String iwBkNo;
	

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
	 * 设置：受托支付通知信息
	 */
	public void setEntrstdPyNtcInf(String entrstdPyNtcInf) {
		this.entrstdPyNtcInf = entrstdPyNtcInf;
	}
	/**
	 * 获取：受托支付通知信息
	 */
	public String getEntrstdPyNtcInf() {
		return entrstdPyNtcInf;
	}
	/**
	 * 设置：是否更改受托支付对象信息
	 */
	public void setWthrUpEntrstdPyObjInf(String wthrUpEntrstdPyObjInf) {
		this.wthrUpEntrstdPyObjInf = wthrUpEntrstdPyObjInf;
	}
	/**
	 * 获取：是否更改受托支付对象信息
	 */
	public String getWthrUpEntrstdPyObjInf() {
		return wthrUpEntrstdPyObjInf;
	}
	/**
	 * 设置：受托支付对象户名
	 */
	public void setEntrstdPyObjAccNm(String entrstdPyObjAccNm) {
		this.entrstdPyObjAccNm = entrstdPyObjAccNm;
	}
	/**
	 * 获取：受托支付对象户名
	 */
	public String getEntrstdPyObjAccNm() {
		return entrstdPyObjAccNm;
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
	 * 设置：汇入行名
	 */
	public void setIwBkNm(String iwBkNm) {
		this.iwBkNm = iwBkNm;
	}
	/**
	 * 获取：汇入行名
	 */
	public String getIwBkNm() {
		return iwBkNm;
	}
	/**
	 * 设置：汇入行号
	 */
	public void setIwBkNo(String iwBkNo) {
		this.iwBkNo = iwBkNo;
	}
	/**
	 * 获取：汇入行号
	 */
	public String getIwBkNo() {
		return iwBkNo;
	}
}
