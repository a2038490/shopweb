<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="120"/>
<title>Insert title here</title>

</head>
<body>
<script type="text/javascript" language="javascript">
	window.onload = function()
	{
		var slideindex=1;
		showslide(slideindex);
		var prev=document.getElementById("prev");
		prev.addEventListener("click",divideslides,false);
		var next=document.getElementById("next");
		next.addEventListener("click",plusslides,false);
		
		function divideslides()
		{
			showslide((slideindex-=1));
		}
		
		function plusslides()
		{
			showslide((slideindex+=1));
		}
		
		function showslide(num)
		{
			var slides = document.getElementsByClassName("slideitem");
			if(num>slides.length)
				{
					slideindex=1;
				}
			if(num<1)
				{
					slideindex=slides.length;
				}
			for(let i=0;i<slides.length;i++)
				{
					slides[i].style.display="none";
				}
			slides[slideindex-1].style.display="block";
			
			
		}
		
		setInterval(function(){plusslides();},20000);
	};
	
</script>
<div class="wrap">
	<div class="body">
		<div class="slideshow">
			<div class="slideitem fades">
			<img border="0" src="<%=request.getContextPath() %>/JSP/banana.jpg">
			</div>
			<div class="slideitem fades">
			<img border="0" src="<%=request.getContextPath() %>/JSP/inca.jpg">
			</div>
			<div class="slideitem fades">
			<img border="0" src="<%=request.getContextPath() %>/JSP/inca oil.jpg">
			</div>
			<div class="slideitem fades">
			<img border="0" src="<%=request.getContextPath() %>/JSP/sugar.jpg">
			</div>
			<div class="slideitem fades">
			<img border="0" src="<%=request.getContextPath() %>/JSP/sugar juice.jpg">
			</div>
			<a id="prev" class="slidearraw slidearrawprev">《</a>
			<a id="next" class="slidearraw slidearrawnext">》</a>
		</div>
	</div>
	<div class="footer">
	<br>
	<br>
	<p>賣家的連絡資訊:</p>
	<p>聯絡人:黃先生</p>
	<p>連絡電話:09XX-XXX-XXX</p>
	
	</div>
	
</div>


</body>
</html>