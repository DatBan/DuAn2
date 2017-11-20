/**
 * 
 */
function change_alias(alias) {
		var str = alias;
		str = str.toLowerCase();
		str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
		str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
		str = str.replace(/ì|í|ị|ỉ|ĩ/g, "i");
		str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
		str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
		str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
		str = str.replace(/đ/g, "d");
		str = str.replace(/!|@|%|\^|\*|\(|\)|\+|\=|\<|\>|\?|\/|,|\.|\:|\;|\'| |\"|\&|\#|\[|\]|~|$|_/g,"-");
		/* tìm và thay thế các kí tự đặc biệt trong chuỗi sang kí tự - */
		str = str.replace(/-+-/g, "-"); // thay thế 2- thành 1-
		str = str.replace(/^\-+|\-+$/g, "");
		// cắt bỏ ký tự - ở đầu và cuối chuỗi
		return str;
	}
$(document).ready(function() {
	//Đổi sang slug
	var tieuDe = document.getElementById('tieude');
	if(tieuDe != null){
		tieuDe.addEventListener('change', function() {
			var permalink = document.getElementById('slug');
			doiPermarlink(tieuDe.value, permalink);
		});
	}
	
	function doiPermarlink(tieude, permalink) {
		permalink.value = change_alias(tieude);
	}
	
	//Hàm Preview ảnh trước khi upload
	var thumbnail2 = document.getElementById('hinh');
	if(thumbnail2 != null){
		thumbnail2.addEventListener('change', function() {
			var output = document.getElementById('viewhinh');
			loadFile(event, output);
		});
	}	
	var loadFile = function (event, output) {
	    output.className = "img-responsive hinh";
	
	    output.src = URL.createObjectURL(event.target.files[0]);
	};
	
	//Hàm kiểm tra filesize
	$.validator.addMethod('filesize', function (value, element, param) {
	    return this.optional(element) || (element.files[0].size <= param)
	}, 'File size must be less than {0}');
	
	// Check số trong họ tên
	$.validator.addMethod("notNumber", function(value, element, param) {
        var reg = /[0-9.@!#$%&'*+\/=?^_`{|}~-]/;
        if(reg.test(value)){
              return false;
        }else{
                return true;
        }
	});
	// Check tiếng anh
	$.validator.addMethod("checkDau", function(value, element, param) {
        var reg = /[ÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐáàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]/;
        if(reg.test(value)){
              return false;
        }else{
                return true;
        }
	});
	
	$("#thembaiviet").validate({
		onchange: true,
		rules:{
			tieude:{
				required: true,
				rangelength:[4,200],
				notNumber: true,
				remote : {
					type : "GET",
					url : "nhahang/baiviet/kt-trung-tieude.html",
					data: {
						idbv: function(){
							var id = $("#idbv").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}

				}
			},
			name:{
				required: true,
				rangelength:[4,200],
				notNumber: true,
				checkDau: true,
				remote : {
					type : "GET",
					url : "nhahang/baiviet/kt-trung-name.html",
					data: {
						idbv: function(){
							var id = $("#idbv").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}

				}
			},
			
			hinh:{
				required: true,
				extension: "jpg|png|gif|jpeg",
				filesize: 2097152
			},
			mota:{
				maxlength:255
			}
		},
		messages:{
			tieude:{
				required: "Vui lòng nhập tiêu đề",
				rangelength:"Tiêu đề không hợp lệ",
				notNumber :"Tiêu đề không được có ký tự đặc biệt và số",
				remote : "Tên bài viết đã tồn tại"
			},
			name:{
				required: "Vui lòng nhập tiêu đề bằng tiếng anh",
				rangelength:"Tiêu đề tiếng anh không hợp lệ",
				notNumber :"Tiêu đề tiếng anh không được có ký tự đặc biệt và số",
				checkDau :"Tiêu đề này phải là tiếng anh",
				remote : "Tên bài viết này đã tồn tại"
			},
			
			hinh:{
				required: "Vui lòng chọn hình cho bài viết",
				extension: "Vui lòng chọn file định dạng ảnh như (jpg|png|gif|jpeg)",
				filesize: "Dung lượng file nhỏ hơn 2MB"
			},
			mota:{
				maxlength:"Mô tả quá dài"
			}
		
		}
	});
	$("#editbaiviet").validate({
		onchange: true,
		rules:{
			tieude:{
				required: true,
				rangelength:[4,200],
				notNumber: true,
				remote : {
					type : "GET",
					url : "nhahang/baiviet/kt-trung-tieude.html",
					data: {
						idbv: function(){
							var id = $("#idbv").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}

				}
			},
			name:{
				required: true,
				rangelength:[4,200],
				notNumber: true,
				checkDau: true,
				remote : {
					type : "GET",
					url : "nhahang/baiviet/kt-trung-name.html",
					data: {
						idbv: function(){
							var id = $("#idbv").val();
							if(id != null){
								return id;return "redirect:/baiviet/edit/" + id + ".html";
							}else{
								return 0;
							}
						}
					}

				}
			},
			
			hinh:{
				
				extension: "jpg|png|gif|jpeg",
				filesize: 2097152
			},
			mota:{
				maxlength:255
			}
		},
		messages:{
			tieude:{
				required: "Vui lòng nhập tiêu đề",
				rangelength:"Tiêu đề không hợp lệ",
				notNumber :"Tiêu đề không được có ký tự đặc biệt và số",
				remote : "Tên bài viết đã tồn tại"
			},
			name:{
				required: "Vui lòng nhập tiêu đề bằng tiếng anh",
				rangelength:"Tiêu đề tiếng anh không hợp lệ",
				notNumber :"Tiêu đề tiếng anh không được có ký tự đặc biệt và số",
				checkDau :"Tiêu đề này phải là tiếng anh",
				remote : "Tên bài viết này đã tồn tại"
			},
			
			hinh:{
				
				extension: "Vui lòng chọn file định dạng ảnh như (jpg|png|gif|jpeg)",
				filesize: "Dung lượng file nhỏ hơn 2MB"
			},
			mota:{
				maxlength:"Mô tả quá dài"
			}
		}
	});
});