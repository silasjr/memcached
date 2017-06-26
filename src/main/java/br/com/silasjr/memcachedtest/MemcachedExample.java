package br.com.silasjr.memcachedtest;

import com.google.gson.Gson;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class MemcachedExample {

	public static void main(String[] args) {
		String[] servers = { "localhost:11211" };
		SockIOPool pool = SockIOPool.getInstance("Test1");
		pool.setServers(servers);
		pool.setFailover(true);
		pool.setInitConn(10);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setAliveCheck(true);
		pool.initialize();

		// Get the Memcached Client from SockIOPool named Test1
		MemCachedClient mcc = new MemCachedClient("Test1");

		Token token = new Token();
		token.setBrowser("Google Chrome");
		token.setIp("192.168.0.1");
		token.setTimeZone("manaus/amazonas");
		token.setValue("8-918234-9812948928384bbbdfsdfs");
		
		String json = new Gson().toJson(token);
		
		// add some value in cache
		System.out.println("add status:" + mcc.add("2", json));
		
		System.out.println(mcc.get("2"));
	}

}
