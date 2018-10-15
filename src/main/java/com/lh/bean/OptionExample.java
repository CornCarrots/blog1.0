package com.lh.bean;

import java.util.ArrayList;
import java.util.List;

public class OptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OptionExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOptionKeyIsNull() {
            addCriterion("option_key is null");
            return (Criteria) this;
        }

        public Criteria andOptionKeyIsNotNull() {
            addCriterion("option_key is not null");
            return (Criteria) this;
        }

        public Criteria andOptionKeyEqualTo(String value) {
            addCriterion("option_key =", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotEqualTo(String value) {
            addCriterion("option_key <>", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyGreaterThan(String value) {
            addCriterion("option_key >", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("option_key >=", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyLessThan(String value) {
            addCriterion("option_key <", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyLessThanOrEqualTo(String value) {
            addCriterion("option_key <=", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyLike(String value) {
            addCriterion("option_key like", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotLike(String value) {
            addCriterion("option_key not like", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyIn(List<String> values) {
            addCriterion("option_key in", values, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotIn(List<String> values) {
            addCriterion("option_key not in", values, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyBetween(String value1, String value2) {
            addCriterion("option_key between", value1, value2, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotBetween(String value1, String value2) {
            addCriterion("option_key not between", value1, value2, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionValueIsNull() {
            addCriterion("option_value is null");
            return (Criteria) this;
        }

        public Criteria andOptionValueIsNotNull() {
            addCriterion("option_value is not null");
            return (Criteria) this;
        }

        public Criteria andOptionValueEqualTo(String value) {
            addCriterion("option_value =", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueNotEqualTo(String value) {
            addCriterion("option_value <>", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueGreaterThan(String value) {
            addCriterion("option_value >", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueGreaterThanOrEqualTo(String value) {
            addCriterion("option_value >=", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueLessThan(String value) {
            addCriterion("option_value <", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueLessThanOrEqualTo(String value) {
            addCriterion("option_value <=", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueLike(String value) {
            addCriterion("option_value like", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueNotLike(String value) {
            addCriterion("option_value not like", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueIn(List<String> values) {
            addCriterion("option_value in", values, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueNotIn(List<String> values) {
            addCriterion("option_value not in", values, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueBetween(String value1, String value2) {
            addCriterion("option_value between", value1, value2, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueNotBetween(String value1, String value2) {
            addCriterion("option_value not between", value1, value2, "optionValue");
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