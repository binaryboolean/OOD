<%-- 
    Document   : userLogin
    Created on : 6 Sep, 2016, 12:28:04 PM
    Author     : baldeep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login Page</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
    </head>
    <body>
        <img id="bg" src="<%=request.getContextPath()%>/resources/images/bg.jpg" />
        <div class="panel panel-primary col-lg-3" style="margin: 0 auto;float: none;text-align: center">
            <div class="panel-body">
                <h4>Login</h4>
                <form class="form-horizontal" name="loginForm" action="checkLogin" method="POST">
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="Email" name="email" required="" title="Enter your Email here"/>
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="password" placeholder="Password" name="password" title="Enter your Password here"/>
                    </div>
                    <input style="display: none" type="checkbox" name="remember-me" checked="" />
                    <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="Login" />
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script  src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
    <script>$(document).ready(function () {$('#bg').fadeIn('slow');});</script>
</html>
