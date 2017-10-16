package application.dummies;
public class Relationship {
	private RelationshipType type;
	private int sourceEntityIndex;
	private int targetEntityIndex;
	
	public Relationship(RelationshipType type, int sourceEntityIndex, int targetEntityIndex) {
		this.type = type;
		this.sourceEntityIndex = sourceEntityIndex;
		this.targetEntityIndex = targetEntityIndex;
	}

	public RelationshipType getType() {
		return type;
	}

	public void setType(RelationshipType type) {
		this.type = type;
	}

	public int getSourceEntityIndex() {
		return sourceEntityIndex;
	}

	public void setSourceEntityIndex(int sourceEntityIndex) {
		this.sourceEntityIndex = sourceEntityIndex;
	}

	public int getTargetEntityIndex() {
		return targetEntityIndex;
	}

	public void setTargetEntityIndex(int targetEntityIndex) {
		this.targetEntityIndex = targetEntityIndex;
	}
	
	
	
}