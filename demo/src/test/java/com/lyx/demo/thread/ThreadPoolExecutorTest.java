package com.lyx.demo.thread;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Ryan
 */
public class ThreadPoolExecutorTest {

	/**
	 * 最小线程数
	 */
	private int corePoolSize = 1;

	/**
	 * 最大线程数
	 */
	private int maxPoolSize = 5;

	/**
	 * 线程池
	 */
	private ThreadPoolExecutor threadPool;

	@Test
	public void test1() {
		for (int i = 1270; i < 10000; i++) {
			if (i % 72 == 0 && String.valueOf(i).substring(1, 3).equals("27")) {
				System.out.println(i);
			}
		}
	}

	/**
	 *
	 */
	@Test
	public void test() {
		List<Integer> innerTasks = Lists.newArrayList(1, 2, 3, 4, 5, 4, 3, 5, 7, 8, 10, 3, 2, 2, 4, 5);
		innerTasks.forEach(p -> getThreadPool().submit(new Runnable() {
			@Override
			public void run() {
				doExecuteBuildCandleStick();
			}
		}));
	}

	private void doExecuteBuildCandleStick() {
		List<Integer> innerTasks = Lists.newArrayList(1, 2, 3, 4, 5, 4, 3, 5, 7, 8, 10, 3, 2, 2, 4, 5);
		innerTasks.forEach(p -> getThreadPool().submit(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(p * 1000l);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}));

	}

	/**
	 * @return
	 */
	private ThreadPoolExecutor getThreadPool() {
		if (threadPool == null) {
			synchronized (this) {
				if (threadPool == null) {
					final BlockingQueue<Runnable> workQueue = new SynchronousQueue();
					threadPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 1l, TimeUnit.MINUTES, workQueue, (r, executor) -> {
						try {
							workQueue.put(r);
						} catch (InterruptedException e) {
							throw new RejectedExecutionException(e);
						}
					});
				}
			}
		}

		return threadPool;
	}
}
