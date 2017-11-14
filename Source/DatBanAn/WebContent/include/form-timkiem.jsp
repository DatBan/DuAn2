<%@ page pageEncoding="utf-8"%>
<style>
  .ui-autocomplete-loading {
    background: white url("css/images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  </style>
<div class="row timkiemnhc timkiemctnh">
	<form class="form-inline" action="tim-kiem.html" method="get">
		<div class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span> 
			<input type="text" class="form-control" id="keyword" placeholder="Tên nhà hàng, món ăn, địa điểm">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="ngaythang1" name="ohlala" placeholder="Chọn ngày tháng" readonly="readonly" style="cursor:pointer; background-color: #FFFFFF">
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
<script>
$(document).ready(function(){
$( function() {
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
            	console.log(data);
              response( $.map(data, function (item) {
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
      focus: function( event, ui ) {
        $( "#keyword" ).val( ui.item.label );
        return false;
      },
      select: function( event, ui ) {
        $( "#keyword" ).val( ui.item.label );
        /* $( "#project-id" ).val( ui.item.value );
        $( "#project-description" ).html( ui.item.desc );
        $( "#project-icon" ).attr( "src", "images/" + ui.item.icon ); */
 
        return false;
      }
    })
    .autocomplete( "instance" )._renderItem = function( ul, item ) {
      return $( "<li>" )
        .append( "<div>" + item.label + "<br>" + item.desc + "</div>" )
        .appendTo( ul );
    };
  } );


});
  </script>