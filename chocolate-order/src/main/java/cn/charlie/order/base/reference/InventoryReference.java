package cn.charlie.order.base.reference;

import cn.charlie.common.dubbo.api.storage.invtory.InventoryClient;
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

    public Boolean operateInventoryByItemId(Long itemId, Integer operateQty) {
        return inventoryClient.operateInventoryByItemId(itemId, operateQty);
    }
}
