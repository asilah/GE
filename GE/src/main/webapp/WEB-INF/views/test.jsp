<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Page de test</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<!-- PNotify -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.core.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.buttons.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/notify/pnotify.nonblock.js"></script>
    <!-- Bootstrap core CSS -->

    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/resources/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/animate.min.css" rel="stylesheet">
</head>
<body>
<h1>cette page est pour le test hhhhhhh</h1>
<label> champs 1 : </label>
<input type="text" id="c1" /> <br>
<label> champs 2 : </label>
<input type="text" id="c2" /> <br>
<label> champs 3 : </label>
<input type="text" id="c3" /> <br>
<label> champs 4 : </label>
<input type="text" id="c4" /> <br>
<label> champs 5 : </label>
<input type="text" id="c5" /> <br>
<label> champs 6 : </label>
<input type="text" id="c6" /> <br>
<input type="button" value="tester" id="send" />
<div id="res" ></div>
<script type="text/javascript">
$("#send").click(function(){
	var c1=$("#c1").val();
	var c2=$("#c2").val();
	var c3=$("#c3").val();
	var c4=$("#c4").val();
	$.ajax({
		type : 'POST',
		url : 'testajax',
		data : "&a="+c1+"&b="+c2+"&c="+c3+"&d="+c4,
		
		success : function(data){
			new PNotify({
			    title: 'Sticky Success',
			    text: data,
			    type: 'success',
			   delay : 2500
			});
			$("#res").append(data);
			
		}
	});
});
</script>
</body>
</html>