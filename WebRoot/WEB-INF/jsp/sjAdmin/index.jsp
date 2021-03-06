<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/commons/taglibs.jsp" %>
<!doctype html>
<html class="no-js fixed-layout">
<head>
    <%@ include file="include/inc_comm_metalink.jsp" %>
    <%@ include file="include/inc_comm_script.jsp" %>
</head>

<body>
<%-- 头部导航 --%>
<header class="am-topbar am-topbar-inverse admin-header">
    <%@ include file="include/inc_comm_header.jsp" %>
</header>
<%-- 头部导航 end --%>

<div class="am-cf admin-main">
    <%-- 左侧菜单 --%>
    <%@ include file="include/inc_comm_left.jsp" %>
    <%-- 左侧菜单 end --%>

    <%-- 主体内容 --%>
    <div id="admin-content_div" class="admin-content">
        <%-- 展示内容 --%>
        <div id="content_bady_area_0" class="admin-content-body">
            <script type="text/javascript">
                $(function () {
                    func_reload_page("${ctx}${sjIndexUrl}");
                });
            </script>
        </div>
        <%-- 展示内容 end --%>

        <%-- 底部链接 --%>
        <%@ include file="include/inc_comm_footer.jsp" %>
        <%-- 底部链接 end --%>
    </div>
    <%-- 主体内容 end --%>
</div>
<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
   data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
</body>
</html>
