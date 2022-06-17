<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>MANAGER DEVICES</title>
        <link rel="stylesheet" href="css/style.css">
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');
        </style>
        <link rel="stylesheet" href="fonts/themify-icons/themify-icons.css">
        <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
              integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
        <script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>

    </head>
    <body>
        <c:set var="detailError" value="${requestScope.DETAIL_ERROR}"/>
        <c:set var="success" value="${requestScope.SUCCESS}"/>
        <c:set var="deviceList" value="${requestScope.LIST_DEVICE}"/>
        <c:choose>
            <c:when test="${detailError.getDetailNameError() != null}" >
                <div id="detailError" class="modal fade" role="dialog">
                    <div class="modal-dialog modal-lg" role="content">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><strong>${detailError.getDetailNameError()}</strong></h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:when test="${success != null}">
                <div id="success" class="modal fade" role="dialog">
                    <div class="modal-dialog modal-lg" role="content">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><strong>${success}</strong></h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
        </c:choose>

        <div class="navbar-top">
            <div class="navbar-header">
                <!-- logo -->
                <div class="col-sm-3 logo">
                    <a href="#"><img src="./img/logo.png" height="80" alt=""></a>
                </div>
                <!-- name web -->
                <div class="col-sm-6 d-flex align-items-center justify-content-center text-center name-website">
                    <a href="#">DRS - FPT University HCM</a>
                </div>
                <!-- welcome -->
                <div class="col-sm-3 welcome d-flex align-items-center justify-content-end">
                    <div class="nav-item dropdown ">
                        <a class="nav-link dropdown-toggle d-flex align-items-center user-info" href="#"
                           id="navbarDropdownMenuLink" role="button" data-toggle="dropdown">
                            <img src="https://scontent.fsgn5-11.fna.fbcdn.net/v/t1.6435-9/148200636_528659258096027_8966625421411191162_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=dzMdGh7CUt4AX978A2p&_nc_ht=scontent.fsgn5-11.fna&oh=00_AT_T8cl7XJeQ7xnVIt7NSbBeFkMmZy_8FtaihBZKvwhxjw&oe=62BB3767"
                                 class="rounded-circle" height="20">
                            <p class="user-name">Thienpnse150137</p>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li>
                                <a class="dropdown-item" href="myprofile.html">My profile</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="login.html">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="manage-navbar">
            <a href="MainController?search=&action=SearchDevice">
                <button class="btn btn-primary" name="action" type="submit" value="SearchDevice">
                    Manage Devices
                </button>
            </a>
            <a href="MainController?action=GetListWarehouse">
                <button class="btn btn-secondary">
                    Manage Warehouse
                </button>
            </a>
            <a href="insertcatagory.html">
                <button class="btn btn-secondary">
                    Manage Catagory
                </button>
            </a>
        </div>
        <div class="row manager-function d-flex align-items-center">
            <div class="col-sm-6 left-function text-center">
                <button type="button" class="btn">
                    <a class="button-insert" href="MainController?action=GetList">Insert new Devices</a>    
                </button>
                <button type="button" class="btn">
                    <div class="nav-item dropdown d-flex align-items-center">
                        <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" id="navbarDropdownMenuLink"
                           role="button" data-toggle="dropdown">
                            <label class="button-insert">Category</label>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li>
                                <a class="dropdown-item" href="#">Ram</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#">CPU</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#">VGA</a>
                            </li>
                        </ul>
                    </div>
                </button>
                <button type="button" class="btn">
                    <label for="">Filter</label>
                </button>
            </div>
            <div class="col-sm-6 right-function">
                <div class="search">
                    <form action="" id="search-box">
                        <div class="row search-box-wrapper">
                            <form action="MainController" method="POST">
                                <input type="text" id="search-text" class="col-8" placeholder="Search" name="search">
                                <button type="submit" name="action" value="SearchDevice" id="search-btn" class="col-2"><i class="fas fa-search "></i></button>
                            </form>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="table-wapper col-sm-12 container-fluid">
            <c:if test="${not empty deviceList}">
                <table class="table text-center">
                    <thead>
                        <tr>
                            <th>DeviceID</th>
                            <th>Device Name</th>
                            <th>Brand</th>
                            <th>Quantity</th>
                            <th>Description</th>
                            <th>CateID</th>
                            <th>WareHouseID</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="device" items="${deviceList}" varStatus="counter">
                            <tr>
                                <td><input type="text" class="text-center" value="${device.deviceID}"></td>
                                <td><input type="text" class="text-center" value="${device.deviceName}"></td>
                                <td><input type="text" class="text-center" value="${device.brandID}"></td>
                                <td><input type="number" class="text-center" value="${device.quantity}"></td>
                                <td><a href="#" id="fa-info-circle">
                                        <button class="btn " type="button"><i class="fas fa-info-circle"></i></button></a>
                                    <div id="detailModal" class="modal fade" role="dialog">
                                        <div class="modal-dialog modal-lg" role="content">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Details modal</h4>
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                </div>
                                                <div class="modal-body">
                                                    <form>
                                                        <div class="form-row">
                                                            <div class="form-group col-sm-12 d-flex">
                                                                <h5 class="">CPU</h5>
                                                                <label for="" class="col-sm-6 text-center">Core Intrel
                                                                    I9-12900k</label>
                                                            </div>
                                                            <div class="form-group col-sm-12 d-flex">
                                                                <h5>SSD</h5>
                                                                <label for="" class="col-sm-6">1TB</label>
                                                            </div>
                                                            <div class="form-group col-sm-12 d-flex">
                                                                <h5>RAM</h5>
                                                                <label for="" class="col-sm-6">128GB</label>
                                                            </div>
                                                            <div class="form-group col-sm-12 d-flex">
                                                                <h5>VGA</h5>
                                                                <label for="" class="col-sm-6">RTX3090</label>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td><input type="text" class="text-center" value="${device.cateID}"></td>
                                <td><input type="text" class="text-center" value="${device.warehouseID}"></td>
                                <td><button type="button" class="btn btn-dark">Delete</button></td>
                                <td><button type="button" class="btn btn-dark">Update</button></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty deviceList}">
                <h2>No result</h2>
            </c:if>

        </div>
    </body>
    <footer></footer>
    <script>
        $(document).ready(function () {
            $("#fa-info-circle").click(function () {
                $("#detailModal").modal("show");
            });
            $("#detailError").modal("show");
            $("#success").modal("show");
        });


    </script>

</html>