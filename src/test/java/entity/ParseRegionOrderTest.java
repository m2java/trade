package entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ParseRegionOrderTest {

  @Test
  public void test() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String arrayOfObjects = "[{\"duration\":90,\"is_buy_order\":false,\"issued\":\"2019-09-24T04:48:21Z\",\"location_id\":60008494,\"min_volume\":1,\"order_id\":5509218303,\"price\":1599998.97,\"range\":\"region\",\"system_id\":30002187,\"type_id\":1944,\"volume_remain\":79,\"volume_total\":94}]";

    List<RegionOrderEntity> list = Arrays.asList(mapper.readValue(arrayOfObjects, RegionOrderEntity[].class));
    System.out.println(list);
  }

}
