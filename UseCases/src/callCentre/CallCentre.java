package callCentre;

public class CallCentre {

	private EmployeePool employeePool;

	public CallCentre(EmployeePool empPool) {
		this.employeePool = empPool;
	}

	public boolean incomingCall(Call call) {

		Fresher fresher = employeePool.findAFreeFresher();
		boolean callHandled = false;
		if (null != fresher && fresher.isFree()) {
			callHandled = call.handle(fresher);
		}

		if (!callHandled) {
			TechnicalLead techLead = employeePool.getTechLead();
			callHandled = escalateHigher(call, techLead);
		}

		if (!callHandled) {
			ProductManager productManager = employeePool.getProdManager();
			callHandled = escalateHigher(call, productManager);
		}

		return callHandled;

	}

	private boolean escalateHigher(Call call, IEmployee higherEmployee) {
		boolean callHandled = false;

		synchronized (higherEmployee) {
			while (!higherEmployee.isFree()) {
				try {
					higherEmployee.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			callHandled = call.handle(higherEmployee);
		}

		return callHandled;

	}

}
