package com.sample.algo.solutions.packet;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author manyce400
 */
@Service
public class BlockingPacketManagerService implements IPacketManagerService {


    private BlockingQueue<Packet> packetBlockingQueue = new ArrayBlockingQueue<>(100);

    @Override
    public void addPacket(Packet packet) {
        Assert.notNull(packet, "packet cannot be null");
        packetBlockingQueue.add(packet);
    }

    @Override
    public void addPacket(Packet... packets) {
        for(Packet packet : packets) {
            addPacket(packet);
        }
    }

    @Override
    public Packet removeLastRecentlyUsed() throws PacketException {
        try {
            return packetBlockingQueue.take();
        } catch (InterruptedException e) {
            System.out.println("Exception occurred while retrieving packet:>  " + e);
        }

        return null;
    }
}
