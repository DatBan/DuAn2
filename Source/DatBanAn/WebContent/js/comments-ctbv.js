		var target = $("div#bl-section").offset();
		var bl_moi = [0];
		var sapxep_bl = "DESC";
		var sotrang = 1;
		if(target != undefined){
			target = $("div#bl-section").offset().top-150;
			var interval = setInterval(function() {
			    var scroll = $(window).scrollTop();
					 if (scroll >= target) {
						 $("#load-more-cmts").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải');
						 	var data = {idbv: $("#idbv").val(), trang: sotrang, sapxep: sapxep_bl, 'idmoi[]': bl_moi};
						 	sotrang++;
						 	$.ajax({
								type: "POST",
								url: "binh-luan/load-ajax.html",
								data: data,
								dataType: "json",
								success: function(result){
										if(result.rong == 'dung' || result.trave == ""){
											$("#load-more-cmts").css("display", "none");
											$("div#load-bl-section").attr("class", "text-center");
											$("div#load-bl-section").append(
													"<span class='text-center' style='color:gray;' id='rong-bl'>" +
														"<b>Chưa có bình luận về bài viết này</b>" +
													"</span>");
										}else{
											$(".filter-bl").css("display", "block");
											$("#btn-filter-danhgia").before("<hr style='border-color: #ddd;'/>");
										}
										if(result.chuoi == 'out' || result.pagecount == '1'){
											$("#load-more-cmts").css("display", "none");
										}
										$("div#load-bl-section").append($(result.trave));
								},
								error: function(error){
									console.log("LOI "+error);
								}
							}).always(function(){
								$("#load-more-cmts").html('Xem thêm bình luận khác');
							});
							 clearInterval(interval);
					 }
			}, 500);
		}
	//link xem them binh luan
	$("#load-more-cmts").bind("click", function(){
		$("#load-more-cmts").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải');
		/*sotrang++;*/
	 	var data = {idbv: $("#idbv").val(), trang: sotrang, sapxep: sapxep_bl, 'idmoi[]': bl_moi};
	 	sotrang++;
	 	$.ajax({
			type: "POST",
			url: "binh-luan/load-ajax.html",
			data: data,
			dataType: "json",
			success: function(result){
				setTimeout(function(){
					if(result.rong == 'dung' || result.trave == ""){
						$("#load-more-cmts").css("display", "none");
						$("div#load-bl-section").attr("class", "text-center");
						$("div#load-bl-section").append(
								"<span class='text-center' style='color:gray;' id='rong-bl'>" +
									"<b>Chưa có bình luận về bài viết này</b>" +
								"</span>");
					}else{
						$(".filter-bl").css("display", "block");
						$("#btn-filter-danhgia").before("<hr style='border-color: #ddd;'/>");
					}
					if(result.chuoi == 'out' || result.pagecount == '1'){
						$("#load-more-cmts").css("display", "none");
					}
					$("div#load-bl-section").append($(result.trave));
					$("#load-more-cmts").html('Xem thêm bình luận khác');
				}, 0);
			},
			error: function(error){
				console.log("LOI "+error);
			}
		});
		return false;
	});
	
	//Load cmts reply
	var link_load_current = '';
	$("#load-bl-section").on("click", ".load-reply",function(){
		var link_load = $(this);
		var idbl = link_load.attr("data-bl");
		var loaded = link_load.attr("data-loaded");
		var data = {idbl: idbl, 'idmoi[]': bl_moi};
		if(loaded != '1'){
			link_load_current = link_load.html();
			$.ajax({
				url: "binh-luan/load-reply-ajax.html",
				data: data,
				type: "POST",
				dataType: "json",
				beforeSend: function(){
					link_load.append("<i class='fa-li fa fa-spinner fa-spin' style='position: initial;'></i>");
	    		},
				success: function(result){
					
					$(".cmts-reply"+idbl).append($(result.trave));
					$(".cmts-reply"+idbl).collapse('show');
					/*link_load.after("<b>len len</b>");*/
				},
				error: function(error){
					console.log("LOI "+error);
				}
			}).always(function(){
				link_load.html("<i class='fa fa-chevron-up'></i> Ẩn các câu trả lời");
				link_load.attr("data-loaded", "1");
			});
		}else{
			if($(".cmts-reply"+idbl).attr("aria-expanded") == 'false'){
				link_load.html("<i class='fa fa-chevron-up'></i> Ẩn các câu trả lời");
			}else{
				link_load.html(link_load_current);
			}
			$(".cmts-reply"+idbl).collapse('toggle');
		}
	});
	
	//sap xep binh luan
	$(".sap-xep-bl").bind("change",function(){
		sotrang = 1 ;
		$("#load-more-cmts").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải');
		$("div#load-bl-section").html('');
		$("#load-more-cmts").css("display", "block");
		
		if($(this).val() == 'oldest'){
			sapxep_bl = "ASC";
		}else if($(this).val() == 'popular'){
			sapxep_bl = "popular";
		}else{
			sapxep_bl = "DESC";
		}
		bl_moi= [0];
		var data = {idbv: $("#idbv").val(), trang: sotrang, sapxep: sapxep_bl, 'idmoi[]': bl_moi};
	 	sotrang++;
	 	$.ajax({
			type: "POST",
			url: "binh-luan/load-ajax.html",
			data: data,
			dataType: "json",
			success: function(result){
				setTimeout(function(){
					if(result.rong == 'dung' || result.trave == ""){
						$("#load-more-cmts").css("display", "none");
						$("div#load-bl-section").attr("class", "text-center");
						$("div#load-bl-section").append(
								"<span class='text-center' style='color:gray;' id='rong-bl'>" +
									"<b>Chưa có bình luận về bài viết này</b>" +
								"</span>");
					}else{
						$(".filter-bl").css("display", "block");
						$("#btn-filter-danhgia").before("<hr style='border-color: #ddd;'/>");
					}
					if(result.chuoi == 'out' || result.pagecount == '1'){
						$("#load-more-cmts").css("display", "none");
					}
					$("div#load-bl-section").append($(result.trave));
					$("#load-more-cmts").html('Xem thêm bình luận khác');
				}, 0);
			},
			error: function(error){
				console.log("LOI "+error);
			}
		});
	});
	
	//Check validate binh luan moi
	$("#bl-moi").validate({
		/*onchange : false,
		onfocusout : false,
		onkeyup : false,
		onclick : false,*/
		rules : {
			noidung : {
				required : true,
				maxlength : 300
			}
		},
		submitHandler: function(form) {
			$("#btn-bl").attr('disabled','disabled');
			$("#btn-bl").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Bình luận');
			$.ajax({
				type: "POST",
				url: "binh-luan.html",
				data: $("#bl-moi").serialize(),
				dataType: 'json',
				success: function(result){
					bl_moi.push(result.idm);
					$($(form).find("textarea#noidung")).val('');
					setTimeout(function(){
						if($("#rong-bl").val() != undefined){
							$(".filter-bl").css("display", "block");
							/*$("#btn-filter-danhgia").before("<hr style='border-color: #ddd;'/>");*/
							$("div#load-bl-section").attr("class", "");
							$("div#load-bl-section").html('');
						}
						$("div#load-bl-section").prepend($(result.blmoi));
							/*$("div#load-bl-section").prepend(result.blmoi);*/
					}, 500);
					
				},
				error: function(error){
					console.log(error);
				}
			}).always(function(){
				$("#btn-bl").removeAttr('disabled');
				$("#btn-bl").html('Gửi bình luận');
			});
			return false;
		 },
		messages : {
			noidung : {
				required : "Vui lòng nhập nội dung bình luận",
				rangelength : "Nội dung tối đa {0} kí tự"
			}
		}
	});
	
	$("#load-bl-section").on("click", ".taolao", function(){
		var o_reply = $(this).attr('data-target');
		var cai_nay = $(this);
		$(o_reply).on('shown.bs.collapse', function(){
			$(this).find('textarea').focus();
	    });
	});
	
	//Tra loi comments
	$("#load-bl-section").on("focusin", ".reply-cmt", function(){
		var form_nay = $(this);
		var text_area = $(this).find('textarea');
		var button = $(form_nay).find("button[type=submit]");
		var id_parent = $(form_nay).find("input[type=hidden]");
		var a_section = $("#load-bl-section").find("a.load-reply[data-bl="+id_parent.val()+"]");
		var reply_section = $("#load-bl-section").find("div.cmts-reply"+id_parent.val());
		//Check validate binh luan moi
			$(this).validate({
				/*onchange : true,
				onfocusout : true,
				onkeyup : true,*/
				/*onclick : true,*/
				rules : {
					noidung : {
						required : true,
						maxlength : 300
					}
				},
				submitHandler: function(form) {		
					$(button).attr('disabled','disabled');
					$(button).html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Trả lời');
					$.ajax({
						url: "binh-luan/tra-loi.html",
						type: "POST",
						data: $(form).serialize(),
						dataType: "json",
						success: function(result){
							$(text_area).val('');
							/*$('#reply'+id_parent.val()).collapse('hide');*/
							if($(a_section).attr("data-loaded") == '1' || $(reply_section).attr("data-empty") == '1'){
								if($(reply_section).attr("data-empty") == '1'){
									$(reply_section).attr('class', $(reply_section).attr('class')+' in');
									$(reply_section).attr('aria-expanded', 'true');
									$(reply_section).css('height', 'auto');
								}
								$(reply_section).append($(result.blmoi));
								/*if($('.cmts-reply'+id_parent.val()).attr("aria-expanded") != 'true'){
									$(a_section).trigger("click");
								}*/
							}
							if($('.cmts-reply'+id_parent.val()).attr("aria-expanded") != 'true'){
								$(a_section).trigger("click");
								
								$('.cmts-reply'+id_parent.val()).on('shown.bs.collapse', function(){		
									$('html, body').animate({
									    scrollTop: ($('#reply'+id_parent.val()).first().offset().top-200)
									},500);
								});
							}
							
						},
						error: function(error){
							console.log('LOI '+error);
						}
					}).always(function(){
						$(button).removeAttr('disabled');
						$(button).html('Trả lời');
					});
					return false;
				 },
				messages : {
					noidung : {
						required : "Vui lòng nhập nội dung bình luận",
						rangelength : "Nội dung tối đa {0} kí tự"
					}
				}
			});
	});
	
	$("#load-bl-section").on("click", ".btn-huy", function(){
		var id_huy = $(this).attr("data-huy");
		var element_huy = $("#load-bl-section").find("div#"+id_huy);
		$(element_huy).collapse('hide');
	});
	
	$("#load-bl-section").on("click", ".edit-cmt", function(){
		var noidung_cmt = $('#noidung-cmt'+$(this).attr("data-idbl"));
		console.log(noidung_cmt);
		$("#edit_cmt").modal('show');
		$("#noidung-modal").val($(noidung_cmt).html());
		$("#idbl-modal").val($(this).attr('data-idbl'));
		return false;
	});
	
	$("#form-sua-cmt").validate({
		/*onchange : false,
		onfocusout : false,
		onkeyup : false,
		onclick : false,*/
		rules : {
			noidung : {
				required : true,
				maxlength : 300
			}
		},
		submitHandler: function(form) {
			$("#btn-sua-modal").attr('disabled','disabled');
			$("#btn-sua-modal").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Chỉnh sửa');
			var data = $(form).serialize();
			console.log(data);
			$.ajax({
				type: "POST",
				url: "binh-luan/sua-binh-luan.html",
				data: data,
				dataType: 'json',
				success: function(result){
					var idsua = $(form).find("[type=hidden]").val();
					var noidung_sua = $(form).find("textarea").val();
					var noidung_cmt = $('#noidung-cmt'+idsua);
					noidung_cmt.html(noidung_sua);
					$(form).trigger("reset");
					$("#edit_cmt").modal('hide');
					/*$($(form).find("textarea#noidung")).val('');*/
					/*setTimeout(function(){
						if($("#rong-bl").val() != undefined){
							$(".filter-bl").css("display", "block");
							$("#btn-filter-danhgia").before("<hr style='border-color: #ddd;'/>");
							$("div#load-bl-section").attr("class", "");
							$("div#load-bl-section").html('');
						}
						$("div#load-bl-section").prepend($(result.blmoi));
							$("div#load-bl-section").prepend(result.blmoi);
					}, 500);*/
					
				},
				error: function(error){
					console.log(error);
				}
			}).always(function(){
				$("#btn-sua-modal").removeAttr('disabled');
				$("#btn-sua-modal").html('Chỉnh sửa');
			});
			return false;
		 },
		messages : {
			noidung : {
				required : "Vui lòng nhập nội dung bình luận",
				rangelength : "Nội dung tối đa {0} kí tự"
			}
		}
	});
	
	$("#load-bl-section").on("click", ".delete-cmt", function(){
		var noidung_cmts = '#noidung-cmt'+$(this).attr('data-idx');
		var idbl = $(this).attr('data-idx');
		$(noidung_cmts).closest(".media").remove();
		var data = {idbl: idbl};
		$.ajax({
			type:"POST",
			url: "binh-luan/xoa-binh-luan.html",
			data: data,
			dataType: "json",
			success: function(result){
				console.log(result);
			},
			error: function(error){
				console.log(error);
			}
		});
		return false;
	});