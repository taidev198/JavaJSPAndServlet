<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtai
  Date: 5/30/24
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglist.jsp"%>
<c:url var="APIUrl" value="/api-admin-news"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
<%--            <script type="text/javascript">--%>
<%--                try {ace.settings.check('breadcrumbs', 'fix')} catch (e){}--%>
<%--            </script>--%>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa  fa-home home-icon"></i>
                    <a href="#" >Trang Chu</a>
                </li>
                <li class="active">Chinh sua bai viet</li>
            </ul>
        </div>
        <div class="page-content">
<%--            <c:url value="/admin-new-list"  var="listUrl">--%>
<%--                <c:param name="type" value="list"/>--%>
<%--                <c:param name="page" value="${model.page}"/>--%>
<%--                <c:param name="maxPageItem" value="${model.maxPageItem}"/>--%>
<%--            </c:url>--%>
            <form id="formSubmit">
            <div class="row">
                <div class="form-group">
                    <label for="title">Tieu De</label>
                    <input type="text" class="form-control" id="title" placeholder="Nhap..." value="${model.title}" name="title"/>
                </div>
                <br/>
                <br/>
                <div class="form-group">
                    <label for="content" >Content</label>
                    <input type="text" class="form-control" id="content" value="${model.content}" name="content"/>
                </div>
                <br/>
                <br/>
                <div class="form-group">
                    <select class="custom-select" name="categoryId" id="selectForm">
                        <option value="-1" selected>Category</option>
                        <c:forEach var="category" items="${categories}">
<%--                            option 1--%>
                            <c:if test="${category.id == model.categoryId}" >
                                <option value="${category.id}" selected = 'selected' name="categoryId">${category.name}</option>
                            </c:if>
                            <c:if test="${category.id != model.categoryId}">
                                <option value="${category.id}">${category.name}</option>
                            </c:if>
<%--                            option 2--%>
<%--                            <option value="${category.id}" <c:if test="${category.id == model.categoryId}">--%>
<%--                                selected ="selected" </c:if>>--%>
<%--                                ${category.name}--%>
<%--                            </option>--%>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <br/>
            <br/>
             <div class="form-group">
                 <button type="button" class="btn btn-primary" id="submitBtn" value="">Submit</button>
             </div>
                        <input type="hidden" value="${model.id}" id="id" name="id" />
                        <input type="hidden" value="${model.categoryId}" id="Cateid" />
            </form>
        </div>
    </div>

</div>
</body>
</html>
