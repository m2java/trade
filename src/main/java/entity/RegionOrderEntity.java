package entity;

public class RegionOrderEntity {

  private int duration;
  private boolean is_buy_order;
  private String issued;
  private long location_id;
  private int min_volume;
  private long order_id;
  private double price;
  private String range;
  private int system_id;
  private int type_id;
  private int volume_remain;
  private int volume_total;

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public boolean isIs_buy_order() {
    return is_buy_order;
  }

  public void setIs_buy_order(boolean is_buy_order) {
    this.is_buy_order = is_buy_order;
  }

  public String getIssued() {
    return issued;
  }

  public void setIssued(String issued) {
    this.issued = issued;
  }

  public long getLocation_id() {
    return location_id;
  }

  public void setLocation_id(long location_id) {
    this.location_id = location_id;
  }

  public int getMin_volume() {
    return min_volume;
  }

  public void setMin_volume(int min_volume) {
    this.min_volume = min_volume;
  }

  public long getOrder_id() {
    return order_id;
  }

  public void setOrder_id(long order_id) {
    this.order_id = order_id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getRange() {
    return range;
  }

  public void setRange(String range) {
    this.range = range;
  }

  public int getSystem_id() {
    return system_id;
  }

  public void setSystem_id(int system_id) {
    this.system_id = system_id;
  }

  public int getType_id() {
    return type_id;
  }

  public void setType_id(int type_id) {
    this.type_id = type_id;
  }

  public int getVolume_remain() {
    return volume_remain;
  }

  public void setVolume_remain(int volume_remain) {
    this.volume_remain = volume_remain;
  }

  public int getVolume_total() {
    return volume_total;
  }

  public void setVolume_total(int volume_total) {
    this.volume_total = volume_total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof RegionOrderEntity)) return false;

    RegionOrderEntity that = (RegionOrderEntity) o;

    if (getDuration() != that.getDuration()) return false;
    if (isIs_buy_order() != that.isIs_buy_order()) return false;
    if (getLocation_id() != that.getLocation_id()) return false;
    if (getMin_volume() != that.getMin_volume()) return false;
    if (getOrder_id() != that.getOrder_id()) return false;
    if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
    if (getSystem_id() != that.getSystem_id()) return false;
    if (getType_id() != that.getType_id()) return false;
    if (getVolume_remain() != that.getVolume_remain()) return false;
    if (getVolume_total() != that.getVolume_total()) return false;
    if (getIssued() != null ? !getIssued().equals(that.getIssued()) : that.getIssued() != null) return false;
    return getRange() != null ? getRange().equals(that.getRange()) : that.getRange() == null;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = getDuration();
    result = 31 * result + (isIs_buy_order() ? 1 : 0);
    result = 31 * result + (getIssued() != null ? getIssued().hashCode() : 0);
    result = 31 * result + (int) (getLocation_id() ^ (getLocation_id() >>> 32));
    result = 31 * result + getMin_volume();
    result = 31 * result + (int) (getOrder_id() ^ (getOrder_id() >>> 32));
    temp = Double.doubleToLongBits(getPrice());
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (getRange() != null ? getRange().hashCode() : 0);
    result = 31 * result + getSystem_id();
    result = 31 * result + getType_id();
    result = 31 * result + getVolume_remain();
    result = 31 * result + getVolume_total();
    return result;
  }

  @Override
  public String toString() {
    return "RegionOrderEntity{" +
    "duration=" + duration +
    ", is_buy_order=" + is_buy_order +
    ", issued='" + issued + '\'' +
    ", location_id=" + location_id +
    ", min_volume=" + min_volume +
    ", order_id=" + order_id +
    ", price=" + price +
    ", range='" + range + '\'' +
    ", system_id=" + system_id +
    ", type_id=" + type_id +
    ", volume_remain=" + volume_remain +
    ", volume_total=" + volume_total +
    '}';
  }
}
