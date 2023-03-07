package cn.charlie.order.info.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author charlie
 * @date 3/7/2023 9:47 AM
 **/
public class OrderParam implements Serializable {
    private static final long serialVersionUID = 8972840498692463839L;

    private Long customId;

    private Long itemId;

    private Integer orderQty;

    private BigDecimal orderAmount;

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
}
