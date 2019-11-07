package core;

import entity.RegionOrderEntity;

import java.util.*;

public class OrderUtil {
  public static Map<Integer, Queue<RegionOrderEntity>> transformOrderListToMapOfHeaps(List<RegionOrderEntity> orderEntityList, boolean maxHeap) {
    if (orderEntityList == null) {
      return null;
    }
    Map<Integer, Queue<RegionOrderEntity>> result = new HashMap<>();
    Comparator<RegionOrderEntity> comparator = maxHeap ? Comparator.comparingDouble(RegionOrderEntity::getPrice).reversed()
    : Comparator.comparingDouble(RegionOrderEntity::getPrice);
    for (RegionOrderEntity orderEntity : orderEntityList) {
      int keyTypeId = orderEntity.getType_id();
      Queue<RegionOrderEntity> heap;
      if (!result.containsKey(keyTypeId)) {
        heap = new PriorityQueue<>(comparator);
        result.put(keyTypeId, heap);
      } else {
        heap = result.get(keyTypeId);
      }
      heap.offer(orderEntity);
    }
    return result;
  }

  public static void filterPrivateStructures(List<RegionOrderEntity> orderEntityList) {
    orderEntityList.removeIf(order -> order.getLocation_id() > 70000000);
  }
}
