package cn.charlie.storage.inventory.builder;

import cn.charlie.storage.inventory.entity.InventoryParam;

/**
 * @author charlie
 * @date 3/22/2023 4:16 PM
 **/
public class InventoryParamBuilder {

    public static InventoryParam buildInventoryParam() {
        InventoryParam inventoryParam = new InventoryParam();
        inventoryParam.setItemId(7038399168028995584L);
        inventoryParam.setOperateQty(-1);
        return inventoryParam;
    }
}
