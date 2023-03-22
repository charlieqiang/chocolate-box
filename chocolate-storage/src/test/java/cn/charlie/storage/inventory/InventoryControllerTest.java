package cn.charlie.storage.inventory;

import cn.charlie.storage.SpringServiceTest;
import cn.charlie.storage.inventory.builder.InventoryParamBuilder;
import cn.charlie.storage.inventory.entity.Inventory;
import cn.charlie.storage.inventory.entity.InventoryParam;
import cn.charlie.storage.inventory.mapper.InventoryMapper;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

/**
 * @author charlie
 * @date 3/22/2023 3:49 PM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InventoryControllerTest extends SpringServiceTest {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Test
    @Order(1)
    public void operateInventoryByItemId() throws Exception {
        final Map<String, String> header = Maps.newHashMap();
        InventoryParam inventoryParam = InventoryParamBuilder.buildInventoryParam();
        Long itemId = inventoryParam.getItemId();
        Inventory inventoryBefore = inventoryMapper.queryInventoryByItemId(itemId);

        ResultActions resultActions = returnPutResultActions("/inventory", inventoryParam, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());

        Inventory inventoryAfter = inventoryMapper.queryInventoryByItemId(itemId);

        int inventoryBeforeQty = inventoryBefore.getInventoryQty();
        int inventoryAfterQty = inventoryAfter.getInventoryQty();
        int expectQty = inventoryBeforeQty + inventoryParam.getOperateQty();
        Assertions.assertEquals(expectQty, inventoryAfterQty);
    }
}
