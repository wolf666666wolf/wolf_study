package com.util;

import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args){
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.fromString(UUID.randomUUID().toString()));
	}
}
