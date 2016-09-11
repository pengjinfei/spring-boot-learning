package com.pengjinfei.ch8.jpa.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
public class CustomerSpecs {

    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
        Class<T> type = (Class<T>) example.getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                EntityType<T> entity = entityManager.getMetamodel().entity(type);
                for (Attribute<T, ?> attribute : entity.getDeclaredAttributes()) {
                    Object value = getValue(example, attribute);
                    if (value != null) {
                        if (attribute.getJavaType() == String.class) {
                            if (!StringUtils.isEmpty(value)) {
                                predicates.add(criteriaBuilder.like(root.get(attribute(entity, attribute.getName(), String.class)),pattern(String.valueOf(value))));
                            }
                        }else {
                            predicates.add(criteriaBuilder.equal(root.get(attribute(entity, attribute.getName(), value.getClass())),value));
                        }
                    }
                }
                return predicates.isEmpty()?criteriaBuilder.conjunction():criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }

            private <T> Object getValue(T example, Attribute<T, ?> attribute) {
                return ReflectionUtils.getField((Field) attribute.getJavaMember(), example);
            }

            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String filedName,Class<E> fieldClass) {
                return entity.getDeclaredSingularAttribute(filedName, fieldClass);
            }
        };

    }

    static private String pattern(String string) {
        return "%" + string + "%";
    }
}
