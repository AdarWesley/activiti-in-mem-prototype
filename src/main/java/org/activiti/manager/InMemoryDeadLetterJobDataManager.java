package org.activiti.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.activiti.engine.impl.DeadLetterJobQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.DeadLetterJobEntity;
import org.activiti.engine.impl.persistence.entity.DeadLetterJobEntityImpl;
import org.activiti.engine.impl.persistence.entity.JobEntity;
import org.activiti.engine.impl.persistence.entity.data.DeadLetterJobDataManager;
import org.activiti.engine.impl.persistence.entity.data.JobDataManager;
import org.activiti.engine.runtime.Job;

public class InMemoryDeadLetterJobDataManager extends AbstractInMemoryDataManager<DeadLetterJobEntity> implements DeadLetterJobDataManager {

	public InMemoryDeadLetterJobDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	@Override
	public DeadLetterJobEntity create() {
		return new DeadLetterJobEntityImpl();
	}

	@Override
	public List<DeadLetterJobEntity> findJobsByExecutionId(String executionId) {
		List<DeadLetterJobEntity> deadLetterJobEntities = entities.values().stream()
				.filter(dlje -> dlje.getExecutionId() != null && dlje.getExecutionId().equals(executionId))
				.collect(Collectors.<DeadLetterJobEntity>toList());
		return deadLetterJobEntities;
	}

	@Override
	public List<Job> findJobsByQueryCriteria(DeadLetterJobQueryImpl jobQuery, Page page) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long findJobCountByQueryCriteria(DeadLetterJobQueryImpl jobQuery) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateJobTenantIdForDeployment(String deploymentId, String newTenantId) {
		throw new UnsupportedOperationException();
	}
}
