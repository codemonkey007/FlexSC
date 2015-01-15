package util;

import org.apache.commons.cli.ParseException;

public class Reciever<T> extends network.Server implements Runnable {

	public void run() {
		try {
			listen(54321);

			while(true) {
				byte[] res = new byte[1024*128*8];//1024*1024bits
				double t = System.nanoTime();
				os.write(res);
				os.flush();
				double t2 = System.nanoTime();
				System.out.println(1024*8/(t2-t)*1000000000);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException { 
		Reciever r = new Reciever();
		r.run();
	}
}
