package cn.charlie.common.dubbo.api.storage.invtory;

import cn.charlie.common.entity.inventory.InventoryDto;

/**
 * @author charlie
 * @date 3/6/2023 10:26 PM
 **/
public interface InventoryClient {
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
     * @return 库存结果
     */
    InventoryDto queryInventoryByItemId(Long itemId);
}
