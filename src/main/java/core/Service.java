package core;

import entity.ProfitRoute;
import entity.RegionOrderEntity;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Service {
  public static void main(String[] args) {
    new Service().runService();
  }

  public void runService() {
    //Domain
    int region = 10000043;
    ESIHandler handler = new ESIHandler();
    ProfitCalculatorService profitCalculatorService = new ProfitCalculatorService(5);
    List<RegionOrderEntity> sellOrders = handler.getRegionOrders(region, "sell");
    OrderUtil.filterPrivateStructures(sellOrders);
    Map<Integer, Queue<RegionOrderEntity>> sellOrdersMap = OrderUtil.transformOrderListToMapOfHeaps(sellOrders, false);
    sellOrders.clear();
    List<RegionOrderEntity> buyOrders = handler.getRegionOrders(region, "buy");
    OrderUtil.filterPrivateStructures(buyOrders);
    Map<Integer, Queue<RegionOrderEntity>> buyOrdersMap = OrderUtil.transformOrderListToMapOfHeaps(buyOrders, true);
    buyOrders.clear();

    List<ProfitRoute> result = profitCalculatorService.calculateProfitRoute(sellOrdersMap, buyOrdersMap);
    result.sort(Comparator.comparingDouble(ProfitRoute::getProfit_total).reversed());
    for (ProfitRoute profit : result) {
      System.out.println(profit);
    }
    System.out.println(result.size());
  }
}
