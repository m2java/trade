package core;

import entity.RegionOrderEntity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class ESIHandler {
  public static final String ESI_EVETECH_NET = "https://esi.evetech.net/";
  private Client client;
  private WebTarget webTarget;

  public ESIHandler() {
    this.client = ClientBuilder.newClient();
    this.webTarget
    = client.target(ESI_EVETECH_NET);
  }

  public List<RegionOrderEntity> getRegionOrders(int regionId, String isBuyOrder, int page) {
    StringBuilder pathBuilder = new StringBuilder();
    pathBuilder.append("latest/markets/");
    pathBuilder.append(regionId);
    pathBuilder.append("/orders/");
    WebTarget employeeWebTarget = (webTarget.path(pathBuilder.toString())).
    queryParam("datasource", "tranquility").
    queryParam("order_type", isBuyOrder).
    queryParam("page", page);
    Invocation.Builder invocationBuilder
    = employeeWebTarget.request(MediaType.APPLICATION_JSON);
    List<RegionOrderEntity> response = invocationBuilder.get(new GenericType<List<RegionOrderEntity>>() {
    });
    return response;
  }

  public List<RegionOrderEntity> getRegionOrders(int regionId, String isBuyOrder) {
    List<RegionOrderEntity> responsePerPage;
    List<RegionOrderEntity> response = new ArrayList<>();
    int pageCounter = 1;
    while (true) {
      responsePerPage = getRegionOrders(regionId, isBuyOrder, pageCounter);
      if (responsePerPage == null || responsePerPage.isEmpty()) {
        break;
      } else {
        ++pageCounter;
        response.addAll(responsePerPage);
      }
    }

    return response;
  }
}
