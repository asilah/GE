<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" >
<title>test</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/fonts/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/animate.min.css" rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="<%=request.getContextPath()%>/resources/css/custom.css"rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/icheck/flat/green.css" rel="stylesheet">

<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/input_mask/jquery.inputmask.js"></script>
<!-- some CSS styling changes and overrides -->
<style>
.kv-avatar .file-preview-frame,.kv-avatar .file-preview-frame:hover {
    margin: 0;
    padding: 0;
    border: none;
    box-shadow: none;
    text-align: center;
}
.kv-avatar .file-input {
    display: table-cell;
    max-width: 220px;
}
</style>
</head>
<body class="nav-md">
	

    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">

                    <div class="navbar nav_title" style="border: 0;">
                        <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>JEE-PROJET-2016 | </span></a>
                    </div>
                    <div class="clearfix"></div>


                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <img src="images/img.jpg" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <span>Welcome</span>
                            <h2></h2>
                        </div>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>General</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="index.html">Dashboard</a>
                                        </li>
                                        <li><a href="index2.html">Dashboard2</a>
                                        </li>
                                        <li><a href="index3.html">Dashboard3</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="form.html">General Form</a>
                                        </li>
                                        <li><a href="form_advanced.html">Advanced Components</a>
                                        </li>
                                        <li><a href="form_validation.html">Form Validation</a>
                                        </li>
                                        <li><a href="form_wizards.html">Form Wizard</a>
                                        </li>
                                        <li><a href="form_upload.html">Form Upload</a>
                                        </li>
                                        <li><a href="form_buttons.html">Form Buttons</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-desktop"></i> UI Elements <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="general_elements.html">General Elements</a>
                                        </li>
                                        <li><a href="media_gallery.html">Media Gallery</a>
                                        </li>
                                        <li><a href="typography.html">Typography</a>
                                        </li>
                                        <li><a href="icons.html">Icons</a>
                                        </li>
                                        <li><a href="glyphicons.html">Glyphicons</a>
                                        </li>
                                        <li><a href="widgets.html">Widgets</a>
                                        </li>
                                        <li><a href="invoice.html">Invoice</a>
                                        </li>
                                        <li><a href="inbox.html">Inbox</a>
                                        </li>
                                        <li><a href="calender.html">Calender</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="tables.html">Tables</a>
                                        </li>
                                        <li><a href="tables_dynamic.html">Table Dynamic</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="chartjs.html">Chart JS</a>
                                        </li>
                                        <li><a href="chartjs2.html">Chart JS2</a>
                                        </li>
                                        <li><a href="morisjs.html">Moris JS</a>
                                        </li>
                                        <li><a href="echarts.html">ECharts </a>
                                        </li>
                                        <li><a href="other_charts.html">Other Charts </a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="menu_section">
                            <h3>Live On</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-bug"></i> Additional Pages <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="e_commerce.html">E-commerce</a>
                                        </li>
                                        <li><a href="projects.html">Projects</a>
                                        </li>
                                        <li><a href="project_detail.html">Project Detail</a>
                                        </li>
                                        <li><a href="contacts.html">Contacts</a>
                                        </li>
                                        <li><a href="profile.html">Profile</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-windows"></i> Extras <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="page_404.html">404 Error</a>
                                        </li>
                                        <li><a href="page_500.html">500 Error</a>
                                        </li>
                                        <li><a href="plain_page.html">Plain Page</a>
                                        </li>
                                        <li><a href="login.html">Login Page</a>
                                        </li>
                                        <li><a href="pricing_tables.html">Pricing Tables</a>
                                        </li>

                                    </ul>
                                </li>
                                <li><a><i class="fa fa-laptop"></i> Landing Page <span class="label label-success pull-right">Coming Soon</span></a>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">
                        <a data-toggle="tooltip" data-placement="top" title="Settings">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Lock">
                            <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Logout">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>

            <!-- top navigation -->
            <div class="top_nav">

                <div class="nav_menu">
                    <nav class="" role="navigation">
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>

                        <ul class="nav navbar-nav navbar-right">
                            <li class="">
                                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                    <img src="images/img.jpg" alt="">John Doe
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li><a href="javascript:;">  Profile</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            <span class="badge bg-red pull-right">50%</span>
                                            <span>Settings</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">Help</a>
                                    </li>
                                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                    </li>
                                </ul>
                            </li>

                            <li role="presentation" class="dropdown">
                                <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                    <i class="fa fa-envelope-o"></i>
                                    <span class="badge bg-green">6</span>
                                </a>
                                <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="text-center">
                                            <a>
                                                <strong>See All Alerts</strong>
                                                <i class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                    </nav>
                </div>

            </div>
            <!-- /top navigation -->

            <!-- page content -->
            <div class="right_col" role="main">

                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>Contacts Design</h3>
                        </div>

                        <div class="title_right">
                       
                            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">
                   		 <div class="col-md-4 col-sm-4 col-xs-12 animated fadeInDown">
                                            <div class="well profile_view">
                                                <div class="col-sm-12">
                                                    <h4 class="brief"><i></i></h4> Les Fichiers à Générer( PDF )
                                                    <div class="left col-xs-7">
                                                        <h2>Bulletin de Paie</h2>
                                                        <p><strong>About: </strong> Générer les bulletins de paie pour Vos employés </p>
                                                        <ul class="list-unstyled">
                                                            <li><i class=""></i>  </li>
                                                            <li><i class=""></i> .</li>

                                                        </ul>
                                                    </div>
                                                    <div class="right col-xs-5 text-center">
                                                        <img src="" alt="FICHE PAIE" class="img-circle img-responsive">
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 bottom text-center">
                                                    <div class="col-xs-12 col-sm-6 emphasis">
                                                       
                                                    </div>
                                                    <div class="col-xs-12 col-sm-6 emphasis">
                                                        <button type="button" class="btn btn-primary btn-xs"> <i class="fa fa-file-pdf-o">
                                                            </i> Générer Le PDF </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-4 col-sm-4 col-xs-12 animated fadeInDown">
                                            <div class="well profile_view">
                                                <div class="col-sm-12">
                                                    <h4 class="brief"><i></i></h4> Les Fichiers à Générer( PDF )
                                                    <div class="left col-xs-7">
                                                        <h2>Déclaration CNSS</h2>
                                                        <p><strong>About: </strong> Générer la fiche de la déclaration cnss pour tout les employés </p>
                                                        <ul class="list-unstyled">
                                                            <li><i class=""></i>  </li>
                                                            <li><i class=""></i> .</li>

                                                        </ul>
                                                    </div>
                                                    <div class="right col-xs-5 text-center">
                                                        <img src="" alt="CNSS" class="img-circle img-responsive">
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 bottom text-center">
                                                    <div class="col-xs-12 col-sm-6 emphasis">
                                                       
                                                    </div>
                                                    <div class="col-xs-12 col-sm-6 emphasis">
                                                        <button type="button" class="btn btn-primary btn-xs"> <i class="fa fa-file-pdf-o">
                                                            </i> Générer Le PDF </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-4 col-sm-4 col-xs-12 animated fadeInDown">
                                            <div class="well profile_view">
                                                <div class="col-sm-12">
                                                    <h4 class="brief"><i></i></h4> Les Fichiers à Générer( PDF )
                                                    <div class="left col-xs-7">
                                                        <h2>Journal de Paie</h2>
                                                        <p><strong>About: </strong> Générer le journale de paie de tout les employés </p>
                                                        <ul class="list-unstyled">
                                                            <li><i class=""></i>  </li>
                                                            <li><i class=""></i> .</li>

                                                        </ul>
                                                    </div>
                                                    <div class="right col-xs-5 text-center">
                                                        <img src="" alt="JOURNAL DE PAIE" class="img-circle img-responsive">
                                                    </div>
                                                </div>
                                                <div class="col-xs-12 bottom text-center">
                                                    <div class="col-xs-12 col-sm-6 emphasis">
                                                       
                                                    </div>
                                                    <div class="col-xs-12 col-sm-6 emphasis">
                                                        <button type="button" class="btn btn-primary btn-xs"> <i class="fa fa-file-pdf-o">
                                                            </i> Générer Le PDF </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                	</div>
                <div class="row">
				<h2>PDF in modal preview using Easy Modal Plugin</h2>
      			  <a class="btn btn-primary view-pdf fa fa-file-pdf-o" href="<%=request.getContextPath()%>${pdf.fichier_emplacement }"> View PDF</a>  
      			  <p><%=request.getContextPath()%>${pdf.fichier_emplacement }</p>       
      			  
      			  <c:forEach items="${pdfs }" var="p">
      			  
      			  <a class="btn btn-primary view-pdf fa fa-file-pdf-o" href="<%=request.getContextPath()%>${p.fichier_emplacement }"> View PDF : ${p.fichier_emplacement }</a>  
      			  <p><%=request.getContextPath()%>${p.fichier_emplacement }</p>
      			  
      			  </c:forEach>
      			  
      			   <c:forEach items="${jpdf }" var="j">
      			  
      			  <a class="btn btn-primary view-pdf fa fa-file-pdf-o" href="<%=request.getContextPath()%>${j}"> View PDF : ${j }</a>  
      			  <p><%=request.getContextPath()%>${j }</p>
      			  
      			  </c:forEach>
      			  
      			  
      			  <c:forEach items="${lisDec }" var="k">
      			  
      			  <a class="btn btn-primary view-pdf fa fa-file-pdf-o" href="<%=request.getContextPath()%>${k}"> View PDF : ${k }</a>  
      			  <p><%=request.getContextPath()%>${k }</p>
      			  
      			  </c:forEach>
      			  
      			  
				</div>
				
                <!-- footer content -->
                <footer>
                    <div class="">
                        <p class="pull-right"> <a></a> |
                            <span class="lead"> <i class="fa fa-paw "></i> PROJET-JEE-2016</span>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
			</div>
            </div>
            <!-- /page content -->
        </div>

    </div>

    <div id="custom_notifications" class="custom-notifications dsp_none">
        <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
        </ul>
        <div class="clearfix"></div>
        <div id="notif-group" class="tabbed_notifications"></div>
    </div>

    <script src="js/bootstrap.min.js"></script>

    <!-- chart js -->
    <script src="js/chartjs/chart.min.js"></script>
    <!-- bootstrap progress js -->
    <script src="js/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="js/nicescroll/jquery.nicescroll.min.js"></script>
    <!-- icheck -->
    <script src="js/icheck/icheck.min.js"></script>

    <script src="js/custom.js"></script>
    <script>
    $(document).ready(function() {
    (function(a){a.createModal=function(b){defaults={title:"",message:"Your Message Goes Here!",closeButton:true,scrollable:false};var b=a.extend({},defaults,b);var c=(b.scrollable===true)?'style="max-height: 420px;overflow-y: auto;"':"";html='<div class="modal fade" id="myModal">';html+='<div class="modal-dialog">';html+='<div class="modal-content">';html+='<div class="modal-header">';html+='<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';if(b.title.length>0){html+='<h4 class="modal-title">'+b.title+"</h4>"}html+="</div>";html+='<div class="modal-body" '+c+">";html+=b.message;html+="</div>";html+='<div class="modal-footer">';if(b.closeButton===true){html+='<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>'}html+="</div>";html+="</div>";html+="</div>";html+="</div>";a("body").prepend(html);a("#myModal").modal().on("hidden.bs.modal",function(){a(this).remove()})}})(jQuery);

    /*
    * Here is how you use it
    */
    $(function(){    
        $('.view-pdf').on('click',function(){
            var pdf_link = $(this).attr('href');
            alert(pdf_link);
            //var iframe = '<div class="iframe-container"><iframe src="'+pdf_link+'"></iframe></div>'
            //var iframe = '<object data="'+pdf_link+'" type="application/pdf"><embed src="'+pdf_link+'" type="application/pdf" /></object>'        
            var iframe = '<object type="application/pdf" data="'+pdf_link+'" width="100%" height="500">No Support</object>'
            $.createModal({
                title:'My Title',
                message: iframe,
                closeButton:true,
                scrollable:false
            });
            return false;        
        });    
    });
    });
    
    </script>

</body>
<%-- <h1>Welcome Mr ${EmpForm.nom }</h1>
	<div>
		<f:form modelAttribute="EmpForm" method="post" action="ajoutEmp">
			<table>
				<tr>
					<td>login:</td>
					<td><f:input path="login"/></td>
					<td><f:errors path="login"></f:errors></td>
				</tr>
				<tr>
					<td>pass:</td>
					<td><f:input path="pass"/></td>
					<td><f:errors path="pass"></f:errors></td>
				</tr>
					<tr>
					<td><input type="submit" value="ok"></td>
				</tr>
			</table>
		</f:form>
		<c:if test="${not empty EmpForm.exception}">
			${EmpForm.exception }
		</c:if>
		
	</div> --%>
	
</html>
