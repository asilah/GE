<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" >
<title>Modifier un Département</title>
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
<% session.setAttribute("page","updateEntr");%>
    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">

                    <div class="navbar nav_title" style="border: 0;">
                        <a href="<c:url value="/index"/>"><i class="fa fa-paw"></i> <span>Home</span></a>
                    </div>
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <img src="images/img.jpg" alt="..." class="img-circle profile_img">
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
                                    <img src="images/img.jpg" alt="">${Admin.nom } 
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


                            <li role="presentation" class="dropdown"><a
                                href="javascript:;" class="dropdown-toggle info-number"
                                data-toggle="dropdown" aria-expanded="false"> <i
                                    class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
                            </a>
                                <ul id="menu1"
                                    class="dropdown-menu list-unstyled msg_list animated fadeInDown"
                                    role="menu">
                                    <li><a> <span class="image"> <img
                                                src="images/img.jpg" alt="Profile Image" />
                                        </span> <span> <span>John Smith</span> <span class="time">3
                                                    mins ago</span>
                                        </span> <span class="message"> Film festivals used to be
                                                do-or-die moments for movie makers. They were where... </span>
                                    </a></li>
                                    <li><a> <span class="image"> <img
                                                src="images/img.jpg" alt="Profile Image" />
                                        </span> <span> <span>John Smith</span> <span class="time">3
                                                    mins ago</span>
                                        </span> <span class="message"> Film festivals used to be
                                                do-or-die moments for movie makers. They were where... </span>
                                    </a></li>
                                    <li><a> <span class="image"> <img
                                                src="images/img.jpg" alt="Profile Image" />
                                        </span> <span> <span>John Smith</span> <span class="time">3
                                                    mins ago</span>
                                        </span> <span class="message"> Film festivals used to be
                                                do-or-die moments for movie makers. They were where... </span>
                                    </a></li>
                                    <li><a> <span class="image"> <img
                                                src="images/img.jpg" alt="Profile Image" />
                                        </span> <span> <span>John Smith</span> <span class="time">3
                                                    mins ago</span>
                                        </span> <span class="message"> Film festivals used to be
                                                do-or-die moments for movie makers. They were where... </span>
                                    </a></li>
                                    <li>
                                        <div class="text-center">
                                            <a> <strong>See All Alerts</strong> <i
                                                class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul></li>

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
                            <h3>Modifier un Département</h3>
                        </div>

                        <div class="title_right">
                            <div
                                class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" class="form-control"
                                        placeholder="Chercher..."> <span
                                        class="input-group-btn">
                                        <button class="btn btn-default" type="button">Ok!</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">

                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>
                                        Modifier un Département <small>updating</small>
                                    </h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i
                                                class="fa fa-chevron-up"></i></a></li>
                                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                            data-toggle="dropdown" role="button" aria-expanded="false"><i
                                                class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a></li>
                                                <li><a href="#">Settings 2</a></li>
                                            </ul></li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">

                                <f:form modelAttribute="EntrForm" action="updateEntr" method="post" class="form-horizontal form-label-left" >
                                        <span class="section">Département</span>
                         				 <div id="neww">
                                        
                                        <div class="item form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nom">Nom <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="nom" value="${Entr.nom}" class="form-control col-md-7 col-xs-12"  name="nom"  required="required" type="text" >
                                            </div>
                                        </div>
                                        <div class="item form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="ville">ville <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="ville" value="${Entr.ville}" class="form-control col-md-7 col-xs-12"  name="ville"  required="required" type="text">
                                            </div>
                                        </div>
                                        <div class="item form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">address 
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="address" name="address" value="${Entr.address}" required="required" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                         <div class="item form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="tel">tel 
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="tel" name="tel" value="${Entr.tel}" required="required" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="item form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="ville">fax 
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="fax" name="fax" value="${Entr.fax}" required="required" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="item form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="banque">banque <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="banque" value="${Entr.banque}" class="form-control col-md-7 col-xs-12"    name="banque"  required="required" type="text" >
                                            </div>
                                        </div>
                                        <div class="item form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="numCompteBanque">numCompteBanque <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="numCompteBanque" value="${Entr.numCompteBanque}" class="form-control col-md-7 col-xs-12"    name="numCompteBanque"  required="required" type="text" >
                                            </div>
                                        </div>
                                       <div class="item form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="smig">smig <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="smig" value="${Entr.smig}" class="form-control col-md-7 col-xs-12"    name="smig"  required="required" type="text" >
                                            </div>
                                        </div>
                                        <div class="item form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="heureNormale">heureNormale <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="heureNormale" value="${Entr.heureNormale}" class="form-control col-md-7 col-xs-12"    name="heureNormale"  required="required" type="text" >
                                            </div>
                                        </div>
                                        
                                        
                                        
                                        
                                        <div class="ln_solid"></div>
                                        <div class="form-group">
                                            <div class="col-md-6 col-md-offset-3">
                                                <button type="submit" class="btn btn-primary">Annuler</button>
                                                <f:input value="Modifier" path="submit" id="send" type="submit" class="btn btn-success"/>
                                            </div>
                                        </div>
                                        </div>
                                    </f:form>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <!-- footer content -->
                <footer>
                    <div class="">
                        <p class="pull-right">
                            HANNOUNI <a>PROJET DE JEE</a>. | <span
                                class="lead"> <i class="fa fa-paw"></i> Gestion des
                                employes
                            </span>
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
        <ul class="list-unstyled notifications clearfix"
            data-tabbed_notifications="notif-group">
        </ul>
        <div class="clearfix"></div>
        <div id="notif-group" class="tabbed_notifications"></div>
    </div>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

    <!-- chart js -->
    <script src="<%=request.getContextPath()%>/resources/js/chartjs/chart.min.js"></script>
    <!-- bootstrap progress js -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/moment.min2.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/datepicker/daterangepicker.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
    <!-- icheck -->
    <script src="<%=request.getContextPath()%>/resources/js/icheck/icheck.min.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/custom.js"></script>
    <!-- form wizard -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/wizard/jquery.smartWizard.js"></script>
    <script type="text/javascript">
    	$(document).ready(function() {
    		$("#sel").change(function(){
			var req=$(this).val();
      	 	alert('Selected value: ' + $(this).val());
    		});
    		$.ajax({
    			url : "http://localhost:8080/emp/DeptSel?req="+req,
    			type : "get"
    		});
    
    	});
    $(document).ready(function() {
            // Smart Wizard     
            $('#wizard').smartWizard();

            function onFinishCallback() {
                $('#wizard').smartWizard('showMessage', 'Finish Clicked');
                //alert('Finish Clicked');
            }
        });
		
        $(document).ready(function() {
            // Smart Wizard 
            $('#wizard_verticle').smartWizard({
                transitionEffect : 'slide'
            });
            $( "#sel" ).change(function() {
                  $("#neww").show();
                  $("#old").prop('disabled', 'disabled');
                  // kayn le prob dyal n3amero dakchi b les vals li kano 
                });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#birthday').daterangepicker({
                singleDatePicker : true,
                calender_style : "picker_4"
            }, function(start, end, label) {
                console.log(start.toISOString(), end.toISOString(), label);
            });
        });
    </script>
<script type="text/javascript"> 
$(document).on('ready', function() {
    $("#photo").fileinput({
        showUpload: false,
        maxFileCount: 10,
        mainClass: "input-group-lg"
    });
});
</script>
<script>
        $(document).ready(function () {
            $(":input").inputmask();
        });
    </script>
<script>
 $("form1").submit(function(){
    alert("Submitted");
}); 
 </script>
</html>
