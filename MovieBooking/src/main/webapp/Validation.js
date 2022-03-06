jQuery(function($) {
	var validator = $('#form').validate({
		rules : {
			firstName : {
				required : true
			},
			lastName : {
				required : true
			},
			email : {
				required : true,
				email : true
			},
			mobile : {
				required : true,
				minlength : 10,
				maxlength : 10
			},
			zipCode : {
				required : true,
				marlength: 5
			},
			password : {
				required : true,
				minlength : 5,
				maxlength:5
			}

		},
		messages : {
			firstname : "Plese Enter Your firstname",
			lastname : "Plese Enter Your lastname",
			email : "Plese Enter valid EmailId",
			mobile : "Plese Enter 10 Digit mobile Number",
			zipCode: "Enter 5 Digit Zip Code",
			password : "Plese enter 5 digit password"
		},
		errorPlacement : function(error, element) {
			var placement = $(element).data('error');
			if (placement) {
				$(placement).append(error)
			} else {
				error.insertAfter(element);
			}
		}
	});
});