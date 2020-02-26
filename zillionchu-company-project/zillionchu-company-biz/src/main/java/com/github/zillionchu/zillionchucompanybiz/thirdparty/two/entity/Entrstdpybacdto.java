package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.List;


/**
 * 
 * 
 * @author Mr.AG
 * @email 463540703@qq.com
 * @date 2019-12-24 18:46:35
 */
@Data
@ToString
public class Entrstdpybacdto extends BaseEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "受托支付列表")
	private List<Entrstdpylistdto> list;
	
	    //借据编号
    @ApiModelProperty(value = "借据编号", name = "DEBIT_I_D")
    @Max(value = 40, message = "借据编号超长")
    private String debitID;

	public List<Entrstdpylistdto> getList() {
		return list;
	}

	public void setList(List<Entrstdpylistdto> list) {
		this.list = list;
	}

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
}
