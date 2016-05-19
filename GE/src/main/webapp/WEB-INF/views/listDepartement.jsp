<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
                        <a href="<c:url value="/index"/>"><i class="fa fa-univesity"></i> <span>Home</span></a>
                    </div>
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <i class="fa fa-user" aria-hidden="true"></i>
                        </div>
                        <div class="profile_info">
                            <span>Welcome,</span>
                            <h2>${Admin.nom } </h2>
                        </div>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>General</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-home"></i> Ajouter <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/ajoutEmp"/>">Employe</a></li>
										<li><a href="<c:url value="/ajoutDept"/>">Departement</a></li>
										<li><a href="<c:url value="/ajoutAdmin"/>">Admin</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-table"></i> List <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/listEmp"/>">List des Employes</a></li>
                                        <li><a href="<c:url value="/listDept"/>">List des departement</a></li>
                                        
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-desktop"></i> gestion d'absence <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/gestionAbsence"/>">gestion d'absence</a></li>
                                        
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-edit"></i> Modification <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/updateAdmin"/>">Admin</a>
                                        </li>
                                        <li><a href="<c:url value="/updateEntr"/>">Entreprise</a>
                                        </li>
                                        <li><a href="<c:url value="/updateEmp"/>">Departement</a>
                                        </li>
                                        <li><a href="<c:url value="/updateDept"/>">Employe</a>
                                        </li>
                                    </ul>
                                </li>
                              
                                <li><a><i class="fa fa-table"></i> generation des pdfs <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/pdfs"/>">generer pdf</a>
                                        </li>
                                        
                                    </ul>
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
                                    <i class="fa fa-user" aria-hidden="true"></i>${Admin.nom } 
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li><a href="<c:url value="/updateAdmin"/>">  Profile</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            
                                            <span>Settings</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">Help</a>
                                    </li>
                                    <li><a href="<c:url value="/logout"/>"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
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
                            <h3>DEPARTEMENT(S)</h3>
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
                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_content">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12 col-xs-12" style="text-align:center;">
                                            <ul class="pagination pagination-split">
                                                <li><a href="#">1</a>
                                                </li>
                                                <li><a href="#">2</a>
                                                </li>
                                                <li><a href="#">3</a>
                                                </li>
                                                <li><a href="#">4</a>
                                                </li>
                                                <li><a href="#">5</a>
                                                </li>
                                                <li>...</li>
                                                <li><a href="#">12</a>
                                                </li>
                                                <li><a href="#">13</a>
                                                </li>
                                                <li><a href="#">14</a>
                                                </li>
                                                <li><a href="#">15</a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="clearfix"></div>

										<c:forEach items="${depts }" var="d">
                                        <div class="col-md-4 col-sm-4 col-xs-12 animated fadeInDown">
                                            <div class="well profile_view">
                                                <div class="col-sm-12">
                                                    <h4 class="brief"><i>Departement : ${d.codeDept }</i></h4>
                                                    <div class="left col-xs-7">
                                                        <h2>${d.nom}</h2>
                                                        <p><strong>chef: </strong> ${d.chefDept.nom} </p>
                                                        <ul class="list-unstyled">
                                                        <li><i>.</i></li>
                                                        <li></li>
                                                            <%-- <li><i class="fa fa-phone"></i> description: ${d.description } </li>
                                                            <li><i class="fa fa-phone"></i> description: ${d.description } </li> --%>
                                                        </ul>
                                                    </div>
                                                    <!-- <div class="right col-xs-5 text-center">
                                                        
                                                    </div> -->
                                                </div>
                                                <div class="col-xs-12 bottom text-center">
                                                   	<div class="col-xs-12 col-sm-6 emphasis">
                                                      <f:form modelAttribute="DeptForm" action="AfficheDept" method="post" >
                                                      	<input name="codeDept" value="${d.codeDept }" type="hidden"/>
                                                        <button  type="submit"  class="btn btn-success btn-xs"> <i class="fa">
                                                            </i> <i class="fa fa-home"></i> Afficher </button>
                                                         </f:form>   
                                                    </div>
                                                    <div class="col-xs-12 col-sm-6 emphasis">
                                                      <f:form modelAttribute="DeptForm" action="updateDept" method="post" >
                                                      	<input name="codeDept" value="${d.codeDept }" type="hidden"/>
                                                        <button  type="submit"  class="btn btn-primary btn-xs"> <i class="fa fa-cogs">
                                                            </i> Modifier </button>
                                                         </f:form>  
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
										</c:forEach>
                                       
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- footer content -->
                <footer>
                    <div class="">
                        <p class="pull-right"> JEE-PROJET-2016 |
                            <span class="lead"> <i class="fa fa-university"></i>   </span>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->

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
