package cn.charlie.common.entity.inventory;

import java.io.Serializable;

/**
 * @author charlie
 * @date 3/22/2023 4:31 PM
 **/
public class InventoryDto implements Serializable {

    private static final long serialVersionUID = 2028565829961556703L;

    private Long id;

    private Long itemId;

    private Integer inventoryQty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getInventoryQty() {
        return inventoryQty;
    }

    public void setInventoryQty(int inventoryQty) {
        this.inventoryQty = inventoryQty;
    }
}
