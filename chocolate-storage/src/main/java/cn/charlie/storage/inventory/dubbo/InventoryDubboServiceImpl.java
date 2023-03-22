package cn.charlie.storage.inventory.dubbo;

import cn.charlie.common.dubbo.api.storage.invtory.InventoryClient;
import cn.charlie.common.entity.inventory.InventoryDto;
import cn.charlie.storage.inventory.dubbo.builder.InventoryDtoBuilder;
import cn.charlie.storage.inventory.entity.Inventory;
import cn.charlie.storage.inventory.service.InventoryService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

/**
 * @author charlie
 * @date 3/6/2023 10:16 PM
 **/
@Service
public class InventoryDubboServiceImpl implements InventoryClient {
    @Autowired
    private InventoryService inventoryService;

    @Override
    public Boolean operateInventoryByItemId(Long itemId, Integer operateQty) {
        return inventoryService.operateInventoryByItemId(itemId, operateQty);
    }

    @Override
    public InventoryDto queryInventoryByItemId(Long itemId) {
        Inventory inventoryInfo = inventoryService.queryInventoryByItemId(itemId);
        if (ObjectUtils.isEmpty(inventoryInfo)) {
            return null;
        }
        InventoryDto inventoryDto = InventoryDtoBuilder.buildInventoryInfoDto(inventoryInfo);
        return inventoryDto;
    }


}
