<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.mandatory-duty.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.mandatory-duty.form.label.dutyDescription" path="dutyDescription"/>
	<acme:form-moment code="authenticated.mandatory-duty.form.label.percentage" path="percentage"/>
	
	<acme:form-return code="authenticated.mandatory-duty.form.button.return"/>
	</acme:form> 

