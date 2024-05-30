<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtai
  Date: 5/27/24
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglist.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Dashboard - SB Admin</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="<c:url value="/template/admin/css/styles.css"/>" rel="stylesheet" />
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
</head>
<body class="sb-nav-fixed">
<%@include file="/common/admin/header.jsp"%>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Core</div>
                    <a class="nav-link" href="<c:url value="/decorators/admin.jsp"/>">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Dashboard
                    </a>
                    <div class="sb-sidenav-menu-heading">Interface</div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                        Layouts
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="<c:url value="/template/admin/layout-static.html"/>">Static Navigation</a>
                            <a class="nav-link" href="<c:url value="/template/admin/layout-sidenav-light.html"/>">Light Sidenav</a>
                        </nav>
                    </div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                        <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                        Pages
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                Authentication
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="<c:url value="/template/admin/login.html"/>">Login</a>
                                    <a class="nav-link" href="<c:url value="/template/admin/register.html"/>">Register</a>
                                    <a class="nav-link" href="<c:url value="/template/admin/password.html"/>">Forgot Password</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                Error
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="<c:url value="/template/admin/401.html"/>">401 Page</a>
                                    <a class="nav-link" href="<c:url value="/template/admin/404.html"/>">404 Page</a>
                                    <a class="nav-link" href="<c:url value="/template/admin/500.html"/>">500 Page</a>
                                </nav>
                            </div>
                        </nav>
                        <a href="<c:url value="/admin-new-list?type=list&page=1&maxPageItem-2"/> ">

                        </a>
                    </div>
                    <div class="sb-sidenav-menu-heading">Addons</div>
                    <a class="nav-link" href="<c:url value="/template/admin/charts.html"/>">
                        <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                        Charts
                    </a>
                    <a class="nav-link" href="<c:url value="/admin-new-list?type=list"/>">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Tables
                    </a>
                </div>
            </div>

              <c:if test="${empty USERMODEL}">
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                Start Bootstrap
            </div>
             </c:if>
            <c:if test="${not empty USERMODEL}">
                <div class="sb-sidenav-footer">
                    <div class="small">Logged in as:</
                        ${USERMODEL.userName}
                </div>
            </c:if>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <dec:body/>
        <%@include file="/common/admin/footer.jsp"%>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
<script src="<c:url value="/template/jquery.twbsPagination.js"/> " type="text/javascript" > </script>
<script src="<c:url value="/template/jquery.twbsPagination.min.js"/> " type="text/javascript" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="<c:url value="/template/admin/js/scripts.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="<c:url value="/template/admin/assets/demo/chart-area-demo.js"/>"></script>
<script src="<c:url value="/template/admin/assets/demo/chart-bar-demo.js"/>"></script>
<script src="<c:url value="/template/admin/js/simple-datatables.min.js"/>" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var currentPage = ${model.page};
    var totalPages = ${model.totalPages};
    var limit = ${model.maxPageItem};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            startPage: currentPage,
            visiblePages: limit,
            onPageClick: function (event, page) {
                if (currentPage !== page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#type').val('list');
                    $('#formsubmit').submit(); //click to change form table
                }
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>
</body>
</html>

