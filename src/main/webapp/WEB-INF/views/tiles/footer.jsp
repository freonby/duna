<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer>
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <div class="widget">
          <h5 class="widgetheading">Наши контакты</h5>
          <address>
          <strong>ООО "ДЮНАэнерго"</strong><br>
          <i class="fa fa-map-marker"></i> пр.Машерова, 17 (литер А 7/к, пом.1), оф. 725
          </address>
          <p> <i class="fa fa-phone"></i> (017) 286-34-08 <br>
            <i class="fa fa-envelope"></i> na_an@tut.by </p>
        </div>
        <div>
       <c:import url="metrica.jsp"></c:import>
        </div>
      </div>
      <div class="col-lg-3">
        <div class="widget">
          <h5 class="widgetheading">Быстрые ссылки</h5>
          <ul class="link-list">
            <li><i class="fa fa-external-link-square" aria-hidden="true"></i> <a href="ascue">АСКУЭ</a></li>
            <li><i class="fa fa-external-link-square" aria-hidden="true"></i> <a href="#">Счетчики АИСТ</a></li>
            <li><i class="fa fa-external-link-square" aria-hidden="true"></i> <a href="#">Энергоэффективность</a></li>
            <li><i class="fa fa-external-link-square" aria-hidden="true"></i> <a href="#">ТНПА</a></li>
            <li><i class="fa fa-external-link-square" aria-hidden="true"></i> <a href="#">Проектирование электроснабжения</a></li>
          </ul>
        </div>
      </div>
      <div class="col-lg-3">
        <div class="widget">
          <h5 class="widgetheading">Банковские реквизиты</h5>
          <ul class="link-list">
            <li>ООО "ДЮНАэнерго"</li>
            <li>УНП 192485462</li>
            <li>ОКПО 382368345000 </li>
            <li>р/с 3012037816018 в ЦБУ 111 ОАО "Приорбанк" </li>
            <li>220123, г.Минск, пр. Машерова,40, код 153001749</li>
          </ul>
        </div>
      </div>
      <div class="col-lg-3">
        <div class="widget">
          <h5 class="widgetheading">ТНПА</h5>
          <ul class="link-list">
            <li><i class="fa fa-file-text" aria-hidden="true"></i> <a href="#">ТКП 339-2011 (02230)</a></li>
            <li><i class="fa fa-file-text" aria-hidden="true"></i> <a href="#">ТКП 45-1.02-295-2014 (02250)</a></li>
            <li><i class="fa fa-file-text" aria-hidden="true"></i> <a href="#">СТБ 2255-2012</a></li>
            <li><i class="fa fa-file-text" aria-hidden="true"></i> <a href="#">Правила электроснабжения</a></li>
            <li><i class="fa fa-file-text" aria-hidden="true"></i> <a href="#">СТБ 2096-2010</a></li>
            <li><i class="fa fa-file-text" aria-hidden="true"></i> <a href="#">ТКП 308-2011 (02230)</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div id="sub-footer">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <div class="copyright">
            <p> <span>2017 &copy; Все права на материалы данного сайта принадлежат ООО "ДЮНАэнерго" </span>.<br>
              Запросы на разрешение копирования материалов направлять на e-mail: na_an@tut.by.</p>
          </div>
        </div>
        <div class="col-lg-6">
          <ul class="social-network">
            <li><a href="#" data-placement="top" title="Facebook"><i class="fa fa-facebook"></i></a></li>
            <li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter"></i></a></li>
            
          </ul>
        </div>
      </div>
    </div>
  </div>
</footer>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a> 
<!-- javascript
    ================================================== --> 
<script src="resources/js/jquery.js"></script> 
<script src="resources/js/jquery.easing.1.3.js"></script> 
<script src="resources/js/bootstrap.min.js"></script> 
<script src="resources/js/jquery.fancybox.pack.js"></script> 
<script src="resources/js/jquery.fancybox-media.js"></script> 
<script src="resources/js/jquery.flexslider.js"></script> 
<script src="resources/js/animate.js"></script> 
<!-- Vendor Scripts --> 
<script src="resources/js/modernizr.custom.js"></script> 
<script src="resources/js/jquery.isotope.min.js"></script> 
<script src="resources/js/jquery.magnific-popup.min.js"></script> 
<script src="resources/js/custom.js"></script> 

<script>
$(document).ready(function() {
  //carousel options
  $('#quote-carousel').carousel({
    pause: true, interval: 10000,
  });
});
</script>
</body></html>
