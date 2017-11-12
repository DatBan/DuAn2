<%@ page pageEncoding="utf-8"%>
<footer class="panel-footer">
	<span><b>Copyright © 2017 <a href="#">Datban</a></b>. All rights reserved.</span>
</footer>
<!-- Link toi file jquery -->
<script src="js/jquery.min.js"></script>
 <!-- Bootstrap Js CDN -->
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap.min.js"></script>
<!-- File jquery kiem tra loi -->
<script src="js/jquery.validate.js"></script>
<script src="js/additional-methods.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			var url = window.location;
			
			//for sidebar menu entirely but not cover treeview
			$('ul.components a').filter(function() {

			return this.href == url;
			}).parent().addClass('active');
			
			//for treeview
			$('ul.components ul.collapse a').filter(function() {
				if(this.href == url){
					$(this).parent().parent().addClass('in').attr('aria-expanded', !0).siblings().attr('aria-expanded', !0);
				}
			return this.href == url;
			}).closest('.child-menu').addClass('active');
			
			//Collapse sidebar
			$('#sidebarCollapse').on('click', function(){
				$('#sidebar').toggleClass('active');
			});
			
			 $('#example').DataTable({
				 responsive: true,
				 retrieve: true
			 });
		});
	</script>
<script src="js/validate-them.js"></script>
<script src="js/custom-script.js"></script>
<script src="js/ScriptTrang.js"></script>
<script src="js/ScriptBaiViet.js"></script>
<script src="js/ScriptMonAn.js"></script>
