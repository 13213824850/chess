package com.onlinechese.entys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameRecordExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWinUserNameIsNull() {
            addCriterion("win_user_name is null");
            return (Criteria) this;
        }

        public Criteria andWinUserNameIsNotNull() {
            addCriterion("win_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andWinUserNameEqualTo(String value) {
            addCriterion("win_user_name =", value, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameNotEqualTo(String value) {
            addCriterion("win_user_name <>", value, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameGreaterThan(String value) {
            addCriterion("win_user_name >", value, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("win_user_name >=", value, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameLessThan(String value) {
            addCriterion("win_user_name <", value, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameLessThanOrEqualTo(String value) {
            addCriterion("win_user_name <=", value, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameLike(String value) {
            addCriterion("win_user_name like", value, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameNotLike(String value) {
            addCriterion("win_user_name not like", value, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameIn(List<String> values) {
            addCriterion("win_user_name in", values, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameNotIn(List<String> values) {
            addCriterion("win_user_name not in", values, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameBetween(String value1, String value2) {
            addCriterion("win_user_name between", value1, value2, "winUserName");
            return (Criteria) this;
        }

        public Criteria andWinUserNameNotBetween(String value1, String value2) {
            addCriterion("win_user_name not between", value1, value2, "winUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameIsNull() {
            addCriterion("stansport_user_name is null");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameIsNotNull() {
            addCriterion("stansport_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameEqualTo(String value) {
            addCriterion("stansport_user_name =", value, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameNotEqualTo(String value) {
            addCriterion("stansport_user_name <>", value, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameGreaterThan(String value) {
            addCriterion("stansport_user_name >", value, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("stansport_user_name >=", value, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameLessThan(String value) {
            addCriterion("stansport_user_name <", value, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameLessThanOrEqualTo(String value) {
            addCriterion("stansport_user_name <=", value, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameLike(String value) {
            addCriterion("stansport_user_name like", value, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameNotLike(String value) {
            addCriterion("stansport_user_name not like", value, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameIn(List<String> values) {
            addCriterion("stansport_user_name in", values, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameNotIn(List<String> values) {
            addCriterion("stansport_user_name not in", values, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameBetween(String value1, String value2) {
            addCriterion("stansport_user_name between", value1, value2, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andStansportUserNameNotBetween(String value1, String value2) {
            addCriterion("stansport_user_name not between", value1, value2, "stansportUserName");
            return (Criteria) this;
        }

        public Criteria andGameoverResultIsNull() {
            addCriterion("gameover_result is null");
            return (Criteria) this;
        }

        public Criteria andGameoverResultIsNotNull() {
            addCriterion("gameover_result is not null");
            return (Criteria) this;
        }

        public Criteria andGameoverResultEqualTo(Integer value) {
            addCriterion("gameover_result =", value, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andGameoverResultNotEqualTo(Integer value) {
            addCriterion("gameover_result <>", value, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andGameoverResultGreaterThan(Integer value) {
            addCriterion("gameover_result >", value, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andGameoverResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("gameover_result >=", value, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andGameoverResultLessThan(Integer value) {
            addCriterion("gameover_result <", value, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andGameoverResultLessThanOrEqualTo(Integer value) {
            addCriterion("gameover_result <=", value, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andGameoverResultIn(List<Integer> values) {
            addCriterion("gameover_result in", values, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andGameoverResultNotIn(List<Integer> values) {
            addCriterion("gameover_result not in", values, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andGameoverResultBetween(Integer value1, Integer value2) {
            addCriterion("gameover_result between", value1, value2, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andGameoverResultNotBetween(Integer value1, Integer value2) {
            addCriterion("gameover_result not between", value1, value2, "gameoverResult");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
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