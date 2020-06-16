package org.activiti.manager;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionInfoEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionInfoEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ProcessDefinitionInfoDataManager;

public class InMemoryProcessDefinitionInfoDataManager extends AbstractInMemoryDataManager<ProcessDefinitionInfoEntity> implements ProcessDefinitionInfoDataManager {

	public InMemoryProcessDefinitionInfoDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	@Override
	public ProcessDefinitionInfoEntity create() {
		return new ProcessDefinitionInfoEntityImpl();
	}

	@Override
	public ProcessDefinitionInfoEntity findProcessDefinitionInfoByProcessDefinitionId(String processDefinitionId) {
		for (ProcessDefinitionInfoEntity ent : entities.values()) {
			if (ent.getProcessDefinitionId() != null && ent.getProcessDefinitionId().equals(processDefinitionId)) {
				return ent;
			}
		}
		
		return null;
	}

}
