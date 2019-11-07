package entity;

import core.ESIHandler;
import core.OrderUtil;
import org.junit.Test;

import java.util.*;

public class OrderUtilTest {

  @Test
  public void testTransformOrderListToMap() {
    //Domain
    int region = 10000043;
    ESIHandler handler = new ESIHandler();
    List<RegionOrderEntity> sellOrders = handler.getRegionOrders(region, "sell");
    Map<Integer, Queue<RegionOrderEntity>> sellOrdersMap = OrderUtil.transformOrderListToMapOfHeaps(sellOrders, false);
    System.out.println(sellOrders.size());
    OrderUtil.filterPrivateStructures(sellOrders);
    System.out.println(sellOrders.size());
    sellOrders.clear();
    List<RegionOrderEntity> buyOrders = handler.getRegionOrders(region, "buy");
    Map<Integer, Queue<RegionOrderEntity>> buyOrdersMap = OrderUtil.transformOrderListToMapOfHeaps(buyOrders,true);
    buyOrders.clear();


    Set<Integer> sellKeySet = sellOrdersMap.keySet();
    Set<Integer> buyKeySet = buyOrdersMap.keySet();

    Set<Integer> retainSet = new HashSet<>(sellKeySet);
    retainSet.retainAll(buyKeySet);
    sellOrdersMap.keySet().removeIf(k -> !retainSet.contains(k));
    buyOrdersMap.keySet().removeIf(k -> !retainSet.contains(k));
    System.out.println(sellOrdersMap.size());
    System.out.println(buyOrdersMap.size());
  }
}
