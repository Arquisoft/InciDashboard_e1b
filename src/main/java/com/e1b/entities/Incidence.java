package com.e1b.entities;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Incidence {

	@Id
	private ObjectId _id;
	private Operario operario;

	private String name;
	private String description;
	private String location;
	private List<String> tags;
	private String additionalInformation;
	private Map<String, String> properties;
	private String state = "OPEN";
	private String notification;
	private String expireAt;
	private String assignedTo;

	public Incidence() {
	}

	public Incidence(String username, String password, String name, String description, String location,
			List<String> tags, String additionalInformation, Map<String, String> properties, String state,
			String notification, String expireAt, String assignedTo) {
		super();
		this.operario.setUsername(username);
		this.operario.setPassword(password);
		this.name = name;
		this.description = description;
		this.location = location;
		this.tags = tags;
		this.additionalInformation = additionalInformation;
		this.properties = properties;
		this.state = state;
		this.notification = notification;
		this.expireAt = expireAt;
		this.assignedTo = assignedTo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(String expireAt) {
		this.expireAt = expireAt;
	}

}
