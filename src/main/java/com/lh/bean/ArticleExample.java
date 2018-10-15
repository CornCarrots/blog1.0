package com.lh.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleUidIsNull() {
            addCriterion("article_uid is null");
            return (Criteria) this;
        }

        public Criteria andArticleUidIsNotNull() {
            addCriterion("article_uid is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUidEqualTo(Integer value) {
            addCriterion("article_uid =", value, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleUidNotEqualTo(Integer value) {
            addCriterion("article_uid <>", value, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleUidGreaterThan(Integer value) {
            addCriterion("article_uid >", value, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_uid >=", value, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleUidLessThan(Integer value) {
            addCriterion("article_uid <", value, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleUidLessThanOrEqualTo(Integer value) {
            addCriterion("article_uid <=", value, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleUidIn(List<Integer> values) {
            addCriterion("article_uid in", values, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleUidNotIn(List<Integer> values) {
            addCriterion("article_uid not in", values, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleUidBetween(Integer value1, Integer value2) {
            addCriterion("article_uid between", value1, value2, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleUidNotBetween(Integer value1, Integer value2) {
            addCriterion("article_uid not between", value1, value2, "articleUid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidIsNull() {
            addCriterion("article_cpid is null");
            return (Criteria) this;
        }

        public Criteria andArticleCpidIsNotNull() {
            addCriterion("article_cpid is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCpidEqualTo(Integer value) {
            addCriterion("article_cpid =", value, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidNotEqualTo(Integer value) {
            addCriterion("article_cpid <>", value, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidGreaterThan(Integer value) {
            addCriterion("article_cpid >", value, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_cpid >=", value, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidLessThan(Integer value) {
            addCriterion("article_cpid <", value, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidLessThanOrEqualTo(Integer value) {
            addCriterion("article_cpid <=", value, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidIn(List<Integer> values) {
            addCriterion("article_cpid in", values, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidNotIn(List<Integer> values) {
            addCriterion("article_cpid not in", values, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidBetween(Integer value1, Integer value2) {
            addCriterion("article_cpid between", value1, value2, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCpidNotBetween(Integer value1, Integer value2) {
            addCriterion("article_cpid not between", value1, value2, "articleCpid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidIsNull() {
            addCriterion("article_ccid is null");
            return (Criteria) this;
        }

        public Criteria andArticleCcidIsNotNull() {
            addCriterion("article_ccid is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCcidEqualTo(Integer value) {
            addCriterion("article_ccid =", value, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidNotEqualTo(Integer value) {
            addCriterion("article_ccid <>", value, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidGreaterThan(Integer value) {
            addCriterion("article_ccid >", value, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_ccid >=", value, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidLessThan(Integer value) {
            addCriterion("article_ccid <", value, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidLessThanOrEqualTo(Integer value) {
            addCriterion("article_ccid <=", value, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidIn(List<Integer> values) {
            addCriterion("article_ccid in", values, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidNotIn(List<Integer> values) {
            addCriterion("article_ccid not in", values, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidBetween(Integer value1, Integer value2) {
            addCriterion("article_ccid between", value1, value2, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCcidNotBetween(Integer value1, Integer value2) {
            addCriterion("article_ccid not between", value1, value2, "articleCcid");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateIsNull() {
            addCriterion("article_create_date is null");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateIsNotNull() {
            addCriterion("article_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateEqualTo(Date value) {
            addCriterion("article_create_date =", value, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateNotEqualTo(Date value) {
            addCriterion("article_create_date <>", value, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateGreaterThan(Date value) {
            addCriterion("article_create_date >", value, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("article_create_date >=", value, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateLessThan(Date value) {
            addCriterion("article_create_date <", value, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("article_create_date <=", value, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateIn(List<Date> values) {
            addCriterion("article_create_date in", values, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateNotIn(List<Date> values) {
            addCriterion("article_create_date not in", values, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateBetween(Date value1, Date value2) {
            addCriterion("article_create_date between", value1, value2, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("article_create_date not between", value1, value2, "articleCreateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateIsNull() {
            addCriterion("article_update_date is null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateIsNotNull() {
            addCriterion("article_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateEqualTo(Date value) {
            addCriterion("article_update_date =", value, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateNotEqualTo(Date value) {
            addCriterion("article_update_date <>", value, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateGreaterThan(Date value) {
            addCriterion("article_update_date >", value, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("article_update_date >=", value, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateLessThan(Date value) {
            addCriterion("article_update_date <", value, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("article_update_date <=", value, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateIn(List<Date> values) {
            addCriterion("article_update_date in", values, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateNotIn(List<Date> values) {
            addCriterion("article_update_date not in", values, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateBetween(Date value1, Date value2) {
            addCriterion("article_update_date between", value1, value2, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("article_update_date not between", value1, value2, "articleUpdateDate");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNull() {
            addCriterion("article_status is null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNotNull() {
            addCriterion("article_status is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusEqualTo(Integer value) {
            addCriterion("article_status =", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotEqualTo(Integer value) {
            addCriterion("article_status <>", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThan(Integer value) {
            addCriterion("article_status >", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_status >=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThan(Integer value) {
            addCriterion("article_status <", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("article_status <=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIn(List<Integer> values) {
            addCriterion("article_status in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotIn(List<Integer> values) {
            addCriterion("article_status not in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusBetween(Integer value1, Integer value2) {
            addCriterion("article_status between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("article_status not between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleViewsIsNull() {
            addCriterion("article_views is null");
            return (Criteria) this;
        }

        public Criteria andArticleViewsIsNotNull() {
            addCriterion("article_views is not null");
            return (Criteria) this;
        }

        public Criteria andArticleViewsEqualTo(Long value) {
            addCriterion("article_views =", value, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleViewsNotEqualTo(Long value) {
            addCriterion("article_views <>", value, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleViewsGreaterThan(Long value) {
            addCriterion("article_views >", value, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleViewsGreaterThanOrEqualTo(Long value) {
            addCriterion("article_views >=", value, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleViewsLessThan(Long value) {
            addCriterion("article_views <", value, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleViewsLessThanOrEqualTo(Long value) {
            addCriterion("article_views <=", value, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleViewsIn(List<Long> values) {
            addCriterion("article_views in", values, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleViewsNotIn(List<Long> values) {
            addCriterion("article_views not in", values, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleViewsBetween(Long value1, Long value2) {
            addCriterion("article_views between", value1, value2, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleViewsNotBetween(Long value1, Long value2) {
            addCriterion("article_views not between", value1, value2, "articleViews");
            return (Criteria) this;
        }

        public Criteria andArticleLikesIsNull() {
            addCriterion("article_likes is null");
            return (Criteria) this;
        }

        public Criteria andArticleLikesIsNotNull() {
            addCriterion("article_likes is not null");
            return (Criteria) this;
        }

        public Criteria andArticleLikesEqualTo(Long value) {
            addCriterion("article_likes =", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesNotEqualTo(Long value) {
            addCriterion("article_likes <>", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesGreaterThan(Long value) {
            addCriterion("article_likes >", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesGreaterThanOrEqualTo(Long value) {
            addCriterion("article_likes >=", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesLessThan(Long value) {
            addCriterion("article_likes <", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesLessThanOrEqualTo(Long value) {
            addCriterion("article_likes <=", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesIn(List<Long> values) {
            addCriterion("article_likes in", values, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesNotIn(List<Long> values) {
            addCriterion("article_likes not in", values, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesBetween(Long value1, Long value2) {
            addCriterion("article_likes between", value1, value2, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesNotBetween(Long value1, Long value2) {
            addCriterion("article_likes not between", value1, value2, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsIsNull() {
            addCriterion("article_comments is null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsIsNotNull() {
            addCriterion("article_comments is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsEqualTo(Long value) {
            addCriterion("article_comments =", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsNotEqualTo(Long value) {
            addCriterion("article_comments <>", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsGreaterThan(Long value) {
            addCriterion("article_comments >", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsGreaterThanOrEqualTo(Long value) {
            addCriterion("article_comments >=", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsLessThan(Long value) {
            addCriterion("article_comments <", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsLessThanOrEqualTo(Long value) {
            addCriterion("article_comments <=", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsIn(List<Long> values) {
            addCriterion("article_comments in", values, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsNotIn(List<Long> values) {
            addCriterion("article_comments not in", values, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsBetween(Long value1, Long value2) {
            addCriterion("article_comments between", value1, value2, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsNotBetween(Long value1, Long value2) {
            addCriterion("article_comments not between", value1, value2, "articleComments");
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