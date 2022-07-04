<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Devices</title>
        <link rel="stylesheet" href="css/style.css" />
        <style>
            @import url("https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap");
        </style>
        <link rel="stylesheet" href="fonts/themify-icons/themify-icons.css" />
        <link rel="icon" href="./img/word-image-1047.jpg" type="image/x-icon" />
        <link
            rel="stylesheet"
            href="node_modules/bootstrap/dist/css/bootstrap.min.css"
            />
        <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
            integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
            crossorigin="anonymous"
            />
        <script src="node_modules/jquery/dist/jquery.slim.min.js"></script>
        <script src="node_modules/popper.js/dist/umd/popper.min.js"></script>
        <script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    </head>

    <body>
        <c:set var="descriptionList" value="${requestScope.DESCRIPTION_LIST}"/>
        <!-- nabar -->
        <div class="row navbar">
            <!-- logo -->
            <div class="col-sm-4 navbar-user-left d-flex align-items-center">
                <div class="col-sm-5 logo">
                    <a href="#"><img src="./img/logo.png" height="80" alt="" /></a>
                </div>
                <!-- product-list -->
                <div class="">
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle d-flex align-items-center justify-content-center user-info" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown">
                            <p class="product-list">Product</p>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li>
                                <a class="dropdown-item" href="userproduct.html">Laptop</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="userproduct.html">Camera</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="userproduct.html">Graphic Tablet</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="userproduct.html">Tablet</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="userproduct.html">All Product</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 text-center navbar-user-fill"></div>
            <!-- card-icon -->
            <div class="col-sm-4 text-center navbar-user-right d-flex">
                <div class="col-sm-6 card-shopping">
                    <a href="card.html" role="button">
                        <i class="fas fa-shopping-cart text-dark ml-5 mt-2"></i>
                    </a>
                </div>
                <!-- welcome -->
                <div class="col-sm-6">
                    <div class="nav-item dropdown align-items-center">
                        <a class="nav-link dropdown-toggle d-flex align-items-center justify-content-center user-info" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown">
                            <img src="https://scontent.fsgn5-11.fna.fbcdn.net/v/t1.6435-9/148200636_528659258096027_8966625421411191162_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=dzMdGh7CUt4AX978A2p&_nc_ht=scontent.fsgn5-11.fna&oh=00_AT_T8cl7XJeQ7xnVIt7NSbBeFkMmZy_8FtaihBZKvwhxjw&oe=62BB3767" class="rounded-circle" height="25"/>
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
    </div>
    <div class="detail-devices-wapper d-flex row">
        <div class="col-sm-7 order-first">
            <img class="img-devices" src="img/macbook.png" id="main-img">
            <div class="col-sm-12 ml-5">
                <p>
                    <img class="img-many" src="img/macbook.png">
                    <img class="img-many" src="img/macbook1.png">
                    <img class="img-many" src="img/macbook2.png">
                    <img class="img-many" src="img/macbook3.png">
                </p>
            </div>
        </div>
        <div class="row detail-devices col-sm-5 mt-5">
            <div class="divices-name col-sm-12 mt-5">
                <h2>MacBook Pro Bla Bla Bla</h2>
                <br/>
            </div>
            <div class="col-sm-12">
                <p>Device Name : ${requestScope.DEVICE_NAME}</p>
                <p>Warehouse : ${requestScope.WAREHOUSE_NAME}</p>
                <p>Brand Name : ${requestScope.BRAND_NAME}</p>
                <p>Quantity : ${requestScope.QUANTITY}</p>
                <div class="buttons_added">
                    <p>Amount: </p>
                    <input class="minus is-form ml-3" type="button" value="-">
                    <input aria-label="quantity" class="input-qty" max="100" min="1" name="" type="number" value="1">
                    <input class="plus is-form" type="button" value="+">
                </div>
                </span>
                <div class="col-sm-12 mt-5">
                    <button class="rent-button"><i class="fas fa-shopping-cart"> Add to Card</i></button>
                    <button class="rent-button-1">Rent Now</button>
                </div> 
            </div>
        </div>
        <div class="col-sm-12">
            <h2 class="ml-5 mt-5">PRODUCT DESCRIPTION</h2>
            <div class="ml-5">
                <c:forEach var="detail" items="${requestScope.DETAIL_LIST}" varStatus="counter">
                    <p>${descriptionList[counter.count-1]}: ${detail.value}</p>
                </c:forEach>
            </div>
        </div>
        <div class="col-sm-12">

        </div>
    </div>

    <footer></footer>
    <script>
                $('input.input-qty').each(function() {
        var $this = $(this),
                qty = $this.parent().find('.is-form'),
                min = Number($this.attr('min')),
                max = Number($this.attr('max'))
                if (min == 0) {
        var d = 0
        } else d = min
                $(qty).on('click', function() {
        if ($(this).hasClass('minus')) {
        if (d > min) d += - 1
        } else if ($(this).hasClass('plus')) {
        var x = Number($this.val()) + 1
                if (x <= max) d += 1
        }
        $this.attr('value', d).val(d)
        })
        })
                $(() = > {
                $('p img').click(function(){
                let imgPatch = $(this).attr('src');
                        $('#main-img').attr('src', imgPatch);
                })
                })
    </script>
</body>
</html>
