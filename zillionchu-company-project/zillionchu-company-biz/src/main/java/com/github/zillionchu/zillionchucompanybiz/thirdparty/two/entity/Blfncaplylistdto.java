package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * 
 * 票据融资申请列表
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-24 16:28:12
 */
@Data
@ToString
public class Blfncaplylistdto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	
	    //电子票号
    @ApiModelProperty(value = "电子票号", name = "ELC_BILL_NO")
    @Max(value = 30, message = "电子票号超长")
    private String elcBillNo;
	
	    //票据类型
    @ApiModelProperty(value = "票据类型", name = "BL_TP")
    @Max(value = 4, message = "票据类型超长")
    private String blTp;
	
	    //出票日
    @ApiModelProperty(value = "出票日", name = "ISSU_OF_PPR_DAY")
    @Max(value = 8, message = "出票日超长")
    private String issuOfPprDay;
	
	    //到期日
    @ApiModelProperty(value = "到期日", name = "EX_DY")
    @Max(value = 8, message = "到期日超长")
    private String exDy;
	
	    //出票人类型
    @ApiModelProperty(value = "出票人类型", name = "RMTR_TP")
    @Max(value = 4, message = "出票人类型超长")
    private String rmtrTp;
	
	    //出票人名称
    @ApiModelProperty(value = "出票人名称", name = "RMTR_NM")
    @Max(value = 60, message = "出票人名称超长")
    private String rmtrNm;
	
	    //出票人组织机构代码证
    @ApiModelProperty(value = "出票人组织机构代码证", name = "RMTR_OR_CD")
    @Max(value = 20, message = "出票人组织机构代码证超长")
    private String rmtrOrCd;
	
	    //出票人开户帐户
    @ApiModelProperty(value = "出票人开户帐户", name = "RMTR_OPN_ACC_ACC")
    @Max(value = 32, message = "出票人开户帐户超长")
    private String rmtrOpnAccAcc;
	
	    //出票人行号
    @ApiModelProperty(value = "出票人行号", name = "RMTR_BR_NO")
    @Max(value = 12, message = "出票人行号超长")
    private String rmtrBrNo;
	
	    //到期无条件支付委托
    @ApiModelProperty(value = "到期无条件支付委托", name = "EXP_U_CND_PY_ENTRST")
    @Max(value = 4, message = "到期无条件支付委托超长")
    private String expUCndPyEntrst;
	
	    //出票人签名
    @ApiModelProperty(value = "出票人签名", name = "RMTR_SGN")
    @Max(value = 2000, message = "出票人签名超长")
    private String rmtrSgn;
	
	    //承兑人名称
    @ApiModelProperty(value = "承兑人名称", name = "ACPTR_NM")
    @Max(value = 60, message = "承兑人名称超长")
    private String acptrNm;
	
	    //承兑人账号
    @ApiModelProperty(value = "承兑人账号", name = "ACPTR_ACC_NO")
    @Max(value = 32, message = "承兑人账号超长")
    private String acptrAccNo;
	
	    //承兑人行号
    @ApiModelProperty(value = "承兑人行号", name = "ACPTR_BR_NO")
    @Max(value = 12, message = "承兑人行号超长")
    private String acptrBrNo;
	
	    //申请承兑金额
    @ApiModelProperty(value = "申请承兑金额", name = "APLY_ACPT_AMT")
    @Max(value = 16, message = "申请承兑金额超长")
    private String aplyAcptAmt;
	
	    //允许背书
    @ApiModelProperty(value = "允许背书", name = "PRMT_EDRS")
    @Max(value = 4, message = "允许背书超长")
    private String prmtEdrs;
	
	    //收款人名称
    @ApiModelProperty(value = "收款人名称", name = "RCV_PYMT_PS_NM")
    @Max(value = 60, message = "收款人名称超长")
    private String rcvPymtPsNm;
	
	    //收款人开户帐户
    @ApiModelProperty(value = "收款人开户帐户", name = "RCV_PYMT_PS_OPN_ACC_ACC")
    @Max(value = 32, message = "收款人开户帐户超长")
    private String rcvPymtPsOpnAccAcc;
	
	    //收款人开户行行号
    @ApiModelProperty(value = "收款人开户行行号", name = "R_P_P_D_BNK_BR_NO")
    @Max(value = 12, message = "收款人开户行行号超长")
    private String rPPDBnkBrNo;
	
	    //保证金占用金额
    @ApiModelProperty(value = "保证金占用金额", name = "MRGN_OCP_AMT")
    @Max(value = 16, message = "保证金占用金额超长")
    private String mrgnOcpAmt;
	
	    //担保物占用金额
    @ApiModelProperty(value = "担保物占用金额", name = "GURT_OCP_AMT")
    @Max(value = 16, message = "担保物占用金额超长")
    private String gurtOcpAmt;
	
	    //备注
    @ApiModelProperty(value = "备注", name = "RMRK")
    @Max(value = 256, message = "备注超长")
    private String rmrk;
	

	/**
	 * 设置：电子票号
	 */
	public void setElcBillNo(String elcBillNo) {
		this.elcBillNo = elcBillNo;
	}
	/**
	 * 获取：电子票号
	 */
	public String getElcBillNo() {
		return elcBillNo;
	}
	/**
	 * 设置：票据类型
	 */
	public void setBlTp(String blTp) {
		this.blTp = blTp;
	}
	/**
	 * 获取：票据类型
	 */
	public String getBlTp() {
		return blTp;
	}
	/**
	 * 设置：出票日
	 */
	public void setIssuOfPprDay(String issuOfPprDay) {
		this.issuOfPprDay = issuOfPprDay;
	}
	/**
	 * 获取：出票日
	 */
	public String getIssuOfPprDay() {
		return issuOfPprDay;
	}
	/**
	 * 设置：到期日
	 */
	public void setExDy(String exDy) {
		this.exDy = exDy;
	}
	/**
	 * 获取：到期日
	 */
	public String getExDy() {
		return exDy;
	}
	/**
	 * 设置：出票人类型
	 */
	public void setRmtrTp(String rmtrTp) {
		this.rmtrTp = rmtrTp;
	}
	/**
	 * 获取：出票人类型
	 */
	public String getRmtrTp() {
		return rmtrTp;
	}
	/**
	 * 设置：出票人名称
	 */
	public void setRmtrNm(String rmtrNm) {
		this.rmtrNm = rmtrNm;
	}
	/**
	 * 获取：出票人名称
	 */
	public String getRmtrNm() {
		return rmtrNm;
	}
	/**
	 * 设置：出票人组织机构代码证
	 */
	public void setRmtrOrCd(String rmtrOrCd) {
		this.rmtrOrCd = rmtrOrCd;
	}
	/**
	 * 获取：出票人组织机构代码证
	 */
	public String getRmtrOrCd() {
		return rmtrOrCd;
	}
	/**
	 * 设置：出票人开户帐户
	 */
	public void setRmtrOpnAccAcc(String rmtrOpnAccAcc) {
		this.rmtrOpnAccAcc = rmtrOpnAccAcc;
	}
	/**
	 * 获取：出票人开户帐户
	 */
	public String getRmtrOpnAccAcc() {
		return rmtrOpnAccAcc;
	}
	/**
	 * 设置：出票人行号
	 */
	public void setRmtrBrNo(String rmtrBrNo) {
		this.rmtrBrNo = rmtrBrNo;
	}
	/**
	 * 获取：出票人行号
	 */
	public String getRmtrBrNo() {
		return rmtrBrNo;
	}
	/**
	 * 设置：到期无条件支付委托
	 */
	public void setExpUCndPyEntrst(String expUCndPyEntrst) {
		this.expUCndPyEntrst = expUCndPyEntrst;
	}
	/**
	 * 获取：到期无条件支付委托
	 */
	public String getExpUCndPyEntrst() {
		return expUCndPyEntrst;
	}
	/**
	 * 设置：出票人签名
	 */
	public void setRmtrSgn(String rmtrSgn) {
		this.rmtrSgn = rmtrSgn;
	}
	/**
	 * 获取：出票人签名
	 */
	public String getRmtrSgn() {
		return rmtrSgn;
	}
	/**
	 * 设置：承兑人名称
	 */
	public void setAcptrNm(String acptrNm) {
		this.acptrNm = acptrNm;
	}
	/**
	 * 获取：承兑人名称
	 */
	public String getAcptrNm() {
		return acptrNm;
	}
	/**
	 * 设置：承兑人账号
	 */
	public void setAcptrAccNo(String acptrAccNo) {
		this.acptrAccNo = acptrAccNo;
	}
	/**
	 * 获取：承兑人账号
	 */
	public String getAcptrAccNo() {
		return acptrAccNo;
	}
	/**
	 * 设置：承兑人行号
	 */
	public void setAcptrBrNo(String acptrBrNo) {
		this.acptrBrNo = acptrBrNo;
	}
	/**
	 * 获取：承兑人行号
	 */
	public String getAcptrBrNo() {
		return acptrBrNo;
	}
	/**
	 * 设置：申请承兑金额
	 */
	public void setAplyAcptAmt(String aplyAcptAmt) {
		this.aplyAcptAmt = aplyAcptAmt;
	}
	/**
	 * 获取：申请承兑金额
	 */
	public String getAplyAcptAmt() {
		return aplyAcptAmt;
	}
	/**
	 * 设置：允许背书
	 */
	public void setPrmtEdrs(String prmtEdrs) {
		this.prmtEdrs = prmtEdrs;
	}
	/**
	 * 获取：允许背书
	 */
	public String getPrmtEdrs() {
		return prmtEdrs;
	}
	/**
	 * 设置：收款人名称
	 */
	public void setRcvPymtPsNm(String rcvPymtPsNm) {
		this.rcvPymtPsNm = rcvPymtPsNm;
	}
	/**
	 * 获取：收款人名称
	 */
	public String getRcvPymtPsNm() {
		return rcvPymtPsNm;
	}
	/**
	 * 设置：收款人开户帐户
	 */
	public void setRcvPymtPsOpnAccAcc(String rcvPymtPsOpnAccAcc) {
		this.rcvPymtPsOpnAccAcc = rcvPymtPsOpnAccAcc;
	}
	/**
	 * 获取：收款人开户帐户
	 */
	public String getRcvPymtPsOpnAccAcc() {
		return rcvPymtPsOpnAccAcc;
	}
	/**
	 * 设置：收款人开户行行号
	 */
	public void setRPPDBnkBrNo(String rPPDBnkBrNo) {
		this.rPPDBnkBrNo = rPPDBnkBrNo;
	}
	/**
	 * 获取：收款人开户行行号
	 */
	public String getRPPDBnkBrNo() {
		return rPPDBnkBrNo;
	}
	/**
	 * 设置：保证金占用金额
	 */
	public void setMrgnOcpAmt(String mrgnOcpAmt) {
		this.mrgnOcpAmt = mrgnOcpAmt;
	}
	/**
	 * 获取：保证金占用金额
	 */
	public String getMrgnOcpAmt() {
		return mrgnOcpAmt;
	}
	/**
	 * 设置：担保物占用金额
	 */
	public void setGurtOcpAmt(String gurtOcpAmt) {
		this.gurtOcpAmt = gurtOcpAmt;
	}
	/**
	 * 获取：担保物占用金额
	 */
	public String getGurtOcpAmt() {
		return gurtOcpAmt;
	}
	/**
	 * 设置：备注
	 */
	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
	}
	/**
	 * 获取：备注
	 */
	public String getRmrk() {
		return rmrk;
	}
}
