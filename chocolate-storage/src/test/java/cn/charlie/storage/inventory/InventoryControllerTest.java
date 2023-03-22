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
    public void operateInventoryByItemIdAndTestInventory() throws Exception {
        InventoryParam inventoryParam = InventoryParamBuilder.buildInventoryParam();
        Long itemId = inventoryParam.getItemId();
        Integer operateQty = inventoryParam.getOperateQty();
        Inventory inventoryBefore = inventoryMapper.queryInventoryByItemId(itemId);
        final Map<String, String> header = Maps.newHashMap();
        ResultActions resultActions = returnPutResultActions("/inventory", inventoryParam, header);

        String exp = "$.data";
        Boolean expectedValue = true;
        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(exp).value(expectedValue));

        Inventory inventoryAfter = inventoryMapper.queryInventoryByItemId(itemId);
        testInventory(inventoryBefore, inventoryAfter, operateQty);
    }

    private void testInventory(Inventory inventoryBefore, Inventory inventoryAfter, Integer operatedQty) {
        int inventoryBeforeQty = inventoryBefore.getInventoryQty();
        int inventoryAfterQty = inventoryAfter.getInventoryQty();
        int expectQty = inventoryBeforeQty + operatedQty;
        Assertions.assertEquals(expectQty, inventoryAfterQty);
    }
}
