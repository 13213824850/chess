package com.onlinechese.entys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FriendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FriendExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNull() {
            addCriterion("friend_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNotNull() {
            addCriterion("friend_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendNameEqualTo(String value) {
            addCriterion("friend_name =", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotEqualTo(String value) {
            addCriterion("friend_name <>", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThan(String value) {
            addCriterion("friend_name >", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThanOrEqualTo(String value) {
            addCriterion("friend_name >=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThan(String value) {
            addCriterion("friend_name <", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThanOrEqualTo(String value) {
            addCriterion("friend_name <=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLike(String value) {
            addCriterion("friend_name like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotLike(String value) {
            addCriterion("friend_name not like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameIn(List<String> values) {
            addCriterion("friend_name in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotIn(List<String> values) {
            addCriterion("friend_name not in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameBetween(String value1, String value2) {
            addCriterion("friend_name between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotBetween(String value1, String value2) {
            addCriterion("friend_name not between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameIsNull() {
            addCriterion("friend_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameIsNotNull() {
            addCriterion("friend_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameEqualTo(String value) {
            addCriterion("friend_nick_name =", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameNotEqualTo(String value) {
            addCriterion("friend_nick_name <>", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameGreaterThan(String value) {
            addCriterion("friend_nick_name >", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("friend_nick_name >=", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameLessThan(String value) {
            addCriterion("friend_nick_name <", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameLessThanOrEqualTo(String value) {
            addCriterion("friend_nick_name <=", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameLike(String value) {
            addCriterion("friend_nick_name like", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameNotLike(String value) {
            addCriterion("friend_nick_name not like", value, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameIn(List<String> values) {
            addCriterion("friend_nick_name in", values, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameNotIn(List<String> values) {
            addCriterion("friend_nick_name not in", values, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameBetween(String value1, String value2) {
            addCriterion("friend_nick_name between", value1, value2, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendNickNameNotBetween(String value1, String value2) {
            addCriterion("friend_nick_name not between", value1, value2, "friendNickName");
            return (Criteria) this;
        }

        public Criteria andFriendSexIsNull() {
            addCriterion("friend_sex is null");
            return (Criteria) this;
        }

        public Criteria andFriendSexIsNotNull() {
            addCriterion("friend_sex is not null");
            return (Criteria) this;
        }

        public Criteria andFriendSexEqualTo(Byte value) {
            addCriterion("friend_sex =", value, "friendSex");
            return (Criteria) this;
        }

        public Criteria andFriendSexNotEqualTo(Byte value) {
            addCriterion("friend_sex <>", value, "friendSex");
            return (Criteria) this;
        }

        public Criteria andFriendSexGreaterThan(Byte value) {
            addCriterion("friend_sex >", value, "friendSex");
            return (Criteria) this;
        }

        public Criteria andFriendSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("friend_sex >=", value, "friendSex");
            return (Criteria) this;
        }

        public Criteria andFriendSexLessThan(Byte value) {
            addCriterion("friend_sex <", value, "friendSex");
            return (Criteria) this;
        }

        public Criteria andFriendSexLessThanOrEqualTo(Byte value) {
            addCriterion("friend_sex <=", value, "friendSex");
            return (Criteria) this;
        }

        public Criteria andFriendSexIn(List<Byte> values) {
            addCriterion("friend_sex in", values, "friendSex");
            return (Criteria) this;
        }

        public Criteria andFriendSexNotIn(List<Byte> values) {
            addCriterion("friend_sex not in", values, "friendSex");
            return (Criteria) this;
        }

        public Criteria andFriendSexBetween(Byte value1, Byte value2) {
            addCriterion("friend_sex between", value1, value2, "friendSex");
            return (Criteria) this;
        }

        public Criteria andFriendSexNotBetween(Byte value1, Byte value2) {
            addCriterion("friend_sex not between", value1, value2, "friendSex");
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