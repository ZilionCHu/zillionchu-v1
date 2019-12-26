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
 * 融资信息接口
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-24 16:08:00
 */
@Data
@ToString
public class Financinginfodto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	//受托支付列表
	private List<Rzentrstdpylistdto> list;

    public List<Rzentrstdpylistdto> getList() {
        return list;
    }

    public void setList(List<Rzentrstdpylistdto> list) {
        this.list = list;
    }

    //客户编号
    @ApiModelProperty(value = "客户编号", name = "CST_I_D")
    @Max(value = 40, message = "客户编号超长")
    private String cstID;
	
	    //客户名称
    @ApiModelProperty(value = "客户名称", name = "CST_NM")
    @Max(value = 200, message = "客户名称超长")
    private String cstNm;
	
	    //业务性质
    @ApiModelProperty(value = "业务性质", name = "BSN_CHAR")
    @Max(value = 20, message = "业务性质超长")
    private String bsnChar;
	
	    //授信品种
    @ApiModelProperty(value = "授信品种", name = "CR_G_VRTY")
    @Max(value = 40, message = "授信品种超长")
    private String crGVrty;
	
	    //融资申请编号
    @ApiModelProperty(value = "融资申请编号", name = "FNC_APLY_I_D")
    @Max(value = 40, message = "融资申请编号超长")
    private String fncAplyID;
	
	    //业务协议编号
    @ApiModelProperty(value = "业务协议编号", name = "BSN_AGRM_I_D")
    @Max(value = 32, message = "业务协议编号超长")
    private String bsnAgrmID;
	
	    //业务方案编号
    @ApiModelProperty(value = "业务方案编号", name = "BSN_SCM_I_D")
    @Max(value = 32, message = "业务方案编号超长")
    private String bsnScmID;
	
	    //业务方案状态
    @ApiModelProperty(value = "业务方案状态", name = "BSN_SCM_ST")
    @Max(value = 32, message = "业务方案状态超长")
    private String bsnScmSt;
	
	    //是否关联合作方
    @ApiModelProperty(value = "是否关联合作方", name = "WTHR_RLTV_PRTN")
    @Max(value = 1, message = "是否关联合作方超长")
    private String wthrRltvPrtn;
	
	    //是否农业综合开发贷款
    @ApiModelProperty(value = "是否农业综合开发贷款", name = "WTHRLY_CPRSV_DVLP_LOAN")
    @Max(value = 1, message = "是否农业综合开发贷款超长")
    private String wthrlyCprsvDvlpLoan;
	
	    //是否支农贷款
    @ApiModelProperty(value = "是否支农贷款", name = "WTHRZL_LOAN")
    @Max(value = 1, message = "是否支农贷款超长")
    private String wthrzlLoan;
	
	    //支农贷款大类
    @ApiModelProperty(value = "支农贷款大类", name = "SUPPER_FARM_LOAN_LRG_CLSS")
    @Max(value = 20, message = "支农贷款大类超长")
    private String supperFarmLoanLrgClss;
	
	    //农田基本建设类型
    @ApiModelProperty(value = "农田基本建设类型", name = "FARM_BSC_CSTC_TP")
    @Max(value = 150, message = "农田基本建设类型超长")
    private String farmBscCstcTp;
	
	    //农产品加工类型
    @ApiModelProperty(value = "农产品加工类型", name = "FARM_P_D_PCS_TP")
    @Max(value = 150, message = "农产品加工类型超长")
    private String farmPDPcsTp;
	
	    //农业生产资料制造类型
    @ApiModelProperty(value = "农业生产资料制造类型", name = "FARM_PD_MTRL_TP")
    @Max(value = 150, message = "农业生产资料制造类型超长")
    private String farmPdMtrlTp;
	
	    //农用物资和农副产品流通类型
    @ApiModelProperty(value = "农用物资和农副产品流通类型", name = "FARM_RESOUCE_AND_VICE_P_D_CRCL_TP")
    @Max(value = 150, message = "农用物资和农副产品流通类型超长")
    private String farmResouceAndVicePDCrclTp;
	
	    //农业科技类型
    @ApiModelProperty(value = "农业科技类型", name = "FARM_S_T_TP")
    @Max(value = 150, message = "农业科技类型超长")
    private String farmSTTp;
	
	    //农村基础设施建设类型
    @ApiModelProperty(value = "农村基础设施建设类型", name = "CNTSD_BASE_EQMT_CSTC_TP")
    @Max(value = 150, message = "农村基础设施建设类型超长")
    private String cntsdBaseEqmtCstcTp;
	
	    //是否产业结构调整类型
    @ApiModelProperty(value = "是否产业结构调整类型", name = "WTHR_IDY_STC_ADJ_TP")
    @Max(value = 20, message = "是否产业结构调整类型超长")
    private String wthrIdyStcAdjTp;
	
	    //产业结构调整类型
    @ApiModelProperty(value = "产业结构调整类型", name = "IDY_STC_ADJ_TP")
    @Max(value = 20, message = "产业结构调整类型超长")
    private String idyStcAdjTp;
	
	    //是否贸易融资额度预占用
    @ApiModelProperty(value = "是否贸易融资额度预占用", name = "WTHR_TRD_FNC_LMT_OCP")
    @Max(value = 2, message = "是否贸易融资额度预占用超长")
    private String wthrTrdFncLmtOcp;
	
	    //贸易融资额度预占用编号
    @ApiModelProperty(value = "贸易融资额度预占用编号", name = "TRD_FNC_LMT_OCP_I_D")
    @Max(value = 40, message = "贸易融资额度预占用编号超长")
    private String trdFncLmtOcpID;
	
	    //是否战略新兴产业类型
    @ApiModelProperty(value = "是否战略新兴产业类型", name = "WTHR_STRTG_NEW_IDY_TP")
    @Max(value = 20, message = "是否战略新兴产业类型超长")
    private String wthrStrtgNewIdyTp;
	
	    //战略新兴产业类型
    @ApiModelProperty(value = "战略新兴产业类型", name = "STRTG_NEW_IDY_TP")
    @Max(value = 20, message = "战略新兴产业类型超长")
    private String strtgNewIdyTp;
	
	    //工业转型升级标识
    @ApiModelProperty(value = "工业转型升级标识", name = "INDUSTRY_TRNST_I_D")
    @Max(value = 20, message = "工业转型升级标识超长")
    private String industryTrnstID;
	
	    //环境社会风险分类结果
    @ApiModelProperty(value = "环境社会风险分类结果", name = "ENV_SOC_RSK_C_L_RSLT")
    @Max(value = 20, message = "环境社会风险分类结果超长")
    private String envSocRskCLRslt;
	
	    //绿色信贷标识分类结果
    @ApiModelProperty(value = "绿色信贷标识分类结果", name = "GRN_CR_I_D_C_L_RSLT")
    @Max(value = 100, message = "绿色信贷标识分类结果超长")
    private String grnCrIDCLRslt;
	
	    //涉及环境、安全重大风险分类结果
    @ApiModelProperty(value = "涉及环境、安全重大风险分类结果", name = "IVL_ENV_SAFE_MJR_RSK_C_L_RSLT")
    @Max(value = 50, message = "涉及环境、安全重大风险分类结果超长")
    private String ivlEnvSafeMjrRskCLRslt;
	
	    //担保方式
    @ApiModelProperty(value = "担保方式", name = "WRNT_MOD")
    @Max(value = 30, message = "担保方式超长")
    private String wrntMod;
	
	    //营销机构代码
    @ApiModelProperty(value = "营销机构代码", name = "CMPN_INST_CD")
    @Max(value = 40, message = "营销机构代码超长")
    private String cmpnInstCd;
	
	    //营销机构名称
    @ApiModelProperty(value = "营销机构名称", name = "CMPN_INST_NM")
    @Max(value = 200, message = "营销机构名称超长")
    private String cmpnInstNm;
	
	    //贷款投向
    @ApiModelProperty(value = "贷款投向", name = "LOAN_IVS_IN")
    @Max(value = 512, message = "贷款投向超长")
    private String loanIvsIn;
	
	    //贷款用途
    @ApiModelProperty(value = "贷款用途", name = "LOAN_USE")
    @Max(value = 200, message = "贷款用途超长")
    private String loanUse;
	
	    //详细用途
    @ApiModelProperty(value = "详细用途", name = "DTL_USE")
    @Max(value = 100, message = "详细用途超长")
    private String dtlUse;
	
	    //还款来源
    @ApiModelProperty(value = "还款来源", name = "REPY_SRC")
    @Max(value = 100, message = "还款来源超长")
    private String repySrc;
	
	    //环境社会风险分类理由
    @ApiModelProperty(value = "环境社会风险分类理由", name = "ENV_SOC_RSK_C_L_RSN")
    @Max(value = 50, message = "环境社会风险分类理由超长")
    private String envSocRskCLRsn;
	
	    //备注
    @ApiModelProperty(value = "备注", name = "RMRK")
    @Max(value = 100, message = "备注超长")
    private String rmrk;
	
	    //是否是二级支行营销客户
    @ApiModelProperty(value = "是否是二级支行营销客户", name = "WTHR_LVL2_SUB_B_CMPN_CST")
    @Max(value = 2, message = "是否是二级支行营销客户超长")
    private String wthrLvl2SubBCmpnCst;
	
	    //营销机构
    @ApiModelProperty(value = "营销机构", name = "CMPN_INST")
    @Max(value = 40, message = "营销机构超长")
    private String cmpnInst;
	
	    //二级支行机构名称
    @ApiModelProperty(value = "二级支行机构名称", name = "LVL2_SUB_B_INST_NM")
    @Max(value = 200, message = "二级支行机构名称超长")
    private String lvl2SubBInstNm;
	
	    //是否存量客户营销推荐客户
    @ApiModelProperty(value = "是否存量客户营销推荐客户", name = "WTHR_STK_CST_CMPN_RCM_CST")
    @Max(value = 2, message = "是否存量客户营销推荐客户超长")
    private String wthrStkCstCmpnRcmCst;
	
	    //存量客户编号
    @ApiModelProperty(value = "存量客户编号", name = "STK_CST_I_D")
    @Max(value = 40, message = "存量客户编号超长")
    private String stkCstID;
	
	    //存量客户名称
    @ApiModelProperty(value = "存量客户名称", name = "STK_CST_NM")
    @Max(value = 200, message = "存量客户名称超长")
    private String stkCstNm;
	
	    //是否有扶贫带动作用
    @ApiModelProperty(value = "是否有扶贫带动作用", name = "WTHFARMFUNCTION")
    @Max(value = 10, message = "是否有扶贫带动作用超长")
    private String wthfarmfunction;
	
	    //金额
    @ApiModelProperty(value = "金额", name = "AMT")
    @Max(value = 20, message = "金额超长")
    private String amt;
	
	    //币种
    @ApiModelProperty(value = "币种", name = "CCY")
    @Max(value = 20, message = "币种超长")
    private String ccy;
	
	    //期限
    @ApiModelProperty(value = "期限", name = "DDLN")
    @Max(value = 8, message = "期限超长")
    private String ddln;
	
	    //还款方式
    @ApiModelProperty(value = "还款方式", name = "RP_MD")
    @Max(value = 20, message = "还款方式超长")
    private String rpMd;
	
	    //还本周期
    @ApiModelProperty(value = "还本周期", name = "REPY_PNP_CYC")
    @Max(value = 2, message = "还本周期超长")
    private String repyPnpCyc;
	
	    //还息周期
    @ApiModelProperty(value = "还息周期", name = "REPY_INT_CYC")
    @Max(value = 2, message = "还息周期超长")
    private String repyIntCyc;
	
	    //只还利息期数
    @ApiModelProperty(value = "只还利息期数", name = "ONLY_INT_PRD_NUM")
    @Max(value = 8, message = "只还利息期数超长")
    private String onlyIntPrdNum;
	
	    //结息日是否靠季末月
    @ApiModelProperty(value = "结息日是否靠季末月", name = "INT_SETL_DAY_WTHR_SSN_MO")
    @Max(value = 1, message = "结息日是否靠季末月超长")
    private String intSetlDayWthrSsnMo;
	
	    //放款方式
    @ApiModelProperty(value = "放款方式", name = "DSBR_MOD")
    @Max(value = 20, message = "放款方式超长")
    private String dsbrMod;
	
	    //是否有提款期
    @ApiModelProperty(value = "是否有提款期", name = "WTHR_DW_M_PRD")
    @Max(value = 1, message = "是否有提款期超长")
    private String wthrDwMPrd;
	
	    //提款期
    @ApiModelProperty(value = "提款期", name = "DW_M_PRD")
    @Max(value = 8, message = "提款期超长")
    private String dwMPrd;
	
	    //是否有宽限期
    @ApiModelProperty(value = "是否有宽限期", name = "WTHR_GRC_PRD")
    @Max(value = 1, message = "是否有宽限期超长")
    private String wthrGrcPrd;
	
	    //宽限期
    @ApiModelProperty(value = "宽限期", name = "GRC_PRD")
    @Max(value = 8, message = "宽限期超长")
    private String grcPrd;
	
	    //是否收取费用
    @ApiModelProperty(value = "是否收取费用", name = "WTHR_COLL_EPS")
    @Max(value = 20, message = "是否收取费用超长")
    private String wthrCollEps;
	
	    //费用收取时点
    @ApiModelProperty(value = "费用收取时点", name = "EPS_COLL_TM_PNT")
    @Max(value = 10, message = "费用收取时点超长")
    private String epsCollTmPnt;
	
	    //费用名称
    @ApiModelProperty(value = "费用名称", name = "COST_NM")
    @Max(value = 100, message = "费用名称超长")
    private String costNm;
	
	    //费用币种
    @ApiModelProperty(value = "费用币种", name = "EPS_CCY")
    @Max(value = 20, message = "费用币种超长")
    private String epsCcy;
	
	    //费用形式
    @ApiModelProperty(value = "费用形式", name = "EPS_FORM")
    @Max(value = 80, message = "费用形式超长")
    private String epsForm;
	
	    //收费方向
    @ApiModelProperty(value = "收费方向", name = "FPRT")
    @Max(value = 20, message = "收费方向超长")
    private String fprt;
	
	    //费用缴付方式
    @ApiModelProperty(value = "费用缴付方式", name = "EPS_PYMT")
    @Max(value = 20, message = "费用缴付方式超长")
    private String epsPymt;
	
	    //年费率(%)
    @ApiModelProperty(value = "年费率(%)", name = "YR_FEE_RT")
    @Max(value = 16, message = "年费率(%)超长")
    private String yrFeeRt;
	
	    //费用缴付周期
    @ApiModelProperty(value = "费用缴付周期", name = "EPS_CYC")
    @Max(value = 100, message = "费用缴付周期超长")
    private String epsCyc;
	
	    //日费率计算方式
    @ApiModelProperty(value = "日费率计算方式", name = "DAY_FEE_RT_CL_MTD")
    @Max(value = 80, message = "日费率计算方式超长")
    private String dayFeeRtClMtd;
	
	    //费率备注
    @ApiModelProperty(value = "费率备注", name = "FEE_RT_RMRK")
    @Max(value = 4000, message = "费率备注超长")
    private String feeRtRmrk;
	
	    //是否关联核心企业
    @ApiModelProperty(value = "是否关联核心企业", name = "WTHR_RLTV_CORE_ENTP")
    @Max(value = 2, message = "是否关联核心企业超长")
    private String wthrRltvCoreEntp;
	
	    //核心企业编号
    @ApiModelProperty(value = "核心企业编号", name = "CORE_ENTP_I_D")
    @Max(value = 40, message = "核心企业编号超长")
    private String coreEntpID;
	
	    //核心企业名称
    @ApiModelProperty(value = "核心企业名称", name = "CORE_ENT_NM")
    @Max(value = 200, message = "核心企业名称超长")
    private String coreEntNm;
	
	    //责任承担类型
    @ApiModelProperty(value = "责任承担类型", name = "RSPL_CHRG_TO_TP")
    @Max(value = 40, message = "责任承担类型超长")
    private String rsplChrgToTp;
	
	    //与核心企业关系
    @ApiModelProperty(value = "与核心企业关系", name = "WITH_CORE_ENTP_REL")
    @Max(value = 2, message = "与核心企业关系超长")
    private String withCoreEntpRel;
	
	    //是否关联监管企业
    @ApiModelProperty(value = "是否关联监管企业", name = "WTHR_RLTV_REG_ENTP")
    @Max(value = 2, message = "是否关联监管企业超长")
    private String wthrRltvRegEntp;
	
	    //监管企业编号
    @ApiModelProperty(value = "监管企业编号", name = "REG_ENTP_I_D")
    @Max(value = 40, message = "监管企业编号超长")
    private String regEntpID;
	
	    //监管企业名称
    @ApiModelProperty(value = "监管企业名称", name = "REG_ENT_NM")
    @Max(value = 200, message = "监管企业名称超长")
    private String regEntNm;
	
	    //监管企业承担责任
    @ApiModelProperty(value = "监管企业承担责任", name = "REG_ENTP_CHRG_TO_RSPL")
    @Max(value = 4, message = "监管企业承担责任超长")
    private String regEntpChrgToRspl;
	
	    //是否占用第三方授信额度
    @ApiModelProperty(value = "是否占用第三方授信额度", name = "WTHR_OCP_TRD_PT_CR_G_LN")
    @Max(value = 1, message = "是否占用第三方授信额度超长")
    private String wthrOcpTrdPtCrGLn;
	
	    //利率依据方式
    @ApiModelProperty(value = "利率依据方式", name = "IN_RT_AC_T_MD")
    @Max(value = 20, message = "利率依据方式超长")
    private String inRtAcTMd;
	
	    //利率档次
    @ApiModelProperty(value = "利率档次", name = "INT_RT_LVL")
    @Max(value = 20, message = "利率档次超长")
    private String intRtLvl;
	
	    //利率浮动类型
    @ApiModelProperty(value = "利率浮动类型", name = "INT_RT_FLT_TP")
    @Max(value = 20, message = "利率浮动类型超长")
    private String intRtFltTp;
	
	    //浮动比率
    @ApiModelProperty(value = "浮动比率", name = "FLT_RTO")
    @Max(value = 16, message = "浮动比率超长")
    private String fltRto;
	
	    //加减点数
    @ApiModelProperty(value = "加减点数", name = "PLUS_OR_SUB_PNT")
    @Max(value = 16, message = "加减点数超长")
    private String plusOrSubPnt;
	
	    //利率调整方式
    @ApiModelProperty(value = "利率调整方式", name = "INT_ADJ_MOD")
    @Max(value = 2, message = "利率调整方式超长")
    private String intAdjMod;
	
	    //纸质合同编号
    @ApiModelProperty(value = "纸质合同编号", name = "P_CR_CTR_I_D")
    @Max(value = 40, message = "纸质合同编号超长")
    private String pCrCtrID;
	
	    //合同份数
    @ApiModelProperty(value = "合同份数", name = "CTR_CPS")
    @Max(value = 8, message = "合同份数超长")
    private String ctrCps;
	
	    //签约地点
    @ApiModelProperty(value = "签约地点", name = "SIGN_PLC")
    @Max(value = 512, message = "签约地点超长")
    private String signPlc;
	
	    //补充条款
    @ApiModelProperty(value = "补充条款", name = "SPLMT_PRV")
    @Max(value = 2000, message = "补充条款超长")
    private String splmtPrv;
	
	    //合同文本类型
    @ApiModelProperty(value = "合同文本类型", name = "CTR_TX_TP")
    @Max(value = 20, message = "合同文本类型超长")
    private String ctrTxTp;
	
	    //放款账户名
    @ApiModelProperty(value = "放款账户名", name = "DSBR_ACC_NM")
    @Max(value = 200, message = "放款账户名超长")
    private String dsbrAccNm;
	
	    //放款账户号
    @ApiModelProperty(value = "放款账户号", name = "DSBR_ACC_NO")
    @Max(value = 40, message = "放款账户号超长")
    private String dsbrAccNo;
	
	    //还款账户名
    @ApiModelProperty(value = "还款账户名", name = "REPY_ACC_NM")
    @Max(value = 200, message = "还款账户名超长")
    private String repyAccNm;
	
	    //还款账户号
    @ApiModelProperty(value = "还款账户号", name = "REPY_ACC_NO")
    @Max(value = 40, message = "还款账户号超长")
    private String repyAccNo;
	
	    //是否固定付息日
    @ApiModelProperty(value = "是否固定付息日", name = "WTHR_FIX_INT_PYMT_DAY")
    @Max(value = 1, message = "是否固定付息日超长")
    private String wthrFixIntPymtDay;
	
	    //固定付息日
    @ApiModelProperty(value = "固定付息日", name = "FIX_INT_PYMT_DAY")
    @Max(value = 2, message = "固定付息日超长")
    private String fixIntPymtDay;
	
	    //最低提前还本限额(元)
    @ApiModelProperty(value = "最低提前还本限额(元)", name = "LWST_IN_ADV_REPY_PNP_QOT")
    @Max(value = 20, message = "最低提前还本限额(元)超长")
    private String lwstInAdvRepyPnpQot;
	
	    //提前还款是否收取违约金
    @ApiModelProperty(value = "提前还款是否收取违约金", name = "PRE_RPY_WTHR_COLL_DFLT_PNY")
    @Max(value = 1, message = "提前还款是否收取违约金超长")
    private String preRpyWthrCollDfltPny;
	
	    //提前还款违约金率
    @ApiModelProperty(value = "提前还款违约金率", name = "PRE_RPY_DFLT_PNY_RATE")
    @Max(value = 16, message = "提前还款违约金率超长")
    private String preRpyDfltPnyRate;
	
	    //还款资金提前到账天数
    @ApiModelProperty(value = "还款资金提前到账天数", name = "REPY_CPTL_IN_ADV_TO_ACC_DYS")
    @Max(value = 8, message = "还款资金提前到账天数超长")
    private String repyCptlInAdvToAccDys;
	
	    //逾期罚息利率上浮比率
    @ApiModelProperty(value = "逾期罚息利率上浮比率", name = "ODUE_PNY_INT_INT_RT_FLOT_UP_RTO")
    @Max(value = 16, message = "逾期罚息利率上浮比率超长")
    private String oduePnyIntIntRtFlotUpRto;
	
	    //挪用罚息利率上浮比率
    @ApiModelProperty(value = "挪用罚息利率上浮比率", name = "DVRT_PNY_INT_INT_RT_FLOT_UP_RTO")
    @Max(value = 16, message = "挪用罚息利率上浮比率超长")
    private String dvrtPnyIntIntRtFlotUpRto;
	
	    //日利率计算方式
    @ApiModelProperty(value = "日利率计算方式", name = "DAY_INT_RT_CL_MTD")
    @Max(value = 80, message = "日利率计算方式超长")
    private String dayIntRtClMtd;
	
	    //放款利率是否执行最新基准利率
    @ApiModelProperty(value = "放款利率是否执行最新基准利率", name = "DSBR_INT_RT_WTHR_EXEC_LTST_BS_I_RT")
    @Max(value = 1, message = "放款利率是否执行最新基准利率超长")
    private String dsbrIntRtWthrExecLtstBsIRt;
	
	    //首次放款执行基准利率
    @ApiModelProperty(value = "首次放款执行基准利率", name = "F_TM_DSBR_EXEC_BS_I_RT")
    @Max(value = 16, message = "首次放款执行基准利率超长")
    private String fTmDsbrExecBsIRt;
	
	    //是否需要受托支付
    @ApiModelProperty(value = "是否需要受托支付", name = "WTHR_REQ_ENTRSTD_PY")
    @Max(value = 1, message = "是否需要受托支付超长")
    private String wthrReqEntrstdPy;
	
	    //影像索引
    @ApiModelProperty(value = "影像索引", name = "IMG_INDX")
    @Max(value = 2000, message = "影像索引超长")
    private String imgIndx;
	
	    //经办机构
    @ApiModelProperty(value = "经办机构", name = "HANDING_ORG")
    @Max(value = 30, message = "经办机构超长")
    private String handingOrg;
	
	    //经办人
    @ApiModelProperty(value = "经办人", name = "HANGDING_PERSON")
    @Max(value = 30, message = "经办人超长")
    private String hangdingPerson;
	
	    //经办日期
    @ApiModelProperty(value = "经办日期", name = "HANDING_DATE")
    @Max(value = 40, message = "经办日期超长")
    private String handingDate;

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
	 * 设置：客户名称
	 */
	public void setCstNm(String cstNm) {
		this.cstNm = cstNm;
	}
	/**
	 * 获取：客户名称
	 */
	public String getCstNm() {
		return cstNm;
	}
	/**
	 * 设置：业务性质
	 */
	public void setBsnChar(String bsnChar) {
		this.bsnChar = bsnChar;
	}
	/**
	 * 获取：业务性质
	 */
	public String getBsnChar() {
		return bsnChar;
	}
	/**
	 * 设置：授信品种
	 */
	public void setCrGVrty(String crGVrty) {
		this.crGVrty = crGVrty;
	}
	/**
	 * 获取：授信品种
	 */
	public String getCrGVrty() {
		return crGVrty;
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
	 * 设置：业务协议编号
	 */
	public void setBsnAgrmID(String bsnAgrmID) {
		this.bsnAgrmID = bsnAgrmID;
	}
	/**
	 * 获取：业务协议编号
	 */
	public String getBsnAgrmID() {
		return bsnAgrmID;
	}
	/**
	 * 设置：业务方案编号
	 */
	public void setBsnScmID(String bsnScmID) {
		this.bsnScmID = bsnScmID;
	}
	/**
	 * 获取：业务方案编号
	 */
	public String getBsnScmID() {
		return bsnScmID;
	}
	/**
	 * 设置：业务方案状态
	 */
	public void setBsnScmSt(String bsnScmSt) {
		this.bsnScmSt = bsnScmSt;
	}
	/**
	 * 获取：业务方案状态
	 */
	public String getBsnScmSt() {
		return bsnScmSt;
	}
	/**
	 * 设置：是否关联合作方
	 */
	public void setWthrRltvPrtn(String wthrRltvPrtn) {
		this.wthrRltvPrtn = wthrRltvPrtn;
	}
	/**
	 * 获取：是否关联合作方
	 */
	public String getWthrRltvPrtn() {
		return wthrRltvPrtn;
	}
	/**
	 * 设置：是否农业综合开发贷款
	 */
	public void setWthrlyCprsvDvlpLoan(String wthrlyCprsvDvlpLoan) {
		this.wthrlyCprsvDvlpLoan = wthrlyCprsvDvlpLoan;
	}
	/**
	 * 获取：是否农业综合开发贷款
	 */
	public String getWthrlyCprsvDvlpLoan() {
		return wthrlyCprsvDvlpLoan;
	}
	/**
	 * 设置：是否支农贷款
	 */
	public void setWthrzlLoan(String wthrzlLoan) {
		this.wthrzlLoan = wthrzlLoan;
	}
	/**
	 * 获取：是否支农贷款
	 */
	public String getWthrzlLoan() {
		return wthrzlLoan;
	}
	/**
	 * 设置：支农贷款大类
	 */
	public void setSupperFarmLoanLrgClss(String supperFarmLoanLrgClss) {
		this.supperFarmLoanLrgClss = supperFarmLoanLrgClss;
	}
	/**
	 * 获取：支农贷款大类
	 */
	public String getSupperFarmLoanLrgClss() {
		return supperFarmLoanLrgClss;
	}
	/**
	 * 设置：农田基本建设类型
	 */
	public void setFarmBscCstcTp(String farmBscCstcTp) {
		this.farmBscCstcTp = farmBscCstcTp;
	}
	/**
	 * 获取：农田基本建设类型
	 */
	public String getFarmBscCstcTp() {
		return farmBscCstcTp;
	}
	/**
	 * 设置：农产品加工类型
	 */
	public void setFarmPDPcsTp(String farmPDPcsTp) {
		this.farmPDPcsTp = farmPDPcsTp;
	}
	/**
	 * 获取：农产品加工类型
	 */
	public String getFarmPDPcsTp() {
		return farmPDPcsTp;
	}
	/**
	 * 设置：农业生产资料制造类型
	 */
	public void setFarmPdMtrlTp(String farmPdMtrlTp) {
		this.farmPdMtrlTp = farmPdMtrlTp;
	}
	/**
	 * 获取：农业生产资料制造类型
	 */
	public String getFarmPdMtrlTp() {
		return farmPdMtrlTp;
	}
	/**
	 * 设置：农用物资和农副产品流通类型
	 */
	public void setFarmResouceAndVicePDCrclTp(String farmResouceAndVicePDCrclTp) {
		this.farmResouceAndVicePDCrclTp = farmResouceAndVicePDCrclTp;
	}
	/**
	 * 获取：农用物资和农副产品流通类型
	 */
	public String getFarmResouceAndVicePDCrclTp() {
		return farmResouceAndVicePDCrclTp;
	}
	/**
	 * 设置：农业科技类型
	 */
	public void setFarmSTTp(String farmSTTp) {
		this.farmSTTp = farmSTTp;
	}
	/**
	 * 获取：农业科技类型
	 */
	public String getFarmSTTp() {
		return farmSTTp;
	}
	/**
	 * 设置：农村基础设施建设类型
	 */
	public void setCntsdBaseEqmtCstcTp(String cntsdBaseEqmtCstcTp) {
		this.cntsdBaseEqmtCstcTp = cntsdBaseEqmtCstcTp;
	}
	/**
	 * 获取：农村基础设施建设类型
	 */
	public String getCntsdBaseEqmtCstcTp() {
		return cntsdBaseEqmtCstcTp;
	}
	/**
	 * 设置：是否产业结构调整类型
	 */
	public void setWthrIdyStcAdjTp(String wthrIdyStcAdjTp) {
		this.wthrIdyStcAdjTp = wthrIdyStcAdjTp;
	}
	/**
	 * 获取：是否产业结构调整类型
	 */
	public String getWthrIdyStcAdjTp() {
		return wthrIdyStcAdjTp;
	}
	/**
	 * 设置：产业结构调整类型
	 */
	public void setIdyStcAdjTp(String idyStcAdjTp) {
		this.idyStcAdjTp = idyStcAdjTp;
	}
	/**
	 * 获取：产业结构调整类型
	 */
	public String getIdyStcAdjTp() {
		return idyStcAdjTp;
	}
	/**
	 * 设置：是否贸易融资额度预占用
	 */
	public void setWthrTrdFncLmtOcp(String wthrTrdFncLmtOcp) {
		this.wthrTrdFncLmtOcp = wthrTrdFncLmtOcp;
	}
	/**
	 * 获取：是否贸易融资额度预占用
	 */
	public String getWthrTrdFncLmtOcp() {
		return wthrTrdFncLmtOcp;
	}
	/**
	 * 设置：贸易融资额度预占用编号
	 */
	public void setTrdFncLmtOcpID(String trdFncLmtOcpID) {
		this.trdFncLmtOcpID = trdFncLmtOcpID;
	}
	/**
	 * 获取：贸易融资额度预占用编号
	 */
	public String getTrdFncLmtOcpID() {
		return trdFncLmtOcpID;
	}
	/**
	 * 设置：是否战略新兴产业类型
	 */
	public void setWthrStrtgNewIdyTp(String wthrStrtgNewIdyTp) {
		this.wthrStrtgNewIdyTp = wthrStrtgNewIdyTp;
	}
	/**
	 * 获取：是否战略新兴产业类型
	 */
	public String getWthrStrtgNewIdyTp() {
		return wthrStrtgNewIdyTp;
	}
	/**
	 * 设置：战略新兴产业类型
	 */
	public void setStrtgNewIdyTp(String strtgNewIdyTp) {
		this.strtgNewIdyTp = strtgNewIdyTp;
	}
	/**
	 * 获取：战略新兴产业类型
	 */
	public String getStrtgNewIdyTp() {
		return strtgNewIdyTp;
	}
	/**
	 * 设置：工业转型升级标识
	 */
	public void setIndustryTrnstID(String industryTrnstID) {
		this.industryTrnstID = industryTrnstID;
	}
	/**
	 * 获取：工业转型升级标识
	 */
	public String getIndustryTrnstID() {
		return industryTrnstID;
	}
	/**
	 * 设置：环境社会风险分类结果
	 */
	public void setEnvSocRskCLRslt(String envSocRskCLRslt) {
		this.envSocRskCLRslt = envSocRskCLRslt;
	}
	/**
	 * 获取：环境社会风险分类结果
	 */
	public String getEnvSocRskCLRslt() {
		return envSocRskCLRslt;
	}
	/**
	 * 设置：绿色信贷标识分类结果
	 */
	public void setGrnCrIDCLRslt(String grnCrIDCLRslt) {
		this.grnCrIDCLRslt = grnCrIDCLRslt;
	}
	/**
	 * 获取：绿色信贷标识分类结果
	 */
	public String getGrnCrIDCLRslt() {
		return grnCrIDCLRslt;
	}
	/**
	 * 设置：涉及环境、安全重大风险分类结果
	 */
	public void setIvlEnvSafeMjrRskCLRslt(String ivlEnvSafeMjrRskCLRslt) {
		this.ivlEnvSafeMjrRskCLRslt = ivlEnvSafeMjrRskCLRslt;
	}
	/**
	 * 获取：涉及环境、安全重大风险分类结果
	 */
	public String getIvlEnvSafeMjrRskCLRslt() {
		return ivlEnvSafeMjrRskCLRslt;
	}
	/**
	 * 设置：担保方式
	 */
	public void setWrntMod(String wrntMod) {
		this.wrntMod = wrntMod;
	}
	/**
	 * 获取：担保方式
	 */
	public String getWrntMod() {
		return wrntMod;
	}
	/**
	 * 设置：营销机构代码
	 */
	public void setCmpnInstCd(String cmpnInstCd) {
		this.cmpnInstCd = cmpnInstCd;
	}
	/**
	 * 获取：营销机构代码
	 */
	public String getCmpnInstCd() {
		return cmpnInstCd;
	}
	/**
	 * 设置：营销机构名称
	 */
	public void setCmpnInstNm(String cmpnInstNm) {
		this.cmpnInstNm = cmpnInstNm;
	}
	/**
	 * 获取：营销机构名称
	 */
	public String getCmpnInstNm() {
		return cmpnInstNm;
	}
	/**
	 * 设置：贷款投向
	 */
	public void setLoanIvsIn(String loanIvsIn) {
		this.loanIvsIn = loanIvsIn;
	}
	/**
	 * 获取：贷款投向
	 */
	public String getLoanIvsIn() {
		return loanIvsIn;
	}
	/**
	 * 设置：贷款用途
	 */
	public void setLoanUse(String loanUse) {
		this.loanUse = loanUse;
	}
	/**
	 * 获取：贷款用途
	 */
	public String getLoanUse() {
		return loanUse;
	}
	/**
	 * 设置：详细用途
	 */
	public void setDtlUse(String dtlUse) {
		this.dtlUse = dtlUse;
	}
	/**
	 * 获取：详细用途
	 */
	public String getDtlUse() {
		return dtlUse;
	}
	/**
	 * 设置：还款来源
	 */
	public void setRepySrc(String repySrc) {
		this.repySrc = repySrc;
	}
	/**
	 * 获取：还款来源
	 */
	public String getRepySrc() {
		return repySrc;
	}
	/**
	 * 设置：环境社会风险分类理由
	 */
	public void setEnvSocRskCLRsn(String envSocRskCLRsn) {
		this.envSocRskCLRsn = envSocRskCLRsn;
	}
	/**
	 * 获取：环境社会风险分类理由
	 */
	public String getEnvSocRskCLRsn() {
		return envSocRskCLRsn;
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
	 * 设置：是否是二级支行营销客户
	 */
	public void setWthrLvl2SubBCmpnCst(String wthrLvl2SubBCmpnCst) {
		this.wthrLvl2SubBCmpnCst = wthrLvl2SubBCmpnCst;
	}
	/**
	 * 获取：是否是二级支行营销客户
	 */
	public String getWthrLvl2SubBCmpnCst() {
		return wthrLvl2SubBCmpnCst;
	}
	/**
	 * 设置：营销机构
	 */
	public void setCmpnInst(String cmpnInst) {
		this.cmpnInst = cmpnInst;
	}
	/**
	 * 获取：营销机构
	 */
	public String getCmpnInst() {
		return cmpnInst;
	}
	/**
	 * 设置：二级支行机构名称
	 */
	public void setLvl2SubBInstNm(String lvl2SubBInstNm) {
		this.lvl2SubBInstNm = lvl2SubBInstNm;
	}
	/**
	 * 获取：二级支行机构名称
	 */
	public String getLvl2SubBInstNm() {
		return lvl2SubBInstNm;
	}
	/**
	 * 设置：是否存量客户营销推荐客户
	 */
	public void setWthrStkCstCmpnRcmCst(String wthrStkCstCmpnRcmCst) {
		this.wthrStkCstCmpnRcmCst = wthrStkCstCmpnRcmCst;
	}
	/**
	 * 获取：是否存量客户营销推荐客户
	 */
	public String getWthrStkCstCmpnRcmCst() {
		return wthrStkCstCmpnRcmCst;
	}
	/**
	 * 设置：存量客户编号
	 */
	public void setStkCstID(String stkCstID) {
		this.stkCstID = stkCstID;
	}
	/**
	 * 获取：存量客户编号
	 */
	public String getStkCstID() {
		return stkCstID;
	}
	/**
	 * 设置：存量客户名称
	 */
	public void setStkCstNm(String stkCstNm) {
		this.stkCstNm = stkCstNm;
	}
	/**
	 * 获取：存量客户名称
	 */
	public String getStkCstNm() {
		return stkCstNm;
	}
	/**
	 * 设置：是否有扶贫带动作用
	 */
	public void setWthfarmfunction(String wthfarmfunction) {
		this.wthfarmfunction = wthfarmfunction;
	}
	/**
	 * 获取：是否有扶贫带动作用
	 */
	public String getWthfarmfunction() {
		return wthfarmfunction;
	}
	/**
	 * 设置：金额
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}
	/**
	 * 获取：金额
	 */
	public String getAmt() {
		return amt;
	}
	/**
	 * 设置：币种
	 */
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	/**
	 * 获取：币种
	 */
	public String getCcy() {
		return ccy;
	}
	/**
	 * 设置：期限
	 */
	public void setDdln(String ddln) {
		this.ddln = ddln;
	}
	/**
	 * 获取：期限
	 */
	public String getDdln() {
		return ddln;
	}
	/**
	 * 设置：还款方式
	 */
	public void setRpMd(String rpMd) {
		this.rpMd = rpMd;
	}
	/**
	 * 获取：还款方式
	 */
	public String getRpMd() {
		return rpMd;
	}
	/**
	 * 设置：还本周期
	 */
	public void setRepyPnpCyc(String repyPnpCyc) {
		this.repyPnpCyc = repyPnpCyc;
	}
	/**
	 * 获取：还本周期
	 */
	public String getRepyPnpCyc() {
		return repyPnpCyc;
	}
	/**
	 * 设置：还息周期
	 */
	public void setRepyIntCyc(String repyIntCyc) {
		this.repyIntCyc = repyIntCyc;
	}
	/**
	 * 获取：还息周期
	 */
	public String getRepyIntCyc() {
		return repyIntCyc;
	}
	/**
	 * 设置：只还利息期数
	 */
	public void setOnlyIntPrdNum(String onlyIntPrdNum) {
		this.onlyIntPrdNum = onlyIntPrdNum;
	}
	/**
	 * 获取：只还利息期数
	 */
	public String getOnlyIntPrdNum() {
		return onlyIntPrdNum;
	}
	/**
	 * 设置：结息日是否靠季末月
	 */
	public void setIntSetlDayWthrSsnMo(String intSetlDayWthrSsnMo) {
		this.intSetlDayWthrSsnMo = intSetlDayWthrSsnMo;
	}
	/**
	 * 获取：结息日是否靠季末月
	 */
	public String getIntSetlDayWthrSsnMo() {
		return intSetlDayWthrSsnMo;
	}
	/**
	 * 设置：放款方式
	 */
	public void setDsbrMod(String dsbrMod) {
		this.dsbrMod = dsbrMod;
	}
	/**
	 * 获取：放款方式
	 */
	public String getDsbrMod() {
		return dsbrMod;
	}
	/**
	 * 设置：是否有提款期
	 */
	public void setWthrDwMPrd(String wthrDwMPrd) {
		this.wthrDwMPrd = wthrDwMPrd;
	}
	/**
	 * 获取：是否有提款期
	 */
	public String getWthrDwMPrd() {
		return wthrDwMPrd;
	}
	/**
	 * 设置：提款期
	 */
	public void setDwMPrd(String dwMPrd) {
		this.dwMPrd = dwMPrd;
	}
	/**
	 * 获取：提款期
	 */
	public String getDwMPrd() {
		return dwMPrd;
	}
	/**
	 * 设置：是否有宽限期
	 */
	public void setWthrGrcPrd(String wthrGrcPrd) {
		this.wthrGrcPrd = wthrGrcPrd;
	}
	/**
	 * 获取：是否有宽限期
	 */
	public String getWthrGrcPrd() {
		return wthrGrcPrd;
	}
	/**
	 * 设置：宽限期
	 */
	public void setGrcPrd(String grcPrd) {
		this.grcPrd = grcPrd;
	}
	/**
	 * 获取：宽限期
	 */
	public String getGrcPrd() {
		return grcPrd;
	}
	/**
	 * 设置：是否收取费用
	 */
	public void setWthrCollEps(String wthrCollEps) {
		this.wthrCollEps = wthrCollEps;
	}
	/**
	 * 获取：是否收取费用
	 */
	public String getWthrCollEps() {
		return wthrCollEps;
	}
	/**
	 * 设置：费用收取时点
	 */
	public void setEpsCollTmPnt(String epsCollTmPnt) {
		this.epsCollTmPnt = epsCollTmPnt;
	}
	/**
	 * 获取：费用收取时点
	 */
	public String getEpsCollTmPnt() {
		return epsCollTmPnt;
	}
	/**
	 * 设置：费用名称
	 */
	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}
	/**
	 * 获取：费用名称
	 */
	public String getCostNm() {
		return costNm;
	}
	/**
	 * 设置：费用币种
	 */
	public void setEpsCcy(String epsCcy) {
		this.epsCcy = epsCcy;
	}
	/**
	 * 获取：费用币种
	 */
	public String getEpsCcy() {
		return epsCcy;
	}
	/**
	 * 设置：费用形式
	 */
	public void setEpsForm(String epsForm) {
		this.epsForm = epsForm;
	}
	/**
	 * 获取：费用形式
	 */
	public String getEpsForm() {
		return epsForm;
	}
	/**
	 * 设置：收费方向
	 */
	public void setFprt(String fprt) {
		this.fprt = fprt;
	}
	/**
	 * 获取：收费方向
	 */
	public String getFprt() {
		return fprt;
	}
	/**
	 * 设置：费用缴付方式
	 */
	public void setEpsPymt(String epsPymt) {
		this.epsPymt = epsPymt;
	}
	/**
	 * 获取：费用缴付方式
	 */
	public String getEpsPymt() {
		return epsPymt;
	}
	/**
	 * 设置：年费率(%)
	 */
	public void setYrFeeRt(String yrFeeRt) {
		this.yrFeeRt = yrFeeRt;
	}
	/**
	 * 获取：年费率(%)
	 */
	public String getYrFeeRt() {
		return yrFeeRt;
	}
	/**
	 * 设置：费用缴付周期
	 */
	public void setEpsCyc(String epsCyc) {
		this.epsCyc = epsCyc;
	}
	/**
	 * 获取：费用缴付周期
	 */
	public String getEpsCyc() {
		return epsCyc;
	}
	/**
	 * 设置：日费率计算方式
	 */
	public void setDayFeeRtClMtd(String dayFeeRtClMtd) {
		this.dayFeeRtClMtd = dayFeeRtClMtd;
	}
	/**
	 * 获取：日费率计算方式
	 */
	public String getDayFeeRtClMtd() {
		return dayFeeRtClMtd;
	}
	/**
	 * 设置：费率备注
	 */
	public void setFeeRtRmrk(String feeRtRmrk) {
		this.feeRtRmrk = feeRtRmrk;
	}
	/**
	 * 获取：费率备注
	 */
	public String getFeeRtRmrk() {
		return feeRtRmrk;
	}
	/**
	 * 设置：是否关联核心企业
	 */
	public void setWthrRltvCoreEntp(String wthrRltvCoreEntp) {
		this.wthrRltvCoreEntp = wthrRltvCoreEntp;
	}
	/**
	 * 获取：是否关联核心企业
	 */
	public String getWthrRltvCoreEntp() {
		return wthrRltvCoreEntp;
	}
	/**
	 * 设置：核心企业编号
	 */
	public void setCoreEntpID(String coreEntpID) {
		this.coreEntpID = coreEntpID;
	}
	/**
	 * 获取：核心企业编号
	 */
	public String getCoreEntpID() {
		return coreEntpID;
	}
	/**
	 * 设置：核心企业名称
	 */
	public void setCoreEntNm(String coreEntNm) {
		this.coreEntNm = coreEntNm;
	}
	/**
	 * 获取：核心企业名称
	 */
	public String getCoreEntNm() {
		return coreEntNm;
	}
	/**
	 * 设置：责任承担类型
	 */
	public void setRsplChrgToTp(String rsplChrgToTp) {
		this.rsplChrgToTp = rsplChrgToTp;
	}
	/**
	 * 获取：责任承担类型
	 */
	public String getRsplChrgToTp() {
		return rsplChrgToTp;
	}
	/**
	 * 设置：与核心企业关系
	 */
	public void setWithCoreEntpRel(String withCoreEntpRel) {
		this.withCoreEntpRel = withCoreEntpRel;
	}
	/**
	 * 获取：与核心企业关系
	 */
	public String getWithCoreEntpRel() {
		return withCoreEntpRel;
	}
	/**
	 * 设置：是否关联监管企业
	 */
	public void setWthrRltvRegEntp(String wthrRltvRegEntp) {
		this.wthrRltvRegEntp = wthrRltvRegEntp;
	}
	/**
	 * 获取：是否关联监管企业
	 */
	public String getWthrRltvRegEntp() {
		return wthrRltvRegEntp;
	}
	/**
	 * 设置：监管企业编号
	 */
	public void setRegEntpID(String regEntpID) {
		this.regEntpID = regEntpID;
	}
	/**
	 * 获取：监管企业编号
	 */
	public String getRegEntpID() {
		return regEntpID;
	}
	/**
	 * 设置：监管企业名称
	 */
	public void setRegEntNm(String regEntNm) {
		this.regEntNm = regEntNm;
	}
	/**
	 * 获取：监管企业名称
	 */
	public String getRegEntNm() {
		return regEntNm;
	}
	/**
	 * 设置：监管企业承担责任
	 */
	public void setRegEntpChrgToRspl(String regEntpChrgToRspl) {
		this.regEntpChrgToRspl = regEntpChrgToRspl;
	}
	/**
	 * 获取：监管企业承担责任
	 */
	public String getRegEntpChrgToRspl() {
		return regEntpChrgToRspl;
	}
	/**
	 * 设置：是否占用第三方授信额度
	 */
	public void setWthrOcpTrdPtCrGLn(String wthrOcpTrdPtCrGLn) {
		this.wthrOcpTrdPtCrGLn = wthrOcpTrdPtCrGLn;
	}
	/**
	 * 获取：是否占用第三方授信额度
	 */
	public String getWthrOcpTrdPtCrGLn() {
		return wthrOcpTrdPtCrGLn;
	}
	/**
	 * 设置：利率依据方式
	 */
	public void setInRtAcTMd(String inRtAcTMd) {
		this.inRtAcTMd = inRtAcTMd;
	}
	/**
	 * 获取：利率依据方式
	 */
	public String getInRtAcTMd() {
		return inRtAcTMd;
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
	 * 设置：加减点数
	 */
	public void setPlusOrSubPnt(String plusOrSubPnt) {
		this.plusOrSubPnt = plusOrSubPnt;
	}
	/**
	 * 获取：加减点数
	 */
	public String getPlusOrSubPnt() {
		return plusOrSubPnt;
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
	 * 设置：纸质合同编号
	 */
	public void setPCrCtrID(String pCrCtrID) {
		this.pCrCtrID = pCrCtrID;
	}
	/**
	 * 获取：纸质合同编号
	 */
	public String getPCrCtrID() {
		return pCrCtrID;
	}
	/**
	 * 设置：合同份数
	 */
	public void setCtrCps(String ctrCps) {
		this.ctrCps = ctrCps;
	}
	/**
	 * 获取：合同份数
	 */
	public String getCtrCps() {
		return ctrCps;
	}
	/**
	 * 设置：签约地点
	 */
	public void setSignPlc(String signPlc) {
		this.signPlc = signPlc;
	}
	/**
	 * 获取：签约地点
	 */
	public String getSignPlc() {
		return signPlc;
	}
	/**
	 * 设置：补充条款
	 */
	public void setSplmtPrv(String splmtPrv) {
		this.splmtPrv = splmtPrv;
	}
	/**
	 * 获取：补充条款
	 */
	public String getSplmtPrv() {
		return splmtPrv;
	}
	/**
	 * 设置：合同文本类型
	 */
	public void setCtrTxTp(String ctrTxTp) {
		this.ctrTxTp = ctrTxTp;
	}
	/**
	 * 获取：合同文本类型
	 */
	public String getCtrTxTp() {
		return ctrTxTp;
	}
	/**
	 * 设置：放款账户名
	 */
	public void setDsbrAccNm(String dsbrAccNm) {
		this.dsbrAccNm = dsbrAccNm;
	}
	/**
	 * 获取：放款账户名
	 */
	public String getDsbrAccNm() {
		return dsbrAccNm;
	}
	/**
	 * 设置：放款账户号
	 */
	public void setDsbrAccNo(String dsbrAccNo) {
		this.dsbrAccNo = dsbrAccNo;
	}
	/**
	 * 获取：放款账户号
	 */
	public String getDsbrAccNo() {
		return dsbrAccNo;
	}
	/**
	 * 设置：还款账户名
	 */
	public void setRepyAccNm(String repyAccNm) {
		this.repyAccNm = repyAccNm;
	}
	/**
	 * 获取：还款账户名
	 */
	public String getRepyAccNm() {
		return repyAccNm;
	}
	/**
	 * 设置：还款账户号
	 */
	public void setRepyAccNo(String repyAccNo) {
		this.repyAccNo = repyAccNo;
	}
	/**
	 * 获取：还款账户号
	 */
	public String getRepyAccNo() {
		return repyAccNo;
	}
	/**
	 * 设置：是否固定付息日
	 */
	public void setWthrFixIntPymtDay(String wthrFixIntPymtDay) {
		this.wthrFixIntPymtDay = wthrFixIntPymtDay;
	}
	/**
	 * 获取：是否固定付息日
	 */
	public String getWthrFixIntPymtDay() {
		return wthrFixIntPymtDay;
	}
	/**
	 * 设置：固定付息日
	 */
	public void setFixIntPymtDay(String fixIntPymtDay) {
		this.fixIntPymtDay = fixIntPymtDay;
	}
	/**
	 * 获取：固定付息日
	 */
	public String getFixIntPymtDay() {
		return fixIntPymtDay;
	}
	/**
	 * 设置：最低提前还本限额(元)
	 */
	public void setLwstInAdvRepyPnpQot(String lwstInAdvRepyPnpQot) {
		this.lwstInAdvRepyPnpQot = lwstInAdvRepyPnpQot;
	}
	/**
	 * 获取：最低提前还本限额(元)
	 */
	public String getLwstInAdvRepyPnpQot() {
		return lwstInAdvRepyPnpQot;
	}
	/**
	 * 设置：提前还款是否收取违约金
	 */
	public void setPreRpyWthrCollDfltPny(String preRpyWthrCollDfltPny) {
		this.preRpyWthrCollDfltPny = preRpyWthrCollDfltPny;
	}
	/**
	 * 获取：提前还款是否收取违约金
	 */
	public String getPreRpyWthrCollDfltPny() {
		return preRpyWthrCollDfltPny;
	}
	/**
	 * 设置：提前还款违约金率
	 */
	public void setPreRpyDfltPnyRate(String preRpyDfltPnyRate) {
		this.preRpyDfltPnyRate = preRpyDfltPnyRate;
	}
	/**
	 * 获取：提前还款违约金率
	 */
	public String getPreRpyDfltPnyRate() {
		return preRpyDfltPnyRate;
	}
	/**
	 * 设置：还款资金提前到账天数
	 */
	public void setRepyCptlInAdvToAccDys(String repyCptlInAdvToAccDys) {
		this.repyCptlInAdvToAccDys = repyCptlInAdvToAccDys;
	}
	/**
	 * 获取：还款资金提前到账天数
	 */
	public String getRepyCptlInAdvToAccDys() {
		return repyCptlInAdvToAccDys;
	}
	/**
	 * 设置：逾期罚息利率上浮比率
	 */
	public void setOduePnyIntIntRtFlotUpRto(String oduePnyIntIntRtFlotUpRto) {
		this.oduePnyIntIntRtFlotUpRto = oduePnyIntIntRtFlotUpRto;
	}
	/**
	 * 获取：逾期罚息利率上浮比率
	 */
	public String getOduePnyIntIntRtFlotUpRto() {
		return oduePnyIntIntRtFlotUpRto;
	}
	/**
	 * 设置：挪用罚息利率上浮比率
	 */
	public void setDvrtPnyIntIntRtFlotUpRto(String dvrtPnyIntIntRtFlotUpRto) {
		this.dvrtPnyIntIntRtFlotUpRto = dvrtPnyIntIntRtFlotUpRto;
	}
	/**
	 * 获取：挪用罚息利率上浮比率
	 */
	public String getDvrtPnyIntIntRtFlotUpRto() {
		return dvrtPnyIntIntRtFlotUpRto;
	}
	/**
	 * 设置：日利率计算方式
	 */
	public void setDayIntRtClMtd(String dayIntRtClMtd) {
		this.dayIntRtClMtd = dayIntRtClMtd;
	}
	/**
	 * 获取：日利率计算方式
	 */
	public String getDayIntRtClMtd() {
		return dayIntRtClMtd;
	}
	/**
	 * 设置：放款利率是否执行最新基准利率
	 */
	public void setDsbrIntRtWthrExecLtstBsIRt(String dsbrIntRtWthrExecLtstBsIRt) {
		this.dsbrIntRtWthrExecLtstBsIRt = dsbrIntRtWthrExecLtstBsIRt;
	}
	/**
	 * 获取：放款利率是否执行最新基准利率
	 */
	public String getDsbrIntRtWthrExecLtstBsIRt() {
		return dsbrIntRtWthrExecLtstBsIRt;
	}
	/**
	 * 设置：首次放款执行基准利率
	 */
	public void setFTmDsbrExecBsIRt(String fTmDsbrExecBsIRt) {
		this.fTmDsbrExecBsIRt = fTmDsbrExecBsIRt;
	}
	/**
	 * 获取：首次放款执行基准利率
	 */
	public String getFTmDsbrExecBsIRt() {
		return fTmDsbrExecBsIRt;
	}
	/**
	 * 设置：是否需要受托支付
	 */
	public void setWthrReqEntrstdPy(String wthrReqEntrstdPy) {
		this.wthrReqEntrstdPy = wthrReqEntrstdPy;
	}
	/**
	 * 获取：是否需要受托支付
	 */
	public String getWthrReqEntrstdPy() {
		return wthrReqEntrstdPy;
	}
	/**
	 * 设置：影像索引
	 */
	public void setImgIndx(String imgIndx) {
		this.imgIndx = imgIndx;
	}
	/**
	 * 获取：影像索引
	 */
	public String getImgIndx() {
		return imgIndx;
	}
	/**
	 * 设置：经办机构
	 */
	public void setHandingOrg(String handingOrg) {
		this.handingOrg = handingOrg;
	}
	/**
	 * 获取：经办机构
	 */
	public String getHandingOrg() {
		return handingOrg;
	}
	/**
	 * 设置：经办人
	 */
	public void setHangdingPerson(String hangdingPerson) {
		this.hangdingPerson = hangdingPerson;
	}
	/**
	 * 获取：经办人
	 */
	public String getHangdingPerson() {
		return hangdingPerson;
	}
	/**
	 * 设置：经办日期
	 */
	public void setHandingDate(String handingDate) {
		this.handingDate = handingDate;
	}
	/**
	 * 获取：经办日期
	 */
	public String getHandingDate() {
		return handingDate;
	}
}
