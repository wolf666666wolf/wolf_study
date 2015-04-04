package com.study.javase.thread.muti;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Commander {
	
	public static void main(String[] args){
		String ip = "127.0.0.1";//args[0];
		String port = "1024";//args[1];
		Socket socket = null;
		PrintWriter out = null;
		
		try {
			socket = new Socket(ip, Integer.parseInt(port));
			out = new PrintWriter(socket.getOutputStream(), true);
			byte[] b = new byte[2048];
			
			String msg = new String(b, 0, System.in.read(b));
			while(!msg.startsWith("stop")){
				out.println(msg);
				msg = new String(b, 0, System.in.read(b));
			}
			out.println(msg);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{
				if(socket != null){
					socket.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
