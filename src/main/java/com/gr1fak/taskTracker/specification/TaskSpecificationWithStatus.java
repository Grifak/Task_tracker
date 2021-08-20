package com.gr1fak.taskTracker.specification;

import com.gr1fak.taskTracker.enums.TaskStatus;
import com.gr1fak.taskTracker.model.TaskEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TaskSpecificationWithStatus implements Specification<TaskEntity> {

    private TaskStatus status;

    public TaskSpecificationWithStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public Predicate toPredicate(Root<TaskEntity> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        if(status == null){
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }
        return criteriaBuilder.equal(root.get("status"), this.status);
    }
}
