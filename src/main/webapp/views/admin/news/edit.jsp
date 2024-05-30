<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtai
  Date: 5/30/24
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglist.jsp"%>
<c:url var="APIUrl" value="/admin-new-list"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {ace.settings.check('breadcrumbs', 'fix')} catch (e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa  fa-home home-icon"></i>
                    <a href="#" >Trang Chu</a>
                </li>
                <li class="active">Chinh sua bai viet</li>
            </ul>
        </div>
        <div class="page-content">
            <div class="row">
                <form>
                    <label for="title">Tieu De</label>
                    <input type="text" class="form-control" id="title" placeholder="Nhap..." value="${model.title}">
                </form>
                <br/>
                <br/>
                <form>
                    <label for="content" >Content</label>
                    <input type="text" class="form-control" id="content" value="${model.content}"/>
                </form>
                <br/>
                <br/>
                <form>
                    <select class="custom-select">
                        <option selected>Category</option>
                        <c:forEach var="category" items="${categories}">
                            <c:if test="${category.id == model.categoryId}">
                                <option value="${category.id}" selected>${category.name}</option>
                            </c:if>
                            <c:if test="${category.id != model.categoryId}">
                                <option value="${category.id}">${category.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </form>
            </div>
            <br/>
            <br/>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>

</div>
</body>
</html>
