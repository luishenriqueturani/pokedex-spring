package br.com.pokedexspring.pokedex.providers.SnowflakeId;

public class SnowflakeParams {

  private long workerId;
  private long timestamp;
  private long sequence;
  private long dataCenterId;

  public SnowflakeParams(long workerId, long timestamp, long sequence, long dataCenterId) {
    this.workerId = workerId;
    this.timestamp = timestamp;
    this.sequence = sequence;
    this.dataCenterId = dataCenterId;
  }

  public long getWorkerId() {
    return workerId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public long getSequence() {
    return sequence;
  }

  public long getDataCenterId() {
    return dataCenterId;
  }

  @Override
  public String toString() {
    return "SnowflakeParams{" +
        "workerId=" + workerId +
        ", timestamp=" + timestamp +
        ", sequence=" + sequence +
        ", dataCenterId=" + dataCenterId +
        '}';
  }
}
