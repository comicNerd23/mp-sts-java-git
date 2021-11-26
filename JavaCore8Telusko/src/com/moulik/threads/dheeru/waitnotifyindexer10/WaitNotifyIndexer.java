package com.moulik.threads.dheeru.waitnotifyindexer10;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

import com.moulik.threads.dheeru.naiveindexer9.HttpConnect;

/**
 * For N web links, this approach creates 2 * N threads.
 * 
 * Benefit: Better coordination of control flow between threads. Relinquishes lock on wait()!
 * 
 * Note: htmlPage is NOT declared volatile in Weblink as unlock on a monitor 'happens before' every subsequent lock on 
 * 			that same monitor.
 *       wait() and notify() can lead to run infinitely if synchronized blocks are not used.
 * 
 * Limitation:
 *    Solves task cooperation in a low-level fashion. Josh Bloch says it is like
 *          programming in "concurrency assembly language"
 *    Synchronized blocks are needed
 *  
 * @author Dheeru Mundluru
 * 
 * Notes:
 * 	* Difference between wait() and sleep() and yield() methods is all will suspend the thread but wait() will release
 * 	the lock and sleep() and yield() will not release the lock.
 * 	* wait() and notify() are object methods and hence must be called on the synchronized object.
 * 	* With wait(), we should always use a while loop with some condition, not an if loop. This is the standardized idiom
 * 	for wait(). This is because sometimes there can be spurious wakeups, that is, a thread can move from waiting state
 * 	to blocked state, even though notify() was not called.
 * 
 * A thread can be in New, Active (Runnable and Running), Blocked, Waiting, Timed-Waiting, Terminated.
 * When in Running state, calling wait() will move the thread into waiting state. Now, calling notify()/notifyAll()
 * will move it to Blocked state. 
 * When in Running state, calling wait(long)/sleep(long)/yield(long) will move the thread to Timed-Waiting state.
 * Now, calling notify()/notifyAll() will move it to Blocked state. But if timeout happens, then the thread will move
 * into Runnable state directly.
 *
 */
public class WaitNotifyIndexer {
	private Deque<Weblink> queue = new ArrayDeque<>();
	
	private static class Weblink {
		private long id;
	    private String title;
		private String url;
	    private String host;
	    
	    private String htmlPage;
	    
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getHtmlPage() {
			return htmlPage;
		}
		public void setHtmlPage(String htmlPage) {
			this.htmlPage = htmlPage;
		}
	}
	
	private static class Downloader implements Runnable {
		private Weblink weblink;
		public Downloader(Weblink weblink) {
			this.weblink = weblink;
		}
		public void run() {
			try {
				synchronized (weblink) {
					String htmlPage = HttpConnect.download(weblink.getUrl());
					weblink.setHtmlPage(htmlPage);
					
					/* notify() wakes up single thread (chosen arbitrarily if multiple threads are waiting). Moves
					 * waiting threads to BLOCKED 
					 */
					weblink.notifyAll(); 
				}		
                // *** lock released via wait() or exiting synchronized block ***				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static class Indexer implements Runnable {
		private Weblink weblink;
		private Indexer(Weblink weblink) {
			this.weblink = weblink;
		}
		public void run() {	
			
			// Without synchronized block, wait/notify calls will throw IllegalMonitorStateException 
			synchronized (weblink) {
				String htmlPage = weblink.getHtmlPage();
				
				// Standard idiom for using wait method
				//    + while condition is critical as some other thread could have acquired the 
				//    lock and changed the state of the variable or 
				//    + Due to "spurious wakeup": A waiting thread can rarely wake up in the absence of notify.
				while (htmlPage == null) {
					try {
						System.out.println(weblink.getId() + " not yet downloaded!");
						// wait() --> Comes from "Object" class. Not Thread!
						weblink.wait(); // Suspends thread. Releases lock (unlike sleep()/yield()). Goes into WAITING 
										//state
						System.out.println(weblink.getId() + " awakened!");
						htmlPage = weblink.getHtmlPage();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				index(htmlPage);
			}									
		}
		private void index(String text) {
			if (text != null) {
				System.out.println("\nIndexed: " + weblink.getId() + "\n");
			}
		}
	}
	
	public void go() {
		while (queue.size() > 0) {
			Weblink weblink = queue.remove();
			Thread downloaderThread = new Thread(new Downloader(weblink));
			Thread indexerThread = new Thread(new Indexer(weblink));
			
			downloaderThread.start();
			indexerThread.start();
		}
	}
	public void add(Weblink link) {
		queue.add(link);
	}
	public Weblink createWeblink(long id, String title, String url, String host) {
		Weblink weblink = new Weblink();
    	weblink.setId(id);
    	weblink.setTitle(title);
    	weblink.setUrl(url);
    	weblink.setHost(host);
    	return weblink;
    }
	
	public static void main(String[] args) {
		WaitNotifyIndexer waitNotifyIndexer = new WaitNotifyIndexer();
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2000, "Taming Tiger, Part 2", "https://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com"));
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "https://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com"));
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
		waitNotifyIndexer.go();
	}
}