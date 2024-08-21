package br.com.pokedexspring.pokedex.providers.SnowflakeId;

public class SnowflakeId {

  private final long epoch = 1609459200000L; // Custom epoch (e.g., January 1, 2021)
  private final long workerIdBits = 5L; // Number of bits allocated for worker ID
  private final long datacenterIdBits = 5L; // Number of bits allocated for datacenter ID
  private final long sequenceBits = 12L; // Number of bits allocated for sequence
  private final long maxWorkerId = (1L << workerIdBits) - 1; // Maximum value for worker ID
  private final long maxDatacenterId = (1L << datacenterIdBits) - 1; // Maximum value for datacenter ID
  private final long sequenceMask = (1L << sequenceBits) - 1; // Sequence mask
  private final long workerIdShift = sequenceBits; // Left shift for worker ID
  private final long datacenterIdShift = sequenceBits + workerIdBits; // Left shift for datacenter ID
  private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits; // Left shift for timestamp


  private long workerId; // Worker ID
  private long datacenterId; // Datacenter ID
  private long sequence = 0L; // Sequence number
  private long lastTimestamp = -1L; // Last timestamp

  public SnowflakeId(long workerId, long datacenterId) {
    if (workerId > maxWorkerId || workerId < 0) {
      throw new IllegalArgumentException(String.format("Worker ID must be between 0 and %d", maxWorkerId));
    }
    if (datacenterId > maxDatacenterId || datacenterId < 0) {
      throw new IllegalArgumentException(String.format("Datacenter ID must be between 0 and %d", maxDatacenterId));
    }
    this.workerId = workerId;
    this.datacenterId = datacenterId;
  }

  public synchronized long nextId() {
    long timestamp = currentTimeMillis();

    if (timestamp < lastTimestamp) {
      throw new RuntimeException("Clock moved backwards. Refusing to generate id.");
    }

    if (timestamp == lastTimestamp) {
      sequence = (sequence + 1) & sequenceMask;
      if (sequence == 0) {
        timestamp = waitNextMillis(lastTimestamp);
      }
    } else {
      sequence = 0L;
    }

    lastTimestamp = timestamp;

    //cada parte do ID é deslocada para a esquerda para ocupar os bits corretos dentro do ID final, garantindo que cada campo esteja na posição correta e não sobreponha os outros.
    return ((timestamp - epoch) << timestampLeftShift) |
        (datacenterId << datacenterIdShift) |
        (workerId << workerIdShift) |
        sequence;
  }

  private long waitNextMillis(long lastTimestamp) {
    long timestamp = currentTimeMillis();
    while (timestamp <= lastTimestamp) {
      timestamp = currentTimeMillis();
    }
    return timestamp;
  }

  private long currentTimeMillis() {
    return System.currentTimeMillis();
  }

  public long extractTimestamp(long id) {
    return ((id >> timestampLeftShift) + epoch);
  }

  public long extractDatacenterId(long id) {
    return (id >> datacenterIdShift) & maxDatacenterId;
  }

  public long extractWorkerId(long id) {
    return (id >> workerIdShift) & maxWorkerId;
  }

  public long extractSequence(long id) {
    return id & sequenceMask;
  }

  public SnowflakeParams extractAll(long id) {
    return new SnowflakeParams(extractTimestamp(id), extractDatacenterId(id), extractWorkerId(id), extractSequence(id));
  }

  // Additional getters for testing purposes
  public long getWorkerId() {
    return workerId;
  }

  public long getDatacenterId() {
    return datacenterId;
  }

  public long getTimestampLeftShift() {
    return timestampLeftShift;
  }

}
