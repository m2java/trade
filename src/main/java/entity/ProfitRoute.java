package entity;

public class ProfitRoute {
  private int type_id;
  private String type_name;
  private long location_dest_id;
  private String location_dest_name;
  private double price_buy;
  private long location_start_id;
  private String location_start_name;
  private double price_sell;
  private long volume;
  private double profitPerItem;
  private double profit_total;
  private double roi;

  public int getType_id() {
    return type_id;
  }

  public void setType_id(int type_id) {
    this.type_id = type_id;
  }

  public String getType_name() {
    return type_name;
  }

  public void setType_name(String type_name) {
    this.type_name = type_name;
  }

  public long getLocation_dest_id() {
    return location_dest_id;
  }

  public void setLocation_dest_id(long location_dest_id) {
    this.location_dest_id = location_dest_id;
  }

  public String getLocation_dest_name() {
    return location_dest_name;
  }

  public void setLocation_dest_name(String location_dest_name) {
    this.location_dest_name = location_dest_name;
  }

  public double getPrice_buy() {
    return price_buy;
  }

  public void setPrice_buy(double price_buy) {
    this.price_buy = price_buy;
  }

  public long getVolume() {
    return volume;
  }

  public void setVolume(long volume) {
    this.volume = volume;
  }

  public long getLocation_start_id() {
    return location_start_id;
  }

  public void setLocation_start_id(long location_start_id) {
    this.location_start_id = location_start_id;
  }

  public String getLocation_start_name() {
    return location_start_name;
  }

  public void setLocation_start_name(String location_start_name) {
    this.location_start_name = location_start_name;
  }

  public double getPrice_sell() {
    return price_sell;
  }

  public void setPrice_sell(double price_sell) {
    this.price_sell = price_sell;
  }

  public double getProfitPerItem() {
    return profitPerItem;
  }

  public void setProfitPerItem(double profitPerItem) {
    this.profitPerItem = profitPerItem;
  }

  public double getProfit_total() {
    return profit_total;
  }

  public void setProfit_total(double profit_total) {
    this.profit_total = profit_total;
  }

  public double getRoi() {
    return roi;
  }

  public void setRoi(double roi) {
    this.roi = roi;
  }

  @Override
  public String toString() {
    return "ProfitRoute{" +
    "type_id=" + type_id +
    ", type_name='" + type_name + '\'' +
    ", location_dest_id=" + location_dest_id +
    ", location_dest_name='" + location_dest_name + '\'' +
    ", price_buy=" + price_buy +
    ", location_start_id=" + location_start_id +
    ", location_start_name='" + location_start_name + '\'' +
    ", price_sell=" + price_sell +
    ", volume=" + volume +
    ", profitPerItem=" + profitPerItem +
    ", profit_total=" + profit_total +
    ", roi=" + roi +
    '}';
  }
}
