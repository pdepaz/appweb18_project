// Get the modal
var modal = document.getElementById('id01');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}


grecaptcha.ready(function() {
grecaptcha.execute('6LfsT34UAAAAADa3jHrtDwYSF7qPbOKuqjJr9QKR', {action: 'login'})
.then(function(token) {
// Verify the token on the server.
});
});
