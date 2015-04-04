package com.study.javase.nio;

import java.nio.ByteBuffer;

public class BufferExample {

	/**create*/
	//1.从堆中分配
	ByteBuffer buffer = ByteBuffer.allocate(1024);
	//2.从既有数组中创建
	byte array[] = new byte[1024];
	ByteBuffer buffer1 = ByteBuffer.wrap(array);
	
	
}

    
