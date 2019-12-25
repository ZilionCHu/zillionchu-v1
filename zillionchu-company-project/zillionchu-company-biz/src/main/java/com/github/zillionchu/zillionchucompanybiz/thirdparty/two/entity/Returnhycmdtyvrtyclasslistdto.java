package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * 
 * 货物抵押商品品种查询接口返回实体类
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-24 17:50:40
 */
@Data
@ToString
public class Returnhycmdtyvrtyclasslistdto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	
	    //货押商品品种名称ID
    @ApiModelProperty(value = "货押商品品种名称ID", name = "HY_CMDTY_VRTY_NM_I_D")
    @Max(value = 32, message = "货押商品品种名称ID超长")
    private String hyCmdtyVrtyNmID;
	
	    //商品品种名称
    @ApiModelProperty(value = "商品品种名称", name = "CMDTY_VRTY_NM")
    @Max(value = 100, message = "商品品种名称超长")
    private String cmdtyVrtyNm;
	
	    //生效日期
    @ApiModelProperty(value = "生效日期", name = "EF_DT")
    @Max(value = 40, message = "生效日期超长")
    private String efDt;

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
	 * 设置：商品品种名称
	 */
	public void setCmdtyVrtyNm(String cmdtyVrtyNm) {
		this.cmdtyVrtyNm = cmdtyVrtyNm;
	}
	/**
	 * 获取：商品品种名称
	 */
	public String getCmdtyVrtyNm() {
		return cmdtyVrtyNm;
	}
	/**
	 * 设置：生效日期
	 */
	public void setEfDt(String efDt) {
		this.efDt = efDt;
	}
	/**
	 * 获取：生效日期
	 */
	public String getEfDt() {
		return efDt;
	}
}
