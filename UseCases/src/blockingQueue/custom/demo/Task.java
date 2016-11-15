package blockingQueue.custom.demo;

public class Task {

	private int id;
	private String producer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task(int i, String producer) {
		this.id = i;
		this.producer = producer;
	}

	public String getProducer() {

		return producer;
	}

}
