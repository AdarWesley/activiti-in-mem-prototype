package org.activiti.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.SuspendedJobQueryImpl;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.SuspendedJobEntity;
import org.activiti.engine.impl.persistence.entity.SuspendedJobEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.SuspendedJobDataManager;
import org.activiti.engine.runtime.Job;

public class InMemorySuspendedJobDataManager extends AbstractInMemoryDataManager<SuspendedJobEntity> implements SuspendedJobDataManager {

	public InMemorySuspendedJobDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	@Override
	public SuspendedJobEntity create() {
		return new SuspendedJobEntityImpl();
	}

	@Override
	public List<SuspendedJobEntity> findJobsByExecutionId(String executionId) {
		List<SuspendedJobEntity> suspendedJobEntities = entities.values().stream()
				.filter(sje -> sje.getExecutionId() != null && sje.getExecutionId().equals(executionId))
				.collect(Collectors.<SuspendedJobEntity>toList());
		return suspendedJobEntities;
	}

	@Override
	public List<SuspendedJobEntity> findJobsByProcessInstanceId(String processInstanceId) {
		List<SuspendedJobEntity> suspendedJobEntities = entities.values().stream()
				.filter(sje -> sje.getProcessInstanceId() != null && sje.getProcessInstanceId().equals(processInstanceId))
				.collect(Collectors.<SuspendedJobEntity>toList());
		return suspendedJobEntities;
	}

	@Override
	public List<Job> findJobsByQueryCriteria(SuspendedJobQueryImpl jobQuery, Page page) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long findJobCountByQueryCriteria(SuspendedJobQueryImpl jobQuery) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateJobTenantIdForDeployment(String deploymentId, String newTenantId) {
		throw new UnsupportedOperationException();
	}
}
