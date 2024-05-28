<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtai
  Date: 5/28/24
  Time: 6:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglist.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--get method will go int doget method controller--%>
<main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Tables</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                <li class="breadcrumb-item active">Tables</li>
            </ol>
            <div class="card mb-4">
                <div class="card-body">
                    DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the
                    <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                    .
                </div>
            </div>
<%--            <form action="<c:url value="/admin-new-list"/> " id = "formsubmit" method="get">--%>

            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    DataTable Example
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Position</th>
                            <th>Office</th>
                            <th>Age</th>
                            <th>Start date</th>
                            <th>Salary</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Name</th>
                            <th>Position</th>
                            <th>Office</th>
                            <th>Age</th>
                            <th>Start date</th>
                            <th>Salary</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="item" items="${model.listModels}" >
                            <tr>
                                <td>${item.title}</td>
                                    <%--                        <td>${item.content}</td>--%>
                                    <%--                        <td>${item.description}</td>--%>
                                    <%--                        <td>${item.title}</td>--%>
                                    <%--                        <td>${item.title}</td>--%>
                                    <%--                            <td>nguyen thanh tai</td>--%>
                                    <%--                            <td>nguyen thanh tai</td>--%>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul class="pagination" id="pagination"></ul>
<%--                    <input type="hidden" value="" id="page" name="pageName" />--%>
<%--                    <input type="hidden" value="" id="maxPageItem" name="maxPageItemName" />--%>
                </div>
            </div>
<%--            </form>--%>
        </div>
</main>
