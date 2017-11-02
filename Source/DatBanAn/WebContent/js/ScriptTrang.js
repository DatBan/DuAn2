/**
 * 
 */
$(document).ready(function() {
	
	
	
	$("#themtrangmoi").validate({
		
		onchange : true,
		rules : {
			tieude : {
				required : true,
				rangelength : [ 4, 50 ],				
			},
			slug : {
				required : true,
				rangelength : [ 4, 80 ],
				nowhitespace : true,
				alphanumeric : true

			},
			title : {
				required : true,
				rangelength : [ 4, 50 ],				
			},
			noidung : {
				required : true,
				minlength : 200
			},
			content : {
				required : true,
				minlength : 200
			}

		},
		messages : {
			tieude : {
				required : "Vui lòng nhập tiêu đề",
				rangelength : "Tiêu đề không hợp lệ"
			},
			
			slug : {
				required : "Vui lòng nhập Slug",
				rangelength : "Slug không hợp lệ",
				nowhitespace : "Slug không được có khoảng trống",
				alphanumeric : "Slug viết thường không dấu"
			},
			title : {
				required : "invalid title",
				rangelength : "Tiêu đề không hợp lệ"
			},
			noidung : {
				required : "Vui lòng nhập nội dung",
				minlength : "Nội dung quá ngắn"
			},
			content : {
				required : "invalid content",
				minlength : "Nội dung quá ngắn"
			}
		}
	});
});