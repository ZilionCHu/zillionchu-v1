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
 * 
 * @author Mr.AG
 * @email 担保信息接口
 * @date 2019-12-24 14:54:54
 */
@Data
@ToString
public class Warrantyinfodto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "质押商品列表", name = "FNC_APLY_I_D")
	private List<Hycmdtylistsdto> list;

	    //融资申请编号
    @ApiModelProperty(value = "融资申请编号", name = "FNC_APLY_I_D")
    @Max(value = 40, message = "融资申请编号超长")
    private String fncAplyID;
	
	    //担保人客户编号
    @ApiModelProperty(value = "担保人客户编号", name = "GNR_CST_I_D")
    @Max(value = 20, message = "担保人客户编号超长")
    private String gnrCstID;
	
	    //是否有效
    @ApiModelProperty(value = "是否有效", name = "WTHR_VLD")
    @Max(value = 20, message = "是否有效超长")
    private String wthrVld;
	
	    //保证金比例
    @ApiModelProperty(value = "保证金比例", name = "MRGN_PCTG")
    @Max(value = 20, message = "保证金比例超长")
    private String mrgnPctg;
	
	    //担保类型代码
    @ApiModelProperty(value = "担保类型代码", name = "WRNT_TP_CD")
    @Max(value = 40, message = "担保类型代码超长")
    private String wrntTpCd;
	
	    //是否有初始保证金
    @ApiModelProperty(value = "是否有初始保证金", name = "WTHR_INL_MRGN")
    @Max(value = 1, message = "是否有初始保证金超长")
    private String wthrInlMrgn;
	
	    //保证金币种
    @ApiModelProperty(value = "保证金币种", name = "MRGN_CCY")
    @Max(value = 16, message = "保证金币种超长")
    private String mrgnCcy;
	
	    //初始保证金金额
    @ApiModelProperty(value = "初始保证金金额", name = "INL_MRGN_AMT")
    @Max(value = 1, message = "初始保证金金额超长")
    private String inlMrgnAmt;
	
	    //结算账户名称
    @ApiModelProperty(value = "结算账户名称", name = "SETL_ACC_NM")
    @Max(value = 20, message = "结算账户名称超长")
    private String setlAccNm;
	
	    //结算账户
    @ApiModelProperty(value = "结算账户", name = "SETL_ACC")
    @Max(value = 20, message = "结算账户超长")
    private String setlAcc;
	
	    //保证金账户名称
    @ApiModelProperty(value = "保证金账户名称", name = "MRGN_ACC_NM")
    @Max(value = 80, message = "保证金账户名称超长")
    private String mrgnAccNm;
	
	    //保证金主账户
    @ApiModelProperty(value = "保证金主账户", name = "MRGN_PRIM_ACC")
    @Max(value = 40, message = "保证金主账户超长")
    private String mrgnPrimAcc;
	
	    //开销户操作类型
    @ApiModelProperty(value = "开销户操作类型", name = "OPN_CNCL_ACC_MNPLT_TP")
    @Max(value = 160, message = "开销户操作类型超长")
    private String opnCnclAccMnpltTp;
	
	    //经办人
    @ApiModelProperty(value = "经办人", name = "RSPB_PSN")
    @Max(value = 40, message = "经办人超长")
    private String rspbPsn;
	
	    //经办机构
    @ApiModelProperty(value = "经办机构", name = "HDL_INST")
    @Max(value = 20, message = "经办机构超长")
    private String hdlInst;
	
	    //利息入账账号
    @ApiModelProperty(value = "利息入账账号", name = "INT_ACC_ENTR_ACC_NO")
    @Max(value = 40, message = "利息入账账号超长")
    private String intAccEntrAccNo;
	
	    //保证金子账户名称
    @ApiModelProperty(value = "保证金子账户名称", name = "MRGN_SUB_ACC_NM")
    @Max(value = 160, message = "保证金子账户名称超长")
    private String mrgnSubAccNm;
	
	    //保证金用途
    @ApiModelProperty(value = "保证金用途", name = "MRGN_USE")
    @Max(value = 20, message = "保证金用途超长")
    private String mrgnUse;
	
	    //存款类型
    @ApiModelProperty(value = "存款类型", name = "DEP_TP")
    @Max(value = 20, message = "存款类型超长")
    private String depTp;
	
	    //定期保证金存款期限（月）
    @ApiModelProperty(value = "定期保证金存款期限（月）", name = "TRM_MRGN_DEP_DDLN")
    @Max(value = 8, message = "定期保证金存款期限（月）超长")
    private String trmMrgnDepDdln;
	
	    //转入金额
    @ApiModelProperty(value = "转入金额", name = "TFR_IN_AMT")
    @Max(value = 20, message = "转入金额超长")
    private String tfrInAmt;
	
	    //保证金子账户开户原因
    @ApiModelProperty(value = "保证金子账户开户原因", name = "MRGN_SUB_ACC_OPN_ACC_RSN")
    @Max(value = 512, message = "保证金子账户开户原因超长")
    private String mrgnSubAccOpnAccRsn;
	
	    //保证金来源合法性调查结论
    @ApiModelProperty(value = "保证金来源合法性调查结论", name = "MRGN_SRC_SURVY_CNCLSN")
    @Max(value = 200, message = "保证金来源合法性调查结论超长")
    private String mrgnSrcSurvyCnclsn;
	
	    //计息利率依据
    @ApiModelProperty(value = "计息利率依据", name = "INT_AR_INT_RT_ACRD_TO")
    @Max(value = 20, message = "计息利率依据超长")
    private String intArIntRtAcrdTo;
	
	    //利率种类
    @ApiModelProperty(value = "利率种类", name = "INT_RT_CTLG")
    @Max(value = 20, message = "利率种类超长")
    private String intRtCtlg;
	
	    //利率浮动类型
    @ApiModelProperty(value = "利率浮动类型", name = "INT_RT_FLT_TP")
    @Max(value = 20, message = "利率浮动类型超长")
    private String intRtFltTp;
	
	    //浮动比率
    @ApiModelProperty(value = "浮动比率", name = "FLT_RTO")
    @Max(value = 20, message = "浮动比率超长")
    private String fltRto;
	
	    //浮动点数
    @ApiModelProperty(value = "浮动点数", name = "FLT_PNT")
    @Max(value = 20, message = "浮动点数超长")
    private String fltPnt;
	
	    //利率档次
    @ApiModelProperty(value = "利率档次", name = "INT_RT_LVL")
    @Max(value = 20, message = "利率档次超长")
    private String intRtLvl;
	
	    //指定利率
    @ApiModelProperty(value = "指定利率", name = "APNT_INT_RT")
    @Max(value = 16, message = "指定利率超长")
    private String apntIntRt;
	
	    //利率调整方式
    @ApiModelProperty(value = "利率调整方式", name = "INT_ADJ_MOD")
    @Max(value = 20, message = "利率调整方式超长")
    private String intAdjMod;
	
	    //调整周期类型
    @ApiModelProperty(value = "调整周期类型", name = "ADJ_DY_TP")
    @Max(value = 20, message = "调整周期类型超长")
    private String adjDyTp;
	
	    //调整起始日类型
    @ApiModelProperty(value = "调整起始日类型", name = "ADJ_BG_DY_TP")
    @Max(value = 20, message = "调整起始日类型超长")
    private String adjBgDyTp;
	
	    //调整指定日期
    @ApiModelProperty(value = "调整指定日期", name = "ADJ_APNT_DT")
    @Max(value = 40, message = "调整指定日期超长")
    private String adjApntDt;

	public List<Hycmdtylistsdto> getList() {
		return list;
	}

	public void setList(List<Hycmdtylistsdto> list) {
		this.list = list;
	}

	/**
	 * 设置：融资申请编号
	 */
	public void setFncAplyID(String fncAplyID) {
		this.fncAplyID = fncAplyID;
	}
	/**
	 * 获取：融资申请编号
	 */
	public String getFncAplyID() {
		return fncAplyID;
	}
	/**
	 * 设置：担保人客户编号
	 */
	public void setGnrCstID(String gnrCstID) {
		this.gnrCstID = gnrCstID;
	}
	/**
	 * 获取：担保人客户编号
	 */
	public String getGnrCstID() {
		return gnrCstID;
	}
	/**
	 * 设置：是否有效
	 */
	public void setWthrVld(String wthrVld) {
		this.wthrVld = wthrVld;
	}
	/**
	 * 获取：是否有效
	 */
	public String getWthrVld() {
		return wthrVld;
	}
	/**
	 * 设置：保证金比例
	 */
	public void setMrgnPctg(String mrgnPctg) {
		this.mrgnPctg = mrgnPctg;
	}
	/**
	 * 获取：保证金比例
	 */
	public String getMrgnPctg() {
		return mrgnPctg;
	}
	/**
	 * 设置：担保类型代码
	 */
	public void setWrntTpCd(String wrntTpCd) {
		this.wrntTpCd = wrntTpCd;
	}
	/**
	 * 获取：担保类型代码
	 */
	public String getWrntTpCd() {
		return wrntTpCd;
	}
	/**
	 * 设置：是否有初始保证金
	 */
	public void setWthrInlMrgn(String wthrInlMrgn) {
		this.wthrInlMrgn = wthrInlMrgn;
	}
	/**
	 * 获取：是否有初始保证金
	 */
	public String getWthrInlMrgn() {
		return wthrInlMrgn;
	}
	/**
	 * 设置：保证金币种
	 */
	public void setMrgnCcy(String mrgnCcy) {
		this.mrgnCcy = mrgnCcy;
	}
	/**
	 * 获取：保证金币种
	 */
	public String getMrgnCcy() {
		return mrgnCcy;
	}
	/**
	 * 设置：初始保证金金额
	 */
	public void setInlMrgnAmt(String inlMrgnAmt) {
		this.inlMrgnAmt = inlMrgnAmt;
	}
	/**
	 * 获取：初始保证金金额
	 */
	public String getInlMrgnAmt() {
		return inlMrgnAmt;
	}
	/**
	 * 设置：结算账户名称
	 */
	public void setSetlAccNm(String setlAccNm) {
		this.setlAccNm = setlAccNm;
	}
	/**
	 * 获取：结算账户名称
	 */
	public String getSetlAccNm() {
		return setlAccNm;
	}
	/**
	 * 设置：结算账户
	 */
	public void setSetlAcc(String setlAcc) {
		this.setlAcc = setlAcc;
	}
	/**
	 * 获取：结算账户
	 */
	public String getSetlAcc() {
		return setlAcc;
	}
	/**
	 * 设置：保证金账户名称
	 */
	public void setMrgnAccNm(String mrgnAccNm) {
		this.mrgnAccNm = mrgnAccNm;
	}
	/**
	 * 获取：保证金账户名称
	 */
	public String getMrgnAccNm() {
		return mrgnAccNm;
	}
	/**
	 * 设置：保证金主账户
	 */
	public void setMrgnPrimAcc(String mrgnPrimAcc) {
		this.mrgnPrimAcc = mrgnPrimAcc;
	}
	/**
	 * 获取：保证金主账户
	 */
	public String getMrgnPrimAcc() {
		return mrgnPrimAcc;
	}
	/**
	 * 设置：开销户操作类型
	 */
	public void setOpnCnclAccMnpltTp(String opnCnclAccMnpltTp) {
		this.opnCnclAccMnpltTp = opnCnclAccMnpltTp;
	}
	/**
	 * 获取：开销户操作类型
	 */
	public String getOpnCnclAccMnpltTp() {
		return opnCnclAccMnpltTp;
	}
	/**
	 * 设置：经办人
	 */
	public void setRspbPsn(String rspbPsn) {
		this.rspbPsn = rspbPsn;
	}
	/**
	 * 获取：经办人
	 */
	public String getRspbPsn() {
		return rspbPsn;
	}
	/**
	 * 设置：经办机构
	 */
	public void setHdlInst(String hdlInst) {
		this.hdlInst = hdlInst;
	}
	/**
	 * 获取：经办机构
	 */
	public String getHdlInst() {
		return hdlInst;
	}
	/**
	 * 设置：利息入账账号
	 */
	public void setIntAccEntrAccNo(String intAccEntrAccNo) {
		this.intAccEntrAccNo = intAccEntrAccNo;
	}
	/**
	 * 获取：利息入账账号
	 */
	public String getIntAccEntrAccNo() {
		return intAccEntrAccNo;
	}
	/**
	 * 设置：保证金子账户名称
	 */
	public void setMrgnSubAccNm(String mrgnSubAccNm) {
		this.mrgnSubAccNm = mrgnSubAccNm;
	}
	/**
	 * 获取：保证金子账户名称
	 */
	public String getMrgnSubAccNm() {
		return mrgnSubAccNm;
	}
	/**
	 * 设置：保证金用途
	 */
	public void setMrgnUse(String mrgnUse) {
		this.mrgnUse = mrgnUse;
	}
	/**
	 * 获取：保证金用途
	 */
	public String getMrgnUse() {
		return mrgnUse;
	}
	/**
	 * 设置：存款类型
	 */
	public void setDepTp(String depTp) {
		this.depTp = depTp;
	}
	/**
	 * 获取：存款类型
	 */
	public String getDepTp() {
		return depTp;
	}
	/**
	 * 设置：定期保证金存款期限（月）
	 */
	public void setTrmMrgnDepDdln(String trmMrgnDepDdln) {
		this.trmMrgnDepDdln = trmMrgnDepDdln;
	}
	/**
	 * 获取：定期保证金存款期限（月）
	 */
	public String getTrmMrgnDepDdln() {
		return trmMrgnDepDdln;
	}
	/**
	 * 设置：转入金额
	 */
	public void setTfrInAmt(String tfrInAmt) {
		this.tfrInAmt = tfrInAmt;
	}
	/**
	 * 获取：转入金额
	 */
	public String getTfrInAmt() {
		return tfrInAmt;
	}
	/**
	 * 设置：保证金子账户开户原因
	 */
	public void setMrgnSubAccOpnAccRsn(String mrgnSubAccOpnAccRsn) {
		this.mrgnSubAccOpnAccRsn = mrgnSubAccOpnAccRsn;
	}
	/**
	 * 获取：保证金子账户开户原因
	 */
	public String getMrgnSubAccOpnAccRsn() {
		return mrgnSubAccOpnAccRsn;
	}
	/**
	 * 设置：保证金来源合法性调查结论
	 */
	public void setMrgnSrcSurvyCnclsn(String mrgnSrcSurvyCnclsn) {
		this.mrgnSrcSurvyCnclsn = mrgnSrcSurvyCnclsn;
	}
	/**
	 * 获取：保证金来源合法性调查结论
	 */
	public String getMrgnSrcSurvyCnclsn() {
		return mrgnSrcSurvyCnclsn;
	}
	/**
	 * 设置：计息利率依据
	 */
	public void setIntArIntRtAcrdTo(String intArIntRtAcrdTo) {
		this.intArIntRtAcrdTo = intArIntRtAcrdTo;
	}
	/**
	 * 获取：计息利率依据
	 */
	public String getIntArIntRtAcrdTo() {
		return intArIntRtAcrdTo;
	}
	/**
	 * 设置：利率种类
	 */
	public void setIntRtCtlg(String intRtCtlg) {
		this.intRtCtlg = intRtCtlg;
	}
	/**
	 * 获取：利率种类
	 */
	public String getIntRtCtlg() {
		return intRtCtlg;
	}
	/**
	 * 设置：利率浮动类型
	 */
	public void setIntRtFltTp(String intRtFltTp) {
		this.intRtFltTp = intRtFltTp;
	}
	/**
	 * 获取：利率浮动类型
	 */
	public String getIntRtFltTp() {
		return intRtFltTp;
	}
	/**
	 * 设置：浮动比率
	 */
	public void setFltRto(String fltRto) {
		this.fltRto = fltRto;
	}
	/**
	 * 获取：浮动比率
	 */
	public String getFltRto() {
		return fltRto;
	}
	/**
	 * 设置：浮动点数
	 */
	public void setFltPnt(String fltPnt) {
		this.fltPnt = fltPnt;
	}
	/**
	 * 获取：浮动点数
	 */
	public String getFltPnt() {
		return fltPnt;
	}
	/**
	 * 设置：利率档次
	 */
	public void setIntRtLvl(String intRtLvl) {
		this.intRtLvl = intRtLvl;
	}
	/**
	 * 获取：利率档次
	 */
	public String getIntRtLvl() {
		return intRtLvl;
	}
	/**
	 * 设置：指定利率
	 */
	public void setApntIntRt(String apntIntRt) {
		this.apntIntRt = apntIntRt;
	}
	/**
	 * 获取：指定利率
	 */
	public String getApntIntRt() {
		return apntIntRt;
	}
	/**
	 * 设置：利率调整方式
	 */
	public void setIntAdjMod(String intAdjMod) {
		this.intAdjMod = intAdjMod;
	}
	/**
	 * 获取：利率调整方式
	 */
	public String getIntAdjMod() {
		return intAdjMod;
	}
	/**
	 * 设置：调整周期类型
	 */
	public void setAdjDyTp(String adjDyTp) {
		this.adjDyTp = adjDyTp;
	}
	/**
	 * 获取：调整周期类型
	 */
	public String getAdjDyTp() {
		return adjDyTp;
	}
	/**
	 * 设置：调整起始日类型
	 */
	public void setAdjBgDyTp(String adjBgDyTp) {
		this.adjBgDyTp = adjBgDyTp;
	}
	/**
	 * 获取：调整起始日类型
	 */
	public String getAdjBgDyTp() {
		return adjBgDyTp;
	}
	/**
	 * 设置：调整指定日期
	 */
	public void setAdjApntDt(String adjApntDt) {
		this.adjApntDt = adjApntDt;
	}
	/**
	 * 获取：调整指定日期
	 */
	public String getAdjApntDt() {
		return adjApntDt;
	}
}
