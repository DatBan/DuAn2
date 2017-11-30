<%
	String view = request.getParameter("view");

	if (view.startsWith("dashboard/")) {
		pageContext.forward("admin-layout.jsp");
	} else if (view.startsWith("homepage/")) {
		pageContext.forward("home-layout.jsp");
	} else if (view.startsWith("user/")) {
		pageContext.forward("admin-layout.jsp");
	}else if (view.startsWith("nhahang/")) {
		pageContext.forward("admin-layout.jsp");
	}
%>