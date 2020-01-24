package com.http.pool.conn.configPool;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.message.BasicHeaderElementIterator;

public class config1 {
	
	public static void main(String[] args) throws Exception{
		config1 c=new config1();
		
		HttpGet get = new HttpGet("http://localhost:8080/");

		ConnectionKeepAliveStrategy myStrategy = c.keepAliveStrategy();
		PoolingHttpClientConnectionManager connManager = c.createConnPoolMgr();
		CloseableHttpClient client = c.buildClient(myStrategy, connManager);
		//HttpClientBuilder client = buildClient(myStrategy, connManager);
		//HttpGet get = new HttpGet("http://www.google.com/");

		MultiHttpClientConnThread[] threads = new  MultiHttpClientConnThread[10];
		for(int i = 0; i < threads.length; i++){
		    threads[i] = new MultiHttpClientConnThread(client, get);
		}
		for (MultiHttpClientConnThread thread: threads) {
		     thread.start();
		}
		for (MultiHttpClientConnThread thread: threads) {
		     thread.join(1000);     
		}

	}
	
	public  PoolingHttpClientConnectionManager createConnPoolMgr() {
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
		connManager.setDefaultMaxPerRoute(5);
		connManager.setMaxTotal(5);
		return connManager;
	}
	public  ConnectionKeepAliveStrategy keepAliveStrategy() {
		return new ConnectionKeepAliveStrategy() {
		    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
		        HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
		        while (it.hasNext()) {
		            HeaderElement he = it.nextElement();
		            String param = he.getName();
		            String value = he.getValue();
		            //System.out.println("param: "+param+" value: "+value);
		            if (value != null && param.equalsIgnoreCase
		               ("timeout")) {
		                return Long.parseLong(value) * 1000;
		            }
		        }
		        return 5 * 1000;
		    }
		};		
	}
	public  CloseableHttpClient buildClient(ConnectionKeepAliveStrategy myStrategy, PoolingHttpClientConnectionManager connManager) {
		CloseableHttpClient client = HttpClients.custom()
				  .setKeepAliveStrategy(myStrategy)
				  .setConnectionManager(connManager)
				  .build();
		/*HttpClientBuilder client = HttpClients.custom();
				  client.setKeepAliveStrategy(myStrategy)
				  .setConnectionManager(connManager)
				  .build();*/
		return client;
	}
	// TODO :: Separate the connection manager object creation
	// TODO :: Separate the HTTP Client Creation
	// TODO :: Write a common method to make use of those two
	// TODO :: Invoke that from main
	// TODO :: 
	// TODO :: 
	// TODO :: 
}
