package org.activiti.manager;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.PropertyEntity;
import org.activiti.engine.impl.persistence.entity.PropertyEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.PropertyDataManager;

public class InMemoryPropertyDataManager extends AbstractInMemoryDataManager<PropertyEntity> implements PropertyDataManager {

	public InMemoryPropertyDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	public PropertyEntity create() {
		return new PropertyEntityImpl();
	}
	
	public List<PropertyEntity> findAll() {
		List<PropertyEntity> propertyEntities = new ArrayList<PropertyEntity>();
		propertyEntities.addAll(entities.values());
		return propertyEntities;
	}
}
