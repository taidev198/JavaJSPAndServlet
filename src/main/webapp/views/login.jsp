<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtai
  Date: 5/29/24
  Time: 1:53 PM
  Creating body of login jsp page;
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="layoutAuthentication">
  <div id="layoutAuthentication_content">
    <main>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
              <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
              <div class="card-body">
                <form id="formLogin" action="<c:url value="/dang-nhap"/> " method="post">
                  <div class="form-floating mb-3">
                    <input class="form-control" id="username" type="email" placeholder="name@example.com" name="username" />
                    <label for="username">Email address</label>
                  </div>
                  <div class="form-floating mb-3">
                    <input class="form-control" id="password" type="password" placeholder="Password" name="password"/>
                    <label for="password">Password</label>
                  </div>
                  <div class="form-check mb-3">
                    <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                    <label class="form-check-label" for="inputRememberPassword">Remember Password</label>
                  </div>
                  <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                    <a class="small" href="password.html">Forgot Password?</a>
                    <button class="btn btn-primary" type="submit">Login </button>
<%--                    must be in form tag--%>
                    <input type="hidden" value="login" id="action" name="action" />
                  </div>
                </form>
              </div>
              <div class="card-footer text-center py-3">
                <div class="small"><a href="<c:url value="/template/admin/register.html"/>">Need an account? Sign up!</a></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
  <div id="layoutAuthentication_footer">
    <footer class="py-4 bg-light mt-auto">
      <div class="container-fluid px-4">
        <div class="d-flex align-items-center justify-content-between small">
          <div class="text-muted">Copyright &copy; Your Website 2023</div>
          <div>
            <a href="#">Privacy Policy</a>
            &middot;
            <a href="#">Terms &amp; Conditions</a>
          </div>
        </div>
      </div>
    </footer>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="<c:url value="/template/admin/js/scripts.js"/>" ></script>
</body>
</html>
