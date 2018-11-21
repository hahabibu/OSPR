package com.guigu.instructional.po;

import java.util.ArrayList;
import java.util.List;

public class AuthortyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuthortyInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAuthortyIdIsNull() {
            addCriterion("authorty_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdIsNotNull() {
            addCriterion("authorty_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdEqualTo(Integer value) {
            addCriterion("authorty_id =", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdNotEqualTo(Integer value) {
            addCriterion("authorty_id <>", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdGreaterThan(Integer value) {
            addCriterion("authorty_id >", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("authorty_id >=", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdLessThan(Integer value) {
            addCriterion("authorty_id <", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdLessThanOrEqualTo(Integer value) {
            addCriterion("authorty_id <=", value, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdIn(List<Integer> values) {
            addCriterion("authorty_id in", values, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdNotIn(List<Integer> values) {
            addCriterion("authorty_id not in", values, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdBetween(Integer value1, Integer value2) {
            addCriterion("authorty_id between", value1, value2, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("authorty_id not between", value1, value2, "authortyId");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidIsNull() {
            addCriterion("authorty_pid is null");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidIsNotNull() {
            addCriterion("authorty_pid is not null");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidEqualTo(Integer value) {
            addCriterion("authorty_pid =", value, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidNotEqualTo(Integer value) {
            addCriterion("authorty_pid <>", value, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidGreaterThan(Integer value) {
            addCriterion("authorty_pid >", value, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("authorty_pid >=", value, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidLessThan(Integer value) {
            addCriterion("authorty_pid <", value, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidLessThanOrEqualTo(Integer value) {
            addCriterion("authorty_pid <=", value, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidIn(List<Integer> values) {
            addCriterion("authorty_pid in", values, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidNotIn(List<Integer> values) {
            addCriterion("authorty_pid not in", values, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidBetween(Integer value1, Integer value2) {
            addCriterion("authorty_pid between", value1, value2, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyPidNotBetween(Integer value1, Integer value2) {
            addCriterion("authorty_pid not between", value1, value2, "authortyPid");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameIsNull() {
            addCriterion("authorty_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameIsNotNull() {
            addCriterion("authorty_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameEqualTo(String value) {
            addCriterion("authorty_name =", value, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameNotEqualTo(String value) {
            addCriterion("authorty_name <>", value, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameGreaterThan(String value) {
            addCriterion("authorty_name >", value, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameGreaterThanOrEqualTo(String value) {
            addCriterion("authorty_name >=", value, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameLessThan(String value) {
            addCriterion("authorty_name <", value, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameLessThanOrEqualTo(String value) {
            addCriterion("authorty_name <=", value, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameLike(String value) {
            addCriterion("authorty_name like", value, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameNotLike(String value) {
            addCriterion("authorty_name not like", value, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameIn(List<String> values) {
            addCriterion("authorty_name in", values, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameNotIn(List<String> values) {
            addCriterion("authorty_name not in", values, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameBetween(String value1, String value2) {
            addCriterion("authorty_name between", value1, value2, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyNameNotBetween(String value1, String value2) {
            addCriterion("authorty_name not between", value1, value2, "authortyName");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescIsNull() {
            addCriterion("authorty_desc is null");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescIsNotNull() {
            addCriterion("authorty_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescEqualTo(String value) {
            addCriterion("authorty_desc =", value, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescNotEqualTo(String value) {
            addCriterion("authorty_desc <>", value, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescGreaterThan(String value) {
            addCriterion("authorty_desc >", value, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescGreaterThanOrEqualTo(String value) {
            addCriterion("authorty_desc >=", value, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescLessThan(String value) {
            addCriterion("authorty_desc <", value, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescLessThanOrEqualTo(String value) {
            addCriterion("authorty_desc <=", value, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescLike(String value) {
            addCriterion("authorty_desc like", value, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescNotLike(String value) {
            addCriterion("authorty_desc not like", value, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescIn(List<String> values) {
            addCriterion("authorty_desc in", values, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescNotIn(List<String> values) {
            addCriterion("authorty_desc not in", values, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescBetween(String value1, String value2) {
            addCriterion("authorty_desc between", value1, value2, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyDescNotBetween(String value1, String value2) {
            addCriterion("authorty_desc not between", value1, value2, "authortyDesc");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlIsNull() {
            addCriterion("authorty_url is null");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlIsNotNull() {
            addCriterion("authorty_url is not null");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlEqualTo(String value) {
            addCriterion("authorty_url =", value, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlNotEqualTo(String value) {
            addCriterion("authorty_url <>", value, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlGreaterThan(String value) {
            addCriterion("authorty_url >", value, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("authorty_url >=", value, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlLessThan(String value) {
            addCriterion("authorty_url <", value, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlLessThanOrEqualTo(String value) {
            addCriterion("authorty_url <=", value, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlLike(String value) {
            addCriterion("authorty_url like", value, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlNotLike(String value) {
            addCriterion("authorty_url not like", value, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlIn(List<String> values) {
            addCriterion("authorty_url in", values, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlNotIn(List<String> values) {
            addCriterion("authorty_url not in", values, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlBetween(String value1, String value2) {
            addCriterion("authorty_url between", value1, value2, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyUrlNotBetween(String value1, String value2) {
            addCriterion("authorty_url not between", value1, value2, "authortyUrl");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassIsNull() {
            addCriterion("authorty_class is null");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassIsNotNull() {
            addCriterion("authorty_class is not null");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassEqualTo(Integer value) {
            addCriterion("authorty_class =", value, "authortyClass");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassNotEqualTo(Integer value) {
            addCriterion("authorty_class <>", value, "authortyClass");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassGreaterThan(Integer value) {
            addCriterion("authorty_class >", value, "authortyClass");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("authorty_class >=", value, "authortyClass");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassLessThan(Integer value) {
            addCriterion("authorty_class <", value, "authortyClass");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassLessThanOrEqualTo(Integer value) {
            addCriterion("authorty_class <=", value, "authortyClass");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassIn(List<Integer> values) {
            addCriterion("authorty_class in", values, "authortyClass");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassNotIn(List<Integer> values) {
            addCriterion("authorty_class not in", values, "authortyClass");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassBetween(Integer value1, Integer value2) {
            addCriterion("authorty_class between", value1, value2, "authortyClass");
            return (Criteria) this;
        }

        public Criteria andAuthortyClassNotBetween(Integer value1, Integer value2) {
            addCriterion("authorty_class not between", value1, value2, "authortyClass");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}