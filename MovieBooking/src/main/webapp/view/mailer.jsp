<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Transaction Email</title>
<link href="../css/mailer.css" rel="stylesheet" />
</head>
<body>
	<span class="preheader">This is preheader text. Some clients
		will show this text as a preview.</span>
	<table role="presentation" border="0" cellpadding="0" cellspacing="0"
		class="body">
		<tr>
			<td>&nbsp;</td>
			<td class="container">
				<div class="content">

					<!-- START CENTERED WHITE CONTAINER -->
					<table role="presentation" class="main">

						<!-- START MAIN CONTENT AREA -->
						<tr>
							<td class="wrapper">
								<table role="presentation" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td>
											<p>
												Hi
												<%=request.getParameter("firstName") %><%=request.getParameter("lastName") %>,
											</p>
											<p>
												Thank you for your purchase. A confirmation email has been
												send to
												<%=request.getParameter("emailId") %>We look forward to
												seeing you at the theater. Your tickets have been saved to
												your account. At the theater, proceed directly to the ticket
												 and scan this bar code to use your contact less
												tickets.
											</p>
											<table role="presentation" border="0" cellpadding="0"
												cellspacing="0" class="btn btn-primary">
												<tbody>
													<tr>
														<td align="left">
															<table role="presentation" border="0" cellpadding="0"
																cellspacing="0">
																<tbody>
																	<tr>
																		<td><a href="http://htmlemail.io" target="_blank">Call
																				To Action</a></td>
																	</tr>
																</tbody>
															</table>
														</td>
													</tr>
												</tbody>
											</table>
											<p>Face masks are required for non-vaccinated guests and
												strongly encouraged for all other guests, except where
												required by local mandates. Masks may be removed when eating
												and drinking inside the auditorium.</p>
											<p>At the theater, show your online transaction to pick up
												your tickets.</p>
											<p>Good luck! Hope it works.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>

						<!-- END MAIN CONTENT AREA -->
					</table>
					<!-- END CENTERED WHITE CONTAINER -->

					<!-- START FOOTER -->
					<div class="footer">
						<table role="presentation" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td class="content-block"><span class="apple-link">Posted
										by: Prem Kamal Osipalli</span> <br> Don't like these emails? <a
									href="#">Unsubscribe</a>.</td>
							</tr>
							<tr>
								<td class="content-block powered-by">
									<p>
										Contact information: <a
											href="mailto:premkamalosipalli@gmail.com">premkamalosipalli@gmail.com</a>.
									</p>
									<p>
										<strong>Note:</strong> Horror Movies are Strictly Prohibited
										to age holders below 18 years.
									</p>
								</td>
							</tr>
						</table>
					</div>
					<!-- END FOOTER -->

				</div>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</body>
</html>