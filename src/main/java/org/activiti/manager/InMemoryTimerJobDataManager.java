package org.activiti.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.TimerJobQueryImpl;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.TimerJobEntity;
import org.activiti.engine.impl.persistence.entity.TimerJobEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.TimerJobDataManager;
import org.activiti.engine.runtime.Job;

public class InMemoryTimerJobDataManager extends AbstractInMemoryDataManager<TimerJobEntity> implements TimerJobDataManager {

	public InMemoryTimerJobDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	public TimerJobEntity create() {
		return new TimerJobEntityImpl();
	}

	public List<TimerJobEntity> findTimerJobsToExecute(Page page) {
		List<TimerJobEntity> timerEntities = 
			entities.values().stream()
			.skip(page.getFirstResult())
			.limit(page.getMaxResults())
			.collect(Collectors.<TimerJobEntity>toList());
		return timerEntities;
	}

	public List<TimerJobEntity> findJobsByTypeAndProcessDefinitionId(String jobHandlerType,
			String processDefinitionId) {
		List<TimerJobEntity> tjeEntities = entities.values().stream()
				.filter(tje -> tje.getJobHandlerType().equals(jobHandlerType))
				.filter(tje -> tje.getProcessDefinitionId().equals(processDefinitionId))
				.collect(Collectors.<TimerJobEntity>toList());
		return tjeEntities;
	}

	public List<TimerJobEntity> findJobsByTypeAndProcessDefinitionKeyNoTenantId(String jobHandlerType,
			String processDefinitionKey) {
		List<TimerJobEntity> timerJobEntities = entities.values().stream()
				.filter(tje -> tje.getJobHandlerType() != null && tje.getJobHandlerType().equals(jobHandlerType))
				.filter(tje -> tje.getProcessDefinitionId() != null && tje.getProcessDefinitionId().equals(processDefinitionKey))
				.collect(Collectors.<TimerJobEntity>toList());
		return timerJobEntities;
	}

	public List<TimerJobEntity> findJobsByTypeAndProcessDefinitionKeyAndTenantId(String jobHandlerType,
			String processDefinitionKey, String tenantId) {
		List<TimerJobEntity> timerJobEntities = entities.values().stream()
				.filter(tje -> tje.getJobHandlerType() != null && tje.getJobHandlerType().equals(jobHandlerType))
				.filter(tje -> tje.getProcessDefinitionId() != null && tje.getProcessDefinitionId().equals(processDefinitionKey))
				.filter(tje -> tje.getTenantId() != null && tje.getTenantId().equals(tenantId))
				.collect(Collectors.<TimerJobEntity>toList());
			return timerJobEntities;
	}

	public List<TimerJobEntity> findJobsByExecutionId(String executionId) {
		List<TimerJobEntity> timerJobEntities = entities.values().stream()
			.filter(tje -> tje.getExecutionId() != null && tje.getExecutionId().equals(executionId))
			.collect(Collectors.<TimerJobEntity>toList());
		return timerJobEntities;
	}

	public List<TimerJobEntity> findJobsByProcessInstanceId(String processInstanceId) {
		List<TimerJobEntity> timerJobEntities = entities.values().stream()
				.filter(tje -> tje.getProcessInstanceId() != null && tje.getProcessInstanceId().equals(processInstanceId))
				.collect(Collectors.<TimerJobEntity>toList());
		return timerJobEntities;
	}

	public List<Job> findJobsByQueryCriteria(TimerJobQueryImpl jobQuery, Page page) {
		throw new UnsupportedOperationException();
	}

	public long findJobCountByQueryCriteria(TimerJobQueryImpl jobQuery) {
		throw new UnsupportedOperationException();
	}

	public void updateJobTenantIdForDeployment(String deploymentId, String newTenantId) {
		throw new UnsupportedOperationException();
	}
}
