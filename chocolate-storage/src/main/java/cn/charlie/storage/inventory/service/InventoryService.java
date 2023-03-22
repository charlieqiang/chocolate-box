package cn.charlie.storage.inventory.service;

import cn.charlie.storage.inventory.entity.Inventory;

/**
 * @author charlie
 * @date 3/6/2023 11:30 PM
 **/
public interface InventoryService {
    /**
     * 通过ItemId操作库存
     *
     * @param itemId 物品id
     * @param operateQty 操作数量
     * @return 成功/失败
     */
    Boolean operateInventoryByItemId(Long itemId, Integer operateQty);

    /**
     * 通过ItemId查询库存
     *
     * @param itemId 物品id
     * @return 库存信息
     */
    Inventory queryInventoryByItemId(Long itemId);
}
