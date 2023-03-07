package cn.charlie.storage.inventory.service;

import cn.charlie.storage.inventory.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author charlie
 * @date 3/6/2023 11:31 PM
 **/
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public Boolean operateInventoryByItemId(Long itemId, Integer operateQty) {
        int affectedRows = inventoryMapper.deductInventoryByItemId(itemId, operateQty);
        return affectedRows > 0;
    }
}
