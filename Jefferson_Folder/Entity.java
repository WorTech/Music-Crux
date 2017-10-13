
public class Entity {
	//feel free to change to int or long if that fits your model better
	private String id;
	
	private EntityType type;
	
	//artist name, band name, etc
	private String label;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EntityType getType() {
		return type;
	}

	public void setType(EntityType type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
