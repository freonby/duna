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
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form method="get" action="dogovor" target="_blank"
				class="form-horizontal">
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
						<label class="col-sm-4 control-label">Полное ФИО</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm" name="name"
								placeholder="Иванов Иван Иванович" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Краткое ФИО</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm" name="shortName"
								placeholder="И.И.Иванов" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Населенный пункт
							(адрес регистрации)</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm" name="city"
								placeholder="Минский р-н, н.п.Боровляны" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Улица (адрес
							регистрации)</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm" name="street"
								placeholder="ул. Ленинская, 18а" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Телефон</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm" name="phone"
								placeholder="Введите номер телефона" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">E-mail</label>
						<div class="col-sm-8">
							<input type="email" class="form-control input-sm" name="email"
								placeholder="Ваш адрес e-mail" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Серия паспорта</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm"
								name="passportSn" placeholder="МР" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Номер паспорта
							(возле серии)</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm"
								name="passportNumber" placeholder="8888888" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Дата выдачи паспорта</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm"
								name="passportDate" placeholder="25.08.2016" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Кем выдан</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm"
								name="passportRovd" placeholder="Минским РУВД Минской обл." required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Личный номер</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm"
								name="passportPrivateNumber" placeholder="4021565В073РВ2" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Номер договора</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm"
								name="dogovorNumber" placeholder="ПР-XX/XX" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Объект
							проектирования (город)</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm"
								name="objectCity" placeholder="Минский р-н, н.п.Боровляны" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Объект
							проектирования (улица,дом)</label>
						<div class="col-sm-8">
							<input type="text" class="form-control input-sm"
								name="objectStreet" placeholder="ул. Советская, 11" required="required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Название объекта</label>
						<div class="col-sm-8">
							<select class="form-control input-sm" name="typeObject">
								<option>Устройство 3-фазного ввода в жилой дом:</option>
								
							</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">

					<button type="reset" class="lineBtn">Очистить</button>

					<button type="submit" class="lineBtn">Скачать договор</button>
				</div>
			</form>
		</div>
	</div>
</div>

