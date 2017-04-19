<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<div id="wrapper" class="${homeClass}">
		<!-- start header -->
		<header>
			<div class="navbar navbar-default navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="http://dunaenergo.by"><img
							src="resources/img/logo/logo.png" alt="logo" /></a>
					</div>
					<div class="navbar-collapse collapse ">
						<ul class="nav navbar-nav">
							<li class="${mainStyle}"><a href="mainPage">Главная</a></li>
							<li class="${servStyle}"><a href="services">Услуги</a></li>
							<li class="${ascueStyle}"><a href="ascue">АСКУЭ</a></li>
							<li class="${contactStyle}"><a href="contact">Контакты</a></li>
							<li class="${officeStyle}"><a href="office">Офис</a></li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<!-- end header -->