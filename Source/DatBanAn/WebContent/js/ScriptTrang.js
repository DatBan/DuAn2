/**
 * 
 */
$(document).ready(function() {
	
	// Check ký tự đặc biệt
	$.validator.addMethod("kiemTraKyTu", function(value, element, param) {
        var reg = /[.@!#$%&'*+[]\/=?^_`{|}~]/;
        if(reg.test(value)){
              return false;
        }else{
                return true;
        }
	});
	
	$("#themtrangmoi").validate({
		
		onchange : true,
		rules : {
			tieude : {
				required : true,
				rangelength : [ 4, 50 ],
				kiemTraKyTu: true,
				remote : {
					type : "GET",
					url : "trang/kt-trung-tieude.html"

				}
			},
			slug : {
				required : true,
				rangelength : [ 4, 80 ],
				nowhitespace : true,
				remote : {
					type : "GET",
					url : "trang/kt-trung-slug.html"

				}
				

			},
			title : {
				required : true,
				rangelength : [ 4, 50 ],
				kiemTraKyTu : true,
				remote : {
					type : "GET",
					url : "trang/kt-trung-title.html"

				}
			},
			area1 : {
				required : true,
				minlength : 200
			},
			area2 : {
				required : true,
				minlength : 200
			}

		},
		messages : {
			tieude : {
				required : "Vui lòng nhập tiêu đề",
				rangelength : "Tiêu đề không hợp lệ",
				kiemTraKyTu :"Tiêu đề không được có ký tự đặc biệt",
				remote : "Trang đã tồn tại"
			},
			
			slug : {
				required : "Vui lòng nhập Slug",
				rangelength : "Slug không hợp lệ",
				nowhitespace : "Slug không được có khoảng trống",
				
			},
			title : {
				required : "invalid title",
				rangelength : "Tiêu đề không hợp lệ",
				kiemTraKyTu :"Title has not special character"
			},
			area1 : {
				required : "Vui lòng nhập nội dung",
				minlength : "Nội dung quá ngắn"
			},
			area2 : {
				required : "invalid content",
				minlength : "Content too short"
			}
		}
	});
});