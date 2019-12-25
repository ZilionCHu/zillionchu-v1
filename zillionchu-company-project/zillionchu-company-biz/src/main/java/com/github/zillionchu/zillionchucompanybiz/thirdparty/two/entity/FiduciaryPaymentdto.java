package com.github.zillionchu.zillionchucompanybiz.thirdparty.two.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 受托支付接口请求实体类
 */
@Data
@ToString
public class FiduciaryPaymentdto extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "借据编号")
    @NotNull(message = "借据编号 不能为空!")
    @Max(value = 40, message = "受借据编号超长")
    private String debitID;

    @ApiModelProperty(value = "受托支付列表")
    private List<Entrstdpylistdto> list;

    @ApiModelProperty(value = "融资票据申请列表")
    private List<Blfncaplylistdto> blfncaplylist;

    public List<Blfncaplylistdto> getBlfncaplylist() {
        return blfncaplylist;
    }

    public void setBlfncaplylist(List<Blfncaplylistdto> blfncaplylist) {
        this.blfncaplylist = blfncaplylist;
    }

    public String getDebitID() {
        return debitID;
    }

    public void setDebitID(String debitID) {
        this.debitID = debitID;
    }

    public List<Entrstdpylistdto> getList() {
        return list;
    }

    public void setList(List<Entrstdpylistdto> list) {
        this.list = list;
    }
}
