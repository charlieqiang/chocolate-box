package cn.charlie.storage.inventory.mapper;

import cn.charlie.storage.inventory.entity.Inventory;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author charlie
 * @date 3/6/2023 10:24 PM
 **/
public interface InventoryMapper extends Mapper<Inventory> {
    /**
     * 通过ItemId操作库存
     *
     * @param itemId itemId
     * @param operateQty operateQty
     * @return 成功/失败
     */
    @Update("update inventory set inventory_qty = inventory_qty + (#{operateQty}) where item_id = #{itemId}")
    int deductInventoryByItemId(Long itemId, Integer operateQty);
}
