<%@ page pageEncoding="utf-8"%>
<base href="${pageContext.servletContext.contextPath}/"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="google-signin-client_id" content="400500533070-k8b9qaer0ndtklj1tblkrgqv2037bjd4.apps.googleusercontent.com">

<!-- Link toi file css -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" >
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" >
<link href="css/fontawesome-stars-o.css" rel="stylesheet" type="text/css" >
<link rel="stylesheet" href="css/jquery-ui.css">
<!-- tuy chinh -->
<link href="css/custom.css" rel="stylesheet" type="text/css" >


<!-- Link toi file jquery -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery-ui.js"></script>
  
<script src="js/bootstrap.min.js"></script>
<!-- File jquery kiem tra loi -->
<script src="js/jquery.barrating.min.js"></script>
<script src="js/qcTimepicker.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/ScriptDangKy.js"></script>
<script src="js/custom-script.js"></script>
<script src="js/ScriptDatBan.js"></script>
 <script>
    function start() {
      gapi.load('auth2', function() {
        auth2 = gapi.auth2.init({
          client_id: '400500533070-k8b9qaer0ndtklj1tblkrgqv2037bjd4.apps.googleusercontent.com',
          // Scopes to request in addition to 'profile' and 'email'
          //scope: 'additional_scope'
        });
      });
    }
  </script>