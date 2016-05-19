<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" >
<title>Ajouter un employé</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">


<link
	href="<%=request.getContextPath()%>/resources/fonts/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/animate.min.css"
	rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="<%=request.getContextPath()%>/resources/css/custom.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/icheck/flat/green.css"
	rel="stylesheet">


<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>

<!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
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

<!-- Autocomplete -->
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/autocomplete/countries.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/autocomplete/jquery.autocomplete.js"></script>
        <script type="text/javascript">
            $(function () {
            	
                'use strict';
                var countriesArray = $.map(countries, function (value, key) {
                    return {
                        value: value,
                        data: key
                    };
                });
                // Initialize autocomplete with custom appendTo:
                $('#autocomplete-custom-append').autocomplete({
                    lookup: countriesArray,
                    appendTo: '#autocomplete-container'
                });
            });
        </script>
       


</head>
<body class="nav-md">
<% session.setAttribute("page","ajoutEmp");%>
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
							<h3>Ajouter un employé</h3>
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
										Formulaire d'ajout <small>pour les employées</small>
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


									<!-- Smart Wizard -->
									<div id="wizard" class="form_wizard wizard_horizontal">
										<ul class="wizard_steps">
											<li><a href="#step-1"> <span class="step_no">1</span>
													<span class="step_descr"> Etape 1<br /> <small>Etape
															1: Personnel</small>
												</span>
											</a></li>
											<li><a href="#step-2"> <span class="step_no">2</span>
													<span class="step_descr"> Etape 2<br /> <small>Etape
															2: Famille</small>
												</span>
											</a></li>
											<li><a href="#step-3"> <span class="step_no">3</span>
													<span class="step_descr"> Step 3<br /> <small>Etape
															3: contact</small>
												</span>
											</a></li>
											<li><a href="#step-4"> <span class="step_no">4</span>
													<span class="step_descr"> Step 4<br /> <small>Etape
															4: Autres</small>
												</span>
											</a></li>
										</ul>
										<f:form modelAttribute="EmpForm" method="post" action="ajoutEmp" id="form1" class="form-horizontal form-label-left">
											<div id="step-1">


												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="first-name">CIN <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<f:input path="cin" type="text" id="cin" required="required"
															class="form-control col-md-7 col-xs-12" />
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="last-name">Nom <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="nom" type="text" id="nom" name="nom"
															required="required"
															class="form-control col-md-7 col-xs-12" />
														<%-- <f:input path="nom" type="text" id="nom" name="nom" required="required" class="form-control col-md-7 col-xs-12"/> --%>
													</div>
												</div>
												<div class="form-group">
													<label for="middle-name"
														class="control-label col-md-3 col-sm-3 col-xs-12">Prénom</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="prenom" id="prenom"
															class="form-control col-md-7 col-xs-12" type="text"
															name="prenom" />
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">SEXE</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<div id="gender" class="btn-group" data-toggle="buttons">
															<f:select path="sex" id="sex" class="form-control">
                                                    		<option value="H">Homme</option>
                                                    		<option value="F">Femme</option>
                                                   			</f:select>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">Photo
														 <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
															<div tabindex="500" class="btn btn-primary ">
															<input id="photo"  type="file" class="glyphicon glyphicon-folder-open file-loading">
															</div>
													        
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">Date
														De Naissance <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<f:input path="dateNaissance" id="birthday" data-inputmask="'mask' : '99/99/9999'"
															class="date-picker form-control col-md-7 col-xs-12"
															required="required" type="text"/>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">Lieu
														De Naissance <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<f:input path="lieuNaissance" id="lieuNaissance"
															class=" form-control col-md-7 col-xs-12"
															required="required" type="text"/>
													</div>
												</div>



											</div>
											<div id="step-2">
												

												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="first-name">situation Familiale<span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<f:select path="situationFamiliale" id="situation" class="form-control">
                                                    		<option value="à">Choose option</option>
                                                    		<option value="C">Céblibataire</option>
                                                    		<option value="M">Mariée</option>
                                                    		<option value="D">Divorcé(e)</option>
                                                    		<option value="V">Veuf(ve)</option>
                                               			 </f:select>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="last-name">Nombre des enfants <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="nbEnfant" type="number" id="nbEnfant" name="nbEnfant"
															required="required" data-inputmask="'mask' : '99'"
															class="form-control col-md-7 col-xs-12" />
														<%-- <f:input path="nom" type="text" id="nom" name="nom" required="required" class="form-control col-md-7 col-xs-12"/> --%>
													</div>
												</div>
												<div class="form-group">
													<label for="numCnss"
														class="control-label col-md-3 col-sm-3 col-xs-12">Numero CNSS</label>
														<span class="required">*</span>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="numCnss" id="numCnss" data-inputmask="'mask' : '999999999'"
															class="form-control col-md-7 col-xs-12" type="text"
															name="numCnss" />
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">Banque</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="banque" id="banque"
															class="form-control col-md-7 col-xs-12" type="text"
															name="banque" />
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">Numéro du compte bancaire
														 <span class="required"></span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
															
															<input path="numCompteBanque" name="numCompteBanque" id="numCompteBanque"  type="text" class="form-control col-md-7 col-xs-12">
															
													        
													</div>
												</div>
												
											
											</div>
											<div id="step-3">
												
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="first-name">Numéro de Téléphone<span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input name="tel" class="form-control" data-inputmask="'mask' : '(+212) 09 99-99-99-99'" type="text">
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="last-name">ville <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="ville" type="text" id="ville" name="ville"
															required="required"
															class="form-control col-md-7 col-xs-12" />
														<%-- <f:input path="nom" type="text" id="nom" name="nom" required="required" class="form-control col-md-7 col-xs-12"/> --%>
													</div>
												</div>
												<div class="form-group">
													<label for="middle-name"
														class="control-label col-md-3 col-sm-3 col-xs-12">Adresse<span class="required">*</span></label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="address" name="address" id="adresse"
															class="form-control col-md-7 col-xs-12" type="text"
															name="adresse" required="required" />
													</div>
												</div>
												<div class="form-group">
													<label for="middle-name"
														class="control-label col-md-3 col-sm-3 col-xs-12">Email<span class="required">*</span></label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="mail" id="mail"
															class="form-control col-md-7 col-xs-12" type="email"
															name="mail" required="required" />
													</div>
												</div>
												
												
											</div>
											<div id="step-4">
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">Poste / 
														Salaire de base <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="responsabilite" id="responsabilite" name="responsabilite"
															class=" form-control col-md-7 col-xs-12" value="0"
															 type="number">
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">Poste / 
														Responsabilité <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
														<input path="responsabilite" id="responsabilite" name="responsabilite"
															class=" form-control col-md-7 col-xs-12"
															required="required" type="text">
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">Poste / 
														Departement <span class="required">*</span>
													</label>
													<div class="col-md-6 col-sm-6 col-xs-12">
													<f:select path="Departement" class=" form-control col-md-7 col-xs-12" required="required">
														<c:forEach items="${listDept }" var="ld">
														<option value="${ld.codeDept }">${ld.nom }</option>
														</c:forEach>
														</f:select>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12"
														for="last-name">employé Supérieur 
													</label>
													 <div class="col-md-6 col-sm-6 col-xs-12">
                                                		<input type="text" name="employeSup" id="autocomplete-custom-append" class="form-control col-md-10" style="float: left;" />
                                               		 	<div id="autocomplete-container" style="position: relative; float: left; width: 400px; margin: 10px;"></div>
