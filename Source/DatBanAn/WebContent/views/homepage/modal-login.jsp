<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
								<label><input type="checkbox" name="remember"
									value="true"> Ghi nhớ mật khẩu</label> <label
									class="pull-right"><a href="#">Quên mật khẩu?</a></label>
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block" id="nut-dn">Đăng
									nhập</button>
							</div>
						</form:form>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="fb-login-button" data-max-rows="1" data-size="large" data-button-type="login_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="false"></div>
						</div>
						<div class="form-group">
							<div id="my-signin2"></div>
							<!-- <div class="g-signin2" data-onsuccess="onSignIn"></div> -->
							<a href="#" onclick="signOut();">Sign out</a>
							<!-- <a href="#" class="btn btn-default btn-block"> <i
								class="fa fa-google-plus-square"
								style="font-size: large; color: #c23321;"></i> Đăng nhập với
								Google
							</a> -->
						</div>
						<div class="form-group">
							<a href="RegisterForm.html" class="btn btn-default btn-block">
								Đăng ký </a>
						</div>
						<div class="form-group">
							<button type="button" class="btn btn-default btn-block"
								data-dismiss="modal">Đóng</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.10&appId=140114096632222';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<script>
$(document).ready(function(){
	// This is called with the results from from FB.getLoginStatus().
	  function statusChangeCallback(response) {
	    console.log('statusChangeCallback');
	    console.log(response);
	    // The response object is returned with a status field that lets the
	    // app know the current login status of the person.
	    // Full docs on the response object can be found in the documentation
	    // for FB.getLoginStatus().
	    if (response.status === 'connected') {
	      // Logged into your app and Facebook.
	      testAPI();
	    } else {
	      // The person is not logged into your app or we are unable to tell.
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into this app.';
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
	  
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '140114096632222',
      cookie	: true,
      xfbml      : true,
      version    : 'v2.10'
    });
  };
	
//Load the SDK asynchronously
  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
   
//Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }
});

	function signOut() {
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	    });
	  } 
</script>
<script>
    function onSuccess(googleUser) {
      console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
      var profile = googleUser.getBasicProfile();
	  var id_token = googleUser.getAuthResponse().id_token;
	  console.log('id token: ' + id_token);
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'lay-token.html', true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.onload = function() {	
		if(xhr.responseText == 'signedin2'){
			window.location.href= 'trang-chu.html';
		}
	  console.log('Signed in as: ' + xhr.responseText + ' zz ' +xhr.responseURL);
	};
	xhr.send('idtoken=' + id_token);
    }
    function onFailure(error) {
      console.log(error);
    }
    function renderButton() {
      gapi.signin2.render('my-signin2', {
        'scope': 'profile email',
        'width': 240,
        'height': 50,
        'longtitle': true,
        'theme': 'dark',
        'onsuccess': onSuccess,
        'onfailure': onFailure
      });
    } 
  </script>
<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>