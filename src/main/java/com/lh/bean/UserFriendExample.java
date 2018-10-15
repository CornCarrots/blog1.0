package com.lh.bean;

import java.util.ArrayList;
import java.util.List;

public class UserFriendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserFriendExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andFriendUidIsNull() {
            addCriterion("friend_uid is null");
            return (Criteria) this;
        }

        public Criteria andFriendUidIsNotNull() {
            addCriterion("friend_uid is not null");
            return (Criteria) this;
        }

        public Criteria andFriendUidEqualTo(Integer value) {
            addCriterion("friend_uid =", value, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendUidNotEqualTo(Integer value) {
            addCriterion("friend_uid <>", value, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendUidGreaterThan(Integer value) {
            addCriterion("friend_uid >", value, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("friend_uid >=", value, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendUidLessThan(Integer value) {
            addCriterion("friend_uid <", value, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendUidLessThanOrEqualTo(Integer value) {
            addCriterion("friend_uid <=", value, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendUidIn(List<Integer> values) {
            addCriterion("friend_uid in", values, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendUidNotIn(List<Integer> values) {
            addCriterion("friend_uid not in", values, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendUidBetween(Integer value1, Integer value2) {
            addCriterion("friend_uid between", value1, value2, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendUidNotBetween(Integer value1, Integer value2) {
            addCriterion("friend_uid not between", value1, value2, "friendUid");
            return (Criteria) this;
        }

        public Criteria andFriendStatusIsNull() {
            addCriterion("friend_status is null");
            return (Criteria) this;
        }

        public Criteria andFriendStatusIsNotNull() {
            addCriterion("friend_status is not null");
            return (Criteria) this;
        }

        public Criteria andFriendStatusEqualTo(Integer value) {
            addCriterion("friend_status =", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusNotEqualTo(Integer value) {
            addCriterion("friend_status <>", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusGreaterThan(Integer value) {
            addCriterion("friend_status >", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("friend_status >=", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusLessThan(Integer value) {
            addCriterion("friend_status <", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("friend_status <=", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusIn(List<Integer> values) {
            addCriterion("friend_status in", values, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusNotIn(List<Integer> values) {
            addCriterion("friend_status not in", values, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusBetween(Integer value1, Integer value2) {
            addCriterion("friend_status between", value1, value2, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("friend_status not between", value1, value2, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendNoteIsNull() {
            addCriterion("friend_note is null");
            return (Criteria) this;
        }

        public Criteria andFriendNoteIsNotNull() {
            addCriterion("friend_note is not null");
            return (Criteria) this;
        }

        public Criteria andFriendNoteEqualTo(String value) {
            addCriterion("friend_note =", value, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteNotEqualTo(String value) {
            addCriterion("friend_note <>", value, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteGreaterThan(String value) {
            addCriterion("friend_note >", value, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteGreaterThanOrEqualTo(String value) {
            addCriterion("friend_note >=", value, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteLessThan(String value) {
            addCriterion("friend_note <", value, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteLessThanOrEqualTo(String value) {
            addCriterion("friend_note <=", value, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteLike(String value) {
            addCriterion("friend_note like", value, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteNotLike(String value) {
            addCriterion("friend_note not like", value, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteIn(List<String> values) {
            addCriterion("friend_note in", values, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteNotIn(List<String> values) {
            addCriterion("friend_note not in", values, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteBetween(String value1, String value2) {
            addCriterion("friend_note between", value1, value2, "friendNote");
            return (Criteria) this;
        }

        public Criteria andFriendNoteNotBetween(String value1, String value2) {
            addCriterion("friend_note not between", value1, value2, "friendNote");
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