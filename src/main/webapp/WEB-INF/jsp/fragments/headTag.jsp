<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Spring Security POC</title>


    <spring:url value="/webjars/bootstrap/2.3.0/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    
<%--     <spring:url value="/webjars/bootstrap/2.3.0/css/bootstrap-responsive.min.css" var="bootstrap-responsiveCss"/> --%>
<%--     <link href="${bootstrap-responsiveCss}" rel="stylesheet"/> --%>

    <spring:url value="/webjars/jquery/2.0.3/jquery.min.js" var="jQuery"/>
    <script src="${jQuery}"></script>
    
	<spring:url value="/webjars/bootstrap/2.3.0/js/bootstrap.min.js" var="bootstrapJS"/>
    <script src="${bootstrapJS}"></script>
	
	<!-- jquery-ui.js file is really big so we only load what we need instead of loading everything -->
    <spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.core.js" var="jQueryUiCore"/>
    <script src="${jQueryUiCore}"></script>

	<spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.datepicker.js" var="jQueryUiDatePicker"/>
    <script src="${jQueryUiDatePicker}"></script>
    
    <!-- jquery-ui.css file is not that big so we can afford to load it -->
<%--     <spring:url value="/webjars/jquery-ui/1.10.3/themes/base/jquery-ui.css" var="jQueryUiCss"/> --%>
<%--     <link href="${jQueryUiCss}" rel="stylesheet"></link> --%>
    
     <spring:url value="/resources/css/common.css" var="commonCss"/>
    <link href="${commonCss}" rel="stylesheet"/>
    
   	<spring:url value="/resources/js/jquery.validate.min.js" var="validateJs"/>
    <script src="${validateJs}"></script>
    
   	<spring:url value="/resources/js/classRules.js" var="classRulesJs"/>
    <script src="${classRulesJs}"></script>
    
    <spring:url value="/resources/css/bootstrap-theme.min.css" var="btstrpminCss"/>
    <link href="${btstrpminCss}" rel="stylesheet"/>
</head>