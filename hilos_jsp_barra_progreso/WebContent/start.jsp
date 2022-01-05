<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% session.removeAttribute("task"); %>

<jsp:useBean id="task" scope="session" class="com.ricardo.hilos.TaskBean"/>

<% task.setRunning(true); %>

<% new Thread(task).start(); %>

<jsp:forward page="status.jsp"/>