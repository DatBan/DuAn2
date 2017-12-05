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
									console.log(result);
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
				console.log(result);
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
	$(document).on("click", ".load-reply",function(){
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
					console.log(result);
					link_load.html("<i class='fa fa-chevron-up'></i> Ẩn các câu trả lời");
					link_load.attr("data-loaded", "1");
					$(".cmts-reply"+idbl).append($(result.trave));
					$(".cmts-reply"+idbl).collapse('show');
					/*link_load.after("<b>len len</b>");*/
				},
				error: function(error){
					console.log("LOI "+error);
				}
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
			$("#Modaldanhgia").modal('hide');
			$("#btn-bl").attr('disabled','disabled');
			$("#btn-bl").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Bình luận');
			$.ajax({
				type: "POST",
				url: "binh-luan.html",
				data: $("#bl-moi").serialize(),
				dataType: 'json',
				success: function(result){
					console.log(result);
					bl_moi.push(result.idm);
						/*setTimeout(function(){
						if($("#rong-dg").val() != undefined){
							$(".timdg").css("display", "block");
							$("#btn-filter-danhgia").before("<hr style='border-color: #ddd;'/>");
							$("#danhsach-dg").attr("class", "");
							$("#danhsach-dg").html('');
						}
							$("#danhsach-dg").prepend(hienthi_cmt);
							$( "#dialog" ).dialog('open');
						}, 500);*/
					$("div#load-bl-section").prepend($(result.blmoi));
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
	console.log(bl_moi);