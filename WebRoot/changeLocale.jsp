<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<script language="javascript">
    function changeLocale() 
    {
        document.langForm.submit();
    }
</script>
<s:set name="SESSION_LOCALE" value="#session['WW_TRANS_I18N_LOCALE']"/>
<s:bean id="localeList" name="pro.util.changeLocale">
	<s:param name="current" value="#SESSION_LOCALE==null ? locale : #SESSION_LOCALE" />
</s:bean>
<form action='<s:url />' name="langForm">
<s:text name="pro.languageSelecter" />:&nbsp;<s:select   cssStyle="width:120"
        list="#localeList.locales" listKey="value" listValue="key"
        value="#SESSION_LOCALE==null ? locale : #SESSION_LOCALE"
        name="request_locale" id="langSelecter" 
        onchange="changeLocale()" theme="simple"/>
</form>
<!-- list="#localeList.locales" listKey="value" listValue="key" -->
