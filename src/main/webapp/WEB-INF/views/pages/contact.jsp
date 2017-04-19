<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="inner-headline">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="pageTitle">Контакты и реквизиты</h2>
			</div>
		</div>
	</div>
</section>
<section id="content">

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="about-logo">
					<h3>Реквизиты для оплаты</h3>
					<p>Общество с ограниченной ответственностью "ДЮНАэнерго" (ООО
						"ДЮНАэнерго")</p>
					<p>
						<i class="fa fa-address-card-o"></i> УНП 192485462
					</p>
					<p>
						<i class="fa fa-address-card-o"></i> ОКПО 382368345000
					</p>
					<p>
						<i class="fa fa-address-card-o"></i> р/с 3012037816018 в ЦБУ 111
						ОАО "Приорбанк"
					</p>
					<p>
						<i class="fa fa-address-card-o"></i> Адрес банка:220123, г.Минск,
						пр. Машерова,40
					</p>
					<p>
						<i class="fa fa-address-card-o"></i> код 153001749
					</p>
				</div>
			</div>
			<div class="col-md-6">
				<div class="about-logo">
					<h3>Адрес и телефон</h3>
					<p>Адрес (юридический и почтовый):</p>
					<p>
						<i class="fa fa-map-marker"></i> пр.Машерова, 17 (литер А 7/к,
						пом.1), оф. 725 220029, г.Минск, Республика Беларусь
					</p>
					<p>
						<i class="fa fa-fax"></i> тел./факс: +375(17) 2863408
					</p>
					<p>
						<i class="fa fa-envelope"></i> e-mail: na_an@tut.by
					</p>

				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p>
					<i class="fa fa-clock-o"></i> График работы: Понедельник-пятница:
					8.00-17.00. Обед:12.00-13.00. Суббота-воскресение: выходной.
				</p>

				<!-- Form itself -->
				
			</div>
			<div class="col-md-12">
				<script type="text/javascript"
					src="http://maps.google.com/maps/api/js?key=AIzaSyCh289f2RjiD560Y0OmLSQ_crfJlF95UYY&sensor=false"></script>
				<div style="overflow: hidden; height: 300px; width: 100%;">
					<div id="gmap_canvas" style="height: 300px; width: 100%;"></div>
					<style>
						#gmap_canvas img {
						max-width: none !important;
						background: none !important
						}
					</style>
					<a class="google-map-code" href="www.training.freon.by"
						id="get-map-data">trivoo</a>
				</div>
				<script type="text/javascript">
					function init_map() {
						var myOptions = {
							zoom : 14,
							center : new google.maps.LatLng(53.916107,
									27.565090),
							mapTypeId : google.maps.MapTypeId.ROADMAP
						};
						map = new google.maps.Map(document
								.getElementById("gmap_canvas"), myOptions);
						marker = new google.maps.Marker({
							map : map,
							position : new google.maps.LatLng(53.916107,
									27.565090)
						});
						infowindow = new google.maps.InfoWindow(
								{
									content : "<b>ООО ДЮНАэнерго</b><br/>пр.Машерова, 17 (литер А 7/к, пом.1)<br/> оф. 725"
								});
						google.maps.event.addListener(marker, "click",
								function() {
									infowindow.open(map, marker);
								});
						infowindow.open(map, marker);
					}
					google.maps.event.addDomListener(window, 'load', init_map);
				</script>
			</div>
			
		</div>
	</div>

</section>