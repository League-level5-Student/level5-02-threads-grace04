package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	int x;
	
	ThreadedGreeter(int x){
		this.x = x;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread number: "+x);
		if(x<50) {
			Thread t = new Thread(new ThreadedGreeter(x+=1));
			t.run();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
