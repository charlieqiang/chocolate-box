package cn.charlie.order.info;

import cn.charlie.common.entity.inventory.InventoryDto;
import cn.charlie.order.SpringServiceTest;
import cn.charlie.order.info.builder.OrderParamBuilder;
import cn.charlie.order.info.entity.OrderParam;
import cn.charlie.order.info.reference.InventoryReference;
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
import java.util.Optional;

/**
 * @author charlie
 * @date 3/22/2023 11:16 AM
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderInfoControllerTest extends SpringServiceTest {

    @Autowired
    private InventoryReference inventoryReference;

    @Test
    @Order(1)
    public void bookingOrderAndTestInventory() throws Exception {
        final Map<String, String> header = Maps.newHashMap();
        OrderParam orderParam = OrderParamBuilder.buildOrderParam();
        InventoryDto inventoryInfoBeforeDto = Optional.ofNullable(inventoryReference.queryInventoryByItemId(7038399168028995584L))
                .orElseThrow(() -> new Exception("查无源库存, 物品id: " + 7038399168028995584L));
        ResultActions resultActions = returnPostResultActions("/info", orderParam, header);
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());

        InventoryDto inventoryInfoAfterDto = Optional.ofNullable(inventoryReference.queryInventoryByItemId(7038399168028995584L))
                .orElseThrow(() -> new Exception("查无目标库存, 物品id: " + 7038399168028995584L));

        int inventoryBeforeQty = inventoryInfoBeforeDto.getInventoryQty();
        int inventoryAfterQty = inventoryInfoAfterDto.getInventoryQty();
        int expectQty = inventoryBeforeQty - orderParam.getOrderQty();
        Assertions.assertEquals(expectQty, inventoryAfterQty);
    }
}
