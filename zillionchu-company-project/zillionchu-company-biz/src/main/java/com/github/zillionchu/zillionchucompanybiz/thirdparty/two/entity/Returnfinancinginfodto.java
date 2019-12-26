package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * 
 * 融资返回票据融资申请列表接口
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-24 16:45:13
 */
@Data
@ToString
public class Returnfinancinginfodto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	private List<Retentrstdpylist> retentrstdpylist;
	
	    //借据编号
    @ApiModelProperty(value = "借据编号", name = "DEBIT_I_D")
    private String debitID;
	
	    //保证金子账户
    @ApiModelProperty(value = "保证金子账户", name = "MRGN_SUB_ACC")
    private String mrgnSubAcc;
	
	    //保证金子账户名
    @ApiModelProperty(value = "保证金子账户名", name = "MRGN_SUB_ACC_NM")
    private String mrgnSubAccNm;
	
	    //开户后账户金额
    @ApiModelProperty(value = "开户后账户金额", name = "OPN_ACC_AF_ACC_GLD_AMT")
    private String opnAccAfAccGldAmt;

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
	 * 设置：保证金子账户
	 */
	public void setMrgnSubAcc(String mrgnSubAcc) {
		this.mrgnSubAcc = mrgnSubAcc;
	}
	/**
	 * 获取：保证金子账户
	 */
	public String getMrgnSubAcc() {
		return mrgnSubAcc;
	}
	/**
	 * 设置：保证金子账户名
	 */
	public void setMrgnSubAccNm(String mrgnSubAccNm) {
		this.mrgnSubAccNm = mrgnSubAccNm;
	}
	/**
	 * 获取：保证金子账户名
	 */
	public String getMrgnSubAccNm() {
		return mrgnSubAccNm;
	}
	/**
	 * 设置：开户后账户金额
	 */
	public void setOpnAccAfAccGldAmt(String opnAccAfAccGldAmt) {
		this.opnAccAfAccGldAmt = opnAccAfAccGldAmt;
	}
	/**
	 * 获取：开户后账户金额
	 */
	public String getOpnAccAfAccGldAmt() {
		return opnAccAfAccGldAmt;
	}

	public List<Retentrstdpylist> getRetentrstdpylist() {
		return retentrstdpylist;
	}

	public void setRetentrstdpylist(List<Retentrstdpylist> retentrstdpylist) {
		this.retentrstdpylist = retentrstdpylist;
	}
}
