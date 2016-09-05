package threadPool;

import java.util.Vector;

public class ThreadPoolManager {
	private int maxThread;	//最大线程数
	public Vector vector;	//实现可增长的对象数组 默认大小为10
	private MyNotify notify;	//实现线程间通信的接口
	public void setMaxThread(int threadCount){//threadCount 标志当前线程池线程数
		this.maxThread = threadCount;
	}
	public ThreadPoolManager(int threadCount,MyNotify notify){
		this.notify = notify;//初始化并存储notify的值
		this.setMaxThread(threadCount);
		System.out.println("线程池开始准备......");
		vector = new Vector();
		for(int i=1;i<=threadCount;i++){
			SimpleThread thread = new SimpleThread(i,this.notify);
			vector.addElement(thread);//添加至末尾 数量加一
			thread.start();
		}
	}
	public void Process(Taskable task){//执行任务操作 参数 可以
		int i;
		for (i = 0; i < vector.size(); i++) {
			SimpleThread currentThread = (SimpleThread) vector.elementAt(i);
			if(!currentThread.isRunning()){
				System.out.println("线程"+(i+1)+"开始执行任务");
				currentThread.setTask(task);
				currentThread.setRunning(true);
				return;
			}
		}
		System.out.println("线程池已被占用完，没有空闲线程...");

		if(i == vector.size()){//说明线程池中线程被占用完
			/*ThreadPoolManager tpm = new ThreadPoolManager(10);//这样会重新建立新的线程池非同一资源
			System.out.println("重新分配10个线程");*/
			int temp = maxThread;//存储当前最大线程数
			this.setMaxThread(maxThread+10);//重新分配线程.修改最大值
			for(int j=temp+1;j<=maxThread;j++){
				SimpleThread thread = new SimpleThread(j,this.notify);
				vector.addElement(thread);//添加至末尾 数量加一
				thread.start();
			}
			this.Process(task);
		}
	}
}
