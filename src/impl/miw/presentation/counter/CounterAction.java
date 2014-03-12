package impl.miw.presentation.counter;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;

import com.miw.infrastructure.log.LogService;
import com.miw.model.Counter;
import com.opensymphony.xwork2.ActionSupport;

public class CounterAction extends ActionSupport implements ApplicationAware {

	private static final long serialVersionUID = 5390485447488424041L;
	private Map<String, Object> application;
	private LogService log;

	public LogService getLog() {
		return log;
	}

	public void setLog(LogService log) {
		this.log = log;
	}

	@Override
	public String execute() throws Exception {
		log.debug("Procesando el execute de Counter");
		Counter counter = (Counter) application.get("counter");
		if (counter == null) {
			counter = new Counter();
		}
		counter.increment();
		log.debug("Visitas: " + counter);
		application.put("counter", counter);

		return SUCCESS;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.application = arg0;
	}

}
