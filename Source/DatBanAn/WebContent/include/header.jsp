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
							<i class="fa fa-phone" style="color: #e54d3f;"></i><b style="color: #e54d3f;">1900 1008</b>
						</p></li>
					<li>
						<p class="navbar-text">
							<i class="fa fa-clock-o" style="color: #1178e2;"></i><b> 7:00
								AM - 8:00 PM</b>
						</p>
					</li>
					<li class="dropdown">
						<a href="#" data-toggle="dropdown"> 
							<i class="fa fa-globe"></i> VI <span class="glyphicon glyphicon-menu-down"></span></a>
						<ul class="dropdown-menu">
							<li>
								<a href="#"><i class="glyphicon glyphicon-user"></i> EN
								</a>
							</li>
						</ul>
					</li>
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
					<a class="navbar-brand" href=""><img src="images/logo.png" /></a>
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
								var thanhpho = 'ko co';
						        $("#location-div option[selected='selected']").prop('selected', true);
						        $('#location-homepage').on("change", function () {
						        	var slug = $(this).val();
						        	var current_path = window.location.pathname;
						        	var sub_path = current_path.indexOf('/', 1);
						        	var pathname_moi = current_path.substring(0, sub_path)+'/'+slug+".html";
						        	console.log('moi ' +pathname_moi);
						        	window.location.href = pathname_moi;
						        	console.log( window.location.pathname);
						        });
						        /* $('#sl-city').hover(function () 

{
						            $(this).css('cursor', 'pointer');
						        }); */     
						        
						        /*$('#location-homepage').trigger("change");*/
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
								<li class="dropdown">
									<a href="#" data-toggle="dropdown">Welcome, ${sessionScope.nd.hoTen} <span class="glyphicon glyphicon-menu-down"></span>
									</a>
									<ul class="dropdown-menu">
										<c:if test="${sessionScope.nd.quyennd.id==1}">
										<li>
											<a href="dashboard/index.html"><i class="glyphicon glyphicon-user"></i>	Trang quản trị</a>
										</li>
										</c:if>
										<c:if test="${sessionScope.nd.quyennd.id==2}">
										<li>
											<a href="dashboard/nhahang/hoadon/index.html"><i class="glyphicon glyphicon-user"></i>	Trang quản trị</a>
										</li>
										</c:if>
										<c:if test="${sessionScope.nd.quyennd.id==3}">
										<li>
											<a href="nguoidung/baiviet/index.html"><i class="glyphicon glyphicon-user"></i>	Trang quản trị</a>
										</li>
										</c:if>
										<li>
											<a href="thongtincanhan.html?hienthi&id=${sessionScope.nd.id}"><i class="glyphicon glyphicon-user"></i> Thông tin tài khoản</a>
										</li>
										<li class="divider"></li>
										<li><a href="logout.html" onclick="signOut();"><i class="fa fa-sign-out"></i>Thoát</a></li>
									</ul>
								</li>
							</c:otherwise>
						</c:choose>
						<li>
							<a href="#" class="btn btn-warning" style="padding-top: 6px; padding-left: 10px; padding-bottom: 6px; padding-right: 10px; margin-top: 9px; color: white;font-size: 15px; background-color: #f0ad4e; border: none;"><b>Đặt bàn</b></a>
						</li>
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
        var geocoder = new google.maps.Geocoder;
     	// Try HTML5 geolocation.
     	if (navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(function(position) {
	            var pos = {
	              lat: position.coords.latitude,
	              lng: position.coords.longitude
	            };
				geocodeLatLng(geocoder, pos);
	          }, showError);
     	} else { 
            console.log("Geolocation is not supported by this browser.");
        }
      }

      function geocodeLatLng(geocoder, pos) {
    	  
        geocoder.geocode({'location': pos}, function(results, status) {
          if (status === 'OK') {
            if (results[0]) {
             
              console.log(results[0]);
              var lalala = results[0].address_components;
              var lelele = $(lalala);
              var thanhpho = '';
              for(var i = 0; i < lalala.length; i++){
            	  if((lelele[i]).types[0] == 'administrative_area_level_1'){
            		  thanhpho = (lelele[i]).long_name;
            	  }
              }
              thanhpho = results[0].address_components[6].long_name;
              
	      		$.ajax({
	      			url: "location/switch.html",
	      			type: "POST",
	      			data: {thanhpho: thanhpho},
	      			dataType: "json",
	      			success: function(result){
	      				console.log(result);
	      				status_location = result.status;
	      				console.log(status);
	      				if(result.status == 'co' && result.status_ck != 'daghi'){
	      					window.location.href = result.provinceslug+'.html';
	      				}
	      			},
	      			error: function(error){
	      				console.log(error);
	      			}
	      		});
            } else {
              console.log('No results found');
            }
          } else {
            console.log('Geocoder failed due to: ' + status);
          }
        });
      }
      
      function showError(error) {
    	 	 var coloi = '0';
    	    switch(error.code) {
    	        case error.PERMISSION_DENIED:
    	        	console.log("User denied the request for Geolocation.");
    	        	coloi = '1';
    	            break;
    	        case error.POSITION_UNAVAILABLE:
    	        	console.log("Location information is unavailable.");
    	        	coloi = '1';
    	            break;
    	        case error.TIMEOUT:
    	        	console.log("The request to get user location timed out.");
    	        	coloi = '1';
    	            break;
    	        case error.UNKNOWN_ERROR:
    	        	console.log("An unknown error occurred.");
    	        	coloi = '1';
    	            break;
    	    }
    	    if(coloi == '1'){
	    	    $.ajax({
	      			url: "location/remove-cookie.html",
	      			type: "POST",
	      			dataType: "json",
	      			success: function(result){
	      				console.log(result);
	      			},
	      			error: function(error){
	      				console.log(error);
	      			}
	      		});
    	    }
    	}
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA9luxjN2MQFR3SJY-obplEq7An6PkEcO4&callback=initMap">
    </script>