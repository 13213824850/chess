package com.onlinechese.entys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RankExample() {
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

        public Criteria andRankGradeIsNull() {
            addCriterion("rank_grade is null");
            return (Criteria) this;
        }

        public Criteria andRankGradeIsNotNull() {
            addCriterion("rank_grade is not null");
            return (Criteria) this;
        }

        public Criteria andRankGradeEqualTo(Integer value) {
            addCriterion("rank_grade =", value, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeNotEqualTo(Integer value) {
            addCriterion("rank_grade <>", value, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeGreaterThan(Integer value) {
            addCriterion("rank_grade >", value, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank_grade >=", value, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeLessThan(Integer value) {
            addCriterion("rank_grade <", value, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeLessThanOrEqualTo(Integer value) {
            addCriterion("rank_grade <=", value, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeIn(List<Integer> values) {
            addCriterion("rank_grade in", values, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeNotIn(List<Integer> values) {
            addCriterion("rank_grade not in", values, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeBetween(Integer value1, Integer value2) {
            addCriterion("rank_grade between", value1, value2, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("rank_grade not between", value1, value2, "rankGrade");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageIsNull() {
            addCriterion("rank_grade_stage is null");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageIsNotNull() {
            addCriterion("rank_grade_stage is not null");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageEqualTo(Integer value) {
            addCriterion("rank_grade_stage =", value, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageNotEqualTo(Integer value) {
            addCriterion("rank_grade_stage <>", value, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageGreaterThan(Integer value) {
            addCriterion("rank_grade_stage >", value, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank_grade_stage >=", value, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageLessThan(Integer value) {
            addCriterion("rank_grade_stage <", value, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageLessThanOrEqualTo(Integer value) {
            addCriterion("rank_grade_stage <=", value, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageIn(List<Integer> values) {
            addCriterion("rank_grade_stage in", values, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageNotIn(List<Integer> values) {
            addCriterion("rank_grade_stage not in", values, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageBetween(Integer value1, Integer value2) {
            addCriterion("rank_grade_stage between", value1, value2, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andRankGradeStageNotBetween(Integer value1, Integer value2) {
            addCriterion("rank_grade_stage not between", value1, value2, "rankGradeStage");
            return (Criteria) this;
        }

        public Criteria andStarIsNull() {
            addCriterion("star is null");
            return (Criteria) this;
        }

        public Criteria andStarIsNotNull() {
            addCriterion("star is not null");
            return (Criteria) this;
        }

        public Criteria andStarEqualTo(Integer value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(Integer value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(Integer value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThan(Integer value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(Integer value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarIn(List<Integer> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<Integer> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(Integer value1, Integer value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(Integer value1, Integer value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andProtectCountIsNull() {
            addCriterion("protect_count is null");
            return (Criteria) this;
        }

        public Criteria andProtectCountIsNotNull() {
            addCriterion("protect_count is not null");
            return (Criteria) this;
        }

        public Criteria andProtectCountEqualTo(Integer value) {
            addCriterion("protect_count =", value, "protectCount");
            return (Criteria) this;
        }

        public Criteria andProtectCountNotEqualTo(Integer value) {
            addCriterion("protect_count <>", value, "protectCount");
            return (Criteria) this;
        }

        public Criteria andProtectCountGreaterThan(Integer value) {
            addCriterion("protect_count >", value, "protectCount");
            return (Criteria) this;
        }

        public Criteria andProtectCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("protect_count >=", value, "protectCount");
            return (Criteria) this;
        }

        public Criteria andProtectCountLessThan(Integer value) {
            addCriterion("protect_count <", value, "protectCount");
            return (Criteria) this;
        }

        public Criteria andProtectCountLessThanOrEqualTo(Integer value) {
            addCriterion("protect_count <=", value, "protectCount");
            return (Criteria) this;
        }

        public Criteria andProtectCountIn(List<Integer> values) {
            addCriterion("protect_count in", values, "protectCount");
            return (Criteria) this;
        }

        public Criteria andProtectCountNotIn(List<Integer> values) {
            addCriterion("protect_count not in", values, "protectCount");
            return (Criteria) this;
        }

        public Criteria andProtectCountBetween(Integer value1, Integer value2) {
            addCriterion("protect_count between", value1, value2, "protectCount");
            return (Criteria) this;
        }

        public Criteria andProtectCountNotBetween(Integer value1, Integer value2) {
            addCriterion("protect_count not between", value1, value2, "protectCount");
            return (Criteria) this;
        }

        public Criteria andWinCountIsNull() {
            addCriterion("win_count is null");
            return (Criteria) this;
        }

        public Criteria andWinCountIsNotNull() {
            addCriterion("win_count is not null");
            return (Criteria) this;
        }

        public Criteria andWinCountEqualTo(Integer value) {
            addCriterion("win_count =", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountNotEqualTo(Integer value) {
            addCriterion("win_count <>", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountGreaterThan(Integer value) {
            addCriterion("win_count >", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("win_count >=", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountLessThan(Integer value) {
            addCriterion("win_count <", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountLessThanOrEqualTo(Integer value) {
            addCriterion("win_count <=", value, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountIn(List<Integer> values) {
            addCriterion("win_count in", values, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountNotIn(List<Integer> values) {
            addCriterion("win_count not in", values, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountBetween(Integer value1, Integer value2) {
            addCriterion("win_count between", value1, value2, "winCount");
            return (Criteria) this;
        }

        public Criteria andWinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("win_count not between", value1, value2, "winCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountIsNull() {
            addCriterion("transport_count is null");
            return (Criteria) this;
        }

        public Criteria andTransportCountIsNotNull() {
            addCriterion("transport_count is not null");
            return (Criteria) this;
        }

        public Criteria andTransportCountEqualTo(Integer value) {
            addCriterion("transport_count =", value, "transportCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountNotEqualTo(Integer value) {
            addCriterion("transport_count <>", value, "transportCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountGreaterThan(Integer value) {
            addCriterion("transport_count >", value, "transportCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("transport_count >=", value, "transportCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountLessThan(Integer value) {
            addCriterion("transport_count <", value, "transportCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountLessThanOrEqualTo(Integer value) {
            addCriterion("transport_count <=", value, "transportCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountIn(List<Integer> values) {
            addCriterion("transport_count in", values, "transportCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountNotIn(List<Integer> values) {
            addCriterion("transport_count not in", values, "transportCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountBetween(Integer value1, Integer value2) {
            addCriterion("transport_count between", value1, value2, "transportCount");
            return (Criteria) this;
        }

        public Criteria andTransportCountNotBetween(Integer value1, Integer value2) {
            addCriterion("transport_count not between", value1, value2, "transportCount");
            return (Criteria) this;
        }

        public Criteria andContinusTransportIsNull() {
            addCriterion("continus_transport is null");
            return (Criteria) this;
        }

        public Criteria andContinusTransportIsNotNull() {
            addCriterion("continus_transport is not null");
            return (Criteria) this;
        }

        public Criteria andContinusTransportEqualTo(Integer value) {
            addCriterion("continus_transport =", value, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusTransportNotEqualTo(Integer value) {
            addCriterion("continus_transport <>", value, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusTransportGreaterThan(Integer value) {
            addCriterion("continus_transport >", value, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusTransportGreaterThanOrEqualTo(Integer value) {
            addCriterion("continus_transport >=", value, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusTransportLessThan(Integer value) {
            addCriterion("continus_transport <", value, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusTransportLessThanOrEqualTo(Integer value) {
            addCriterion("continus_transport <=", value, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusTransportIn(List<Integer> values) {
            addCriterion("continus_transport in", values, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusTransportNotIn(List<Integer> values) {
            addCriterion("continus_transport not in", values, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusTransportBetween(Integer value1, Integer value2) {
            addCriterion("continus_transport between", value1, value2, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusTransportNotBetween(Integer value1, Integer value2) {
            addCriterion("continus_transport not between", value1, value2, "continusTransport");
            return (Criteria) this;
        }

        public Criteria andContinusWinIsNull() {
            addCriterion("continus_win is null");
            return (Criteria) this;
        }

        public Criteria andContinusWinIsNotNull() {
            addCriterion("continus_win is not null");
            return (Criteria) this;
        }

        public Criteria andContinusWinEqualTo(Integer value) {
            addCriterion("continus_win =", value, "continusWin");
            return (Criteria) this;
        }

        public Criteria andContinusWinNotEqualTo(Integer value) {
            addCriterion("continus_win <>", value, "continusWin");
            return (Criteria) this;
        }

        public Criteria andContinusWinGreaterThan(Integer value) {
            addCriterion("continus_win >", value, "continusWin");
            return (Criteria) this;
        }

        public Criteria andContinusWinGreaterThanOrEqualTo(Integer value) {
            addCriterion("continus_win >=", value, "continusWin");
            return (Criteria) this;
        }

        public Criteria andContinusWinLessThan(Integer value) {
            addCriterion("continus_win <", value, "continusWin");
            return (Criteria) this;
        }

        public Criteria andContinusWinLessThanOrEqualTo(Integer value) {
            addCriterion("continus_win <=", value, "continusWin");
            return (Criteria) this;
        }

        public Criteria andContinusWinIn(List<Integer> values) {
            addCriterion("continus_win in", values, "continusWin");
            return (Criteria) this;
        }

        public Criteria andContinusWinNotIn(List<Integer> values) {
            addCriterion("continus_win not in", values, "continusWin");
            return (Criteria) this;
        }

        public Criteria andContinusWinBetween(Integer value1, Integer value2) {
            addCriterion("continus_win between", value1, value2, "continusWin");
            return (Criteria) this;
        }

        public Criteria andContinusWinNotBetween(Integer value1, Integer value2) {
            addCriterion("continus_win not between", value1, value2, "continusWin");
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