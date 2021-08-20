package com.gr1fak.taskTracker.specification;

import com.gr1fak.taskTracker.model.TaskEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TaskSpecificationWithName implements Specification<TaskEntity> {

    private String name;

    public TaskSpecificationWithName(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<TaskEntity> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        if(name == null){
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
        return criteriaBuilder.equal(root.get("name"), this.name);
    }
}