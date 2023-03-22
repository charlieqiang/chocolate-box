package cn.charlie.order.info.reference;

import cn.charlie.common.dubbo.api.storage.invtory.InventoryClient;
import cn.charlie.common.entity.inventory.InventoryDto;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author charlie
 * @date 3/7/2023 2:28 PM
 **/
@Service
public class InventoryReference {

    @Reference
    private InventoryClient inventoryClient;

    @SentinelResource(value = "OperateInventoryByItemId", fallback = "operateInventoryByItemIdFallBack")
    public Boolean operateInventoryByItemId(Long itemId, Integer operateQty) {
        return inventoryClient.operateInventoryByItemId(itemId, operateQty);
    }

    public Boolean operateInventoryByItemIdFallBack(Long itemId, Integer operateQty, Throwable e) throws Exception {
        throw new Exception("限流");
    }

    public InventoryDto queryInventoryByItemId(Long itemId) {
        return inventoryClient.queryInventoryByItemId(itemId);
    }
}
