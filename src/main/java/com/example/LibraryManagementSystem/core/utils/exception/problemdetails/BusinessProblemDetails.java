package com.example.LibraryManagementSystem.core.utils.exception.problemdetails;

public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails(String detail){
        setDetail(detail);
        setTitle("Business Rule Violation");
        setType("BusinessException");
    }
}
