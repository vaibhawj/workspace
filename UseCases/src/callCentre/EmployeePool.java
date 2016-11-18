package callCentre;

import java.util.List;

public class EmployeePool {

	private List<Fresher> freshers;

	private TechnicalLead techLead;

	private ProductManager prodManager;

	public EmployeePool(List<Fresher> freshers, TechnicalLead tl, ProductManager pm) {
		this.freshers = freshers;
		this.setTechLead(tl);
		this.setProdManager(pm);
	}

	public Fresher findAFreeFresher() {
		for (Fresher e : freshers) {
			if (e.isFree()) {
				return e;
			}
		}
		return null;
	}

	public TechnicalLead getTechLead() {
		return techLead;
	}

	public void setTechLead(TechnicalLead techLead) {
		this.techLead = techLead;
	}

	public ProductManager getProdManager() {
		return prodManager;
	}

	public void setProdManager(ProductManager prodManager) {
		this.prodManager = prodManager;
	}

}
