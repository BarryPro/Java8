package org.demo.others;

import java.io.File;
import org.apache.commons.io.monitor.*;

public class FileMonitorTest {
	FileAlterationMonitor monitor = null;  
    public FileMonitorTest(long interval) throws Exception {  
        monitor = new FileAlterationMonitor(interval);  
    }  
  
    public void monitor(String path, FileAlterationListener listener) {  
        FileAlterationObserver observer = new FileAlterationObserver(new File(path));  
        monitor.addObserver(observer);  
        observer.addListener(listener);  
    }  
    public void stop() throws Exception{  
        monitor.stop();  
    }  
    public void start() throws Exception {  
        monitor.start();  
    }  
    public static void main(String[] args) throws Exception {  
    	FileMonitorTest m = new FileMonitorTest(5000);  
        m.monitor("C:\\Program Files\\eclipse\\plugins",new FileListenerTest());  
        m.start();  
    }
}
