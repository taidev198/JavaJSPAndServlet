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
                </div>

            </div>
            <table>
            <form action="<c:url value="/admin-new-list?type=list&page=1&maxPageItem=2"/> " id = "formsubmit" method="get">

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
                            <th>THAO TAC</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Name</th>
                            <th>Position</th>
                            <th>Office</th>
                            <th>Age</th>
                            <th>THAO TAC</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="item" items="${model.listModels}" >
                            <tr>
                                <td>${item.content}</td>
                                <td>${item.content}</td>
                                <td>${item.title}</td>
                                <td>${item.title}</td>
                                <td>
                                    <c:url value="/admin-new-list"  var="editUrl">
                                        <c:param name="type" value="edit"/>
                                        <c:param name="id" value="${item.id}"/>
                                        <c:param name="page" value="${model.page}"/>
                                        <c:param name="maxPageItem" value="${model.maxPageItem}"/>
                                    </c:url>
                                    <a  class="btn btn-default btn-sm" href="${editUrl}">
                                        <span class="glyphicon glyphicon-edit"></span> Edit
                                    </a>
                                </td>
                                <td>
                                    <c:url value="/admin-new-list"  var="editUrl1">
                                        <c:param name="type" value="edit"/>
                                        <c:param name="id" value="${item.id}"/>
                                        <c:param name="page" value="${item.page}"/>
                                        <c:param name="maxPageItem" value="${item.maxPageItem}"/>
                                    </c:url>
                                    <a flag="info"
                                       class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                       title="Them bai viet" href="${editUrl1}">
                                    <span>
                                        <i class="fa fa-plus-circle bigger-110 purple"></i>
                                    </span>
                                    </a>
                                </td>
                                <td>
                                    <button id="buttonDelete"
                                            class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                            title="Xoa bai viet" href="<c:url value="/admin-new-list?type=edit"/> ">
                                    <span>
                                        <i class="fa fa-plus-circle bigger-110 purple"></i>
                                    </span>
                                </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul class="pagination" id="pagination"></ul>
                    <input type="hidden" value="1" id="page" name="page" />
                    <input type="hidden" value="2" id="maxPageItem" name="maxPageItem" />
                    <input type="hidden" value="list" id="type" name="type" />
                </div>
            </div>
            </form>
            </table>
        </div>
</main>
