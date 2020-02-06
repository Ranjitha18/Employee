package com.employee.demo.abstractmappee;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;





public class AbstractModelMapper<E, M> extends ModelMapper {
	
	public List<E> entityList(List<M> models) {
		return models.stream().map(model -> entity(model)).collect(Collectors.toList());
	}

	public Set<E> entitySet(Set<M> models) {
		return models.stream().map(model -> entity(model)).collect(Collectors.toSet());
	}

	public E entity(M model) {
		return (E) map(model, entityType());
	}

	
	public List<M> modelList(List<E> jobWorkTypes) {
		return jobWorkTypes.stream().map(jobWorkType -> model(jobWorkType)).collect(Collectors.toList());
	}

	public Set<M> modelSet(List<E> jobWorkTypes) {
		return jobWorkTypes.stream().map(jobWorkType -> model(jobWorkType)).collect(Collectors.toSet());
	}

	public M model(E jobWorkType) {
		return (M) map(jobWorkType, modelType());
	}

	public  Class<E> entityType() {
		return null;
	}

	public  Class<M> modelType() {
		return null;
	}

	
	

}
