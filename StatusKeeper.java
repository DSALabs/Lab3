import java.io.PrintWriter;
public class StatusKeeper {
	StringBuffer status;
	
	public StatusKeeper(){
		status = new StringBuffer();
	}
	public void init() {
			status.setLength(0);
		}
	public void update(String token) {
		status.append(token + " ");
	}
	public String getStatus() {
		return status.toString();
	}
	public void printStatus(PrintWriter pw) {
		pw.println("   Processed : " + status);
	}
	}

