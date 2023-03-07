package cn.charlie.common.dubbo.api.storage.invtory;

/**
 * @author charlie
 * @date 3/6/2023 10:26 PM
 **/
public interface InventoryClient {
    /**
     * 通过ItemId操作库存
     *
     * @param itemId itemId
     * @param operateQty operateQty
     * @return 成功/失败
     */
    Boolean operateInventoryByItemId(Long itemId, Integer operateQty);
}
