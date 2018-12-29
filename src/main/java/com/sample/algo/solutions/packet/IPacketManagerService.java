package com.sample.algo.solutions.packet;

/**
 * @author manyce400
 */
public interface IPacketManagerService {

    public void addPacket(Packet packet);

    public void addPacket(Packet ... packets);

    public Packet removeLastRecentlyUsed() throws PacketException;

}
