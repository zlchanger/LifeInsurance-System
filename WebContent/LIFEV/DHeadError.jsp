<font class="pxError">
<% 	String error = (String)request.getAttribute("ErrMsg");
	if (error != null && error.length() > 0)
		out.println(error); %>
</font>
<font class="pxWarn">
<% 	String warn = (String)request.getAttribute("WarMsg");
	if (warn != null && warn.length() > 0)
		out.println(warn); %>
</font>