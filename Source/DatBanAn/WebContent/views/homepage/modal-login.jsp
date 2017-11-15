<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="https://apis.google.com/js/api:client.js"></script>
<script>
  var googleUser = {};
  var startApp = function() {
    gapi.load('auth2', function(){
      // Retrieve the singleton for the GoogleAuth library and set up the client.
      auth2 = gapi.auth2.init({
        client_id: '400500533070-k8b9qaer0ndtklj1tblkrgqv2037bjd4.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
        // Request scopes in addition to 'profile' and 'email'
        //scope: 'additional_scope'
      });
      attachSignin(document.getElementById('custom-btn'));
    });
  };

  function attachSignin(element) {
    console.log(element.id);
    auth2.attachClickHandler(element, {},
        function(googleUser) {
    	var profile = googleUser.getBasicProfile();
    	var id_token = googleUser.getAuthResponse().id_token;
		/* console.log('id token: ' + id_token); */
          /* document.getElementById('name').innerText = "Signed in: " +
              googleUser.getBasicProfile().getName(); */
          $.ajax({
  			type: "POST",
  			url: "${pageContext.servletContext.contextPath}/google-login.html",
  			data: {idtoken: id_token},
  			success: function(result){
  				console.log(result);
  				if(result == 'signedin2'){
  					$("#myModal").modal('hide');
  					location.reload();
  				}
  			},
  			error: function(error){
  				console.log("Loi "+error);
  			}
  		});
        }, function(error) {
          console.log(JSON.stringify(error, undefined, 2));
        });
  }
  
  function signOut() {
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	    });
	    
	    FB.logout(function(response) {
			  // user is now logged out
			  statusChangeCallback(response);
			  console.log("hu'");
			});
	  }
  </script>
<script>
//This is called with the results from from FB.getLoginStatus().
function statusChangeCallback(response) {
  console.log('statusChangeCallback');
  console.log(response);
  // The response object is returned with a status field that lets the
  // app know the current login status of the person.
  // Full docs on the response object can be found in the documentation
  // for FB.getLoginStatus().
  if (response.status === 'connected') {
    // Logged into your app and Facebook.
    var access_TK = '';
		  access_TK = response.authResponse.accessToken;
		
		$.ajax({
			type: "GET",
			url: "${pageContext.servletContext.contextPath}/facebook-login.html",
			data: {access_token: access_TK},
			success: function(result){
				if(result == 'signedin2'){
					$("#myModal").modal('hide');
					location.reload();
				}
			},
			error: function(error){
				console.log("Loi "+error);
			}
		});
    testAPI();
  } else {
    // The person is not logged into your app or we are unable to tell.
    console.log('Please log into this app.');
  }
}

// This function is called when someone finishes with the Login
// Button.  See the onlogin handler attached to it in the sample
// code below.
function checkLoginState() {
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });
}

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '140114096632222',/* 
    cookie     : true, */  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.10' // use graph api version 2.8
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.
  FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	  });

	};

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      console.log('Thanks for logging in, ' + response.name + '!');
    });
  }
  
  function login_fb(){
	  FB.login(function(response){
		  statusChangeCallback(response);
	  });
  }
</script>

<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Đăng nhập</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-6">
						<form:form action="login.html" method="post"
							modelAttribute="nguoidung" id="login">
							<span id="tb-loi-dn" class="error"></span>
							<div class="form-group clearfix">
								<label for="tendangnhap">Tên đăng nhập:</label>
								<form:input path="tendangnhap" class="form-control" />
							</div>
							<div class="form-group clearfix">
								<label for="matkhau">Mật khẩu:</label>
								<form:password path="matkhau" class="form-control" />
							</div>
							<div class="checkbox">
								<label><input type="checkbox" id="remember"> Ghi nhớ mật khẩu</label> 
								<label class="pull-right"><a href="#">Quên mật khẩu?</a></label>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block" id="nut-dn">Đăng
									nhập</button>
							</div>
						</form:form>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<!-- <div class="fb-login-button" data-max-rows="1" data-size="large" data-button-type="login_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="false"></div> -->
							<a class="btn btn-block btn-social btn-facebook" onclick="login_fb();">
						  		<i class="fa fa-facebook"></i> Đăng nhập với facebook
						  	</a>
						</div>
						<div class="form-group">
							<div id="my-signin2"></div>
							<div id="custom-btn" class="btn btn-block btn-social btn-google">
					  			<i class="fa fa-google"></i> Đăng nhập với Google
					  		</div>
					  		<!-- <div id="name"></div> -->
						</div>
						<div class="form-group">
							<a href="RegisterForm.html" class="btn btn-default btn-block">
								Đăng ký </a>
						</div>
						<div class="form-group">
							<button type="button" class="btn btn-default btn-block" data-dismiss="modal">Đóng</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<script>startApp();</script>
<!-- 
<script>
	function signOut() {
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	    });
	    
	    FB.logout(function(response) {
			  // user is now logged out
			  statusChangeCallback(response);
			  console.log("hu'");
			});
	  }
    function onSuccess(googleUser) {
      console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
      var profile = googleUser.getBasicProfile();
	  var id_token = googleUser.getAuthResponse().id_token;
	 /*  console.log('id token: ' + id_token);
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present. */
		$.ajax({
			type: "POST",
			url: "${pageContext.servletContext.contextPath}/google-login.html",
			data: {idtoken: id_token},
			success: function(result){
				console.log(result);
				if(result == 'signedin2'){
					$("#myModal").modal('hide');
					location.reload();
				}
			},
			error: function(error){
				console.log("Loi "+error);
			}
		});
    }
    function onFailure(error) {
      console.log(error);
    }
    function renderButton() {
      gapi.signin2.render('my-signin2', {
        'scope': 'profile email',
        'width': "auto",
        'height': 50, 
        'longtitle': true,
        'theme': 'dark',
        'onsuccess': onSuccess,
        'onfailure': onFailure
      });
    } 
  </script>
<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script> -->