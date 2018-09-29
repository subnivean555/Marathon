package classical;

import javax.print.DocFlavor;

/**
 *  SnowFlake 算法生成 id 的记过是一个 64 bit 大小的整数 , 并且整个分布式系统内不会产生重复 ID
 *
 *  0+ 时间戳(一般为41位) + 工作机器id(10位) + 序列号(12位)
 *
 *  可以在 1 毫秒内产生 4095 个不重复的id
 *
 */

public class SnowFlakeAlgo {

    /**
     *  workerId + datacenterId 用来标识机器
     *  sequence 为序列号
     */
    private long workerId;
    private long datacenterId;
    private long sequence;

    private long twepoch = 1288834917657L;
    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;
    private long maxWorkerId = -1L^(-1L << workerIdBits);
    private long maxDatacenterId = -1L^(-1L << datacenterIdBits);
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterId;
    private long sequenceMask = -1L ^ (-1 << sequenceBits);

    private long lastTimestamp = -1L;

    public SnowFlakeAlgo(long workerId, long datacenterId, long sequence){

        if (workerId > maxWorkerId || workerId < 0){
            throw new IllegalArgumentException("workerId id is invalid");
        }
        if (datacenterId > maxDatacenterId || maxDatacenterId < 0){
            throw new IllegalArgumentException("datacenterId id is invalid");
        }

        System.out.printf("worker starting. timestamp left shif %d, datacenter id bits %d, sequence bits %d, worker id %d"
            ,timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);

        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

    public long getWorkerId() {
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getTimeStamp(){
        return System.currentTimeMillis();
    }

    public synchronized long nextId(){
        long timeStamp = timeGen();

        if (timeStamp < lastTimestamp){
            System.err.println("clock is moving back");
            throw new RuntimeException("clock is moving back");
        }

        if (lastTimestamp == timeStamp){
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0){
                timeStamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timeStamp;
        return ((timeStamp - twepoch) << timestampLeftShift)|(datacenterId<<datacenterIdShift)
                |(workerId<<workerIdShift)|sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp){
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SnowFlakeAlgo snowFlake = new SnowFlakeAlgo(1, 1, 1);
        for (int i = 0; i < 50; i++){
            System.out.println(snowFlake.nextId());
        }
    }

}
