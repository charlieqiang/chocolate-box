package cn.charlie.order.info.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author charlie
 * @date 3/7/2023 9:46 AM
 **/
@Entity
@Table(name = "order_info")
public class OrderInfo {
    @Id
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单数量
     */
    private Integer orderQty;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 客户id
     */
    private Long customId;

    /**
     * 物品id
     */
    private Long itemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
}
