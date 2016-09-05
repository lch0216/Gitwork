package threadPool;

public class SimpleThread extends Thread implements Runnable{
	private boolean runningFlag;	//线程状态 默认为false 即等待
	private Taskable task;			//要执行的任务
	private int id;					//线程id
	private MyNotify notify;
	//标志runningFlag  用以激活线程
	public boolean isRunning(){
		return runningFlag;
	}
	public Taskable getTask(){
		return this.task;
	}
	public void setTask(Taskable task){
		this.task = task;
	}
	public synchronized void setRunning(boolean flag){//此方法操作了
		runningFlag = flag;//flag为true，当前线程已被占用
		if(flag){
			this.notifyAll();//flag为true通知其他线程进入就绪状态
		}
	} 
	public SimpleThread(int threadNumber,MyNotify notify){
		this.id = threadNumber;
		this.notify = notify;
		runningFlag = false;//创建默认为false 未占用
		System.out.println("线程Thread"+threadNumber+"started");
	}
	public synchronized void run(){
		try {
			while(true){
				if(!runningFlag){
					this.wait();//所有线程在没有任务时处于等待状态
				}else{
					System.out.println("线程"+id+"开始执行新任务.....");
					Object result = this.task.doTask();
					//获取线程中的notifyh回调此结果
					if(notify != null){
						this.notify.notifyResult(result);
					}
					sleep(5000);
					System.out.println("线程"+id+"已重新准备就绪....");
					setRunning(false);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("线程被打断");
		}
	}
}