<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container con">
	<!-- Menu top top top -->
	<div class="row menu-top">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li class="active"><a href="datban/thongtin.html"><b>Thông tin bàn ăn</b></a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><p class="navbar-text">
							<i class="fa fa-phone" style="color: #e54d3f;"></i><b
								style="color: #e54d3f;"> 1900 1008</b>
						</p></li>
					<li>
						<p class="navbar-text">
							<i class="fa fa-clock-o" style="color: #1178e2;"></i><b> 7:00
								AM - 8:00 PM</b>
						</p>
					</li>
					<li class="dropdown"><a href="#" data-toggle="dropdown"> <i
							class="fa fa-globe"></i> VI <span
							class="glyphicon glyphicon-menu-down"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="glyphicon glyphicon-user"></i>
									EN</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</div>
	<!-- menu chinh, logo -->
	<div class="row menu-chinh">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="trang-chu.html"><img
						src="images/logo.png" /></a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<form class="navbar-form navbar-left">
						<div class="form-group" id="location-div">
							<select class="form-control" id="location-homepage">
								<c:forEach items="${dropdown_province}" var="dp">
									<c:if test="${dp[0] == current_province}">
										<option value="${dp[0]}" selected="selected">${dp[1]}</option>
									</c:if>
									<c:if test="${dp[0] != current_province}">
										<option value="${dp[0]}">${dp[1]}</option>
									</c:if>
								</c:forEach>
							</select>
							<script>
						        $("#location-div option[selected='selected']").prop('selected', true);
						        $('#location-homepage').on("change", function () {
						        	var slug = $(this).val();
						        	var pathname_moi = $('#location-homepage').val()+".html";
						        	if(window.location.pathname != '/'+pathname_moi){
						        		console.log(pathname_moi);
						        		$.ajax({
						        			url: "location/switch.html",
						        			type: "POST",
						        			data: {provinceslug: slug},
						        			dataType: "json",
						        			success: function(result){
						        				console.log(result);
						        			},
						        			error: function(error){
						        				console.log(error);
						        			}
						        		});
						        		window.location.href = pathname_moi;
						        	}
						            
						            console.log( window.location.pathname);
						        });
						        $('#sl-city').hover(function () {
						            $(this).css('cursor', 'pointer');
						        });      
						    </script>
						</div>
					</form>
					<ul class="nav navbar-nav">
						<li><a href="${current_province}/nha-hang-khuyen-mai.html"><b>Khuyến mãi</b></a></li>
						<li><a href="bai-viet.html"><b>Bài viết</b></a></li>
						<li><a href="#"><b>Trợ giúp</b></a></li>
						<c:forEach var="t" items="${trang}">
							<li><a href="#">${t.tieude}</a></li>
						</c:forEach>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${sessionScope.nd == null}">
								<li>
									<a href="javascript:;" class="linkdangnhap" data-toggle="modal" data-target="#myModal"> 
										<b>Đăng nhập</b>
									</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="dropdown"><a href="#" data-toggle="dropdown">Welcome,
										${sessionScope.nd.hoTen} <span class="glyphicon glyphicon-menu-down"></span>
								</a>
									<ul class="dropdown-menu">
										<li>
											<a href="dashboard/index.html"><i class="glyphicon glyphicon-user"></i>
												Trang quản trị</a>
										</li>
										<li>
											<a href="dashboard/user-management.html?thongtincanhan&id=${sessionScope.nd.id}"><i class="glyphicon glyphicon-user"></i>
												Thông tin tài khoản</a>
										</li>
										<li class="divider"></li>
										<li><a href="logout.html" onclick="signOut();"><i class="fa fa-sign-out"></i>Thoát</a></li>
									</ul></li>
							</c:otherwise>
						</c:choose>
						<li><a href="#" class="btn btn-warning  "
							style="padding-top: 6px; padding-left: 10px; padding-bottom: 6px; padding-right: 10px; margin-top: 9px; color: white; font-size: 15px; background-color: #f0ad4e; border: none;"><b>Đặt
									bàn</b></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>
<script src="js/tinhthanh-dropdown.js"></script>
<jsp:include page="/views/modals/modal-login.jsp"></jsp:include>
<script>
      function initMap() {
       /*  var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 8,
          center: {lat: 40.731, lng: -73.997}
        }); */
        var geocoder = new google.maps.Geocoder;
        /* var infowindow = new google.maps.InfoWindow; */
        /* document.getElementById('submit').addEventListener('click', function() {
          geocodeLatLng(geocoder, map, infowindow);
        }); */
     	// Try HTML5 geolocation.
        navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
			console.log(position);
			geocodeLatLng(geocoder, pos);
			/* infowindow.setPosition(pos);
			infowindow.setContent('Location found.');
			infowindow.open(map);
            map.setCenter(pos); */
          });
      }

      function geocodeLatLng(geocoder, pos) {
        /* var input = document.getElementById('latlng').value;
        var latlngStr = input.split(',', 2);
        console.log('latlngStr '+latlngStr);
        var latlng = {lat: parseFloat(latlngStr[0]), lng: parseFloat(latlngStr[1])};
        console.log(latlng); */
        geocoder.geocode({'location': pos}, function(results, status) {
        	console.log(status);
          if (status === 'OK') {
            if (results[0]) {
              /* map.setZoom(11);
              var marker = new google.maps.Marker({
                position: pos,
                map: map
              }); */
              console.log(results[0]);
              console.log(results[0].address_components[5]);
              /* infowindow.setContent(results[0].formatted_address); */
              /* infowindow.open(map, marker); */
              /*$('#location-homepage').trigger('change');*/
            } else {
              console.log('No results found');
            }
          } else {
            console.log('Geocoder failed due to: ' + status);
          }
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA9luxjN2MQFR3SJY-obplEq7An6PkEcO4&callback=initMap">
    </script>