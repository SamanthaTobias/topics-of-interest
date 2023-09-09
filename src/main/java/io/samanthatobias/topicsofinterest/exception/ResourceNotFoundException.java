package io.samanthatobias.topicsofinterest.exception;

public class ResourceNotFoundException extends RuntimeException {

	private final Class<?> resourceClass;
	private final Long resourceId;

	public ResourceNotFoundException(Class<?> resourceClass, Long resourceId) {
		super("Resource of type " + resourceClass.getSimpleName() + " with id " + resourceId + " not found.");
		this.resourceClass = resourceClass;
		this.resourceId = resourceId;
	}

	public Class<?> getResourceClass() {
		return resourceClass;
	}

	public Long getResourceId() {
		return resourceId;
	}

}
