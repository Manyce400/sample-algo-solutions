package com.sample.algo.solutions.packet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author manyce400
 */
@RunWith(MockitoJUnitRunner.class)
public class BlockingPacketManagerServiceTest {


    @Spy
    private BlockingPacketManagerService blockingPacketManagerService;


    @Test
    public void testRemoveLastRecentlyUsed() throws PacketException {
        Packet packet1 = Packet.newInstanceManagement(true);
        Packet packet2 = Packet.newInstanceManagement(false);
        Packet packet3 = Packet.newInstanceManagement(false);
        Packet packet4 = Packet.newInstanceManagement(false);

        blockingPacketManagerService.addPacket(packet1, packet2, packet3, packet4);

        Packet result =  blockingPacketManagerService.removeLastRecentlyUsed();
        System.out.println("result = " + result);
    }
}
