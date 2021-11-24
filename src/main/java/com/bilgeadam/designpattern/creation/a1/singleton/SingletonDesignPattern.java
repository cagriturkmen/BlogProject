package com.bilgeadam.designpattern.creation.a1.singleton;

public class SingletonDesignPattern {
	
	// 1. adım instance Class nesnesi
	private static SingletonDesignPattern instance;
	
	// 2. adım
	private SingletonDesignPattern() {
	}
	
	// 3. adım
	public static SingletonDesignPattern getInstance() {
		if (instance == null) {
			instance = new SingletonDesignPattern();
		}
		return instance;
	}
}
