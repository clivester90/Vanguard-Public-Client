package com.client;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class OnDemandData extends Cacheable {

	public OnDemandData() {
		incomplete = true;
	}

	int dataType;
	byte[] buffer;
	int ID;
	boolean incomplete;
	int loopCycle;
	public int dataID;
}
