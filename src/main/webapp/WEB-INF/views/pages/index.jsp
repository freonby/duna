<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="section-padding">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-6 wow fadeInLeft animated"
				data-wow-animation-name="fadeInLeft">

				<div class="btn-group">
					<button type="button" class="lineBtn" data-toggle="modal"
						data-target="#dogovor">Договор</button>
					<button type="button" class="lineBtn" data-toggle="modal"
						data-target="#invoice">Счет</button>
				</div>
			</div>
			<div class="col-md-6 col-sm-6  just"></div>
		</div>
	</div>
</section>
<section id="call-to-action-2">
	<div class="container">
		<div class="row">
			<div class="col-md-12 aligncenter">
				<h3>Доверьте свой объект профессионалам!</h3>
			</div>
		</div>
	</div>
</section>

<!-- Modal -->
<div class="modal fade" id="dogovor" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form:form method="post" action="dogovor" modelAttribute="customer"
				target="_blank" class="form-horizontal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<span class="fa fa-times"></span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Договор</h4>
				</div>

				<div class="modal-body">

					<div class="form-group">
						<label class="col-sm-4 control-label"></label> <label
							class="col-sm-8"> Услуги проектирования </label>
					</div>
					<div class="form-group">
						<label for="inputOrganisation" class="col-sm-4 control-label">Организация</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control input-sm"
								path="companyName" placeholder="Введите название компании" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPhone" class="col-sm-4 control-label">Телефон</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control input-sm"
								path="phone" placeholder="Введите номер телефона" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputManager" class="col-sm-4 control-label">Контакт</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control input-sm"
								path="contactPerson" placeholder="ФИО контактного лица" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-sm-4 control-label">E-mail</label>
						<div class="col-sm-8">
							<form:input type="email" class="form-control input-sm"
								path="email" placeholder="Ваш адрес e-mail" />
						</div>
					</div>
					
					
				</div>
				<div class="modal-footer">

					<button type="reset" class="lineBtn">Очистить</button>

					<form:button type="submit"  class="lineBtn">Скачать
						договор</form:button>
				</div>
			</form:form>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="invoice" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form:form method="post" action="invoice" modelAttribute="customer"
				target="_blank" class="form-horizontal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<span class="fa fa-times"></span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Счет</h4>
				</div>

				<div class="modal-body">

					<div class="form-group">
						<label class="col-sm-4 control-label"></label> <label
							class="col-sm-8"> Услуга проектирования </label>
					</div>
					<div class="form-group">
						<label for="inputOrganisation" class="col-sm-4 control-label">Организация</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control input-sm"
								path="companyName" placeholder="Введите название компании" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPhone" class="col-sm-4 control-label">Телефон</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control input-sm"
								path="phone" placeholder="Введите номер телефона" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputManager" class="col-sm-4 control-label">Контакт</label>
						<div class="col-sm-8">
							<form:input type="text" class="form-control input-sm"
								path="contactPerson" placeholder="ФИО контактного лица" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail" class="col-sm-4 control-label">E-mail</label>
						<div class="col-sm-8">
							<form:input type="email" class="form-control input-sm"
								path="email" placeholder="Ваш адрес e-mail" />
						</div>
					</div>
					
					
				</div>
				<div class="modal-footer">

					<button type="reset" class="lineBtn">Очистить</button>

					<form:button type="submit"  class="lineBtn">Скачать
						счет</form:button>
				</div>
			</form:form>
		</div>
	</div>
</div>