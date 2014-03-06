$.validator.addClassRules({
	
    usernameField: {
	 minlength: 2,
	 required: true,
	 maxlength: 20
    },
	nameField: {
		required: true,
		minlength: 2,
		maxlength: 50
    },
    passwordField: {
        required: true,
        minlength: 5,
        maxlength: 20
    },
    emailField: {
    	 email: true,
         maxlength: 50,
         required: true
    }
});


//defined a customized function to avoid duplication.
function validateForm(arg){
	_form = arg;
	$(_form).validate({
        highlight: function (element) {
            $(element).closest('.control-group').removeClass('success').addClass('error');
        },
        success: function (element) {
            element.text('OK!').addClass('valid')
                .closest('.control-group').removeClass('error').addClass('success');
        }
    });
	
}