<!--                                             			<input path="employeSup" type="text" id="employeSup" name="employeSup" -->
<!-- 															class="form-control col-md-7 col-xs-12" /> -->
                                            		</div>
													
														
															
														<%-- <f:input path="nom" type="text" id="nom" name="nom" required="required" class="form-control col-md-7 col-xs-12"/> --%>
												
												</div>
												
												
												
												<div class="actionBar"><f:input path="submit" value="Ajouter" type="submit" class=" btn btn-default" /></div>
												
											</div>
										
										</f:form>
									</div>
									<!-- End SmartWizard Content -->



								</div>
							</div>
						</div>

					</div>
				</div>

				<!-- footer content -->
				<footer>
					<div class="">
						<p class="pull-right">
							TOUFGA & TAMSAMANI! <a>PROJET DE SEMESTER</a>. | <span
								class="lead"> <i class="fa fa-paw"></i> Gestion des
								employées
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

	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

	<!-- chart js -->
	<script
		src="<%=request.getContextPath()%>/resources/js/chartjs/chart.min.js"></script>
	<!-- bootstrap progress js -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/moment.min2.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/datepicker/daterangepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/progressbar/bootstrap-progressbar.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
	<!-- icheck -->
	<script
		src="<%=request.getContextPath()%>/resources/js/icheck/icheck.min.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/custom.js"></script>
	<!-- form wizard -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/wizard/jquery.smartWizard.js"></script>
	<script type="text/javascript">
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
