package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * 
 * 质押商品列表
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-24 15:25:19
 */
@Data
@ToString
public class Hycmdtylistsdto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	
	    //货押商品目录ID
    @ApiModelProperty(value = "货押商品目录ID", name = "HY_CMDTY_CTLG_I_D")
    @Max(value = 32, message = "货押商品目录ID超长")
    private String hyCmdtyCtlgID;
	
	    //货押商品品种名称ID
    @ApiModelProperty(value = "货押商品品种名称ID", name = "HY_CMDTY_VRTY_NM_I_D")
    @Max(value = 32, message = "货押商品品种名称ID超长")
    private String hyCmdtyVrtyNmID;
	
	    //客户编号
    @ApiModelProperty(value = "客户编号", name = "CST_I_D")
    @Max(value = 40, message = "客户编号超长")
    private String cstID;
	
	    //商品名称
    @ApiModelProperty(value = "商品名称", name = "CMDTY_NM")
    @Max(value = 200, message = "商品名称超长")
    private String cmdtyNm;
	
	    //货押目录管理类型
    @ApiModelProperty(value = "货押目录管理类型", name = "HY_CTLG_MGT_TP")
    @Max(value = 100, message = "货押目录管理类型超长")
    private String hyCtlgMgtTp;
	
	    //质押物状态
    @ApiModelProperty(value = "质押物状态", name = "PLG_ST")
    @Max(value = 30, message = "质押物状态超长")
    private String plgSt;
	
	    //商品信息内容
    @ApiModelProperty(value = "商品信息内容", name = "CMDTY_INF_CNTNT")
    @Max(value = 512, message = "商品信息内容超长")
    private String cmdtyInfCntnt;
	
	    //商品单位
    @ApiModelProperty(value = "商品单位", name = "CMDTY_UNIT")
    @Max(value = 10, message = "商品单位超长")
    private String cmdtyUnit;
	
	    //初始市场价格（元）
    @ApiModelProperty(value = "初始市场价格（元）", name = "INL_MKT_PRC")
    @Max(value = 20, message = "初始市场价格（元）超长")
    private String inlMktPrc;
	
	    //初始价格来源
    @ApiModelProperty(value = "初始价格来源", name = "INL_PRC_SRC")
    @Max(value = 50, message = "初始价格来源超长")
    private String inlPrcSrc;
	
	    //最新市场价格（元）
    @ApiModelProperty(value = "最新市场价格（元）", name = "LTST_MKT_PRC")
    @Max(value = 20, message = "最新市场价格（元）超长")
    private String ltstMktPrc;
	
	    //最新价格来源
    @ApiModelProperty(value = "最新价格来源", name = "LTST_PRC_SRC")
    @Max(value = 50, message = "最新价格来源超长")
    private String ltstPrcSrc;
	
	    //初始发票价格
    @ApiModelProperty(value = "初始发票价格", name = "INL_INV_PRC")
    @Max(value = 20, message = "初始发票价格超长")
    private String inlInvPrc;
	
	    //当前发票价格（元）
    @ApiModelProperty(value = "当前发票价格（元）", name = "CUR_INV_PRC")
    @Max(value = 20, message = "当前发票价格（元）超长")
    private String curInvPrc;
	
	    //生产厂家
    @ApiModelProperty(value = "生产厂家", name = "PD_ENTPRI")
    @Max(value = 50, message = "生产厂家超长")
    private String pdEntpri;
	
	    //是否购买保险
    @ApiModelProperty(value = "是否购买保险", name = "WTHR_PRCH_INS")
    @Max(value = 1, message = "是否购买保险超长")
    private String wthrPrchIns;
	
	    //投保的保险公司
    @ApiModelProperty(value = "投保的保险公司", name = "INS_INS_CO")
    @Max(value = 200, message = "投保的保险公司超长")
    private String insInsCo;
	
	    //保险金额（元）
    @ApiModelProperty(value = "保险金额（元）", name = "INS_AMT")
    @Max(value = 20, message = "保险金额（元）超长")
    private String insAmt;
	
	    //保险期限
    @ApiModelProperty(value = "保险期限", name = "INS_DDLN")
    @Max(value = 10, message = "保险期限超长")
    private String insDdln;
	
	    //品牌
    @ApiModelProperty(value = "品牌", name = "BRND")
    @Max(value = 40, message = "品牌超长")
    private String brnd;
	
	    //车型
    @ApiModelProperty(value = "车型", name = "CAR_MODEL")
    @Max(value = 40, message = "车型超长")
    private String carModel;
	
	    //车系
    @ApiModelProperty(value = "车系", name = "CARSERIES")
    @Max(value = 40, message = "车系超长")
    private String carseries;
	
	    //型号
    @ApiModelProperty(value = "型号", name = "MODL")
    @Max(value = 50, message = "型号超长")
    private String modl;
	
	    //国产/进口/组装
    @ApiModelProperty(value = "国产/进口/组装", name = "NAT_IMPR_GRP")
    @Max(value = 50, message = "国产/进口/组装超长")
    private String natImprGrp;
	
	    //质量认证机构
    @ApiModelProperty(value = "质量认证机构", name = "QLY_CTFN_INST")
    @Max(value = 50, message = "质量认证机构超长")
    private String qlyCtfnInst;
	
	    //合格证号
    @ApiModelProperty(value = "合格证号", name = "QLFD_NO")
    @Max(value = 512, message = "合格证号超长")
    private String qlfdNo;
	
	    //生产批号
    @ApiModelProperty(value = "生产批号", name = "PD_BTCH_NO")
    @Max(value = 40, message = "生产批号超长")
    private String pdBtchNo;
	
	    //备注
    @ApiModelProperty(value = "备注", name = "RMRK")
    @Max(value = 512, message = "备注超长")
    private String rmrk;
	
	    //本次关联数量
    @ApiModelProperty(value = "本次关联数量", name = "THS_RLTV_NUM")
    @Max(value = 20, message = "本次关联数量超长")
    private String thsRltvNum;
	
	    //单品质押率(%)
    @ApiModelProperty(value = "单品质押率(%)", name = "BL_QUL_RATE")
    @Max(value = 16, message = "单品质押率(%)超长")
    private String blQulRate;
	
	    //备注说明
    @ApiModelProperty(value = "备注说明", name = "RMRK_CMNT")
    @Max(value = 512, message = "备注说明超长")
    private String rmrkCmnt;
	

	/**
	 * 设置：货押商品目录ID
	 */
	public void setHyCmdtyCtlgID(String hyCmdtyCtlgID) {
		this.hyCmdtyCtlgID = hyCmdtyCtlgID;
	}
	/**
	 * 获取：货押商品目录ID
	 */
	public String getHyCmdtyCtlgID() {
		return hyCmdtyCtlgID;
	}
	/**
	 * 设置：货押商品品种名称ID
	 */
	public void setHyCmdtyVrtyNmID(String hyCmdtyVrtyNmID) {
		this.hyCmdtyVrtyNmID = hyCmdtyVrtyNmID;
	}
	/**
	 * 获取：货押商品品种名称ID
	 */
	public String getHyCmdtyVrtyNmID() {
		return hyCmdtyVrtyNmID;
	}
	/**
	 * 设置：客户编号
	 */
	public void setCstID(String cstID) {
		this.cstID = cstID;
	}
	/**
	 * 获取：客户编号
	 */
	public String getCstID() {
		return cstID;
	}
	/**
	 * 设置：商品名称
	 */
	public void setCmdtyNm(String cmdtyNm) {
		this.cmdtyNm = cmdtyNm;
	}
	/**
	 * 获取：商品名称
	 */
	public String getCmdtyNm() {
		return cmdtyNm;
	}
	/**
	 * 设置：货押目录管理类型
	 */
	public void setHyCtlgMgtTp(String hyCtlgMgtTp) {
		this.hyCtlgMgtTp = hyCtlgMgtTp;
	}
	/**
	 * 获取：货押目录管理类型
	 */
	public String getHyCtlgMgtTp() {
		return hyCtlgMgtTp;
	}
	/**
	 * 设置：质押物状态
	 */
	public void setPlgSt(String plgSt) {
		this.plgSt = plgSt;
	}
	/**
	 * 获取：质押物状态
	 */
	public String getPlgSt() {
		return plgSt;
	}
	/**
	 * 设置：商品信息内容
	 */
	public void setCmdtyInfCntnt(String cmdtyInfCntnt) {
		this.cmdtyInfCntnt = cmdtyInfCntnt;
	}
	/**
	 * 获取：商品信息内容
	 */
	public String getCmdtyInfCntnt() {
		return cmdtyInfCntnt;
	}
	/**
	 * 设置：商品单位
	 */
	public void setCmdtyUnit(String cmdtyUnit) {
		this.cmdtyUnit = cmdtyUnit;
	}
	/**
	 * 获取：商品单位
	 */
	public String getCmdtyUnit() {
		return cmdtyUnit;
	}
	/**
	 * 设置：初始市场价格（元）
	 */
	public void setInlMktPrc(String inlMktPrc) {
		this.inlMktPrc = inlMktPrc;
	}
	/**
	 * 获取：初始市场价格（元）
	 */
	public String getInlMktPrc() {
		return inlMktPrc;
	}
	/**
	 * 设置：初始价格来源
	 */
	public void setInlPrcSrc(String inlPrcSrc) {
		this.inlPrcSrc = inlPrcSrc;
	}
	/**
	 * 获取：初始价格来源
	 */
	public String getInlPrcSrc() {
		return inlPrcSrc;
	}
	/**
	 * 设置：最新市场价格（元）
	 */
	public void setLtstMktPrc(String ltstMktPrc) {
		this.ltstMktPrc = ltstMktPrc;
	}
	/**
	 * 获取：最新市场价格（元）
	 */
	public String getLtstMktPrc() {
		return ltstMktPrc;
	}
	/**
	 * 设置：最新价格来源
	 */
	public void setLtstPrcSrc(String ltstPrcSrc) {
		this.ltstPrcSrc = ltstPrcSrc;
	}
	/**
	 * 获取：最新价格来源
	 */
	public String getLtstPrcSrc() {
		return ltstPrcSrc;
	}
	/**
	 * 设置：初始发票价格
	 */
	public void setInlInvPrc(String inlInvPrc) {
		this.inlInvPrc = inlInvPrc;
	}
	/**
	 * 获取：初始发票价格
	 */
	public String getInlInvPrc() {
		return inlInvPrc;
	}
	/**
	 * 设置：当前发票价格（元）
	 */
	public void setCurInvPrc(String curInvPrc) {
		this.curInvPrc = curInvPrc;
	}
	/**
	 * 获取：当前发票价格（元）
	 */
	public String getCurInvPrc() {
		return curInvPrc;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setPdEntpri(String pdEntpri) {
		this.pdEntpri = pdEntpri;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getPdEntpri() {
		return pdEntpri;
	}
	/**
	 * 设置：是否购买保险
	 */
	public void setWthrPrchIns(String wthrPrchIns) {
		this.wthrPrchIns = wthrPrchIns;
	}
	/**
	 * 获取：是否购买保险
	 */
	public String getWthrPrchIns() {
		return wthrPrchIns;
	}
	/**
	 * 设置：投保的保险公司
	 */
	public void setInsInsCo(String insInsCo) {
		this.insInsCo = insInsCo;
	}
	/**
	 * 获取：投保的保险公司
	 */
	public String getInsInsCo() {
		return insInsCo;
	}
	/**
	 * 设置：保险金额（元）
	 */
	public void setInsAmt(String insAmt) {
		this.insAmt = insAmt;
	}
	/**
	 * 获取：保险金额（元）
	 */
	public String getInsAmt() {
		return insAmt;
	}
	/**
	 * 设置：保险期限
	 */
	public void setInsDdln(String insDdln) {
		this.insDdln = insDdln;
	}
	/**
	 * 获取：保险期限
	 */
	public String getInsDdln() {
		return insDdln;
	}
	/**
	 * 设置：品牌
	 */
	public void setBrnd(String brnd) {
		this.brnd = brnd;
	}
	/**
	 * 获取：品牌
	 */
	public String getBrnd() {
		return brnd;
	}
	/**
	 * 设置：车型
	 */
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	/**
	 * 获取：车型
	 */
	public String getCarModel() {
		return carModel;
	}
	/**
	 * 设置：车系
	 */
	public void setCarseries(String carseries) {
		this.carseries = carseries;
	}
	/**
	 * 获取：车系
	 */
	public String getCarseries() {
		return carseries;
	}
	/**
	 * 设置：型号
	 */
	public void setModl(String modl) {
		this.modl = modl;
	}
	/**
	 * 获取：型号
	 */
	public String getModl() {
		return modl;
	}
	/**
	 * 设置：国产/进口/组装
	 */
	public void setNatImprGrp(String natImprGrp) {
		this.natImprGrp = natImprGrp;
	}
	/**
	 * 获取：国产/进口/组装
	 */
	public String getNatImprGrp() {
		return natImprGrp;
	}
	/**
	 * 设置：质量认证机构
	 */
	public void setQlyCtfnInst(String qlyCtfnInst) {
		this.qlyCtfnInst = qlyCtfnInst;
	}
	/**
	 * 获取：质量认证机构
	 */
	public String getQlyCtfnInst() {
		return qlyCtfnInst;
	}
	/**
	 * 设置：合格证号
	 */
	public void setQlfdNo(String qlfdNo) {
		this.qlfdNo = qlfdNo;
	}
	/**
	 * 获取：合格证号
	 */
	public String getQlfdNo() {
		return qlfdNo;
	}
	/**
	 * 设置：生产批号
	 */
	public void setPdBtchNo(String pdBtchNo) {
		this.pdBtchNo = pdBtchNo;
	}
	/**
	 * 获取：生产批号
	 */
	public String getPdBtchNo() {
		return pdBtchNo;
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
	/**
	 * 设置：本次关联数量
	 */
	public void setThsRltvNum(String thsRltvNum) {
		this.thsRltvNum = thsRltvNum;
	}
	/**
	 * 获取：本次关联数量
	 */
	public String getThsRltvNum() {
		return thsRltvNum;
	}
	/**
	 * 设置：单品质押率(%)
	 */
	public void setBlQulRate(String blQulRate) {
		this.blQulRate = blQulRate;
	}
	/**
	 * 获取：单品质押率(%)
	 */
	public String getBlQulRate() {
		return blQulRate;
	}
	/**
	 * 设置：备注说明
	 */
	public void setRmrkCmnt(String rmrkCmnt) {
		this.rmrkCmnt = rmrkCmnt;
	}
	/**
	 * 获取：备注说明
	 */
	public String getRmrkCmnt() {
		return rmrkCmnt;
	}
}
