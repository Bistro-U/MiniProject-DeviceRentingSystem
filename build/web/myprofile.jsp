<%-- 
    Document   : myprofile
    Created on : Jun 8, 2022, 8:23:48 AM
    Author     : Trung Duong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>My Profile</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');
        </style>
        <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="themify-icons/themify-icons.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
              integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
        <script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    </head>
    <body>

        <!-- navbar -->
        <div class="row navbar">
            <!-- logo -->
            <div class="col-sm-4 navbar-user-left d-flex align-items-center">
                <div class="col-sm-6 logo">
                    <a href="getAllAccount"><img src="./img/logo.png" height="80" alt=""></a>
                </div>
                <!-- product-list -->
                <div class="col-sm-6">
<!--                    <div class="nav-item dropdown ">
                        <a class="nav-link dropdown-toggle d-flex align-items-center justify-content-center user-info" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown">
                            <p class="product-list">Product</p>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li>
                                <a class="dropdown-item" href="#">Laptop</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#">Camera</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#">Graphic Tablet</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#">Tablet</a>
                            </li>
                        </ul>
                    </div>-->
                </div>
            </div>
            <div class="col-sm-4 text-center navbar-user-fill">

            </div>
            <!-- card-icon -->
            <div class="col-sm-4 text-center navbar-user-right d-flex">
                <div class="col-sm-6">
                </div>
                <!-- welcome -->
                <div class="col-sm-6">
                    <div class="nav-item dropdown ">
                        <a class="nav-link dropdown-toggle d-flex align-items-center justify-content-center user-info" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown">
                            <img
                                src="${sessionScope.Admin.picture}" class="rounded-circle" height="25">
                            <p class="user-name">${sessionScope.Admin.name}</p>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li>
                                <a class="dropdown-item" href="#">My profile</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="MainController?action=Logout">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-10 profile-wapper">
                    <div class="col-sm-12 profile-form">
                        <div class="text-center">
                            <img class="col-sm-2" src="${sessionScope.Admin.picture}" height="95" alt="">
                            <label class="user-name-profile"><h2>${sessionScope.AdminDB.userName}</h2></label>
                        </div>
                        <form action="MainController" method="POST">
                            <div class="col-sm-12 text-center mt-3">
                                <label for="#" class="col-sm-3"><h5>Name</h5></label>
                                <input type="text" class="form-outline col-sm-5" name="userName" value="${sessionScope.AdminDB.userName}" id="profile-info" placeholder="Phạm Ngọc Thiện">
                            </div>
                            <div class="col-sm-12 text-center">
                                <label for="#" class="col-sm-3"><h5>User ID</h5></label>
                                <input type="text" class="form-outline col-sm-5" name="userID" readonly="" value="${sessionScope.AdminDB.userID}" id="profile-info" placeholder="ID">
                            </div>
                            <div class="col-sm-12 text-center">
                                <label for="#" class="col-sm-3"><h5>Position</h5></label>
                                <input type="text" class="form-outline col-sm-5" readonly="" value="${sessionScope.AdminDB.position}" id="profile-info" placeholder="Position">
                            </div>
                            <div class="col-sm-12 text-center">
                                <label for="#" class="col-sm-3"><h5>Email</h5></label>
                                <input type="text" class="form-outline col-sm-5" readonly="" value="${sessionScope.Admin.email}" id="profile-info">
                            </div>
                            <div class="col-sm-12 text-center">
                                <label for="#" class="col-sm-3"><h5>Phone</h5></label>
                                <input type="number" class="form-outline col-sm-5" name="userPhone" value="${sessionScope.AdminDB.phone}" id="profile-info" placeholder="Your number">
                            </div>
                            <input type="hidden" name="action" value="UpdateProfile"/>
                            <button type="submit" class="btn btn-primary btn-block mb-4 col-sm-2 float-sm-right">Update</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" name="errorName" value="${requestScope.errorName}" id="errorName"/>
        <input type="hidden" name="errorPhone" value="${requestScope.errorPhone}" id="errorPhone"/>
        <input type="hidden" name="MESSAGE" value="${requestScope.MESSAGE}" id="MESSAGE"/>
        <script>
            var errorName = document.getElementById("errorName").value;
            var errorPhone = document.getElementById("errorPhone").value;
            if (errorName !== "" || errorPhone !== "")
                alert(errorName + "\n" + errorPhone);
        </script>
        <script>
            var MESSAGE = document.getElementById("MESSAGE").value;
            if (MESSAGE !== "")
                alert(MESSAGE);
        </script>
    </body>
</html>
