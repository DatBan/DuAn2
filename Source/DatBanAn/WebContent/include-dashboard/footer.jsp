<%@ page pageEncoding="utf-8"%>
<footer class="panel-footer">
	<span><b>Copyright © 2017 <a href="#">Datban</a></b>. All rights reserved.</span>
</footer>
<script src="js/jquery-ui.js"></script>


 <!-- Bootstrap Js CDN -->
 
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap.min.js"></script>
<!-- File jquery kiem tra loi -->
<script src="js/qcTimepicker.js"></script>
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
<script src="js/ScriptTienIch.js"></script>
<script src="js/ScriptAmThuc.js"></script>
<script src="js/ScriptKhuyenMai.js"></script>
<script src="js/ScriptBan.js"></script>
<script src="js/ScriptDatBan.js"></script>
<script src="js/quanly-Nhahang.js"></script>
<script src="js/add-user.js"></script>
