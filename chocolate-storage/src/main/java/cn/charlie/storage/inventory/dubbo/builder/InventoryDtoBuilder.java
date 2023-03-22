package cn.charlie.storage.inventory.dubbo.builder;

import cn.charlie.common.entity.inventory.InventoryDto;
import cn.charlie.storage.inventory.entity.Inventory;

/**
 * @author charlie
 * @date 3/22/2023 4:55 PM
 **/
public class InventoryDtoBuilder {
    public static InventoryDto buildInventoryInfoDto(Inventory inventoryInfo) {
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(inventoryInfo.getId());
        inventoryDto.setItemId(inventoryInfo.getItemId());
        inventoryDto.setInventoryQty(inventoryInfo.getInventoryQty());
        return inventoryDto;
    }
}
