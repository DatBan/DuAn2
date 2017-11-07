$(document).ready(function() {
	// check họ tên (số chữ)
	$.validator.addMethod("wordCount", function(value, element, params) {
		var typedWords = jQuery.trim(value).split(" ").length;

		if (typedWords >= params[0]) {
			return true;
		}
	}

	);
	// Check sdt
	$.validator.addMethod("chuanSDT", function(value, element) {
		var regex = new RegExp(/^0[0-9].*$/);
		var key = value;

		if (!regex.test(key)) {
			return false;
		} else {
			return true;
		}
	});
	// Check số trong họ tên
	$.validator.addMethod("notNumber", function(value, element, param) {
        var reg = /[0-9.@!#$%&'*+\/=?^_`{|}~-]/;
        if(reg.test(value)){
              return false;
        }else{
                return true;
        }
	});
});