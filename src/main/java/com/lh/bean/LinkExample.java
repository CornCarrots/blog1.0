package com.lh.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LinkExample() {
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

        public Criteria andLinkUrlIsNull() {
            addCriterion("link_url is null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNotNull() {
            addCriterion("link_url is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlEqualTo(String value) {
            addCriterion("link_url =", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotEqualTo(String value) {
            addCriterion("link_url <>", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThan(String value) {
            addCriterion("link_url >", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("link_url >=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThan(String value) {
            addCriterion("link_url <", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThanOrEqualTo(String value) {
            addCriterion("link_url <=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLike(String value) {
            addCriterion("link_url like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotLike(String value) {
            addCriterion("link_url not like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIn(List<String> values) {
            addCriterion("link_url in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotIn(List<String> values) {
            addCriterion("link_url not in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlBetween(String value1, String value2) {
            addCriterion("link_url between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotBetween(String value1, String value2) {
            addCriterion("link_url not between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNull() {
            addCriterion("link_name is null");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNotNull() {
            addCriterion("link_name is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNameEqualTo(String value) {
            addCriterion("link_name =", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotEqualTo(String value) {
            addCriterion("link_name <>", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThan(String value) {
            addCriterion("link_name >", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThanOrEqualTo(String value) {
            addCriterion("link_name >=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThan(String value) {
            addCriterion("link_name <", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThanOrEqualTo(String value) {
            addCriterion("link_name <=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLike(String value) {
            addCriterion("link_name like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotLike(String value) {
            addCriterion("link_name not like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameIn(List<String> values) {
            addCriterion("link_name in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotIn(List<String> values) {
            addCriterion("link_name not in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameBetween(String value1, String value2) {
            addCriterion("link_name between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotBetween(String value1, String value2) {
            addCriterion("link_name not between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeIsNull() {
            addCriterion("link_describe is null");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeIsNotNull() {
            addCriterion("link_describe is not null");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeEqualTo(String value) {
            addCriterion("link_describe =", value, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeNotEqualTo(String value) {
            addCriterion("link_describe <>", value, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeGreaterThan(String value) {
            addCriterion("link_describe >", value, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("link_describe >=", value, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeLessThan(String value) {
            addCriterion("link_describe <", value, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeLessThanOrEqualTo(String value) {
            addCriterion("link_describe <=", value, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeLike(String value) {
            addCriterion("link_describe like", value, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeNotLike(String value) {
            addCriterion("link_describe not like", value, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeIn(List<String> values) {
            addCriterion("link_describe in", values, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeNotIn(List<String> values) {
            addCriterion("link_describe not in", values, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeBetween(String value1, String value2) {
            addCriterion("link_describe between", value1, value2, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkDescribeNotBetween(String value1, String value2) {
            addCriterion("link_describe not between", value1, value2, "linkDescribe");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateIsNull() {
            addCriterion("link_create_date is null");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateIsNotNull() {
            addCriterion("link_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateEqualTo(Date value) {
            addCriterion("link_create_date =", value, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateNotEqualTo(Date value) {
            addCriterion("link_create_date <>", value, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateGreaterThan(Date value) {
            addCriterion("link_create_date >", value, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("link_create_date >=", value, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateLessThan(Date value) {
            addCriterion("link_create_date <", value, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("link_create_date <=", value, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateIn(List<Date> values) {
            addCriterion("link_create_date in", values, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateNotIn(List<Date> values) {
            addCriterion("link_create_date not in", values, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateBetween(Date value1, Date value2) {
            addCriterion("link_create_date between", value1, value2, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("link_create_date not between", value1, value2, "linkCreateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateIsNull() {
            addCriterion("link_update_date is null");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateIsNotNull() {
            addCriterion("link_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateEqualTo(Date value) {
            addCriterion("link_update_date =", value, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateNotEqualTo(Date value) {
            addCriterion("link_update_date <>", value, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateGreaterThan(Date value) {
            addCriterion("link_update_date >", value, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("link_update_date >=", value, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateLessThan(Date value) {
            addCriterion("link_update_date <", value, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("link_update_date <=", value, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateIn(List<Date> values) {
            addCriterion("link_update_date in", values, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateNotIn(List<Date> values) {
            addCriterion("link_update_date not in", values, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateBetween(Date value1, Date value2) {
            addCriterion("link_update_date between", value1, value2, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLinkUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("link_update_date not between", value1, value2, "linkUpdateDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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