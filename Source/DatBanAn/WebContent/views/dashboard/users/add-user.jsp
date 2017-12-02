<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<form:form id="add-user-db" class="form-label-left clearfix" method="POST" action="dashboard/user-management/them.html" modelAttribute="nguoidung">
	                				<div class="row">
		                				<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Tên đăng nhập <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<form:input path="tendangnhap" id="tdn" cssClass="form-control" autocomplete="off"/>								
											</div>
										</div>
											
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Mật khẩu <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<form:password path="matkhau" cssClass="form-control"/>								
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Họ <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<form:input path="ho" cssClass="form-control" autocomplete="off"/>								
											</div>
										</div>
										
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Tên <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<form:input path="ten" cssClass="form-control" autocomplete="off"/>								
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Email <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<form:input path="email" cssClass="form-control" autocomplete="off"/>								
											</div>
										</div>
										
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Điện thoại <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<form:input path="sdt" cssClass="form-control" autocomplete="off"/>								
											</div>
										</div>
									</div>
									
									<div class="row">
										<div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Địa chỉ
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<form:textarea path="diachi" cssClass="form-control" rows="1"/>								
											</div>
										</div>
										
										<%-- <div class="item form-group col-md-6 clearfix">
											<label class="control-label col-md-4 col-sm-3 col-xs-12" for="number">
												Vai trò <span class="required">*</span>
											</label>
											<div class="col-md-7 col-sm-6 col-xs-12">
												<form:select path="quyennd.id" cssClass="form-control"	items="${listquyen}" itemLabel="tenquyen" itemValue="id">
												</form:select>							
											</div>
											<form:hidden path="tendangnhap" cssClass="form-control" disabled="true"/>
										</div> --%>									
										<div class="row">								
											<div class="item form-group col-md-6 clearfix">
												<div class="col-md-7 col-sm-6 col-xs-12">
													<form:button class="btn btn-primary">Thêm mới</form:button>
													<input type="reset" class="btn btn-default" value="Reset"/>
												</div>
											</div>
										</div>
									</div>
	                			</form:form>