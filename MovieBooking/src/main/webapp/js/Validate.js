jQuery(function($) {
	var validator = $('#form').validate({
		rules: {
			email: {
				required: true,
				email: true
			},
			password: {
				required: true,
				minlength: 5,
				maxlength: 5
			}

		},
		messages: {
			email: "Plese Enter valid EmailId",
			password: "Plese enter 5 digit password"
		},
		errorPlacement: function(error, element) {
			var placement = $(element).data('error');
			if (placement) {
				$(placement).append(error)
			} else {
				error.insertAfter(element);
			}
		}
	});
});