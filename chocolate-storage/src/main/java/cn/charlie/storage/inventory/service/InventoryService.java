package cn.charlie.storage.inventory.service;

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
}
