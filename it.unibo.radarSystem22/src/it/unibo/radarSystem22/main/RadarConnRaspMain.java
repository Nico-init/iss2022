package it.unibo.radarSystem22.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import radarPojo.radarSupport;

public class RadarConnRaspMain {
	public static void main(String[] args) {
		System.out.println("start");
		radarSupport.setUpRadarGui();

		//Create a socket to listen at port 54321
		try (DatagramSocket ds = new DatagramSocket(54321)){
			
			byte[] buff = new byte[8];

			DatagramPacket DpReceive = null;
			while (true) {
				DpReceive = new DatagramPacket(buff, buff.length);
				ds.receive(DpReceive);
				
				String cm = new String(buff);
				radarSupport.update( cm, "60");
				//System.out.println("Dist.Sonar:" + cm);

				// Clear the buffer after every message.
				buff = new byte[8];
			}

		} catch (SocketException e1) {
			System.err.println("Errore DatagramSocket: " + e1.getMessage());
		} catch (IOException e2) {
			System.err.println("Errore receive: " + e2.getMessage());
		}
	}
}
