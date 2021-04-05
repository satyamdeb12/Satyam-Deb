package com.SpringCoreAssignment.q2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question {
    private int questionId;
    private String question;
    private List<String> answersInList;
    private Set<String> answersInSet;
    private Map<Integer,String> answersInMap;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswersInList() {
        return answersInList;
    }

    public void setAnswersInList(List<String> answersInList) {
        this.answersInList = answersInList;
    }

    public Set<String> getAnswersInSet() {
        return answersInSet;
    }

    public void setAnswersInSet(Set<String> answersInSet) {
        this.answersInSet = answersInSet;
    }

    public Map<Integer, String> getAnswersInMap() {
        return answersInMap;
    }

    public void setAnswersInMap(Map<Integer, String> answersInMap) {
        this.answersInMap = answersInMap;
    }

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answersInList=" + answersInList
				+ ", answersInSet=" + answersInSet + ", answersInMap=" + answersInMap + "]";
	}
    
}
