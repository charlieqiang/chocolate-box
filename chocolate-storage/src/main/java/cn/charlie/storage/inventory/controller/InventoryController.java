package cn.charlie.storage.inventory.controller;

import cn.charlie.common.entity.base.Result;
import cn.charlie.storage.inventory.entity.InventoryParam;
import cn.charlie.storage.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlie
 * @date 3/6/2023 11:28 PM
 **/
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    /**
     * 通过ItemId操作库存
     *
     * @param inventoryParam 库存操作参数
     * @return 成功/失败
     */
    @PutMapping("")
    public Result<Boolean> operateInventoryByItemId(@RequestBody InventoryParam inventoryParam) {
        if (ObjectUtils.isEmpty(inventoryParam)) {
            return Result.success(false);
        }
        Long itemId = inventoryParam.getItemId();
        Integer operateQty = inventoryParam.getOperateQty();
        return Result.success(inventoryService.operateInventoryByItemId(itemId, operateQty));
    }
}
