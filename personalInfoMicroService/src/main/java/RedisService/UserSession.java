package RedisService;

public class UserSession {
	private Integer id;
	private boolean completeness;
	
	//getter & setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isCompleteness() {
		return completeness;
	}
	public void setCompleteness(boolean completeness) {
		this.completeness = completeness;
	}
	
}
