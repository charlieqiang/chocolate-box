package cn.charlie.storage.inventory.entity;

import java.io.Serializable;

/**
 * @author charlie
 * @date 3/6/2023 11:45 PM
 **/
public class InventoryParam implements Serializable {
    private static final long serialVersionUID = -4845022620561185923L;

    private Long itemId;
    private Integer operateQty;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getOperateQty() {
        return operateQty;
    }

    public void setOperateQty(Integer operateQty) {
        this.operateQty = operateQty;
    }
}
