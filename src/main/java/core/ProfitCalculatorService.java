package core;

import entity.ProfitRoute;
import entity.RegionOrderEntity;

import java.util.*;

public class ProfitCalculatorService {
  private int roi;

  public ProfitCalculatorService(int roi) {
    this.roi = roi;
  }

  public List<ProfitRoute> calculateProfitRoute(Map<Integer, Queue<RegionOrderEntity>> sellOrders, Map<Integer, Queue<RegionOrderEntity>> buyOrders) {
    Set<Integer> sellKeySet = sellOrders.keySet();
    Set<Integer> buyKeySet = buyOrders.keySet();

    // retain only common type_id
    Set<Integer> retainSet = new HashSet<>(sellKeySet);
    retainSet.retainAll(buyKeySet);
    sellOrders.keySet().removeIf(k -> !retainSet.contains(k));
    buyOrders.keySet().removeIf(k -> !retainSet.contains(k));

    //fast fail
    if (sellOrders.isEmpty() || buyOrders.isEmpty()) {
      return null;
    }
    return closeBuyOrders(sellOrders, buyOrders);
  }

  private List<ProfitRoute> closeBuyOrders(Map<Integer, Queue<RegionOrderEntity>> sellOrdersMap, Map<Integer, Queue<RegionOrderEntity>> buyOrdersMap) {
    List<ProfitRoute> result = new ArrayList<>();
    Set<Map.Entry<Integer, Queue<RegionOrderEntity>>> buyEntrySet = buyOrdersMap.entrySet();

    for (Map.Entry<Integer, Queue<RegionOrderEntity>> buyEntry : buyEntrySet) {
      int keyTypeId = buyEntry.getKey();
      Queue<RegionOrderEntity> buyOrders = buyEntry.getValue();
      Queue<RegionOrderEntity> sellOrders = sellOrdersMap.get(keyTypeId);
      RegionOrderEntity buyOrder = buyOrders.peek();
      RegionOrderEntity sellOrder = sellOrders.peek();

      //fail fast
      double buyPrice = buyOrder.getPrice();
      double sellPrice = sellOrder.getPrice();
      if (buyPrice - sellPrice <= 0) {
        continue;
      }

      int buyVolume = buyOrder.getVolume_remain();
      int sellVolume = sellOrder.getVolume_remain();
      int volume = buyVolume - sellVolume;
      if (volume < 0) {
        volume = buyVolume;
        buyOrders.poll();
        sellOrder.setVolume_remain(sellVolume - buyVolume);
      } else if (volume == 0) {
        volume = buyVolume;
        buyOrders.poll();
        sellOrders.poll();
      } else {
        volume = sellVolume;
        sellOrders.poll();
        buyOrder.setVolume_remain(buyVolume - sellVolume);
      }

      //TODO: add JDBC fill profit route
      ProfitRoute profitRoute = new ProfitRoute();
      profitRoute.setType_id(keyTypeId);
      //profitRoute.setType_name("NAME");
      profitRoute.setLocation_dest_id(buyOrder.getLocation_id());
      //profitRoute.setLocation_dest_name("NAME");
      profitRoute.setLocation_start_id(sellOrder.getLocation_id());
      //profitRoute.setLocation_start_name("NAME");
      profitRoute.setPrice_buy(buyOrder.getPrice());
      profitRoute.setPrice_sell(sellOrder.getPrice());
      profitRoute.setVolume(volume);
      profitRoute.setProfitPerItem(buyOrder.getPrice() - sellOrder.getPrice());
      profitRoute.setProfit_total((buyOrder.getPrice() - sellOrder.getPrice()) * volume);
      profitRoute.setRoi((buyOrder.getPrice() - sellOrder.getPrice()) / sellOrder.getPrice() * 100);
      result.add(profitRoute);
    }
    return result;
  }
}
