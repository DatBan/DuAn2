<%@ page pageEncoding="utf-8"%>
<style>
  .ui-autocomplete-loading {
    background: white url("css/images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  </style>
<div class="row timkiemnhc timkiemctnh">
	<form class="form-inline" action="tim-kiem.html" method="get">
		<div class="form-group">
			<!-- <div class="typeahead__container">
		        <div class="typeahead__field">
		 
		            <span class="typeahead__query"> -->
		            <div class="input-group">
		            	<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
		                <%-- <input class="form-control js-typeahead" id="keyword" name="q" type="search" value="${q}" placeholder="Tên quán ăn hoặc món ăn" autocomplete="off"> --%>
						<input id="placeholder" placeholder="Tên quán ăn hoặc món ăn" name="search" autocomplete="off"/>
					</div>
		           <!--  </span>
		            <span class="typeahead__button">
		                <button type="submit">
		                    <span class="typeahead__search-icon"></span>
		                </button>
		            </span>
		 
		        </div>
		    </div> -->
	    </div>
		<div class="form-group">
			<input type="text" class="form-control" id="ngaythang1" name="date" placeholder="Chọn ngày tháng" readonly="readonly" style="cursor:pointer; background-color: #FFFFFF">
		</div>
		<div class="form-group">
			<input type="time" class="timepicker form-control" id="demo">
		</div>
		<div class="form-group">
			<select class="form-control so-nguoi">
				<option>1 người</option>
				<option>2 người</option>
			</select>
		</div>
		<button class="btn warning btntk">
			<b>Tìm kiếm</b>
		</button>
	</form>
	<div class="col-md-2 "></div>
</div>
<script>
	/* $(document).ready(function(){ */
		$(document).ready(function(){
			var options = {

					  url: function(phrase) {
					    return "search-ajax.html";
					  },
					  
					  categories: [
						{
						        listLocation: "showmore",
						        maxNumberOfElements: 1,
						        header: ""
						},
						{
					        listLocation: "monan",
					        maxNumberOfElements: 4,
					        header: "Món ăn"
					    }, 
					    {
					        listLocation: "nhahang",
					        maxNumberOfElements: 4,
					        header: "<i class='fa fa-phone'></i> Nhà hàng"
					    }],

					  getValue: function(element) {
						  console.log(element);
						  if(element.tennhahang != undefined){
							  return element.tennhahang;
						  }
						  
					    return element.tenmonan;
					  },
					  template: {
						  type: "custom",
							method: function(value, item) {
								if(item.showmore != null){
									return "Tìm kiếm thêm với từ khóa \""+value+"\"";
								}
								return "<img src=\"\" />" + value;
							}
					    },

					  ajaxSettings: {
					    dataType: "json",
					    method: "POST",
					    data: {
					      dataType: "json"
					    },
					    beforeSend: function(){
			    			$("#placeholder").css("background","white url('css/images/ui-anim_basic_16x16.gif') right center no-repeat");
			    		},
			    		complete: function(){
			    			/* $("#eac-container-placeholder > ul").append($("<li/>",{
			    				"class": "ss"
			    			}).append($("<div/>", {
			    				"class": "eac-item",
			    				"text": "halo"
			    			}))); */
			    			$("#placeholder").css("background","white");
			    		}
					  },
					  list: {
					        maxNumberOfElements: 8,
					        match: {
					            enabled: true
					        },
					        sort: {
					            enabled: true
					        }
					    },

					  preparePostData: function(data) {
					    data.search = $("#placeholder").val();
					    return data;
					  },
					  theme: "square",
					  requestDelay: 400
				};

			$("#placeholder").easyAutocomplete(options);
				
			var so_nguoi = document.getElementsByClassName('so-nguoi');
			$('.so-nguoi').empty();
			for(var i = 1; i < 100; i++){
				var opt = document.createElement('option');
				opt.innerHTML = i + " người";
				opt.value = i;
				$('.so-nguoi').append(opt);
			}
			$(function(){		
				$('.timepicker').qcTimepicker({
					'format': 'H:mm',
					'minTime': '7:00:00',
					'maxTime': '23:30:00',
					'step': 900,
					'placeholder': 'halo halo'
				});
				$("#demo-qcTimepicker").attr({"class": "form-control", "name": "thoigian"});
	
				$("#ngaythang1").datepicker({
					dateFormat : "dd/mm/yy",
					gotoCurrent: true,
					minDate : 0
				}).datepicker("setDate", new Date());
			});
		});
	/* }); */
</script>
<!-- <script>
$(document).ready(function(){
  /* $( function() {
    var projects = [
      {
        value: "jquery",
        label: "jQuery",
        desc: "the write less, do more, JavaScript library",
        icon: "jquery_32x32.png"
      },
      {
        value: "jquery-ui",
        label: "jQuery UI",
        desc: "the official user interface library for jQuery",
        icon: "jqueryui_32x32.png"
      },
      
      {
        value: "jquery-ui",
        label: "jQuery UI",
        desc: "the official user interface library for jQuery",
        icon: "jqueryui_32x32.png"
      },
      
      {
        value: "jquery-ui",
        label: "jQuery UI",
        desc: "the official user interface library for jQuery",
        icon: "jqueryui_32x32.png"
      },
      
      {
        value: "jquery-ui",
        label: "jQuery UI",
        desc: "the official user interface library for jQuery",
        icon: "jqueryui_32x32.png"
      },
      
      {
        value: "https://www.google.com",
        label: "jQuery UI",
        desc: "the official user interface library for jQuery",
        icon: "jqueryui_32x32.png"
      },
      
      {
        value: "jquery-ui",
        label: "jQuery UI",
        desc: "the official user interface library for jQuery",
        icon: "jqueryui_32x32.png"
      },
      {
        value: "sizzlejs",
        label: "Sizzle JS",
        desc: "a pure-JavaScript CSS selector engine",
        icon: "sizzlejs_32x32.png"
      }
    ];
 
    $( "#keyword" ).autocomplete({
      minLength: 2,
      source: function( request, response ) {
          $.ajax( {
            url: "search-ajax.html",
            dataType: "json",
            data: {
              search: request.term
            },
            beforeSend: function(){
    			$("#keyword").css("background","white url('css/images/ui-anim_basic_16x16.gif') right center no-repeat");
    		},
            success: function( data ) {
            	$("#keyword").css("background","white");
              response( $.map(data, function (item) {
            	  console.log(data.length + " hi");
            	  console.log(item.id);
                  return {
                      label: item.tennhahang,
                      value: item.name,
                      desc: item.name
                  };
              }));
          },
          error: function(error){
        	  console.log(error);
          }
        });
      }, 
      open: function(event, ui) {
    	  alert('a aa a a a');
          $('.ui-autocomplete').append('<li><a href="javascript:alert(\'redirecting...\')">See All Result</a></li>'); //See all results
      },
      focus: function( event, ui ) {
        $( "#keyword" ).val( ui.item.label );
        return false;
      },
      select: function( event, ui ) {
        $( "#keyword" ).val( ui.item.label );
         $( "#project-id" ).val( ui.item.value );
        $( "#project-description" ).html( ui.item.desc );
        $( "#project-icon" ).attr( "src", "images/" + ui.item.icon );
 
          return false;
      }
    }).autocomplete( "instance" )._renderItem = function( ul, item ) {
      return $( "<li>" )
        .append( "<div>" + item.label + "<br>" + item.desc + "</div>" )
        .appendTo( ul );
    }; 
  }); */


});
  </script> -->